package services;

import entities.Item;
import repositories.InventoryRepository;

public class InventoryService {

    private InventoryRepository repo;
    
    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    public void addItem(int quantity, Item item) {
        repo.saveItem(item);
        int currentStock = repo.getStock(item.getItemCode());
        repo.updateStock(item.getItemCode(), currentStock + quantity);
        
    }

    public void updatePrice(String itemCode, float price) {
        Item item = repo.getItem(itemCode);
        if (item == null) {
            throw new RuntimeException("Item not found");
        }
        item.setPrice(price);
        repo.saveItem(item);
    }

    public boolean isAvailable(String itemCode) {
        return repo.getStock(itemCode) > 0;
    }
    
    public void reduceStock(String itemCode) {
        int currentStock = repo.getStock(itemCode);

        if (currentStock <= 0) {
            throw new RuntimeException("Item out of stock");
        }

        repo.updateStock(itemCode, currentStock - 1);
    }
    
    public Item getItem(String itemCode) {
        Item item = repo.getItem(itemCode);

        if (item == null) {
            throw new RuntimeException("Item not found: " + itemCode);
        }

        return item;
    }
}