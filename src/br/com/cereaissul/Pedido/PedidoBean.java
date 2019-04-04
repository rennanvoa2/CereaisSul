package br.com.cereaissul.Pedido;

import java.util.Date;

public class PedidoBean {

	long numeroPedido = 0;
	Date dataPedido;
	long codComprador = 0;
	String nomeComprador = "";
	long quantidadeSacos = 0;
	String material = "";
	double peso = 0;
	long codProdutor = 0;
	String razaoSocialProdutor = "";
	String estadoProdutor = "";
	String cidadeProdutor = "";
	String cpfCnpjProdutor;
	String inscricaoEstadualProdutor;
	String enderecoProdutor;
	long codTrading = 0;
	String razaoSocialCliente = "";
	String estadoCliente = "";
	String cidadeCliente = "";
	String cpfCnpjCliente;
	String inscricaoEstadualCliente;
	String enderecoCliente;
	double valorLiquido = 0;
	double valorLiquidoTotal = 0;
	double funrural = 0;
	double funruralTotal = 0;
	double impostosDeCompra = 0;
	double impostosDeCompraTotal = 0;
	double freteDeCompra = 0;
	double freteDeCompraTotal = 0;
	double corretagemDeCompra = 0;
	double corretagemDeCompraTotal = 0;
	double custoDeCompra = 0;
	double custoDeCompraTotal = 0;
	String filial;
	String periodoDeEntregaCompra;
	String localDeEmbarque;
	String observacoes;
	String dadosBancariosProdutor;
	String safra = "";

	double impostosDeVenda = 0;
	double impostosDeVendaTotal = 0;
	double freteDeVenda = 0;
	double freteDeVendaTotal = 0;
	double corretagemDeVenda = 0;
	double corretagemDeVendaTotal = 0;
	double custoDeVenda = 0;
	double custoDeVendaTotal = 0;
	double valorRealDeVenda = 0;
	double valorRealDeVendaTotal = 0;
	double margem = 0;
	double margemTotal = 0;
	long diasDeJuros = 0;
	double juros = 0;
	double jurosTotal = 0;
	double custosAdicionais = 0;
	String status = "LANCADO E AGUARDANDO DESBLOQUEIO";
	String observacaoDeModificacao = "";
	String tipoDePedido = "";
	String empresa = "";
	String localDeDestino = "";
	String destinoGrao;

	public long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public long getCodComprador() {
		return codComprador;
	}

	public void setCodComprador(long codComprador) {
		this.codComprador = codComprador;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public long getQuantidadeSacos() {
		return quantidadeSacos;
	}

	public void setQuantidadeSacos(long quantidadeSacos) {
		this.quantidadeSacos = quantidadeSacos;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public long getCodProdutor() {
		return codProdutor;
	}

	public void setCodProdutor(long codProdutor) {
		this.codProdutor = codProdutor;
	}

	public String getRazaoSocialProdutor() {
		return razaoSocialProdutor;
	}

	public void setRazaoSocialProdutor(String razaoSocialProdutor) {
		this.razaoSocialProdutor = razaoSocialProdutor;
	}

	public String getEstadoProdutor() {
		return estadoProdutor;
	}

	public void setEstadoProdutor(String estadoProdutor) {
		this.estadoProdutor = estadoProdutor;
	}

	public String getCidadeProdutor() {
		return cidadeProdutor;
	}

	public void setCidadeProdutor(String cidadeProdutor) {
		this.cidadeProdutor = cidadeProdutor;
	}

	public String getCpfCnpjProdutor() {
		return cpfCnpjProdutor;
	}

	public void setCpfCnpjProdutor(String cpfCnpjProdutor) {
		this.cpfCnpjProdutor = cpfCnpjProdutor;
	}

	public String getInscricaoEstadualProdutor() {
		return inscricaoEstadualProdutor;
	}

	public void setInscricaoEstadualProdutor(String inscricaoEstadualProdutor) {
		this.inscricaoEstadualProdutor = inscricaoEstadualProdutor;
	}

	public String getEnderecoProdutor() {
		return enderecoProdutor;
	}

	public void setEnderecoProdutor(String enderecoProdutor) {
		this.enderecoProdutor = enderecoProdutor;
	}

	public long getCodTrading() {
		return codTrading;
	}

	public void setCodTrading(long codTrading) {
		this.codTrading = codTrading;
	}

	public String getRazaoSocialCliente() {
		return razaoSocialCliente;
	}

	public void setRazaoSocialCliente(String razaoSocialCliente) {
		this.razaoSocialCliente = razaoSocialCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getInscricaoEstadualCliente() {
		return inscricaoEstadualCliente;
	}

	public void setInscricaoEstadualCliente(String inscricaoEstadualCliente) {
		this.inscricaoEstadualCliente = inscricaoEstadualCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public double getValorLiquidoTotal() {
		return valorLiquidoTotal;
	}

	public void setValorLiquidoTotal(double valorLiquidoTotal) {
		this.valorLiquidoTotal = valorLiquidoTotal;
	}

	public double getFunrural() {
		return funrural;
	}

	public void setFunrural(double funrural) {
		this.funrural = funrural;
	}

	public double getFunruralTotal() {
		return funruralTotal;
	}

	public void setFunruralTotal(double funruralTotal) {
		this.funruralTotal = funruralTotal;
	}

	public double getImpostosDeCompra() {
		return impostosDeCompra;
	}

	public void setImpostosDeCompra(double impostosDeCompra) {
		this.impostosDeCompra = impostosDeCompra;
	}

	public double getImpostosDeCompraTotal() {
		return impostosDeCompraTotal;
	}

	public void setImpostosDeCompraTotal(double impostosDeCompraTotal) {
		this.impostosDeCompraTotal = impostosDeCompraTotal;
	}

	public double getFreteDeCompra() {
		return freteDeCompra;
	}

	public void setFreteDeCompra(double freteDeCompra) {
		this.freteDeCompra = freteDeCompra;
	}

	public double getFreteDeCompraTotal() {
		return freteDeCompraTotal;
	}

	public void setFreteDeCompraTotal(double freteDeCompraTotal) {
		this.freteDeCompraTotal = freteDeCompraTotal;
	}

	public double getCorretagemDeCompra() {
		return corretagemDeCompra;
	}

	public void setCorretagemDeCompra(double corretagemDeCompra) {
		this.corretagemDeCompra = corretagemDeCompra;
	}

	public double getCorretagemDeCompraTotal() {
		return corretagemDeCompraTotal;
	}

	public void setCorretagemDeCompraTotal(double corretagemDeCompraTotal) {
		this.corretagemDeCompraTotal = corretagemDeCompraTotal;
	}

	public double getCustoDeCompra() {
		return custoDeCompra;
	}

	public void setCustoDeCompra(double custoDeCompra) {
		this.custoDeCompra = custoDeCompra;
	}

	public double getCustoDeCompraTotal() {
		return custoDeCompraTotal;
	}

	public void setCustoDeCompraTotal(double custoDeCompraTotal) {
		this.custoDeCompraTotal = custoDeCompraTotal;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getPeriodoDeEntregaCompra() {
		return periodoDeEntregaCompra;
	}

	public void setPeriodoDeEntregaCompra(String periodoDeEntregaCompra) {
		this.periodoDeEntregaCompra = periodoDeEntregaCompra;
	}

	public String getLocalDeEmbarque() {
		return localDeEmbarque;
	}

	public void setLocalDeEmbarque(String localDeEmbarque) {
		this.localDeEmbarque = localDeEmbarque;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getDadosBancariosProdutor() {
		return dadosBancariosProdutor;
	}

	public void setDadosBancariosProdutor(String dadosBancariosProdutor) {
		this.dadosBancariosProdutor = dadosBancariosProdutor;
	}

	public String getSafra() {
		return safra;
	}

	public void setSafra(String safra) {
		this.safra = safra;
	}

	public double getImpostosDeVenda() {
		return impostosDeVenda;
	}

	public void setImpostosDeVenda(double impostosDeVenda) {
		this.impostosDeVenda = impostosDeVenda;
	}

	public double getImpostosDeVendaTotal() {
		return impostosDeVendaTotal;
	}

	public void setImpostosDeVendaTotal(double impostosDeVendaTotal) {
		this.impostosDeVendaTotal = impostosDeVendaTotal;
	}

	public double getFreteDeVenda() {
		return freteDeVenda;
	}

	public void setFreteDeVenda(double freteDeVenda) {
		this.freteDeVenda = freteDeVenda;
	}

	public double getFreteDeVendaTotal() {
		return freteDeVendaTotal;
	}

	public void setFreteDeVendaTotal(double freteDeVendaTotal) {
		this.freteDeVendaTotal = freteDeVendaTotal;
	}

	public double getCorretagemDeVenda() {
		return corretagemDeVenda;
	}

	public void setCorretagemDeVenda(double corretagemDeVenda) {
		this.corretagemDeVenda = corretagemDeVenda;
	}

	public double getCorretagemDeVendaTotal() {
		return corretagemDeVendaTotal;
	}

	public void setCorretagemDeVendaTotal(double corretagemDeVendaTotal) {
		this.corretagemDeVendaTotal = corretagemDeVendaTotal;
	}

	public double getCustoDeVenda() {
		return custoDeVenda;
	}

	public void setCustoDeVenda(double custoDeVenda) {
		this.custoDeVenda = custoDeVenda;
	}

	public double getCustoDeVendaTotal() {
		return custoDeVendaTotal;
	}

	public void setCustoDeVendaTotal(double custoDeVendaTotal) {
		this.custoDeVendaTotal = custoDeVendaTotal;
	}

	public double getValorRealDeVenda() {
		return valorRealDeVenda;
	}

	public void setValorRealDeVenda(double valorRealDeVenda) {
		this.valorRealDeVenda = valorRealDeVenda;
	}

	public double getValorRealDeVendaTotal() {
		return valorRealDeVendaTotal;
	}

	public void setValorRealDeVendaTotal(double valorRealDeVendaTotal) {
		this.valorRealDeVendaTotal = valorRealDeVendaTotal;
	}

	public double getMargem() {
		return margem;
	}

	public void setMargem(double margem) {
		this.margem = margem;
	}

	public double getMargemTotal() {
		return margemTotal;
	}

	public void setMargemTotal(double margemTotal) {
		this.margemTotal = margemTotal;
	}

	public long getDiasDeJuros() {
		return diasDeJuros;
	}

	public void setDiasDeJuros(long diasDeJuros) {
		this.diasDeJuros = diasDeJuros;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getJurosTotal() {
		return jurosTotal;
	}

	public void setJurosTotal(double jurosTotal) {
		this.jurosTotal = jurosTotal;
	}

	public double getCustosAdicionais() {
		return custosAdicionais;
	}

	public void setCustosAdicionais(double custosAdicionais) {
		this.custosAdicionais = custosAdicionais;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacaoDeModificacao() {
		return observacaoDeModificacao;
	}

	public void setObservacaoDeModificacao(String observacaoDeModificacao) {
		this.observacaoDeModificacao = observacaoDeModificacao;
	}

	public String getTipoDePedido() {
		return tipoDePedido;
	}

	public void setTipoDePedido(String tipoDePedido) {
		this.tipoDePedido = tipoDePedido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	public String getDestinoGrao() {
		return destinoGrao;
	}

	public void setDestinoGrao(String destinoGrao) {
		this.destinoGrao = destinoGrao;
	}

}
