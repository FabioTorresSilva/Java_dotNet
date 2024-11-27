package pt.org.upskill.repository;

import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Organization;
import java.util.ArrayList;
import java.util.List;

public class OrganizationRepository {
    private final List<Organization> organizations;

    public OrganizationRepository() {
        organizations = new ArrayList<>();
    }

    public Organization getOrganizationByEmployee(Employee employee) {
        for (Organization organization : organizations) {
            if (organization.employs(employee)) {
                return organization;
            }
        }
        return null;
    }

    public Organization getOrganizationByEmployeeEmail(String email) {
        for (Organization organization : organizations) {
            if (organization.anyEmployeeHasEmail(email)) {
                return organization;
            }
        }
        return null;
    }

    public Organization add(Organization organization) {
        if (validateOrganization(organization)) {
            Organization newOrganization = organization.clone();
            boolean operationSuccess = organizations.add(newOrganization);

            if (operationSuccess) {
                return newOrganization;
            }
        }
        return null;
    }

    private boolean validateOrganization(Organization organization) {
        return !organizations.contains(organization);
    }
}