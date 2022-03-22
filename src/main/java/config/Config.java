package config;

public class Config {
    private String lang;
    private static Config instancia;

    private Config() {
    }

    public static Config getInstance() {
        if(instancia == null) {
            instancia = new Config();
        }

        return instancia;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


}
