package br.com.cereaissul.impostos.Icms;
//Classe que calcula a taxa de ICMS

// TO DO: ALTERAR AS taxaIcmsProdutos para a query que buscar� no banco os param�tros de impostos
public class Icms {

	public double taxaIcms;

	public double getTaxaIcms() {
		return taxaIcms;
	}

	public void setTaxaIcms(double taxaIcmsProdutor) {
		this.taxaIcms = taxaIcmsProdutor;
	}

}
