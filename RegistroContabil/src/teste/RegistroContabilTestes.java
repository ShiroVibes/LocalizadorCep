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
		RegistroContabil r3 = RegistroContabil.criarPlano("1.0.0.0.1.1 - Despesas Bens Duraveis");
		RegistroContabil r4 = RegistroContabil.criarPlano("1.0.0.0.1.2 - Despesas Bens Nao-Duraveis");
		r2.adicionar(r3);
		r2.adicionar(r4);
		RegistroContabil r5 = RegistroContabil.criarPlano("1.0.0.0.2 - Receitas");
		r1.adicionar(r5);
		
		RegistroContabil d3 = RegistroContabil.criarLancamento("Cafe", -150);
		r4.adicionar(d3);
		
		RegistroContabil d1 = RegistroContabil.criarLancamento("Compra ar-condicionado autorregulavel",-2100.00);
		r3.adicionar(d1);
		
		RegistroContabil d2 = RegistroContabil.criarLancamento("Salario",5000.00);
		r5.adicionar(d2);
		
		Assert.assertEquals(2750.00, r1.sumarizar(), 0.01);
		
	}
	
	@Test 
	public void emitirExtrato() {

		RegistroContabil r1 = RegistroContabil.criarPlano("1.0.0.0 - Fluxo Geral");
		RegistroContabil r2 = RegistroContabil.criarPlano("1.0.0.0.1 - Despesas de Consumo");
		r1.adicionar(r2);
		RegistroContabil r3 = RegistroContabil.criarPlano("1.0.0.0.1.1 - Despesas Bens Duraveis");
		RegistroContabil r4 = RegistroContabil.criarPlano("1.0.0.0.1.2 - Despesas Bens Nao-Duraveis");
		r2.adicionar(r3);
		r2.adicionar(r4);
		RegistroContabil d3 = RegistroContabil.criarLancamento("Cafe", -150.00);
		r4.adicionar(d3);
		RegistroContabil d1 = RegistroContabil.criarLancamento("Compra ar-condicionado autorregulavel",-2100.00);
		r3.adicionar(d1);
		
		String extratoObtido = r1.emitirExtrato();
		String extratoResult = 	"1.0.0.0 - Fluxo Geral\n" +
								"1.0.0.0.1 - Despesas de Consumo\n" +
								"1.0.0.0.1.1 - Despesas Bens Duraveis\n" +
								"* Compra ar-condicionado autorregulavel:-2100.0\n" +
								"1.0.0.0.1.2 - Despesas Bens Nao-Duraveis\n" +
								"* Cafe:-150.0\n";
		Assert.assertEquals(extratoResult, extratoObtido);
		
	}
	
	
	
}
