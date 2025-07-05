package benicio.solucoes.floresca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentDicasBinding;

public class FragmentDicas extends Fragment {
    public FragmentDicas() {
    }

    Fragment fragmentAbrirDicas = new FragmentAbrirDicas();

    FragmentDicasBinding mainBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentDicasBinding.inflate(getLayoutInflater());

        mainBinding.dicas
                .setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentAbrirDicas).commit());
        return mainBinding.getRoot();
    }
}
