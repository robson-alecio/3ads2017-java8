package parte3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import parte2.Personagem;

public class RunStreams {

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
		
		System.out.println("Modo java básico");
		personagens.stream().map(new Function<Personagem, String>() {
			@Override
			public String apply(Personagem t) {
				return t.getNome() + " -> " + t.getRaca();
			}
		}).forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		System.out.println("Modo java lambda");
		personagens.stream().map(p -> p.getNome() + " -> " + p.getRaca())
			.forEach(descricao -> System.out.println(descricao));
		
		List<Personagem> antiPersonagens = personagens.stream()
			.map(origem -> new Personagem("Anti " + origem.getNome(), origem.getForca(), origem.getRaca()))
			.collect(Collectors.toList());
		
		antiPersonagens.forEach(p -> System.out.println(p.getNome()));
	}

}
