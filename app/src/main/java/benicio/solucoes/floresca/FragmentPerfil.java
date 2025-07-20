package benicio.solucoes.floresca;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentPerfilBinding;
import benicio.solucoes.floresca.service.WeeklyScreenTracker;

public class FragmentPerfil extends Fragment {

    public FragmentPerfil() {
    }

    FragmentPerfilBinding mainBinding;
    SharedPreferences prefs ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        prefs = getActivity().getSharedPreferences("user_info", MODE_PRIVATE);
        mainBinding = FragmentPerfilBinding.inflate(getLayoutInflater());
//        mainBinding.name.setText(Html.fromHtml("<b>Amanda Silva</b>"));
        mainBinding.editTextTextEmailAddress2.setText(Html.fromHtml(prefs.getString("email", "")));


        WeeklyScreenTracker tracker = new WeeklyScreenTracker(getActivity());
        int sons = tracker.getScreenCount("sons");
        int relaxamento = tracker.getScreenCount("relaxamento");

        mainBinding.sons.setText("Você acessou Sons "+sons+" vezes essa semana.");
        mainBinding.relaxamento.setText("Você acessou Sons "+relaxamento+" vezes essa semana.");

        mainBinding.progresssons.setProgress(sons, true);
        mainBinding.progressrelaxamento.setProgress(relaxamento, true);

        return mainBinding.getRoot();
    }
}
