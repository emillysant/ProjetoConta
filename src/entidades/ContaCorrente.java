package entidades;

public class ContaCorrente extends Conta{
    private double tarifa;
    public ContaCorrente(long numeroConta, int numeroAgencia, Correntista correntista, double tarifa){
        super(numeroAgencia, numeroConta,  correntista );
        this.tarifa = tarifa;
    }

    @Override
    public void debitar(double valor){
        saldo = saldo - valor - tarifa;
    }
    @Override
    public void creditar(double valor){
        saldo = saldo + valor - tarifa; 
    }
}
