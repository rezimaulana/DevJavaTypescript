package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class OddEvenView {
	
	private MainView mainView;
	private ArrayList<Integer> arr = new ArrayList<>();
	
	OddEvenView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.println("1. Ganjil");
		System.out.println("2. Genap");
		System.out.print("Pilih Opsi : ");
		final byte menuOpt = ScannerUtil.scanByte.nextByte();
		input(menuOpt);
	}
	
	private void input(final Byte menuOpt) {
		System.out.print("Input Lower Bound : ");
		final int lowerBound = ScannerUtil.scanInteger.nextInt();
		System.out.print("Input Upper Bound : ");
		final int upperBound = ScannerUtil.scanInteger.nextInt();
		process(menuOpt, lowerBound, upperBound);
	}
	
	private void process(final Byte menuOpt, final Integer lowerBound, final Integer upperBound) {
		if(menuOpt == 1) {
			processOdd(lowerBound, upperBound);
		} else if (menuOpt == 2) {
			processEven(lowerBound, upperBound);
		} else {
			show();
		}
	}
	
	private void processOdd(final Integer lowerBound, final Integer upperBound) {
		for(int i = lowerBound; i<=upperBound; i++) {
			if(i%2 != 0) {
				arr.add(i);
			}
		}
		output();
	}
	
	private void processEven(final Integer lowerBound, final Integer upperBound) {
		for(int i = lowerBound; i<=upperBound; i++) {
			if(i%2 == 0) {
				arr.add(i);
			}
		}
		output();
	}
	
	private void output() {
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
