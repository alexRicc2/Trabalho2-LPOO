import java.util.*;
public class APrazo extends Venda{
  private int quantPrazos;
  private int tipo = 2;
  
  
  public int getQuantPrazos() {
    return quantPrazos;
  }
  public void setQuantPrazos(int quantPrazos) {
    this.quantPrazos = quantPrazos;
  }
  public void calculaValoFinal() {
    double juros;
    
    if(this.getQuantPrazos() == 12)juros =  1.012;
    else if(this.getQuantPrazos() == 24)juros = 1.0187;
    else juros = 1.0244;
    
    this.setValorFinal(this.getValor() * juros);
  }
  public void cadastra(List <Funcionarios> vendedores, List <Cliente> clientes, List <Veiculo> motos, List <Veiculo> carros) {
    Scanner scan = new Scanner(System.in);
    
    super.cadastra(vendedores, clientes, motos, carros);
    System.out.println("Quantidade de parcelas (12x 24x 36x): ");
    this.setQuantPrazos(scan.nextInt());
    this.calculaValoFinal();
    System.out.println("Valor final: "+ this.getValorFinal()+ "\nVenda realizada com sucesso!");
    
  }
}
