package pt.org.upskill.controller;

import pt.org.upskill.DTO.AgentDTO;
import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.Mapper.AgentMapper;
import pt.org.upskill.Mapper.StoreMapper;
import pt.org.upskill.domain.*;
import pt.org.upskill.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.stream.Collectors;

public class ListAgentsController {
    private OrganizationRepository organizationRepository;
    private AgentRepository agentRepository;
    private AuthenticationRepository authenticationRepository;

    public ListAgentsController() {
        organizationRepository = Repositories.getInstance().getOrganizationRepository();
        authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    public List<AgentDTO> getAgents() {
        Email currentUserEmail = authenticationRepository.getCurrentUserSession().getUserId();
        Employee employee = new Employee(currentUserEmail.getEmail());
        Organization organization = organizationRepository.getOrganizationByEmployee(employee);

        if (organization == null) {
            return null; // or throw an exception depending on your logic
        }

        List<Employee> employees = organization.getAllEmployees();
        return AgentMapper.AgentMapper(employees);
    }
}