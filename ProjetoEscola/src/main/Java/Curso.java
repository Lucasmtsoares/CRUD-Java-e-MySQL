public class Curso {
    private String nome;
    private String descricao;
    private int IdProfessor;
    
    public Curso(String nome, String descricao, int IdProfessor) {
        this.nome = nome;
        this.descricao = descricao;
        this.IdProfessor = IdProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdProfessor() {
        return IdProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        IdProfessor = idProfessor;
    }

    
    
}
