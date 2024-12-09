package pt.org.upskill.controller;

import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.Mapper.StoreMapper;
import pt.org.upskill.domain.*;
import pt.org.upskill.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

public class CreateStoreController {
    private StoreRepository storeRepository;
    private OrganizationRepository organizationRepository;
    private AuthenticationRepository authenticationRepository;

    public CreateStoreController() {
        this.storeRepository = Repositories.getInstance().getStoreRepository();
        this.organizationRepository = getOrganizationRepository();
        this.authenticationRepository = getAuthenticationRepository();
    }

    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public StoreDTO createStore(String openingTime, String closingTime, String designation, String address) {
        Employee employee = getEmployeeFromSession();
        Organization organization = organizationRepository.getOrganizationByEmployee(employee);

        if (organization == null) {
            throw new IllegalArgumentException("No organization found for the current employee.");
        }

        Store store = organization.createStore(openingTime, closingTime, designation, address);
        storeRepository.addStore(store);

        return StoreMapper.toDTO(store);
    }

    public List<StoreDTO> getStores() {
        List<Store> stores = storeRepository.getAllStores();
        return StoreMapper.StoreMapper(stores);
    }

    private Employee getEmployeeFromSession() {
        Email email = authenticationRepository.getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}