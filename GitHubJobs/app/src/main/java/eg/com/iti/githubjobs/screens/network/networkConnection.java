package eg.com.iti.githubjobs.screens.network;

import java.util.List;

import eg.com.iti.githubjobs.screens.model.JobPojo;
import eg.com.iti.githubjobs.screens.screens.home.MainContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class networkConnection implements MainContract.MainService {

    MainContract.MainPresenter mainPresenter;
    List<JobPojo> jobsList;
    public networkConnection(MainContract.MainPresenter mainPresenter)
    {
        this.mainPresenter = mainPresenter;
    }
    @Override
    public void getJobs(String description, String location)
    {
        RetrofitClient.getService(KeyTags.GITHUB_URL).getjobs(description,location).enqueue(new Callback<List<JobPojo>>() {
            @Override
            public void onResponse(Call<List<JobPojo>> call, Response<List<JobPojo>> response) {
                jobsList = response.body();
                mainPresenter.setJobsList(jobsList);
            }

            @Override
            public void onFailure(Call<List<JobPojo>> call, Throwable t) {

            }
        });
    }
}
