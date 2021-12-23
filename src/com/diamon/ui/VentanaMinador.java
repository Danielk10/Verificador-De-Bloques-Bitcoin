package com.diamon.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.diamon.cifrado.CifradoSha256ProtocoloBitcoin;
import com.diamon.utilidad.FechaBitcoin;

public class VentanaMinador extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;

	private CifradoSha256ProtocoloBitcoin cifrado256Bitcoin;

	private JButton generarDobleHashSha256;

	private JButton minarBitcoin;

	private JTextField versionDeProtocoloBitcoin;

	private JTextField hashDeBloqueAnterior;

	private JTextField merkleRoot;

	private JTextField marcaDeTiempo;

	private JTextField bits;

	private JTextField nonce;

	private JTextField dia;

	private JTextField mes;

	private JTextField ano;

	private JTextField hora;

	private JTextField minutos;

	private JTextField segundos;

	private JLabel etiquetaVersionDeProtocoloBitcoin;

	private JLabel etiquetaHashDeBloqueAnterior;

	private JLabel etiquetaMerkleRoot;

	private JLabel etiquetaMarcaDeTiempo;

	private JLabel etiquetaBits;

	private JLabel etiquetaNonce;

	private JLabel etiquetaHashValido;

	private JLabel hashPorSegundos;

	private JLabel DoblehashPorSegundos;

	private JRadioButton conFecha;

	private JRadioButton conTiempoMaster;

	private long numeroDeTrabajo;

	private String objetivoDeDificultad;

	private volatile boolean minar;

	private FechaBitcoin fecha;

	private int contador;

	private int contadorTotal;

	private double segundosContados;

	private volatile boolean tiempoyFecha;

	private Thread hilo;

	private volatile boolean iniciar;

	public VentanaMinador() {

		super("Ventana De Minador");

		setSize(800, 600);

		setDefaultCloseOperation(VentanaMinador.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		setResizable(false);

		setLocationRelativeTo(null);

		cifrado256Bitcoin = new CifradoSha256ProtocoloBitcoin();

		fecha = new FechaBitcoin();

		numeroDeTrabajo = 0;

		contador = 0;

		contadorTotal = 0;

		segundosContados = 0;

		objetivoDeDificultad = "";

		minar = false;

		tiempoyFecha = false;

		iniciar = true;

		UI();

		generarDobleHashSha256.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent ev) {

				minar = false;

				pausa();

				String marcaTiempo = "";

				int nDia = 0;

				int nMes = 0;

				int nAno = 0;

				int nHora = 0;

				int nMinutos = 0;

				int nSegundos = 0;

				try {

					if (!tiempoyFecha) {

						nDia = Integer.parseInt(dia.getText());

						nMes = Integer.parseInt(mes.getText());

						nAno = Integer.parseInt(ano.getText());

						nHora = Integer.parseInt(hora.getText());

						nMinutos = Integer.parseInt(minutos.getText());

						nSegundos = Integer.parseInt(segundos.getText());

						long tiempo = fecha.getTiempoMaster(nDia, nMes, nAno, nHora, nMinutos, nSegundos);

						marcaTiempo = cifrado256Bitcoin.getBinario().decimalHexadecimal4Bytes("" + tiempo);

						marcaDeTiempo.setText(marcaTiempo);

					}

				} catch (Exception e) {

					marcaTiempo = marcaDeTiempo.getText();

				}

				if (tiempoyFecha) {

					marcaTiempo = marcaDeTiempo.getText();

				}

				String hashGenerado = cifrado256Bitcoin.generarHashDeBloqueBitcoin(versionDeProtocoloBitcoin.getText(),
						hashDeBloqueAnterior.getText(), merkleRoot.getText(), marcaTiempo, bits.getText(),
						nonce.getText());

				etiquetaHashValido.setText("Hash Valido: " + hashGenerado);

			}

			@Override
			public void mouseEntered(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

		});

		minarBitcoin.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent ev) {

				try {

					objetivoDeDificultad = cifrado256Bitcoin.getBinario().obtenerObjetivoDeDificultad(bits.getText());

					numeroDeTrabajo = cifrado256Bitcoin.getBinario()
							.hexadecimalDecimalOchoDigitos4Bytes(nonce.getText());

					minar = true;

					resumen();

				} catch (Exception e) {

					numeroDeTrabajo = 0;

					minar = false;

				}

			}

			@Override
			public void mouseEntered(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent ev) {

			}

		});

		setVisible(true);

		hilo = new Thread(this);

		hilo.start();

	}

	private void UI() {

		generarDobleHashSha256 = new JButton("Verificar Bloque Extraido - Generar Doble Hash Sha-256");

		minarBitcoin = new JButton("Minar Bitcoin - Bloque Extraido");

		versionDeProtocoloBitcoin = new JTextField("numero en Hexadecimal 4 Bytes", 55);
		hashDeBloqueAnterior = new JTextField("numero en Hexadecimal 32 Bytes", 55);
		merkleRoot = new JTextField("numero en Hexadecimal 32 Bytes", 60);
		marcaDeTiempo = new JTextField("numero en Hexadecimal 4 Bytes", 42);
		bits = new JTextField("numero en Hexadecimal 4 Bytes", 68);
		nonce = new JTextField("numero en Hexadecimal 4 Bytes", 60);

		dia = new JTextField("dia", 10);
		mes = new JTextField("mes", 10);
		ano = new JTextField("ano", 10);
		hora = new JTextField("hora", 10);
		minutos = new JTextField("minutos", 10);
		segundos = new JTextField("segundos", 10);

		etiquetaVersionDeProtocoloBitcoin = new JLabel("Version de Protocolo Bitcoin");
		etiquetaHashDeBloqueAnterior = new JLabel("Hash del Bloque Anterior");
		etiquetaMerkleRoot = new JLabel("Merkle Root");
		etiquetaMarcaDeTiempo = new JLabel("Marca de Tiempo (Timestamp)");
		etiquetaBits = new JLabel("Bits");
		etiquetaNonce = new JLabel("Nonce");

		etiquetaHashValido = new JLabel("Hash Valido: ");

		hashPorSegundos = new JLabel("Hash/s: ");

		DoblehashPorSegundos = new JLabel("Doble Hash/s: ");

		conFecha = new JRadioButton("Fecha");

		conTiempoMaster = new JRadioButton("Tiempo");

		marcaDeTiempo.disable();

		ButtonGroup seleccion = new ButtonGroup();

		seleccion.add(conFecha);

		seleccion.add(conTiempoMaster);

		ButtonModel modelo = conFecha.getModel();

		modelo.setSelected(true);

		seleccion.setSelected(modelo, true);

		conFecha.addActionListener(this);

		conTiempoMaster.addActionListener(this);

		add(etiquetaVersionDeProtocoloBitcoin);

		add(versionDeProtocoloBitcoin);

		add(etiquetaHashDeBloqueAnterior);

		add(hashDeBloqueAnterior);

		add(etiquetaMerkleRoot);

		add(merkleRoot);

		add(etiquetaMarcaDeTiempo);

		add(conFecha);

		add(dia);

		add(mes);

		add(ano);

		add(hora);

		add(minutos);

		add(segundos);

		add(conTiempoMaster);

		add(marcaDeTiempo);

		add(etiquetaBits);

		add(bits);

		add(etiquetaNonce);

		add(nonce);

		add(generarDobleHashSha256);

		add(minarBitcoin);

		add(etiquetaHashValido);

		add(hashPorSegundos);

		add(DoblehashPorSegundos);

	}

	public void resumen() {

		iniciar = true;
		hilo = new Thread(this);
		hilo.start();

	}

	public void pausa() {

		iniciar = false;
		while (true) {
			try {
				hilo.join();

				return;

			} catch (InterruptedException e) {

			}

		}

	}

	@Override
	public void run() {

		String hashGenerado = "";

		while (iniciar) {

			if (minar) {

				long delta = System.nanoTime();

				String marcaTiempo = "";

				int nDia = 0;

				int nMes = 0;

				int nAno = 0;

				int nHora = 0;

				int nMinutos = 0;

				int nSegundos = 0;

				try {

					if (!tiempoyFecha) {

						nDia = Integer.parseInt(dia.getText());

						nMes = Integer.parseInt(mes.getText());

						nAno = Integer.parseInt(ano.getText());

						nHora = Integer.parseInt(hora.getText());

						nMinutos = Integer.parseInt(minutos.getText());

						nSegundos = Integer.parseInt(segundos.getText());

						long tiempo = fecha.getTiempoMaster(nDia, nMes, nAno, nHora, nMinutos, nSegundos);

						marcaTiempo = cifrado256Bitcoin.getBinario().decimalHexadecimal4Bytes("" + tiempo);

						marcaDeTiempo.setText(marcaTiempo);

					}

				} catch (Exception e) {

					marcaTiempo = marcaDeTiempo.getText();

				}

				if (tiempoyFecha) {

					marcaTiempo = marcaDeTiempo.getText();

				}

				final String numeroNonce = cifrado256Bitcoin.getBinario()
						.decimalHexadecimal4Bytes("" + numeroDeTrabajo);

				hashGenerado = cifrado256Bitcoin.generarHashDeBloqueBitcoin(versionDeProtocoloBitcoin.getText(),
						hashDeBloqueAnterior.getText(), merkleRoot.getText(), marcaTiempo, bits.getText(), numeroNonce);

				nonce.setText(numeroNonce);

				etiquetaHashValido.setText("Hash Valido: " + hashGenerado);

				try {

					BigInteger numero1 = new BigInteger(
							cifrado256Bitcoin.getBinario().hexadecimalDecimalGigante(objetivoDeDificultad));

					BigInteger numero2 = new BigInteger(
							cifrado256Bitcoin.getBinario().hexadecimalDecimalGigante(hashGenerado));

					if (numero2.compareTo(numero1) < 0) {

						minar = false;

					}

				} catch (Exception e) {

				}

				contador++;

				numeroDeTrabajo++;

				segundosContados += System.nanoTime() - delta;

				if ((segundosContados / 1000000000) >= 1) {

					contadorTotal = contador;

					hashPorSegundos.setText("Hash/s: " + contadorTotal * 2);

					DoblehashPorSegundos.setText("Boble Hash/s: " + contadorTotal);

					contador = 0;

					segundosContados = 0;

				}

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if (ev.getActionCommand().equals("Fecha")) {

			dia.enable();

			mes.enable();

			ano.enable();

			hora.enable();

			segundos.enable();

			minutos.enable();

			marcaDeTiempo.disable();

			tiempoyFecha = false;
		}

		if (ev.getActionCommand().equals("Tiempo")) {

			marcaDeTiempo.enable();

			dia.disable();

			mes.disable();

			ano.disable();

			hora.disable();

			segundos.disable();

			minutos.disable();

			tiempoyFecha = true;

		}

	}

}
