package kommunevalg.Model;

import javax.persistence.*;

@Entity
@Table(name="Candidates")
public class Candidate {

    public Candidate(){}
    public Candidate(String name, String party, int votes) {
        this.name = name;
        this.party = party;
        this.votes = votes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="party")
    private String party;

    @Column(name="votes")
    private int votes;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", votes=" + votes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
