// KWIC
// A01281309, José Antonio Toussaint
// A01193246, Denisse Daminan
// A01193251, Isabela Escalante
// A01281104, Renato Sanchez
// Noviembre 6, 2019

import java.util.Arrays;
import java.util.Vector;

// Clase que se encarga de hacer el circular shift
public class Circular {

String [] stopWordsArr = {
"a",
"his",
"of",
"the",
"c",
"a",
"h",
"m",
"r",
"c",
"is",
"fue",
"la",
"up",
"es",
"la",
"which",
"when"
};

Vector<String> stopWords = new Vector<String>(Arrays.asList(stopWordsArr));
    Vector<String> shift(String sentence, Vector<String> v, boolean useStopWords) {
        
        String clouds = sentence.toLowerCase();
        String cloudsCopy = clouds;
        if (useStopWords) {
            cloudsCopy = clean(sentence);
            clouds = cloudsCopy;
        }
		
		// Primer shift
		clouds = clouds.substring(clouds.indexOf(" ") + 1) + " " + clouds.substring(0, clouds.indexOf(" "));
		v.add(clouds);
		
		// Shift hasta que nos encontremos oración inicial
        while (!clouds.equals(cloudsCopy)) {
            clouds = clouds.substring(clouds.indexOf(" ") + 1) + " " + clouds.substring(0, clouds.indexOf(" "));
            v.add(clouds);
		}
		
        return v;
    }

    String clean(String sentence) {

        for (String word : this.stopWords) {
            if (sentence.contains(" "+word+" ")) {
                sentence = sentence.replace(word+" ", "");   
            }
        }

        return sentence;
    }   
}