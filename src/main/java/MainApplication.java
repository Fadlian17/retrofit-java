import com.google.gson.Gson;
import repository.clients.APIClient;
import repository.clients.GitHubClient;
import repository.clients.TodoClient;
import repository.models.RepoModel;
import repository.models.TodoModel;
import repository.services.TodoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
//        GitHubClient.gitHubService().getRepos("Fadlian17")
//                .enqueue(new Callback<>() {
//                    @Override
//                    public void onResponse(Call<List<RepoModel>> call,
//                                           Response<List<RepoModel>> response) {
//                        if (response.code() >= 200 & response.code() <= 299) {
//                            System.out.println(new Gson().toJson(response.body()));
//                        } else {
//                            System.out.println("Maaf response gagal dengan kode " +
//                                    response.code());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<RepoModel>> call, Throwable t) {
//                        System.out.println(t.getMessage());
//                    }
//                });
//
//        TodoClient.todoService().getTodos().enqueue(new Callback<>() {
//            @Override
//            public void onResponse(Call<List<TodoModel>> call,
//                                   Response<List<TodoModel>> response) {
//                if (response.code() >= 200 & response.code() <= 299) {
//                    System.out.println(new Gson().toJson(response.body()));
//                } else {
//                    System.out.println("Maaf response gagal dengan kode " +
//                            response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<TodoModel>> call, Throwable t) {
//                System.out.println(t.getMessage());
//            }
//        });

        APIClient.client(
                TodoService.class,
                "https://jsonplaceholder.typicode.com/")
                .getTodo(10)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<TodoModel> call,
                                           Response<TodoModel> response) {
                        if (response.code() >= 200 & response.code() <= 299) {
                            System.out.println(new Gson().toJson(response.body()));
                        } else {
                            System.out.println("Maaf response gagal dengan kode " +
                                    response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<TodoModel> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
    }
}
