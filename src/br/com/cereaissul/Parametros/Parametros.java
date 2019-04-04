package br.com.cereaissul.Parametros;

public class Parametros {

	// parametros sobre produto
	private String material;
	private double qtSacos;
	private double precoProdutor;

	// parametros para calculos de compra
	private long codigoProdutor = 0;
	private String estadoSaidaMaterial;
	private String estadoFilial;
	private String atividadeCompra;
	private String proRural;
	private String funRural;
	private String temFreteCompra;
	private double valorFreteCompra = 0;
	private String tipoDeFreteCompra;
	private double valorCorretagemDeCompra = 0;
	private String statusCorretagemDeCompra = "";
	private String tipoDePessoaCompra = "";

	// parametros para calculo de venda
	private long codigoCliente = 0;
	private String estadoCliente = "";
	private String atividadeVenda;
	private String temFreteVenda;
	private double valorFreteVenda = 0;
	private String tipoDeFreteVenda;
	private double valorDeVenda = 0;
	private double valorCorretagemDeVenda = 0;
	private String statusCorretagemDeVenda = "";

	public long getCodigoProdutor() {
		return codigoProdutor;
	}

	public void setCodigoProdutor(long codigoProdutor) {
		this.codigoProdutor = codigoProdutor;
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public double getValorCorretagemDeVenda() {
		return valorCorretagemDeVenda;
	}

	public void setValorCorretagemDeVenda(double valorCorretagemDeVenda) {
		this.valorCorretagemDeVenda = valorCorretagemDeVenda;
	}

	public String getStatusCorretagemDeVenda() {
		return statusCorretagemDeVenda;
	}

	public void setStatusCorretagemDeVenda(String statusCorretagemDeVenda) {
		this.statusCorretagemDeVenda = statusCorretagemDeVenda;
	}

	public double getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getTipoDePessoaCompra() {
		return tipoDePessoaCompra;
	}

	public void setTipoDePessoaCompra(String tipoDePessoaCompra) {
		this.tipoDePessoaCompra = tipoDePessoaCompra;
	}

	public double getPrecoProdutor() {
		return precoProdutor;
	}

	public void setPrecoProdutor(double precoProdutor) {
		this.precoProdutor = precoProdutor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getQtSacos() {
		return qtSacos;
	}

	public void setQtSacos(double d) {
		this.qtSacos = d;
	}

	public String getEstadoSaidaMaterial() {
		return estadoSaidaMaterial;
	}

	public void setEstadoSaidaMaterial(String estadoSaidaMaterial) {
		this.estadoSaidaMaterial = estadoSaidaMaterial;
	}

	public String getEstadoFilial() {
		return estadoFilial;
	}

	public void setEstadoFilial(String estadoFilial) {
		this.estadoFilial = estadoFilial;
	}

	public String getAtividadeCompra() {
		return atividadeCompra;
	}

	public void setAtividadeCompra(String atividade) {
		this.atividadeCompra = atividade;
	}

	public String getProRural() {
		return proRural;
	}

	public void setProRural(String proRural) {
		this.proRural = proRural;
	}

	public String getFunRural() {
		return funRural;
	}

	public void setFunRural(String funRural) {
		this.funRural = funRural;
	}

	public String getTemFreteCompra() {
		return temFreteCompra;
	}

	public void setTemFreteCompra(String tipo) {
		this.temFreteCompra = tipo;
	}

	public double getValorFreteCompra() {
		return valorFreteCompra;
	}

	public void setValorFreteCompra(double valorFreteCompra) {
		this.valorFreteCompra = valorFreteCompra;
	}

	public void setTipoDeFreteCompra(String pfOuPj) {
		this.tipoDeFreteCompra = pfOuPj;
	}

	public String getAtividadeVenda() {
		return atividadeVenda;
	}

	public void setAtividadeVenda(String atividadeVenda) {
		this.atividadeVenda = atividadeVenda;
	}

	public String getTemFreteVenda() {
		return temFreteVenda;
	}

	public void setTemFreteVenda(String tipoFreteVenda) {
		this.temFreteVenda = tipoFreteVenda;
	}

	public double getValorFreteVenda() {
		return valorFreteVenda;
	}

	public void setValorFreteVenda(double valorFreteVenda) {
		this.valorFreteVenda = valorFreteVenda;
	}

	public String getTipoDeFreteVenda() {
		return tipoDeFreteVenda;
	}

	public void setTipoDeFreteVenda(String pfOuPjVenda) {
		this.tipoDeFreteVenda = pfOuPjVenda;
	}

	public String getTipoDeFreteCompra() {
		return tipoDeFreteCompra;
	}

	public double getValorCorretagemDeCompra() {
		return valorCorretagemDeCompra;
	}

	public void setValorCorretagemDeCompra(double valorCorretagemDeCompra) {
		this.valorCorretagemDeCompra = valorCorretagemDeCompra;
	}

	public String getStatusCorretagemDeCompra() {
		return statusCorretagemDeCompra;
	}

	public void setStatusCorretagemDeCompra(String statusCorretagemDeCompra) {
		this.statusCorretagemDeCompra = statusCorretagemDeCompra;
	}

}
