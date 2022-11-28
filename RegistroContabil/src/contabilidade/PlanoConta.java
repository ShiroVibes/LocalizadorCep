package contabilidade;

import java.util.ArrayList;
import java.util.List;


public class PlanoConta extends RegistroContabil {
	
	private List<RegistroContabil> elementos = new ArrayList<RegistroContabil>();
	
	public PlanoConta(String descricao) {
		super(descricao);
	}
	
	@Override
	public void adicionar(RegistroContabil r2) {
		elementos.add(r2);
	}

	@Override
	public double sumarizar() {
		double total = 0;
		for (RegistroContabil rc: elementos){
			total = total + rc.sumarizar();
		}
		return total;
	}

	@Override
	public String emitirExtrato() {
		String textoParcial = this.getDescricao() + "\n";
		for (RegistroContabil rc: elementos){
			textoParcial = textoParcial + rc.emitirExtrato();
		}		
		return textoParcial;
	}
}
