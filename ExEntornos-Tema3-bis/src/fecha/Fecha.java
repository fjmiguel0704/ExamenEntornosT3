package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int dia;
	private int mes;
	private int anio;

	// Constructores
	// Constructor por defecto
	public Fecha() {

	}

	// Constructor con parámetros
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	// Constructor copia
	public Fecha(final Fecha date) {
		dia = date.dia;
		mes = date.mes;
		anio = date.anio;
	}

	// getters y setters
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAño(int anio) {
		this.anio = anio;
	}

	// Método fecha correcta
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// Método esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	// Método diaSiguiente
	public void nextDay() {
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
	public String toString() {
		String fechaFinal = "";
		if (dia < DIEZ && mes < DIEZ) {
			fechaFinal = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < DIEZ && mes >= DIEZ) {
			fechaFinal = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= DIEZ && mes < DIEZ) {
			fechaFinal = dia + "-0" + mes + "-" + anio;
		} else {
			fechaFinal = dia + "-" + mes + "-" + anio;
		}
		return fechaFinal;
	}

}
