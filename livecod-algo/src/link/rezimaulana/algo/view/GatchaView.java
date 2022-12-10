package link.rezimaulana.algo.view;

import java.util.ArrayList;

import link.rezimaulana.algo.util.ScannerUtil;

public class GatchaView {

	private MainView mainView;
	private final ArrayList<String> items = new ArrayList<>();
	private final ArrayList<Integer> chance = new ArrayList<>();
	
	GatchaView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	
	public void show() {
		System.out.print("Input jumlah item : ");
		final int menuOpt = ScannerUtil.scanInteger.nextInt();	
		input(menuOpt);
	}
	
	private void input(final Integer menuOpt) {
		for(int i = 0; i<menuOpt; i++) {
			System.out.print("Item ke "+i+" : ");
			final String itemValue = ScannerUtil.scanString.nextLine();
			System.out.print("Peluang item ke "+i+" [1-100]: ");
			final Integer itemChance = ScannerUtil.scanInteger.nextInt();
			items.add(itemValue);
			chance.add(itemChance);
		}
		final boolean val = validate(chance);
		if(val){
			process(items, chance);
		} else {
			System.out.println("Input Salah");
			exit();
		}
	}
	
	private boolean validate(ArrayList<Integer> chance) {
		boolean status = false;
		int chanceTotal = 0;
		for(int i = 0; i<= chance.size(); i++) {
			chanceTotal += chance.get(i);
		}
		if(chanceTotal == 100) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	private void process(ArrayList<String> items, ArrayList<Integer> chance) {
		
	}
	
	private void exit() {
		mainView.show();
	}
	
}
