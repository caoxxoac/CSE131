package exercises6;
import static org.junit.Assert.*;

import org.junit.Test;


public class SumTest {
	@Test
	public void testSum() {
		assertEquals(Sum.sum(0), 0);
		assertEquals(Sum.sum(3), 6);
		
		for (int i=0; i<1000; i++) {
			int ans = i * (i+1) / 2;
			assertEquals(Sum.sum(i), ans);
		}
	}

}
