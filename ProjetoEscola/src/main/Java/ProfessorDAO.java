import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public void salvarProfessor(Professor professor) throws ClassNotFoundException{
        String sql = "INSERT INTO Professor (Nome, AreaEspecializacao, DepartamentoId) VALUES (?,?,?)";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setString(2,professor.getAreaEspec());
            pst.setInt(3,professor.getDep());
            pst.execute();
            System.out.println("Professor salvo com sucesso!!");
            conn.close();
            pst.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
     public List<Professor> ListarProfessor() throws ClassNotFoundException{
        String sql = "SELECT * FROM Professor";
        List<Professor> listaProfessor = new ArrayList<>();
        
        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet consulta = pst.executeQuery();

            while(consulta.next()){
                String nome = consulta.getString("Nome");
                String AreaEspec = consulta.getString("AreaEspecializacao");
                int dep = consulta.getInt("DepartamentoId");

                Professor professor = new Professor(nome,AreaEspec,dep);
                listaProfessor.add(professor);

            }
            pst.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaProfessor;
    }
    public void DeletarProfessor( int IdProfessor) throws ClassNotFoundException{
        String sql = "DELETE FROM Professor WHERE IdProfessor = ?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,IdProfessor);

            pst.executeUpdate();
            System.out.println("Professor deletado com sucesso!!");
            pst.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void AtualizarProfessor(int IdProfessor, Professor professor) throws ClassNotFoundException{
        String sql = "UPDATE Professor SET nome=?,AreaEspecializacao=?, DepartamentoId=? WHERE IdProfessor=?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,professor.getNome());
            ps.setString(2,professor.getAreaEspec());
            ps.setInt(3,professor.getDep());
            ps.setInt(4,IdProfessor);

            ps.executeUpdate();
            System.out.println("Professor atualizado com sucesso!!");

            ps.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    
}
