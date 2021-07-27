import java.util.*;

public class Cliente {
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
  
  public void printCliente(){
    System.out.printf("Nome: %s\nCPF: %s\n Data de Nascimento: ",nome,cpf);
    dataNasc.printData();
    System.out.printf("Endereco: rua %s %d, %s\n",endereco.getRua(),endereco.getNumero(),endereco.getBairro());
    System.out.printf("Renda: %.2f\n",renda);
    System.out.printf("Dependentes: ");
    for(int i=0;i<dependentes.size();i++){
      System.out.printf("%s -- ",dependentes.get(i));
    }
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
    System.out.printf("Nome do cliente: ");
    this.setNome(scan.nextLine());
    System.out.printf("CPF do cliente: ");
    this.setCpf(scan.nextLine());
    System.out.printf("Digite o dia mes e ano em que o cliente nasceu separado por espaco: ");
    this.setDataNasc(new Data(scan.nextInt(),scan.nextInt(),scan.nextInt()));
    this.endereco.cadastra();
    System.out.printf("Renda do cliente: ");
    this.setRenda(scan.nextDouble());
    System.out.printf("Quantidade de dependentes: ");
    int quant = scan.nextInt();
    List<String> depen = new ArrayList<>();
    scan.nextLine();
    for(int i=0;i<quant;i++) {
      System.out.printf("Nome do Dependente ["+i+"]: ");
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
      System.out.printf("Escolha: ");
      op = scan.nextInt();
      
      if(op == 1) {
        System.out.println("Nome atual: "+this.getNome());
        System.out.printf("Novo nome: ");
        this.setNome(scan.nextLine());
      }
      if(op == 2) {
        System.out.println("CPF atual: "+this.getCpf());
        System.out.printf("Novo CPF: ");
        this.setCpf(scan.nextLine());
      }
      else if(op == 3) {
        System.out.println("Renda atual: "+this.getRenda());
        System.out.printf("Nova Renda: ");
        this.setRenda(scan.nextDouble());
      }
      else if(op ==4) {
        this.endereco.altera();
      }

    }while(op!=5);
  }
}