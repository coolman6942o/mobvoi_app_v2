package hl;

import android.util.Log;
/* loaded from: classes2.dex */
public class a implements il.a {
    @Override // il.a
    public void log(int i10, String str, String str2) {
        switch (i10) {
            case 1:
                Log.v(str, str2);
                return;
            case 2:
                Log.d(str, str2);
                return;
            case 3:
                Log.i(str, str2);
                return;
            case 4:
                Log.w(str, str2);
                return;
            case 5:
                Log.e(str, str2);
                return;
            case 6:
                Log.wtf(str, str2);
                return;
            default:
                return;
        }
    }
}
