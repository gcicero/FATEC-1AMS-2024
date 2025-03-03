public class TesteBanco {
    public static void main(String[] args) {
        
        ContaCorrente cc = new ContaCorrente(101, "João");
        ContaPoupanca cp = new ContaPoupanca(102, "Maria");

        //Depósito
        cc.depositar(500);
        cp.depositar(1000);
        System.out.println("\nDepósito realizado:");
        System.out.println("João depositou R$500. Saldo atual: R$ " + cc.consultarSaldo());
        System.out.println("Maria depositou R$1000. Saldo atual: R$ " + cp.consultarSaldo());

        //Saque
        cc.sacar(200);
        cp.sacar(500);
        System.out.println("\nSaque realizado:");
        System.out.println("João sacou R$200. Saldo atual: R$ " + cc.consultarSaldo());
        System.out.println("Maria sacou R$500. Saldo atual: R$ " + cp.consultarSaldo());

        //Transferência
        cc.transferir(cp, 100);
        System.out.println("\nTransferência realizada:");
        System.out.println("João transferiu R$100 para Maria.");
        System.out.println("Saldo de João: R$ " + cc.consultarSaldo());
        System.out.println("Saldo de Maria: R$ " + cp.consultarSaldo());
    }
}
