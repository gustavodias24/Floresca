package benicio.solucoes.floresca;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentJardinBinding.inflate(getLayoutInflater());

        mainBinding.explorar.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragmentDicas).commit());

        return mainBinding.getRoot();
    }
}
