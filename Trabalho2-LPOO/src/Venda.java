import java.util.*;

public abstract class Venda {
  private int id;
  private Funcionarios vendedor;
  private Cliente cliente;
  private Veiculo veiculo;
  private double valor;
  private Data data;
  private Hora hora;
  
  public Venda() {
    this(0, new Vendedor(), new Cliente(), new Carro(), 0, new Data(), new Hora());
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
  public int getQuantPrazos(){
    return 0;
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
  
  public boolean cadastra(List<Venda> vendas, Funcionarios vendedor, List <Cliente> clientes, List <Motocicleta> motos, List <Carro> carros) {
    Scanner scan = new Scanner(System.in);
    int op;
    boolean disponivel=false;
    System.out.println("--Realizando uma venda--");
    int idVenda;
    while(true){
      boolean achado=false;
      System.out.printf("ID da venda: ");
      idVenda=scan.nextInt();
      for(int i=0;i<vendas.size();i++){
        if(vendas.get(i).getId()==idVenda){
          System.out.println("ID repetido. Tente novamente.");
          achado=true;
          break;
        }
      }
      if(!achado)
        break;
    }
    this.setId(idVenda);
    System.out.printf("Valor inicial da venda: ");
    this.setValor(scan.nextDouble());
    this.data.cadastra();
    this.hora.cadastra();
    
    this.setVendedor(vendedor);
    
    for(int i=0;i<clientes.size();i++) {
      System.out.println("Cliente["+i+"]: "+clientes.get(i).getNome());
    }
    System.out.printf("Digite o indice do cliente que esta realizando a compra: ");
    this.setCliente(clientes.get(scan.nextInt()));
    
    System.out.println("1- comprar um carro");
    System.out.println("2- comprar uma moto");
    System.out.printf("escolha: ");
    op = scan.nextInt();
    if(op == 1) {
      if(carros.size()==0){
        System.out.println("Nao existem carros cadastrados.");
        return false;
      }
      else{
        for(int i=0;i<carros.size();i++) {
          if(!carros.get(i).getStatus()){
            System.out.println("Carro["+i+"]: "+carros.get(i).getModelo());
            disponivel=true;
          }
        }
        if(disponivel){
          System.out.printf("Digite o indice do carro que esta sendo comprado: ");
          this.setVeiculo(carros.get(scan.nextInt()));  
          this.getVeiculo().setStatus(true);
        }
        else{
          System.out.println("Nao existem carros disponiveis.");
          return false;
        }
      }
    }
    else {
      if(motos.size()==0){
        System.out.println("Nao existem motos cadastradas.");
        return false;
      }
      else{
        for(int i=0;i<motos.size();i++) {
          if(!motos.get(i).getStatus()){
            System.out.println("Motos["+i+"]: "+motos.get(i).getModelo());
            disponivel=true;
          }
        }
        if(disponivel){
          System.out.printf("Digite o indice da moto que esta sendo comprada: ");
          this.setVeiculo(motos.get(scan.nextInt()));  
          this.getVeiculo().setStatus(true);
        }
        else{
          System.out.println("Nao existem motos disponiveis.");
          return false;
        }
      }
    }
    return true;
  }
  public void mostraVenda() {
  }
}