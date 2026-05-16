package br.com.mn.TabelaFip.principal;

import br.com.mn.TabelaFip.model.Dados;
import br.com.mn.TabelaFip.model.Modelos;
import br.com.mn.TabelaFip.model.Veiculo;
import br.com.mn.TabelaFip.service.ConsumoApi;
import br.com.mn.TabelaFip.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();

    public void exibeMenu() {
        var menu = """
            ***  OPÇÕES  ***
            Carro
            Moto
            Caminhão
            
            Digite uma das opções para consultar:
            """;

        System.out.println(menu);
        var opcao = leitura.nextLine();

        String endereco;
        String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::println);

        System.out.println("Informe o código da marca para consumo");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";

        json = consumoApi.obterDados(endereco);
        var modeloLista = converteDados.obterDados(json, Modelos.class);
        System.out.println();
        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
            .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
            .toList();

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumoApi.obterDados(endereco);
        List<Dados> anos = converteDados.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano.");
        veiculos.forEach(System.out::println);
    }
}
