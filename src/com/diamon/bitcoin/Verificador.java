package com.diamon.bitcoin;

import com.diamon.ui.VentanaMinador;
import com.diamon.utilidad.FechaBitcoin;

public class Verificador {

	public static void main(String[] args) {

		new VentanaMinador();

		FechaBitcoin fecha = new FechaBitcoin();

		System.out.println(fecha.getTiempoMaster(8, 7, 2014, 2, 53, 44));

		System.out.println(fecha.getTiempoMasterNuevo(0, 0, 0, 0, 0, 0));

	}

}
