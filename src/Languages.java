public enum Languages {
    ESP,
    ENG,
    GER
}

class Translation {
    private String selectedLanguage;
    private String executionTime;
    private String seconds;
    private String name;
    private String result;
    private String totalExecutionTime;
    private String errorFinder;
    private String CHECK="[\u001B[32m\u2713\u001B[0m] ";
    private String CROSS="[\u001B[31mX\u001B[0m] \u001b[34m";
    private String starTotalExecutionTime="\n[\u001b[34m*\u001b[0m] ";

    public Translation(Languages language) {
        switch (language) {
            case ESP:
                setSpanish();
                break;
            case ENG:
                setEnglish();
                break;
            case GER:
                setGerman();
                break;
            default:
                setEnglish();
        }
    }

    private void setSpanish(){
        selectedLanguage="Idioma Seleccionado: Español";
        executionTime=" \u001b[34mTiempo de ejecución:\u001b[0m\t\t";
        seconds=" segundos";
        name="\n\t\t[\u001b[33mnombre\u001b[0m]\t\t\t\t";
        result="\n\t\t[\u001b[33mresultado\u001b[0m]\t\t\t\t";
        totalExecutionTime="Tiempo de ejecución total:\t\t";
        errorFinder="\t\t\tEl error ha ocurrido aquí";

    }
    private void setEnglish(){
        selectedLanguage="Selected language: English";
        executionTime=" \u001b[34mRuntime:\u001b[0m\t\t\t\t\t";
        seconds=" seconds";
        name="\n\t\t[\u001b[33mname\u001b[0m]\t\t\t\t\t";
        result="\n\t\t[\u001b[33mresult\u001b[0m]\t\t\t\t";
        totalExecutionTime="Total execution time:\t\t";
        errorFinder="\t\t\tAn error occurred here";
    }
    private void setGerman(){
        selectedLanguage="Sprache ausgewählt: Deutsch";
        executionTime=" \u001b[34mLaufzeit:\u001b[0m\t\t\t\t\t";
        seconds=" Sekunden";
        name="\n\t\t[\u001b[33mName\u001b[0m]\t\t\t\t\t";
        result="\n\t\t[\u001b[33mErgebnis\u001b[0m]\t\t\t\t";
        totalExecutionTime="Gesamtlaufzeit:\t\t\t\t";
        errorFinder="\t\t\tEin Fehler ist hier aufgetreten";

    }
    public String getStarTotalExecutionTime(){
        return starTotalExecutionTime;
    }
    public String getCheck(){
        return CHECK;
    }
    public String getCross(){
        return CROSS;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public String getSeconds() {
        return seconds;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public String getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public String getErrorFinder() {
        return errorFinder;
    }

}
