// potência, número de cilindros, número de ocupantes, tipo (utilitário,
// pickup, sedan, hatch, esportivo), dimensões (altura, largura e comprimento).
public class Carro extends Veiculo {
  private int potencia;
  private int numeroCilindros;
  private int numeroOcupantes;
  private int tipo;// 1 utilitario,2 pickup,3 sedan,4 hatch,5 esportivo;
  private double altura;
  private double largura;
  private double comprimento;

  public Carro(int potencia, int numeroCilindros, int numeroOcupantes, int tipo, double altura, double largura,
      double comprimento, int numeroChassi, String marca, String modelo, int ano, int km, int tipoCombustivel,
      double peso, boolean status) {
    super(numeroChassi, marca, modelo, ano, km, tipoCombustivel, peso, status);
    this.potencia = potencia;
    this.numeroCilindros = numeroCilindros;
    this.numeroOcupantes = numeroOcupantes;
    this.tipo = tipo;
    this.altura = altura;
    this.largura = largura;
    this.comprimento = comprimento;
  }

  public void printCarro() {
    System.out.printf("Potencia: %d\nCilindros: %d\nOcupantes: %d\nTipo: ", potencia, numeroCilindros, numeroOcupantes);
    switch (tipo) {
      case 1:
        System.out.printf("Utilitario\n");
      case 2:
        System.out.printf("Pickup\n");
      case 3:
        System.out.printf("Sedan\n");
      case 4:
        System.out.printf("Hatch\n");
      case 5:
        System.out.printf("Esportivo\n");
    }
    System.out.printf("Dimensoes: %dx%dx%d", comprimento, largura, altura);
    printaVeiculo();
  }

  public int getPotencia() {
    return potencia;
  }

  public int getNumeroCilindros() {
    return numeroCilindros;
  }

  public int getNumeroOcupantes() {
    return numeroOcupantes;
  }

  public int getTipo() {
    return tipo;
  }

  public double getAltura() {
    return altura;
  }

  public double getLargura() {
    return largura;
  }

  public double getComprimento() {
    return comprimento;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public void setNumeroCilindros(int numeroCilindros) {
    this.numeroCilindros = numeroCilindros;
  }

  public void setNumeroOcupantes(int numeroOcupantes) {
    this.numeroOcupantes = numeroOcupantes;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public void setLargura(double largura) {
    this.largura = largura;
  }

  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }
}