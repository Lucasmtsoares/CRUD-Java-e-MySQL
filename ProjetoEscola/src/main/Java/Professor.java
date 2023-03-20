public class Professor {
    private String nome;
    private String AreaEspec;
    private int Dep;

    public Professor(String nome,String AreaEspec, int Dep){
        this.nome = nome;
        this.AreaEspec = AreaEspec;
        this.Dep = Dep;
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

    public int getDep() {
        return Dep;
    }

    public void setDep(int dep) {
        Dep = dep;
    }
    
}
