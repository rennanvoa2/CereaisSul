package br.com.cereaissul.Datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;

public class ParseData {

	public Date converteData(String data) throws ParseException {
		Date novaData = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try{
			novaData = sdf.parse(data);
			return novaData;
		} catch (RuntimeErrorException e) {
			throw new RuntimeException(e);
		}
		
	}
}
