package ejercicio12;

import java.util.List;

public class FIFO implements  Estrategia{
    public JobDescription selectNextJob(List<JobDescription> jobs){
        return (jobs != null && !jobs.isEmpty()) ? jobs.get(0) : null;
    }
}
