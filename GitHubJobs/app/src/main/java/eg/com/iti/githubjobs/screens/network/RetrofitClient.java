package eg.com.iti.githubjobs.screens.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static GitHubService service;

    private static Retrofit getClient(String baseUrl)
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static GitHubService getService(String baseUrl)
    {
        service= getClient(baseUrl).create(GitHubService.class);
        return service;
    }
}
