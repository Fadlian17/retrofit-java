package repository.clients;

import com.google.gson.GsonBuilder;
import repository.services.GitHubService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {
    public static GitHubService gitHubService() {
        var retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder().setLenient().create()
                        )
                )
                .build();

        return retrofit.create(GitHubService.class);
    }
}
