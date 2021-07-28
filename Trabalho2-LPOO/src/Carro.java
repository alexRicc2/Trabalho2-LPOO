// potência, número de cilindros, número de ocupantes, tipo (utilitário,
// pickup, sedan, hatch, esportivo), dimensoes (altura, largura e comprimento).
import java.util.*;
public class Carro extends Veiculo {
  private int potencia;
  private int numeroCilindros;
  private int numeroOcupantes;
  private int tipo;// 1 utilitario,2 pickup,3 sedan,4 hatch,5 esportivo;
  private double altura;
  private double largura;
  private double comprimento;
  
  public Carro(){
    super();
  }
  
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
        break;
      case 2:
        System.out.printf("Pickup\n");
        break;
      case 3:
        System.out.printf("Sedan\n");
        break;
      case 4:
        System.out.printf("Hatch\n");
        break;
      case 5:
        System.out.printf("Esportivo\n");
        break;
    }
    System.out.printf("Dimensoes: %.2fx%.2fx%.2f\n", comprimento, largura, altura);
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
  public void cadastra() {
    Scanner scan = new Scanner(System.in);
    super.cadastra();
    System.out.printf("Potencia: ");
    this.setPotencia(scan.nextInt());
    System.out.printf("Numero de cilindros: ");
    this.setNumeroCilindros(scan.nextInt());
    System.out.printf("Numero de ocupantes: ");
    this.setNumeroOcupantes(scan.nextInt());
    System.out.printf("tipo(1 utilitario,2 pickup,3 sedan,4 hatch,5 esportivo): ");
    this.setTipo(scan.nextInt());
    System.out.printf("Altura: ");
    this.setAltura(scan.nextDouble());
    System.out.printf("Largura: ");
    this.setLargura(scan.nextDouble());
    System.out.printf("Comprimento: ");
    this.setComprimento(scan.nextDouble());
    System.out.println("Cadastro concluido!");
  }
}