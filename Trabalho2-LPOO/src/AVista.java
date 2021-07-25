import java.util.*;

public class AVista extends Venda{
	private final double desconto = 0.10;
	private int tipo = 1;
	
	public void calculaValorFinal() {
		this.setValorFinal(this.getValor() - this.getValor() * this.desconto);
	}
	public void cadastra(List <Funcionarios> vendedores, List <Cliente> clientes, List <Veiculo> motos, List <Veiculo> carros) {
		super.cadastra(vendedores, clientes, motos, carros);
		this.calculaValorFinal();
		System.out.println("Valor final: " + this.getValorFinal() + "\nVenda realizada com sucesso!");
	}
}
