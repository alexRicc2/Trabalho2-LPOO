import java.io.*;
import java.util.*;
public class Principal{
  public static void main(String[] args) {
    List<Funcionarios> gerentes=new ArrayList<>();
    List<Funcionarios> vendedores=new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Veiculo> carros = new ArrayList<>();
    List<Veiculo> motocicletas = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>(); 
    
    int logado=-1;//guarda o indice do funcionario logado.
    Scanner scan=new Scanner(System.in);
    int opLogin;
    String[] gerentesArq;
    //experiencia;login;senha;rg;nome;diaNasc;anoNas;mesNas;diaAdm;mesAdm;anoAdm;salario;
    Arquivo arq=new Arquivo();
    gerentesArq=arq.ler("gerentes.dat");
    //se não existirem gerentes no arquivo, cadastra um novo
    //ja que só gerentes podem criar outros usuarios.
    if(gerentesArq[0].equals("")){
      Gerente novo=new Gerente();
      novo.cadastra(gerentes);
    }
    else{
      //a cada 12 informações, se tem um novo gerente no arquivo.
      for(int i=0;i<gerentesArq.length;i+=12){
        gerentes.add(new Gerente(
        Integer.parseInt(gerentesArq[i]),//AnosExperiencia
        gerentesArq[i+1],//login
        gerentesArq[i+2],//senha
        gerentesArq[i+3],//rg
        gerentesArq[i+4],//nome
        new Data(Integer.parseInt(gerentesArq[i+5]),//diaNascimento
        Integer.parseInt(gerentesArq[i+6]),//mesNascimento
        Integer.parseInt(gerentesArq[i+7])),//anoNascimento
        new Data(Integer.parseInt(gerentesArq[i+8]),//diaAdmissao
        Integer.parseInt(gerentesArq[i+9]),//mesAdmissao
        Integer.parseInt(gerentesArq[i+10])),//anoAdmissao
        Double.parseDouble(gerentesArq[i+11])));//salario
      }
    }
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
        // opções gerente
    	  int opcao,op;
    	  do {
    		  
    		  System.out.println("---Menu Gerente---");
    		  System.out.println("1- Opções Clientes");
    		  System.out.println("2- Opções Veiculos");
    		  System.out.println("3- Opções Funcionarios");
    		  System.out.println("0- Deslogar como gerente");
    		  System.out.println("Sua escolha: ");
    		  opcao = scan.nextInt();
    		  
    		  if(opcao == 1) { //opcoes do gerente sobre clientes
    			  System.out.println("---Aba Clientes---");
    			  System.out.println("1- Cadastrar novo cliente");
    			  System.out.println("2- Alterar informações de um cliente");
    			  System.out.println("3- excluir um cliente");
    			  System.out.println("Sua escolha: ");
    			  op = scan.nextInt();
    			  
    			  if(op == 1) { //cadastrar cliente
    				  Cliente novo = new Cliente();
    				  novo.cadastra();
    				  clientes.add(novo);
    			  }
    			  else if(op == 2) { //alterar cliente
    				  for(int i=0;i<clientes.size();i++) {
    					  System.out.println("Cliente["+i+"]: "+ clientes.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do cliente que deseja alterar: ");
    				  clientes.get(scan.nextInt()).altera();
    			  }else if(op == 3) { //excluir cliente
    				  for(int i=0;i<clientes.size();i++) {
    					  System.out.println("Cliente["+i+"]: "+ clientes.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do cliente que deseja deletar: ");
    				  clientes.remove(scan.nextInt());
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
    			  if(op == 1) {
        			Carro novo = new Carro();
        			novo.cadastra();
        			carros.add(novo);
    			  }
    			  else if(op == 2) {
        			  Motocicleta novo = new Motocicleta();
        			  novo.cadastra();
        			  motocicletas.add(novo);
        		  }
    			  else if(op == 3) {
    				  for(int i=0;i<carros.size();i++) {    					  
    					  System.out.println("Carro["+i+"]: " +carros.get(i).getMarca() + " " + carros.get(i).getModelo());
    				  }
    				  System.out.println("Digite o indice do carro que deseja alterar: ");
    				  carros.get(scan.nextInt()).altera();
    			  }
    			  else if(op == 4) {
    				  for(int i=0;i<motocicletas.size();i++) {    					  
    					  System.out.println("Moto["+i+"]: " +motocicletas.get(i).getMarca() + " " + motocicletas.get(i).getModelo());
    				  }
    				  System.out.println("Digite o indice da moto que deseja alterar: ");
    				  motocicletas.get(scan.nextInt()).altera();
    			  }
    			  else if(op == 5) {
    				  for(int i=0;i<carros.size();i++) {    					  
    					  System.out.println("Carro["+i+"]: " +carros.get(i).getMarca() + " " + carros.get(i).getModelo());
    				  }
    				  System.out.println("Digite o indice do carro que deseja excluir: ");
    				  carros.remove(scan.nextInt());
    			  }
    			  else if(op == 6) {
    				  for(int i=0;i<motocicletas.size();i++) {    					  
    					  System.out.println("Moto["+i+"]: " +motocicletas.get(i).getMarca() + " " + motocicletas.get(i).getModelo());
    				  }
    				  System.out.println("Digite o indice da moto que deseja excluir: ");
    				  motocicletas.remove(scan.nextInt());
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
    			  System.out.println("7- informações de um vendedor");
    			  System.out.println("sua escolha: ");
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
    				  System.out.println("Digite o indice do gerente que deseja alterar: ");
    				  gerentes.get(scan.nextInt()).altera();
    			  }
    			  else if(op == 4) {
    				  for(int i=0;i<vendedores.size();i++) {
    					  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do vendedor que deseja alterar: ");
    				  vendedores.get(scan.nextInt()).altera();
    			  }
    			  else if(op == 5) {
    				  for(int i=0;i<gerentes.size();i++) {
    					  System.out.println("Gerente["+i+"]: " + gerentes.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do gerente que deseja excluir: ");
    				  gerentes.remove(scan.nextInt());
    			  }
    			  else if(op == 6) {
    				  for(int i=0;i<vendedores.size();i++) {
    					  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do vendedor que deseja excluir: ");
    				  vendedores.remove(scan.nextInt());
    			  }
    			  else if(op == 7) {
    				  for(int i=0;i<vendedores.size();i++) {
    					  System.out.println("Vendedor["+i+"]: " + vendedores.get(i).getNome());
    				  }
    				  System.out.println("Digite o indice do vendedor que deseja ver desempenho: ");
    				  vendedores.get(scan.nextInt()).getLogin();
    			  }
    		  }
    		  
    		  
    	  }while(opcao != 0);
    	 
      }
      else{
        //opções vendedor
    	  int opcao,op;
    	  do {
    		  
    		  System.out.println("--Menu vendedor--");
        	  System.out.println("1- Realizar uma venda");
        	  System.out.println("2- Mostrar veiculos");
        	  System.out.println("3- Mostrar clientes");
        	  System.out.println("4- Mostrar vendas");
        	  System.out.println("0- Deslogar como vendedor");
        	  System.out.println("sua escolha: ");
        	  opcao = scan.nextInt();
        	  
        	  if(opcao == 1) {
        		  System.out.println("1- Realizar compra a vista");
        		  System.out.println("2- Realizar compra a prazo");
        		  System.out.println("sua escolha: ");
        		  op = scan.nextInt();
        		  
        		  if(op == 1) {
        			  AVista novo = new AVista();
        			  novo.cadastra(vendedores, clientes, motocicletas, carros);
        			  vendas.add(novo);
        		  }
        		  else {
        			 APrazo novo = new APrazo();
        			 novo.cadastra(vendedores, clientes, motocicletas, carros);
        			 vendas.add(novo);
        		  }
        	  }
        	  else if(opcao == 4) {
        		  for(int i=0;i<vendas.size();i++) {
        			  System.out.println("Venda["+i+"]");
        			  vendas.get(i).mostraVenda();
        		  }
        	  }
    	  }while(opcao != 0);
    	  
      }
    }while(opLogin!=3);
  }
}