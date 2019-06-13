package eg.com.iti.githubjobs.screens.screens.home;

import java.util.List;

import eg.com.iti.githubjobs.screens.model.JobPojo;

public interface MainContract {

    interface MainView
    {
        void setJobsList(List<JobPojo> jobList);
    }

    interface MainPresenter
    {
        void getJobs(String description, String location);
        void setJobsList(List<JobPojo> jobList);
    }
    interface MainService
    {
        void getJobs(String description, String location);
    }

}
