package br.com.cereaissul.Frete;

import br.com.cereaissul.Parametros.Parametros;

public class FreteCompra extends Frete {
	
	public double calculaFreteCompra(Parametros param) {
		this.setImpostoFrete(0);
		this.setValorFrete(0);
		// VALOR DO FRETE POR SACO COM TRANSPORTE PJ
		if (param.getTemFreteCompra().equals("SIM") && param.getValorFreteCompra() > 0
				&& param.getTipoDeFreteCompra().equals("PJ")) {
			valorFrete = param.getValorFreteCompra() / 16.6666666666667;
			impostoFrete = 0;
		}
		// VALOR DO FRETE POR SACO COM TRANSPORTE PF
		if (param.getTemFreteCompra().equals("SIM") && param.getValorFreteCompra() > 0
				&& param.getTipoDeFreteCompra().equals("PF")) {
			valorFrete = (param.getValorFreteCompra() / 16.6666666666667);
			double y = valorFrete * param.getQtSacos();
			impostoFrete = calculaImpostosFrete(y) / param.getQtSacos();
		}
		return valorFrete + impostoFrete ;
	}
}
