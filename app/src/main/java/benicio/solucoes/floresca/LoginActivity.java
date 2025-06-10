package benicio.solucoes.floresca;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import benicio.solucoes.floresca.databinding.ActivityIndexBinding;
import benicio.solucoes.floresca.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        mainBinding.entrar.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, InicioActivity.class));
        });
        mainBinding.cadastro.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));
    }
}