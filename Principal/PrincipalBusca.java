package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Classes.BuscaCEP;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
    Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<BuscaCEP> buscaCEPs = new ArrayList<>();
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
             .create();

     while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um CEP para: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://viacep.com.br/ws/" + busca.replace("-", "") + "/json/";
            System.out.println(endereco);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                BuscaCEP buscandoCEP = gson.fromJson(json, BuscaCEP.class);
                System.out.println(buscandoCEP);
                System.out.println("Titulo já convertido");

                buscaCEPs.add(buscandoCEP);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            }

        }
        System.out.println(buscaCEPs);

        FileWriter escrita = new FileWriter("buscaCEP.json");
        escrita.write(gson.toJson(buscaCEPs));
        escrita.close();
        System.out.println("O programa finalizou corretamente!");

    }
}
