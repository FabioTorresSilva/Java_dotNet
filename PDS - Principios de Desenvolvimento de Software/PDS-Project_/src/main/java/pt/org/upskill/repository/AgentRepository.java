package pt.org.upskill.repository;

import pt.org.upskill.domain.Employee;
import java.util.ArrayList;
import java.util.List;

public class AgentRepository {
    private static AgentRepository instance;
    private final List<Employee> agentList = new ArrayList<>();

    public AgentRepository() {}

    public static AgentRepository getInstance() {
        if (instance == null) {
            instance = new AgentRepository();
        }
        return instance;
    }

    public boolean addAgent(Employee agent) {
        if (agent == null) {
            return false;
        }
        return agentList.add(agent);
    }

    public List<Employee> getAllAgent() {
        return new ArrayList<>(agentList);
    }
}
