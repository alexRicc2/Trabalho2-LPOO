import java.util.*;
public class Vendedor extends Funcionarios {
  private int treinamentoRestante;
  private Funcionarios responsavel;
  private int tipo = 2;
  
  public Vendedor() {
    this(0, new Gerente(),"","","","",new Data(),new Data(),0);
  }

  public Vendedor(int treinamentoRestante, Funcionarios responsavel,String login,String senha, String rg, String nome, Data dataNasc,
      Data dataAdmissao, double salario) {
    super(login, senha, rg, nome, dataNasc, dataAdmissao, salario);
    this.treinamentoRestante = treinamentoRestante;
    this.responsavel = responsavel;
  }

  public int getTreinamentoRestante() {
    return this.treinamentoRestante;
  }

  public void setTreinamentoRestante(int treinamentoRestante) {
    this.treinamentoRestante = treinamentoRestante;
  }

  public Funcionarios getResponsavel() {
    return this.responsavel;
  }

  public void setResponsavel(Funcionarios responsavel) {
    this.responsavel = responsavel;
  }
  public void cadastra(List<Funcionarios> vendedores, List<Funcionarios> gerentes) {
    Scanner scan = new Scanner(System.in);
    System.out.println("--Cadastrando vendedor--");
    super.cadastra(vendedores);
    System.out.printf("Treinamento restante: ");
    this.setTreinamentoRestante(scan.nextInt());
    
    for(int i=0;i<gerentes.size();i++) {
      System.out.println("Gerente["+i+"]: "+gerentes.get(i).getNome());
    }
    int indice;
    while(true){
      System.out.printf("Digite o indice do gerente responsavel: ");
      indice=scan.nextInt();
      if(indice<0 || indice>=gerentes.size())
        System.out.println("Indice invalido.");
      else
        break;
    }
    this.setResponsavel(gerentes.get(indice));
  }
}