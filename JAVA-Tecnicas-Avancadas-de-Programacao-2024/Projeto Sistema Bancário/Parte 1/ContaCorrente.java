public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroAgencia, String nomeTitular) {
        super(numeroAgencia, nomeTitular, "Conta Corrente");
        System.out.println("Conta Corrente criada para " + nomeTitular +
                           "\nAgência: " + numeroAgencia +
                           "\nNúmero da Conta: " + this.getNumeroConta() +
                           "\nSaldo Inicial: R$ " + this.consultarSaldo());
    }
}