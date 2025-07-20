package benicio.solucoes.floresca.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Calendar;

public class WeeklyScreenTracker {

    private static final String PREF_NAME = "screen_tracker";
    private SharedPreferences prefs;

    public WeeklyScreenTracker(Context context) {
        this.prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Retorna o número da semana do ano atual (ex: 30 para a 30ª semana)
    private int getCurrentWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public void incrementScreenCount(String screenName) {
        int currentWeek = getCurrentWeek();
        int savedWeek = prefs.getInt("week", -1);

        // Se mudou a semana, zera todos os contadores e salva nova semana
        if (savedWeek != currentWeek) {
            prefs.edit().clear().apply();
            prefs.edit().putInt("week", currentWeek).apply();
        }

        String key = screenName + "_count";
        int count = prefs.getInt(key, 0);
        prefs.edit().putInt(key, count + 1).apply();
    }

    public int getScreenCount(String screenName) {
        int currentWeek = getCurrentWeek();
        int savedWeek = prefs.getInt("week", -1);
        if (savedWeek != currentWeek) return 0;
        return prefs.getInt(screenName + "_count", 0);
    }
}
