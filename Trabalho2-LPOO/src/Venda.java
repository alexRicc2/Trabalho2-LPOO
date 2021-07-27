import java.util.*;

public class Venda implements generalActions{
  private int id;
  private int tipo;
  private Funcionarios vendedor;
  private Cliente cliente;
  private Veiculo veiculo;
  private double valor;
  private double valorFinal;
private Data data;
  private Hora hora;
  
  public Venda() {
    this(0, new Funcionarios(), new Cliente(), new Veiculo(), 0, new Data(), new Hora());
  }
  
  public Venda(int id, Funcionarios vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data, Hora hora) {
    this.id = id;
    this.vendedor = vendedor;
    this.cliente = cliente;
    this.veiculo = veiculo;
    this.valor = valor;
    this.data = data;
    this.hora = hora;
  }

  public int getTipo() {
  return tipo;
  }

  public void setTipo(int tipo) {
  this.tipo = tipo;
  }

public double getValorFinal() {
    return valorFinal;
  }
  
  public void setValorFinal(double valorFinal) {
    this.valorFinal = valorFinal;
  }
  public int getId() {
    return this.id;
  }

  public Funcionarios getVendedor() {
    return this.vendedor;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public Veiculo getVeiculo() {
    return this.veiculo;
  }

  public double getValor() {
    return this.valor;
  }

  public Data getData() {
    return this.data;
  }

  public Hora getHora() {
    return this.hora;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setVendedor(Funcionarios vendedor) {
    this.vendedor = vendedor;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public void setHora(Hora hora) {
    this.hora = hora;
  }
  
  public void cadastra() {
    Scanner scan = new Scanner(System.in);
    System.out.println("--Realizando uma venda--");
    System.out.println("ID da venda: ");
    this.setId(scan.nextInt());
    System.out.println("Valor inicial da venda: ");
    this.setValor(scan.nextDouble());
    this.data.cadastra();
    this.hora.cadastra();
    
  }
  public void cadastra(List <Funcionarios> vendedores, List <Cliente> clientes, List <Veiculo> motos, List <Veiculo> carros) {
    Scanner scan = new Scanner(System.in);
    int op;
    
    this.cadastra();
    for(int i=0;i<vendedores.size();i++) {
      System.out.println("Vendedor["+i+"]: "+vendedores.get(i).getNome());
    }
    System.out.println("Digite o indice do vendedor que esta realizando a venda: ");
    this.setVendedor(vendedores.get(scan.nextInt()));
    
    for(int i=0;i<clientes.size();i++) {
      System.out.println("Cliente["+i+"]: "+clientes.get(i).getNome());
    }
    System.out.println("Digite o indice do cliente que esta realizando a compra: ");
    this.setCliente(clientes.get(scan.nextInt()));
    
    System.out.println("1- comprar um carro");
    System.out.println("2- comprar uma moto");
    System.out.println("escolha: ");
    op = scan.nextInt();
    if(op == 1) {
      for(int i=0;i<carros.size();i++) {
        System.out.println("Carro["+i+"]: "+carros.get(i).getModelo());
      }
      System.out.println("Digite o indice do carro que esta sendo comprado: ");
      this.setVeiculo(carros.get(scan.nextInt()));  
    }
    else {
      for(int i=0;i<motos.size();i++) {
        System.out.println("Motos["+i+"]: "+motos.get(i).getModelo());
      }
      System.out.println("Digite o indice da moto que esta sendo comprada: ");
      this.setVeiculo(motos.get(scan.nextInt()));  
    }
  }
  public void altera() {
    
  }
  public void mostraVenda() {
    System.out.println("Tipo de pagamento: "+this.getTipo());
    System.out.println("Nome do vendedor: "+ this.vendedor.getNome());
    System.out.println("Nome do cliente: "+ this.cliente.getNome());
    System.out.println("Veiculo vendido: "+ this.veiculo.getModelo());
    System.out.println("Valor final: "+ this.getValorFinal());
  }
}