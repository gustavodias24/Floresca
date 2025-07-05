package benicio.solucoes.floresca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragementSonsBinding;

public class FragmentSons extends Fragment {

    public FragmentSons() {

    }

    FragementSonsBinding mainBinding;
    Fragment fragmentSons = new FragmentEscolherSons();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragementSonsBinding.inflate(getLayoutInflater());

        mainBinding.iniciar.setOnClickListener(v ->
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragmentSons).commit());

        return mainBinding.getRoot();
    }
}
