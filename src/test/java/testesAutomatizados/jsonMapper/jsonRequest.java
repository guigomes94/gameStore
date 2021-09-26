package testesAutomatizados.jsonMapper;

public class jsonRequest {

    public String jsonToken(){
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append(" \"email\" : \"admin@admin.com\", ");
        sb.append(" \"password\" : \"admin\"");
        sb.append(" }");

        return sb.toString();
    }

    public String jsonSucess(){
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append(" \"title\" : \"Grand Theft Auto IV\",");
        sb.append(" \"description\" : \"Grand Theft Auto IV e um jogo eletronico de acao-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games\",");
        sb.append(" \"imageURL\" : \"https://upload.wikimedia.org/wikipedia/pt/9/91/Grand_Theft_Auto_IV_capa.png\",");
        sb.append(" \"costPrice\" : \"90.0\",");
        sb.append(" \"sellPrice\" : \"120.0\",");
        sb.append(" \"quantity\" : \"16\"");
        sb.append(" }");

        return sb.toString();
    }

}
