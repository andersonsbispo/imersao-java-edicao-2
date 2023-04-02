import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception {
        //fazer uma conexão HTTP e buscar os top 250 conteudos

        API api = API.IMDB_TOP_MOVIES;

        String url = api.getUrl();
        //String url = "http://localhost:8080/linguagens";
        
        extratorConteudo extrator = api.getExtrator();
        
        var http = new clienteHttp();
        String json = http.buscaDados(url);
        
        var diretorio = new File("alura-stickers/figurinhas/");
        diretorio.mkdir();


        //exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new geradorDeFigurinhas();
        
        for (int i = 0; i < 10; i++) {
            
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "alura-stickers/figurinhas/" + conteudo.titulo() + ".png";
            
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
    }
}