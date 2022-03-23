package config;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.nio.file.Path;

import com.google.gson.Gson;

public class Config {
    private static Locale locale;
    private static Config instancia;
    private static Texts texts;
    private static boolean languageSelected;

    private Config() {
        texts = new Texts();
    }

    public static Config getInstance() {
        if(instancia == null) {
            instancia = new Config();
        }

        return instancia;
    }

    public void setLang(String selectedLang) throws IOException, URISyntaxException {        
        URI textFileURI = getClass().getResource("/i18n/texts_"+selectedLang+".json").toURI();
        Path textFilePath = Paths.get(textFileURI);
        String textJsonString = Files.readString(textFilePath);
    
        Gson gson = new Gson();
        Texts newTexts = gson.fromJson(textJsonString, Texts.class);

        locale = langToLocale(selectedLang);
        languageSelected = true;
        texts = newTexts;
    }

    private Locale langToLocale(String selectedLang) {
        Locale loc = Locale.getDefault();
        switch (selectedLang) {
            case "ptBR":
                loc = new Locale("pt", "BR");
                break;
            case "enUS":
                loc = Locale.US;
                break;
            case "esMX":
                loc = new Locale("es", "MX");
                break;
            default:
                break;
        }
        return loc;
    }

    public static Locale locale() {
        return locale;
    }

    public static Texts texts() {
        return texts;
    }

    public static Boolean languageSelected() {
        return languageSelected;
    }


}
