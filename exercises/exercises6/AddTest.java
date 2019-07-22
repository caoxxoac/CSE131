package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void test() {
		assertEquals(0, Add.addAny(0, 0));
		//
		// write other test cases here:
		//
		for (int i=-100; i<100; i++) {
			for (int j=-100; j<100; j++) {
				assertEquals(i+j, Add.addAny(i, j));
			}
		}
	}

}
