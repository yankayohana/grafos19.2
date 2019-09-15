
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author yanka yohana
 *
 */

public class CirculoAmigos {

	/**
	 * Retorna os circulos de amigos a partir de uma lista de pares;
	 * 
	 * @param paresAmigos lista de pares representando os amigos;
	 * @return circulos de amigos;
	 */

	public static List<Set<String>> retornaCirculos(List<Pair<String, String>> paresAmigos) {

		Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		Set<String> amigos = new HashSet<String>();

		for (Pair<String, String> pair : paresAmigos) {
			String p1 = pair.getFirst();
			String p2 = pair.getSecond();
			amigos.add(p1);
			amigos.add(p2);
			if (!graph.containsVertex(p1))
				graph.addVertex(p1);
			if (!graph.containsVertex(p2))
				graph.addVertex(p2);

			graph.addEdge(p1, p2);
		}

		Set<Set<String>> circulos = new HashSet<Set<String>>();

		for (String amigo : amigos) {
			Set<String> circulo = new HashSet<String>();
			Set<String> passed = new HashSet<String>();

			getAllCircle(graph, amigo, circulo, passed);
			circulos.add(circulo);

		}

		return new ArrayList<Set<String>>(circulos);
	}

	/**
	 * Faz uma busca dentro do grafo para adicionar todas os vertices conectados no
	 * circulo;
	 * 
	 * @param graph  grafo de amigos;
	 * @param amigo  amigo atual;
	 * @param circle circulo atual;
	 * @param passed vertices ja checados;
	 */

	public static void getAllCircle(Graph<String, DefaultEdge> graph, String amigo, Set<String> circle,
			Set<String> passed) {

		passed.add(amigo);
		circle.add(amigo);
		Set<DefaultEdge> conexoes = graph.edgesOf(amigo);

		Set<String> amigos = new HashSet<String>();

		for (DefaultEdge conexao : conexoes) {
			String source = graph.getEdgeSource(conexao);
			String target = graph.getEdgeTarget(conexao);

			circle.add(target);
			amigos.add(source);
			amigos.add(target);
		}

		for (String a : amigos) {
			if (!passed.contains(a)) {
				getAllCircle(graph, a, circle, passed);
			}
		}
	}

}
