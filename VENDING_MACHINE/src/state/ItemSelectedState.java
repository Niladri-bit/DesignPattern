package state;

import services.VendingMachine;

public class ItemSelectedState extends VendingMachineState{

	public ItemSelectedState(VendingMachine machine) {
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

	    machine.setAmountDeposited(
	        machine.getAmountDeposited() + money
	    );

	    float price = machine.getItemSelected().getPrice();
	    float total = machine.getAmountDeposited();

	    if (total >= price) {
	        System.out.println("Enough money received");
	        machine.setMachineState(new DispensingState(machine));
	    } else {
	        System.out.println("Inserted: " + total +
	                " | Remaining: " + (price - total));
	    }
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("Insert money");
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		machine.reset();
		machine.setMachineState(new IdleState(machine));
		System.out.println("Transaction canceled");
		
	}

}
