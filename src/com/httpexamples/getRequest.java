package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class getRequest {

    //public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    public static final String URL_GET = "https://jsonplaceholder.typicode.com/comments";

    public static void main(String[] args) throws IOException, InterruptedException{

        HttpClient Client = HttpClient.newHttpClient();

         // Criar a Requisição

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        // enviando Solicitação

        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());

        // imprimir o conteudo recebido

        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
