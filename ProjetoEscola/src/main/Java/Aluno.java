public class Aluno {
    private String nome;
    private String matricula;
    private int AnoGraduacao;

    public Aluno(String nome,String matricula, int AnoGraduacao){
        this.nome = nome;
        this.matricula = matricula;
        this.AnoGraduacao = AnoGraduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoGraduacao() {
        return AnoGraduacao;
    }

    public void setAnoGraduacao(int anoGraduacao) {
        AnoGraduacao = anoGraduacao;
    }

    
}
