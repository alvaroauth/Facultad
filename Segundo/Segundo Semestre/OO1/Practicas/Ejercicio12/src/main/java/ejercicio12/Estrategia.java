package ejercicio12;

import java.util.List;

public interface Estrategia {
    public JobDescription selectNextJob(List<JobDescription> jobs);
}
