import java.io.*;
import java.util.*;
public abstract class Arquivo{
  //função auxiliar.
  public static String[] lerAux(String arq){
    String[] dados2;
    String dados="";
    //tava tendo q inicializar pra poder retornar caso o try falhasse
    dados2=dados.split("");
    try{
      FileReader arquivo=new FileReader(arq);
      BufferedReader reader=new BufferedReader(arquivo);
      while(reader.ready()){
        dados=dados+reader.readLine();
      }
      reader.close();
      arquivo.close();
      dados2=dados.split(";");
    }
    catch(IOException e){
      System.out.println("Erro.");
    }
    return dados2;
  }
  
  //pega todas as informações dos arquivos.
  public static void ler(List<Funcionarios> gerentes,List<Funcionarios> vendedores,List<Cliente> clientes,List<Carro> carros,List<Motocicleta> motocicletas,List<Venda> vendas){
    String[] gerentesArq,vendedoresArq,clientesArq,carrosArq,motocicletasArq,aVistaArq,aPrazoArq;
    gerentesArq=lerAux("gerentes.dat");
    vendedoresArq=lerAux("vendedores.dat");
    clientesArq=lerAux("clientes.dat");
    carrosArq=lerAux("carros.dat");
    motocicletasArq=lerAux("motocicletas.dat");
    aVistaArq=lerAux("avista.dat");
    aPrazoArq=lerAux("aprazo.dat");
    
    //se não existirem gerentes no arquivo, cadastra um novo
    //ja que só gerentes podem criar outros usuarios.
    if(gerentesArq[0].equals("")){
      Gerente novo=new Gerente();
      novo.cadastra(gerentes);
    }
    else{
      //a cada 12 informações, se tem um novo gerente no arquivo.
      //experiencia;login;senha;rg;nome;diaNasc;anoNas;mesNas;diaAdm;mesAdm;anoAdm;salario;
      for(int i=0;i<gerentesArq.length;i+=12){
        gerentes.add(new Gerente(
        Integer.parseInt(gerentesArq[i]),//AnosExperiencia
        gerentesArq[i+1],//login
        gerentesArq[i+2],//senha
        gerentesArq[i+3],//rg
        gerentesArq[i+4],//nome
        new Data(
        Integer.parseInt(gerentesArq[i+5]),//diaNascimento
        Integer.parseInt(gerentesArq[i+6]),//mesNascimento
        Integer.parseInt(gerentesArq[i+7])//anoNascimento
        ),
        new Data(
        Integer.parseInt(gerentesArq[i+8]),//diaAdmissao
        Integer.parseInt(gerentesArq[i+9]),//mesAdmissao
        Integer.parseInt(gerentesArq[i+10])//anoAdmissao
        ),
        Double.parseDouble(gerentesArq[i+11])//salario
        ));
      }
    }
    //treinamento;loginGerente;login;senha;rg;nome;diaNasc;mesNasc;anoNasc;diaAdm;mesAdm;anoAdm;salario;
    if(vendedoresArq[0]!=""){
      Funcionarios aux=new Gerente();
      for(int i=0;i<vendedoresArq.length;i+=13){
        //pegando o gerente responsavel.
        for(int j=0;j<gerentes.size();j++){
          if(gerentes.get(i).getLogin()==vendedoresArq[i+1])
            aux=gerentes.get(i);
        }
        //adicionando ao arraylist
        vendedores.add(new Vendedor(
        Integer.parseInt(vendedoresArq[i]),//treinamento
        aux,//responsavel
        vendedoresArq[i+2],//login
        vendedoresArq[i+3],//senha
        vendedoresArq[i+4],//rg
        vendedoresArq[i+5],//nome
        new Data(
        Integer.parseInt(vendedoresArq[i+6]),//diaNasc
        Integer.parseInt(vendedoresArq[i+7]),//mesNasc
        Integer.parseInt(vendedoresArq[i+8])//anoNasc
        ),
        new Data(
        Integer.parseInt(vendedoresArq[i+9]),//diaAdm
        Integer.parseInt(vendedoresArq[i+10]),//mesAdm
        Integer.parseInt(vendedoresArq[i+11])//anoAdm
        ),
        Double.parseDouble(vendedoresArq[i+12])//salario
        ));
      }
    }
    // dep1:dep2:dep3:;cpf;nome;diaNasc;mesNasc;anoNasc;rua;numero;bairro;cidade;renda
    if(clientesArq[0]!=""){
      for(int i=0;i<clientesArq.length;i+=11){
        //pegando dependentes se tiver
        List<String> dependentes=new ArrayList<>();
        dependentes.add("semDependentes");
        if(clientesArq[i]!="semDependentes"){
          dependentes.remove(0);
          String[] dependentesArq=clientesArq[i].split(":");
          for(int j=0;j<dependentesArq.length;j++){
            dependentes.add(dependentesArq[j]);
          }
        }
        
        clientes.add(new Cliente(
        clientesArq[i+1],//cpf
        clientesArq[i+2],//nome
        new Data(
        Integer.parseInt(clientesArq[i+3]),//diaNasc
        Integer.parseInt(clientesArq[i+4]),//mesNasc
        Integer.parseInt(clientesArq[i+5])//anoNasc
        ),
        new Endereco(
        clientesArq[i+6],//rua
        Integer.parseInt(clientesArq[i+7]),//numero
        clientesArq[i+8],//bairro
        clientesArq[i+9]//cidade
        ),
        Double.parseDouble(clientesArq[i+10]),//renda
        dependentes//arraylist de dependentes
        ));
      }
    }
   
    if(carrosArq[0]!=""){
      for(int i=0;i<carrosArq.length;i+=15){
        carros.add(new Carro(
        Integer.parseInt(carrosArq[i]),//potencia
        Integer.parseInt(carrosArq[i+1]),//cilindros
        Integer.parseInt(carrosArq[i+2]),//ocupantes
        Integer.parseInt(carrosArq[i+3]),//tipo
        Double.parseDouble(carrosArq[i+4]),//altura
        Double.parseDouble(carrosArq[i+5]),//largura
        Double.parseDouble(carrosArq[i+6]),//comprimento
        Integer.parseInt(carrosArq[i+7]),//chassi
        carrosArq[i+8],//marca
        carrosArq[i+9],//modelo
        Integer.parseInt(carrosArq[i+10]),//ano
        Integer.parseInt(carrosArq[i+11]),//km
        Integer.parseInt(carrosArq[i+12]),//combustivel
        Double.parseDouble(carrosArq[i+13]),//peso
        Boolean.parseBoolean(carrosArq[i+14])//status
        ));
      }
    }
    
    if(motocicletasArq[0]!=""){
      for(int i=0;i<motocicletasArq.length;i+=10){
        motocicletas.add(new Motocicleta(
        Integer.parseInt(motocicletasArq[i]),//Cilindradas
        Integer.parseInt(motocicletasArq[i+1]),//tipo
        Integer.parseInt(motocicletasArq[i+2]),//chassi
        motocicletasArq[i+3],//marca
        motocicletasArq[i+4],//modelo
        Integer.parseInt(motocicletasArq[i+5]),//ano
        Integer.parseInt(motocicletasArq[i+6]),//km
        Integer.parseInt(motocicletasArq[i+7]),//combustivel
        Double.parseDouble(motocicletasArq[i+8]),//peso
        Boolean.parseBoolean(carrosArq[i+9])//status
        ));
      }
    }
    
    // id;loginVendedor;cpfCliente;chassi;valor;dia;mes;ano;hora;min;
    if(aVistaArq[0]!=""){
      Funcionarios vendedor=new Vendedor();
      Cliente cliente=new Cliente();
      Veiculo veiculo=new Veiculo();
      
      for(int i=0;i<aVistaArq.length;i+=10){
        //encontrando vendedor
        for(int j=0;j<vendedores.size();j++){
          if(vendedores.get(j).getLogin().equals(aVistaArq[i+1])){
            vendedor=vendedores.get(j);
            break;
          }
        }
        //encontrando cliente
        for(int j=0;j<clientes.size();j++){
          if(clientes.get(j).getCpf().equals(aVistaArq[i+2])){
            cliente=clientes.get(j);
            break;
          }
        }
        //encontrando veiculo
        for(int j=0;j<carros.size();j++){
          if(carros.get(j).getNumeroChassi()==Integer.parseInt(aVistaArq[i+3]))
            veiculo=carros.get(j);
            break;
        }
        for(int j=0;j<motocicletas.size();j++){
          if(motocicletas.get(j).getNumeroChassi()==Integer.parseInt(aVistaArq[i+3]))
            veiculo=motocicletas.get(j);
            break;
        }
        //adicionando ao arraylist
        vendas.add(new AVista(
          Integer.parseInt(aVistaArq[i]),//id
          vendedor,
          cliente,
          veiculo,
          Double.parseDouble(aVistaArq[i+4]),//valor
          new Data(
          Integer.parseInt(aVistaArq[i+5]),//dia
          Integer.parseInt(aVistaArq[i+6]),//mes
          Integer.parseInt(aVistaArq[i+7])//ano
          ),
          new Hora(
          Integer.parseInt(aVistaArq[i+8]),//hora
          Integer.parseInt(aVistaArq[i+9])//minuto
          )
        ));
      }
    }
    // int id, Funcionarios vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data, Hora hora, int quantPrazos
    if(aPrazoArq[0]!=""){
      Funcionarios vendedor=new Vendedor();
      Cliente cliente=new Cliente();
      Veiculo veiculo=new Veiculo();
      
      for(int i=0;i<aPrazoArq.length;i+=11){
        //encontrando vendedor
        for(int j=0;j<vendedores.size();j++){
          if(vendedores.get(j).getLogin().equals(aPrazoArq[i+1])){
            vendedor=vendedores.get(j);
            break;
          }
        }
        //encontrando cliente
        for(int j=0;j<clientes.size();j++){
          if(clientes.get(j).getCpf().equals(aPrazoArq[i+2])){
            cliente=clientes.get(j);
            break;
          }
        }
        //encontrando veiculo
        for(int j=0;j<carros.size();j++){
          if(carros.get(j).getNumeroChassi()==Integer.parseInt(aPrazoArq[i+3]))
            veiculo=carros.get(j);
            break;
        }
        for(int j=0;j<motocicletas.size();j++){
          if(motocicletas.get(j).getNumeroChassi()==Integer.parseInt(aPrazoArq[i+3]))
            veiculo=motocicletas.get(j);
            break;
        }
        //adicionando ao arraylist
        vendas.add(new APrazo(
          Integer.parseInt(aPrazoArq[i]),//id
          vendedor,
          cliente,
          veiculo,
          Double.parseDouble(aPrazoArq[i+4]),//valor
          new Data(
          Integer.parseInt(aPrazoArq[i+5]),//dia
          Integer.parseInt(aPrazoArq[i+6]),//mes
          Integer.parseInt(aPrazoArq[i+7])//ano
          ),
          new Hora(
          Integer.parseInt(aPrazoArq[i+8]),//hora
          Integer.parseInt(aPrazoArq[i+9])//minuto
          ),
          Integer.parseInt(aPrazoArq[i+10])//parcelas
        ));
      }
    }
    
  }
  // public static void escrever(String arq,ArrayList<Livro> livros){
  //   try{
  //     File arquivo;
  //     arquivo=new File(arq);
  //     FileWriter escrever=new FileWriter(arquivo,false);
  //     for(int i=0;i<livros.size();i++){
  //       //isbn;titulo;autor1:autor2:autor3;editora;anoPub;numPags;
  //       escrever.write(livros.get(i).getIsbn()+";"+livros.get(i).getTitulo()+";");
  //       for(int j=0;j<livros.get(i).getAutores().size();j++){
  //         escrever.write(livros.get(i).getAutores().get(j)+":");
  //       }
  //       escrever.write(";"+livros.get(i).getEditora()+";"+livros.get(i).getAnoPublicacao()+";"+livros.get(i).getNumPags()+";"+"\n");
  //     }
  //     escrever.close();
  //   }
  //   catch(IOException e){
  //     System.out.println("Erro.");
  //   }
  // }
}