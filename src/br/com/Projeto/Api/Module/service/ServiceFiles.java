package br.com.Projeto.Api.Module.service;

import br.com.Projeto.Api.Module.module.FormatarGson;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServiceFiles extends ConversoGson {


    public void gerarArquivo(FormatarGson endereco) throws IOException {
        File file = new File( endereco.cep() + ".json");

        if (file.exists()) {
            System.out.println("[AVISO] O arquivo " + file.getName() + " já existe. Não será criado novamente.");
            return;
        }

        try(FileWriter fw = new FileWriter(file)) {
            fw.write(gson.toJson(endereco));
            fw.close();
            System.out.println("[Ok] Arquivo " + file.getName() + " gerado com sucesso anteriormente.");

        }



    }
}
