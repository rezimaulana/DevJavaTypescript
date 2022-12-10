package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class PrimeView {
	
	private ArrayList<Integer> arr = new ArrayList<>();
	private MainView mainView;
	
	PrimeView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.print("Input Lower Bound : ");
		final int lowerBound = ScannerUtil.scanInteger.nextInt();
		System.out.print("Input Upper Bound : ");
		final int upperBound = ScannerUtil.scanInteger.nextInt();
		input(lowerBound, upperBound);
	}
	
	private void input(final Integer lowerBound, final Integer upperBound) {
		for(int i = lowerBound; i<=upperBound; i++) {
			if(isPrime(i)) {
				arr.add(i);
			}
		}
		output();
	}
	
	private Boolean isPrime(final Integer num) {
		int count = 0;
		for(int i = 1; i <= num; i++) {
			if(num%i == 0) {
				count += 1;
			}
		}
		if(count == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void output() {
		System.out.println(arr);
		System.out.println("Coba Lagi?");
		System.out.println("1. Ya");
		System.out.println("2. Tidak");
		System.out.print("Pilih Opsi : ");
		final byte userOpt = ScannerUtil.scanByte.nextByte();
		switch (userOpt) {
		case 1: 
			arr = new ArrayList<>();
			show();
			break;
		case 2 : 
			mainView.show();
			break;
		default:
			show();
			break;
		}
	}
	
}
