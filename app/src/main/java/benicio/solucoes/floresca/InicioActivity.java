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
import benicio.solucoes.floresca.utils.MensagemDoDiaUtil;

public class InicioActivity extends AppCompatActivity {

    ActivityInicioBinding mainBinding;
    BottomNavigationView bottomNavigationView;
    Fragment fragmentHome = new FragmentExercicio();
//    Fragment fragmentExcercicio = new FragmentExercicio();
    Fragment fragmentSons = new FragmentSons();
    Fragment fragmentProfile = new FragmentPerfil();
    Fragment fragmentDicas = new FragmentDicas();
    Fragment fragmentJardin = new FragmentJardin();




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
            } else if (item.getItemId() == R.id.nav_dicas) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentDicas).commit();
            } else if (item.getItemId() == R.id.nav_sair) {
                finish();
            } else if (item.getItemId() == R.id.nav_jardim) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentJardin).commit();
            } else if (item.getItemId() == R.id.nav_profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentProfile).commit();
            }
//            else if ( item.getItemId() == R.id.nav_dicas){
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentDicas).commit();
//            }
            return false;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        MensagemDoDiaUtil.mostrarMensagemDoDia(this);
    }
}