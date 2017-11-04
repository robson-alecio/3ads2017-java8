package parte3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import parte2.Personagem;

public class RunStreams {

	public static void main(String[] args) throws Throwable {
		ArrayList<Personagem> personagens = new ArrayList<>();
		personagens.add(new Personagem("Jason Born", 45, "Humano"));
		personagens.add(new Personagem("Hulk", 1450, "Super-Humano"));
		personagens.add(new Personagem("Superman", 1200, "Criptoniano"));
		personagens.add(new Personagem("Batman", 75, "Humano"));
		personagens.add(new Personagem("Homem de Ferro", 400, "Humano"));
		personagens.add(new Personagem("Thor", 1050, "Asgardiano"));
		personagens.add(new Personagem("Riuk", 500, "Shinigami"));
		personagens.add(new Personagem("Rem", 500, "Shinigami"));
		personagens.add(new Personagem("Sobo", 400, "Shinigami"));
		personagens.add(new Personagem("Sobo", 300, "Shinigami"));
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

		List<Personagem> personagensBombados = personagens.stream()
				.map(origem -> new Personagem(origem.getNome(), origem.getForca() * 2, origem.getRaca()))
				.collect(Collectors.toList());
		personagensBombados.forEach(p -> System.out.printf("%s -> %d\n", p.getNome(), p.getForca()));
		
		System.out.println("=====================================");
		List<Personagem> copia1 = new ArrayList<Personagem>(personagens);
//		copia1.sort(Comparator.comparing(Personagem::getNome));
//		copia1.sort(Comparator.comparingInt(Personagem::getForca).thenComparing(Personagem::getNome));
		copia1.sort(Comparator.comparing(Personagem::getNome).reversed().thenComparingInt(Personagem::getForca));
		Map<String, List<Personagem>> personagensPorRaca = copia1.stream()
				.collect(Collectors.groupingBy(Personagem::getRaca));
		System.out.println(personagensPorRaca);
		
		System.out.println("**************************************");
		personagensPorRaca.forEach(new BiConsumer<String, List<Personagem>>() {
			@Override
			public void accept(String raca, List<Personagem> personagens) {
				System.out.println("=====================================");
				System.out.printf("Raça: %s\n", raca);
				personagens.forEach(p -> System.out.printf("-> %s -> %d\n", p.getNome(), p.getForca()));
			}
		});
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		personagensPorRaca.forEach((raca, personagens1) -> {
			System.out.println("=====================================");
			System.out.printf("Raça: %s\n", raca);
			personagens1.forEach(p -> System.out.printf("-> %s -> %d\n", p.getNome(), p.getForca()));
		});
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		List<Personagem> copia2 = new ArrayList<Personagem>(personagens);
		copia2.sort(Comparator.comparingInt(Personagem::getForca));
		Stream<Personagem> filtered = copia2.stream().filter(p -> p.getForca() >= 1_000 );
		Optional<Personagem> optional = filtered.findFirst();
//		Personagem personagemComCerteza = optional.orElse(new Personagem("Zé Ninguém", 0, "desconhecida"));
//		Personagem personagemComCerteza = optional.orElseThrow(() -> new RuntimeException("Deu ruim!!!"));
		optional.ifPresent(p -> System.out.println(p));
//		System.out.println(personagemComCerteza);
		criarPersonagem("Ranger Vermelho", 140, "Humano").ifPresent(p -> copia2.add(p));
		copia2.forEach(p -> System.out.println(p));
		
		IntStream.rangeClosed(1, 100).forEach(i -> System.out.println(i));
	}

	private static Optional<Personagem> criarPersonagem(String nome, int forca, String raca) {
		if (nome == null || nome.isEmpty() || forca <= 0 || raca == null || raca.isEmpty())
			return Optional.empty();
		
		return Optional.of(new Personagem(nome, forca, raca));
	}

}
