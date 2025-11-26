package ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected Estrategia strategy;

    public JobScheduler (Estrategia st) {
        this.jobs = new ArrayList<>();
        this.strategy = st;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Estrategia getStrategy() {
        return this.strategy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setStrategy(Estrategia aStrategy) {
        this.strategy = aStrategy;
    }

    public JobDescription next() {
        JobDescription j = strategy.selectNextJob(jobs);
        this.unschedule(j);
        return j;
    }

}
