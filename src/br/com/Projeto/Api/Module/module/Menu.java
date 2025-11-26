package br.com.Projeto.Api.Module.module;


import br.com.Projeto.Api.Module.service.ConversoGson;
import br.com.Projeto.Api.Module.service.ServiceFiles;
import br.com.Projeto.Api.Module.service.ServiceHttp;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void menu()  {
        // ---------- INSTÂNCIAS ----------
        ServiceHttp service = new ServiceHttp();
        ConversoGson converter = new ConversoGson();
        ServiceFiles serviceFiles = new ServiceFiles();


        Scanner sc = new Scanner(System.in);
        String busca = "";

        // ----------- loop Principal  -----------

        while (!busca.equals("sair")) {
            System.out.println("Digite o Cep para obter os dados: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            // Monta URL da API ViaCEP
            String endereco = "https://viacep.com.br/ws/" + busca + "/json/";

            try {
                // Consulta API e retorna JSON bruto
                String json = service.consultar(endereco);


                System.out.println("==========");
                System.out.println("Consulta realizada!");
                System.out.println(json);
                System.out.println("==========");


                // Converte JSON → Objeto (Record FormatarGson)
                FormatarGson dados = converter.converter(json);

                // Mostra objeto convertido
                System.out.println(dados);

                System.out.println("Gerando Arquivo em Json.....");
                // Salva o arquivo no disco
                serviceFiles.gerarArquivo(dados);



            }catch (Exception  e ){
                System.out.println("Erro ao consultar");
                System.out.println("Detalhe: " + e.getMessage());
            }


        }




    }

}
