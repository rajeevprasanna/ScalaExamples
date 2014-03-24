package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, shows the first 11 ugly numbers. By
 * convention, 1 is included. Write a program to find and print the 150th ugly
 * number.
 * 
 * Refer: http://www.geeksforgeeks.org/ugly-numbers/
 */
public class UglyNumbersJava {
	
	public static void main(String[] args) {
		List<Integer> uglyNumbers = new ArrayList<Integer>();
		uglyNumbers.add(1);

		// Initialize three pointers to i2,i3,i5
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		// initialize three choices for the next ugly numbers
		int next_multiple_2 = uglyNumbers.get(i2) * 2;
		int next_multiple_3 = uglyNumbers.get(i3) * 3;
		int next_multiple_5 = uglyNumbers.get(i5) * 5;

		int n = 11;
		for (int i = 0; i < n; i++) {			 
			int nextUglyNumber = min(next_multiple_2, next_multiple_3, next_multiple_5);			 
			uglyNumbers.add(nextUglyNumber);

			if (nextUglyNumber == next_multiple_2) {
				i2++; 
				next_multiple_2 = uglyNumbers.get(i2) * 2;
			}

			if (nextUglyNumber == next_multiple_3) {
				i3++;
				next_multiple_3 = uglyNumbers.get(i3) * 3;
			}

			if (nextUglyNumber == next_multiple_5) {
				i5++;	 
				next_multiple_5 = uglyNumbers.get(i5) * 5;
			}			
		}

		for (Integer uglyNumber : uglyNumbers) {
			System.out.print(uglyNumber+ "   ");
		}
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c) {
			return a;
		} else if (b <= a && b <= c) {
			return b;
		} else {
			return c;
		}
	}
}
