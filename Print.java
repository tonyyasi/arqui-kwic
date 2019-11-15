// KWIC
// A01281309, José Antonio Toussaint
// A01193246, Denisse Daminan
// A01193251, Isabela Escalante
// A01281104, Renato Sanchez
// Noviembre 6, 2019

import java.util.*;

// Clase que se usa para imprimir resultados
public class Print {

    void print(Vector<String> v, boolean alrevez) {
		// Ordenar resultados
        Collections.sort(v);
        if (alrevez) {
			Collections.reverse(v);
        }		
		// Imprimir resutlados
		System.out.println("");
        for (int x = 0; x < v.size(); x++) {
            System.out.println( x+1 + " " + v.elementAt(x));
        }
    }
	
	void print(Vector<String> v) {
		// Imprimir resutlados
		System.out.println("");
        for (int x = 0; x < v.size(); x++) {
            System.out.println( x+1 + " " + v.elementAt(x));
        }
    }
}