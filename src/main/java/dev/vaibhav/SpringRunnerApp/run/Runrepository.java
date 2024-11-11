package dev.vaibhav.SpringRunnerApp.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class Runrepository {

    ArrayList<Run> Runlist = new ArrayList<>();

    List<Run> findall(){
        return Runlist;
    }

//    Run findbyid(Integer id){
//        return Runlist.stream().filter(run ->run.id()==id).findFirst().get();
//
//    }

       Optional<Run> findbyid(Integer id){
        return Runlist.stream().filter(run ->run.id()==id).findFirst();

    }


    void create(Run run){
        Runlist.add(run);
    }

    void update(Run run , Integer id){
        Optional<Run> existingRun = findbyid(id);
        if(existingRun.isPresent()){
            Runlist.set(Runlist.indexOf(existingRun.get()),run);
        }
    }
    void delete(Integer id){
        Runlist.removeIf(run -> run.id().equals(id));

    }



        @PostConstruct
        private void init(){
        Runlist.add(new Run(1,"Monday morning run", LocalDateTime.now(),LocalDateTime.now().plusHours(5),3,Location.OUTDOOR));
        Runlist.add(new Run(2,"Monday Evening run",LocalDateTime.now().plusHours(12),LocalDateTime.now().plusHours(3),5,Location.INDOOR));


        }


}
