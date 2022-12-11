package link.rezimaulana.algo.view;

import link.rezimaulana.algo.util.ScannerUtil;

public class SeparatorView {

	private MainView mainView;
	
	SeparatorView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.print("Masukan kata : ");
		final String word = ScannerUtil.scanString.nextLine();
		System.out.println("Input separator : [Pilih Index]");
		for(int i = 1; i<=word.length()+1; i++) {
			System.out.println("Pada karakter : "+i);
		}
		System.out.println("Pilih Opsi: ");
		final int separator = ScannerUtil.scanInteger.nextInt();
		process(word, separator);
	}
	
	private void process(final String word, final int separator) {
	String result = "";
       final int len = word.length();
       for (int i=0; i<len; i++){
    	   if(separator-1 == i) {
    		   result += "-";
    	   }
           result += word.charAt(len-i-1);
       }
       System.out.println(result);
		output(result);
	}
	
	private void output(final String result) {
		System.out.println(result);
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
