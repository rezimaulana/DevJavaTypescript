package com.lawencon.app.view;

import java.util.ArrayList;

import com.lawencon.app.util.ScannerUtil;

public class MainView {
	
	private ArrayList<Integer> arr = new ArrayList<>();
	
	public void show() {
		System.out.println("input jumlah data : ");
		final int menuOpt = ScannerUtil.scanInteger.nextInt();
		for (int i = 0; i < menuOpt; i++) {
			System.out.print("input angka ke "+(i+1)+" : ");
			final int nums = ScannerUtil.scanInteger.nextInt();
			arr.add(nums);
		}
		process();
	}
	
	private void process() {
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
		
		String omaks = "";
		String omin = "";
		
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i) != maks) {
				resultMaks += arr.get(i);
				omaks += arr.get(i)+"+";
			}
			if(arr.get(i) != min) {
				resultMin += arr.get(i);
				omin += arr.get(i)+"+";
			}
		}
		
		output(resultMaks, resultMin, omaks, omin);
	}
	
	public void output(final int maks, final int min, final String omaks, final String omin) {
		System.out.println(arr);
		System.out.println("output penjumlahan minimum = "+omaks+" = "+maks);
		System.out.println("output penjumlahan maksimum = "+omin+" = "+min);
		System.out.println("coba lagi?");
		System.out.println("1.ya");
		System.out.println("2.tidak");
		System.out.print("pilih opsi : ");
		final byte userOpt = ScannerUtil.scanByte.nextByte();
		switch (userOpt) {
		case 1: 
			arr = new ArrayList<>();
			show();
			break;
		case 2 : 
			System.exit(0);
			break;
		default:
			show();
			break;
		}
	}
	
}
