package br.com.Projeto.Api.Module.service;

import br.com.Projeto.Api.Module.module.FormatarGson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversoGson {
    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public FormatarGson converter(String json) {
        return gson.fromJson(json, FormatarGson.class);
    }
}
