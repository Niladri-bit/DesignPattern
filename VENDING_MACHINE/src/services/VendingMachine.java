package services;

import entities.Item;
import repositories.InventoryRepository;
import state.IdleState;
import state.VendingMachineState;

public class VendingMachine {
	private static VendingMachine INSTANCE;
	private Item itemSelected;
	private float amountDeposited;
	private VendingMachineState machineState;
	
	 private InventoryService inventoryService;

	    private VendingMachine() {
	        // wiring dependencies (manual DI)
	        InventoryRepository repo = new InventoryRepository();
	        this.inventoryService = new InventoryService(repo);
	        this.machineState = new IdleState(this);
	        
	    }
	    
	    public Item getItemSelected() {
			return itemSelected;
		}
		public void setItemSelected(Item itemSelected) {
			this.itemSelected = itemSelected;
		}
		public float getAmountDeposited() {
			return amountDeposited;
		}

		public void setAmountDeposited(float amountDeposited) {
			this.amountDeposited = amountDeposited;
		}
		

	public VendingMachineState getMachineState() {
			return machineState;
		}

		public void setMachineState(VendingMachineState machineState) {
			this.machineState = machineState;
		}

	public static synchronized VendingMachine getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new VendingMachine();
		}
		return INSTANCE;
	}
	
	public boolean isItemAvailable(String code) {
		return inventoryService.isAvailable(code);
	}
	
	public void selectItem(String code) {
		machineState.selectItem(code);
	}
	
	public void dispense() {
		machineState.dispense();
	}
	
	public void insertMoney(Float amount) {
		machineState.insertMoney(amount);
	}
	
	public void cancel() {
		machineState.cancel();
	}
	
	public void dispenseItem() {
		inventoryService.reduceStock(itemSelected.getItemCode());
		if(amountDeposited>itemSelected.getPrice()) {
			System.out.println("Returning amount: "+(amountDeposited-itemSelected.getPrice()));
		}
		System.out.println("Item dispensed "+itemSelected.getName());
		reset();
		setMachineState(new IdleState(this));
		
	}
	
	public Item getItem(String code) {
		return inventoryService.getItem(code);
	}
	
	public void reset() {
		this.amountDeposited = 0;
		this.itemSelected = null;
	}
	
	
	public void refund() {
	    System.out.println("Refunding money: " + amountDeposited);
	    reset();
	    setMachineState(new IdleState(this));
	}
	
	public void addProduct(String itemCode,
            String name,
            float price,
            int quantity) {

Item item = new Item(itemCode, name, price);

inventoryService.addItem(quantity, item);

System.out.println("Added product: " + name + " | Qty: " + quantity);
}
	
}
