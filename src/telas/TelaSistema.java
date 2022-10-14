package telas;

import java.util.Scanner;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import entidades.Correntista;
import mediadores.ContaMediador;
import mediadores.CorrentistaMediador;

public class TelaSistema {
    private final Scanner ENTRADA = new Scanner(System.in);
    private ContaMediador contaMediador;
    private CorrentistaMediador correntistaMediador;
    public TelaSistema(){
        correntistaMediador = new CorrentistaMediador();
        contaMediador = new ContaMediador();
    }
    public void executarTela(){
        boolean continua;
        do {
            continua = menuPrincipal();
        } while(continua);
    }

    private boolean menuPrincipal(){
        System.out.println("1- Incluir correntista");
		System.out.println("2- Incluir conta");
		System.out.println("3- Depositar");
		System.out.println("4- Creditar");
		System.out.println("5- Listar correntistas");
		System.out.println("6- Listar contas");
		System.out.println("7- Sair");
		int opcao = ENTRADA.nextInt();
		boolean ret = true;
		switch (opcao) { 
		case 1:
			incluirCorrentista();
			break;
		case 2:
			incluirConta();
			break;
		case 3:
			depositar();
			break;
		case 4:
			creditar();
			break;
		case 5:
			listarCorrentistas();
			break;
		case 6:
			listarContas();
			break;
		case 7:
			ret = false;
			break;
		}
		return ret;
    }

    private void incluirCorrentista(){
        System.out.println("Digite o cpf: ");
		int cpf = ENTRADA.nextInt();
		System.out.println("Digite o nome: ");
		String nome = ENTRADA.next();
        Correntista correntista = new Correntista(cpf, nome);
        int ret = correntistaMediador.incluir(correntista);
        mostrarSucessoNaoSucesso("Correntista Incluido", "Correntista Não Incluido", CorrentistaMediador.SUCESSO, ret);
    }
    private void incluirConta(){
        Conta conta = null;
        double tarifa = 0.0;
        double taxaBonus = 0.0;
        System.out.println("Digite 1 para conta corrente e 2 para conta poupança");
        int opcConta = ENTRADA.nextInt();
        System.out.println("Digite o numero da conta: ");
        long numeroConta = ENTRADA.nextLong();
        System.out.println("Digite o numero da agencia ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite o cpf do correntista: ");
        int cpf = ENTRADA.nextInt();
        if (opcConta ==1){
            System.out.println("Digite a tarifa (exemplo: 1,1): ");
            tarifa = ENTRADA.nextDouble();
            conta = new ContaCorrente(numeroConta, numeroAgencia, null, tarifa);
        } else {
            System.out.println("Digite a taxa bonus");
            taxaBonus = ENTRADA.nextDouble();
            conta = new ContaPoupanca(numeroConta, numeroAgencia, null, taxaBonus);
        }
        int ret = contaMediador.incluir(conta, cpf);
        mostrarSucessoNaoSucesso("Conta criada", "Conta não criada", ContaMediador.SUCESSO, ret);

    }
    private void depositar(){
        System.out.println("Digite o número da sua conta: ");
        long numeroConta = ENTRADA.nextLong();
        System.out.println("Digite o número da agencia: ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite o valor: ");
        double valor = ENTRADA.nextDouble();
        int ret = contaMediador.creditar(numeroAgencia, numeroConta, valor);
        mostrarSucessoNaoSucesso("Valor Depositado", "Valor não depositado", ContaMediador.SUCESSO, ret);
    }
    private void creditar(){
        System.out.println("Digite o número da sua conta: ");
        long numeroConta = ENTRADA.nextLong();
        System.out.println("Digite o número da agencia: ");
        int numeroAgencia = ENTRADA.nextInt();
        System.out.println("Digite o valor: ");
        double valor = ENTRADA.nextDouble();
        int ret = contaMediador.debitar(numeroAgencia, numeroConta, valor);
        mostrarSucessoNaoSucesso("Valor Creditado", "Valor não creditado", ContaMediador.SUCESSO, ret);
    }
    private void listarCorrentistas(){
        Correntista[] correntistas = correntistaMediador.consultarOrdenadoPorNome();
        for (Correntista correntista :  correntistas) {
            System.out.println(correntista.getNome() + " , " + correntista.getCpf());
        }
    }
    private void listarContas(){
        Conta[] contas = contaMediador.consultarOrdenadoPorSaldo();
        for (Conta conta : contas) {
            System.out.println(conta.getNumeroAgencia() + " , " + conta.getNumeroConta() + " - R$ " + conta.getSaldo());
        }
    }

    private void mostrarSucessoNaoSucesso(String msgSucesso, String msgNaoSucesso, int codigoSucesso, int ret) {
		if (ret == codigoSucesso) {
			System.out.println(msgSucesso + " com sucesso");
		} else {
			System.out.println(msgNaoSucesso + ", cod retorno: " + ret);
		}		
	}

}
