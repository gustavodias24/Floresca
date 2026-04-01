package benicio.solucoes.floresca;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentEscolherHistorias2Binding;

public class FragmentEscolherHistorias extends Fragment {

    private FragmentEscolherHistorias2Binding mainBinding;
    private MediaPlayer mediaPlayer;
    private int somAtual = -1;

    public FragmentEscolherHistorias() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentEscolherHistorias2Binding.inflate(inflater, container, false);

        mainBinding.voltar.setOnClickListener(v -> {getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentExercicio()).commit();
        });

        mainBinding.btnJapones.setOnClickListener(v ->
                toggleSom(R.raw.histjapo));

        mainBinding.btnArabe.setOnClickListener(v ->
                toggleSom(R.raw.historiaarabe));

        // opcional: clicar no texto também inicia/para
        mainBinding.japones.setOnClickListener(v ->
                toggleSom(R.raw.histjapo));

        mainBinding.arabe.setOnClickListener(v ->
                toggleSom(R.raw.historiaarabe));

        atualizarBotoes();

        return mainBinding.getRoot();
    }

    private void toggleSom(int som) {
        if (getActivity() == null) return;

        // Se clicou no mesmo áudio que já está tocando, para
        if (mediaPlayer != null && somAtual == som) {
            pararSomAtual();
            Toast.makeText(getActivity(), "Áudio parado!", Toast.LENGTH_SHORT).show();
            return;
        }

        tocarSom(som);
    }

    private void tocarSom(int som) {
        pararSomAtualSemToast();

        mediaPlayer = MediaPlayer.create(getActivity(), som);

        if (mediaPlayer == null) {
            somAtual = -1;
            atualizarBotoes();
            Toast.makeText(getActivity(), "Não foi possível iniciar o áudio.", Toast.LENGTH_SHORT).show();
            return;
        }

        somAtual = som;
        mediaPlayer.start();
        atualizarBotoes();

        Toast.makeText(getActivity(), "Iniciando áudio...", Toast.LENGTH_SHORT).show();

        mediaPlayer.setOnCompletionListener(mp -> {
            pararSomAtualSemToast();
            if (getActivity() != null) {
                Toast.makeText(getActivity(), "Áudio finalizado.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pararSomAtual() {
        pararSomAtualSemToast();
    }

    private void pararSomAtualSemToast() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            } catch (Exception ignored) {
            }

            mediaPlayer.release();
            mediaPlayer = null;
        }

        somAtual = -1;
        atualizarBotoes();
    }

    private void atualizarBotoes() {
        if (mainBinding == null) return;

        atualizarTextoBotao(mainBinding.btnJapones, R.raw.histjapo);
        atualizarTextoBotao(mainBinding.btnArabe, R.raw.historiaarabe);
    }

    private void atualizarTextoBotao(Button button, int som) {
        if (somAtual == som && mediaPlayer != null) {
            button.setText("PARAR ÁUDIO");
        } else {
            button.setText("COMEÇAR ÁUDIO");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        pararSomAtualSemToast();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        pararSomAtualSemToast();
        mainBinding = null;
    }
}