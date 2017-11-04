package parte2;

public class Personagem {

	private String nome;
	private int forca;
	private String raca;

	public Personagem(String nome, int forca, String raca) {
		super();
		this.nome = nome;
		this.forca = forca;
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public int getForca() {
		return forca;
	}

	public String getRaca() {
		return raca;
	}

	@Override
	public String toString() {
		return "Personagem [nome=" + nome + ", forca=" + forca + ", raca="
				+ raca + "]";
	}
	
}
