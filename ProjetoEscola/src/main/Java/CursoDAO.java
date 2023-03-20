public class CursoDAO{
    public void salvarCurso(Curso curso){
        String sql = "INSERT INTO Curso (Nome, Descricao, ProfessorId) VALUES (?,?,?)";
        try{

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}