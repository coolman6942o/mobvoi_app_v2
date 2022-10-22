package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;
/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private Object f2629a;

    private z(Object obj) {
        this.f2629a = obj;
    }

    public static z b(Context context, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new z(PointerIcon.getSystemIcon(context, i10));
        }
        return new z(null);
    }

    public Object a() {
        return this.f2629a;
    }
}
