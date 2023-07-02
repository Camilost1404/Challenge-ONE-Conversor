package challenge_conversor;

import java.util.ArrayList;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		int opcionPrincipal = 0;

		do {

			try {
				opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
						"---------- Bienvenido al conversor ONE ----------" + "\n1. Conversor monedas" + "\n2. Salir"
								+ "\n---------- Selecciona una opción ----------",
						"Conversores", JOptionPane.QUESTION_MESSAGE));

				switch (opcionPrincipal) {
				case 1:

					ConversorMoneda objConversorMoneda = new ConversorMoneda();

					ArrayList<String> monedas = new ArrayList<>();

					int opcionSecundaria = 0;

					do {

						try {
							opcionSecundaria = Integer.parseInt(JOptionPane.showInputDialog(null,
									"---------- Bienvenido al conversor ONE ----------" + "\n1. Convertir monedas"
											+ "\n2.Añadir moneda nueva" + "\n3. Actualizar divisas" + "\n4.Regresar"
											+ "\n5. Salir" + "\n---------- Selecciona una opción ----------",
									"Conversor monedas", JOptionPane.QUESTION_MESSAGE));

							switch (opcionSecundaria) {
							case 1:

								monedas = objConversorMoneda.getMonedas();
								
								String valor = JOptionPane.showInputDialog(null, "Digita el valor: ");

								boolean valorEsValido = true;

								do {

									objConversorMoneda.validarValor(valor);

									if (!valorEsValido) {
										JOptionPane.showMessageDialog(null, "Digita un valor valido");
									}

								} while (!valorEsValido);

								String monedaActual = (String) JOptionPane.showInputDialog(null,
										"Seleccione la moneda actual:", "Conversor de Monedas",
										JOptionPane.QUESTION_MESSAGE, null, monedas.toArray(), monedas.get(0));

								String monedaDestino = (String) JOptionPane.showInputDialog(null,
										"Seleccione la moneda a convertir:", "Conversor de Monedas",
										JOptionPane.QUESTION_MESSAGE, null, monedas.toArray(), monedas.get(0));

								double valorConvertido = objConversorMoneda.convertir(Double.parseDouble(valor),
										monedaActual, monedaDestino);

								JOptionPane.showMessageDialog(null, Double.parseDouble(valor) + " " + monedaActual
										+ " son " + valorConvertido + " " + monedaDestino);

								break;

							case 2:

								String monedaNueva = JOptionPane.showInputDialog(null,
										"Escribe el estándar internacional de la moneda");

								String divisaNueva;

								boolean divisaNuevaEsValida = true;

								do {

									divisaNueva = JOptionPane.showInputDialog(null, "Ingresa la divisa de la moneda");

									divisaNuevaEsValida = objConversorMoneda.validarDivisa(divisaNueva);

									if (!divisaNuevaEsValida) {
										JOptionPane.showMessageDialog(null, "Digita un valor valido");
									}

								} while (!divisaNuevaEsValida);

								objConversorMoneda.setMonedas(monedaNueva, Double.parseDouble(divisaNueva));

								JOptionPane.showMessageDialog(null, "Moneda agregada");

								break;

							case 3:

								monedas = objConversorMoneda.getMonedas();
								
								String moneda = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda:",
										"Conversor de Monedas", JOptionPane.QUESTION_MESSAGE, null, monedas.toArray(),
										monedas.get(0));

								String divisa;

								boolean divisaEsValida = true;

								do {

									divisa = JOptionPane.showInputDialog(null, "Ingresa la divisa de la moneda");

									divisaEsValida = objConversorMoneda.validarDivisa(divisa);

									if (!divisaEsValida) {
										JOptionPane.showMessageDialog(null, "Digita un valor valido");
									}

								} while (!divisaEsValida);

								objConversorMoneda.setMonedas(moneda, Double.parseDouble(divisa));

								JOptionPane.showMessageDialog(null, "Moneda actualizada");

								break;

							case 4:

								break;

							case 5:

								opcionPrincipal = 2;
								JOptionPane.showMessageDialog(null, "Programa Terminado");
								break;

							default:
								break;
							}
						} catch (Exception e) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Digita un número");
						}

					} while (opcionSecundaria != 4 && opcionSecundaria != 5);

					break;

				case 2:

					JOptionPane.showMessageDialog(null, "Programa Terminado");
					break;

				default:

					JOptionPane.showInternalMessageDialog(null, "Opción Invalida");
					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digita un número");
			}

		} while (opcionPrincipal != 2);

	}

}
