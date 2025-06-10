package benicio.solucoes.floresca;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import benicio.solucoes.floresca.databinding.ActivityInicioBinding;
import benicio.solucoes.floresca.databinding.ActivityLoginBinding;

public class InicioActivity extends AppCompatActivity {

    ActivityInicioBinding mainBinding;

    BottomNavigationView bottomNavigationView;

    Fragment fragmentHome = new FragmentHome();
    Fragment fragmentExcercicio = new FragmentExercicio();
    Fragment fragmentSons = new FragmentSons();
    Fragment fragmentProfile = new FragmentPerfil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityInicioBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        bottomNavigationView = mainBinding.bottomNavigation;

        //Definir fragmento inicial
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentHome).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentHome).commit();
            } else if (item.getItemId() == R.id.nav_exercicio) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentExcercicio).commit();
            } else if (item.getItemId() == R.id.nav_sair) {
                finish();
            } else if (item.getItemId() == R.id.nav_sons) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentSons).commit();
            } else if (item.getItemId() == R.id.nav_profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentProfile).commit();
            }
            return false;
        });
    }
}