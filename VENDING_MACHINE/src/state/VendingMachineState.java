package state;

import services.VendingMachine;

public abstract class VendingMachineState {
	
	VendingMachine machine;
	
	public VendingMachineState(VendingMachine machine) {
		this.machine = machine;
	}
	public abstract void selectItem(String itemCode);
	public abstract void insertMoney(float money);
	public abstract void dispense();
	public abstract void cancel();
}
