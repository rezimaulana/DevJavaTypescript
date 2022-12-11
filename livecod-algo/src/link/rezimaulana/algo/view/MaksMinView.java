package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class MaksMinView {
	
	private ArrayList<Integer> arr = new ArrayList<>();
	private MainView mainView;
	
	MaksMinView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.print("Input jumlah data : ");
		final int len = ScannerUtil.scanInteger.nextInt();
		for(int i = 0; i<len; i++) {
			System.out.print("Masukan angka : ");
			final int nums = ScannerUtil.scanInteger.nextInt();
			arr.add(nums);
		}
		process();
	}
	
	public void process() {
		int maks = arr.get(0);
		int min = arr.get(0);
		for(int i = 0; i<arr.size(); i++) {
			if(maks<arr.get(i)) {
				maks = arr.get(i);
			}
			if(min>arr.get(i)) {
				min = arr.get(i);
			}
		}
		int resultMaks = 0;
		int resultMin = 0;
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i) != maks) {
				resultMaks += arr.get(i);
			}
			if(arr.get(i) != min) {
				resultMin += arr.get(i);
			}
		}
		output(resultMaks, resultMin);
	}
	
	public void output(final int maks, final int min) {
		System.out.println("Nilai Minimum : "+maks);
		System.out.println("Nilai Maksimum : "+min);
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
