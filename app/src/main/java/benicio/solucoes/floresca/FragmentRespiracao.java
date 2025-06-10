package benicio.solucoes.floresca;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentExercicioRespiracaoBinding;
import benicio.solucoes.floresca.databinding.FragmentPerfilBinding;

public class FragmentRespiracao extends Fragment {
    public FragmentRespiracao(){}

    FragmentExercicioRespiracaoBinding mainBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentExercicioRespiracaoBinding.inflate(getLayoutInflater());
        return mainBinding.getRoot();
    }
}
