package benicio.solucoes.floresca;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentEscolherSonsBinding;
import benicio.solucoes.floresca.service.WeeklyScreenTracker;

public class FragmentEscolherSons extends Fragment {

    private FragmentEscolherSonsBinding mainBinding;
    private MediaPlayer mediaPlayer;
    private int somAtual = -1;

    public FragmentEscolherSons() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentEscolherSonsBinding.inflate(inflater, container, false);

        mainBinding.voltar.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_container, new FragmentSons())
                        .commit();
            }
        });

        mainBinding.btnSomChuva.setOnClickListener(v -> toggleSom(R.raw.dez_som_chuva));
        mainBinding.btnSomMar.setOnClickListener(v -> toggleSom(R.raw.dez_som_mar));
        mainBinding.btnSomPassarinho.setOnClickListener(v -> toggleSom(R.raw.dez_som_passaro));
        mainBinding.btnSomSino.setOnClickListener(v -> toggleSom(R.raw.quinze_som_sino));

        // opcional: clicar na imagem também toca/pausa
        mainBinding.somChuva.setOnClickListener(v -> toggleSom(R.raw.dez_som_chuva));
        mainBinding.somMar.setOnClickListener(v -> toggleSom(R.raw.dez_som_mar));
        mainBinding.somPassarinho.setOnClickListener(v -> toggleSom(R.raw.dez_som_passaro));
        mainBinding.somSino.setOnClickListener(v -> toggleSom(R.raw.quinze_som_sino));

        atualizarBotoes();

        WeeklyScreenTracker tracker = new WeeklyScreenTracker(getActivity());
        tracker.incrementScreenCount("sons");

        return mainBinding.getRoot();
    }

    private void toggleSom(int som) {
        if (getActivity() == null) return;

        // Se clicou no mesmo som que já está tocando, pausa/para
        if (mediaPlayer != null && somAtual == som) {
            pararSomAtualSemToast();
            Toast.makeText(getActivity(), "Áudio pausado!", Toast.LENGTH_SHORT).show();
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
        atualizarBotoes();

        try {
            mediaPlayer.start();
            Toast.makeText(getActivity(), "Iniciando áudio...", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            somAtual = -1;
            atualizarBotoes();
            Toast.makeText(getActivity(), "Erro ao reproduzir o áudio.", Toast.LENGTH_SHORT).show();

            try {
                mediaPlayer.release();
            } catch (Exception ignored) {
            }
            mediaPlayer = null;
            return;
        }

        mediaPlayer.setOnCompletionListener(mp -> {
            pararSomAtualSemToast();
            if (getActivity() != null) {
                Toast.makeText(getActivity(), "Áudio finalizado.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pararSomAtualSemToast() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            } catch (Exception ignored) {
            }

            try {
                mediaPlayer.release();
            } catch (Exception ignored) {
            }

            mediaPlayer = null;
        }

        somAtual = -1;
        atualizarBotoes();
    }

    private void atualizarBotoes() {
        if (mainBinding == null) return;

        atualizarIconeBotao(mainBinding.btnSomMar, R.raw.dez_som_mar);
        atualizarIconeBotao(mainBinding.btnSomPassarinho, R.raw.dez_som_passaro);
        atualizarIconeBotao(mainBinding.btnSomChuva, R.raw.dez_som_chuva);
        atualizarIconeBotao(mainBinding.btnSomSino, R.raw.quinze_som_sino);
    }

    private void atualizarIconeBotao(ImageButton button, int som) {
        if (button == null) return;

        if (somAtual == som && mediaPlayer != null) {
            button.setImageResource(R.drawable.pausa);
        } else {
            button.setImageResource(R.drawable.play);
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