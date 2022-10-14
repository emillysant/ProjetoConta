package entidades;

public class ContaPoupanca extends Conta {
    private double taxaBonus;
    public ContaPoupanca( long numeroConta, int numeroAgencia, Correntista correntista, double taxaBonus) {
        super( numeroAgencia, numeroConta, correntista);
        this.taxaBonus = taxaBonus;
    }

    @Override
    public void creditar(double valor){
        saldo = saldo + valor + taxaBonus;
    }
    @Override
    public void debitar(double valor){
        saldo = saldo - valor + taxaBonus;
    }
}
