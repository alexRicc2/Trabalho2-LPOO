import java.io.*;
import java.util.*;
public class Arquivo{
  public String[] ler(String arq){
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