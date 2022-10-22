package bh;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.TextView;
import com.mobvoi.health.common.data.pojo.SportType;
import ef.u;
import fg.q;
import gh.a;
import java.util.List;
/* compiled from: SportUtils.java */
/* loaded from: classes2.dex */
public class f {
    public static int a(int i10) {
        int i11 = i10 % 3;
        if (i11 != 0) {
            i10 += 3 - i11;
        }
        return i10 / 3;
    }

    public static String b(Context context, u uVar) {
        return context.getString(fg.u.E2, DateFormat.format("MM-dd HH:mm", uVar.f25989h).toString(), DateFormat.format("HH:mm", uVar.f25990i).toString());
    }

    public static float c(List<a> list) {
        if (list == null || list.size() == 0) {
            return 0.0f;
        }
        int size = list.size();
        float f10 = 0.0f;
        for (a aVar : list) {
            f10 += aVar.f27477c;
        }
        if (f10 > 0.0f) {
            return (f10 * 100) / list.get(size - 1).f27476b;
        }
        return 0.0f;
    }

    public static boolean d(SportType sportType) {
        return sportType == SportType.BandAutoWalking || sportType == SportType.BandRunning;
    }

    public static boolean e(List list) {
        return list == null || list.size() == 0;
    }

    public static void f(Context context, TextView textView, TextView textView2, SportType sportType, u uVar) {
        textView.setText(context.getResources().getString(com.mobvoi.health.companion.sport.view.a.d().e(sportType).f18994c));
        if (sportType.isAutoSport()) {
            textView.setCompoundDrawablePadding(10);
            textView.setCompoundDrawablesWithIntrinsicBounds(q.f26576i, 0, 0, 0);
        }
        textView2.setText(b(context, uVar));
    }
}
