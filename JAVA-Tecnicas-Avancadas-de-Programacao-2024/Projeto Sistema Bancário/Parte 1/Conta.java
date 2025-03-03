public abstract class Conta {
	private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private String nomeTitular;
    private String tipoConta;
    private static int quantidadeContas = 0;

    public Conta(int numeroAgencia, String nomeTitular, String tipoConta) {
        this.numeroAgencia = numeroAgencia;
        this.nomeTitular = nomeTitular;
        this.tipoConta = tipoConta;
        this.numeroConta = ++quantidadeContas;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
}
