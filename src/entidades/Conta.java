package entidades;

public abstract class Conta {
    private int numeroAgencia;
    private long numeroConta;
    private Correntista correntista;
    protected double saldo;

    public Conta(int numeroAgencia, long numeroConta, Correntista correntista){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.correntista = correntista;
        this.saldo = 0.0;
    }

    public abstract void debitar(double valor);
    public abstract void creditar(double valor);

 
    public int getNumeroAgencia(){
        return numeroAgencia;
    }

    public long getNumeroConta() {
        return numeroConta;
    }
    public Correntista getCorrentista(){
        return correntista;
    }
    // Não faz sentido mudar o nunero e agencia da conta //
    // public void setNumeroConta(Long numeroConta) {
    //     this.numeroConta = numeroConta;
    // }
    // public void setNumeroAgencia(int numeroAgencia) {
    //     this.numeroAgencia = numeroAgencia;
    // }
    public void setCorrentista(Correntista correntista){
        this.correntista = correntista;
    }
    public double getSaldo() {
        return saldo;
    }

}
