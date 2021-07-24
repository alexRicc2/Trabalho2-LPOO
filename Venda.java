public class Venda {
  private int id;
  private Vendedor vendedor;
  private Cliente cliente;
  private Veiculo veiculo;
  private double valor;
  private Data data;
  private Hora hora;

  public Venda(int id, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data, Hora hora) {
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

  public Vendedor getVendedor() {
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

  public void setVendedor(Vendedor vendedor) {
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
}