
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("================================================");

        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}






maps can pass in different objects  

 Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one",1);
        numbers.put("two",2);
        System.out.println(numbers.get("one"));
       // numbers.put("one",1);
        if(numbers.containsKey("one")){
            System.out.println("1 is already added to your dictionary");

        }
        else{

            System.out.println("one is the first number");
        }
        for(String key :numbers.keySet()){
            System.out.println(key + " : " + numbers.get(key));
        }


    }
