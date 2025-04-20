package entities;

public class Departament {
	//ATRIBUTOS
	private String name;

	//CONSTRUTOR - Somente com o name
	public Departament(String name) {
		this.name = name;
	}

	//GET E SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


