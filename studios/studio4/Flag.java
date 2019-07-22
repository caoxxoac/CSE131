package studio4;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		//
		//  Add code for your studio below here.
		//
		StdDraw.setPenColor(Color.black);
		StdDraw.rectangle(0.5, 0.5, 0.3, 0.2);
		StdDraw.setPenColor(Color.red);
		StdDraw.filledCircle(0.5, 0.5, 0.1);
		
		StdDraw.setPenColor(Color.cyan);
		StdDraw.text(0.5, 0.5, "This is a Japanese flag!!!");
		
		System.setIn(new FileInputStream("music/National_Anthem.txt"));

        // repeat as long as there are more integers to read in
        while (!StdIn.isEmpty()) {

            // read in the pitch, where 0 = Concert A (A4)
            int pitch = StdIn.readInt();

            // read in duration in seconds
            double duration = StdIn.readDouble();

            // build sine wave with desired frequency
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int N = (int) (StdAudio.SAMPLE_RATE * duration);
            double[] a = new double[N+1];
            for (int i = 0; i <= N; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }

            // play it using standard audio
            StdAudio.play(a);

        }
	}

}
