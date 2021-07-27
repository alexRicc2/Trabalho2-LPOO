// Número do chassi, marca, modelo, ano, quilometragem, tipo de
// combustível, peso, status (vendido, a venda).
import java.util.*;
public abstract class Veiculo {
  private int numeroChassi;
  private String marca;
  private String modelo;
  private int ano;
  private int km;
  private int tipoCombustivel;// 1 gasolina,2 alcool;
  private double peso;
  private boolean status;

  public Veiculo() {
    this(0,"","",0,0,1,0,false);
  }
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
        System.out.printf("Gasolina\n");break;
      case 2:
        System.out.printf("Alcool\n");break;
      default:
        System.out.println();break;
    }
    System.out.printf("Peso: %.2f\nStatus: ", peso);
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
  
  public void cadastra() {
    Scanner scan = new Scanner(System.in);
    System.out.printf("Numero do chassi: ");
    this.setNumeroChassi(scan.nextInt());
    System.out.printf("Marca do veiculo: ");
    scan.nextLine();
    this.setMarca(scan.nextLine());
    System.out.printf("Modelo do veiculo: ");
    this.setModelo(scan.nextLine());
    System.out.printf("Ano do veiculo: ");
    this.setAno(scan.nextInt());
    System.out.printf("Kilometragem do veiculo: ");
    this.setKm(scan.nextInt());
    System.out.printf("Tipo combustivel (1 gasolina, 2 alcool): ");
    this.setTipoCombustivel(scan.nextInt());
  }
  public void altera() {
    Scanner scan = new Scanner(System.in);
    int op;
    
    do {      
      System.out.println("--Sistema de alteração de veiculo--");
      System.out.println("1- Alterar numero do chassi");
      System.out.println("2- alterar modelo do veiculo");
      System.out.println("3- alterar marca do veiculo");
      System.out.println("4- alterar ano do veiculo");
      System.out.println("5- alterar kilometragem");
      System.out.println("6- alterar tipo do combustivel");
      System.out.println("7- sair");
      System.out.printf("escolha: ");
      op = scan.nextInt();
      
      if(op == 1) {
        System.out.println("Numero do chassi atual: "+this.getNumeroChassi());
        System.out.printf("Novo numero de chassi: ");
        this.setNumeroChassi(scan.nextInt());
      }
      else if(op == 2) {
        System.out.println("modelo atual do veiculo: "+this.getModelo());
        System.out.printf("novo modelo: ");
        this.setModelo(scan.nextLine());
      }
      else if(op == 3) {
        System.out.println("marca atual do veiculo: "+this.getMarca());
        System.out.printf("nova marca: ");
        this.setMarca(scan.nextLine());
      }
      else if(op == 4) {
        System.out.println("ano atual do veiculo: "+this.getAno());
        System.out.printf("novo ano: ");
        this.setAno(scan.nextInt());
      }
      else if(op == 5) {
        System.out.println("kilometragem atual do veiculo: "+this.getKm());
        System.out.printf("nova kilometragem: ");
        this.setKm(scan.nextInt());
      }
      else if(op == 6) {
        System.out.println("tipo do combustivel atual do veiculo: "+this.getTipoCombustivel());
        System.out.printf("novo tipo de combustivel: ");
        this.setTipoCombustivel(scan.nextInt());
      }
    }while(op!=7);
    
  }
}