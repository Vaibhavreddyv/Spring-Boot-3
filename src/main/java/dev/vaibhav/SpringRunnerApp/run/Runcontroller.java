package dev.vaibhav.SpringRunnerApp.run;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class Runcontroller {

    private Runrepository runRepository;

    public Runcontroller(Runrepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findall();
    }

    @GetMapping("/{id}")
    Run findbyid(@PathVariable Integer id) {

        Optional<Run> r = runRepository.findbyid(id);
        if (r.isEmpty()) {
            throw new RunNotFoundException();
        }
        return r.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody  Run run){
        runRepository.create(run);

    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
     void update(@RequestBody Run run,@PathVariable Integer id){
        runRepository.update(run,id);
     }


    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }

}
