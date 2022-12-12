package link.rezimaulana.algo.view;

import link.rezimaulana.algo.util.ScannerUtil;

public class CaseABCView {
	
	private MainView mainView;
	
	CaseABCView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.print("Input kalimat : ");
		final String word = ScannerUtil.scanString.nextLine();
		process(word);
	}
	
	public void process(final String word) {
		String result = "";
		Integer index = null;
		boolean status = false;
		String nextLoop = "no";
		for(int i=0; i<word.length(); i++) {
			nextLoop = "no";
			if(nextLoop == "no" && result.length() == 0) {
				if(Character.toString(word.charAt(i)).equals("A")) {
					result += word.charAt(i);
					index = i;
					nextLoop = "yes";
				}
			}
			if(nextLoop == "no" && result.length() == 1) {
				if(Character.toString(word.charAt(i)).equals("B")) {
					result += word.charAt(i);
					nextLoop = "yes";
				} else {
					result = "";
					index = null;
				}
				if(Character.toString(word.charAt(i)).equals("A")) {
					result += word.charAt(i);
					index = i;
					nextLoop = "yes";
				}
			}
			if(nextLoop == "no" && result.length() == 2) {
				if(Character.toString(word.charAt(i)).equals("C")) {
					result += word.charAt(i);
					nextLoop = "yes";
				} else {
					result = "";
					index = null;
				}
			}
			if(result.equals("ABC")) {
				status = true;
				break;
			}
		}
		output(status, result, index, word.length());
	}
	
	public void output(final boolean status, final String result, Integer index, final Integer len) {
		System.out.println(result);
		if(status == true) {
			System.out.println("Ditemukan ABC");
			int left = index;
			int right = len - left - 3;
			System.out.println("Total huruf di kiri : "+left);
			System.out.println("Total huruf di kanan : "+right);
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
