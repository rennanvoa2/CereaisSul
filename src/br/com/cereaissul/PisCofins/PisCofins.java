package br.com.cereaissul.PisCofins;

import br.com.cereaissul.Parametros.Parametros;

public class PisCofins {
	
	// SETA A TAXA DO PIS COFINS E CALCULA O VALOR

	public double calculaPisCofins(Parametros param){
		double taxaPisCofins = 0;
		if(param.getMaterial().equals("MILHO")) {
			if(param.getEstadoCliente().equals("EXP") || param.getAtividadeVenda().equals("HUMANO")) {
				taxaPisCofins = 0;
			}
			else if (param.getAtividadeVenda().equals("OUTROS")){
				taxaPisCofins = 0.0925;
			} else {
				taxaPisCofins = 0;
			}
		}
		
		if (param.getMaterial().equals("SOJA")) {
			taxaPisCofins = 0;
		}
		return taxaPisCofins;
	}
}
