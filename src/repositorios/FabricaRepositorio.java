package repositorios;

public class FabricaRepositorio {
    private static RepositorioConta repositorioConta = new RepositorioConta();
    private static RepositorioCorrentista repositorioCorrentista = new RepositorioCorrentista();

    public static RepositorioConta getRepositorioConta(){
        return repositorioConta;
    }
    public static RepositorioCorrentista getRepositorioCorrentista(){
        return repositorioCorrentista;
    }
}
