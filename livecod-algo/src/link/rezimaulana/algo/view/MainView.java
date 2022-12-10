package link.rezimaulana.algo.view;

import link.rezimaulana.algo.util.ScannerUtil;

public class MainView {
	
	public void show() {
		System.out.println("1. Array");
		System.out.println("2. Separator");
		System.out.println("3. Nilai maksimum dan minimum");
		System.out.println("4. 123");
		System.out.println("5. ABC");
		System.out.println("6. Segitiga Paskal");
		System.out.println("7. Mesin Gatcha");
		System.out.println("8. Ganjil Genap");
		System.out.println("9. Prima");
		System.out.println("10. Fibonacci");
		System.out.println("0. Exit");		
		System.out.print("Pilih Opsi : ");
		final byte mainMenuOpt = ScannerUtil.scanByte.nextByte();
		switch (mainMenuOpt) {
		case 0:
			exit();
			break;
		case 1:
			optArray();
			break;
		case 7:
			optGatcha();
			break;
		case 8:
			optOddEven();
			break;
		case 9:
			optPrime();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + mainMenuOpt);
		}
	}
	
	private void optArray() {
		final ArrayView arrayView = new ArrayView();
		arrayView.show();
	}
	
	private void optGatcha() {
		final GatchaView gatchaView = new GatchaView(this);
		gatchaView.show();
	}
	
	private void optOddEven() {
		final OddEvenView oddEvenView = new OddEvenView(this);
		oddEvenView.show();
	}
	
	private void optPrime() {
		final PrimeView primeView = new PrimeView(this);
		primeView.show();
	}
	
	private void exit() {
		System.exit(0);
	}
	
}
