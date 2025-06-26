public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando contas
        banco.abrirConta(new ContaCorrente("123", "João", 5.0));
        banco.abrirConta(new ContaPoupanca("456", "Maria", 0.05));

        // Operações
        banco.realizarOperacao("123", "depositar", 1000);
        banco.realizarOperacao("123", "sacar", 200);

        banco.realizarOperacao("456", "depositar", 500);
        ((ContaPoupanca) banco.buscarConta("456")).aplicarRendimento();

        // Listagem final
        banco.listarContas();
    }
}
