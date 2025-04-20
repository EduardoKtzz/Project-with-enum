package entities;

//IMPORTAÇÔES
import java.util.ArrayList;
import java.util.List;
import entitiesEnums.WorkerLevel;

public class Worker {

	//ATRIBUTOS
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	//ASSOCIAÇÔES
	private Departament departament; //Um colaborador só tem um departamento
	private List<HourContract> contracts = new ArrayList<>(); //Um colaborador pode ter vários contratos

	//CONSTRUTOR - Todos atributos junto com o de departamento
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	//GET E SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	//FUNÇÔES
	//Adcionar contrato na lista.
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	//Remover adcionar contrato na lista.
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}

	//Calcular o salario com base na duração do contrato.
	public Double income(Integer year, Integer month) {
		double sum = baseSalary;
		
		for (HourContract contract : contracts) {
			int c_year = contract.getDate().getYear();
			int c_month = contract.getDate().getMonthValue();

				if (year.equals(c_year) && month.equals(c_month)) {
					sum += contract.totalValue();
				}

		}
		return sum;
	}




}
