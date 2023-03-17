public class Professor {
    private String nome;
    private String AreaEspec;

    public Professor(String nome,String AreaEspec){
        this.nome = nome;
        this.AreaEspec = AreaEspec;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getAreaEspec(){
        return AreaEspec;
    }
    public void setAreaEspec(String AreaEspec){
        this.AreaEspec = AreaEspec;
    }
    
}
