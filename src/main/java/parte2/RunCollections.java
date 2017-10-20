package parte2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RunCollections {

	public static void main(String[] args) {
		ArrayList<Personagem> personagens = new ArrayList<>();
		personagens.add(new Personagem("Jason Born", 45, "Humano"));
		personagens.add(new Personagem("Hulk", 1450, "Super-Humano"));
		personagens.add(new Personagem("Superman", 1200, "Criptoniano"));
		personagens.add(new Personagem("Batman", 75, "Humano"));
		personagens.add(new Personagem("Homem de Ferro", 400, "Humano"));
		personagens.add(new Personagem("Thor", 1050, "Asgardiano"));
		personagens.add(new Personagem("Riuk", 500, "Shinigami"));
		personagens.add(new Personagem("Rem", 500, "Shinigami"));
		personagens.add(new Personagem("Loki", 600, "Asgardiano"));
		personagens.add(new Personagem("Felipe", 15, "Asgardiano"));
		personagens.add(new Personagem("Zod", 1300, "Criptoniano"));
		personagens.add(new Personagem("Goku", 2000, "Sayajin"));
		personagens.add(new Personagem("Capitão América", 450, "Super-Humano"));
		personagens.add(new Personagem("Vegeta", 1600, "Sayajin"));
		
		for (Personagem personagem : personagens) {
			System.out.println(personagem.getNome());
		}
		
		System.out.println("1========================================");
		personagens.forEach(p -> System.out.println(p.getNome()));
		
		System.out.println("2========================================");

		ArrayList<Personagem> copia1 = new ArrayList<>(personagens);
		Collections.sort(copia1, new Comparator<Personagem>() {

			@Override
			public int compare(Personagem o1, Personagem o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		copia1.forEach(p -> System.out.println(p.getNome()));

		System.out.println("3========================================");
		
		ArrayList<Personagem> copia2 = new ArrayList<>(personagens);
		Collections.sort(copia2, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		
		copia2.forEach(p -> System.out.println(p.getNome()));

		System.out.println("4========================================");
		
		ArrayList<Personagem> copia3 = new ArrayList<>(personagens);
		copia3.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		
		copia3.forEach(p -> System.out.println(p.getNome()));

		System.out.println("5========================================");
		
		ArrayList<Personagem> copia4 = new ArrayList<>(personagens);
		copia4.sort(Comparator.comparing((Personagem p) -> p.getNome()));
		
		copia4.forEach(p -> System.out.println(p.getNome()));
		System.out.println("6========================================");
		
		ArrayList<Personagem> copia5 = new ArrayList<>(personagens);
		copia5.sort(Comparator.comparing(Personagem::getNome));
		
		copia5.forEach(p -> System.out.println(p.getNome()));

		System.out.println("7========================================");
		
		ArrayList<Personagem> copia7 = new ArrayList<>(personagens);
		copia7.sort(Comparator.comparingInt(Personagem::getForca));
		
		copia7.forEach(p -> System.out.println(p.getNome()));
	}

}
