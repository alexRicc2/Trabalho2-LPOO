import java.util.Scanner;

public class Data {
  private int dia;
  private int mes;
  private int ano;
  
  public Data(){
    this(1,1,1950);
  }

  public Data(int dia, int mes, int ano) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      if (!(setDia(dia) && setMes(mes) && setAno(ano))) {
        System.out.printf("Dia: ");
        dia = scan.nextInt();
        System.out.printf("Mes: ");
        mes = scan.nextInt();
        System.out.printf("Ano: ");
        ano = scan.nextInt();
      } else {
        break;
      }
    }
  }

  public int getDia() {
    return this.dia;
  }

  public boolean setDia(int dia) {
    if (dia < 1 || dia > 31) {
      System.out.println("Dia invalido. Tente novamente.");
      return false;
    }
    this.dia = dia;
    return true;
  }

  public int getMes() {
    return this.mes;
  }

  public boolean setMes(int mes) {
    if (mes < 1 || mes > 12) {
      System.out.println("Mes invalido. Tente novamente.");
      return false;
    }
    this.mes = mes;
    return true;
  }

  public int getAno() {
    return this.ano;
  }

  public boolean setAno(int ano) {
    if (ano < 1950 || ano > 2050) {
      System.out.println("Ano invalido. Tente novamente.");
      return false;
    }
    this.ano = ano;
    return true;
  }

  public void printData() {
    System.out.println("Data: " + this.getDia() + "/" + this.getMes() + "/" + this.getAno());
  }
}