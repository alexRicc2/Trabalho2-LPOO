import java.io.*;
import java.util.*;
public class Arquivo{
  //função auxiliar.
  public static String[] lerAux(String arq){
    String[] dados2;
    String dados="";
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
      
    }
    return dados2;
  }
  
  //pega todas as informações dos arquivos.
  public void ler(List<Funcionarios> gerentes,List<Funcionarios> vendedores,List<Cliente> clientes,List<Carro> carros,List<Motocicleta> motocicletas,List<Venda> vendas){
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
      Veiculo veiculo=new Carro();
      
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
      Veiculo veiculo=new Carro();
      
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
          if(carros.get(j).getNumeroChassi()==Integer.parseInt(aPrazoArq[i+3])){
            veiculo=carros.get(j);
            break;
          }
        }
        for(int j=0;j<motocicletas.size();j++){
          if(motocicletas.get(j).getNumeroChassi()==Integer.parseInt(aPrazoArq[i+3])){
            veiculo=motocicletas.get(j);
            break;
          }
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
  public void escrever(List<Funcionarios> gerentes,List<Funcionarios> vendedores,List<Cliente> clientes,
  List<Carro> carros,List<Motocicleta> motocicletas,List<Venda> vendas){
    // avista.dat
    // aprazo.dat
    try{
      File arquivo;
      arquivo=new File("gerentes.dat");
      FileWriter escrever=new FileWriter(arquivo,false);
      for(int i=0;i<gerentes.size();i++){
        Funcionarios gerente=gerentes.get(i);
        //experiencia;login;senha;rg;nome;diaNasc;anoNas;mesNas;diaAdm;mesAdm;anoAdm;salario;
        escrever.write(gerente.getAnosExperiencia()+";"+gerente.getLogin()+";"+gerente.getSenha()+";"+gerente.getRg()+";"+gerente.getNome()+";"+gerente.getDataNasc().getDia()
        +";"+gerente.getDataNasc().getMes()+";"+gerente.getDataNasc().getAno()+";"+gerente.getDataAdmissao().getDia()+";"+gerente.getDataAdmissao().getMes()
        +";"+gerente.getDataAdmissao().getAno()+";"+gerente.getSalario()+";\n");
      }
      arquivo=new File("vendedores.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      for(int i=0;i<vendedores.size();i++){
        Funcionarios vendedor=vendedores.get(i);
        //treinamento;loginGerente;login;senha;rg;nome;diaNasc;mesNasc;anoNasc;diaAdm;mesAdm;anoAdm;salario;
        escrever.write(vendedor.getTreinamentoRestante()+";"+vendedor.getResponsavel().getLogin()+";"+vendedor.getLogin()+";"+vendedor.getSenha()+";"+vendedor.getRg()
        +";"+vendedor.getNome()+";"+vendedor.getDataNasc().getDia()+";"+vendedor.getDataNasc().getMes()+";"+vendedor.getDataNasc().getAno()+";"+vendedor.getDataAdmissao().getDia()+";"+vendedor.getDataAdmissao().getMes()
        +";"+vendedor.getDataAdmissao().getAno()+";"+vendedor.getSalario()+";\n");
      }
      arquivo=new File("clientes.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      // dep1:dep2:dep3:;cpf;nome;diaNasc;mesNasc;anoNasc;rua;numero;bairro;cidade;renda
      for(int i=0;i<clientes.size();i++){
        Cliente cliente=clientes.get(i);
        for(int j=0;j<cliente.getDependentes().size();j++)
          escrever.write(cliente.getDependentes().get(j)+":");
        escrever.write(";"+cliente.getCpf()+";"+cliente.getNome()+";"+cliente.getDataNasc().getDia()+";"+
        cliente.getDataNasc().getMes()+";"+cliente.getDataNasc().getAno()+";"+cliente.getEndereco().getRua()
        +";"+cliente.getEndereco().getNumero()+";"+cliente.getEndereco().getBairro()+";"+cliente.getEndereco().getCidade()
        +";"+cliente.getRenda()+";\n");
      }
      arquivo=new File("carros.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      // potencia;cilindros;ocupantes;tipo;altura;largura;comprimento;chassi;marca;modelo;ano;km;combustivel;peso;status;
      for(int i=0;i<carros.size();i++){
        Carro carro=carros.get(i);
        escrever.write(carro.getPotencia()+";"+carro.getNumeroCilindros()+";"+carro.getNumeroOcupantes()+";"+carro.getTipo()+";"+carro.getAltura()
        +";"+carro.getLargura()+";"+carro.getComprimento()+";"+carro.getNumeroChassi()+";"+carro.getMarca()+";"+carro.getModelo()+";"+carro.getAno()+";"+carro.getKm()+";"+carro.getTipoCombustivel()
        +";"+carro.getPeso()+";"+carro.getStatus()+";\n");
      }
      arquivo=new File("motocicletas.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      // cilindradas;tipo;chassi;marca;modelo;ano;km;combustive;peso;status;
      for(int i=0;i<motocicletas.size();i++){
        Motocicleta moto=motocicletas.get(i);
        escrever.write(moto.getCilindradas()+";"+moto.getTipo()+";"+moto.getNumeroChassi()+";"+moto.getMarca()
        +";"+moto.getModelo()+";"+moto.getAno()+";"+moto.getKm()+";"+moto.getTipoCombustivel()+";"+moto.getPeso()
        +";"+moto.getStatus()+";\n");
      }
      arquivo=new File("avista.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      // id;loginVendedor;cpfCliente;chassi;valor;dia;mes;ano;hora;min;
      for(int i=0;i<vendas.size();i++){
        Venda venda=vendas.get(i);
        if(venda instanceof AVista){
          escrever.write(venda.getId()+";"+venda.getVendedor().getLogin()+";"+venda.getCliente().getCpf()+";"+
          venda.getVeiculo().getNumeroChassi()+";"+venda.getValor()+";"+venda.getData().getDia()+";"+
          venda.getData().getMes()+";"+venda.getData().getAno()+";"+venda.getHora().getHora()+";"+
          venda.getHora().getMinuto()+";\n");
        }
      }
      escrever.close();
      arquivo=new File("aprazo.dat");
      escrever.close();
      escrever=new FileWriter(arquivo,false);
      // id;loginVendedor;cpfCliente;chassi;valor;dia;mes;ano;hora;min;
      for(int i=0;i<vendas.size();i++){
        Venda venda=vendas.get(i);
        if(venda instanceof APrazo){
          escrever.write(venda.getId()+";"+venda.getVendedor().getLogin()+";"+venda.getCliente().getCpf()+";"+
          venda.getVeiculo().getNumeroChassi()+";"+venda.getValor()+";"+venda.getData().getDia()+";"+
          venda.getData().getMes()+";"+venda.getData().getAno()+";"+venda.getHora().getHora()+";"+
          venda.getHora().getMinuto()+";"+venda.getQuantPrazos()+";\n");
        }
      }
      escrever.close();
    }
    catch(IOException e){
     
    }
  }
}