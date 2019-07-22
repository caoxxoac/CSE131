package biojavagc;

import java.io.File;

import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.ProteinSequence;

import biojava.SequenceLoader;

public class GCContent {
	
	//
	// We are providing everything from here....
	//

	public static void main(String[] args) {
		analyze("mysterya");
		analyze("NC_002677");
		analyze("mysteryb");
		analyze("mysteryc");
	}
	
	private static void analyze(String genomeName) {	
		//
		// Open the file with the sequence contents
		//
		File file = new File("datafiles/genomes/"+genomeName+".fasta");

		//
		// Load the sequence into a DNASequence object
		//
		SequenceLoader sequenceLoader = new SequenceLoader();
		DNASequence dnaSequence = sequenceLoader.loadDNASequence(file);
		
		//
		// Convert the sequence to a string and then a char array
		//
		String dnaAsString = dnaSequence.getSequenceAsString().toUpperCase();
		char[] dnaAsCharArray = dnaAsString.toCharArray();
		
		//
		// Call your solution to compute the result
		//
		double gc = percentGC(dnaAsCharArray);
		
		//
		// Print out the result
		//
		System.out.println("GC Content of " + genomeName + " is " + gc + "%");
	}
	
	//
	// ... to here, so don't change the code above here without asking.
	//
	//  Your job is to complete the method below so that the
	//  ans value returned is the percentage of GC in the supplied seq
	//

	/**
	 * 
	 * @param seq An array of characters denoting the DNA.  These may be upper or lower case
	 * @return the percentage of G or C characters found in the supplied seq
	 */
	public static double percentGC(char[] seq) {
		double ans = 0;
		int count = 0;
		if (seq.length == 0) {
			return 0;
		}
		for (int i=0; i<seq.length; i++) {
			if (Character.toUpperCase(seq[i]) == 'G' || Character.toUpperCase(seq[i]) == 'C') {
				count ++;
			}
		}
		ans = (double) count * 100 / seq.length;
		return ans;
	}

}
