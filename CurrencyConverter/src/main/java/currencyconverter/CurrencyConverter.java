package currencyconverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    private static final List<String> historicoConversoes = new ArrayList<>();
    private static final Map<Integer, String> moedasDisponiveis = Map.of(
        1, "USD-ARS", 2, "ARS-USD", 3, "USD-BRL", 4, "BRL-USD",
        5, "USD-COP", 6, "COP-USD", 7, "USD-EUR", 8, "EUR-USD"
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        float valor;
        Requisicao requisicao = new Requisicao();

        while (opcao != 10) {
            System.out.println("-------------------------------------");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Dólar => Euro");
            System.out.println("8) Euro => Dólar");
            System.out.println("9) Exibir Histórico de Conversões");
            System.out.println("10) Sair");
            System.out.println("-------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = sc.nextFloat();
                    String moedaEscolhida = moedasDisponiveis.get(opcao);
                    String[] moedas = moedaEscolhida.split("-");
                    requisicao.req(valor, moedas[0], moedas[1]);

                    // Adiciona ao histórico de conversões
                    registrarHistorico(valor, moedas[0], moedas[1]);
                    break;  

                case 9:
                    exibirHistorico();
                    break;

                case 10:
                    System.out.println("\nPrograma finalizado com sucesso!");
                    break;

                default:
                    System.out.println("\nOpção invalida, insira uma opção valida\n");
            }
        }
    }

    // Método para registrar o histórico
    private static void registrarHistorico(float valor, String moedaOrigem, String moedaDestino) {
        // Obtém o timestamp atual
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String log = String.format("Data: %s - Valor: %.2f [%s] => [%s]", timestamp, valor, moedaOrigem, moedaDestino);

        // Limita o histórico a 5 entradas
        if (historicoConversoes.size() >= 5) {
            historicoConversoes.remove(0);
        }
        historicoConversoes.add(log);
    }

    // Método para exibir o histórico de conversões
    private static void exibirHistorico() {
        if (historicoConversoes.isEmpty()) {
            System.out.println("\nHistórico de Conversões vazio.\n");
        } else {
            System.out.println("\nHistórico de Conversões:");
            for (String registro : historicoConversoes) {
                System.out.println(registro);
            }
        }
    }
}
