import java.util.*;
import java.io.*;

public class Carta_Restaurant_Nivell2 {

	public static void main(String[] args) {
		// Fase 1
		// Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a
		// 500€, haureu de crear un altre variable per guardar el preu total del menjar.
		int bitllet5 = 5;
		int bitllet10 = 10;
		int bitllet20 = 20;
		int bitllet50 = 50;
		int bitllet100 = 100;
		int bitllet200 = 200;
		int bitllet500 = 500;
		Float Import = 0f;
		/*
		 * Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de
		 * cada plat.
		 */
		String[] menu = new String[6];
		float[] preu = new float[6];
		HashMap<String, Float> carta_rest = new HashMap<String, Float>();
		carta_rest.put("Sopa", 6.5f);
		carta_rest.put("Amanida", 5.6f);
		carta_rest.put("Paella", 6.75f);
		carta_rest.put("Conill", 6.5f);
		carta_rest.put("Llenguado", 8f);
		carta_rest.put("Vedella", 12f);

		// Fase 2

		/*
		 * Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem
		 * el nom del plat i després el preu. Pots fer us de diccionaris de dades(Java
		 * HasMap).
		 */
		int x = 0;
		for (String m : carta_rest.keySet()) {
			menu[x] = m;
			preu[x] = carta_rest.get(m);
			x++;
		}
		// Un cop plens els dos arrays haurem de mostrar-los
		System.out.println("Menú i preus del Restaurant");
		System.out.println("---------------------------");
		for (int m = 0; m < menu.length; m++) {
			System.out.println((m + 1) + "-" + menu[m] + "  -->Preu : " + preu[m] + " €");
		}

		// Fase 3
		// i preguntar que es vol per menjar, guardarem la informació en una List fent
		// servir un bucle while.

		Scanner comanda = new Scanner(System.in);
		Scanner Continuar = new Scanner(System.in);
		ArrayList<String> Comandes = new ArrayList<String>();
		boolean p = false;

		do {
			System.out.println("que vols per menjar ?");
			Comandes.add(comanda.nextLine());
			try {

				for (String m : Comandes) {// en el cas de que el plat no estigui a la carta eliminar i tornar a preguntar
					if (!Arrays.asList(menu).contains(m)) {
						System.out.println(m + " no existeix en la carta !!!");
						Comandes.remove(m);
					}
				}
			} catch (ConcurrentModificationException exception) {
				System.out.println(" Eliminat de la llista");
			}

			System.out.println("Vols demanar un altre plat ? (1:Si / 0:No)");
			int cont = 0;
			// Control excepcions per a que s' introdueixi un int
			try {
				cont = Continuar.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El valor introduït no es vàlid");
				// break;
			}
			if (cont == 1) {
				p = true;
			} else if (cont == 0) {
				p = false;
			} else {
				System.out.println("Opció Incorrecte !!");
				break;
			}
		} while (p == true);
		// Tancar Scanner
		comanda.close();
		Continuar.close();

		for (String m : Comandes) {
			// Verifica si coincideix la comanda amb la carta i suma el preu corresponent
			if (Arrays.asList(menu).contains(m)) {
				Import += carta_rest.get(m);

			}

		}
		System.out.println("L' import total de la comanda es de " + Import + " €");

	}

}
