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

    static Vector<String> elimSentence(Vector<String> sentences, int index) {
        // Restamos uno porque se empieza a imprimir desde 1
         sentences.remove(index - 1);
         return sentences;
    }

    static void printSentences(Vector<String> v) {
        for (int x = 0; x < v.size(); x++) {
            System.out.println( x+1 + " " + v.elementAt(x));
        }
    }
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>();
		Circular mycircular = new Circular();
		
		// Leer input
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to remove stop words? Y/N ");
        String response = myObj.nextLine();
        boolean rem = false;
        String sentence;
        if (response.equals("Y")){
            // said yes
            rem = true;
        } 
        do {
            System.out.println("Give me sentences: ");
			sentence = myObj.nextLine();

			// Hacer shift ciruclar de input mientras no este vacio
            if (!sentence.isEmpty()) {
                v.add(sentence);
			}
			
        } while (!sentence.isEmpty());

        // Print all senteces
        printSentences(v);

        int responseDel = 1;
        while (responseDel != 0){
            System.out.println("Do you want to remove a sentence? If yes write the index, if not write 0 ");
            responseDel = myObj.nextInt();
            myObj.nextLine();
            if (responseDel > 0) {
                elimSentence(v, responseDel);
                printSentences(v);
            }
        }
        Vector<String> result = new Vector<String>();
        
        for (String elem : v) {
            result = mycircular.shift(elem, result, rem);
        }


        boolean backwards = false;

        Print myprint = new Print();
        myprint.print(result, backwards);

        System.out.println("Do you want to print the result backwards? Y/N ");
        String backwardsResponse = myObj.nextLine();
        if (backwardsResponse.equals("Y")){
            // said yes
            backwards = true;
            myprint.print(result, backwards);
        } 
		
        myObj.close();
    }
}