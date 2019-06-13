package eg.com.iti.githubjobs.screens.network;

import java.util.List;

import eg.com.iti.githubjobs.screens.model.JobPojo;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService
{
    @GET("positions.json")
    Call<List<JobPojo>> getjobs (@Query("description") String description , @Query("location") String location);
}
