import javax.persistence.EntityManager;

public class Principal {
    public static void main(String[] args) {
	Aluno a1 = new Aluno();
	a1.setNome("Dhionatã");
	EntityManager em = EntityManagerHelper.getEntityManager();
	em.getTransaction().begin();
	em.persist(a1);
	em.getTransaction().commit();
    }
}