package org.SDA.Optionals;

import java.util.*;

public class ItemDatabase {
    private final Set<Item> items;

    public ItemDatabase(Set<Item> items) {
        this.items = items;
    }

    public Optional<Item> getItem(Integer id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return Optional.of(item);
            }
        }

        // Optional.of - when we're sure that the object isn't null
        // Optional.ofNullable - when the object can be null
        // Optional.empty - when we're sure that the object is null

        return Optional.empty();
    }

    public static void example() {
        Set<Item> items = new HashSet<>();
        items.add(new Item(1, "Sugar", 10.0));
        items.add(new Item(2, "Salt", 5.0));
        items.add(new Item(3, "Pepper", 8.0));

        ItemDatabase db = new ItemDatabase(items);

        // Imperative approach
        Optional<Item> optionalItem = db.getItem(2);

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            System.out.println(item.getName());
        }

        // Functional approach
        db.getItem(2).ifPresent(item -> System.out.println(item.getName()));
    }
}
