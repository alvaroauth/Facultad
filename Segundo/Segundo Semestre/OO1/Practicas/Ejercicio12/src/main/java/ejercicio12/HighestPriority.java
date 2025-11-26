package ejercicio12;

import java.util.List;

public class HighestPriority implements Estrategia{
    public JobDescription selectNextJob(List<JobDescription> jobs){
        return (jobs != null && !jobs.isEmpty()) ? jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                .orElse(null) : null;
    }
}
