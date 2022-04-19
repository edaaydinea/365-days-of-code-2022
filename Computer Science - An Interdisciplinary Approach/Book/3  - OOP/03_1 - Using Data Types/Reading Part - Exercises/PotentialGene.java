import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac PotentialGene.java
 *  Execution:    java PotentialGene < input.txt
 *
 *  Determines whether a a DNA string corresponds to a potential gene
 *      - length is a multiple of 3
 *      - starts with the start codon (ATG)
 *      - ends with a stop codon (TAA or TAG or TGA)
 *      - has no intervening stop codons
 *
 *  % java PotentialGene ATGCGCCTGCGTCTGTACTAG
 *  true
 *
 *  % java PotentialGene ATGCGCTGCGTCTGTACTAG
 *  false
 *
 ******************************************************************************/

public class PotentialGene {

    public static boolean isPotentialGene(String dna) {

        // Length is a multiple of 3.
        if (dna.length() % 3 != 0) return false;

        // Starts with start codon.
        if (!dna.startsWith("ATG")) return false;

        // Ends with a stop codon.
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;

        // No intervening stop codons.
        for (int i = 3; i < dna.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = dna.substring(i, i + 3);
                if (codon.equals("TAA")) return false;
                if (codon.equals("TAG")) return false;
                if (codon.equals("TGA")) return false;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        String dna = args[0];
        StdOut.println(isPotentialGene(dna));
    }
}