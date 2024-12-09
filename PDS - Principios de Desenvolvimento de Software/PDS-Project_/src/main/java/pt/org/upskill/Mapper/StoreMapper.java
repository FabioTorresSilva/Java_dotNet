package pt.org.upskill.Mapper;

import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreMapper {

    public static StoreDTO toDTO(Store store) {
        if (store == null) {
            return null;
        }
        return new StoreDTO(store.getCode(), store.getDesignation(), store.getAddress());
    }

    public static List<StoreDTO> StoreMapper(List<Store> stores) {
        List<StoreDTO> storeDtos = new ArrayList<>();
        for (Store s : stores) {
            if (s != null) {
                storeDtos.add(new StoreDTO(
                        s.getCode(),
                        s.getDesignation(),
                        s.getAddress()
                ));
            }
        }
        return storeDtos;
    }
}
