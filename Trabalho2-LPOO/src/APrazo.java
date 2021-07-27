import java.util.*;
public class APrazo extends Venda{
  private int quantPrazos; 
  
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
  public boolean cadastra(List<Venda> vendas, Funcionarios vendedor, List <Cliente> clientes, List <Motocicleta> motos, List <Carro> carros) {
    Scanner scan = new Scanner(System.in);
    
    if(super.cadastra(vendas, vendedor, clientes, motos, carros)){
      System.out.printf("Quantidade de parcelas (12, 24, 36): ");
      this.setQuantPrazos(scan.nextInt());
      this.calculaValoFinal();
      System.out.println("Valor final: "+ this.getValorFinal()+ "\nVenda realizada com sucesso!");
      return true;
    }
    return false;
  }
  public void mostraVenda() {
    System.out.println("Tipo de venda: A Prazo.");
    System.out.println("Nome do vendedor: "+ this.getVendedor().getNome());
    System.out.println("Nome do cliente: "+ this.getCliente().getNome());
    System.out.println("Veiculo vendido: "+ this.getVeiculo().getModelo());
    System.out.println("Parcelas: "+quantPrazos);
    System.out.println("Valor final: "+ this.getValorFinal());
  }
}
