package benicio.solucoes.floresca;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentJardinBinding;

public class FragmentJardin extends Fragment {
    public FragmentJardin(){}

    FragmentJardinBinding mainBinding;
    Fragment fragmentDicas = new FragmentAbrirDicas();

    SharedPreferences prefs ;
    SharedPreferences.Editor edt ;

    int cuidados;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentJardinBinding.inflate(getLayoutInflater());

        prefs = getActivity().getSharedPreferences("jardim", MODE_PRIVATE);
        edt = prefs.edit();

        cuidados = prefs.getInt("cuidados", 0);
        mainBinding.progresstext.setText("Você já cultivou "+cuidados+" de 10 momentos\nde bem-estar nesta semana");
        mainBinding.progressBar2.setProgress(cuidados, true);

        mainBinding.explorar.setOnClickListener(v -> {
            cuidados = prefs.getInt("cuidados", 0);
            cuidados += 1;
            edt.putInt("cuidados",cuidados).apply();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragmentDicas).commit();
        });

        return mainBinding.getRoot();
    }
}
