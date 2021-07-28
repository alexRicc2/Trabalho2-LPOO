import java.util.Scanner;

public class Hora {
  private int hora;
  private int minuto;
  
  public Hora() {
    this(0,0);
  }

  public Hora(int hora, int minuto) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      if (!(setHora(hora) && setMinuto(minuto))) {
        System.out.printf("Hora: ");
        hora = scan.nextInt();
        System.out.printf("Minuto: ");
        minuto = scan.nextInt();
      } else {
        break;
      }
    }
  }
  
  public void printHora(){
    System.out.printf("Horario: %d:%d",hora,minuto);
  }

  public int getHora() {
    return this.hora;
  }

  public int getMinuto() {
    return this.minuto;
  }

  public boolean setHora(int hora) {
    if (hora < 0 || hora > 23) {
      System.out.println("Hora invalida. Tente novamente.");
      return false;
    }
    this.hora = hora;
    return true;
  }

  public boolean setMinuto(int minuto) {
    if (minuto < 0 || minuto > 59) {
      System.out.println("Minuto invalido. Tente novamente.");
      return false;
    }
    this.minuto = minuto;
    return true;
  }
  
  public void cadastra() {
  Scanner scan = new Scanner(System.in);
  System.out.printf("Digite a hora e minutos separado por espacos: ");
  this.setHora(scan.nextInt()); this.setMinuto(scan.nextInt());
  }
}