
package ca_lexicographicpermutations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CA_LexicographicPermutations {
    
    public static <T> void print(List<T> list) {
        
        for (T i : list) {System.out.print(i + "");       }
        System.out.println();
    }

    public static void main(String[] args) {
    int step=0;    
    String str_input="0 2 10531100";
    Scanner scan=new Scanner(str_input);
//    while (scan.hasNext()){
//    step=scan.nextInt();
//    
//    }
        
for (List<String> list : new Permutation<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L")))
{print(list); System.out.print(" step - "+step+" "); step++;}
    }
//for (List<String> list : new Permutation<String>(Arrays.asList("A", "B", "C", "D")))
//            print(list);
//    }
    
}
