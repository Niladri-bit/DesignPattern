package state;

import entities.Item;
import services.VendingMachine;

public class IdleState extends VendingMachineState{

	public IdleState(VendingMachine machine) {
		super(machine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectItem(String itemCode) {
		// TODO Auto-generated method stub
		if (!machine.isItemAvailable(itemCode)) {
	        System.out.println("Item not available");
	        return;
	    }
		Item item = machine.getItem(itemCode);
		machine.setItemSelected(item);
		machine.setMachineState(new ItemSelectedState(machine));
		System.out.println("item is selected "+item.getName());
		
	}

	@Override
	public void insertMoney(float money) {
		// TODO Auto-generated method stub
		System.out.println("Select item first");
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("Select item first");
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("Select item first");
	}

}
