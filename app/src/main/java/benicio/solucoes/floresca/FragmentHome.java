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

import benicio.solucoes.floresca.databinding.FragmentHomeBinding;

public class FragmentHome extends Fragment {

    String texto1 = "Secretaria de cultura em Niterói - https://www.culturaniteroi.com.br/Secretaria Municipal de esporte e Lazer de Niterói-  http://esporte.niteroi.rj.gov.br/";
    String texto2 = "Agenda cultural de eventos da prefeitura de Niterói.\n" +
            "Informações: https://www.culturaniteroi.com.br/\n" +
            "\n" +
            "\n" +
            "SEPE - Sindicato Estadual dos profissionais da educação do estado do Rio de Janeiro\n" +
            "Aulas de dança e teatro\n" +
            "Informações:  https://www.instagram.com/sepeniteroi/\n" +
            "      \n" +
            "Centro de artes e esportes Jurujuba- Prefeitura de Niterói\n" +
            "Projeto Social totalmente gratuito com Ações Esportivas, Educacionais e Culturais. \n" +
            "Projeto social gratuito com Ações esportivas, educacionais e culturais.\n" +
            "Informações: https://www.instagram.com/ceujurujuba/?hl=pt\n" +
            "\n" +
            "Práticas integrativas de saúde gratuitas oferecidas pelo Sistema Único de Saúde (SUS)- Policlínicas\n" +
            "Informações: https://saude.niteroi.rj.gov.br/policlinicas/\n" +
            "\n" +
            "\n" +
            "\n" +
            "Agenda de eventos e atividades de esporte e lazer gratuitos abertos ao público: academia natural, capoeira inclusiva, yoga, campeonatos, passeios, entre outros.\n" +
            "Espaço de divulgação de atividades esportivas para a promoção da  saúde e do bem-estar realizadas pela Secretaria de esporte e lazer de Niterói.\n" +
            "Informações: https://www.instagram.com/esporteelazerniteroi/\n";
    String texto3 = "Práticas integrativas e complementares em saúde\n" +
            "Divulgação de informações de evidências científicas sobre práticas integrativas complementares em saúde.\n" +
            "Faculdade de Farmácia da UFF\n" +
            "Informações: https://www.instagram.com/uffpics/\n";
    String texto4 = "Serviço de Psicologia Aplicada da UFF\n" +
            "Informações podem ser solicitadas ao SPA pelo e-mail: spa.ips@id.uff.br\n" +
            "\n" +
            "AASM - Ambulatórios Ampliados de Saúde Mental\n" +
            "Atendimento para pessoas com quadros moderados de sofrimento psíquico.\n" +
            "Locais: Policlínicas regionais de Niterói\n" +
            "Informações: https://saude.niteroi.rj.gov.br/policlinicas/\n" +
            "\n" +
            "CODIM  -coordenadoria de Políticas e Direitos Humanos das Mulheres\n" +
            "Atendimento psicológico para o fortalecimento da autoestima de mulheres, bem como rompimento das situações de violência.\n" +
            "Informações: (21)96992-6557- http://codim.niteroi.rj.gov.br/\n";
    String texto5 = "Menos dor + saúde\n" +
            "Grupo terapêutico para manejo da dor\n" +
            "Tratamento com acupuntura\n" +
            "Local: Unidade de saúde  - Clínica da família - Fonseca/Niterói/RJ\n" +
            "\n" +
            "\n" +
            "2. Projeto saúde para todos\n" +
            "    Treino funcional gratuito.\n" +
            "    Local: Bairros Ingá e Bumba\n" +
            "   Informações: https://www.instagram.com/projeto_saudetodos/\n" +
            "\n" +
            "\n" +
            "DANÇA na UFF\n" +
            "Movimento espontâneo, gratuito de aulas de dança aberto ao público.\n" +
            "Não é necessário inscrição.\n" +
            "Informações: https://www.instagram.com/danca.uff/\n" +
            "\n" +
            "YOGA NA UFF\n" +
            "Estratégia para a promoção da saúde mental, destinado a qualquer membro da comunidade.\n" +
            "Informações: https://www.instagram.com/yoganauff/?hl=pt\n" +
            "\n" +
            "Mulheres que caminham\n" +
            "Movimento feminino gratuito para proporcionar esporte, saúde e beleza para as mulheres de Niterói.\n" +
            "Informações: @https://www.instagram.com/mulheres_quecaminham/\n" +
            "\n";


    public FragmentHome() {
    }

    FragmentHomeBinding mainBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mainBinding = FragmentHomeBinding.inflate(getLayoutInflater());

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
            mainBinding.texto1.setText(Html.fromHtml(texto1.replace("\n", "<br>")));
            Linkify.addLinks(mainBinding.texto1, Linkify.WEB_URLS);
            mainBinding.texto1.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto1.setVisibility(View.VISIBLE);
        }

        if (tipo == 2) {
            mainBinding.texto2.setText(Html.fromHtml(texto2.replace("\n", "<br>")));
            Linkify.addLinks(mainBinding.texto2, Linkify.WEB_URLS);
            mainBinding.texto2.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto2.setVisibility(View.VISIBLE);
        }

        if (tipo == 3) {
            mainBinding.texto3.setText(Html.fromHtml(texto3.replace("\n", "<br>")));
            Linkify.addLinks(mainBinding.texto3, Linkify.WEB_URLS);
            mainBinding.texto3.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto3.setVisibility(View.VISIBLE);
        }

        if (tipo == 4) {
            mainBinding.texto4.setText(Html.fromHtml(texto4.replace("\n", "<br>")));
            Linkify.addLinks(mainBinding.texto4, Linkify.WEB_URLS);
            mainBinding.texto4.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto4.setVisibility(View.VISIBLE);
        }

        if (tipo == 5) {
            mainBinding.texto5.setText(Html.fromHtml(texto5.replace("\n", "<br>")));
            Linkify.addLinks(mainBinding.texto5, Linkify.WEB_URLS);
            mainBinding.texto5.setMovementMethod(LinkMovementMethod.getInstance());
            mainBinding.texto5.setVisibility(View.VISIBLE);
        }
    }
}
