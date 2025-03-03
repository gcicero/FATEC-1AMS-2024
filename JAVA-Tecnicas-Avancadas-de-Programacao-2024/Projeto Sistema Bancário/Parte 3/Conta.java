public abstract class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private String tipoConta;
    protected double saldo;
    private String nomeTitular;
    private static int quantidadeContas = 0;

    public Conta(int numeroAgencia, int numeroConta, String tipoConta, double saldo, String nomeTitular) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.nomeTitular = nomeTitular;
        ++quantidadeContas;
    }

    public abstract void depositar(double valor);

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        }
        return false;
    }
    
    public int getNumeroAgencia() {
        return numeroAgencia;
    }
    
    public void setNumeroAgencia(int numeroAgencia) {
    	this.numeroAgencia = numeroAgencia;
    }
    
    public int getNumeroConta() {
        return numeroConta;
    }
    
    public void setNumeroConta (int numeroConta) {
    	this.numeroConta = numeroConta;
    }
    
    public String getTipoConta() {
        return tipoConta;
    }
    
    public void setTipoConta(String tipoConta) {
    	this.tipoConta = tipoConta;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
    public void setNomeTitular(String nomeTitular) {
    	this.nomeTitular = nomeTitular;
    }
    
    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
}
