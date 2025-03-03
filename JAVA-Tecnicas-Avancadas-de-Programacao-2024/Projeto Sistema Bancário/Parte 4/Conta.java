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

    public void sacar(double valor) throws SaldoInsuficienteException, LimiteExcedidoException, ValorNaoMultiploException {
    	if (valor > 300) {
            throw new LimiteExcedidoException("Erro: O valor de saque excede o limite de R$300.");
        }
        if (valor % 20 != 0) {
            throw new ValorNaoMultiploException("Erro: O valor de saque deve ser múltiplo de R$20.");
        }
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente para realizar o saque.");
        }

        this.saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException, LimiteExcedidoException, ValorNaoMultiploException {
        this.sacar(valor);
        destino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
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

class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, String nomeTitular) {
        super(numeroAgencia, numeroConta, "Conta Corrente", saldo, nomeTitular);
        System.out.println("Conta Corrente criada para " + nomeTitular +
                           "\nAgência: " + numeroAgencia +
                           "\nNúmero da Conta: " + getNumeroConta());
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, LimiteExcedidoException, ValorNaoMultiploException {
    	
        super.sacar(valor);
        this.saldo -= 0.20;
        System.out.println("Taxa de R$0,20 aplicada");
    }


    @Override
    public void depositar(double valor) {
        if (valor > 0) {
        	this.saldo += valor;
        }
    }
    
    @Override
    public double calcularImposto() {
        return this.getSaldo() * 0.01;
    }
}

class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, String nomeTitular) {
        super(numeroAgencia, numeroConta, "Conta Poupança", saldo, nomeTitular);
        System.out.println("Conta Poupança criada para " + nomeTitular +
                           "\nAgência: " + numeroAgencia +
                           "\nNúmero da Conta: " + getNumeroConta());
    }
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
        	this.saldo += valor;
        }
    }
}

