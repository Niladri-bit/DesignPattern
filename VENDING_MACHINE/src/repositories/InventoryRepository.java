package repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import entities.Item;

public class InventoryRepository {

    private Map<String, Item> itemMap = new ConcurrentHashMap<>();
    private Map<String, Integer> stockMap = new ConcurrentHashMap<>();

    public void saveItem(Item item) {
        itemMap.put(item.getItemCode(), item);
    }

    public Item getItem(String itemCode) {
        return itemMap.get(itemCode);
    }

    public int getStock(String itemCode) {
        return stockMap.getOrDefault(itemCode, 0);
    }
    
    public void updateStock(String itemCode, int quantity) {
        if (quantity <= 0) {
            stockMap.remove(itemCode);
            itemMap.remove(itemCode); // optional: depends on design
        } else {
            stockMap.put(itemCode, quantity);
        }
    }
}
