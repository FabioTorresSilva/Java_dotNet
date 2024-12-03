package pt.org.upskill.repository;

import pt.org.upskill.domain.Store;
import pt.org.upskill.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    private final List<Store> storeList = new ArrayList<>(); // Simulating an in-memory database

    // Add a new Store
    public boolean create(Store store) {
        if (store == null) {
            return false;
        }
        return storeList.add(store);
    }

    // Retrieve all Stores
    public List<Store> readAll() {
        return new ArrayList<>(storeList); // Return a copy to prevent external modification
    }



    // Update an existing Store
    public boolean update(Store updatedStore) {
        for (int i = 0; i < storeList.size(); i++) {
            if (storeList.get(i).getCode() == updatedStore.getCode()) {
                storeList.set(i, updatedStore);
                return true;
            }
        }
        return false; // Store not found
    }



    // Find a Store by Name
    public Store findByName(String name) {
        return storeList.stream()
                .filter(store -> store.getCode().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null); // Return null if no store with the given name is found
    }


}
