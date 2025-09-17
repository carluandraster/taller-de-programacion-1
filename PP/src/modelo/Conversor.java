package modelo;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conversor {
	/** Especificación:
	 *
	 * Este código pretende convertir el resultado de una cantidad de dinero en letras de la forma
	 * 1234.45 a "Mil doscientos treynta y cuatro ṕesos con cuarenta y cinco centavos.
	 *
	 * La conversion debe operar tanto en la recepción de un numero como de un String que represente
	a
	 * una cifra.
	*/
	/** Método Letra.
	 * Argumento de Entrada un String con una cifra entera a convertir.
	 * Argumento de Salida un String con la frase que representa la cifra
	 * Precondición: El argumento de entrada representa una cifra entera y valida.
	 * Postcondición: No existe.
	 */
	 private String LETRA(String a)
	 {
		Boolean paso = a.matches("[0-9]{1,15}.[0-9]{2}"); // ERROR: esto siempre da falso porque la precondición es que es un número entero
		if (paso)
		{
			String Letra1 ="";
			int i =0;
			int d =0;
			int digito =0;
			String[] Unidades = {"CERO","UN","DOS","TRES","CUATRO","CINCO", "SEIS",
			"SIETE", "OCHO", "NUEVE", "DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE",
			"DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUN",
			"VEINTIDOS", "VEINTITRES", "VEINTICUATRO", "VEINTICINCO", "VEINTISEIS",
			"VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE" };
			String[] Decenas = {"","DIEZ", "VEINTE", "TREINTA", "CUARENTA",
			"CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};
			String[] Centenas = {"","CIENTO", "DOCIENTOS", "TRECIENTOS",
			"CUATROCIENTOS", "QUINIENTOS", "SEICIENTOS", "SETECIENTOS", "OCHOCIENTOS",
			"NOVECIENTOS" };
			String[] Millares = {"BILLON", "MIL MILLONES", "MILLON", "MIL"," " };
			String[] b = {"","","","",""};
			if (Integer.valueOf(a)==0)
			{
				Letra1 = " CERO ";
			}
			else
			{
				a.replace(' ', '0'); // ERROR: si el argumento de entrada representa una cifra entera y valida, entonces no tiene espacios
				for (i=0; i<4; i++)
				{
					b[i] = a.substring(i * 3, i*3 + 3); // Longitud de b[i] = i*3+3-i*3 = 3
				}
				// b[4] = ""
				Letra1 = "";
				for (i=0; i<5; i++)
				{
					if (!b[i].toString().equals("000")) // ERROR: no es necesario llamar al método toString
					{
						if (!b[i].toString().equals("100")) // ERROR: no es necesario llamar al método toString
						{
							if (b[i].charAt(0) != '0') // ERROR porque b[4] es un String vacío y, por ende, no es posible acceder a su caracter 0
							{
								digito = (int) b[i].charAt(0) - 47; // Mismo error que arriba
								Letra1 = Letra1 + " " + Centenas[digito ];
							}
							d = Integer.valueOf(b[i].substring(1,3)); // ERROR para b[4]
							if (d>31)
							{
								d = (int) b[i].charAt(1) - 48; // ERROR para b[4]
								Letra1 = Letra1 + " " + Decenas[d];
								d = (int) b[i].charAt(2) - 48; // ERROR para b[4]
								if (b[i].charAt(2) != '0')// ERROR para b[4]
								{
									Letra1 = Letra1 + " Y " + Unidades[d];
								}
							}
							else
							{
								if (d != 0)
								{
									Letra1 = Letra1 + " " + Decenas[d];
								}
							}
						}
						else
						{
							Letra1 = Letra1 + " CIEN";
						}
						if (i!=5)
						{
							Letra1 = Letra1 + " " + Millares[i];
						}
						if (((i == 3) | (i == 1)) & (!b[i].toString().equals("001")))
						{
							Letra1 = Letra1 + "";
						}
					}
				}
			}
			Letra1 = Letra1.substring(0, Letra1.length() - 1);
			return Letra1;
		}
		else
		{
			return "";
		}
	 }

	/** Método letranum
	 * Argumento de Entrada un String con una cifra de 15 digitos enteros y dos decimales separados
	por un punto.
	 * La entrada es validada y si es incorrecta se lanza una excepción.
	 * Argumento de Salida un String con la frase que representa la cifra
	 * Precondición: No existe.
	 * Postcondición: No existe.
	 */
	 public String letranum(String numero) throws Exception
	 {
		String ENTERO;
		String DECIMAL;
		String SALIDA;
		Boolean paso = numero.matches("[0-9]{1,15}.[0-9]{2}");
		if (paso)
		{
			String Espacios = "00000000000000000000000000000";
			String entrada = Espacios.substring(0,18-numero.length()) + numero;
			ENTERO = entrada.substring(0,15);
			DECIMAL = entrada.substring(16,18);
			DECIMAL = Espacios.substring(0,13) + DECIMAL;
			if (Integer.valueOf(ENTERO)<2)
			{
				SALIDA = LETRA(ENTERO) + "PESO CON"; // ERROR: no se agregan espacios
			}
			else
			{
				SALIDA = LETRA(ENTERO) + "PESOS CON"; // ERROR: no se agregan espacios
			}
			if (Integer.valueOf(DECIMAL)==2)
			{
				SALIDA = SALIDA + LETRA(DECIMAL) + "CENTAVO"; // ERROR: no se agregan espacios
			}
			else
			{
				SALIDA = SALIDA + LETRA(DECIMAL) + "CENTAVOS"; // ERROR: no se agregan espacios
			}
			return SALIDA;
		}
		else
		{
			return "";
		}
	 }

	/* Método letranum2
	 * Argumento de Entrada es un numero de 15 digitos enteros y dos decimales separados por un
	punto,
	 * la entrada es validada y si es incorrecta se lanza una excepción.
	 * Argumento de Salida un String con la frase que representa la cifra
	 * Precondición: No existe
	 * Postcondición: No existe.
	 */
	 public String letranum2(BigDecimal num) throws Exception
	 {
		String numero;
		String ENTERO;
		String DECIMAL;
		String SALIDA;

		numero= num.setScale(2, RoundingMode.HALF_DOWN).toString();

		Boolean paso = numero.matches("[0-9]{1,15}.[0-9]{2}");
		if (paso)
		{
			String Espacios = "00000000000000000000000000000";
			String entrada = Espacios.substring(0,18-numero.length()) + numero;
			ENTERO = entrada.substring(0,15);
			DECIMAL = entrada.substring(16,18);
			DECIMAL = Espacios.substring(0,13) + DECIMAL;
			if (Integer.valueOf(ENTERO)==1)
			{
				SALIDA = LETRA(ENTERO) + "PESO CON";
			}
			else
			{
				SALIDA = LETRA(ENTERO) + "PESOS CON";
			}
			if (Integer.valueOf(DECIMAL)==2)
			{
				SALIDA = SALIDA + LETRA(DECIMAL) + "CENTAVO";
			}
			else
			{
				SALIDA = SALIDA + LETRA(DECIMAL) + "CENTAVOS";
			}
			return SALIDA;
		}
		else
		{
			throw new Exception ("ERROR");
		}
	 }
}
