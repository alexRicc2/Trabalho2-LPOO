import java.util.*;
public class Funcionarios {
  private int tipo;
  private String rg;
  private String nome;
  private Data dataNasc;
  private Data dataAdmissao;
  private double salario;
  private String login;
  private String senha;
  
  public Funcionarios() {
    this("","","","",new Data(),new Data(),0);
  }
  
  public Funcionarios(String login,String senha,String rg, String nome, Data dataNasc, Data dataAdmissao, double salario) {
    this.login=login;
    this.senha=senha;
    this.rg = rg;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.dataAdmissao = dataAdmissao;
    this.salario = salario;
  }
  
  public boolean validaLogin(String login,String senha){
    if(this.senha.equals(senha) && this.login.equals(login))
      return true;
    else
      return false;
  }
  
  public String getSenha(){
    return senha;
  }
  
  public void setSenha(String senha){
    this.senha=senha;
  }
  
  public String getLogin(){
    return login;
  }
  
  public void setLogin(String login){
    this.login=login;
  }

  public String getRg() {
    return this.rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Data getDataNasc() {
    return this.dataNasc;
  }

  public void setDataNasc(Data dataNasc) {
    this.dataNasc = dataNasc;
  }

  public Data getDataAdmissao() {
    return this.dataAdmissao;
  }

  public void setDataAdmissao(Data dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
  
  public int getAnosExperiencia(){
    return 0;
  }
  public void cadastra( List<Funcionarios> funcionarios) {
    Scanner scan=new Scanner(System.in);
      while(true){
        boolean login_repetido=false;
        System.out.printf("Digite o login: ");
        String auxLogin=scan.nextLine();
        for(int i=0;i<funcionarios.size();i++){
          if(funcionarios.get(i).getLogin().equals(auxLogin)){
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
      System.out.printf("Digite a senha: ");
      setSenha(scan.next());
      System.out.printf("Digite o RG: ");
      setRg(scan.next());
      System.out.printf("Digite o nome: ");
      scan.nextLine();
      setNome(scan.nextLine());
      System.out.printf("Digite o dia mes e ano em que nasceu separado por espaco: ");
      setDataNasc(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
      System.out.printf("Digite o dia mes e ano em que foi admitido separado por espaco: ");
      setDataAdmissao(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
      System.out.printf("Digite o salario: ");
      setSalario(scan.nextDouble());
  }
  public void altera() {
    Scanner scan = new Scanner(System.in);
    
    System.out.printf("Digite a nova senha: ");
    setSenha(scan.next());
    System.out.printf("Redefina o RG: ");
    setRg(scan.next());
    System.out.printf("Redefina o nome: ");
    scan.nextLine();
    setNome(scan.nextLine());
    System.out.printf("Novo salario: ");
    setSalario(scan.nextDouble()); 
    
  }
}