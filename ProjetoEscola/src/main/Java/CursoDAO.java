import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO{
    public void salvarCurso(Curso curso) throws ClassNotFoundException{
        String sql = "INSERT INTO Curso (Nome, Descricao, ProfessorId) VALUES (?,?,?)";
        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);

            p.setString(1,curso.getNome());
            p.setString(2,curso.getDescricao());
            p.setInt(3,curso.getIdProfessor());
            p.execute();
            System.out.println("Curso salvo com sucesso!!");

            p.close();
            conn.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Curso> ListarCursos() throws ClassNotFoundException{
        String sql = "SELECT * FROM Curso";
        List<Curso> listaDeCursos = new ArrayList<>();
        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet consulta = ps.executeQuery();

            while(consulta.next()){
                String nome = consulta.getString("Nome");
                String desc = consulta.getString("Descricao");
                int IdProfessor = consulta.getInt("ProfessorId");

                Curso curso = new Curso(nome,desc,IdProfessor);
                listaDeCursos.add(curso);
            }
        
            ps.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaDeCursos;
    }
    public void DeleteCurso(int IdCurso) throws ClassNotFoundException{
        String sql = "DELETE FROM Curso WHERE IdCurso = ?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,IdCurso);
            pst.executeUpdate();

            System.out.println("Curso deletado com sucesso!!");

            pst.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void AtualizarCurso(int IdCurso, Curso curso) throws ClassNotFoundException{
        String sql = "UPDATE Curso SET Nome = ?, Descricao = ?, ProfessorId = ? WHERE IdCurso = ?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,curso.getNome());
            pst.setString(2,curso.getDescricao());
            pst.setInt(3,curso.getIdProfessor());
            pst.setInt(4,IdCurso);

            pst.executeUpdate();

            System.out.println("Curso atualizado com sucesso!!");

            pst.close();
            conn.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}