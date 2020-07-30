package cover;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<ArrayList<Integer> > sets =  
                new ArrayList<ArrayList<Integer> >();
        
        while (in.hasNextInt()) {
        	int one = in.nextInt();
        	if (one == 0) {
        		ArrayList<Integer> empty = new ArrayList<Integer>(); 
                empty.add(0);
                sets.add(empty);
        	}
        	else {
        		int two = in.nextInt();
            	if (one < 0) {
            		one = one * (-1);
            		
            		if (two == 1) {
            			new Precise().check(sets, one);
            		}
            		if (two == 2) {
            			new Greedy().check(sets, one);
            		}
            		if (two == 3) {
            			new Naive().check(sets, one);
            		}
            	}
            	else {
            		ArrayList<Integer> set = new ArrayList<Integer>();
            		set.add(one);
            		while (two != 0) {
            			set.add(two);
            			two = in.nextInt(); 
            		}
            		sets.add(set);
            	}
        	}  	
        }
	}
}
