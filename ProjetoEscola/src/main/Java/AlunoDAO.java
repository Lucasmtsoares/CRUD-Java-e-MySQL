import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public void salvarAluno(Aluno a){

       String sql = "INSERT INTO Aluno (nome, matricula, anoGraduacaoPrevisto) VALUES (?,?,?)";

        try{
            Connection conn = ConexãoMySQL.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1,a.getNome());
            pst.setString(2,a.getMatricula());
            pst.setInt(3,a.getAnoGraduacao());
            System.out.print("Aluno salvo com sucesso!!");
            pst.execute();
            pst.close();
            conn.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<Aluno> ListarAlunos() throws ClassNotFoundException{
        String sql = "SELECT*FROM Aluno";
        List<Aluno> listarAlunos = new ArrayList<>();
       
        try{
           
           Connection conn = ConexãoMySQL.getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            while(resultado.next()){
                String nome = resultado.getString("nome");
                String matricula = resultado.getString("matricula");
                int anoGraduacaoPrevisto = resultado.getInt("AnoGraduacaoPrevisto");

                Aluno aluno = new Aluno(nome,matricula,anoGraduacaoPrevisto);

                listarAlunos.add(aluno);
            }
            
            pst.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
            
        }
        return listarAlunos;
    }

    public void DeleteAluno(int IdAluno)  throws ClassNotFoundException{
    
        String sql = "DELETE FROM Aluno WHERE IdAluno = ?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1,IdAluno);
            pst.executeUpdate();

            System.out.println("Aluno deletado com sucesso!!");

            pst.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    
    }
    public void AtualizarAluno(int IdAluno, Aluno aluno) throws ClassNotFoundException{
        String sql = "UPDATE Aluno SET Nome = ?,Matricula = ?,AnoGraduacaoPrevisto = ? WHERE IdAluno = ?";

        try{
            Connection conn = ConexãoMySQL.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,aluno.getNome());
            pst.setString(2,aluno.getMatricula());
            pst.setInt(3,aluno.getAnoGraduacao());
            pst.setInt(4,IdAluno);

            pst.executeUpdate();

            System.out.println("Aluno atualizado com sucesso!!");

            conn.close();
            pst.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
   
}