package cover;

import java.util.ArrayList;

public class Naive implements Soluction {
	
	public void check(ArrayList<ArrayList<Integer> > sets, int end) {
		
		boolean[] included = new boolean[end + 1];
		for (int i = 1; i <= end; i++) {
			included[i] = false;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int k = 0; k < sets.size(); k++) {
			ArrayList<Integer> checking = sets.get(k);
			boolean new_set = false;
			checking.add(0);
			checking.add(0);
			
			for (int i = 0; i < (checking.size() - 2); i++) {
				if (checking.get(i) != 0) {
					if (checking.get(i + 1) >= 0) {
						if (checking.get(i) <= end && checking.get(i) >= 1) {
							if (included[checking.get(i)] == false && new_set == false) {
								result.add(k + 1);
								new_set = true;
							}
							included[checking.get(i)] = true;
						}
					}
					else {
						if (checking.get(i + 2) >= 0) {
							for (int j = checking.get(i); j <= end; j = j - checking.get(i + 1)) {
								if (included[j] == false && new_set == false) {
									result.add(k + 1);
									new_set = true;
								}
								included[j] = true;
							}
							i++;
						}
						else {
							for (int j = checking.get(i); (j <= end && j <= ((-1) * checking.get(i + 2))); j = j - checking.get(i + 1)) {
								if (included[j] == false && new_set == false) {
									result.add(k + 1);
									new_set = true;
								}
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

		if (possible == false) {
			System.out.println("0");
		}
		else {
			// showing result
			Result.show(result);
		}
	}
}
