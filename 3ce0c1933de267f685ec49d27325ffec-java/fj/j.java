package fj;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.f;
import hc.e;
import java.util.List;
import rx.c;
import rx.i;
import sh.k;
import xp.a;
import yp.g;
/* compiled from: RequestPermissionUtils.java */
/* loaded from: classes2.dex */
public class j {
    public static String c(Context context) {
        if (Build.VERSION.SDK_INT <= 30) {
            return context.getString(k.f34839n1);
        }
        boolean i10 = e.i(context, "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        boolean i11 = e.i(context, "android.permission.ACCESS_FINE_LOCATION");
        if (!i10 && !i11) {
            return context.getString(k.f34771a2);
        }
        if (!i10) {
            return context.getString(k.Z1);
        }
        return context.getString(k.O0);
    }

    public static String[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 30) {
            return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
        }
        if (i10 > 28) {
            return new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        }
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT > 30) {
            return e.i(context, "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(f fVar, i iVar) {
        iVar.onNext(g.Z(fVar));
    }

    public static c<List<e>> h(final f fVar, final String... strArr) {
        return c.i0(new c.a() { // from class: fj.h
            @Override // yp.b
            public final void call(Object obj) {
                j.f(f.this, (i) obj);
            }
        }).Z(a.b()).v(new g() { // from class: fj.i
            @Override // yp.g
            public final Object call(Object obj) {
                c c02;
                c02 = ((g) obj).c0(strArr);
                return c02;
            }
        });
    }
}
