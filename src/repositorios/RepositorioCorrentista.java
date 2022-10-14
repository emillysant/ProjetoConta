package repositorios;

import entidades.Correntista;

public class RepositorioCorrentista {
    private Correntista[] listaCorrentista;
    private int tamanhoAtual = -1;
    RepositorioCorrentista(){
        listaCorrentista = new Correntista[100];
    }

    public void incluir(Correntista correntista){
        tamanhoAtual++;
        listaCorrentista[tamanhoAtual] = correntista;
    }

    public Correntista buscarPorCPF(long cpf){
        for (Correntista correntista : listaCorrentista) {
            if(correntista != null && correntista.getCpf() == cpf){
                return correntista;
            }
        }
        return null;
    }

    public Correntista[] consultarTodos(){
        Correntista[] listaRetorno = new Correntista[tamanhoAtual + 1];
        for(int i=0; i < listaRetorno.length; i++){
            listaRetorno[i] = listaCorrentista[i];
        }
        return listaRetorno;
    }
}
