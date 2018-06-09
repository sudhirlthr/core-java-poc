/**
 * 
 */
package com.sudhir.airtel;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author sudhir
 *
 */
public class RollCharacterOfStrings {
	public static void main(String[] args) {
		int roll[] = {1,2,5};
		String str = "geeks";
		System.out.println(rollString(str,roll));
	}
	
	public static String rollString(String str, int[] roll) {
		int rollCounts[] = new int[str.length()];
		Arrays.stream(roll).forEach(rollCount -> rollCounts[rollCount - 1]++);
		
		System.out.println(Arrays.toString(rollCounts));
		for(int ind = roll.length-2;ind>=0;ind--) {
			rollCounts[ind] += rollCounts[ind+1];
		}
		
		char[] charr = str.toCharArray();
		IntStream.range(0, roll.length).forEach(ind->{
			charr[ind] = (char) ('a' + (rollCounts[ind]%26 + charr[ind]-'a')%26);
		});
		return String.valueOf(charr);
	}
}
