package br.com.cereaissul.impostos.Icms;

import br.com.cereaissul.Parametros.Parametros;

public class IcmsCompra extends Icms {
	// CALCULA O ICMS DE COMPRA (QUE O PRODUTOR DEVERIA PAGAR PORÉM A EMPRESA FAZ O CALCULO COM O VALOR LIQUIDO)
		public double calculaIcmsCompra(Parametros param) {

			if (param.getMaterial().equals("MILHO")) {
				calculaTaxaIcmsMilhoCompra(param);
			} else if (param.getMaterial().equals("SOJA")) {
				calculaTaxaIcmsSojaCompra(param);

			}

			return this.getTaxaIcms();

		}

		
		
		// CALCULA O ICMS DE COMPRA NO CASO DO MATERIAL SER SOJA

		public void calculaTaxaIcmsSojaCompra(Parametros param) {
			
			// DEFINIÇÃO DA TAXA DE ICMS
			// GO - GO > PRODUTOR OU COOPERATIVA
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("GO")
					&& param.getEstadoFilial().equals("GO") && (param.getAtividadeCompra().equals("PRODUTOR")
							|| param.getAtividadeCompra().equals("COOPERATIVA"))) {
				this.setTaxaIcms(0);
			}
			// GO - GO > CEREALISTA
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("GO")
					&& param.getEstadoFilial().equals("GO") && param.getAtividadeCompra().equals("CEREALISTA")) {
				this.setTaxaIcms(0.17);
			}
			// DF - GO > PRODUTOR COM PRORURAL
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getAtividadeCompra().equals("PRODUTOR")
					&& param.getProRural().equals("SIM")) {
				this.setTaxaIcms(0.024);
			}
			// DF - GO > PRODUTOR SEM PRO RURAL, COOPERATIVA E CEREALISTAS
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getProRural().equals("NAO")) {
				this.setTaxaIcms(0.12);

			}
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getProRural().equals("SIM")
					&& (param.getAtividadeCompra().equals("COOPERATIVA")
							|| param.getAtividadeCompra().equals("CEREALISTA"))) {
				this.setTaxaIcms(0.12);
			}

			// DF - MG > PRODUTOR COM PRO RURAL
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("MG") && param.getAtividadeCompra().equals("PRODUTOR")
					&& param.getProRural().equals("SIM")) {
				this.setTaxaIcms(0.024);
			}
			// DF - MG > PRODUTOR SEM PRORURAL, COOPERATIVA E CEREALISTA
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("MG") && param.getProRural().equals("NAO")) {
				this.setTaxaIcms(0.12);
			}
			// MG - MG > PRODUTOR OU COOPERATIVA
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("MG")
					&& param.getEstadoFilial().equals("MG") && (param.getAtividadeCompra().equals("PRODUTOR")
							|| param.getAtividadeCompra().equals("COOPERATIVA"))) {
				this.setTaxaIcms(0);
			}
			// MG - MG > CEREALISTA
			if (param.getMaterial().equals("SOJA") && param.getEstadoSaidaMaterial().equals("MG")
					&& param.getEstadoFilial().equals("MG") && param.getAtividadeCompra().equals("CEREALISTA")) {
				this.setTaxaIcms(0.18);
			}

		}

		
		
		// CALCULA O ICMS DE COMPRA NO CASO DO MATERIAL SER MILHO
		public void calculaTaxaIcmsMilhoCompra(Parametros param) {

			// DEFINIÇÃO DA TAXA DE ICMS
			// GO - GO > PRODUTOR OU COOPERATIVA
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("GO")
					&& param.getEstadoFilial().equals("GO") && (param.getAtividadeCompra().equals("PRODUTOR")
							|| param.getAtividadeCompra().equals("COOPERATIVA"))) {
				this.setTaxaIcms(0);
			}
			// GO - GO > CEREALISTA
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("GO")
					&& param.getEstadoFilial().equals("GO") && param.getAtividadeCompra().equals("CEREALISTA")) {
				this.setTaxaIcms(0.17);
			}
			// DF - GO > PRODUTOR COM PRORURAL
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getAtividadeCompra().equals("PRODUTOR")
					&& param.getProRural().equals("SIM")) {
				this.setTaxaIcms(0.024);
			}
			// DF - GO > PRODUTOR SEM PRO RURAL, COOPERATIVA E CEREALISTAS
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getProRural().equals("NAO")) {
				this.setTaxaIcms(0.12);

			}
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("GO") && param.getProRural().equals("SIM")
					&& (param.getAtividadeCompra().equals("COOPERATIVA")
							|| param.getAtividadeCompra().equals("CEREALISTA"))) {
				this.setTaxaIcms(0.12);
			}

			// DF - MG > PRODUTOR COM PRO RURAL
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("MG") && param.getAtividadeCompra().equals("PRODUTOR")
					&& param.getProRural().equals("SIM")) {
				this.setTaxaIcms(0.024);
			}
			// DF - MG > PRODUTOR SEM PRORURAL, COOPERATIVA E CEREALISTA
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("DF")
					&& param.getEstadoFilial().equals("MG") && param.getProRural().equals("NAO")) {
				this.setTaxaIcms(0.12);
			}
			// MG - MG > PRODUTOR OU COOPERATIVA
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("MG")
					&& param.getEstadoFilial().equals("MG") && (param.getAtividadeCompra().equals("PRODUTOR")
							|| param.getAtividadeCompra().equals("COOPERATIVA"))) {
				this.setTaxaIcms(0);
			}
			// MG - MG > CEREALISTA
			if (param.getMaterial().equals("MILHO") && param.getEstadoSaidaMaterial().equals("MG")
					&& param.getEstadoFilial().equals("MG") && param.getAtividadeCompra().equals("CEREALISTA")) {
				this.setTaxaIcms(0.18);
			}

		}

}
