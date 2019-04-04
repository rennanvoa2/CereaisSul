package br.com.cereaissul.Frete;

import br.com.cereaissul.Parametros.Parametros;

public class FreteVenda extends Frete {
	public double calculaFreteVenda(Parametros param) {
		this.setImpostoFrete(0);
		this.setValorFrete(0);
		// VALOR DO FRETE DE VENDA POR SACO COM TRANSPORTE PJ
		if (param.getTemFreteVenda().equals("SIM") && param.getValorFreteVenda() > 0
				&& param.getTipoDeFreteVenda().equals("PJ")) {
			valorFrete = param.getValorFreteVenda() / 16.6666666666667;
			impostoFrete = 0;
		}
		// VALOR DO FRETE DE VENDA POR SACO COM TRANSPORTE PF
		if (param.getTemFreteVenda().equals("SIM") && param.getValorFreteVenda() > 0
				&& param.getTipoDeFreteVenda().equals("PF")) {
			valorFrete = (param.getValorFreteVenda() / 16.6666666666667);
			double y = valorFrete * param.getQtSacos();
			impostoFrete = calculaImpostosFrete(y) / param.getQtSacos();
		}
		return valorFrete + impostoFrete;
	}

}
