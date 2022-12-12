package link.rezimaulana.algo.view;

import link.rezimaulana.algo.util.ScannerUtil;

public class PascalView {
	
	private MainView mainView;
	
	PascalView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void show() {
	    System.out.print("Masukkan nilai: ");
	    final int a = ScannerUtil.scanInteger.nextInt();
	    for (int i=0; i<a; i++){
	    	for (int j =0; j<a-i-1; j++){
	    		System.out.print(" ");
	    	}
	    	for (int j =0; j<=i; j++){
	    		final long result = factorial(i) / ( factorial(j) * factorial(i-j) );
	    		System.out.print(result+" ");
	    	}
	    	System.out.println();
    	}
	}
	
	private long factorial(int n) {
		long z =1;
	    int i = 1;
	    while(i <= n){
	      z=z*i;
	      i++;
	    }
	    return z;
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
