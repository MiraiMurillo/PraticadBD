import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> threadLocal;
    static {
	emf = Persistence.createEntityManagerFactory("banco-dados");
	threadLocal = new ThreadLocal<EntityManager>();
    }

    public static EntityManager getEntityManager() {
	EntityManager em = threadLocal.get();
	if (em == null) {
	    em = emf.createEntityManager();
	    threadLocal.set(em);
	}
	return em;
    }
}