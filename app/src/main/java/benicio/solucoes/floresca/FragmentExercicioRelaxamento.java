package benicio.solucoes.floresca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentExercicioRelaxamentoBinding;

public class FragmentExercicioRelaxamento extends Fragment {
    public FragmentExercicioRelaxamento() {
    }

    public FragmentExercicioRelaxamentoBinding mainBinding;
    Fragment fragmentRelaxamento = new FragmentEscolherTempoRelaxamento();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentExercicioRelaxamentoBinding.inflate(getLayoutInflater());

        mainBinding.iniciar.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentRelaxamento).commit())
        ;

        return mainBinding.getRoot();
    }
}
