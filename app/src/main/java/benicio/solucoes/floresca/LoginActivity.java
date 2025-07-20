package benicio.solucoes.floresca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

import benicio.solucoes.floresca.databinding.ActivityIndexBinding;
import benicio.solucoes.floresca.databinding.ActivityLoginBinding;
import benicio.solucoes.floresca.service.ApiResponse;
import benicio.solucoes.floresca.service.RetrofitClient;
import benicio.solucoes.floresca.service.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private UserApi userApi;
    ActivityLoginBinding mainBinding;
    SharedPreferences prefs ;
    SharedPreferences.Editor edt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        prefs = getSharedPreferences("user_info", MODE_PRIVATE);
        edt = prefs.edit();

        userApi =  RetrofitClient.getClient().create(UserApi.class);
        mainBinding.entrar.setOnClickListener(v -> {

            String email, senha;

            email = mainBinding.editTextTextEmailAddress.getText().toString();
            senha = mainBinding.editTextTextPassword.getText().toString();

            if ( email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Preencha todas as informações", Toast.LENGTH_SHORT).show();
            }else{
                // Exemplo de login
                HashMap<String, String> loginData = new HashMap<>();
                loginData.put("email", email);
                loginData.put("senha", senha);

                userApi.login(loginData).enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().success) {
                            Toast.makeText(LoginActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                            edt.putString("email", email).apply();
                            finish();
                            startActivity(new Intent(LoginActivity.this, InicioActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Login falhou", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Erro de conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        mainBinding.cadastro.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));
    }
}