public class Vendedor extends Funcionarios {
  private int treinamentoRestante;
  private Gerente responsavel;

  public Vendedor(int treinamentoRestante, Gerente responsavel,String login,String senha, String rg, String nome, Data dataNasc,
      Data dataAdmissao, double salario) {
    super(login, senha, rg, nome, dataNasc, dataAdmissao, salario);
    this.treinamentoRestante = treinamentoRestante;
    this.responsavel = responsavel;
  }

  public int getTreinamentoRestante() {
    return this.treinamentoRestante;
  }

  public void setTreinamentoRestante() {
    this.treinamentoRestante = treinamentoRestante;
  }

  public Gerente getResponsavel() {
    return this.responsavel;
  }

  public void setResponsavel(Gerente responsavel) {
    this.responsavel = responsavel;
  }
}