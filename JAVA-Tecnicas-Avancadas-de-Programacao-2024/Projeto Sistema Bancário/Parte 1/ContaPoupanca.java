public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroAgencia, String nomeTitular) {
        super(numeroAgencia, nomeTitular, "Conta Poupança");
        System.out.println("Conta Poupança criada para " + nomeTitular +
                           "\nAgência: " + numeroAgencia +
                           "\nNúmero da Conta: " + this.getNumeroConta() +
                           "\nSaldo Inicial: R$ " + this.consultarSaldo());
    }
}