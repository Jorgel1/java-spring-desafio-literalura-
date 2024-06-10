package br.com.jorge.literalura.service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

}

//public class BookService {
//    public String obterDados(String endereco) throws IOException {
//        // Requisição
//        HttpClient client = HttpClient.newBuilder()
//                .followRedirects(HttpClient.Redirect.ALWAYS)
//                .build();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(endereco))
//                .build();
//        // Resposta
//        HttpResponse<String> response = null;
//        try {
//            response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        String json = response.body();
//
//        FileWriter escrita = new FileWriter("livro.txt");
//        escrita.write(json);
//        escrita.close();
//
//        return json;
//    }
//
//}
