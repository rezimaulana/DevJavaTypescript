package link.rezimaulana.algo.view;

import java.util.ArrayList;
import java.util.Arrays;

import link.rezimaulana.algo.util.ScannerUtil;

public class ArrayView {
	
	private MainView mainView;
	
	ArrayView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		//array declarev cx rv uv dx cannot direct print
		int[] arr = {10, 20, 30, 40};
		System.out.println(arr.toString());
		arr[0] = 20;
		System.out.println(arr.toString());

		//arraylist declarev cv rv uv dx
		ArrayList<Integer> arrL = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println(arrL);
		arrL.add(10);
		System.out.println(arrL);
		System.out.println(arrL.get(0));
		arrL.set(2, 100);
		System.out.println(arrL);
		arrL.remove(2);
		System.out.println(arrL);		
	}
	
	public void output() {
		System.out.println("Coba Lagi?");
		System.out.println("1. Ya");
		System.out.println("2. Tidak");
		System.out.print("Pilih Opsi : ");
		final byte userOpt = ScannerUtil.scanByte.nextByte();
		switch (userOpt) {
		case 1: 
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
