package benicio.solucoes.floresca.service;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/cadastro")
    Call<ApiResponse> cadastro(@Body HashMap<String, String> body);

    @POST("/login")
    Call<ApiResponse> login(@Body HashMap<String, String> body);
}
