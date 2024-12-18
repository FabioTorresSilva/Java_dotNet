package pt.org.upskill.repository;

public class Repositories {
    private static Repositories instance;
    private final StoreRepository storeRepository;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final AgentRepository agentRepository;


    private Repositories() {
        storeRepository = new StoreRepository();
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        agentRepository = new AgentRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                if (instance == null) { // Double-checked locking
                    instance = new Repositories();
                }
            }
        }
        return instance;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }
    public AgentRepository getAgentRepository() {
        return agentRepository;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }
}
