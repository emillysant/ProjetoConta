package repositorios;

import entidades.Conta;

public class RepositorioConta {
    private Conta[] listaConta;
    private int tamanhoAtual = -1;

    RepositorioConta(){
        listaConta = new Conta[100];
    }

    public void incluir(Conta conta){
        tamanhoAtual++;
        listaConta[tamanhoAtual] = conta;
    }
    public Conta buscar(int agencia, long nummero){
        for(Conta conta: listaConta){
            if(conta != null && (conta.getNumeroAgencia() == agencia || conta.getNumeroConta() == nummero )){
                return conta;
            }
        }
        return null;
    }
    public Conta[] consultarTodos(){
        Conta[] listaRetorno = new Conta[tamanhoAtual+1];
        for(int i=0; i < listaRetorno.length; i++){
            listaRetorno[i] = listaConta[i];
        }
        return listaRetorno;
    }
}
