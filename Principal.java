import java.io.*;
import java.util.*;
public class Principal{
  public static void main(String[] args) {
    List<Funcionarios> gerentes=new ArrayList<>();
    List<Funcionarios> vendedores=new ArrayList<>();
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
          break;
        }
        else
          System.out.println("Login ou senha incorretos.");
      }
      //se quem logou foi gerente
      if(opLogin==1){
        // opções gerente
      }
      else{
        //opções vendedor
      }
    }while(opLogin!=3);
  }
}