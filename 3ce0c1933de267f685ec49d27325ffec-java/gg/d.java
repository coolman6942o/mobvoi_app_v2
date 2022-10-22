package gg;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.q;
/* compiled from: ArtyDataUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static int a(int i10, int i11) {
        String str = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "" : "pref_key_arty_age" : "pref_key_arty_hsx" : "pref_key_arty_cap" : "pref_key_arty_truhr" : "pref_key_arty_score";
        int i12 = 0;
        if (!TextUtils.isEmpty(str)) {
            int b10 = b(str);
            if (b10 >= 0) {
                i12 = i11 - b10;
            }
            if (i12 != 0 || b10 == -1) {
                c(str, i11);
            }
        }
        return i12;
    }

    public static int b(String str) {
        return q.b(b.e(), "arty_data_pref_name", str, -1);
    }

    public static void c(String str, int i10) {
        q.f(b.e(), "arty_data_pref_name", str, i10);
    }
}
