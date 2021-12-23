package com.diamon.cifrado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.diamon.utilidad.Binario;

public class CifradoSha256ProtocoloBitcoin {

	private Binario binario;

	public CifradoSha256ProtocoloBitcoin() {

		binario = new Binario();

	}

	public String generarHashDeBloqueBitcoin(String versionDeProtocoloBitcoinHexadecimal,
			String hashDeBloqueAnteriorHexadecimal, String merkleRootHexadecimal, String marcaDeTiempoHexadecimal,
			String bitsHexadecimal, String nonceHexadecimal) {

		MessageDigest sha256 = null;

		byte[] versionDeProtocoloBitcoin = binario.bytesInvertidosLittleEndian(binario.decimalHexadecimal4Bytes(
				"" + binario.hexadecimalDecimalOchoDigitos4Bytes(versionDeProtocoloBitcoinHexadecimal)));

		byte[] hashDeBloqueAnterior = binario.bytesInvertidosLittleEndian(hashDeBloqueAnteriorHexadecimal);

		byte[] merkleRoot = binario.bytesInvertidosLittleEndian(merkleRootHexadecimal);

		byte[] marcaDeTiempo = binario.bytesInvertidosLittleEndian(binario
				.decimalHexadecimal4Bytes("" + binario.hexadecimalDecimalOchoDigitos4Bytes(marcaDeTiempoHexadecimal)));

		byte[] bits = binario.bytesInvertidosLittleEndian(
				binario.decimalHexadecimal4Bytes("" + binario.hexadecimalDecimalOchoDigitos4Bytes(bitsHexadecimal)));

		byte[] nonce = binario.bytesInvertidosLittleEndian(
				binario.decimalHexadecimal4Bytes("" + binario.hexadecimalDecimalOchoDigitos4Bytes(nonceHexadecimal)));

		byte[] cabeceraDeBloqueBitcoin = new byte[versionDeProtocoloBitcoin.length + hashDeBloqueAnterior.length
				+ merkleRoot.length + marcaDeTiempo.length + bits.length + nonce.length];

		int indice1 = 0;

		for (int i = 0; i < versionDeProtocoloBitcoin.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = versionDeProtocoloBitcoin[i];

			indice1++;

		}

		for (int i = 0; i < hashDeBloqueAnterior.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = hashDeBloqueAnterior[i];

			indice1++;
		}

		for (int i = 0; i < merkleRoot.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = merkleRoot[i];

			indice1++;
		}

		for (int i = 0; i < marcaDeTiempo.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = marcaDeTiempo[i];

			indice1++;
		}

		for (int i = 0; i < bits.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = bits[i];

			indice1++;
		}

		for (int i = 0; i < nonce.length; i++) {

			cabeceraDeBloqueBitcoin[indice1] = nonce[i];

			indice1++;

		}

		try {
			sha256 = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] cifradoSha256EnBytes = sha256.digest(sha256.digest(cabeceraDeBloqueBitcoin));

		StringBuilder cifradoSha256InvertidoLittleEndian = new StringBuilder();

		for (byte bytes : cifradoSha256EnBytes) {

			cifradoSha256InvertidoLittleEndian.append(String.format("%02x", bytes));

		}

		StringBuilder[] paresDeBytesInvertidos = new StringBuilder[cifradoSha256InvertidoLittleEndian.toString()
				.length() / 2];

		for (int i = 0; i < paresDeBytesInvertidos.length; i++) {

			paresDeBytesInvertidos[i] = new StringBuilder();

		}

		int indice2 = 0;

		for (int i = 0; i < paresDeBytesInvertidos.length; i++) {

			paresDeBytesInvertidos[i].append(cifradoSha256InvertidoLittleEndian.toString().charAt(indice2));

			indice2++;

			paresDeBytesInvertidos[i].append(cifradoSha256InvertidoLittleEndian.toString().charAt(indice2));

			indice2++;

		}

		StringBuilder cifradoSha256BigEndian = new StringBuilder();

		for (int i = paresDeBytesInvertidos.length - 1; i >= 0; i--) {

			cifradoSha256BigEndian.append(paresDeBytesInvertidos[i].toString());

		}

		return cifradoSha256BigEndian.toString();

	}

	public Binario getBinario() {

		return binario;
	}

}
