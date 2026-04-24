package br.com.mnfullstack.screenmatch.principal;

import br.com.mnfullstack.screenmatch.model.DadosEpisodio;
import br.com.mnfullstack.screenmatch.model.DadosSerie;
import br.com.mnfullstack.screenmatch.model.DadosTemporada;
import br.com.mnfullstack.screenmatch.service.ConsumoApi;
import br.com.mnfullstack.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para pesquisar");

        var nomeSerie = leitura.nextLine();
        String urlStreaming = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumoApi.obterDados(urlStreaming);

        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

       /* for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }*/

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
