public class Gerente extends Funcionarios {
  private int anosExperiencia;

  public Gerente(int anosExperiencia, String rg, String nome, Data dataNasc, Data dataAdmissao, double salario) {
    super(rg, nome, dataNasc, dataAdmissao, salario);
    this.anosExperiencia = anosExperiencia;
  }

  public int getAnosExperiencia() {
    return this.anosExperiencia;
  }

  public void setAnosExperiencia(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }
}