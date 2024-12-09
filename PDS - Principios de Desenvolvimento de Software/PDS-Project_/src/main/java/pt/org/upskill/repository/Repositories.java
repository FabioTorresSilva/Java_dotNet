package pt.org.upskill.repository;

/**
 * Inspired on https://refactoring.guru/design-patterns/singleton/java/example
 *
 * The Repositories class works as a Singleton. It defines the getInstance method that serves as an alternative
 * to the constructor and lets client classes access the same instance of this class over and over.
 */
public class Repositories {
    private static Repositories instance;
    private final StoreRepository storeRepository;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final AgentRepository agentRepository;

    /**
     * The Singleton's constructor should always be private to prevent direct construction calls with the new operator.
     */
    private Repositories() {
        storeRepository = new StoreRepository();
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        agentRepository = new AgentRepository();
    }

    /**
     * This is the static method that controls the access to the singleton instance.
     * On the first run, it creates a singleton object and places it into the static attribute.
     * On subsequent runs, it returns the existing object stored in the static attribute.
     */
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
