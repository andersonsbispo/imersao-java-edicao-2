import java.util.List;
import java.util.Map;

public class extratorConteudoIMDB implements extratorConteudo {

    public List<Conteudo> extraiConteudos(String json) {
        
        //pegar só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        return listaDeAtributos.stream().map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg")))
        .toList();
    }
}