public class ContaPoupanca extends Conta {

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
