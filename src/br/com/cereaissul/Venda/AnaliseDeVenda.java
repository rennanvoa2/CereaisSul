package br.com.cereaissul.Venda;

import br.com.cereaissul.Compra.CompraBean;
import br.com.cereaissul.Frete.FreteVenda;
import br.com.cereaissul.Parametros.Parametros;
import br.com.cereaissul.PisCofins.PisCofins;
import br.com.cereaissul.TransformaReais.TransformaReais;
import br.com.cereaissul.impostos.Icms.IcmsVenda;

public class AnaliseDeVenda {

	public VendaBean calculaAnaliseDeVenda(Parametros param, CompraBean analise) {

		VendaBean venda = new VendaBean();
		IcmsVenda icms = new IcmsVenda();

		venda.setCustoTotalDeCompra(analise.getCustoTotalDeCompra());
		venda.setValorDeVenda(param.getValorDeVenda());
		FreteVenda frete = new FreteVenda();
		PisCofins pc = new PisCofins();
		TransformaReais tr = new TransformaReais();

		
		//Checa se Tem frete de Venda e calcula o valor
		venda.setValorFreteVenda(frete.calculaFreteVenda(param));

		//Calcula o valor do PIS e COFINS
		venda.setValorPisECofins(venda.getValorDeVenda() * pc.calculaPisCofins(param));
		
		//Calcula o valor do ICMS de venda
		venda.setValorIcmsVenda(icms.calculaIcmsVenda(param, venda));

		
		//Checa se tem corretagem de Venda e atribui o valor
		if (param.getStatusCorretagemDeVenda().equals("SIM")) {
			venda.setValorCorretagemDeVenda(param.getValorCorretagemDeVenda());

		} else {
			venda.setValorCorretagemDeVenda(0);
		}
		
		

		// SETA O CUSTO FINAL E CALCULA A MARGEM
		venda.setCustoFinal(venda.getCustoTotalDeCompra() + venda.getValorFreteVenda()
				+ venda.getValorCorretagemDeVenda() + venda.getValorIcmsVenda() + venda.getValorPisECofins());

		venda.setValorMargem(venda.getValorDeVenda() - venda.getCustoFinal());

		venda.setTaxaMargem(venda.getValorMargem() / venda.getValorDeVenda());

		// APROXIMA TODOS OS VALORES
		venda.setImpostoFreteVenda(tr.transforma(venda.getImpostoFreteVenda()));
		venda.setValorFreteVenda(tr.transforma(venda.getValorFreteVenda()));
		venda.setValorIcmsVenda(tr.transforma(venda.getValorIcmsVenda()));
		venda.setCustoFinal(tr.transforma(venda.getCustoFinal()));
		venda.setValorPisECofins(tr.transforma(venda.getValorPisECofins()));
		venda.setValorDeVenda(tr.transforma(venda.getValorDeVenda()));
		venda.setValorMargem(tr.transforma(venda.getValorMargem()));
		venda.setValorCorretagemDeVenda(tr.transforma(param.getValorCorretagemDeVenda()));
		venda.setValorMargem(tr.transforma(param.getValorDeVenda() - venda.getCustoFinal()));
		venda.setTaxaMargem(venda.getValorMargem()/ param.getValorDeVenda());
		return venda;

	}

}
