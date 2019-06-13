package eg.com.iti.githubjobs.screens.screens.home;

import java.util.List;

import eg.com.iti.githubjobs.screens.model.JobPojo;
import eg.com.iti.githubjobs.screens.network.networkConnection;

public class MainPresenterImp implements MainContract.MainPresenter
{

    MainContract.MainView mainView;
    MainContract.MainService mainService;

    public  MainPresenterImp(MainContract.MainView mainView)
    {
        this.mainView = mainView;
        mainService = new networkConnection(this);
    }
    @Override
    public void getJobs(String description, String location)
    {
        mainService.getJobs(description,location);
    }

    @Override
    public void setJobsList(List<JobPojo> jobList) {
        mainView.setJobsList(jobList);
    }
}
