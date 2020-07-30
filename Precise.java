package cover;

import java.util.ArrayList;

public class Precise implements Soluction {
	
	boolean stop = false;
	
	public void combinations(int[] our_sets, int len, int start, int[] result, ArrayList<ArrayList<Integer> > sets, int end) {
	    if (len == 0) {
	    	
			ArrayList<Integer> result_of_check = new ArrayList<Integer>();
			boolean[] included = new boolean[end + 1];
			for (int i = 1; i <= end; i++) {
				included[i] = false;
			}

			for (int l = 0; l < result.length; l++) {
				ArrayList<Integer> checking = sets.get(result[l]);
				result_of_check.add(result[l] + 1);
				checking.add(0);
				checking.add(0);
				
				for (int i = 0; i < (checking.size() - 2); i++) {
					if (checking.get(i) != 0) {
						if (checking.get(i + 1) >= 0) {
							if (checking.get(i) <= end && checking.get(i) >= 1) {
								included[checking.get(i)] = true;
							}
						}
						else {
							if (checking.get(i + 2) >= 0) {
								for (int j = checking.get(i); j <= end; j = j - checking.get(i + 1)) {
									included[j] = true;
								}
								i++;
							}
							else {
								for (int j = checking.get(i); (j <= end && j <= ((-1) * checking.get(i + 2))); j = j - checking.get(i + 1)) {
									included[j] = true;
								}
								i = i + 2;
							}
						}
					}
				}
			}

			// checking if we covered Z
			boolean possible = true;
			for (int i = 1; i <= end; i++) {
				if (included[i] == false) {
					possible = false;
				}
			}

			if (possible == true) {
				Result.show(result_of_check);
				stop = true;
			}

	        return;
	    }
	    for (int i = start; i <= our_sets.length - len; i++) {
	        result[result.length - len] = our_sets[i];
	        combinations(our_sets, len - 1, i + 1, result, sets, end);
	        if (stop == true) {
	            return;
	        }
	    }
	}
	
	public void check(ArrayList<ArrayList<Integer> > sets, int end) {
		
		int k = sets.size();
		int[] our_sets = new int[k];
		for(int i = 0; i < k; i++) {
			our_sets[i] = i;
		}
		
		stop = false;
		for (int j = 1; j <= k; j++) {
			if (stop == false) {
				combinations(our_sets, j, 0, new int[j], sets, end);	
			}	
		}
		if (stop == false) {
			System.out.println("0");
		}
	}
}
