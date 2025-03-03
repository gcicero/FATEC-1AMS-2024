public class TesteBanco {
    public static void main(String[] args) {
        
        ContaCorrente cc = new ContaCorrente(101, 1001, 500, "João");
        ContaPoupanca cp = new ContaPoupanca(102, 1002, 1000, "Maria");

        // Depósito
        cc.depositar(500);
        cp.depositar(1000);
        System.out.println("\nDepósito realizado:");
        System.out.println("João depositou R$500. Saldo atual: R$ " + cc.getSaldo());
        System.out.println("Maria depositou R$1000. Saldo atual: R$ " + cp.getSaldo());

        // Saque
        cc.sacar(200);
        cp.sacar(500);
        System.out.println("\nSaque realizado:");
        System.out.println("João sacou R$200. Saldo atual: R$ " + cc.getSaldo());
        System.out.println("Maria sacou R$500. Saldo atual: R$ " + cp.getSaldo());

        // Transferência
        cc.transferir(cp, 100);
        System.out.println("\nTransferência realizada:");
        System.out.println("João transferiu R$100 para Maria.");
        System.out.println("Saldo de João: R$ " + cc.getSaldo());
        System.out.println("Saldo de Maria: R$ " + cp.getSaldo());
        
        // Teste de saque maior que o saldo
        boolean saqueMaiorQueSaldo = cc.sacar(1000);
        System.out.println("\nTentativa de saque maior que o saldo:");
        System.out.println("João tentou sacar R$1000. Resultado: " + saqueMaiorQueSaldo + ". Saldo atual: R$ " + cc.getSaldo());
        
        // Teste de transferência maior que o saldo
        boolean transferenciaMaiorQueSaldo = cc.transferir(cp, 1000);
        System.out.println("\nTentativa de transferência maior que o saldo:");
        System.out.println("João tentou transferir R$1000 para Maria. Resultado: " + transferenciaMaiorQueSaldo);
        System.out.println("Saldo de João: R$ " + cc.getSaldo());
        System.out.println("Saldo de Maria: R$ " + cp.getSaldo());

        System.out.println("\nQuantidade de contas criadas: " + Conta.getQuantidadeContas());
    }
}
