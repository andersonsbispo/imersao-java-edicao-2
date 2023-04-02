public enum API {
    IMDB_TOP_MOVIES("https://imdb-api.com/en/API/Top250Movies/k_15csmezz", new extratorConteudoIMDB()),
    IMDB_TOP_SERIES("https://imdb-api.com/en/API/Top250TVs/k_15csmezz", new extratorConteudoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new extratorConteudoNasa());

    private String url;
    private extratorConteudo extrator;

    API(String url, extratorConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public extratorConteudo getExtrator() {
        return extrator;
    }
}