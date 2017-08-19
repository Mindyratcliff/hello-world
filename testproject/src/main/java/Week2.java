import edu.duke.StorageResource;

public class Week2 {
    public int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currentGene = geneFinder(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            count++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();

        }
        return count;
    }

    public int howMany(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        int count = 0;
        while (index != -1) {
            count++;
            stringb = stringb.substring(index + stringa.length());
            index = stringb.indexOf(stringa);
        }
        //System.out.println(stringa + " occurs in " + stringb);
        return count;
    }

    public int findCodon(String dnaStr,
                         int startIndex,
                         String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return -1;
    }

    public String geneFinder(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findCodon(dna, startIndex, "TAA");
        int tagIndex = findCodon(dna, startIndex, "TAG");
        int tgaIndex = findCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if (taaIndex == -1 ||
                (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 ||
                (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }

    public void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = geneFinder(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();

        }
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true) {
            String currentGene = geneFinder(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public float cgRatio(String dna) {
        int numOfCs = howMany("C", dna);
        int numOfGs = howMany("G", dna);
        return (float) (numOfCs + numOfGs) / dna.length();

    }

    public int countCTG(String dna) {
        int numOfCTGs = howMany("CTG", dna);
        System.out.println(numOfCTGs);
        return numOfCTGs;
    }

    public void processGenes(StorageResource pg) {
        int numOfGenes = 0;
        int numOfCgs = 0;
        int maxLength = 0;
        int totalGenes = 0;
        int numOfCTGs = 0;
        StorageResource allGenes = null;
        for (String genes : pg.data()) {
            allGenes = getAllGenes(genes.toUpperCase());
            printAllGenes(genes);
            numOfCTGs = countCTG(genes);
            System.out.println(genes);
            for (String s : allGenes.data())


            { totalGenes++;
                if (s.length() > 60) {
                    numOfGenes++;
                    System.out.println(s);
                }

                float cg = cgRatio(s);
                if (cg > 0.35) {
                    System.out.println(cg);
                    numOfCgs++;

                }
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    System.out.println(s);
                }
                
            }
            System.out.println(numOfGenes);
            System.out.println(numOfCgs);
            System.out.println(totalGenes);
            System.out.println(numOfCTGs);
            System.out.println(maxLength);
        }


    }


}

