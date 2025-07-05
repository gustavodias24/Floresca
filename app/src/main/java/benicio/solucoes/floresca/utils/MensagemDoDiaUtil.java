package benicio.solucoes.floresca.utils;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MensagemDoDiaUtil {
    private static final String PREFS = "mensagem_do_dia_prefs";
    private static final String PREF_DATE = "mensagem_data";

    private static final String[] MENSAGENS = {
            "🌼 Você não precisa dar conta de tudo, só cuidar de si mesma com carinho.",
            "✨ Seu esforço transforma vidas — inclusive a sua.",
            "🌷 Permita-se pausar. Descansar também é revolucionário.",
            "💪 Você é forte, mas também merece acolhimento.",
            "💖 A sua saúde mental importa. E muito.",
            "🌞 Todo dia é uma nova chance de se colocar em primeiro lugar.",
            "🌿 Cuidar de si não é egoísmo. É resistência.",
            "📚 Você ensina com amor. Aprenda também a se amar.",
            "💫 Entre uma aula e outra, lembre-se: você também precisa de cuidado.",
            "🍃 Respire fundo. Você está fazendo o seu melhor.",
            "💜 Seu bem-estar é tão importante quanto o aprendizado de seus alunos.",
            "🌺 Você não está sozinha. Outras mulheres também resistem com você.",
            "🔆 Reconheça seu valor além das tarefas e responsabilidades.",
            "🧘 Cinco minutos de autocuidado podem mudar o seu dia.",
            "🌸 Ser forte é também saber quando pedir ajuda.",
            "💭 Seu corpo e sua mente merecem descanso sem culpa.",
            "🌻 A leveza que você deseja começa com um pequeno gesto de cuidado.",
            "🌈 Você pode se reinventar, mesmo em dias difíceis.",
            "🌺 Olhe-se com gentileza: há beleza em sua trajetória.",
            "🌺 A professora que cuida de si inspira ainda mais."
    };

    public static void mostrarMensagemDoDia(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String dataHoje = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        String ultimaData = prefs.getString(PREF_DATE, "");

        if (!dataHoje.equals(ultimaData)) {
            // Sorteia a mensagem
            String mensagem = MENSAGENS[new Random().nextInt(MENSAGENS.length)];

            // Cria layout customizado para caixa arredondada
            View dialogView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
            TextView txt = dialogView.findViewById(android.R.id.text1);
            txt.setText(mensagem);
            txt.setPadding(50, 60, 50, 60);
            txt.setTextSize(18);

            // Caixa com fundo arredondado
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(0xFFFFFFFF); // branco
            drawable.setCornerRadius(45);  // raio arredondado
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                dialogView.setBackground(drawable);
            } else {
                dialogView.setBackgroundDrawable(drawable);
            }

            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle("mensagem do dia")
                    .setView(dialogView)
                    .setPositiveButton("obrigada", (d, which) -> d.dismiss())
                    .create();

            dialog.show();

            // Personaliza botão
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            if (positiveButton != null) {
                positiveButton.setAllCaps(false);
            }

            // Salva data do último alerta
            prefs.edit().putString(PREF_DATE, dataHoje).apply();
        }
    }
}
