package br.com.cereaissul.TransformaReais;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TransformaReais {
	public double transforma(double valorParaAproximar) {

		BigDecimal bd1 = new BigDecimal(valorParaAproximar).setScale(2, RoundingMode.HALF_EVEN);

		return (bd1.doubleValue());

	}

}
