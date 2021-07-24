public class Funcionarios{
  private String rg;
  private String nome;
  private Data dataNasc;
  private Data dataAdmissao;
  private double salario;
  private String login;
  private String senha;

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
}