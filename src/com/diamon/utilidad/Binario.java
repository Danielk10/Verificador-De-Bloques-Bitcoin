package com.diamon.utilidad;

import java.math.BigInteger;

public class Binario {

	public Binario() {

	}

	public byte[] bytesNoInvertidosBigEndian(String numeroHexadecimal) {

		byte[] paresDeMedioByte = new byte[numeroHexadecimal.length() / 2];

		if (!(numeroHexadecimal == null)) {

			StringBuilder[] paresDeByte = new StringBuilder[paresDeMedioByte.length];

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeByte[i] = new StringBuilder();

			}

			int j = 0;

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeByte[i].append(numeroHexadecimal.charAt(j));

				j++;

				paresDeByte[i].append(numeroHexadecimal.charAt(j));

				j++;

			}

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeMedioByte[i] = (byte) hexadecimalDecimalCorto(paresDeByte[i].toString());

			}

		}

		return paresDeMedioByte;

	}

	public byte[] bytesInvertidosLittleEndian(String numeroHexadecimal) {

		byte[] paresDeMedioByteInvertidos = new byte[numeroHexadecimal.length() / 2];

		byte[] paresDeMedioByte = new byte[paresDeMedioByteInvertidos.length];

		if (!(numeroHexadecimal == null)) {

			StringBuilder[] paresDeByte = new StringBuilder[paresDeMedioByteInvertidos.length];

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeByte[i] = new StringBuilder();

			}

			int j = 0;

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeByte[i].append(numeroHexadecimal.charAt(j));

				j++;

				paresDeByte[i].append(numeroHexadecimal.charAt(j));

				j++;

			}

			for (int i = 0; i < paresDeByte.length; i++) {

				paresDeMedioByte[i] = (byte) hexadecimalDecimalCorto(paresDeByte[i].toString());

			}

			int indice = 0;

			for (int i = paresDeMedioByte.length - 1; i >= 0; i--) {

				paresDeMedioByteInvertidos[indice] = paresDeMedioByte[i];

				indice++;

			}
		}
		return paresDeMedioByteInvertidos;

	}

	private int hexadecimalDecimalCorto(String numeroHexadecimal) {

		int[] numeros = new int[numeroHexadecimal.length()];

		int numeroDecimal = 0;

		for (int i = 0; i < numeros.length; i++) {

			if (numeroHexadecimal.charAt(i) == '0') {

				numeros[i] = 0;

			}
			if (numeroHexadecimal.charAt(i) == '1') {

				numeros[i] = 1;

			}
			if (numeroHexadecimal.charAt(i) == '2') {

				numeros[i] = 2;

			}
			if (numeroHexadecimal.charAt(i) == '3') {

				numeros[i] = 3;

			}
			if (numeroHexadecimal.charAt(i) == '4') {

				numeros[i] = 4;

			}
			if (numeroHexadecimal.charAt(i) == '5') {

				numeros[i] = 5;

			}
			if (numeroHexadecimal.charAt(i) == '6') {

				numeros[i] = 6;

			}
			if (numeroHexadecimal.charAt(i) == '7') {

				numeros[i] = 7;

			}
			if (numeroHexadecimal.charAt(i) == '8') {

				numeros[i] = 8;

			}
			if (numeroHexadecimal.charAt(i) == '9') {

				numeros[i] = 9;

			}
			if (numeroHexadecimal.charAt(i) == 'a') {

				numeros[i] = 10;

			}
			if (numeroHexadecimal.charAt(i) == 'b') {

				numeros[i] = 11;

			}
			if (numeroHexadecimal.charAt(i) == 'c') {

				numeros[i] = 12;

			}
			if (numeroHexadecimal.charAt(i) == 'd') {

				numeros[i] = 13;

			}
			if (numeroHexadecimal.charAt(i) == 'e') {

				numeros[i] = 14;

			}
			if (numeroHexadecimal.charAt(i) == 'f') {

				numeros[i] = 15;

			}

			if (numeroHexadecimal.charAt(i) == 'A') {

				numeros[i] = 10;

			}
			if (numeroHexadecimal.charAt(i) == 'B') {

				numeros[i] = 11;

			}
			if (numeroHexadecimal.charAt(i) == 'C') {

				numeros[i] = 12;

			}
			if (numeroHexadecimal.charAt(i) == 'D') {

				numeros[i] = 13;

			}
			if (numeroHexadecimal.charAt(i) == 'E') {

				numeros[i] = 14;

			}
			if (numeroHexadecimal.charAt(i) == 'F') {

				numeros[i] = 15;

			}

			numeroDecimal = numeros[1] + numeros[0] * (16);
		}

		return numeroDecimal;

	}

	public long hexadecimalDecimalOchoDigitos4Bytes(String numeroHexadecimal) {

		int[] numero = new int[numeroHexadecimal.length()];

		for (int i = 0; i < numeroHexadecimal.length(); i++) {

			if (numeroHexadecimal.charAt(i) == '0') {

				numero[i] = 0;

			}
			if (numeroHexadecimal.charAt(i) == '1') {

				numero[i] = 1;

			}
			if (numeroHexadecimal.charAt(i) == '2') {

				numero[i] = 2;

			}
			if (numeroHexadecimal.charAt(i) == '3') {

				numero[i] = 3;

			}
			if (numeroHexadecimal.charAt(i) == '4') {

				numero[i] = 4;

			}
			if (numeroHexadecimal.charAt(i) == '5') {

				numero[i] = 5;

			}
			if (numeroHexadecimal.charAt(i) == '6') {

				numero[i] = 6;

			}
			if (numeroHexadecimal.charAt(i) == '7') {

				numero[i] = 7;

			}
			if (numeroHexadecimal.charAt(i) == '8') {

				numero[i] = 8;

			}
			if (numeroHexadecimal.charAt(i) == '9') {
				numero[i] = 9;

			}
			if (numeroHexadecimal.charAt(i) == 'a') {
				numero[i] = 10;

			}
			if (numeroHexadecimal.charAt(i) == 'b') {

				numero[i] = 11;

			}
			if (numeroHexadecimal.charAt(i) == 'c') {

				numero[i] = 12;

			}
			if (numeroHexadecimal.charAt(i) == 'd') {

				numero[i] = 13;

			}
			if (numeroHexadecimal.charAt(i) == 'e') {

				numero[i] = 14;

			}
			if (numeroHexadecimal.charAt(i) == 'f') {

				numero[i] = 15;

			}

			if (numeroHexadecimal.charAt(i) == 'A') {

				numero[i] = 10;

			}
			if (numeroHexadecimal.charAt(i) == 'B') {

				numero[i] = 11;

			}
			if (numeroHexadecimal.charAt(i) == 'C') {

				numero[i] = 12;

			}
			if (numeroHexadecimal.charAt(i) == 'D') {

				numero[i] = 13;

			}
			if (numeroHexadecimal.charAt(i) == 'E') {

				numero[i] = 14;

			}
			if (numeroHexadecimal.charAt(i) == 'F') {

				numero[i] = 15;

			}

		}

		long numeroDecimalTemporal = 0;

		long numeroDecimal = 0;

		for (int i = 0; i < numero.length; i++) {

			if (i <= numero.length - 3) {

				numeroDecimalTemporal = (long) (numero[i] * Math.pow(16, ((numero.length - 1) - i)));

				numeroDecimal += numeroDecimalTemporal;
			}

			if (i == numero.length - 1) {

				numeroDecimalTemporal = numero[numero.length - 1];

				numeroDecimal += numeroDecimalTemporal;

			}

			if (i == numero.length - 2) {

				numeroDecimalTemporal = (long) (numero[numero.length - 2] * (16));

				numeroDecimal += numeroDecimalTemporal;

			}

		}

		return numeroDecimal;

	}

	public String hexadecimal4BytesAHexadecimal32Bytes(String numeroHexadecimal) {

		String numeroHexadecimalTemporal = numeroHexadecimal;

		String numeroHexadecimal32Bytes = "";

		StringBuilder ceros = new StringBuilder();

		for (int i = 0; i < 64; i++) {

			if (numeroHexadecimalTemporal.length() == i + 1) {

				for (int j = 0; j < 64 - (i + 1); j++) {

					ceros.append("0");

				}

				numeroHexadecimal32Bytes = ceros + numeroHexadecimalTemporal;

			}

		}

		return numeroHexadecimal32Bytes;

	}

	public String decimalHexadecimal4Bytes(String numeroDecimalTexto) {

		String numeroDecimalTemporal = null;

		long numeroDecimalNuevo = 0;

		try {

			numeroDecimalNuevo = Long.parseLong(numeroDecimalTexto);

		} catch (Exception e) {

			numeroDecimalTemporal = "00000000";

		}

		StringBuilder ceros = new StringBuilder();

		try {

			numeroDecimalTemporal = Long.toHexString(numeroDecimalNuevo);

		} catch (Exception e) {

			numeroDecimalTemporal = "00000000";

		}

		String numeroHexadecimal4Bytes = "";

		for (int i = 0; i < 8; i++) {

			if (numeroDecimalTemporal.length() == i + 1) {

				for (int j = 0; j < 8 - (i + 1); j++) {

					ceros.append("0");

				}

				numeroHexadecimal4Bytes = ceros.toString() + numeroDecimalTemporal;

			}

		}

		return numeroHexadecimal4Bytes;

	}

	public String hexadecimalDecimalGigante(String textoHexadecimal) {

		StringBuilder[] numeroDecimal = new StringBuilder[textoHexadecimal.length()];

		for (int i = 0; i < textoHexadecimal.length(); i++) {

			numeroDecimal[i] = new StringBuilder();

		}

		for (int i = 0; i < textoHexadecimal.length(); i++) {

			if (textoHexadecimal.charAt(i) == '0') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '1') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '2') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '3') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '4') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '5') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '6') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '7') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '8') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '9') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == 'a') {

				numeroDecimal[i].append("10");
			}
			if (textoHexadecimal.charAt(i) == 'b') {

				numeroDecimal[i].append("11");

			}
			if (textoHexadecimal.charAt(i) == 'c') {

				numeroDecimal[i].append("12");

			}
			if (textoHexadecimal.charAt(i) == 'd') {

				numeroDecimal[i].append("13");

			}
			if (textoHexadecimal.charAt(i) == 'e') {

				numeroDecimal[i].append("14");

			}
			if (textoHexadecimal.charAt(i) == 'f') {

				numeroDecimal[i].append("15");

			}

			if (textoHexadecimal.charAt(i) == 'A') {

				numeroDecimal[i].append("10");
			}
			if (textoHexadecimal.charAt(i) == 'B') {

				numeroDecimal[i].append("11");

			}
			if (textoHexadecimal.charAt(i) == 'C') {

				numeroDecimal[i].append("12");

			}
			if (textoHexadecimal.charAt(i) == 'D') {

				numeroDecimal[i].append("13");

			}
			if (textoHexadecimal.charAt(i) == 'E') {

				numeroDecimal[i].append("14");

			}
			if (textoHexadecimal.charAt(i) == 'F') {

				numeroDecimal[i].append("15");

			}

		}

		BigInteger[] numeros = new BigInteger[numeroDecimal.length];

		BigInteger[] partes = new BigInteger[numeroDecimal.length];

		BigInteger[] suma = new BigInteger[numeroDecimal.length - 1];

		BigInteger base = new BigInteger("16");

		for (int i = 0; i < numeros.length; i++) {

			numeros[i] = new BigInteger(numeroDecimal[i].toString());

		}

		int indice = numeros.length - 1;

		for (int i = 0; i < numeros.length; i++) {

			partes[i] = numeros[indice].multiply(base.pow(i));

			indice--;

		}

		suma[0] = partes[0].add(partes[1]);

		for (int i = 1; i < numeros.length - 1; i++) {

			suma[i] = suma[i - 1].add(partes[i + 1]);

		}

		BigInteger numeroDe = suma[suma.length - 1];

		return numeroDe.toString();

	}

	public String decimalGiganteHexadecimal(String numeroDecimal) {

		BigInteger numero = new BigInteger(numeroDecimal);

		BigInteger base = new BigInteger("16");

		int potencia = 0;

		for (int i = 0; i < 100000; i++) {

			if (base.pow(i).bitLength() >= numero.bitLength()) {

				potencia = i - 1;

				break;

			}

		}

		BigInteger[] division = new BigInteger[potencia];

		BigInteger[] resto = new BigInteger[potencia];

		division[0] = numero.divide(base.pow(potencia));

		resto[0] = numero.mod(base.pow(potencia));

		for (int i = 1; i < potencia; i++) {

			division[i] = resto[i - 1].divide(base.pow(potencia - i));

			resto[i] = resto[i - 1].mod(base.pow(potencia - i));

		}

		String[] num = new String[potencia + 1];

		for (int i = 0; i < potencia; i++) {

			num[i] = division[i].toString();

			if (i == potencia - 1) {

				num[i + 1] = resto[i].toString();

			}

		}

		StringBuilder numeroHexadecimal = new StringBuilder();

		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < 16; j++) {

				if (num[i].equals("" + j)) {

					if (j == 10) {

						numeroHexadecimal.append("A");

					} else if (j == 11) {

						numeroHexadecimal.append("B");

					} else if (j == 12) {

						numeroHexadecimal.append("C");

					} else if (j == 13) {

						numeroHexadecimal.append("D");

					} else if (j == 14) {

						numeroHexadecimal.append("E");

					} else if (j == 15) {

						numeroHexadecimal.append("F");

					} else {

						numeroHexadecimal.append("" + j);

					}

				}

			}

		}

		return numeroHexadecimal.toString();

	}

	public String obtenerObjetivoDeDificultad(String bitsHexadecimal) {

		long exponente = hexadecimalDecimalOchoDigitos4Bytes(bitsHexadecimal) >> 24;

		long numoroObtenido = hexadecimalDecimalOchoDigitos4Bytes(bitsHexadecimal) & 0xffffff;

		BigInteger numeroGrande = new BigInteger("1");

		int desplazar = (int) (8 * (exponente - 3));

		BigInteger numeroGrande2 = new BigInteger(String.valueOf(numoroObtenido));

		BigInteger numeroGrande3 = numeroGrande.shiftLeft(desplazar);

		BigInteger numero = numeroGrande2.multiply(numeroGrande3);

		BigInteger base = new BigInteger("16");

		int potencia = 0;

		for (int i = 0; i < 100000; i++) {

			if (base.pow(i).compareTo(numero) >= 1) {

				potencia = i - 1;

				break;

			}

		}

		BigInteger[] division = new BigInteger[potencia];

		BigInteger[] resto = new BigInteger[potencia];

		division[0] = numero.divide(base.pow(potencia));

		resto[0] = numero.mod(base.pow(potencia));

		for (int i = 1; i < potencia; i++) {

			division[i] = resto[i - 1].divide(base.pow(potencia - i));

			resto[i] = resto[i - 1].mod(base.pow(potencia - i));

		}

		String[] numeroDecimal = new String[potencia + 1];

		for (int i = 0; i < potencia; i++) {

			numeroDecimal[i] = division[i].toString();

			if (i == potencia - 1) {

				numeroDecimal[i + 1] = resto[i].toString();

			}

		}

		StringBuilder numeroHexadecimal = new StringBuilder();

		for (int i = 0; i < numeroDecimal.length; i++) {

			for (int j = 0; j < 16; j++) {

				if (numeroDecimal[i].equals("" + j)) {

					if (j == 10) {

						numeroHexadecimal.append("A");

					} else if (j == 11) {

						numeroHexadecimal.append("B");

					} else if (j == 12) {

						numeroHexadecimal.append("C");

					} else if (j == 13) {

						numeroHexadecimal.append("D");

					} else if (j == 14) {

						numeroHexadecimal.append("E");

					} else if (j == 15) {

						numeroHexadecimal.append("F");

					} else {

						numeroHexadecimal.append("" + j);

					}

				}

			}

		}

		String objetivo = hexadecimal4BytesAHexadecimal32Bytes(numeroHexadecimal.toString());

		return objetivo;

	}

}
