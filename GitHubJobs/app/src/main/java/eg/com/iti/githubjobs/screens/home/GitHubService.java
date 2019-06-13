package eg.com.iti.githubjobs.screens.home;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("/positions.json")
    Call<Response> getjobs(@Query("description") String description ,@Query("location") String location);
}
