public class TesteBanco {
    public static void main(String[] args) {
        
        // Criação de contas
        ContaCorrente cc = new ContaCorrente(101, 1001, 5000, "João");
        ContaPoupanca cp = new ContaPoupanca(102, 1002, 3000, "Maria");

        // Criação de Seguro de Vida
        SeguroDeVida seguro = new SeguroDeVida();
        
        // Criando o Calculador de Imposto
        CalculadorImposto calculador = new CalculadorImposto();

        // Teste de Depósito
        cc.depositar(500);
        cp.depositar(1000);
        System.out.println("\nDepósito realizado:");
        System.out.println("João depositou R$500. Saldo atual: R$ " + cc.getSaldo());
        System.out.println("Maria depositou R$1000. Saldo atual: R$ " + cp.getSaldo());

        // Teste de Saque
        cc.sacar(200);
        cp.sacar(500);
        System.out.println("\nSaque realizado:");
        System.out.println("João sacou R$200 (com taxa de R$0.20). Saldo atual: R$ " + cc.getSaldo());
        System.out.println("Maria sacou R$500. Saldo atual: R$ " + cp.getSaldo());

        // Teste de Transferência
        cc.transferir(cp, 100);
        System.out.println("\nTransferência realizada:");
        System.out.println("João transferiu R$100 para Maria.");
        System.out.println("Saldo de João: R$ " + cc.getSaldo());
        System.out.println("Saldo de Maria: R$ " + cp.getSaldo());

        // Teste de saque maior que o saldo
        boolean saqueMaiorQueSaldo = cc.sacar(10000);
        System.out.println("\nTentativa de saque maior que o saldo:");
        System.out.println("João tentou sacar R$10000. Resultado: " + saqueMaiorQueSaldo + ". Saldo atual: R$ " + cc.getSaldo());
        
        // Teste de transferência maior que o saldo
        boolean transferenciaMaiorQueSaldo = cc.transferir(cp, 10000);
        System.out.println("\nTentativa de transferência maior que o saldo:");
        System.out.println("João tentou transferir R$10000 para Maria. Resultado: " + transferenciaMaiorQueSaldo);
        System.out.println("Saldo de João: R$ " + cc.getSaldo());
        System.out.println("Saldo de Maria: R$ " + cp.getSaldo());

        // Registrando impostos das contas correntes e seguro de vida
        calculador.registrar(cc); // Conta Corrente de João é tributável
        calculador.registrar(seguro); // Seguro de vida também é tributável
        
        // Exibindo saldo das contas e total de impostos arrecadados
        System.out.println("\nRelatório de Impostos:");
        System.out.println("Saldo da Conta Corrente de João: R$ " + cc.getSaldo());
        System.out.println("Saldo da Conta Poupança de Maria: R$ " + cp.getSaldo());
        System.out.println("Imposto sobre a Conta Corrente de João: R$ " + cc.calcularImposto());
        System.out.println("Imposto sobre o Seguro de Vida: R$ " + seguro.calcularImposto());

        // Total de impostos arrecadados
        System.out.println("\nValor total de impostos arrecadados: R$ " + calculador.getTotalImposto());

        // Exibindo quantidade total de contas criadas
        System.out.println("\nQuantidade total de contas criadas: " + Conta.getQuantidadeContas());
    }
}
