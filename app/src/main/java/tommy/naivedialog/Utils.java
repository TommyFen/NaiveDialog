package tommy.naivedialog;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils {

    public static float dp2px(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
