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
        if(c==2){
           try{
            System.out.println("Cadastrar professor: ");
            System.out.print("Nome: ");
            String nome = scan.next();
            System.out.print("Area de especialização: ");
            String AreadeEspec = scan.next();
            System.out.print("Departamento: ");
            int dep = scan.nextInt();
            Professor professor = new Professor(nome,AreadeEspec,dep);
            new ProfessorDAO().salvarProfessor(professor);
           }catch(Exception e){
            System.out.println("Ero inesperado!!");
            System.out.println(e);
           }
        }
        if(c==3){
            System.out.println("Cadastrar curso:");
            try{
                System.out.print("Nome do curso: ");
                String nomeCurso = scan.nextLine();
                System.out.print("Descrição: ");
                String desc = scan.nextLine();

            }catch(Exception e){
                System.out.println("Erro inesperado!!");
                System.out.println(e);
            }
        }
        if(c==4){
            System.out.println("Lista de Alunos: ");
            try{
                List<Aluno> listaDeAlunos = new AlunoDAO().ListarAlunos();

                for(Aluno a:listaDeAlunos){
                    System.out.println("Nome: "+a.getNome()+"| Matricula: "+a.getMatricula()+"| Ano de gradução: "+a.getAnoGraduacao());
                }
            }catch(Exception e){
                System.out.println("Erro ao listar alunos!!");
            }
        }4
        if(c==5){
            System.out.println("Lista de professores: ");
            try{
                List<Professor> listaDeProfessores = new ProfessorDAO().ListarProfessor();

                for(Professor p: listaDeProfessores){
                    System.out.print("Nome: "+p.getNome()+" | Area de especialização: "+p.getAreaEspec()+"| Id do departamento: "+p.getDep());
                    System.out.println("\n");
                }
                

            }catch(Exception e){
                System.out.println("Erro inesperador!!");
                System.out.print(e);
            }
        }

        /*if(c==6){
            System.out.println("Lista de cursos:");
            try{

            }catch(Exception e){
                System.out.println("Erro inesperado!!");
                System.out.println(e);
            } 
        }*/

        if(c==7){
            System.out.println("Deletar Aluno:");
           try{

            System.out.print("Informe O id do aluno: ");
            int IdAluno = scan.nextInt();
            AlunoDAO AlunoDeletado = new AlunoDAO();
            AlunoDeletado.DeleteAluno(IdAluno);

           }catch(Exception e){
                System.out.println("Erro inesperado!!");
                System.out.println(e);
           }
        }
        if(c==8){
            System.out.println("Deletar professor: ");

            try{
                System.out.print("Informe o id do professor: ");
                int IdProfessor = scan.nextInt();
                new ProfessorDAO().DeletarProfessor(IdProfessor);
            }catch(Exception e ){
                System.out.println("Erro inesperado!!");
                System.out.println(e);
            }
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
        if(c==11){
            System.out.println("Atualizar Professor: ");

            try{
                System.out.print("Informe o id do professor: ");
                int IdProfessor = scan.nextInt();
                System.out.println("Novos dados: ");

                System.out.print("Nome: ");
                String nome = scan.next();
                System.out.print("Area de espealização: ");
                String areaEspec = scan.next();
                System.out.print("Id do departamento: ");
                int dep = scan.nextInt();
                new ProfessorDAO().AtualizarProfessor(nome,areaEspec,dep,IdProfessor);
            }catch(Exception e){
                System.out.println("Erro inesperado!!");
                System.out.println(e);
            }
        }
      }
        
    }
}