package pt.org.upskill.controller;

import pt.org.upskill.DTO.AgentDTO;
import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.Mapper.AgentMapper;
import pt.org.upskill.Mapper.StoreMapper;
import pt.org.upskill.domain.*;
import pt.org.upskill.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

public class CreateAgentController {
    private StoreRepository storeRepository;
    private OrganizationRepository organizationRepository;
    private AuthenticationRepository authenticationRepository;

    public CreateAgentController() {
        getStoreRepository();
        getAuthenticationRepository();
    }

    public CreateAgentController(StoreRepository storeRepository, AuthenticationRepository authenticationRepository) {
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
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public AgentDTO createEmployee(String email, String name, int phone, String position) {
        Employee employee = getEmployeeFromSession();
        Organization organization = getOrganizationRepository().getOrganizationByEmployee(employee);

        if (organization != null) {
            Employee newEmployee = organization.createEmployee(email, name, phone, position);
            organization.addEmployee(newEmployee);

            return AgentMapper.toDTO(newEmployee);
        }
        return null;
    }


    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}