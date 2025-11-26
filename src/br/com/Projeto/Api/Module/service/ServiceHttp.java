package br.com.Projeto.Api.Module.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ServiceHttp {
    private final HttpClient client;

    public ServiceHttp() {
        this.client = HttpClient.newHttpClient();
    }


    public String consultar(String endereco)   {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .GET()
                    .build();

        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
        catch (IOException |InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
