package mediadores;

import entidades.Conta;
import entidades.Correntista;
import repositorios.FabricaRepositorio;
import repositorios.RepositorioConta;
import repositorios.RepositorioCorrentista;

public class ContaMediador {
    public static final int SUCESSO = 0;
    public static final int NUMERO_CONTA_INVALIDO = 1;
	public static final int NUMERO_AGENCIA_INVALIDA = 2;
    public static final int CORRENTISTA_INEXISTENTE = 3;
    public static final int VALOR_INVALIDO = 4;
    public static final int CONTA_INEXISTENTE = 5;
    public static final int SALDO_INSUFICIENTE = 6;
    private RepositorioCorrentista repositorioCorrentista;
    private RepositorioConta repositorioConta;

    public ContaMediador () {
        repositorioConta = FabricaRepositorio.getRepositorioConta();
        repositorioCorrentista = FabricaRepositorio.getRepositorioCorrentista();
    }

    public int incluir(Conta conta, int cpfCorrentista){
        if(conta.getNumeroConta() <= 0){
            return NUMERO_CONTA_INVALIDO;
        } else if(conta.getNumeroAgencia() <= 0 ){
            return NUMERO_AGENCIA_INVALIDA;
        } else {
            Correntista correntista = repositorioCorrentista.buscarPorCPF(cpfCorrentista);
            if (correntista == null) {
                return CORRENTISTA_INEXISTENTE;
            } else {
                conta.setCorrentista(correntista);
            }
        }
        repositorioConta.incluir(conta);
        return SUCESSO;
    }
    public int debitar(int numeroAgencia,long numeroConta, double valor){
        if(valor < 0) {
            return VALOR_INVALIDO;
        } else {
            Conta conta = repositorioConta.buscar(numeroAgencia, numeroConta);
            if (conta == null){
                return CONTA_INEXISTENTE;
            } else if(conta.getSaldo() < valor) {
                return SALDO_INSUFICIENTE;
            } else {
                conta.debitar(valor);
                return SUCESSO;
            }
        }
    }
    public int creditar(int numeroAgencia,long numeroConta, double valor){
        if(valor < 0) {
            return VALOR_INVALIDO;
        } else {
            Conta conta = repositorioConta.buscar(numeroAgencia, numeroConta);
            if (conta == null){
                return CONTA_INEXISTENTE;
            } else {
                conta.creditar(valor);
                return SUCESSO;
            }
        }
    }
    public Conta[] consultarOrdenadoPorSaldo(){
        Conta[] conta = repositorioConta.consultarTodos();
        Conta aux = null;
        for (int i =0 ; i < conta.length; i++){
            for (int k =i ; k<conta.length; k++){
                double saldo1 = conta[i].getSaldo();
                double saldo2 = conta[k].getSaldo();
                if (saldo1 > saldo2){
                    aux = conta[i];
                    conta[i] = conta[k];
                    conta[k] = aux;
                }
            }
        }
        return conta;
    }
}
