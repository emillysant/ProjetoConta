package entidades;

public class Correntista {
    private int cpf;
    private String nome;

    public Correntista(int cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
