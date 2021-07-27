import java.util.*;
public class AVista extends Venda{
  private final double desconto = 0.10;
  
  public void calculaValorFinal() {
    this.setValorFinal(this.getValor() - this.getValor() * this.desconto);
  }
  public boolean cadastra(List<Venda> vendas, Funcionarios vendedor, List <Cliente> clientes, List <Motocicleta> motos, List <Carro> carros) {
    if(super.cadastra(vendas, vendedor, clientes, motos, carros)){
      this.calculaValorFinal();
      System.out.println("Valor final: " + this.getValorFinal() + "\nVenda realizada com sucesso!");
      return true;
    }
    return false;
  }
  public void mostraVenda() {
    System.out.println("Tipo de venda: A Vista.");
    System.out.println("Nome do vendedor: "+ this.getVendedor().getNome());
    System.out.println("Nome do cliente: "+ this.getCliente().getNome());
    System.out.println("Veiculo vendido: "+ this.getVeiculo().getModelo());
    System.out.println("Desconto: 10%");
    System.out.println("Valor final: "+ this.getValorFinal());
  }
}
