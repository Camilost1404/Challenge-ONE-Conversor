package challenge_conversor;

import java.math.*;
import java.util.*;

public class ConversorMoneda {

	// Atributo para las monedas y su respectiva divisa frente al dolar
	private static Map<String, Double> monedas;

	// Constructor de la clase
	public ConversorMoneda() {

		monedas = new HashMap<>();

		// Agregamos monedas por defecto
		monedas.put("USD", 1.0);
		monedas.put("EUR", 0.91626);
		monedas.put("COP", 4160.32);
		monedas.put("GBP", 0.78735);
		monedas.put("BRL", 4.7865);

	}

	public ArrayList<String> getMonedas() {

		ArrayList<String> monedasEstandar = new ArrayList<>();

		for (Map.Entry<String, Double> moneda : monedas.entrySet()) {
			monedasEstandar.add(moneda.getKey());
		}

		return monedasEstandar;

	}

	// Hacemos un set para agregar una moneda nueva o actualizar las existentes
	public void setMonedas(String moneda, double divisa) {
		monedas.put(moneda.toUpperCase(), divisa);
	}

	// Método para convertir de una moneda a otra
	public double convertir(double valorActual, String monedaActual, String monedaDestino) {

		// Capturamos las divisas las redondeamos a dos decimales
		double divisaMonedaActual = monedas.get(monedaActual);
		double divisaMonedaDestino = monedas.get(monedaDestino);

		// Sacamos la divisa de conversión para el valor dividiendo
		double divisaConversion = divisaMonedaDestino / divisaMonedaActual;

		// Multiplicamos el valor actual por la divisa para obtener nuestro resultado
		double valorConvertido = valorActual * divisaConversion;

		// Retornamos el valor
		return BigDecimal.valueOf(valorConvertido).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	public boolean validarDivisa(String divisa) {

		/*
		 * Verificar si la divisa es valida (Si es un número entero o decimal y que sea
		 * positivo)
		 */
		return divisa.matches("\\d+(\\.\\d+)?") && Double.parseDouble(divisa) > 0;

	}

	public boolean validarValor(String valor) {

		/*
		 * Verificar si la divisa es valida (Si es un número entero o decimal y que sea
		 * positivo)
		 */
		return valor.matches("\\d+(\\.\\d+)?") && Double.parseDouble(valor) > 0;

	}

}
