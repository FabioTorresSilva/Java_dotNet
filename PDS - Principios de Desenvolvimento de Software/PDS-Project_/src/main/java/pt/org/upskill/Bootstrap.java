package pt.org.upskill;

import pt.org.upskill.controller.AuthenticationController;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Organization;
import pt.org.upskill.domain.Store;
import pt.org.upskill.domain.TaskCategory;
import pt.org.upskill.repository.AuthenticationRepository;
import pt.org.upskill.repository.OrganizationRepository;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.StoreRepository;
import pt.org.upskill.repository.TaskCategoryRepository;

public class Bootstrap implements Runnable {

    @Override
    public void run() {
        addTaskCategories();
        addOrganization();
        addStores();
        addUsers();
    }

    private void addOrganization() {
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();

        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();

        taskCategoryRepository.add(new TaskCategory("Requirements"));
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }

    private void addStores() {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();

        Store store1 = new Store("12","123", "Store001", "Downtown Store");
        Store store2 = new Store("132","1323", "Store0031", "Downtown S3tore");

        storeRepository.addStore(store1);
        storeRepository.addStore(store2);

        System.out.println("Stores added: ");
        System.out.println(store1);
        System.out.println(store2);
    }

    private void addUsers() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd", AuthenticationController.ROLE_EMPLOYEE);
    }
}
