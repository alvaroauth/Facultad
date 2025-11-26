package ejercicio12;

import java.util.List;

public class LIFO implements Estrategia{
    public JobDescription selectNextJob(List<JobDescription> jobs){
        return (jobs != null && !jobs.isEmpty()) ? jobs.get(jobs.size()-1) : null;
    }
}
