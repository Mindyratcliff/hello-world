public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        int startIndex = dna.toUpperCase().indexOf("ATG");
        if (startIndex == -1){
            return "";}
        int stopIndex = dna.toUpperCase().indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return "";}
        result = dna.substring(startIndex, stopIndex+3);
        if ((startIndex + stopIndex)%3 == 0){
            return result;}
            else{ return "";}
        
            
            
     
    
}

public void testSimpleGene(){
    String dna = "ATCGATAGGATGCTACCGTAAcga";
    String startCodon = "ATG";
    String stopCodon = "TAA";
    System.out.println("DNA strand is " + dna);
    String gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);
    
    dna = "attatgcggtcctaacga";
    startCodon = "ATG";
    stopCodon = "TAA";
    System.out.println("DNA strand is " + dna);
    gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene is " + gene);

}}
