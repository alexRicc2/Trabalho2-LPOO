import java.util.*;
public class APrazo extends Venda{
  private int quantPrazos; 
  private double juros;
  
  public APrazo(){
    super();
  }
  
  public APrazo(int id, Funcionarios vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data, Hora hora, int quantPrazos){
    super(id,vendedor,cliente,veiculo,valor,data,hora);
    this.quantPrazos=quantPrazos;
    this.calculaValoFinal();
  }
  
  public int getQuantPrazos() {
    return quantPrazos;
  }
  public void setQuantPrazos(int quantPrazos) {
    this.quantPrazos = quantPrazos;
  }
  public void calculaValoFinal() {    
    if(this.getQuantPrazos() == 12)juros =  1.012;
    else if(this.getQuantPrazos() == 24)juros = 1.0187;
    else juros = 1.0244;
    
  }
  public boolean cadastra(List<Venda> vendas, Funcionarios vendedor, List <Cliente> clientes, List <Motocicleta> motos, List <Carro> carros) {
    Scanner scan = new Scanner(System.in);
    
    if(super.cadastra(vendas, vendedor, clientes, motos, carros)){
      System.out.printf("Quantidade de parcelas (12, 24, 36): ");
      this.setQuantPrazos(scan.nextInt());
      this.calculaValoFinal();
      System.out.println("Valor final: "+ this.getValor()*juros+ "\nVenda realizada com sucesso!");
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
    System.out.printf("Valor final: %.2f\n",getValor()*juros);
  }
}
