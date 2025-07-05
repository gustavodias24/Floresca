package benicio.solucoes.floresca;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentPerfilBinding;

public class FragmentPerfil extends Fragment {

    public FragmentPerfil() {
    }

    FragmentPerfilBinding mainBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentPerfilBinding.inflate(getLayoutInflater());
        mainBinding.name.setText(Html.fromHtml("<b>Amanda Silva</b>"));
        return mainBinding.getRoot();
    }
}
