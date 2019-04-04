package br.com.cereaissul.Datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculaDatas {

	public void calculaDataPonderada(String[] dataForn, Double[] kgForn, String[] dataCliente, Double[] kgCliente)
			throws ParseException {
		double pesoTotalForn = calculaSoma(kgCliente);
		Double[] pesoIndividual = new Double[4];
		long[] diasDeDiferenca = new long[4];


		// Preenche peso indivudual com o peso de cada data e os dias de
		// diferença entre cada data.
		ponderaPeso(kgCliente, pesoIndividual, pesoTotalForn);
		diasDeDiferenca(dataCliente, diasDeDiferenca);
		//pondera o peso e a diferenca de dias entre as datas pra chegar em uma data ponderada, esse valor + a data inicial é a data ponderada
		double diasParaDataPonderada = Math.round((((pesoIndividual[0] * diasDeDiferenca[0]) + (pesoIndividual[1] * diasDeDiferenca[1])
				+ (pesoIndividual[2] * diasDeDiferenca[2]) + (pesoIndividual[3] * diasDeDiferenca[3])) / 100)-1);
	}
	
	

	// Calcula a quantidade total de dias de juros
	public void diasDeDiferenca(String[] datas, long[] dias) throws ParseException {

		for (int i = 0; i < datas.length; i++) {
			dias[i] = (diferencaEntreDuasDatas(datas[i], datas[0]) + 1);
		}

	}

	// calcula a diferença em dias entre duas datas
	public long diferencaEntreDuasDatas(String data1, String data2) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		Date d1 = df.parse(data1);
		Date d2 = df.parse(data2);
		long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para
															// compensar horário
															// de verão
		dt = (dt / 86400000L);
		return dt;
	}

	// Soma os valores de um array
	private double calculaSoma(Double[] array) {
		double valor = 0;
		for (int i = 0; i < array.length; i++) {
			valor += array[i];
		}
		return valor;
	}

	// Pondera o peso individual / peso total de cada carregamento
	private void ponderaPeso(Double[] kgCliente, Double[] pesoIndividual, double pesoTotalForn) {
		for (int i = 0; i < kgCliente.length; i++) {
			if (kgCliente[i] != null) {
				pesoIndividual[i] = kgCliente[i] / pesoTotalForn;
			}

		}
	}

}
