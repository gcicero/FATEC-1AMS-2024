public class TesteBanco {
    public static void main(String[] args) {
        // Criação de contas
        ContaCorrente cc = new ContaCorrente(101, 1001, 300, "João");
        ContaPoupanca cp = new ContaPoupanca(102, 1002, 1000, "Maria");

        // Criação de Seguro de Vida
        SeguroDeVida seguro = new SeguroDeVida();

        // Criando o Calculador de Imposto
        CalculadorImposto calculador = new CalculadorImposto();

        // Teste de depósito
        cc.depositar(100);
        cp.depositar(200); 
        System.out.println("\nDepósito realizado:");
        System.out.println("João depositou R$100. Saldo atual: R$ " + cc.getSaldo());
        System.out.println("Maria depositou R$200. Saldo atual: R$ " + cp.getSaldo());

        // Testes de operações bem-sucedidas
        System.out.println("\nTestes de operações bem-sucedidas:");
        try {
            cc.sacar(100);
            System.out.println("João sacou R$100 (com taxa de R$0,20). Saldo atual: R$ " + cc.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Erro ao sacar de João: " + e.getMessage());
        }

        try {
            cp.sacar(200);
            System.out.println("Maria sacou R$200. Saldo atual: R$ " + cp.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Erro ao sacar de Maria: " + e.getMessage());
        }

        try {
            cc.transferir(cp, 60);
            System.out.println("Transferência de R$60 realizada com sucesso de João para Maria.");
            System.out.println("Saldo de João: R$ " + cc.getSaldo());
            System.out.println("Saldo de Maria: R$ " + cp.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Erro na transferência de João para Maria: " + e.getMessage());
        }

        // Testes de operações com erro
        System.out.println("\nTestes de operações com erro:");
        try {
            cc.sacar(350); // Tentativa de saque acima do limite de R$300
            System.out.println("João sacou R$350. Saldo atual: R$ " + cc.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de saque com erro: " + e.getMessage());
        }

        try {
            cc.sacar(25); // Tentativa de saque que não é múltiplo de R$20
            System.out.println("João sacou R$25. Saldo atual: R$ " + cc.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de saque com erro: " + e.getMessage());
        }

        try {
            cc.sacar(300); // Tentativa de saque com saldo insuficiente
            System.out.println("João sacou R$300. Saldo atual: R$ " + cc.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de saque com erro: " + e.getMessage());
        }

        try {
            cc.transferir(cp, 280); // Transferência com saldo insuficiente
            System.out.println("Transferência de R$280 realizada de João para Maria.");
            System.out.println("Saldo de João: R$ " + cc.getSaldo());
            System.out.println("Saldo de Maria: R$ " + cp.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de transferência com erro: " + e.getMessage());
        }

        try {
            cc.transferir(cp, 350); // Transferência acima do limite de saque de R$300
            System.out.println("Transferência de R$350 realizada de João para Maria.");
            System.out.println("Saldo de João: R$ " + cc.getSaldo());
            System.out.println("Saldo de Maria: R$ " + cp.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de transferência com erro: " + e.getMessage());
        }

        try {
            cc.transferir(cp, 55); // Transferência com valor que não é múltiplo de R$20
            System.out.println("Transferência de R$55 realizada de João para Maria.");
            System.out.println("Saldo de João: R$ " + cc.getSaldo());
            System.out.println("Saldo de Maria: R$ " + cp.getSaldo());
        } catch (SaldoInsuficienteException | LimiteExcedidoException | ValorNaoMultiploException e) {
            System.out.println("Tentativa de transferência com erro: " + e.getMessage());
        }

        // Registrando impostos das contas correntes e seguro de vida
        calculador.registrar(cc);
        calculador.registrar(seguro);

        // Exibindo saldo das contas e total de impostos arrecadados
        System.out.println("\nRelatório de Impostos:");
        System.out.println("Saldo da Conta Corrente de João: R$ " + cc.getSaldo());
        System.out.println("Saldo da Conta Poupança de Maria: R$ " + cp.getSaldo());
        System.out.println("Imposto sobre a Conta Corrente de João: R$ " + cc.calcularImposto());
        System.out.println("Imposto sobre o Seguro de Vida: R$ " + seguro.calcularImposto());
        System.out.println("\nValor total de impostos arrecadados: R$ " + calculador.getTotalImposto());

        // Exibindo quantidade total de contas criadas
        System.out.println("\nQuantidade total de contas criadas: " + Conta.getQuantidadeContas());
    }
}
