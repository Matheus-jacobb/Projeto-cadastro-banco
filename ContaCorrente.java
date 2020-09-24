public class ContaCorrente {
    
    private String cliente;
    private int numeroConta;
    private double saldo;
    private double limiteEspecial;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {

        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    public void depositar (double valor){
        this.saldo += valor;
        System.out.println("Deposito feito! ");
    }

    public void saque (double valor){
        double value = this.saldo;

        value -= valor;

        if (value< (0 - this.limiteEspecial))
            System.out.println("Saque maior que limite Especial (R$" + this.limiteEspecial + ")");
        else{
            this.saldo -= valor;
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente [cliente=" + cliente + ", limiteEspecial=" + limiteEspecial + ", numeroConta="
                + numeroConta + ", saldo=" + saldo + "]";
    }
}