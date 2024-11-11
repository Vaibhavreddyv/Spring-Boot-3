package dev.vaibhav.SpringRunnerApp.run;

import java.time.LocalDateTime;

//public class Run {
//
//    private Integer id;
//    private String title;
//    private LocalDateTime startedon;
//    private LocalDateTime completedon;
//    private Integer miles;
////    private Location location;
//    // we are making use of record insted of this class creation
//}

public record Run(Integer id, String title, LocalDateTime startedon, LocalDateTime completedon, Integer miles, Location location) {
}