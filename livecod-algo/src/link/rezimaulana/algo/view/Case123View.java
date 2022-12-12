package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class Case123View {

	private ArrayList<Integer> arr = new ArrayList<>();
	private MainView mainView;
	
	Case123View(MainView mainView){
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
		String result = "";
		boolean status = false;
		boolean nextLoop = false;
		for(int i=0; i<arr.size(); i++) {
			nextLoop = false;
			if(nextLoop == false && result.length() == 0) {
				if(arr.get(i)==1) {
					result += arr.get(i).toString();
					nextLoop = true;
				}
			}
			if(nextLoop == false && result.length() == 1) {
				if(arr.get(i)==2) {
					result += arr.get(i).toString();
					nextLoop = true;
				} else {
					result = "";
				}
				if(arr.get(i)==1) {
					result += arr.get(i).toString();
					nextLoop = true;
				}
			}
			if(nextLoop == false && result.length() == 2) {
				if(arr.get(i)==3) {
					result += arr.get(i).toString();
					nextLoop = true;
				} else {
					result = "";
				}
			}
			if(result.equals("123")) {
				status = true;
				break;
			}
		}
		output(status, result);
	}
	
	public void output(final boolean status, final String result) {
		System.out.println(result);
		if(status == true) {
			System.out.println("Ditemukan 123");
		} else {
			System.out.println("Tidak ditemukan");
		}
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
