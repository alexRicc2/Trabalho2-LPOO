import java.util.*;

public class Cliente implements generalActions{
  private String cpf;
  private String nome;
  private Data dataNasc;
  private Endereco endereco;
  private double renda;
  private List<String> dependentes = new ArrayList<>();
  
  public Cliente() {
    this("", "", new Data(), new Endereco(), 0, new ArrayList<String>());
  }

  public Cliente(String cpf, String nome, Data dataNasc, Endereco endereco, double renda, List<String> dependentes) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.endereco = endereco;
    this.renda = renda;
    this.dependentes = dependentes;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public Data getDataNasc() {
    return this.dataNasc;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public double getRenda() {
    return this.renda;
  }

  public List getDependentes() {
    return this.dependentes;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDataNasc(Data dataNasc) {
    this.dataNasc = dataNasc;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public void setRenda(double renda) {
    this.renda = renda;
  }

  public void setDependentes(List<String> dependentes) {
    this.dependentes = dependentes;
  }
  public void cadastra() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Nome do cliente: ");
    this.setNome(scan.nextLine());
    System.out.println("CPF do cliente: ");
    this.setCpf(scan.nextLine());
    System.out.printf("Digite o dia mes e ano em que o cliente nasceu separado por espaco: ");
    this.setDataNasc(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
    this.endereco.cadastra();
    System.out.println("Renda do cliente: ");
    this.setRenda(scan.nextDouble());
    System.out.println("Quantidade de dependentes: ");
    int quant = scan.nextInt();
    List<String> depen = new ArrayList<>();
    scan.nextLine();
    for(int i=0;i<quant;i++) {
      System.out.println("Nome do Dependente ["+i+"]: ");
      depen.add(scan.nextLine());
    }
    this.setDependentes(depen);
    System.out.println("Cadastro concluido!!");
  }
  public void altera() {
    Scanner scan = new Scanner(System.in);
    int op;
    do {
      System.out.println("--Sistema de alterações de cliente--");
      System.out.println("1- Alterar nome do cliente");
      System.out.println("2- Alterar cpf do cliente");
      System.out.println("3- Alterar renda do cliente");
      System.out.println("4- Alterar endereco do cliente");
      System.out.println("5- sair");
      System.out.println("Escolha: ");
      op = scan.nextInt();
      
      if(op == 1) {
        System.out.println("Nome atual: "+this.getNome());
        System.out.println("Novo nome: ");
        this.setNome(scan.nextLine());
      }
      if(op == 2) {
        System.out.println("CPF atual: "+this.getCpf());
        System.out.println("Novo CPF: ");
        this.setCpf(scan.nextLine());
      }
      else if(op == 3) {
        System.out.println("Renda atual: "+this.getRenda());
        System.out.println("Nova Renda: ");
        this.setRenda(scan.nextDouble());
      }
      else if(op ==4) {
        this.endereco.altera();
      }

    }while(op!=5);
  }
}