package problem1068;

import java.util.*;

public class Main{

    public static Scanner in;
 
    public static void main(String[] args){
        in=new Scanner(System.in);
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
        	int n = in.nextInt();
        	int[] pseq = new int[n];
        	char[] parens = new char[n*2];
        	Arrays.fill(parens, '(');
        	for (int j = 0; j < n; j++) {
				pseq[j] = in.nextInt();
				parens[j+pseq[j]] = ')';
			}
        	for (int j = 0; j < n; j++) {
        		int pos = pseq[j] + j;
        		int ptr = 1;
        		int count = 1;
        		// Start backtracking from pos
        		while (ptr > 0) {
        			pos--;
        			if (parens[pos] == ')') { 
        				count++;
        				ptr++;
        			}
        			else
        				ptr--;
        		}

        		if (j == (n-1))
        			System.out.printf("%d",count);
        		else        			
        			System.out.printf("%d ",count);
        	}
        	System.out.println();
		}
    }
}