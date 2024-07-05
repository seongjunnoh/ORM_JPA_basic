package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity         // jpa를 사용하는 entity임을 표시
@Table(name = "Member")         // 매핑할 테이블 이름 지정 가능
public class Member {

    @Id         // pk임을 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @Column(name = "TEAM_ID")
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
