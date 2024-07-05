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
            // 저장
            Team team = new Team();
            team.setName("Team 1");
            em.persist(team);

            Member member = new Member();
            member.setName("member 1");
            member.setTeam(team);
            em.persist(member);

            // 조회
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());          // member의 PK값으로 member를 find
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());


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
