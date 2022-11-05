package integracao.viacep.control;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import integracao.viacep.model.ObjetoResposta;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muril
 */
public class ApiCep {
    
    public ObjetoResposta buscaCep(String cep) throws IOException{
        cep = cep.replace("-","");
        cep = cep.replace(".","");
        cep = cep.trim();
        
        String url = "https://viacep.com.br/ws/"+cep+"/json/";
        
        System.out.println("URL: "+url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()                
                .url(url)
                .method("GET", null)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ObjectMapper mapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        
        
        ResponseBody responseBody = client.newCall(request).execute().body();
        
        System.out.println("response body");
        System.out.println(responseBody.toString());
        
        ObjetoResposta endereco = objectMapper.readValue(responseBody.string(), ObjetoResposta.class);
        return endereco;
                                               
    }
}
