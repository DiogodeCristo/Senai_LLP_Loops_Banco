public abstract class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String titular;

    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    // Getters
    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }
    public String getTitular() { return titular; }
}

public class ContaCorrente extends ContaBancaria {
    private double taxaManutencao;

    public ContaCorrente(String numeroConta, String titular, double taxaManutencao) {
        super(numeroConta, titular);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + taxaManutencao;
        return super.sacar(valorComTaxa);
    }
}

public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, String titular, double taxaRendimento) {
        super(numeroConta, titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento;
        depositar(rendimento);
    }
}
