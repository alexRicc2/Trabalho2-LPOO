import java.util.*;
public class Gerente extends Funcionarios{
  private int anosExperiencia;
  private int tipo = 1;
  
  public Gerente(){
    this(0,"","","","",new Data(),new Data(),0);
  }

  public Gerente(int anosExperiencia, String login, String senha, String rg, String nome, Data dataNasc, Data dataAdmissao, double salario) {
    super(login, senha, rg, nome, dataNasc, dataAdmissao, salario);
    this.anosExperiencia = anosExperiencia;
  }

  public int getAnosExperiencia() {
    return this.anosExperiencia;
  }

  public void setAnosExperiencia(int anosExperiencia) {
    Scanner scan=new Scanner(System.in);
    if(anosExperiencia<1950 || anosExperiencia>2050){
      System.out.println("Ano invalido. Tente novamente: ");
      setAnosExperiencia(scan.nextInt());
    }
    else
      this.anosExperiencia = anosExperiencia;
  }
  
  public void cadastra(List<Funcionarios> gerentes){
    Scanner scan = new Scanner(System.in);
    System.out.println("--Cadastrando um novo gerente--");
    super.cadastra(gerentes);
    System.out.printf("Digite a quantidade de anos de experiencia: ");
    anosExperiencia=scan.nextInt();
    gerentes.add(this);
    System.out.println("Gerente cadastrado com sucesso.");
  }
}