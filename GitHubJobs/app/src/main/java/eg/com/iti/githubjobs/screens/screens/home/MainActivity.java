package eg.com.iti.githubjobs.screens.screens.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import eg.com.iti.githubjobs.R;
import eg.com.iti.githubjobs.screens.model.JobPojo;
import eg.com.iti.githubjobs.screens.network.GitHubService;
import eg.com.iti.githubjobs.screens.screens.home.adapter.JobsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    List<JobPojo> jobsList;
    MainContract.MainPresenter mainPresenter;
    RecyclerView recyclerView;
    EditText editText;
    JobsAdapter jobsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        jobsAdapter = new JobsAdapter(jobsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(jobsAdapter);

        mainPresenter=new MainPresenterImp(this);
        mainPresenter.getJobs("java","uk");
    }

    private void initComponents()
    {
        editText=findViewById(R.id.edtSearch);
        recyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public void setJobsList(List<JobPojo> jobList) {
        this.jobsList.addAll(jobList);
        jobsAdapter.notifyDataSetChanged();
    }
}
