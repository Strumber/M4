import java.util.*;
import java.io.Console;

public class Carta_Restaurant_Nivell1 {
	/*
	 * L’exercici consisteix a mostrar per consola una carta d’un restaurant on
	 * afegirem diferents plats i després escollirem que volem per menjar. Un cop
	 * fet això s’haurà de calcular el preu del menjar el programa ens dirà amb
	 * quins bitllets hem de pagar.
	 */

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
		Float Import=0f;
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

			/*
			 * Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el
			 * sistema (1:Si / 0:No), per tant haureu de crear un altre variable int per
			 * guardar la informació.
			 */
			System.out.println("Vols demanar un altre plat ? (1:Si / 0:No)");
			int cont=0;
			// Control excepcions per a que s' introdueixi un int
			try {
				cont = Continuar.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El valor introduït no es vàlid");
				 break;
			}
			if (cont == 1 ) {
				p=true;
			}else if(cont == 0) {
				p=false;
			}else {
				System.out.println("Opció Incorrecte !!");
				break;
			}
		} while (p == true);
		// Tancar Scanner
		comanda.close();
		Continuar.close();
		
		//Fase 3
		//Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array 
		//que hem fet al principi. En el cas que la informació que hem introduït a la List coincideixi amb la del array,
		//haurem de sumar el preu del producte demanat; en el cas contrari haurem de mostrar un missatge que digui que //
		//el producte que hem demanat no existeix. 
		
		ArrayList <String> no_comanda = new ArrayList <String>();
		
		for (String m:Comandes) { 
			//Verifica si coincideix la comanda amb la carta i suma el preu corresponent
			if (Arrays.asList(menu).contains(m)) {
				Import += carta_rest.get(m);
				
			}else {
				no_comanda.add(m);
			}
			
		for (String n:no_comanda) {//mostra per consola els plats que no estan a la carta
			System.out.println (n + " no esta en la nostre carta de Restaurant");
		}
		
		
		}
		System.out.println ("L' import total de la comanda es de "+ Import + " €");
		
		
		

	}
}
