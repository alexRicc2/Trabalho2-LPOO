import java.util.*;
public class Motocicleta extends Veiculo {
  private int cilindradas;
  private int tipo;// 1 trail, 2 street, 3 esportiva, 4 custom
  
  public Motocicleta() {
    super();
  }
  public Motocicleta(int cilindradas, int tipo, int numeroChassi, String marca, String modelo, int ano, int km,
      int tipoCombustivel, double peso, boolean status) {
    super(numeroChassi, marca, modelo, ano, km, tipoCombustivel, peso, status);
    this.cilindradas=cilindradas;
    this.tipo=tipo;
  }
  
  public void printMotocicleta(){
    System.out.printf("Cilindradas: %d\nTipo: ",cilindradas);
    switch(tipo){
      case 1:System.out.printf("Trail\n");break;
      case 2:System.out.printf("Street\n");break;
      case 3:System.out.printf("Esportiva\n");break;
      case 4:System.out.printf("Custom\n");break;
    }
    printaVeiculo();
  }

  public int getCilindradas() {
    return this.cilindradas;
  }

  public int getTipo() {
    return this.tipo;
  }

  public void setCilindradas(int cilindradas) {
    this.cilindradas = cilindradas;
  }

  public void setTipo(int tipo) {
    Scanner scan=new Scanner(System.in);
    if(tipo<1 || tipo>4){
      System.out.printf("Valor invalido. Tente novamente: ");
        setTipo(scan.nextInt());
    }
    else
      this.tipo = tipo;
  }
  public void cadastra(int chassi) {
    Scanner scan = new Scanner(System.in);
    super.cadastra(chassi);
    System.out.printf("Cilindradas: ");
    this.setCilindradas(scan.nextInt());
    System.out.printf("Tipo(1 trail, 2 street, 3 esportiva, 4 custom): ");
    this.setTipo(scan.nextInt());
    System.out.println("Cadastro concluido!");
  }
}