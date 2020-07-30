package cover;

import java.util.ArrayList;

public class Result {

	// if its possible to cover our set and sets needed are in result we print result
	public static void show(ArrayList<Integer> result) {
		if (result.size() == 1) {
			System.out.println(result.get(0));
		}
		else {
			for (int i = 0; i < result.size(); i++) {
				if (i == 0) {
					System.out.print(result.get(i));
				}
				else {
					System.out.print(" ");
					if (i == (result.size() - 1)) {
						System.out.println(result.get(i));
					}
					else {
						System.out.print(result.get(i));
					}
				}
			}
		}
	}
}
