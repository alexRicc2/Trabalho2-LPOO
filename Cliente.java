import java.util.*;

public class Cliente {
  private String cpf;
  private String nome;
  private Data dataNasc;
  private Endereco endereco;
  private double renda;
  private List dependentes;

  public Cliente(String cpf, String nome, Data dataNasc, Endereco endereco, double renda, List list) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.endereco = endereco;
    this.renda = renda;
    this.dependentes = this.dependentes;
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

  public void setDependentes(List dependentes) {
    this.dependentes = dependentes;
  }
}