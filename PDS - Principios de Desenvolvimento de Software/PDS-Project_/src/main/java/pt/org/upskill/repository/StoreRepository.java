package pt.org.upskill.repository;

import pt.org.upskill.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    private static StoreRepository instance; // Singleton instance
    private final List<Store> storeList = new ArrayList<>(); // Simulating an in-memory database

    // Private constructor to prevent direct instantiation
    public StoreRepository() {}

    // Public method to get the singleton instance
    public static StoreRepository getInstance() {
        if (instance == null) {
            instance = new StoreRepository();
        }
        return instance;
    }

    // Add a new Store
    public boolean addStore(Store store) {
        if (store == null) {
            return false;
        }
        return storeList.add(store);
    }

    public List<Store> getAllStores() {
        return new ArrayList<>(storeList); // Return a copy to prevent external modification
    }

    public boolean updateStore(Store updatedStore) {
        for (int i = 0; i < storeList.size(); i++) {
            if (storeList.get(i).getCode().equals(updatedStore.getCode())) {
                storeList.set(i, updatedStore);
                return true;
            }
        }
        return false; // Store not found
    }

    public Store findByCode(String code) {
        return storeList.stream()
                .filter(store -> store.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
