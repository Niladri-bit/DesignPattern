package state;

import services.VendingMachine;

public class DispensingState extends VendingMachineState{

	public DispensingState(VendingMachine machine) {
		super(machine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectItem(String itemCode) {
		// TODO Auto-generated method stub
		System.out.println("Item is already selected");
		
	}

	@Override
	public void insertMoney(float money) {
		// TODO Auto-generated method stub
		System.out.println("Money is already inserted");
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		machine.dispenseItem();
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		machine.refund();
		
	}

}
