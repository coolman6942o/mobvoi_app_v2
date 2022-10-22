package g5;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.f;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import java.util.HashMap;
import java.util.Map;
import n5.j;
import n5.k;
/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class l implements Handler.Callback {

    /* renamed from: f  reason: collision with root package name */
    private static final b f27276f = new a();

    /* renamed from: a  reason: collision with root package name */
    private volatile h f27277a;

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, k> f27278b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, o> f27279c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f27280d;

    /* renamed from: e  reason: collision with root package name */
    private final b f27281e;

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // g5.l.b
        public h a(c cVar, h hVar, m mVar, Context context) {
            return new h(cVar, hVar, mVar, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public interface b {
        h a(c cVar, h hVar, m mVar, Context context);
    }

    public l(b bVar) {
        new androidx.collection.a();
        new androidx.collection.a();
        new Bundle();
        this.f27281e = bVar == null ? f27276f : bVar;
        this.f27280d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @Deprecated
    private h c(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        k j10 = j(fragmentManager, fragment, z10);
        h e10 = j10.e();
        if (e10 != null) {
            return e10;
        }
        h a10 = this.f27281e.a(c.c(context), j10.c(), j10.f(), context);
        j10.k(a10);
        return a10;
    }

    private h h(Context context) {
        if (this.f27277a == null) {
            synchronized (this) {
                if (this.f27277a == null) {
                    this.f27277a = this.f27281e.a(c.c(context.getApplicationContext()), new g5.b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f27277a;
    }

    private k j(FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f27278b.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.j(fragment);
            if (z10) {
                kVar.c().d();
            }
            this.f27278b.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f27280d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    private o l(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment, boolean z10) {
        o oVar = (o) fragmentManager.g0("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f27279c.get(fragmentManager)) == null) {
            oVar = new o();
            oVar.i0(fragment);
            if (z10) {
                oVar.a0().d();
            }
            this.f27279c.put(fragmentManager, oVar);
            fragmentManager.l().e(oVar, "com.bumptech.glide.manager").k();
            this.f27280d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return oVar;
    }

    private static boolean m(Context context) {
        Activity b10 = b(context);
        return b10 == null || !b10.isFinishing();
    }

    private h n(Context context, androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment, boolean z10) {
        o l10 = l(fragmentManager, fragment, z10);
        h c02 = l10.c0();
        if (c02 != null) {
            return c02;
        }
        h a10 = this.f27281e.a(c.c(context), l10.a0(), l10.d0(), context);
        l10.j0(a10);
        return a10;
    }

    public h d(Activity activity) {
        if (k.p()) {
            return e(activity.getApplicationContext());
        }
        a(activity);
        return c(activity, activity.getFragmentManager(), null, m(activity));
    }

    public h e(Context context) {
        if (context != null) {
            if (k.q() && !(context instanceof Application)) {
                if (context instanceof f) {
                    return g((f) context);
                }
                if (context instanceof Activity) {
                    return d((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return e(contextWrapper.getBaseContext());
                    }
                }
            }
            return h(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public h f(androidx.fragment.app.Fragment fragment) {
        j.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (k.p()) {
            return e(fragment.getContext().getApplicationContext());
        }
        return n(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public h g(f fVar) {
        if (k.p()) {
            return e(fVar.getApplicationContext());
        }
        a(fVar);
        return n(fVar, fVar.getSupportFragmentManager(), null, m(fVar));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i10 = message.what;
        Object obj4 = null;
        boolean z10 = true;
        if (i10 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f27278b.remove(obj3);
        } else if (i10 != 2) {
            z10 = false;
            obj = null;
            if (z10 && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z10;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f27279c.remove(obj3);
        }
        obj = obj3;
        obj4 = obj2;
        if (z10) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public k i(Activity activity) {
        return j(activity.getFragmentManager(), null, m(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o k(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return l(fragmentManager, null, m(context));
    }
}
