package benicio.solucoes.floresca;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import benicio.solucoes.floresca.databinding.FragmentCompreendaSeBinding;

public class FragmentCompreenda extends Fragment {

    String texto1 = "A ansiedade é caracterizada por um medo exacerbado em relação ao futuro com uma preocupação exagerada que distorce o cenário real alimentando diversos pensamentos negativos, <a href='https://hospitalsantamonica.com.br/depressao-e-ansiedade-em-mulheres-fatores-de-risco/#:~:text=Entre%20os%20adultos%2C%20as%20mulheres,convivem%20com%20sintomas%20de%20ansiedade'> saiba mais </a>";
    String texto2 = "Engana-se quem pensa a depressão como preguiça/descuido.  É uma condição vivida por tempo prolongado com vivências de humor deprimido, perda de interesse e prazer, cansaço, ansiedade, irritabilidade, distúrbio do sono e baixa autoestima, com grande sofrimento para a pessoa e seus próximos. <a href='http://crp16.org.br/depressao-vamos-conversar/'>Saiba mais</a>";
    String texto3 = "Embora o estresse seja inevitável em grande parte da vida, existem algumas formas de lidar com ele quando está sendo demasiado. Algumas dicas são: Saber reconhecer os sintomas do estresse no corpo e na mente é o primeiro passo para conseguir lidar com ele. Neste sentido, é importante não ignorar sinais como músculos tensos, irritabilidade, problemas para dormir, dores de cabeça, entre outros. <a href='https://institutodepsiquiatriapr.com.br/blog/estresse-e-pressao-como-lidar/#:~:text=Reconhecer%20quando%20o%20estresse%20est%C3%A1,dores%20de%20cabe%C3%A7a%2C%20entre%20outros'>Saiba mais</a>";
    String texto4 = "Dê importância a sua vida, tenha uma melhor compreensão e consciência de suas emoções, pensamentos, valores, aprendizagem e desejos, desta forma terá um ego sólido e saudável, tendo uma melhora em sua autoestima. <a href='https://revistaft.com.br/contribuicao-da-psicologia-para-a-autoestima-das-mulheres/'> Saiba Mais</a>";
    String texto5 = "A importância da mudança de hábitosestá relacionada a adoção de uma rotina saudável para uma vida equilibrada e plena. Alimentação balanceada, prática regular de exercícios físicos, descanso adequado, gestão do estresse, abandono de vícios como o tabagismo e cultivo de boas relações interpessoais são hábitos nos quais vale a pena investir. <a href='https://vidasaudavel.einstein.br/habitos-saudaveis/'> Saiba mais<a>";

    public FragmentCompreenda() {
    }

    FragmentCompreendaSeBinding mainBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainBinding = FragmentCompreendaSeBinding.inflate(getLayoutInflater());

        mainBinding.titulo1.setOnClickListener(v -> exibirTexto(1));
        mainBinding.titulo2.setOnClickListener(v -> exibirTexto(2));
        mainBinding.titulo3.setOnClickListener(v -> exibirTexto(3));
        mainBinding.titulo4.setOnClickListener(v -> exibirTexto(4));
        mainBinding.titulo5.setOnClickListener(v -> exibirTexto(5));

        return mainBinding.getRoot();
    }

    void exibirTexto(int tipo) {
        mainBinding.texto1.setVisibility(View.GONE);
        mainBinding.texto2.setVisibility(View.GONE);
        mainBinding.texto3.setVisibility(View.GONE);
        mainBinding.texto4.setVisibility(View.GONE);
        mainBinding.texto5.setVisibility(View.GONE);

        if (tipo == 1) {
            mainBinding.texto1.setText(Html.fromHtml(texto1));
            Linkify.addLinks(mainBinding.texto1, Linkify.WEB_URLS);
            mainBinding.texto1.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto1.setVisibility(View.VISIBLE);
        }

        if (tipo == 2) {
            mainBinding.texto2.setText(Html.fromHtml(texto2));
            Linkify.addLinks(mainBinding.texto2, Linkify.WEB_URLS);
            mainBinding.texto2.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto2.setVisibility(View.VISIBLE);
        }

        if (tipo == 3) {
            mainBinding.texto3.setText(Html.fromHtml(texto3));
            Linkify.addLinks(mainBinding.texto3, Linkify.WEB_URLS);
            mainBinding.texto3.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto3.setVisibility(View.VISIBLE);
        }

        if (tipo == 4) {
            mainBinding.texto4.setText(Html.fromHtml(texto4));
            Linkify.addLinks(mainBinding.texto4, Linkify.WEB_URLS);
            mainBinding.texto4.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto4.setVisibility(View.VISIBLE);
        }

        if (tipo == 5) {
            mainBinding.texto5.setText(Html.fromHtml(texto5));
            Linkify.addLinks(mainBinding.texto5, Linkify.WEB_URLS);
            mainBinding.texto5.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto5.setVisibility(View.VISIBLE);
        }
    }
}
