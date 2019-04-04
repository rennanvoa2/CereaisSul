package br.com.cereaissul.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.cereaissul.Compra.AnaliseDeCompra;
import br.com.cereaissul.Compra.CompraBean;
import br.com.cereaissul.Datas.DatasBean;
import br.com.cereaissul.Parametros.Parametros;
import br.com.cereaissul.Pedido.PedidoBean;
import br.com.cereaissul.Venda.AnaliseDeVenda;
import br.com.cereaissul.Venda.VendaBean;

// parei testando o calculo de icms
public class MainTeste {
	public static void main(String[] args) throws ParseException {
		
		Parametros p = new Parametros();
		PedidoBean pedido = new PedidoBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DatasBean data = new DatasBean();
		
		//GERAL	
		p.setMaterial("SOJA");
		p.setQtSacos(166.6666667);
		p.setPrecoProdutor(50);
		pedido.setNomeComprador("GIOR5DANO");
		pedido.setDataPedido(sdf.parse("12/03/2019"));
		pedido.setSafra("2019");
		pedido.setTipoDePedido("COMERCIAL");
		pedido.setEmpresa("BOA SAFRA SEMENTES");
		
		//COMPRA
		p.setCodigoProdutor(101028);
		pedido.setRazaoSocialProdutor("RENNAN VALADARES PRODUTOR");
		pedido.setEstadoProdutor("GO");
		pedido.setCidadeProdutor("FORMOSA");
		pedido.setCpfCnpjProdutor("00001112222");
		pedido.setInscricaoEstadualProdutor("001122334455");
		pedido.setEnderecoProdutor("RUA B CASA A");
		p.setTipoDePessoaCompra("PF");
		p.setEstadoSaidaMaterial("GO");
		p.setEstadoFilial("GO");
		p.setAtividadeCompra("CEREALISTA");
		p.setProRural("NAO");
		p.setFunRural("SIM");
		p.setTemFreteCompra("SIM");
		p.setValorFreteCompra(35);
		p.setTipoDeFreteCompra("PF");
		p.setStatusCorretagemDeCompra("SIM");
		p.setValorCorretagemDeCompra(0.20);
		data.setDataCliente1(sdf.parse("20/03/2019"));
		pedido.setFilial("CS06");
		pedido.setPeriodoDeEntregaCompra("De 20/03 a 30/03");
		pedido.setLocalDeEmbarque("FAZ BOA SAFRA");
		pedido.setObservacoes("SEM CARGA EXTRA");
		
		
		
		//VENDA
		p.setCodigoCliente(105060);
		pedido.setRazaoSocialCliente("BUNGE");
		pedido.setEstadoCliente("GO");
		pedido.setCidadeCliente("SAO JOAO DA ALIANCA");
		pedido.setCpfCnpjCliente("123456789123450");
		pedido.setInscricaoEstadualCliente("1234567890");
		pedido.setEnderecoCliente("Porto de Santos Bungue");
		p.setEstadoCliente("OUTROSESTADOS");
		p.setAtividadeVenda("OUTROS");
		p.setTemFreteVenda("SIM");
		p.setTipoDeFreteVenda("PF");
		p.setValorFreteVenda(50);
		p.setValorDeVenda(75);
		p.setStatusCorretagemDeVenda("SIM");
		p.setValorCorretagemDeVenda(0.1);
		data.setDataProd1(sdf.parse("30/03/2019"));
		pedido.setDestinoGrao("MERCADO INTERNO");
		pedido.setLocalDeDestino("BUNGUE PORTO");


		AnaliseDeCompra analiseCompra = new AnaliseDeCompra(p);
		CompraBean compra = analiseCompra.calculaAnaliseDeCompra(p);
		
		AnaliseDeVenda analiseVenda = new AnaliseDeVenda();
		VendaBean venda = analiseVenda.calculaAnaliseDeVenda(p, compra);
		

		System.out.println("Material: " + p.getMaterial());
		
		System.out.println("Preço Liquido: " + p.getPrecoProdutor());

		System.out.println("ICMS:" + compra.getValorIcmsProdutor() );
		
		System.out.println("Funrural: " + compra.getValorFunRural());

		System.out.println("Senar: " + compra.getValorSenar());
		
		System.out.println("Pat: " + compra.getValorPat());
		
		System.out.println("Valor Bruto: " + compra.getValorBrutoCompra());

		System.out.println("Frete Compra:" + compra.getValorFreteCompra());
		
		System.out.println("Corretagem: " + compra.getValorCorretagemDeCompra());
		
		System.out.println("Custo total te Compra:" + compra.getCustoTotalDeCompra());
		
		System.out.println("_______________________________");
		
		System.out.println(" ");
		
		System.out.println("Custo total de Compra: " + venda.getCustoTotalDeCompra());
		
		System.out.println("Frete de Venda: " + venda.getValorFreteVenda());
		
		System.out.println("Corretagem de Venda: " + venda.getValorCorretagemDeVenda());
		
		System.out.println("ICMS de Venda: " + venda.getValorIcmsVenda());
		
		System.out.println("PIS e COFINS: " + venda.getValorPisECofins());
		
		System.out.println("Custo Final: " + venda.getCustoFinal());
		
		System.out.println("Margem: " + venda.getValorMargem());
		
		System.out.println("Percentual de Margem: " + venda.getTaxaMargem());
		

	}

}
