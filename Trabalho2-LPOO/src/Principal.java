import java.io.*;
import java.util.*;
public class Principal extends Arquivo{
  public static void main(String[] args) {
    List<Funcionarios> gerentes=new ArrayList<>();
    List<Funcionarios> vendedores=new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Carro> carros = new ArrayList<>();
    List<Motocicleta> motocicletas = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>(); 
    
    int logado=-1;//guarda o indice do funcionario logado.
    Scanner scan=new Scanner(System.in);
    int opLogin;
    Arquivo arq=new Arquivo();
    //le os arquivos
    arq.ler(gerentes,vendedores,clientes,carros,motocicletas,vendas);
    
    //logando gerente ou vendedor.
    do{
      //repetir até logar.
      while(true){
        System.out.printf("1 para logar como gerente, 2 para logar como vendedor, 3 para sair: ");
        opLogin=scan.nextInt();
        if(opLogin==3)break;
        boolean achou=false;
        System.out.printf("Digite seu login: ");
        String login=scan.next();
        System.out.printf("Digise sua senha: ");
        String senha=scan.next();
        if(opLogin==1){
          for(int i=0;i<gerentes.size();i++){
            if(gerentes.get(i).validaLogin(login,senha)){
              logado=i;//indice do funcionario logado
              achou=true;
              break;
            }
          }
        }
        else if(opLogin==2){
          for(int i=0;i<vendedores.size();i++){
            if(vendedores.get(i).validaLogin(login,senha)){
              logado=i;//indice do funcionario logado
              achou=true;
              break;
            }
          }
        }
        if(achou){
          System.out.printf("Logado como ");
          if(opLogin==1)
            System.out.printf("%s\n",gerentes.get(logado).getLogin());
          else
            System.out.printf("%s\n",vendedores.get(logado).getLogin());
          break; // sai do while(true)
        }
        else
          System.out.println("Login ou senha incorretos.");
      }
      //se quem logou foi gerente
      if(opLogin==1){
        // opcoes gerente
        int opcao,op;
        do {
          
          System.out.println("---Menu Gerente---");
          System.out.println("1- Opcoes Clientes");
          System.out.println("2- Opcoes Veiculos");
          System.out.println("3- Opcoes Funcionarios");
          System.out.println("0- Deslogar como gerente");
          System.out.printf("Sua escolha: ");
          opcao = scan.nextInt();
          
          if(opcao == 1) { //opcoes do gerente sobre clientes
            System.out.println("---Aba Clientes---");
            System.out.println("1- Cadastrar novo cliente");
            System.out.println("2- Alterar informacoes de um cliente");
            System.out.println("3- excluir um cliente");
            System.out.printf("Sua escolha: ");
            op = scan.nextInt();
            
            if(op == 1) { //cadastrar cliente
              Cliente novo = new Cliente();
              novo.cadastra();
              clientes.add(novo);
            }
            else if(op == 2) { //alterar cliente
              if(clientes.size()==0)
                System.out.println("Nao existem clientes cadastrados.");
              else{
                for(int i=0;i<clientes.size();i++) {
                  System.out.println("Cliente["+i+"]: "+ clientes.get(i).getNome());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do cliente que deseja alterar: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=clientes.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                clientes.get(indice).altera();
              }
            }else if(op == 3) { //excluir cliente
              if(clientes.size()==0)
                System.out.println("Nao existem clientes cadastrados.");
              else{
                for(int i=0;i<clientes.size();i++) {
                  System.out.println("Cliente["+i+"]: "+ clientes.get(i).getNome());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do cliente que deseja remover: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=clientes.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                clientes.remove(indice);
              }
            }
          }
          else if(opcao == 2) {//opcoes do gerente sobre veiculos
            
            System.out.println("---Aba Veiculos---");
            System.out.println("1- Cadastrar um carro");
            System.out.println("2- Cadastrar uma moto");
            System.out.println("3- Alterar um carro");
            System.out.println("4- Alterar uma moto");
            System.out.println("5- Excluir um carro");
            System.out.println("6- Excluir uma moto");
            System.out.println("sua escolha: ");
            op = scan.nextInt();
            if(op == 1 || op == 2) {
              int chassi;
              boolean achou;
              while(true){
                achou=false;
                System.out.printf("Digite o numero do chassi: ");
                chassi=scan.nextInt();
                for(int i=0;i<carros.size();i++){
                  if(carros.get(i).getNumeroChassi()==chassi){
                    System.out.println("Chassi ja existente.");
                    achou=true;
                    break;
                  }
                }
                if(!achou){
                  for(int i=0;i<motocicletas.size();i++){
                    if(motocicletas.get(i).getNumeroChassi()==chassi){
                      System.out.println("Chassi ja existente.");
                      achou=true;
                      break;
                    }
                  }
                }
                if(!achou)
                  break;
              }
              if(op==1){
                Carro novo = new Carro();
                novo.cadastra(chassi);
                carros.add(novo);
              }
              else{
                Motocicleta novo = new Motocicleta();
                novo.cadastra(chassi);
                motocicletas.add(novo);
              }
            }
            else if(op == 3) {
              if(carros.size()==0)
                System.out.println("Nao existem carros cadastrados.");
              else{
                for(int i=0;i<carros.size();i++) {                
                  System.out.println("Carro["+i+"]: " +carros.get(i).getMarca() + " " + carros.get(i).getModelo());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do carro que deseja alterar: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=carros.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                carros.get(indice).altera();
              }
            }
            else if(op == 4) {
              if(carros.size()==0)
                System.out.println("Nao existem motos cadastradas.");
              else{
                for(int i=0;i<motocicletas.size();i++) {                
                  System.out.println("Moto["+i+"]: " +motocicletas.get(i).getMarca() + " " + motocicletas.get(i).getModelo());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice da moto que deseja alterar: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=motocicletas.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                motocicletas.get(indice).altera();
              }
            }
            else if(op == 5) {
              if(carros.size()==0)
                System.out.println("Nao existem carros cadastrados.");
              else{
                for(int i=0;i<carros.size();i++) {                
                  System.out.println("Carro["+i+"]: " +carros.get(i).getMarca() + " " + carros.get(i).getModelo());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do carro que deseja excluir: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=carros.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                carros.remove(indice);
              }
            }
            else if(op == 6) {
              if(carros.size()==0)
                System.out.println("Nao existem motos cadastradas.");
              else{
                for(int i=0;i<motocicletas.size();i++) {                
                  System.out.println("Moto["+i+"]: " +motocicletas.get(i).getMarca() + " " + motocicletas.get(i).getModelo());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice da motocicleta que deseja excluir: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=motocicletas.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                motocicletas.remove(indice);
              }
            }
          }
          else if(opcao == 3) { //opcoes do gerente sobre funcionarios
            System.out.println("--aba funcionarios--");
            System.out.println("1- Registrar novo gerente");
            System.out.println("2- Registrar novo vendedor");
            System.out.println("3- Alterar gerente");
            System.out.println("4- Alterar vendendor");
            System.out.println("5- excluir gerente");
            System.out.println("6- excluir vendedor");
            System.out.println("7- informacoes de um vendedor");
            System.out.printf("sua escolha: ");
            op = scan.nextInt();
            if(op == 1) {
            Gerente novo = new Gerente();
            novo.cadastra(gerentes);
            }
            else if(op == 2) {
            Vendedor novo = new Vendedor();
            novo.cadastra(vendedores,gerentes);
            vendedores.add(novo);
            }
            else if(op == 3) {
              for(int i=0;i<gerentes.size();i++) {
                System.out.println("Gerente["+i+"]: " + gerentes.get(i).getNome());
              }
              int indice;
              while(true){
                System.out.printf("Digite o indice do gerente que deseja alterar: ");
                indice=scan.nextInt();
                if(indice<0 || indice>=gerentes.size())
                  System.out.println("Indice invalido.");
                else
                  break;
              }
              gerentes.get(indice).altera();
            }
            else if(op == 4) {
              if(vendedores.size()==0)
                System.out.println("Nao existem vendedores cadastrados.");
              else{
                for(int i=0;i<vendedores.size();i++) {
                  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do vendedor que deseja alterar: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=vendedores.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                vendedores.get(scan.nextInt()).altera();
              }
            }
            else if(op == 5) {
              if(gerentes.size()==1)
                System.out.println("Deve haver pelomenos um gerente.");
              else{
                for(int i=0;i<gerentes.size();i++) {
                  System.out.println("Gerente["+i+"]: " + gerentes.get(i).getNome());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do gerente que deseja excluir: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=gerentes.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                gerentes.remove(indice);
              }
            }
            else if(op == 6) {
              if(vendedores.size()==0)
                System.out.println("Nao existem vendedores cadastrados.");
              else{
                for(int i=0;i<vendedores.size();i++) {
                  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
                }
                int indice;
                while(true){
                  System.out.printf("Digite o indice do vendedor que deseja excluir: ");
                  indice=scan.nextInt();
                  if(indice<0 || indice>=vendedores.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                vendedores.remove(indice);
              }
            }
            else if(op == 7) {
              if(vendedores.size()==0)
                System.out.println("Nao existem vendedores cadastrados.");
              else{
                for(int i=0;i<vendedores.size();i++) {
                  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
                }
                int indiceVendedor;
                while(true){
                  System.out.printf("Digite o indice do vendedor que deseja ver desempenho: ");
                  indiceVendedor=scan.nextInt();
                  if(indiceVendedor<0 || indiceVendedor>=vendedores.size())
                    System.out.println("Indice invalido.");
                  else
                    break;
                }
                for(int i=0;i<vendas.size() && vendas.size()!=0;i++) {
                  if(vendas.get(i).getVendedor()==vendedores.get(indiceVendedor)){
                    vendas.get(i).mostraVenda();
                    System.out.println("/-----------------/");
                  }
                }
              }
            }
          }
        }while(opcao != 0);
      }
      else if(opLogin==2){
        //opcoes vendedor
        int opcao,op;
        do {
          
          System.out.println("--Menu vendedor--");
            System.out.println("1- Realizar uma venda");
            System.out.println("2- Mostrar veiculos");
            System.out.println("3- Mostrar clientes");
            System.out.println("4- Mostrar vendas");
            System.out.println("0- Deslogar como vendedor");
            System.out.printf("sua escolha: ");
            opcao = scan.nextInt();
            
            if(opcao == 1) {
              if(clientes.size()==0)
                System.out.println("Nao existem clientes cadastrados.");
              else if(carros.size()==0 && motocicletas.size()==0)
                System.out.println("Nao existem veiculos cadastrados.");
              else{
              System.out.println("1- Realizar venda a vista");
              System.out.println("2- Realizar venda a prazo");
              System.out.printf("sua escolha: ");
              op = scan.nextInt();
              
              if(op == 1) {
                AVista novo = new AVista();
                if(novo.cadastra(vendas, vendedores.get(logado), clientes, motocicletas, carros))
                  vendas.add(novo);
              }
              else {
                APrazo novo = new APrazo();
                if(novo.cadastra(vendas, vendedores.get(logado), clientes, motocicletas, carros))
                  vendas.add(novo);
              }
            }
            }
            else if(opcao==2){
              System.out.println("1- Carros");
              System.out.println("2- motocicletas");
              System.out.println("sua escolha: ");
              int opcao2=scan.nextInt();
              if(opcao2==1){
                if(carros.size()==0)
                  System.out.println("Nao existem carros cadastrados.");
                for(int i=0;i<carros.size() && carros.size()!=0;i++){
                  carros.get(i).printCarro();
                  System.out.println("/--------------------/");
                }
              }
              else{
                if(motocicletas.size()==0)
                  System.out.println("Nao existem motocicletas cadastradas.");
                for(int i=0;i<motocicletas.size() && motocicletas.size()!=0;i++){
                  motocicletas.get(i).printMotocicleta();
                  System.out.println("/--------------------/");
                }
              }
            }
            else if(opcao == 3){
              if(clientes.size()==0)
                System.out.println("Nao existem clientes cadastrados.");
              for(int i=0;i<clientes.size() && clientes.size()!=0;i++){
                clientes.get(i).printCliente();
                System.out.println("/--------------------/");
              }
            }
            else if(opcao == 4) {
              if(vendas.size()==0)
                System.out.println("Nao existem vendas.");
              for(int i=0;i<vendas.size() && vendas.size()!=0;i++) {
                vendas.get(i).mostraVenda();
                System.out.println("/--------------------/");
              }
            }
        }while(opcao != 0);
      }
    }while(opLogin!=3);
    arq.escrever(gerentes,vendedores,clientes,carros,motocicletas,vendas);
  }
}