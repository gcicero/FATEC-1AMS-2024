public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, String nomeTitular) {
        super(numeroAgencia, numeroConta, "Conta Corrente", saldo, nomeTitular);
        System.out.println("Conta Corrente criada para " + nomeTitular +
                           "\nAgência: " + numeroAgencia +
                           "\nNúmero da Conta: " + getNumeroConta());
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + 0.20;
        return super.sacar(valorTotal);
    }


    @Override
    public void depositar(double valor) {
        if (valor > 0) {
        	this.saldo += valor;
        }
    }
}
