package br.com.cereaissul.impostos.Icms;

import br.com.cereaissul.Parametros.Parametros;
import br.com.cereaissul.Venda.VendaBean;

public class IcmsVenda extends Icms {

	public double taxaCreditoIcms = 0;
	public double taxaDebitoIcms = 0;
	public double valorDebitoIcms = 0;
	public double valorCreditoIcms = 0;
	public double valorIcmsVenda = 0;

	public double getTaxaCreditoIcms() {
		return taxaCreditoIcms;
	}

	public void setTaxaCreditoIcms(double taxaCreditoIcms) {
		this.taxaCreditoIcms = taxaCreditoIcms;
	}

	public double getTaxaDebitoIcms() {
		return taxaDebitoIcms;
	}

	public void setTaxaDebitoIcms(double taxaDebitoIcms) {
		this.taxaDebitoIcms = taxaDebitoIcms;
	}

	public double getValorDebitoIcms() {
		return valorDebitoIcms;
	}

	public void setValorDebitoIcms(double valorDebitoIcms) {
		this.valorDebitoIcms = valorDebitoIcms;
	}

	public double getValorCreditoIcms() {
		return valorCreditoIcms;
	}

	public void setValorCreditoIcms(double valorCreditoIcms) {
		this.valorCreditoIcms = valorCreditoIcms;
	}

	public double getValorIcmsVenda() {
		return valorIcmsVenda;
	}

	public void setValorIcmsVenda(double valorIcmsVenda) {
		this.valorIcmsVenda = valorIcmsVenda;
	}

	// CALCULA DOS VALORES DE DÉBITO E CRÉDITO DE ICMS E ACHA O VALOR FINAL DO
	// ICMS
	// DE VENDA
	public double calculaIcmsVenda(Parametros param, VendaBean venda) {

		// SOJA - CALCULA TAXA DE DEBITO
		if (param.getMaterial().equals("SOJA")) {
			this.debitoIcmsSoja(param);			
			this.creditoIcms(param);

		}

		// MILHO - CALCULA TAXA DE DEBITO
		if (param.getMaterial().equals("MILHO")) {
			this.debitoIcmsMilho(param);			
			this.creditoIcms(param);

		}

		this.setValorDebitoIcms(param.getValorDeVenda() * this.getTaxaDebitoIcms());
		this.setValorCreditoIcms(param.getPrecoProdutor() * this.getTaxaCreditoIcms());

		if (this.getValorDebitoIcms() - this.getValorCreditoIcms() <= 0) {
			this.setValorIcmsVenda(0);
		} else {
			this.setValorIcmsVenda(this.getValorDebitoIcms() - this.getValorCreditoIcms());
		}

		return this.getValorIcmsVenda();
	}

	// CALCULA O ICMS DE VENDA PARA POSTERIORMENTE CALCULAR SE A SALDO DE ICMS
	// NA OPERAÇÃO OU NÃO
	// QUANDO O MATERIAL É SOJA

	public void debitoIcmsSoja(Parametros param) {
		// GO - GO > OUTROS
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("GO")
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.17);
		}

		// GO - OUTROS ESTADOS > OUTROS
		if (param.getEstadoFilial().equals("GO")
				&& (param.getEstadoCliente().equals("MG") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > OUTROS
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("SUL")
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - GO > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("GO")
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0);
		}

		// GO - OUTROS ESTADOS > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("GO")
				&& (param.getEstadoCliente().equals("MG") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.084);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("SUL")
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.084);
		}

		// GO - GO > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("GO")
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.17);
		}

		// GO - OUTROS ESTADOS > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("GO")
				&& (param.getEstadoCliente().equals("MG") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("GO") && param.getEstadoCliente().equals("SUL")
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO/MG - EXPORTAÇÃO > ISENTO
		if ((param.getEstadoFilial().equals("MG") || param.getEstadoFilial().equals("MG"))
				&& param.getEstadoCliente().equals("MG") && param.getAtividadeVenda().equals("EXP")) {
			this.setTaxaDebitoIcms(0);
		}

		// MG - MG > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("MG")
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0);
		}

		// MG - OUTROS ESTADOS > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("MG")
				&& (param.getEstadoCliente().equals("GO") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.049);
		}

		// MG - MG > OUTROS
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("MG")
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.18);
		}

		// MG - OUTROS ESTADOS > OUTROS
		if (param.getEstadoFilial().equals("MG")
				&& (param.getEstadoCliente().equals("GO") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.07);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > OUTROS
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("SUL")
				&& param.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > IND.RAC/PRODUTOR/GRANJA
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("SUL")
				&& (param.getAtividadeVenda().equals("PROD") || param.getAtividadeVenda().equals("RACOES")
						|| param.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.084);
		}

		// MG - MG > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("MG")
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.18);
		}

		// MG - OUTROS ESTADOS > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("MG")
				&& (param.getEstadoCliente().equals("GO") || param.getEstadoCliente().equals("OUTROSESTADOS"))
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.07);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) > CONSUMO HUMANO
		if (param.getEstadoFilial().equals("MG") && param.getEstadoCliente().equals("SUL")
				&& param.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

	}

	// CALCULA TAXA DE DEBITO DE ICMS NO CASO DO MATERIAL SER MILHO PARA
	// POSTERIOR CALCULO FINAL DE VENDA DE ICMS

	public void debitoIcmsMilho(Parametros compra) {

		// GO - GO OUTROS
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("GO")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.17);
		}

		// GO - OUTROS ESTADOS OUTROS (OUTORGADO 6% E PROTEGE 15%)
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			double outorgado = ((0.12 - 0.06) + ((0.12 - 0.06) * 0.15));
			this.setTaxaDebitoIcms(outorgado);
		}

		// GO - GO IND.RAC/PRODUTOR/GRANJA
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("GO")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0);
		}

		// GO - OUTROS ESTADOS IND.RAC/PRODUTOR/GRANJA (COMPRA DO DF)
		if (compra.getEstadoSaidaMaterial().equals("DF") && compra.getEstadoFilial().equals("GO")
				&& compra.getEstadoCliente().equals("") && compra.getAtividadeVenda().equals("")) {
			this.setTaxaDebitoIcms(0.084);
		}

		// GO - OUTROS ESTADOS IND.RAC/PRODUTOR/GRANJA (COMPRA DE GO COM CRÉDITO
		// OUTORGADO)
		if (compra.getEstadoSaidaMaterial().equals("GO") && compra.getEstadoFilial().equals("GO")
				&& compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			double outorgado = ((0.084 - 0.0343) + ((0.084 - 0.0343) * 0.15));
			this.setTaxaDebitoIcms(outorgado);
		}

		// GO - GO CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("GO")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - OUTROS ESTADOS CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("SUL")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) IND.RAC/PRODUTOR/GRANJA
		// (COMPRA DO
		// DF)
		if (compra.getEstadoSaidaMaterial().equals("DF") && compra.getEstadoFilial().equals("GO")
				&& compra.getEstadoCliente().equals("SUL")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.084);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) IND.RAC/PRODUTOR/GRANJA
		// (COMPRA DO
		// GO COM CRÉDITO OUTORGADO)
		if (compra.getEstadoSaidaMaterial().equals("GO") && compra.getEstadoFilial().equals("GO")
				&& compra.getEstadoCliente().equals("SUL")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			double outorgado = ((0.084 - 0.0343) + ((0.084 - 0.0343) * 0.15));
			this.setTaxaDebitoIcms(outorgado);
		}

		// GO - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) OUTROS
		if (compra.getEstadoFilial().equals("GO") && compra.getEstadoCliente().equals("SUL")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// GO/MG - EXPORTAÇÃO ISENTO
		if ((compra.getEstadoFilial().equals("GO") || compra.getEstadoFilial().equals("MG"))
				&& compra.getEstadoCliente().equals("EXP")) {
			this.setTaxaDebitoIcms(0);
		}

		// MG - MG IND.RAC/PRODUTOR/GRANJA
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("MG")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0);
		}

		// MG - OUTROS ESTADOS IND.RAC/PRODUTOR/GRANJA
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.049);
		}

		// MG - MG OUTROS
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("MG")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.18);
		}

		// MG - OUTROS ESTADOS OUTROS
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.07);
		}

		// MG - MG CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("MG")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.18);
		}

		// MG - OUTROS ESTADOS CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("OUTROSESTADOS")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.07);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) CONSUMO HUMANO
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("SUL")
				&& compra.getAtividadeVenda().equals("HUMANO")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) OUTROS
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("SUL")
				&& compra.getAtividadeVenda().equals("OUTROS")) {
			this.setTaxaDebitoIcms(0.12);
		}

		// MG - SUL/SUDESTE ( PR, RS, RJ, SC OU SP) IND.RAC/PRODUTOR/GRANJA
		if (compra.getEstadoFilial().equals("MG") && compra.getEstadoCliente().equals("SUL")
				&& (compra.getAtividadeVenda().equals("PROD") || compra.getAtividadeVenda().equals("RACOES")
						|| compra.getAtividadeVenda().equals("GRANJA"))) {
			this.setTaxaDebitoIcms(0.084);
		}

	}

	// CALCULA O CRÉDITO DE ICMS

	public void creditoIcms(Parametros param) {
		// GO - GO > PRODUTOR/COOPERATIVA
		if (param.getEstadoSaidaMaterial().equals("GO") && param.getEstadoFilial().equals("GO")
				&& (param.getAtividadeCompra().equals("PROD") || param.getAtividadeCompra().equals("COOPERATIVA"))) {
			this.setTaxaCreditoIcms(0);
		}
		// GO - GO > CEREALISTA
		if (param.getEstadoSaidaMaterial().equals("GO") && param.getEstadoFilial().equals("GO")
				&& param.getAtividadeCompra().equals("CEREALISTA")) {
			this.setTaxaCreditoIcms(0.17);
		}
		// DF - GO/MG > QUALQUER UM
		if (param.getEstadoSaidaMaterial().equals("DF")
				&& (param.getEstadoFilial().equals("MG") || param.getEstadoFilial().equals("GO"))) {
			this.setTaxaCreditoIcms(0.12);
		}
		// MG - MG > PRODUTOR/COOPERATIVA
		if (param.getEstadoSaidaMaterial().equals("MG") && param.getEstadoFilial().equals("MG")
				&& (param.getAtividadeCompra().equals("PROD") || param.getAtividadeCompra().equals("COOPERATIVA"))) {
			this.setTaxaCreditoIcms(0);
		}
		// MG - MG > CEREALISTA
		if (param.getEstadoSaidaMaterial().equals("MG") && param.getEstadoFilial().equals("MG")
				&& param.getAtividadeCompra().equals("CEREALISTA")) {
			this.setTaxaCreditoIcms(0.18);
		}

	}
}
