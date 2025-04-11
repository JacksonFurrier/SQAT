package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.WalrusFood;

public class OpensCan {

	public WalrusFood open(CannedWalrusFood can) {
		return can.extractContents();
	}

}
