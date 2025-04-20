package main;

//IMPORTAÇÔES
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entitiesEnums.WorkerLevel;

public class principal {
	public static void main(String[] args) {
	
		//Scanner para pegar a resposta
		Scanner sc = new Scanner(System.in);

		//Nome do cargo do colaborador
		System.out.println();
		System.out.println("Digite o seu cargo: ");
		String department = sc.nextLine();
		System.out.println();

		//Nome do colaborador
		System.out.println("Entre com seus dados de trabalho ");
		System.out.println("Name: ");
		String name = sc.next();

		//Nivel de trabalho
		System.out.println("Level: ");
		String level = sc.next();

		//Salario base do colaborador
		System.out.println("Base salarial: ");
		Double baseSalary = sc.nextDouble();
		System.out.println();

		//INSTANCIANDO - Aqui estamos instanciando a classe Worker com todos atributos do colaborador
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(department));

		//Pegando a quantidade de contratos
		System.out.println("Quantos contratos você possui? ");
		Integer quantidade = sc.nextInt();

		//For para pegar os dados de todos contratos e colocar em uma lista
		for (int i = 0; i < quantidade; i++) {

			//Aqui pegamos a data de começo, o valor por hora e a quantidade de hora do contrato
			//Data de começo
			System.out.println("Coloque o contrato número: #" + i);
			System.out.println("Data de começo (DD/MM/YYYY): ");
			String date = sc.next();

			//Formato da hora
			LocalDate contractDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			//Valor por hora
			System.out.println("Valor por hora: ");
			Double valuePerHour = sc.nextDouble();

			//Horas do contrato
			System.out.println("Duração(Horas): ");
			Integer hours = sc.nextInt();

			//Instanciando os contratos e adcionando os contratos na lista de contratos.
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);

		}

		//Perguntar o mês que o colaborador quer consultar o valor total dos contratos
		System.out.println();
		System.out.println("Entre com mês e ano para calcular a duração (MM/YYYY): ");
		String monthAndYear = sc.next();

		//Separar o mês e o ano para usar cada um em uma variavel
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		//Print de todas informações do colaborador junto com o valor total do mês que ele buscou
		System.out.println();
		System.out.println("Name: " + worker.getName());
		System.out.println("Cargo: " + worker.getDepartament().getName());
		System.out.println("Duração para " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

}
