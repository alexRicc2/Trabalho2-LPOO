
public class Data {

	private double Dia;
	private double Mes;
	private double Ano;
	
	public Data(double dia, double mes, double ano) {
		this.Dia = dia;
		this.Mes = mes;
		this.Ano = ano;
	}
	
	public double getDia() {
		return Dia;
	}
	public void setDia(double dia) {
		Dia = dia;
	}
	public double getMes() {
		return Mes;
	}
	public void setMes(double mes) {
		Mes = mes;
	}
	public double getAno() {
		return Ano;
	}
	public void setAno(double ano) {
		Ano = ano;
	}
	public void dataFormatada() {
		System.out.println("Data: "+this.getDia()+"/"+this.getMes()+"/"+this.getAno());
	}
	
	
}
