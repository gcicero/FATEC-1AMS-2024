public class CalculadorImposto {
    private double totalImposto = 0;

    public void registrar(Tributavel t) {
        double imposto = t.calcularImposto();
        this.totalImposto += imposto;
    }

    public double getTotalImposto() {
        return totalImposto;
    }
}