package benicio.solucoes.floresca;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentEscolherSonsBinding;

public class FragmentEscolherSons extends Fragment {

    public FragmentEscolherSons() {
    }

    FragmentEscolherSonsBinding mainBinding;
    private MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentEscolherSonsBinding.inflate(getLayoutInflater());

        mainBinding.somChuva.setOnClickListener(v -> tocar_som(R.raw.dez_som_chuva));
        mainBinding.somMar.setOnClickListener(v -> tocar_som(R.raw.dez_som_mar));
        mainBinding.somPassarinho.setOnClickListener(v -> tocar_som(R.raw.dez_som_passaro));
        mainBinding.somSino.setOnClickListener(v -> tocar_som(R.raw.quinze_som_sino));

        return mainBinding.getRoot();


    }

    void tocar_som(int som) {

        Toast.makeText(getActivity(), "Iniciando Som...", Toast.LENGTH_SHORT).show();

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(getActivity(), som);
        mediaPlayer.start();
    }


}
