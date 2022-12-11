package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class FibonacciView {
	
	private MainView mainView;
	private ArrayList<Integer> arr = new ArrayList<>();
	
	FibonacciView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.println("Metode berhitung");
		System.out.println("1. Lowerbound dan Upperbound");
		System.out.println("2. Range");
		System.out.print("Pilih Opsi : ");
		final byte menuOpt = ScannerUtil.scanByte.nextByte();
		switch(menuOpt) {
			case 1 :
				bound();
				break;
			case 2 : 
				range();
				break;
			default :
				show();
				break;
		}
	}
	
	private void bound() {
		System.out.print("Input Lower Bound : ");
		final int lowerBound = ScannerUtil.scanInteger.nextInt();
		System.out.print("Input Upper Bound : ");
		final int upperBound = ScannerUtil.scanInteger.nextInt();
		final String status = "bound";
		countFib(lowerBound, upperBound, status);
	}
	
	private void range() {
		System.out.print("Input Range Fibonacci : ");
		final int upperBound = ScannerUtil.scanInteger.nextInt();
		final int lowerBound = 1;
		final String status = "range";
		countFib(lowerBound, upperBound, status);
	}
	
	private void countFib(final Integer lowerBound, final Integer upperBound, final String status) {
		int a = 0;
		int b = 1;
		if(lowerBound == 1) {
			arr.add(a);
			arr.add(b);
		} else if(lowerBound == 2) {
			arr.add(b);
		}
		for(int i = 2; i < upperBound; i++) {
			final int result = a + b;
			arr.add(result);
			a = b;
			b = result;
			if(status.equals("bound") && b > upperBound) {
				arr.remove(arr.size()-1);
				break;
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
