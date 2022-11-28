package teste;

import org.junit.Assert;
import org.junit.Test;

import contabilidade.RegistroContabil;

public class RegistroContabilTestes {

	@Test
	public void CriaRegistroContabilTeste() {
		
		RegistroContabil r1 = RegistroContabil.criarPlano("1.0.0.0 - Fluxo Geral");
		RegistroContabil r2 = RegistroContabil.criarPlano("1.0.0.0.1 - Despesas de Consumo");
		r1.adicionar(r2);
		RegistroContabil r3 = RegistroContabil.criarPlano("1.0.0.0.0.1 - Despesas Bens Duráveis");
		RegistroContabil r4 = RegistroContabil.criarPlano("1.0.0.0.0.2 - Despesas Bens Não-Duráveis");
		r2.adicionar(r3);
		r2.adicionar(r4);
		RegistroContabil r5 = RegistroContabil.criarPlano("2.0.0.0.1 - Receitas");
		r1.adicionar(r5);
		
		RegistroContabil d1 = RegistroContabil.criarDespesa("Compra ar-condicionado autorregulável",2100.00);
		r3.adicionar(d1);
		
		RegistroContabil d2 = RegistroContabil.criarReceita("Salário",5000.00);
		r5.adicionar(d2);
		
		Assert.assertEquals(2900.00, r1.sumarizar(), 0.01);
		
	}
	
	
}
