package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class postRequest {

    public static final String URL_POST = "https://httpbin.org/forms/post";
    public static String File_JSON = "/c/Users/Sandelelo Muteka/Desktop/Prova de TIC ANTÓNIO PEDRO ELIAS MUTEKA Nº4/HTTPExample/pedido.json";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient Client = HttpClient.newHttpClient();

        // Criar a Requisição

        HttpRequest request = HttpRequest.newBuilder()
               // .POST(HttpRequest.BodyPublishers.ofFile(Path.of(File_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        // enviando Solicitação

        Client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

}
