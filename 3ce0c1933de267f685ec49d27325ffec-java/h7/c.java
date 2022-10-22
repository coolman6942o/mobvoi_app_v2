package h7;

import android.os.Build;
/* compiled from: CircularRevealHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f27744a;

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            f27744a = 2;
        } else if (i10 >= 18) {
            f27744a = 1;
        } else {
            f27744a = 0;
        }
    }
}
