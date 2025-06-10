package benicio.solucoes.floresca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentExerciciosBinding;

public class FragmentExercicio extends Fragment {
    public FragmentExercicio() {

    }
    Fragment fragmentSons = new FragmentSons();
    Fragment fragmentHistorias = new FragmentHistoriasNarradas();
    Fragment fragmentRelaxamento = new FragmentExercicioRelaxamento();
    Fragment fragmentRespiracao = new FragmentRespiracao();
    Fragment fragmentCompreenda = new FragmentCompreenda();
    Fragment fragmentSaibaMais = new FragmentHome();
    FragmentExerciciosBinding mainbingind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainbingind = FragmentExerciciosBinding.inflate(getLayoutInflater());

        mainbingind.sons.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentSons).commit();
        });
        mainbingind.historias.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentHistorias).commit();
        });
        mainbingind.compeenda.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentCompreenda).commit();
        });
        mainbingind.relaxamento.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentRelaxamento).commit();
        });
        mainbingind.respiracao.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentRespiracao).commit();
        });

        mainbingind.saibaMais.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentSaibaMais).commit();
        });

        return mainbingind.getRoot();

    }
}
