import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException{
    Scanner scan = new Scanner(System.in);
    int c=1;
    while(c!=0){
        System.out.println("[1] - Cadastrar Aluno");
        System.out.println("[2] - Cadastrar Professor");
        System.out.println("[3] - Cadastrar Curso");
        System.out.println("[4] - Listar alunos");
        System.out.println("[5] - Listar professores");
        System.out.println("[6] - Listar cursos");
        System.out.println("[7] - Deletar aluno");
        System.out.println("[8] - Deletar professor");
        System.out.println("[9] - Deletar curso");
        System.out.println("[10] - Atualizar aluno");
        System.out.println("[11] - Atualizar professor");
        System.out.println("[12] - Atualizar curso");

        System.out.print("Opcao: ");
        c = scan.nextInt();
        System.out.print("\n");
        if(c==1){
            System.out.println("Cadastrar Aluno");
           try{
            System.out.print("Nome: ");
            String nome = scan.next();

            System.out.print("Matricula: ");
            String matricula = scan.next();

            System.out.print("Ano de graduacao: ");
            int AnoGraduacao = scan.nextInt();
            
            Aluno aluno = new Aluno(nome, matricula, AnoGraduacao);
            new AlunoDAO().salvarAluno(aluno);
            System.out.print("\n");
           }catch(Exception e){
            System.out.println("Erro inesperado");
            System.out.println(e);
           }

        }
        if(c==4){
            try{
                List<Aluno> listaDeAlunos = new AlunoDAO().ListarAlunos();

                for(Aluno a:listaDeAlunos){
                    System.out.println("Nome: "+a.getNome()+"| Matricula: "+a.getMatricula()+"| Ano de gradução: "+a.getAnoGraduacao());
                }
            }catch(Exception e){
                System.out.println("Erro ao listar alunos!!");
            }
        }

        if(c==7){
            System.out.println("Deletar Aluno:");
            System.out.print("Informe O id do aluno: ");
            int IdAluno = scan.nextInt();
            AlunoDAO AlunoDeletado = new AlunoDAO();
            AlunoDeletado.DeleteAluno(IdAluno);
        }
        if(c==10){
            System.out.println("Atualizar aluno:");
            System.out.print("Informe o id do aluno: ");
            int IdAluno = scan.nextInt();
            System.out.println("Insira os novos dados");
            System.out.print("Nome: ");
            String novoNome = scan.next();
            System.out.print("Matricula: ");
            String novaMatricula = scan.next();
            System.out.print("Ano de Graduação: ");
            int novoAnoGraduacao = scan.nextInt();
            AlunoDAO atualizarAluno = new AlunoDAO();
            atualizarAluno.AtualizarAluno(IdAluno, novoNome,  novaMatricula, novoAnoGraduacao);
        }
      }
        
    }
}