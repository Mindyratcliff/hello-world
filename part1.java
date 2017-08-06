import edu.duke.*;

public class Part1 {

    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";}
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return "";}
        result = dna.substring(startIndex, stopIndex+3);
        if ((startIndex + stopIndex)%3 == 0){
            return result;}
            else{ return "";}
            
            
     
    
}

public void testSimpleGene(){
    String dna = "ATCGATAGGATGCTACCGTAACGA";
    System.out.println("DNA strand is " + dna);
    String gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
    dna = "ATCGATAGGCTACCGTAA";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
    dna = "ATCGATAGGATGCTAAACCGTAACGA";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
    dna = "ATCGATAGGATGCTACCGCGA";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
    dna = "TAACGG";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
    
    dna = "GAAATGTCCCGATAATCC";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna);
    System.out.println("Gene is " + gene);
}}
    

