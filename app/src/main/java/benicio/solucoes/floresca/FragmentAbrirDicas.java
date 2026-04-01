package benicio.solucoes.floresca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentAbrirDicasBinding;
import benicio.solucoes.floresca.databinding.FragmentDicasBinding;

public class FragmentAbrirDicas extends Fragment {
    public FragmentAbrirDicas(){}

    FragmentAbrirDicasBinding mainBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentAbrirDicasBinding.inflate(getLayoutInflater());

        mainBinding.voltar.setOnClickListener(v -> {getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentDicas()).commit();
        });
        return mainBinding.getRoot();
    }
}
