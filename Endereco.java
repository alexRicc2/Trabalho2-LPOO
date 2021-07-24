public class Endereco {
  private String rua;
  private int numero;
  private String bairro;
  private String cidade;

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
}