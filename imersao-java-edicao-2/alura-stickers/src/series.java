import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class series {
    public static void main(String[] args) throws Exception {
        /*  - fazer uma conexão HTTP e buscar os top 250 series
            - pegar só os dados que interessam (titulo, poster, classificação)
            - exibir e manipular os dados
        */

        String url = "https://imdb-api.com/en/API/Top250TVs/k_15csmezz";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeSeries = parser.parse(body);
        

        for (int i = 0; i <listaDeSeries.size(); i++) {
            Map<String, String> serie = listaDeSeries.get(i);

            System.out.print("\u001b[1m\u001b[32mTítulo:\u001b[m ");
            System.out.println("\u001b[1m" + serie.get("title") + "\u001b[m");

            System.out.print("\u001b[1m\u001b[31mAvaliação:\u001b[m ");
            System.out.println("📺📺📺📺📺 " + "\u001b[1m("+ serie.get("imDbRating") +")\u001b[0m");

            System.out.print("\u001b[1m\u001b[36mPoster:\u001b[m ");
            System.out.println("\u001b[1m" + serie.get("image") + "\u001b[0m");


            System.out.println();
        }
    }
}