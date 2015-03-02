package collatz;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * CIT 594:  HW 1 Collatz
 * @author James
 *
 */
/**
 * @author James
 *
 */
public class Collatz {

	/**
	 * Returns an integer array of size n+1, such that for all 1 <= i <= n, array element i 
	 * contains the length of the Collatz sequence starting with i. 
	 * Uses the lengthOfSequence function.
	 * @param n
	 * @return
	 */
	static int[] simpleComputeSequenceLengths(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		int[] array = new int[(int) (n + 1)];
		int j;
		for (int i = 1; i < (n + 1); i++) {
			j = lengthOfSequence(i);
			array[i] = j;
		}
		return array;
	}

	
	/**
	 * Helper function for memoizedComputeSequenceLengths.
	 * Uses memoization.
	 * @param n
	 * @param array
	 * @return
	 */
	static int memoizedLengthOfSequence(long n, int[] array) {
		if (n < 0 || array == null) {
			throw new IllegalArgumentException();
		}
		int i = 1;
		long j = n;
		while (n != 1) {
			if (n < j) {
				int m = i + array[(int) n] - 1;
				return m;
			}
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			i++;
		}
		return i;
	}
	
	/**
	 * Does same thing as simpleComputeSequenceLengths except uses memoization.
	 * @param n
	 * @param array
	 * @return
	 */
	static int[] memoizedComputeSequenceLengths(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		int[] array = new int[(int) (n + 1)];
		for (int i = 1; i < (n + 1); i++) {
			array[i] = memoizedLengthOfSequence(i, array);
		}
		return array;
	}

	/**
	 * Returns a long that is just one step in the Collatz sequence that starts with n.
	 * @param n
	 * @return
	 */
	static long collatz_1(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 1) {
			return 1;
		}
		long i;
		if (n % 2 == 0) {
			i = n / 2;
		} else {
			i = 3 * n + 1;
		}
		return i;
	}

	/**
	 * Returns a list of longs in the Collatz sequence that starts with n.
	 * @param n
	 * @return
	 */
	static List<Long> sequenceOf(long n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		List<Long> list = new ArrayList<Long>();
		list.add(n);
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			list.add(n);
		}
		return list;
	}

	/**
	 * Returns the length of the Collatz sequence starting with n
	 * @param n
	 * @return
	 */
	static int lengthOfSequence(long n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		int i = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			i++;
		}
		return i;
	}

	/**
	 * Returns the largest value in Collatz sequence starting with n.
	 * @param n
	 * @return
	 */
	static long largestValueInSequence(long n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		List<Long> list = new ArrayList<Long>();
		list = sequenceOf(n);
		long max = Collections.max(list);
		return max;
	}

	/**
	 * Returns a list of Pairs where each pair has equal lengths of Collatz sequences.
	 * @param lo
	 * @param hi
	 * @return
	 */
	static List<Pair<Long, Integer>> equalLengthTwins(long lo, long hi) {
		List<Pair<Long, Integer>> list = new ArrayList<Pair<Long, Integer>>();
		for (int i = (int) lo; i < (int) (hi + 1); i++) {
			int j = lengthOfSequence(i);
			int k = lengthOfSequence(i + 1);
			if (j == k) {
				Pair<Long, Integer> twin = new Pair<Long, Integer>((long) i, j);
				list.add(twin);
			}
		}
		return list;
	}

	/**
	 * Returns a list of Pairs where each pair has equal max values in their respective
	 * Collatz sequences.
	 * @param lo
	 * @param hi
	 * @return
	 */
	static List<Pair<Long, Long>> equalMaxValueTwins(long lo, long hi) {
		List<Pair<Long, Long>> list = new ArrayList<Pair<Long, Long>>();
		for (long i = lo; i < hi + 1; i++) {
			long j = largestValueInSequence(i);
			long k = largestValueInSequence(i + 1);
			if (j == k) {
				Pair<Long, Long> twin = new Pair<Long, Long>(i, j);
				list.add(twin);
			}
		}
		return list;
	}

	/**
	 * Returns a list of ints that counts the number of times location i occurs in 
	 * the Collatz sequence from 1 to n inclusive.
	 * @param n
	 * @param counts
	 * @return
	 */
	static int[] occurrences(long n, int counts) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		int[] array = new int[(counts + 1)];
		for (int i = 1; i <= n; i++) {
			for (long item : sequenceOf(i)){
				if (item <= counts) {
					array[(int) item]++;
				}
			}
		}
		return array;
	}
	
	/**
	 * Returns a list of ints that counts the number of times odd numbers occurs in 
	 * the Collatz sequence from 1 to n inclusive.
	 * @param n
	 * @param counts
	 * @return
	 */
	static int[] oddOccurrences(long n, int counts){
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		//finds out how many odd numbers are in an Collatz sequence from 1 to n inclusive
		int[] array = new int[(counts + 1)];
		for (int i = 1; i <= counts; i++){
			int k = 0;
			List<Long> list = sequenceOf(i);
			for (long item : list){
				if (item % 2 != 0){
					k++;
				}
			array[i] = k;
		}		
		}
		return array;
	}

	
	/**
	 * Does the timings for simpleComputeSequenceLengths and 
	 * memoizedComputeSequenceLengths.
	 * @param n
	 */
	static void doTimings(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		System.gc();
		long startTime1 = System.nanoTime();
		simpleComputeSequenceLengths(n);
		long elapsedTime1 = System.nanoTime() - startTime1;

		System.gc();
		long startTime2 = System.nanoTime();
		memoizedComputeSequenceLengths(n);
		long elapsedTime2 = System.nanoTime() - startTime2;
		System.out.printf("simple: %-15d memoized: %d\n", elapsedTime1, elapsedTime2);
	}

	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		doTimings(100000);
		doTimings(200000);
		doTimings(300000);
		doTimings(400000);
		doTimings(500000);
		doTimings(600000);
		doTimings(700000);
		doTimings(800000);
		doTimings(900000);
		doTimings(1000000);
		System.out.printf("%n");
		for (int n = 1; n < 101; n++){ 
			System.out.printf("%d: length %5d, max %5d: ", n, lengthOfSequence(n), largestValueInSequence(n)); 
			System.out.print(sequenceOf(n));
			System.out.printf("%n");
		}
		System.out.printf("%n");
		List<Pair<Long, Integer>> twinList = equalLengthTwins(1, 100);
		System.out.printf("List of equal length twins: ");
		System.out.println(twinList);
		List<Pair<Long, Long>> twinList2 = equalMaxValueTwins(1, 100);
		System.out.printf("List of equal value twins: ");
		System.out.println(twinList2);
		int[] array = occurrences(100, 1000000);
		System.out.printf("List of occurrences: ");
		for (int item : array){
			System.out.printf("%d, ", item);
		}
		System.out.printf("%n");
		int[] oddNum = oddOccurrences(100, 100);
		System.out.printf("List of odd occurrences: ");
		for (int item : oddNum){
			System.out.printf("%d, ", item);
		}
	}
}
