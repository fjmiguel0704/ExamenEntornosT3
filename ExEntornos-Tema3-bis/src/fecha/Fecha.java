package fecha;

public class Fecha {
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
	public Fecha(final Fecha f) {
		dia = f.dia;
		mes = f.mes;
		anio = f.anio;
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
	private boolean esBisiesto() {
		boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
		return esBisiesto;
	}

	// Método diaSiguiente
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
