// Número do chassi, marca, modelo, ano, quilometragem, tipo de
// combustível, peso, status (vendido, a venda).
public class Veiculo {
  private int numeroChassi;
  private String marca;
  private String modelo;
  private int ano;
  private int km;
  private int tipoCombustivel;// 1 gasolina,2 alcool;
  private double peso;
  private boolean status;

  public Veiculo(int numeroChassi, String marca, String modelo, int ano, int km, int tipoCombustivel, double peso,
      boolean status) {
    this.numeroChassi = numeroChassi;
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.km = km;
    this.tipoCombustivel = tipoCombustivel;
    this.peso = peso;
    this.status = status;
  }

  public void printaVeiculo() {
    System.out.printf("Numero Chassi: %d\nMarca: %s\nModelo: %s\nAno: %d\nKm: %d\nCombustivel: ", numeroChassi, marca,
        modelo, ano, km);
    switch (tipoCombustivel) {
      case 1:
        System.out.printf("Gasolina\n");
      case 2:
        System.out.printf("Alcool\n");
      default:
        System.out.println();
    }
    System.out.printf("Peso: %f\nStatus: ", peso);
    if (status)
      System.out.printf("Vendido.\n");
    else
      System.out.printf("Disponivel.\n");
  }

  public int getNumeroChassi() {
    return numeroChassi;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getAno() {
    return ano;
  }

  public int getKm() {
    return km;
  }

  public int getTipoCombustivel() {
    return tipoCombustivel;
  }

  public double getPeso() {
    return peso;
  }

  public boolean getStatus() {
    return status;
  }

  public void setNumeroChassi(int numeroChassi) {
    this.numeroChassi = numeroChassi;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void setKm(int km) {
    this.km = km;
  }

  public void setTipoCombustivel(int tipoCombustivel) {
    this.tipoCombustivel = tipoCombustivel;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}