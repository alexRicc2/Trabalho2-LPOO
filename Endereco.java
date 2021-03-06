import java.util.*;
public class Endereco {
  private String rua;
  private int numero;
  private String bairro;
  private String cidade;
  public Endereco() {
    this("",0,"","");
  }

  public Endereco(String rua, int numero, String bairro, String cidade) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
  }

  public String getRua() {
    return this.rua;
  }

  public int getNumero() {
    return this.numero;
  }

  public String getBairro() {
    return this.bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  public void cadastra() {
    Scanner scan = new Scanner(System.in);
    System.out.println("---Cadastrando endereco---");
    System.out.printf("Nome da Rua: ");
    this.setRua(scan.nextLine());
    System.out.printf("Numero da casa: ");
    this.setNumero(scan.nextInt());
    System.out.printf("Nome do bairro: ");
    scan.nextLine();
    this.setBairro(scan.nextLine());
    System.out.printf("Nome da cidade: ");
    this.setCidade(scan.nextLine());
  }
  public void altera() {
    Scanner scan = new Scanner(System.in);
    int op;
    do {
      System.out.println("--Sistema de alteracoes de endereco--");
      System.out.println("1- Alterar nome da Rua");
      System.out.println("2- Alterar numero da casa");
      System.out.println("3- Alterar nome do bairro");
      System.out.println("4- Alterar nome da cidade");
      System.out.println("5- sair");
      System.out.printf("Escolha: ");
      op = scan.nextInt();
      
      if(op == 1) {
        System.out.println("Rua atual: " + this.getRua());
        System.out.printf("Nova Rua: ");
        this.setRua(scan.nextLine()); 
      }
      else if(op == 2) {
        System.out.println("Numero atual: " + this.getNumero());
        System.out.printf("Novo numero: ");
        this.setNumero(scan.nextInt()); 
      }
      else if(op == 3) {
        System.out.println("Bairro atual: " + this.getBairro());
        System.out.printf("Novo Bairro: ");
        this.setBairro(scan.nextLine()); 
      }
      else if(op == 4) {
        System.out.println("Cidade atual: " + this.getCidade());
        System.out.printf("Nova Cidade: ");
        this.setCidade(scan.nextLine()); 
      }
    }while(op != 5);
    
  }
}