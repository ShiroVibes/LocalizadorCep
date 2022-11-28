package contabilidade;


public class Lancamento extends RegistroContabil {
	private double valor;
	
	public Lancamento(String descricao, double valor) {
		super(descricao);
		this.valor = valor;
	}
	
	@Override
	public void adicionar(RegistroContabil r2) {
		// nada implementado
	}
	
	@Override
	public double sumarizar() {
		return valor;
	}

	@Override
	public String emitirExtrato() {
		return "* " + this.getDescricao() + ":" + this.valor + "\n";
	}
	
	
	
}
