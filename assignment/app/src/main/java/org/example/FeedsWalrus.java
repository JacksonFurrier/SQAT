package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;

public class FeedsWalrus {

	OpensCan opensCan = new OpensCan();

	public void feed(Walrus gary, CannedWalrusFood can) {
		gary.addToStomach(opensCan.open(can));
	}

}
