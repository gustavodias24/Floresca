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

import benicio.solucoes.floresca.databinding.FragmentEscolherTempoRelaxamentoBinding;

public class FragmentEscolherTempoRelaxamento extends Fragment {

    public FragmentEscolherTempoRelaxamento(){}

    FragmentEscolherTempoRelaxamentoBinding mainBinding;
    private MediaPlayer mediaPlayer;
    private int somAtual = -1; // Guarda o id do som que está tocando

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentEscolherTempoRelaxamentoBinding.inflate(getLayoutInflater());

        mainBinding.autoconfianca.setOnClickListener(v -> tocar_som(R.raw.dez_aceitacao_autoconfianca));
        mainBinding.autoestima.setOnClickListener(v -> tocar_som(R.raw.cinco_autoestima_amor));
        mainBinding.livre.setOnClickListener(v -> tocar_som(R.raw.dez_livre_ansiedade));
        mainBinding.cura.setOnClickListener(v -> tocar_som(R.raw.cinco_cura_em_voce));

        return mainBinding.getRoot();
    }

    void tocar_som(int som) {
        // Se já está tocando o mesmo som, para ele e reseta
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

        // Libera o MediaPlayer quando o som termina (boa prática)
        mediaPlayer.setOnCompletionListener(mp -> {
            mediaPlayer.release();
            mediaPlayer = null;
            somAtual = -1;
        });
    }
}
