package contabilidade;


public abstract class RegistroContabil {
	
	private String descricao;
	
	public RegistroContabil(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static RegistroContabil criarPlano(String descricao) {
		return new PlanoConta(descricao);
	}

	public static RegistroContabil criarLancamento(String descricao, double d) {
		return new Lancamento(descricao,d);
	}
	
	public abstract void adicionar(RegistroContabil r2);
	public abstract double sumarizar();

	public abstract String emitirExtrato();

}
