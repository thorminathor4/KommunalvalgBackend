package kommunevalg.RestControllers;
import kommunevalg.Repo.CandidateRepo;
import kommunevalg.Model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
@CrossOrigin("*")
public class CandidateController {
    @Autowired
    CandidateRepo candidateRepo;
    @PostMapping("/create")
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
        Candidate newCandidate = candidateRepo.save(candidate);
        System.out.println("Saved Candidate:\n"+candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCandidate);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Candidate>> readById(@PathVariable int id){
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);
        if(optionalCandidate.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(optionalCandidate);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalCandidate);
    }
    @PutMapping("/update")
    public ResponseEntity<Candidate> edit(@RequestBody Candidate candidate) {
        Candidate newCandidate = candidateRepo.save(candidate);
        return ResponseEntity.status(HttpStatus.OK).body(newCandidate);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);
        if (optionalCandidate.isPresent()){
            candidateRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
    @GetMapping("/read-all")
    public ResponseEntity<List<Candidate>> readAll(){
        List<Candidate> candidates = new ArrayList<>();
        candidateRepo.findAll().forEach(candidates::add);
        System.out.println("Loaded Candidates:");
        candidates.forEach(c->System.out.println(c));
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }
    @GetMapping("/read-by-party/{party}")
    public ResponseEntity<List<Candidate>> readByParty(@PathVariable String party){
        List<Candidate> attractions = new ArrayList<>();
        candidateRepo.findByParty(party).forEach(attractions::add);
        return ResponseEntity.status(HttpStatus.OK).body(attractions);
    }
}