package g6;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import h6.d;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f27293e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f27294f;

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f27295a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f27296b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f27297c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f27298d;

    private a() {
        List<String> list = Collections.EMPTY_LIST;
        this.f27295a = list;
        this.f27296b = list;
        this.f27297c = list;
        this.f27298d = list;
    }

    public static a b() {
        if (f27294f == null) {
            synchronized (f27293e) {
                if (f27294f == null) {
                    f27294f = new a();
                }
            }
        }
        return f27294f;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i10) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i10);
    }

    @SuppressLint({"UntrackedBindService"})
    public void c(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : d.b(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i10);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
