package pt.org.upskill.controller;

import pt.org.upskill.domain.*;
import pt.org.upskill.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

public class CreateStoreController {
    private StoreRepository storeRepository;
    private OrganizationRepository organizationRepository;
    private AuthenticationRepository authenticationRepository;

    //Repository instances are obtained from the Repositories class
    public CreateStoreController() {
        this.storeRepository = getStoreRepository();
        this.organizationRepository = getOrganizationRepository();
        this.authenticationRepository = getAuthenticationRepository();
    }


    //Allows receiving the repositories as parameters for testing purposes
    public CreateStoreController(StoreRepository storeRepository, AuthenticationRepository authenticationRepository) {
        this.storeRepository = storeRepository;
        this.authenticationRepository = authenticationRepository;
    }

    private StoreRepository getStoreRepository() {
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        System.out.println(storeRepository);
        return storeRepository;

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

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public Store createStore(String openingTime, String closingTime) {
        try {
            Employee employee = getEmployeeFromSession();
            Organization organization = organizationRepository.getOrganizationByEmployee(employee);

            if (organization == null) {
                System.err.println("No organization found for the current employee.");
                return null;
            }

            Store newStore = organization.createStore(openingTime, closingTime);

            if (newStore == null) {
                System.err.println("Failed to create the store.");
            }

            return newStore;

        } catch (Exception e) {
            System.err.println("An error occurred while creating the store: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    public List<Store> getStores() {
        return storeRepository.readAll();
    }
}