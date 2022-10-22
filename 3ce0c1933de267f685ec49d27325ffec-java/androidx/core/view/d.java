package androidx.core.view;

import android.os.Build;
import android.view.DisplayCutout;
import j0.c;
/* compiled from: DisplayCutoutCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2499a;

    private d(Object obj) {
        this.f2499a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2499a).getSafeInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2499a).getSafeInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2499a).getSafeInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2499a).getSafeInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return c.a(this.f2499a, ((d) obj).f2499a);
    }

    public int hashCode() {
        Object obj = this.f2499a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2499a + "}";
    }
}
