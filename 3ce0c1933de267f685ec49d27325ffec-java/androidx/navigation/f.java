package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j0;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;
import java.util.UUID;
/* compiled from: NavBackStackEntry.java */
/* loaded from: classes.dex */
public final class f implements p, j0, j, c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3448a;

    /* renamed from: b  reason: collision with root package name */
    private final k f3449b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3450c;

    /* renamed from: d  reason: collision with root package name */
    private final q f3451d;

    /* renamed from: e  reason: collision with root package name */
    private final b f3452e;

    /* renamed from: f  reason: collision with root package name */
    final UUID f3453f;

    /* renamed from: g  reason: collision with root package name */
    private Lifecycle.State f3454g;

    /* renamed from: h  reason: collision with root package name */
    private Lifecycle.State f3455h;

    /* renamed from: i  reason: collision with root package name */
    private g f3456i;

    /* renamed from: j  reason: collision with root package name */
    private h0.b f3457j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavBackStackEntry.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3458a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f3458a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3458a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3458a[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3458a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3458a[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3458a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3458a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, k kVar, Bundle bundle, p pVar, g gVar) {
        this(context, kVar, bundle, pVar, gVar, UUID.randomUUID(), null);
    }

    private static Lifecycle.State d(Lifecycle.Event event) {
        switch (a.f3458a[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    public Bundle a() {
        return this.f3450c;
    }

    public k b() {
        return this.f3449b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lifecycle.State c() {
        return this.f3455h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Lifecycle.Event event) {
        this.f3454g = d(event);
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Bundle bundle) {
        this.f3450c = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        this.f3452e.d(bundle);
    }

    @Override // androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        if (this.f3457j == null) {
            this.f3457j = new c0((Application) this.f3448a.getApplicationContext(), this, this.f3450c);
        }
        return this.f3457j;
    }

    @Override // androidx.lifecycle.p
    public Lifecycle getLifecycle() {
        return this.f3451d;
    }

    @Override // androidx.savedstate.c
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f3452e.b();
    }

    @Override // androidx.lifecycle.j0
    public i0 getViewModelStore() {
        g gVar = this.f3456i;
        if (gVar != null) {
            return gVar.c(this.f3453f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Lifecycle.State state) {
        this.f3455h = state;
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (this.f3454g.ordinal() < this.f3455h.ordinal()) {
            this.f3451d.o(this.f3454g);
        } else {
            this.f3451d.o(this.f3455h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, k kVar, Bundle bundle, p pVar, g gVar, UUID uuid, Bundle bundle2) {
        this.f3451d = new q(this);
        b a10 = b.a(this);
        this.f3452e = a10;
        this.f3454g = Lifecycle.State.CREATED;
        this.f3455h = Lifecycle.State.RESUMED;
        this.f3448a = context;
        this.f3453f = uuid;
        this.f3449b = kVar;
        this.f3450c = bundle;
        this.f3456i = gVar;
        a10.c(bundle2);
        if (pVar != null) {
            this.f3454g = pVar.getLifecycle().b();
        }
    }
}
