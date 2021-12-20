package kommunevalg.Repo;

import kommunevalg.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
    List<Candidate> findByParty(String party);
}
