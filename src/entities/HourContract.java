package entities;

import java.time.LocalDate;

public class HourContract {
	
	//ATRIBUTOS
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;

	//CONSTRUTOR - Completo com todos atributos	
	public HourContract (LocalDate date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	//GET E SET
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	//FUNCAO PARA PEGAR O VALOR TOTAL DO CONTRATO COM BASE NAS HORAS
	public Double totalValue() {
		return valuePerHour * hours;
	}
}
