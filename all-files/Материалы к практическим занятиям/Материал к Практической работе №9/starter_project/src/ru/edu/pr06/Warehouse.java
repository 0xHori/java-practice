package ru.edu.pr06;
import java.util.*;
public class Warehouse {
 private final Map<String,StockItem> items=new HashMap<>(); private final List<StockMovement> movements=new ArrayList<>();
 public void addItem(StockItem item) { /* TODO 3 */ }
 public void receive(String code,int q) { /* TODO 4 */ }
 public void issue(String code,int q) { /* TODO 5 */ }
 public List<StockItem> findByCategory(Category c) { /* TODO 6 */ return List.of(); }
 public Map<Category,Integer> totalsByCategory() { /* TODO 7 */ return Map.of(); }
}
