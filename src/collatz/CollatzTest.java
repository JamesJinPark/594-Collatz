package collatz;

import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author James
 *
 */
public class CollatzTest {

	@Test
	public void testLengthOfSequence() {
		int a = Collatz.lengthOfSequence(1);
		int b = Collatz.lengthOfSequence(2);
		int c = Collatz.lengthOfSequence(3);
		int d = Collatz.lengthOfSequence(4);
		int e = Collatz.lengthOfSequence(7);
		int f = Collatz.lengthOfSequence(99);
		assertTrue(a == 1);
		assertTrue(b == 2);
		assertTrue(c == 8);
		assertTrue(d == 3);
		assertTrue(e == 17);
		assertFalse(f == 17);
	}
	
	@Test
	public void testSimpleComputeSequenceLengths() {
		int[] array1 = Collatz.simpleComputeSequenceLengths(3); 
		int[] array2 = Collatz.simpleComputeSequenceLengths(0); 
		int[] array3 = Collatz.simpleComputeSequenceLengths(9); 
		assertTrue(array1[1] == 1);
		assertTrue(array1[2] == 2);
		assertTrue(array1[3] == 8);
		assertTrue(array2[0] == 0);
		assertTrue(array3[7] == 17);
	}
		
	@Test
	public void testMemoizedComputeSequenceLengths() {
		int[] array1 = Collatz.memoizedComputeSequenceLengths(3); 
		int[] array2 = Collatz.memoizedComputeSequenceLengths(0); 
		int[] array3 = Collatz.memoizedComputeSequenceLengths(9); 
		assertTrue(array1[1] == 1);
		assertTrue(array1[2] == 2);
		assertTrue(array1[3] == 8);
		assertTrue(array2[0] == 0);
		assertTrue(array3[7] == 17);
	}

	@Test
	public void testCollatz_1() {
		long a = Collatz.collatz_1(7);
		long b = Collatz.collatz_1(10);
		long c = Collatz.collatz_1(1);
		long d = Collatz.collatz_1(100);
		long e = Collatz.collatz_1(0);
		assertTrue(a == 22);
		assertTrue(b == 5);
		assertTrue(c == 1);
		assertFalse(d == 1);
		assertFalse(e == 1);	
	}
	
	@Test
	public void testSequenceOf() {
		List<Long> List = new ArrayList<Long>();
		List.add(2L);
		List.add(1L);		
		List<Long> testList = new ArrayList<Long>();
		testList = Collatz.sequenceOf(2);
		assertTrue(List.equals(testList));
		assertFalse(List == testList);
	}
	
	@Test
	public void testLargestValueInSequence() {
		long a = Collatz.largestValueInSequence(3);
		long b = Collatz.largestValueInSequence(4);
		long c = Collatz.largestValueInSequence(5);
		long d = Collatz.largestValueInSequence(90);
		assertTrue(a == 16);
		assertTrue(b == 4);
		assertTrue(c == 16);
		assertFalse(d == 2);
	}

	@Test
	public void testEqualLengthTwins() {
		List<Pair<Long, Integer>> twinList1 = new ArrayList<Pair<Long, Integer>> ();
		List<Pair<Long, Integer>> twinList2 = new ArrayList<Pair<Long, Integer>> ();
		twinList1 = Collatz.equalLengthTwins(28, 29);
		twinList2 = Collatz.equalLengthTwins(28, 28);
		List<Pair<Long, Integer>> testList = new ArrayList<Pair<Long, Integer>> ();
		Pair<Long, Integer> twin = new Pair<Long, Integer>((long)28, 19);
		Pair<Long, Integer> twin2 = new Pair<Long, Integer>((long)29, 19);
		testList.add(twin);
		testList.add(twin2);
		assertTrue(twinList1.equals(testList));
		List<Pair<Long, Integer>> testList2 = new ArrayList<Pair<Long, Integer>> ();
		Pair<Long, Integer> twin3 = new Pair<Long, Integer>((long)28, 19);
		testList2.add(twin3);
		assertTrue(twinList2.equals(testList2));
	}

	@Test
	public void testEqualMaxValueTwins() {
		List<Pair<Long, Long>> twinList1 = new ArrayList<Pair<Long, Long>> ();
		List<Pair<Long, Long>> twinList2 = new ArrayList<Pair<Long, Long>> ();
		twinList1 = Collatz.equalMaxValueTwins(5, 6);
		twinList2 = Collatz.equalMaxValueTwins(15, 50);
		List<Pair<Long, Long>> testList = new ArrayList<Pair<Long, Long>> ();
		List<Pair<Long, Long>> testList2 = new ArrayList<Pair<Long, Long>> ();
		Pair<Long, Long> twin = new Pair<Long, Long>(5L, 16L);
		Pair<Long, Long> twin2 = new Pair<Long, Long>(17L, 52L);		
		testList.add(twin);
		testList2.add(twin2);
		assertTrue(twinList1.equals(testList));
		assertTrue(twinList2.equals(testList2));
	}
	
	@Test
	public void testOccurrences() {
		int k = 2;
		int[] array = new int[3]; 
		array[0] = 0;
		array[1] = 100;
		array[2] = 99;
		int[] testArray = Collatz.occurrences(100, k);
		assertTrue(array[0] == testArray[0]);
		assertTrue(array[1] == testArray[1]);
		assertTrue(array[2] == testArray[2]);
		
	}	
	
	@Test
	public void testOddOccurrences(){
		int[] testArray = Collatz.oddOccurrences(100, 10);
		assertTrue(testArray[0] == 0);
		assertTrue(testArray[1] == 1);
		assertTrue(testArray[2] == 1);
		assertTrue(testArray[3] == 3);
		assertTrue(testArray[4] == 1);
		assertTrue(testArray[5] == 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		Collatz.lengthOfSequence(-1);
		Collatz.simpleComputeSequenceLengths(-9); 
		Collatz.memoizedLengthOfSequence(-3, null);
		Collatz.memoizedComputeSequenceLengths(-3);
		Collatz.collatz_1(-68);
		Collatz.sequenceOf(-12);
		Collatz.largestValueInSequence(-8);
		Collatz.occurrences(-2, 0);
		Collatz.oddOccurrences(-2, 0);
	}
}
