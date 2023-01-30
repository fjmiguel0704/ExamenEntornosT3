package fecha;

/**
 * Clase en la que se comprobará si la fecha es correcta o no, teniendo en
 * cuenta los meses del año, días que tiene, etc.
 * 
 * @author fjmiguel
 *
 */
public class Fecha {
	private int dia;
	private int mes;
	private int anio;

	// Constructores
	// Constructor por defecto

	/**
	 * Método por defecto
	 */
	public Fecha() {

	}

	// Constructor con parámetros
	/**
	 * Este método guardará información del día, mes y año
	 * 
	 * @param dia  contiene el día de la fecha
	 * @param mes  contiene en mes de la fecha
	 * @param anio contiene el año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	// Constructor copia
	/**
	 * Este método crea una copia del anterior, con el dia, mes y año
	 * 
	 * @param f hará referencia al día, mes y año
	 */
	public Fecha(final Fecha f) {
		dia = f.dia;
		mes = f.mes;
		anio = f.anio;
	}

	// getters y setters
	/**
	 * Esta función obtiene el valor de la variable dia y lo devuelve
	 * 
	 * @return el dia de la fecha
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Este método modifica el valor de la variable dia
	 * 
	 * @param dia dia de la fecha introducido por parámetro
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * Esta función obtiene el valor de la variable mes y lo devuelve
	 * 
	 * @return el mes de la fecha
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Este método modifica el valor de la variable mes
	 * 
	 * @param mes mes de la fecha introducido por parámetro
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * Este método obtiene el valor de la variable anio y lo devuelve
	 * 
	 * @return el año de la fecha
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Este método modifica el valor de la variable anio
	 * 
	 * @param anio año de la fecha introducido por parámetro
	 */
	public void setAño(int anio) {
		this.anio = anio;
	}

	// Método fecha correcta
	/**
	 * Este método comprobará caso por caso si la fecha es correcta o no lo es
	 * 
	 * @return la fecha (dia, mes, año) correcta
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = dia >= 1 && dia <= 29;
			} else {
				diaCorrecto = dia >= 1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = dia >= 1 && dia <= 30;
			break;
		default:
			diaCorrecto = dia >= 1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// Método esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Este método comprobará si el año de la fecha correcta comprobada
	 * anteriormente es Bisiesto o no
	 * 
	 * @return true en caso de ser Bisiesto
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
		return esBisiesto;
	}

	// Método diaSiguiente
	/**
	 * Esta función incrementará el mes del año cuando el dia sea igual a 1 e
	 * incrementará el año cuando el mes sea igual a 1
	 */
	public void diaSiguiente() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	// Método toString
	/**
	 * Este método irá comprobando si el dia y mes es menor, mayor o igual a 10 para
	 * mostrar el formato correcto de la fecha
	 * 
	 * @return la fecha final 
	 */
	public String toString() {
		String fechaFinal = "";
		if (dia < 10 && mes < 10) {
			fechaFinal = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < 10 && mes >= 10) {
			fechaFinal = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= 10 && mes < 10) {
			fechaFinal = dia + "-0" + mes + "-" + anio;
		} else {
			fechaFinal = dia + "-" + mes + "-" + anio;
		}
		return fechaFinal;
	}

}
