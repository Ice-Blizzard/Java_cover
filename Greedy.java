package cover;

import java.util.ArrayList;

public class Greedy implements Soluction {
	
	public void check(ArrayList<ArrayList<Integer> > sets, int end) {
		
		boolean[] included = new boolean[end + 1];
		boolean[] joined = new boolean[sets.size() + 1];
		int[] elements = new int[sets.size() + 1];
		int new_elements = -1;
		for (int i = 1; i<= sets.size(); i++) {
			joined[i] = false;
		}
		for (int i = 1; i <= end; i++) {
			included[i] = false;
		}			
			
		while (new_elements != 0) {
			// checking for every sets how much we can gain
			for (int k = 0; k < sets.size(); k++) {
				ArrayList<Integer> checking = sets.get(k);
				checking.add(0);
				checking.add(0);
				elements[k + 1] = 0;
				boolean[] included_copy = new boolean[end + 1];
				for (int i = 1; i <= end; i++) {
					included_copy[i] = included[i];
				}
				if (joined[k + 1] == false) {
					for (int i = 0; i < (checking.size() - 2); i++) {
						if (checking.get(i) != 0) {
							if (checking.get(i + 1) >= 0) {
								if (checking.get(i) <= end && checking.get(i) >= 1) {
									if (included_copy[checking.get(i)] == false) {
										elements[k + 1]++;
										included_copy[checking.get(i)] = true;
									}
								}
							}
							else {
								if (checking.get(i + 2) >= 0) {
									for (int j = checking.get(i); j <= end; j = j - checking.get(i + 1)) {
										if (included_copy[j] == false) {
											elements[k + 1]++;
											included_copy[j] = true;
										}
									}
									i++;
								}
								else {
									for (int j = checking.get(i); (j <= end && j <= ((-1) * checking.get(i + 2))); j = j - checking.get(i + 1)) {
										if (included_copy[j] == false) {
											elements[k + 1]++;
											included_copy[j] = true;
										}
									}
									i = i + 2;
								}
							}
						}
					}
				}
			}

			// seaching for most giving set
			for (int k = 0; k < sets.size(); k++) {
				if (elements[k + 1] > new_elements) {
					new_elements = elements[k + 1];
				}
			}
			if (new_elements == 0 || new_elements == (-1)) {
				new_elements = 0;
			}
			else {
				// adding new set
				boolean adding = false;
				for (int k = 0; k < sets.size(); k++) {
					if (elements[k + 1] == new_elements && adding == false) {
						adding = true;
						joined[k + 1] = true;
						ArrayList<Integer> checking = sets.get(k);
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
				}
				new_elements = -1;
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
			ArrayList<Integer> result = new ArrayList<Integer>();
			for (int k = 0; k < sets.size(); k++) {
				if (joined[k + 1] == true) {
					result.add(k + 1);
				}
			}
			// showing result
			Result.show(result);
		}
	}
}
