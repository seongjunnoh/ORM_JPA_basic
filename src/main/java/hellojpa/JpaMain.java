package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");         // persistence.xml에 작성한 persistenceUnitName
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // code
        try {
            Team team = new Team();
            team.setName("Team 1");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            transaction.commit();           // transaction을 commit해야 영속 컨텍스트에 있는게 db에 반영되는 것임
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
