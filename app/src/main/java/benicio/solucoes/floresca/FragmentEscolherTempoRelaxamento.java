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

import benicio.solucoes.floresca.databinding.FragmentEscolherTempoRelaxamentoBinding;
import benicio.solucoes.floresca.service.WeeklyScreenTracker;

public class FragmentEscolherTempoRelaxamento extends Fragment {

    private FragmentEscolherTempoRelaxamentoBinding mainBinding;
    private MediaPlayer mediaPlayer;
    private int somAtual = -1;

    public FragmentEscolherTempoRelaxamento() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        mainBinding = FragmentEscolherTempoRelaxamentoBinding.inflate(inflater, container, false);

        mainBinding.voltar1.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentExercicioRelaxamento()).commit();
        });

        mainBinding.btnAutoconfianca.setOnClickListener(v ->
                toggleSom(R.raw.dez_aceitacao_autoconfianca));

        mainBinding.btnAutoestima.setOnClickListener(v ->
                toggleSom(R.raw.cinco_autoestima_amor));

        mainBinding.btnLivre.setOnClickListener(v ->
                toggleSom(R.raw.dez_livre_ansiedade));

        mainBinding.btnCura.setOnClickListener(v ->
                toggleSom(R.raw.cinco_cura_em_voce));

        // opcional: clicar no texto também inicia/para
        mainBinding.autoconfianca.setOnClickListener(v ->
                toggleSom(R.raw.dez_aceitacao_autoconfianca));

        mainBinding.autoestima.setOnClickListener(v ->
                toggleSom(R.raw.cinco_autoestima_amor));

        mainBinding.livre.setOnClickListener(v ->
                toggleSom(R.raw.dez_livre_ansiedade));

        mainBinding.cura.setOnClickListener(v ->
                toggleSom(R.raw.cinco_cura_em_voce));

        atualizarBotoes();

        WeeklyScreenTracker tracker = new WeeklyScreenTracker(getActivity());
        tracker.incrementScreenCount("relaxamento");

        return mainBinding.getRoot();
    }

    private void toggleSom(int som) {
        if (getActivity() == null) return;

        // se clicou no mesmo som que já está tocando, para
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

        atualizarTextoBotao(mainBinding.btnAutoconfianca, R.raw.dez_aceitacao_autoconfianca);
        atualizarTextoBotao(mainBinding.btnAutoestima, R.raw.cinco_autoestima_amor);
        atualizarTextoBotao(mainBinding.btnLivre, R.raw.dez_livre_ansiedade);
        atualizarTextoBotao(mainBinding.btnCura, R.raw.cinco_cura_em_voce);
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