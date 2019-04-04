package br.com.cereaissul.Frete;
public class Frete {
	double valorFrete;
	double impostoFrete;

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public double getImpostoFrete() {
		return impostoFrete;
	}

	public void setImpostoFrete(double impostoFrete) {
		this.impostoFrete = impostoFrete;
	}

	public double calculaImpostosFrete(double valorTotal) {
		// SE O FRETE FOR PF ESSE MÉTODO DEVE CALCULAR OS IMPOSTOS SOBRE ESTE
		// FRETE
		double inss = 0;
		double irpf = 0;
		double baseIrpf = 0;
		double soma = 0;
		double sest = 0;
		double senat = 0;

		if (valorTotal <= 1659.38) {
			inss = valorTotal * 0.08;
		} else if (valorTotal > 1659.38 && valorTotal <= 2765.66) {
			inss = valorTotal * 0.09;
		} else if (valorTotal > 2765.66 && valorTotal <= 5531.31) {
			inss = valorTotal * 0.11;
		} else {
			inss = 5531.31 * 0.11;
		}
		baseIrpf = (valorTotal - inss) * 0.1;
		if (baseIrpf <= 1903.98) {
			irpf = 0;
		} else if (baseIrpf > 1903.98 && baseIrpf <= 2826.65) {
			irpf = (baseIrpf * 0.075) - 142.8;
		} else if (baseIrpf > 2826.65 && baseIrpf <= 3751.06) {
			irpf = (baseIrpf * 0.15) - 354.8;
		} else if (baseIrpf > 3751.06 && baseIrpf <= 4664.68) {
			irpf = (baseIrpf * 0.225) - 636.13;
		} else {
			irpf = (baseIrpf * 0.275) - 869.36;
		}

		sest = baseIrpf * 0.015;
		senat = baseIrpf * 0.01;
		soma = inss + irpf + sest + senat;
		return soma;
	}

}
