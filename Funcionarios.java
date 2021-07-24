public class Funcionarios implements actions {
  private String rg;
  private String nome;
  private Data dataNasc;
  private Data dataAdmissao;
  private double salario;

  public Funcionarios(String rg, String nome, Data dataNasc, Data dataAdmissao, double salario) {
    this.rg = rg;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.dataAdmissao = dataAdmissao;
    this.salario = salario;
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

  public void exclui() {
  }

  public void cadastro() {
  }

  public void altera() {
  }
}