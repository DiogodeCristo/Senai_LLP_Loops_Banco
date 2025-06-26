import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void abrirConta(ContaBancaria novaConta) {
        contas.add(novaConta);
    }

    public ContaBancaria buscarConta(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarOperacao(String numeroConta, String tipoOperacao, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            switch (tipoOperacao.toLowerCase()) {
                case "depositar" -> conta.depositar(valor);
                case "sacar" -> {
                    boolean sucesso = conta.sacar(valor);
                    System.out.println(sucesso ? "Saque realizado!" : "Saldo insuficiente!");
                }
                default -> System.out.println("Operação inválida!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void listarContas() {
        for (ContaBancaria conta : contas) {
            System.out.printf("Conta: %s | Titular: %s | Saldo: R$%.2f%n",
                conta.getNumeroConta(), conta.getTitular(), conta.getSaldo());
        }
    }
}
