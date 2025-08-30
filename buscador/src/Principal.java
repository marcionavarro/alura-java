package src;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o numero de CEP para consulta:");
        var cep = sc.nextLine();

        ConsultaCep consultaCep = new ConsultaCep();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep); //01001000
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador  = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}
