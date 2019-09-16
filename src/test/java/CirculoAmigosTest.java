import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.util.Pair;
import org.junit.Test;


/**
 * 
 * @author Caio José
 * @author Eduardo Afonso
 * @author Jader Figueiredo
 *
 */

public class CirculoAmigosTest {

	@Test
	public void test1() {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();
		listaAmigos.add(new Pair<String, String>("a","b"));
		listaAmigos.add(new Pair<String, String>("c","d"));
		listaAmigos.add(new Pair<String, String>("e","f"));
		listaAmigos.add(new Pair<String, String>("f","g"));
		listaAmigos.add(new Pair<String, String>("i","j"));
		
		// Circulos que devem ser encontrados
		Set <String> c1 = new HashSet<String> (); c1.add("a"); c1.add("b");
		Set <String> c2 = new HashSet<String> (); c2.add("c"); c2.add("d");
		Set <String> c3 = new HashSet<String> (); c3.add("e"); c3.add("f"); c3.add("g"); 
		Set <String> c4 = new HashSet<String> (); c4.add("i"); c4.add("j");
		
		// Calculando c�rculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertTrue(circuloAmigos.contains(c3));
		assertTrue(circuloAmigos.contains(c4));
		assertEquals(circuloAmigos.size(),4);		
	}
	
	@Test 
	public void test2 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();
		listaAmigos.add(new Pair<String, String>("a","b"));
		listaAmigos.add(new Pair<String, String>("c","b"));
		listaAmigos.add(new Pair<String, String>("e","a"));
		listaAmigos.add(new Pair<String, String>("f","b"));
		listaAmigos.add(new Pair<String, String>("f","a"));		
		
		// Circulos que devem ser encontrados
		Set <String> c1 = new HashSet<String> (); c1.add("a"); c1.add("b"); c1.add("c"); c1.add("e"); c1.add("f");
		
		// Calculando c�rculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		
		assertTrue(circuloAmigos.contains(c1));
		assertEquals(circuloAmigos.size(),1);	
	}
	
	@Test
	public void test3 () {
		ArrayList<Pair<String,String>> listaAmigos = new ArrayList <Pair<String,String>> ();

		// Calculando c�rculos
		List <Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);

		assertEquals(circuloAmigos.size(),0);	
	}
	
	@Test
	public void test4() {
		List<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String, String>("Caio", "Eduardo"));
		listaAmigos.add(new Pair<String,String>("Eduardo", "Jader"));
		listaAmigos.add(new Pair<String, String>("Jader", "Yanka"));
		listaAmigos.add(new Pair<String, String>("Pedro", "Joao"));
		
		Set <String> c1 = new HashSet<String>();
		c1.add("Caio"); c1.add("Eduardo"); c1.add("Jader"); c1.add("Yanka");
		Set <String> c2 = new HashSet<String>();
		c2.add("Pedro"); c2.add("Joao");
		
		
		List<Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		assertEquals(circuloAmigos.size(), 2);
		assertTrue(circuloAmigos.contains(c1));
	}
	
	@Test
	public void test5() {
		List<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String,String>("1","2"));
		listaAmigos.add(new Pair<String,String>("2","3"));
		listaAmigos.add(new Pair<String,String>("4","5"));
		listaAmigos.add(new Pair<String,String>("6", "7"));
		listaAmigos.add(new Pair<String,String>("9", "10"));
		
		Set<String> c1 = new HashSet<String>();
		c1.add("1"); c1.add("2"); c1.add("3");
		Set<String> c2 = new HashSet<String>();
		c2.add("4"); c2.add("5");
		Set<String> c3 = new HashSet<String>();
		c3.add("6"); c3.add("7");
		Set<String> c4 = new HashSet<String>();
		c4.add("9"); c4.add("10");
		
		List<Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);
		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertTrue(circuloAmigos.contains(c3));
		assertTrue(circuloAmigos.contains(c4));
		assertEquals(circuloAmigos.size(), 4);
		
	}
	
	@Test
	public void test6() {
		List<Pair<String,String>> listaAmigos = new ArrayList<Pair<String,String>>();
		listaAmigos.add(new Pair<String,String>("Caio","Mariana"));
		listaAmigos.add(new Pair<String,String>("Caio","Eduardo"));
		listaAmigos.add(new Pair<String,String>("Eduardo","Jader"));
		listaAmigos.add(new Pair<String,String>("Caio","Mariana"));
		listaAmigos.add(new Pair<String,String>("Jader","Maely"));
		listaAmigos.add(new Pair<String,String>("Lucas","Jonas"));
		listaAmigos.add(new Pair<String,String>("Enzo","Valentina"));
		
		
		List<Set<String>> circuloAmigos = CirculoAmigos.retornaCirculos(listaAmigos);

		Set<String> c1 = new HashSet<String>();
		c1.add("Caio"); c1.add("Mariana"); c1.add("Eduardo"); c1.add("Jader"); c1.add("Maely");
		Set<String> c2 = new HashSet<String>();
		c2.add("Lucas"); c2.add("Jonas");
		Set<String> c3 = new HashSet<String>();
		c3.add("Enzo"); c3.add("Valentina");

		assertTrue(circuloAmigos.contains(c1));
		assertTrue(circuloAmigos.contains(c2));
		assertTrue(circuloAmigos.contains(c3));
		assertEquals(circuloAmigos.size(), 3);
		
		
	}
}

