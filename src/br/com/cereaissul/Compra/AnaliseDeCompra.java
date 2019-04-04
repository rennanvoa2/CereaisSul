package br.com.cereaissul.Compra;

import br.com.cereaissul.Frete.FreteCompra;
import br.com.cereaissul.Parametros.Parametros;
import br.com.cereaissul.TransformaReais.TransformaReais;
import br.com.cereaissul.impostos.Icms.IcmsCompra;

public class AnaliseDeCompra {

	public AnaliseDeCompra(Parametros param) {

	}

	public CompraBean calculaAnaliseDeCompra(Parametros param) {
		FreteCompra frete = new FreteCompra();
		IcmsCompra icms = new IcmsCompra();
		TransformaReais tr = new TransformaReais();
		CompraBean compra = new CompraBean();

		compra.setTaxaIcmsProdutor(icms.calculaIcmsCompra(param));


		if (param.getTipoDePessoaCompra().equals("PF")) {
			
			// IF pra Check no campo do funrural
			// Se foi marcado SIM no Funrural e o produtor paga seu Funrural
			if (param.getFunRural().equals("SIM"))

			{
				compra.setTaxaFunRural(0.012);
			} else {
				compra.setTaxaFunRural(0.0);// TO DO Substituir 0 pela query
												// que busca o
				// valor
				// da Taxa de Funrural
				// na tabela IMPOSTOS no banco de dados;

			}
			
			
			compra.setTaxaSenar(0.002); // TO DO Substituir 0 pela query que
			// busca o valor

			// da Taxa SENAR
			// na tabela IMPOSTOS no banco de dados;

			compra.setTaxaPat(0.001); // TO DO Substituir 0 pela query que busca
										// o valor
										// da
										// Taxa PAT
										// na tabela IMPOSTOS no banco de dados;

		} else if (param.getTipoDePessoaCompra().equals("PJ")){
			compra.setTaxaFunRural(0);
			compra.setTaxaSenar(0);
			compra.setTaxaPat(0);
		}

		// Seta o preço liquido do produtor
		compra.setPrecoProdutor(tr.transforma(param.getPrecoProdutor()));

		// Seta o valor da corretagem
		if (param.getStatusCorretagemDeCompra().equals("SIM")) {
			compra.setCorretagemDeCompra(param.getValorCorretagemDeCompra());
		} else {
			compra.setCorretagemDeCompra(0);
		}

		// Usa os paramêtros passados para calcular: Valor bruto, ICMS,
		// FUNRURAL, SENAR, PAT, FRETE DE COMPRA
		// e Custo total de compra
		compra.setValorBrutoCompra(tr.transforma(this.valorBrutoDeCompra(param, compra)));
		compra.setValorIcmsProdutor(tr.transforma(valorIcmsProdutor(param, compra)));
		compra.setValorFunRural(tr.transforma(valorFunrural(param, compra)));
		compra.setValorSenar(tr.transforma(valorSenar(param, compra)));
		compra.setValorPat(tr.transforma(valorPat(param, compra)));
		compra.setValorFreteCompra(tr.transforma(frete.calculaFreteCompra(param)));
		compra.setValorCorretagemDeCompra(tr.transforma(compra.getCorretagemDeCompra()));
		compra.setCustoTotalDeCompra(tr.transforma(
				compra.getValorBrutoCompra() + compra.getValorFreteCompra() + param.getValorCorretagemDeCompra()));

		return compra;
	}

	// Calcula Valor Bruto de Compra
	public double valorBrutoDeCompra(Parametros compra, CompraBean analise) {
		double valor = 0;
		valor = compra.getPrecoProdutor() / (1 - analise.getTaxaFunRural() - analise.getTaxaSenar()
				- analise.getTaxaIcmsProdutor() - analise.getTaxaPat());
		return valor;
	}

	// Calcula Valor ICMS
	public double valorIcmsProdutor(Parametros compra, CompraBean analise) {
		double valor = 0;
		valor = analise.getValorBrutoCompra() * analise.getTaxaIcmsProdutor();
		return valor;
	}

	// Calcula Valor Funrural
	public double valorFunrural(Parametros compra, CompraBean analise) {
		double valor = 0;
		valor = analise.getValorBrutoCompra() * analise.getTaxaFunRural();
		return valor;
	}

	// Calcula Valor SENAR
	public double valorSenar(Parametros compra, CompraBean analise) {
		double valor = 0;
		valor = analise.getValorBrutoCompra() * analise.getTaxaSenar();
		return valor;
	}

	// Calcula Valor PAT
	public double valorPat(Parametros compra, CompraBean analise) {
		double valor = 0;
		valor = analise.getValorBrutoCompra() * analise.getTaxaPat();
		return valor;
	}

}
