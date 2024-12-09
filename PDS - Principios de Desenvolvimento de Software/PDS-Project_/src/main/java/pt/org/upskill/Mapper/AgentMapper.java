package pt.org.upskill.Mapper;

import pt.org.upskill.DTO.AgentDTO;
import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class AgentMapper {

    public static AgentDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new AgentDTO(employee.getEmail(),employee.getName(), employee.getPosition(),employee.getPhone());
    }

    public static List<AgentDTO> AgentMapper(List<Employee> agents) {
        List<AgentDTO> agentDtos = new ArrayList<AgentDTO>();
        for (Employee a : agents) {
            agentDtos.add(new AgentDTO(a.getEmail(), a.getName(), a.getPosition(), a.getPhone()));
        }
        return agentDtos;
    }
}
