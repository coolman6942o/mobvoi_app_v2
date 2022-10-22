package nj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.mcuwatch.engine.n;
import gn.p;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: McuModelUtils.java */
/* loaded from: classes2.dex */
public class j {
    @SuppressLint({"DefaultLocale"})
    public static String a(double d10, int i10) {
        return d10 > 0.0d ? a.isUnitMetric(b.e()) ? String.format("%.1f", Double.valueOf((d10 / i10) * 3.5999999046325684d)) : String.format("%.1f", Double.valueOf((d10 / i10) * 2.25d)) : "0";
    }

    public static int b(double d10, int i10) {
        if (d10 <= 0.0d) {
            return 0;
        }
        return (int) ((a.isUnitMetric(b.e()) ? 1000.0d : 1600.0d) / (d10 / i10));
    }

    public static int c(Context context) {
        return j7.a.f(j7.a.b(context, 16842801, -1)) ? 16974394 : 16974374;
    }

    public static boolean d(int i10) {
        return p.d(b.e(), i10);
    }

    public static void e() {
        String s10 = n.f19178a.s();
        boolean z10 = false;
        if (!TextUtils.isEmpty(s10) && s10.length() >= 4) {
            try {
                if (Integer.parseInt(s10.substring(s10.length() - 4)) > 1027) {
                    z10 = true;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        ad.a.f168a.q(z10);
    }

    @SuppressLint({"DefaultLocale"})
    public static String f(double d10) {
        return a.isUnitMetric(b.e()) ? String.format("%.2f", Double.valueOf((d10 * 1.0d) / 1000.0d)) : String.format("%.2f", Double.valueOf((d10 * 1.0d) / 1600.0d));
    }

    public static String g(double d10) {
        return String.valueOf((int) d10);
    }

    @SuppressLint({"DefaultLocale"})
    public static String h(float f10) {
        return f10 > 10.0f ? String.valueOf((int) f10) : String.format("%.1f", Float.valueOf(f10));
    }

    public static String i(int i10) {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Long.valueOf((i10 * 1000) - TimeZone.getDefault().getRawOffset()));
    }

    public static String j(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(i10 * 1000));
        return calendar.get(12) + "'" + calendar.get(13) + "\"";
    }
}
