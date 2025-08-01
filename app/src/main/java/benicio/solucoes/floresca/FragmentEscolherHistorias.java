package benicio.solucoes.floresca;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentEscolherHistorias2Binding;

public class FragmentEscolherHistorias extends Fragment {

    public FragmentEscolherHistorias(){}
    FragmentEscolherHistorias2Binding mainBinding;
    private MediaPlayer mediaPlayer;
    private int somAtual = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentEscolherHistorias2Binding.inflate(getLayoutInflater());

        mainBinding.japones.setOnClickListener(v -> tocar_som(R.raw.histjapo));
        mainBinding.arabe.setOnClickListener(v -> tocar_som(R.raw.historiaarabe));

        return mainBinding.getRoot();
    }

    void tocar_som(int som) {
        // Se já está tocando o mesmo som, para e reseta
        if (mediaPlayer != null && mediaPlayer.isPlaying() && somAtual == som) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            somAtual = -1;
            Toast.makeText(getActivity(), "Som desligado!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Se estava tocando outro som, para ele
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // Toca o novo som
        mediaPlayer = MediaPlayer.create(getActivity(), som);
        mediaPlayer.start();
        somAtual = som;
        Toast.makeText(getActivity(), "Iniciando Som...", Toast.LENGTH_SHORT).show();

        // Libera o player ao terminar
        mediaPlayer.setOnCompletionListener(mp -> {
            mediaPlayer.release();
            mediaPlayer = null;
            somAtual = -1;
        });
    }
}
