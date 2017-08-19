import edu.duke.*;
import java.io.*;

public class Part3 {
    
    public boolean twoOccurances(String a, String b){
        System.out.println("a is " + a);
        System.out.println("b is " + b);
        int pos = b.toLowerCase().indexOf(a.toLowerCase());
        System.out.println("index of a in b is " + pos);
        int length = b.length();
        System.out.println("b length is " + length);
        if (pos == -1){
            return false;}
        if (b.toLowerCase().lastIndexOf(a.toLowerCase()) != pos){
            return true;
           }
          return false;  
            
      

}
public void testOcuurances(){
    String startCodon = "ATG";
    String dna = "TAACGCAGTATGCGGTAAATGCGGCAC";
    System.out.println("The strand is  " + dna);
    boolean appears = twoOccurances(startCodon, dna);
    System.out.println(appears);
    
    startCodon = "ATG";
    dna = "ATGATGATGTAA";
    System.out.println("The strand is  " + dna);
    appears = twoOccurances(startCodon, dna);
    System.out.println(appears);
    
    startCodon = "ATG";
    dna = "TAATAATAATAA";
    System.out.println("The strand is  " + dna);
    appears = twoOccurances(startCodon, dna);
    System.out.println(appears);
    
    startCodon = "ATG";
    dna = "CGGTAACGAATGTGG";
    System.out.println("The strand is  " + dna);
    appears = twoOccurances(startCodon, dna);
    System.out.println(appears);
}}
