package l2;

import android.util.Log;
/* compiled from: FMLog4Android.java */
/* loaded from: classes.dex */
public class a implements z2.a {
    @Override // z2.a
    public void a(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // z2.a
    public void b(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // z2.a
    public void c(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // z2.a
    public void d(boolean z10) {
    }

    @Override // z2.a
    public void e(String str, String str2) {
        Log.i(str, str2);
    }
}
