// KWIC
// A01281309, José Antonio Toussaint
// A01193246, Denisse Daminan
// A01193251, Isabela Escalante
// A01281104, Renato Sanchez
// Noviembre 6, 2019

import java.util.Scanner;
import java.util.Vector;

import java.util.*;

// Clase Main que lee strings en input hasta recibir uno vacio
public class Main {
    public static void main(String[] args) {
        Vector v = new Vector<String>();
		Circular mycircular = new Circular();
		
		// Leer input
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to remove stop words? Y/N ");
        String response = myObj.nextLine();
        boolean rem = false;
        if (response.equals("Y")){
            // said yes
            System.out.println(response + " -----");
            rem = true;
        } 
        System.out.println("Give me a sentence: ");
        String sentence = myObj.nextLine();

        v = mycircular.shift(sentence, v, rem);

        do {
            System.out.println("Give me a sentence: ");
			sentence = myObj.nextLine();

			// Hacer shift ciruclar de input mientras no este vacio
            if (!sentence.isEmpty()) {
                v = mycircular.shift(sentence, v, rem);
			}
			
		} while (!sentence.isEmpty());
		
        myObj.close();
        Print myprint = new Print();
        myprint.print(v);
    }
}