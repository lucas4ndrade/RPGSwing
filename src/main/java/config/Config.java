package config;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import com.google.gson.Gson;

public class Config {
    private static String lang;
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

        lang = selectedLang;
        languageSelected = true;
        texts = newTexts;
    }

    public static String lang() {
        return lang;
    }

    public static Texts texts() {
        return texts;
    }

    public static Boolean languageSelected() {
        return languageSelected;
    }


}
