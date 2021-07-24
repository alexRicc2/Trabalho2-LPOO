import java.util.*;
public class Gerente extends Funcionarios implements actions{
  private int anosExperiencia;
  
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
    this.anosExperiencia = anosExperiencia;
  }
  
  public void cadastra(List<Funcionarios> gerentes){
    Scanner scan=new Scanner(System.in);
    while(true){
      boolean login_repetido=false;
      System.out.printf("Digite seu login: ");
      String auxLogin=scan.nextLine();
      for(int i=0;i<gerentes.size();i++){
        if(gerentes.get(i).getLogin().equals(auxLogin)){
          login_repetido=true;
          break;
        }
      }
      if(login_repetido)
        System.out.println("Login ja existente. tente novamente.");
      else{
        setLogin(auxLogin);
        break;
      }
    }
    System.out.printf("Digite sua senha: ");
    setSenha(scan.next());
    System.out.printf("Digite seu RG: ");
    setRg(scan.next());
    System.out.printf("Digite seu nome: ");
    scan.nextLine();
    setNome(scan.nextLine());
    System.out.printf("Digite o dia mes e ano em que nasceu separado por espaco: ");
    setDataNasc(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
    System.out.printf("Digite o dia mes e ano em que foi admitido separado por espaco: ");
    setDataAdmissao(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
    System.out.printf("Digite seu salario: ");
    setSalario(scan.nextDouble());
    System.out.printf("Digite a quantidade de anos de experiencia: ");
    anosExperiencia=scan.nextInt();
    gerentes.add(this);
    System.out.println("Gerente cadastrado com sucesso.");
  }
}