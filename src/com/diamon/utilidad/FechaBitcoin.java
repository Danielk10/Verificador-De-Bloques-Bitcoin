package com.diamon.utilidad;

import java.util.Date;

public class FechaBitcoin {

	public FechaBitcoin() {
		// TODO Auto-generated constructor stub
	}

	public long getTiempoMaster(int dia, int mes, int ano, int hora, int minutos, int segundos) {

		int tm = minutos;

		mes = mes - 1;

		int tiemp = 1462086000;

		int ti = 0;

		int ta = 0;

		if (ano >= 2000) {

			ta = ano - 2000;

			ta = 100 + ta;

		}

		if (ano < 2000) {

			ta = ano - 1900;

		}

		Date fechac = new Date();

		fechac.setYear(ta);

		fechac.setMonth(mes);

		fechac.setDate(dia);

		fechac.setHours(hora);

		fechac.setMinutes(minutos);

		fechac.setSeconds(segundos);

		StringBuilder numero = new StringBuilder();

		String t = "" + fechac.getTime();

		numero.append(t.charAt(0));
		numero.append(t.charAt(1));
		numero.append(t.charAt(2));
		numero.append(t.charAt(3));
		numero.append(t.charAt(4));
		numero.append(t.charAt(5));
		numero.append(t.charAt(6));
		numero.append(t.charAt(7));
		numero.append(t.charAt(8));
		numero.append(t.charAt(9));

		ti = Integer.parseInt(numero.toString());

		
		
		
		
		
		
		
		
		if (ti < tiemp) {

			tm = minutos - 30;

		}
		
		
		
		
		
		
		
		

		Date fecha = new Date();

		fecha.setYear(ta);

		fecha.setMonth(mes);

		fecha.setDate(dia);

		fecha.setHours(hora);

		fecha.setMinutes(tm);

		fecha.setSeconds(segundos);

		int tiempoMaster = 0;

		StringBuilder numeroMaster = new StringBuilder();

		String tM = "" + fecha.getTime();

		numeroMaster.append(tM.charAt(0));
		numeroMaster.append(tM.charAt(1));
		numeroMaster.append(tM.charAt(2));
		numeroMaster.append(tM.charAt(3));
		numeroMaster.append(tM.charAt(4));
		numeroMaster.append(tM.charAt(5));
		numeroMaster.append(tM.charAt(6));
		numeroMaster.append(tM.charAt(7));
		numeroMaster.append(tM.charAt(8));
		numeroMaster.append(tM.charAt(9));

		tiempoMaster = Integer.parseInt(numeroMaster.toString());

		return tiempoMaster;

	}

	public long getTiempoMasterNuevo(int dia, int mes, int ano, int hora, int minutos, int segundos) {

		Date fecha = null;

		int ta = 0;

		if (ano >= 2000) {

			ta = ano - 2000;

			ta = 100 + ta;

		}

		if (ano < 2000) {

			ta = ano - 1900;

		}

		if (dia != 0 || mes != 0 || ano != 0 || hora != 0 || minutos != 0 || segundos != 0) {

			fecha = new Date();

			fecha.setDate(dia);

			mes = mes - 1;

			fecha.setMonth(mes);

			fecha.setYear(ta);

			ano = fecha.getYear();

			fecha.setHours(hora);

			fecha.setMinutes(minutos);

			fecha.setSeconds(segundos);

		} else {

			fecha = new Date();

		}

		int tiempoMaster = 0;

		StringBuilder numeroMaster = new StringBuilder();

		String tM = "" + fecha.getTime();

		numeroMaster.append(tM.charAt(0));
		numeroMaster.append(tM.charAt(1));
		numeroMaster.append(tM.charAt(2));
		numeroMaster.append(tM.charAt(3));
		numeroMaster.append(tM.charAt(4));
		numeroMaster.append(tM.charAt(5));
		numeroMaster.append(tM.charAt(6));
		numeroMaster.append(tM.charAt(7));
		numeroMaster.append(tM.charAt(8));
		numeroMaster.append(tM.charAt(9));

		tiempoMaster = Integer.parseInt(numeroMaster.toString());

		return tiempoMaster;

	}

}
