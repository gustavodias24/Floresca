package benicio.solucoes.floresca;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

import benicio.solucoes.floresca.databinding.ActivityCadastroBinding;
import benicio.solucoes.floresca.databinding.ActivityLoginBinding;
import benicio.solucoes.floresca.service.ApiResponse;
import benicio.solucoes.floresca.service.RetrofitClient;
import benicio.solucoes.floresca.service.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private UserApi userApi;

    ActivityCadastroBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        mainBinding.entrar.setOnClickListener(v -> finish());

        userApi = RetrofitClient.getClient().create(UserApi.class);

        mainBinding.entrar.setOnClickListener( v -> {
            String email, senha, senha2;
            email = mainBinding.editTextTextEmailAddress.getText().toString();
            senha = mainBinding.editTextTextPassword.getText().toString();
            senha2 = mainBinding.editTextTextPasswordConfirm.getText().toString();


            if (email.isEmpty() || senha.isEmpty() || senha2.isEmpty()){
                Toast.makeText(this, "Preencha todas as informações", Toast.LENGTH_SHORT).show();
            }else{
                if ( senha.equals(senha2)){
                    // Exemplo de cadastro
                    HashMap<String, String> cadastroData = new HashMap<>();
                    cadastroData.put("email", email);
                    cadastroData.put("senha", senha);

                    userApi.cadastro(cadastroData).enqueue(new Callback<ApiResponse>() {
                        @Override
                        public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                            if (response.isSuccessful() && response.body() != null && response.body().success) {
                                Toast.makeText(CadastroActivity.this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(CadastroActivity.this, "Erro no cadastro", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ApiResponse> call, Throwable t) {
                            Toast.makeText(CadastroActivity.this, "Erro de conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(this, "Senhas não são iguais!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}