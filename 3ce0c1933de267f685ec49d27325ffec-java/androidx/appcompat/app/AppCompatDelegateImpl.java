package androidx.appcompat.app;

import a0.h;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.e1;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.x0;
import androidx.core.view.d0;
import androidx.core.view.g;
import androidx.core.view.i0;
import androidx.core.view.k0;
import androidx.core.view.n0;
import androidx.lifecycle.Lifecycle;
import i.b;
import i.f;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.f implements e.a, LayoutInflater.Factory2 {

    /* renamed from: n0  reason: collision with root package name */
    private static final androidx.collection.f<String, Integer> f433n0 = new androidx.collection.f<>();

    /* renamed from: o0  reason: collision with root package name */
    private static final boolean f434o0;

    /* renamed from: p0  reason: collision with root package name */
    private static final int[] f435p0;

    /* renamed from: q0  reason: collision with root package name */
    private static final boolean f436q0;

    /* renamed from: r0  reason: collision with root package name */
    private static final boolean f437r0;

    /* renamed from: s0  reason: collision with root package name */
    private static boolean f438s0;
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    private boolean F;
    private PanelFeatureState[] G;
    private PanelFeatureState H;
    private boolean I;
    private boolean J;
    private boolean K;
    boolean L;
    private Configuration M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private r R;
    private r S;
    boolean T;
    int U;
    private final Runnable V;
    private boolean W;

    /* renamed from: d  reason: collision with root package name */
    final Object f439d;

    /* renamed from: e  reason: collision with root package name */
    final Context f440e;

    /* renamed from: f  reason: collision with root package name */
    Window f441f;

    /* renamed from: g  reason: collision with root package name */
    private p f442g;

    /* renamed from: h  reason: collision with root package name */
    final androidx.appcompat.app.e f443h;

    /* renamed from: i  reason: collision with root package name */
    androidx.appcompat.app.a f444i;

    /* renamed from: j  reason: collision with root package name */
    MenuInflater f445j;

    /* renamed from: j0  reason: collision with root package name */
    private Rect f446j0;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f447k;

    /* renamed from: k0  reason: collision with root package name */
    private Rect f448k0;

    /* renamed from: l  reason: collision with root package name */
    private e0 f449l;

    /* renamed from: l0  reason: collision with root package name */
    private androidx.appcompat.app.h f450l0;

    /* renamed from: m  reason: collision with root package name */
    private j f451m;

    /* renamed from: m0  reason: collision with root package name */
    private androidx.appcompat.app.i f452m0;

    /* renamed from: n  reason: collision with root package name */
    private v f453n;

    /* renamed from: o  reason: collision with root package name */
    i.b f454o;

    /* renamed from: p  reason: collision with root package name */
    ActionBarContextView f455p;

    /* renamed from: q  reason: collision with root package name */
    PopupWindow f456q;

    /* renamed from: r  reason: collision with root package name */
    Runnable f457r;

    /* renamed from: s  reason: collision with root package name */
    i0 f458s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f459t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f460u;

    /* renamed from: v  reason: collision with root package name */
    ViewGroup f461v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f462w;

    /* renamed from: x  reason: collision with root package name */
    private View f463x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f464y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f465z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f466a;

        /* renamed from: b  reason: collision with root package name */
        int f467b;

        /* renamed from: c  reason: collision with root package name */
        int f468c;

        /* renamed from: d  reason: collision with root package name */
        int f469d;

        /* renamed from: e  reason: collision with root package name */
        int f470e;

        /* renamed from: f  reason: collision with root package name */
        int f471f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f472g;

        /* renamed from: h  reason: collision with root package name */
        View f473h;

        /* renamed from: i  reason: collision with root package name */
        View f474i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.e f475j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.c f476k;

        /* renamed from: l  reason: collision with root package name */
        Context f477l;

        /* renamed from: m  reason: collision with root package name */
        boolean f478m;

        /* renamed from: n  reason: collision with root package name */
        boolean f479n;

        /* renamed from: o  reason: collision with root package name */
        boolean f480o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f481p;

        /* renamed from: q  reason: collision with root package name */
        boolean f482q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f483r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f484s;

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f485a;

            /* renamed from: b  reason: collision with root package name */
            boolean f486b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f487c;

            /* loaded from: classes.dex */
            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f485a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f486b = z10;
                if (z10) {
                    savedState.f487c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f485a);
                parcel.writeInt(this.f486b ? 1 : 0);
                if (this.f486b) {
                    parcel.writeBundle(this.f487c);
                }
            }
        }

        PanelFeatureState(int i10) {
            this.f466a = i10;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f475j == null) {
                return null;
            }
            if (this.f476k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f477l, d.g.f24824j);
                this.f476k = cVar;
                cVar.h(aVar);
                this.f475j.b(this.f476k);
            }
            return this.f476k.b(this.f472g);
        }

        public boolean b() {
            if (this.f473h == null) {
                return false;
            }
            return this.f474i != null || this.f476k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f475j;
            if (eVar != eVar2) {
                if (eVar2 != null) {
                    eVar2.Q(this.f476k);
                }
                this.f475j = eVar;
                if (eVar != null && (cVar = this.f476k) != null) {
                    eVar.b(cVar);
                }
            }
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(d.a.f24713a, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(d.a.H, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(d.i.f24851c, true);
            }
            i.d dVar = new i.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f477l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(d.j.f24960v0);
            this.f467b = obtainStyledAttributes.getResourceId(d.j.f24975y0, 0);
            this.f471f = obtainStyledAttributes.getResourceId(d.j.f24970x0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f488a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f488a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th2) {
            String message;
            if (!(th2 instanceof Resources.NotFoundException) || (message = th2.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            if (a(th2)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th2.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th2.getCause());
                notFoundException.setStackTrace(th2.getStackTrace());
                this.f488a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f488a.uncaughtException(thread, th2);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.U & 1) != 0) {
                appCompatDelegateImpl.Z(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.U & 4096) != 0) {
                appCompatDelegateImpl2.Z(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.T = false;
            appCompatDelegateImpl3.U = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements androidx.core.view.v {
        c() {
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            int m10 = n0Var.m();
            int P0 = AppCompatDelegateImpl.this.P0(n0Var, null);
            if (m10 != P0) {
                n0Var = n0Var.q(n0Var.k(), P0, n0Var.l(), n0Var.j());
            }
            return d0.f0(view, n0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements i0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.i0.a
        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.P0(null, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* loaded from: classes.dex */
        class a extends k0 {
            a() {
            }

            @Override // androidx.core.view.j0
            public void b(View view) {
                AppCompatDelegateImpl.this.f455p.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f458s.f(null);
                AppCompatDelegateImpl.this.f458s = null;
            }

            @Override // androidx.core.view.k0, androidx.core.view.j0
            public void c(View view) {
                AppCompatDelegateImpl.this.f455p.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f456q.showAtLocation(appCompatDelegateImpl.f455p, 55, 0, 0);
            AppCompatDelegateImpl.this.a0();
            if (AppCompatDelegateImpl.this.I0()) {
                AppCompatDelegateImpl.this.f455p.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f458s = d0.e(appCompatDelegateImpl2.f455p).a(1.0f);
                AppCompatDelegateImpl.this.f458s.f(new a());
                return;
            }
            AppCompatDelegateImpl.this.f455p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f455p.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends k0 {
        g() {
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            AppCompatDelegateImpl.this.f455p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f458s.f(null);
            AppCompatDelegateImpl.this.f458s = null;
        }

        @Override // androidx.core.view.k0, androidx.core.view.j0
        public void c(View view) {
            AppCompatDelegateImpl.this.f455p.setVisibility(0);
            if (AppCompatDelegateImpl.this.f455p.getParent() instanceof View) {
                d0.q0((View) AppCompatDelegateImpl.this.f455p.getParent());
            }
        }
    }

    /* loaded from: classes.dex */
    private class h implements androidx.appcompat.app.b {
        h() {
        }

        @Override // androidx.appcompat.app.b
        public Context a() {
            return AppCompatDelegateImpl.this.f0();
        }

        @Override // androidx.appcompat.app.b
        public void b(Drawable drawable, int i10) {
            androidx.appcompat.app.a p10 = AppCompatDelegateImpl.this.p();
            if (p10 != null) {
                p10.x(drawable);
                p10.v(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface i {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class j implements j.a {
        j() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            AppCompatDelegateImpl.this.Q(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback k02 = AppCompatDelegateImpl.this.k0();
            if (k02 == null) {
                return true;
            }
            k02.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f498a;

        /* loaded from: classes.dex */
        class a extends k0 {
            a() {
            }

            @Override // androidx.core.view.j0
            public void b(View view) {
                AppCompatDelegateImpl.this.f455p.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f456q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f455p.getParent() instanceof View) {
                    d0.q0((View) AppCompatDelegateImpl.this.f455p.getParent());
                }
                AppCompatDelegateImpl.this.f455p.k();
                AppCompatDelegateImpl.this.f458s.f(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f458s = null;
                d0.q0(appCompatDelegateImpl2.f461v);
            }
        }

        public k(b.a aVar) {
            this.f498a = aVar;
        }

        @Override // i.b.a
        public boolean a(i.b bVar, MenuItem menuItem) {
            return this.f498a.a(bVar, menuItem);
        }

        @Override // i.b.a
        public void b(i.b bVar) {
            this.f498a.b(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f456q != null) {
                appCompatDelegateImpl.f441f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f457r);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f455p != null) {
                appCompatDelegateImpl2.a0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f458s = d0.e(appCompatDelegateImpl3.f455p).a(0.0f);
                AppCompatDelegateImpl.this.f458s.f(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.e eVar = appCompatDelegateImpl4.f443h;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(appCompatDelegateImpl4.f454o);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f454o = null;
            d0.q0(appCompatDelegateImpl5.f461v);
        }

        @Override // i.b.a
        public boolean c(i.b bVar, Menu menu) {
            d0.q0(AppCompatDelegateImpl.this.f461v);
            return this.f498a.c(bVar, menu);
        }

        @Override // i.b.a
        public boolean d(i.b bVar, Menu menu) {
            return this.f498a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class l {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }
    }

    /* loaded from: classes.dex */
    static class m {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class q extends r {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f503c;

        q(Context context) {
            super();
            this.f503c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !m.a(this.f503c)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void d() {
            AppCompatDelegateImpl.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class r {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f505a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                r.this.d();
            }
        }

        r() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f505a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f440e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f505a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f505a == null) {
                    this.f505a = new a();
                }
                AppCompatDelegateImpl.this.f440e.registerReceiver(this.f505a, b10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class s extends r {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.app.m f508c;

        s(androidx.appcompat.app.m mVar) {
            super();
            this.f508c = mVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return this.f508c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void d() {
            AppCompatDelegateImpl.this.e();
        }
    }

    /* loaded from: classes.dex */
    private static class t {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class u extends ContentFrameLayout {
        public u(Context context) {
            super(context);
        }

        private boolean c(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.Y(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.S(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(e.a.b(getContext(), i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class v implements j.a {
        v() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            androidx.appcompat.view.menu.e F = eVar.F();
            boolean z11 = F != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                eVar = F;
            }
            PanelFeatureState d02 = appCompatDelegateImpl.d0(eVar);
            if (d02 == null) {
                return;
            }
            if (z11) {
                AppCompatDelegateImpl.this.P(d02.f466a, d02, F);
                AppCompatDelegateImpl.this.T(d02, true);
                return;
            }
            AppCompatDelegateImpl.this.T(d02, z10);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback k02;
            if (eVar != eVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.A || (k02 = appCompatDelegateImpl.k0()) == null || AppCompatDelegateImpl.this.L) {
                return true;
            }
            k02.onMenuOpened(108, eVar);
            return true;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        boolean z11 = i10 < 21;
        f434o0 = z11;
        f435p0 = new int[]{16842836};
        f436q0 = !"robolectric".equals(Build.FINGERPRINT);
        if (i10 >= 17) {
            z10 = true;
        }
        f437r0 = z10;
        if (z11 && !f438s0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
            f438s0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    private void C0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f480o && !this.L) {
            if (panelFeatureState.f466a == 0) {
                if ((this.f440e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback k02 = k0();
            if (k02 == null || k02.onMenuOpened(panelFeatureState.f466a, panelFeatureState.f475j)) {
                WindowManager windowManager = (WindowManager) this.f440e.getSystemService("window");
                if (windowManager != null && F0(panelFeatureState, keyEvent)) {
                    ViewGroup viewGroup = panelFeatureState.f472g;
                    if (viewGroup == null || panelFeatureState.f482q) {
                        if (viewGroup == null) {
                            if (!n0(panelFeatureState) || panelFeatureState.f472g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f482q && viewGroup.getChildCount() > 0) {
                            panelFeatureState.f472g.removeAllViews();
                        }
                        if (!m0(panelFeatureState) || !panelFeatureState.b()) {
                            panelFeatureState.f482q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f473h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.f472g.setBackgroundResource(panelFeatureState.f467b);
                        ViewParent parent = panelFeatureState.f473h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f473h);
                        }
                        panelFeatureState.f472g.addView(panelFeatureState.f473h, layoutParams2);
                        if (!panelFeatureState.f473h.hasFocus()) {
                            panelFeatureState.f473h.requestFocus();
                        }
                    } else {
                        View view = panelFeatureState.f474i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i10 = -1;
                            panelFeatureState.f479n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f469d, panelFeatureState.f470e, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.f468c;
                            layoutParams3.windowAnimations = panelFeatureState.f471f;
                            windowManager.addView(panelFeatureState.f472g, layoutParams3);
                            panelFeatureState.f480o = true;
                            return;
                        }
                    }
                    i10 = -2;
                    panelFeatureState.f479n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f469d, panelFeatureState.f470e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f468c;
                    layoutParams32.windowAnimations = panelFeatureState.f471f;
                    windowManager.addView(panelFeatureState.f472g, layoutParams32);
                    panelFeatureState.f480o = true;
                    return;
                }
                return;
            }
            T(panelFeatureState, true);
        }
    }

    private boolean E0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f478m || F0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.f475j) != null) {
            z10 = eVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f449l == null) {
            T(panelFeatureState, true);
        }
        return z10;
    }

    private boolean F0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        e0 e0Var;
        e0 e0Var2;
        e0 e0Var3;
        if (this.L) {
            return false;
        }
        if (panelFeatureState.f478m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.H;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            T(panelFeatureState2, false);
        }
        Window.Callback k02 = k0();
        if (k02 != null) {
            panelFeatureState.f474i = k02.onCreatePanelView(panelFeatureState.f466a);
        }
        int i10 = panelFeatureState.f466a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (e0Var3 = this.f449l) != null) {
            e0Var3.c();
        }
        if (panelFeatureState.f474i == null && (!z10 || !(D0() instanceof androidx.appcompat.app.k))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.f475j;
            if (eVar == null || panelFeatureState.f483r) {
                if (eVar == null && (!o0(panelFeatureState) || panelFeatureState.f475j == null)) {
                    return false;
                }
                if (z10 && this.f449l != null) {
                    if (this.f451m == null) {
                        this.f451m = new j();
                    }
                    this.f449l.a(panelFeatureState.f475j, this.f451m);
                }
                panelFeatureState.f475j.h0();
                if (!k02.onCreatePanelMenu(panelFeatureState.f466a, panelFeatureState.f475j)) {
                    panelFeatureState.c(null);
                    if (z10 && (e0Var2 = this.f449l) != null) {
                        e0Var2.a(null, this.f451m);
                    }
                    return false;
                }
                panelFeatureState.f483r = false;
            }
            panelFeatureState.f475j.h0();
            Bundle bundle = panelFeatureState.f484s;
            if (bundle != null) {
                panelFeatureState.f475j.R(bundle);
                panelFeatureState.f484s = null;
            }
            if (!k02.onPreparePanel(0, panelFeatureState.f474i, panelFeatureState.f475j)) {
                if (z10 && (e0Var = this.f449l) != null) {
                    e0Var.a(null, this.f451m);
                }
                panelFeatureState.f475j.g0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f481p = z11;
            panelFeatureState.f475j.setQwertyMode(z11);
            panelFeatureState.f475j.g0();
        }
        panelFeatureState.f478m = true;
        panelFeatureState.f479n = false;
        this.H = panelFeatureState;
        return true;
    }

    private void G0(boolean z10) {
        e0 e0Var = this.f449l;
        if (e0Var == null || !e0Var.d() || (ViewConfiguration.get(this.f440e).hasPermanentMenuKey() && !this.f449l.e())) {
            PanelFeatureState i02 = i0(0, true);
            i02.f482q = true;
            T(i02, false);
            C0(i02, null);
            return;
        }
        Window.Callback k02 = k0();
        if (this.f449l.b() && z10) {
            this.f449l.f();
            if (!this.L) {
                k02.onPanelClosed(108, i0(0, true).f475j);
            }
        } else if (k02 != null && !this.L) {
            if (this.T && (this.U & 1) != 0) {
                this.f441f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            PanelFeatureState i03 = i0(0, true);
            androidx.appcompat.view.menu.e eVar = i03.f475j;
            if (eVar != null && !i03.f483r && k02.onPreparePanel(0, i03.f474i, eVar)) {
                k02.onMenuOpened(108, i03.f475j);
                this.f449l.g();
            }
        }
    }

    private int H0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i10 != 9) {
            return i10;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean J0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f441f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || d0.W((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean L(boolean z10) {
        if (this.L) {
            return false;
        }
        int O = O();
        boolean N0 = N0(s0(this.f440e, O), z10);
        if (O == 0) {
            h0(this.f440e).e();
        } else {
            r rVar = this.R;
            if (rVar != null) {
                rVar.a();
            }
        }
        if (O == 3) {
            g0(this.f440e).e();
        } else {
            r rVar2 = this.S;
            if (rVar2 != null) {
                rVar2.a();
            }
        }
        return N0;
    }

    private void L0() {
        if (this.f460u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void M() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f461v.findViewById(16908290);
        View decorView = this.f441f.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f440e.obtainStyledAttributes(d.j.f24960v0);
        obtainStyledAttributes.getValue(d.j.H0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(d.j.I0, contentFrameLayout.getMinWidthMinor());
        int i10 = d.j.F0;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = d.j.G0;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = d.j.D0;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = d.j.E0;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private androidx.appcompat.app.d M0() {
        for (Context context = this.f440e; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void N(Window window) {
        if (this.f441f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof p)) {
                p pVar = new p(callback);
                this.f442g = pVar;
                window.setCallback(pVar);
                x0 u10 = x0.u(this.f440e, null, f435p0);
                Drawable h10 = u10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                u10.w();
                this.f441f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean N0(int i10, boolean z10) {
        boolean z11;
        Configuration U = U(this.f440e, i10, null);
        boolean q02 = q0();
        Configuration configuration = this.M;
        if (configuration == null) {
            configuration = this.f440e.getResources().getConfiguration();
        }
        int i11 = configuration.uiMode & 48;
        int i12 = U.uiMode & 48;
        boolean z12 = true;
        if (i11 != i12 && z10 && !q02 && this.J && (f436q0 || this.K)) {
            Object obj = this.f439d;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                androidx.core.app.a.r((Activity) this.f439d);
                z11 = true;
                if (!z11 || i11 == i12) {
                    z12 = z11;
                } else {
                    O0(i12, q02, null);
                }
                if (z12) {
                    Object obj2 = this.f439d;
                    if (obj2 instanceof androidx.appcompat.app.d) {
                        ((androidx.appcompat.app.d) obj2).onNightModeChanged(i10);
                    }
                }
                return z12;
            }
        }
        z11 = false;
        if (!z11) {
        }
        z12 = z11;
        if (z12) {
        }
        return z12;
    }

    private int O() {
        int i10 = this.N;
        return i10 != -100 ? i10 : androidx.appcompat.app.f.l();
    }

    private void O0(int i10, boolean z10, Configuration configuration) {
        Resources resources = this.f440e.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            androidx.appcompat.app.j.a(resources);
        }
        int i12 = this.O;
        if (i12 != 0) {
            this.f440e.setTheme(i12);
            if (i11 >= 23) {
                this.f440e.getTheme().applyStyle(this.O, true);
            }
        }
        if (z10) {
            Object obj = this.f439d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.p) {
                    if (((androidx.lifecycle.p) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.K && !this.L) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void Q0(View view) {
        int i10;
        if ((d0.Q(view) & 8192) != 0) {
            i10 = androidx.core.content.b.c(this.f440e, d.c.f24741b);
        } else {
            i10 = androidx.core.content.b.c(this.f440e, d.c.f24740a);
        }
        view.setBackgroundColor(i10);
    }

    private void R() {
        r rVar = this.R;
        if (rVar != null) {
            rVar.a();
        }
        r rVar2 = this.S;
        if (rVar2 != null) {
            rVar2.a();
        }
    }

    private Configuration U(Context context, int i10, Configuration configuration) {
        int i11;
        if (i10 != 1) {
            i11 = i10 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i11 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup V() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f440e.obtainStyledAttributes(d.j.f24960v0);
        int i10 = d.j.A0;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(d.j.J0, false)) {
                C(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                C(108);
            }
            if (obtainStyledAttributes.getBoolean(d.j.B0, false)) {
                C(109);
            }
            if (obtainStyledAttributes.getBoolean(d.j.C0, false)) {
                C(10);
            }
            this.D = obtainStyledAttributes.getBoolean(d.j.f24965w0, false);
            obtainStyledAttributes.recycle();
            c0();
            this.f441f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f440e);
            if (this.E) {
                viewGroup = this.C ? (ViewGroup) from.inflate(d.g.f24829o, (ViewGroup) null) : (ViewGroup) from.inflate(d.g.f24828n, (ViewGroup) null);
            } else if (this.D) {
                viewGroup = (ViewGroup) from.inflate(d.g.f24820f, (ViewGroup) null);
                this.B = false;
                this.A = false;
            } else if (this.A) {
                TypedValue typedValue = new TypedValue();
                this.f440e.getTheme().resolveAttribute(d.a.f24718f, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new i.d(this.f440e, typedValue.resourceId);
                } else {
                    context = this.f440e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.g.f24830p, (ViewGroup) null);
                e0 e0Var = (e0) viewGroup.findViewById(d.f.f24804p);
                this.f449l = e0Var;
                e0Var.setWindowCallback(k0());
                if (this.B) {
                    this.f449l.h(109);
                }
                if (this.f464y) {
                    this.f449l.h(2);
                }
                if (this.f465z) {
                    this.f449l.h(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    d0.G0(viewGroup, new c());
                } else if (viewGroup instanceof androidx.appcompat.widget.i0) {
                    ((androidx.appcompat.widget.i0) viewGroup).setOnFitSystemWindowsListener(new d());
                }
                if (this.f449l == null) {
                    this.f462w = (TextView) viewGroup.findViewById(d.f.M);
                }
                e1.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(d.f.f24790b);
                ViewGroup viewGroup2 = (ViewGroup) this.f441f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f441f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.A + ", windowActionBarOverlay: " + this.B + ", android:windowIsFloating: " + this.D + ", windowActionModeOverlay: " + this.C + ", windowNoTitle: " + this.E + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void b0() {
        if (!this.f460u) {
            this.f461v = V();
            CharSequence j02 = j0();
            if (!TextUtils.isEmpty(j02)) {
                e0 e0Var = this.f449l;
                if (e0Var != null) {
                    e0Var.setWindowTitle(j02);
                } else if (D0() != null) {
                    D0().A(j02);
                } else {
                    TextView textView = this.f462w;
                    if (textView != null) {
                        textView.setText(j02);
                    }
                }
            }
            M();
            B0(this.f461v);
            this.f460u = true;
            PanelFeatureState i02 = i0(0, false);
            if (this.L) {
                return;
            }
            if (i02 == null || i02.f475j == null) {
                p0(108);
            }
        }
    }

    private void c0() {
        if (this.f441f == null) {
            Object obj = this.f439d;
            if (obj instanceof Activity) {
                N(((Activity) obj).getWindow());
            }
        }
        if (this.f441f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration e0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                n.a(configuration, configuration2, configuration3);
            } else if (!j0.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                o.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            if (i14 >= 17) {
                l.b(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private r g0(Context context) {
        if (this.S == null) {
            this.S = new q(context);
        }
        return this.S;
    }

    private r h0(Context context) {
        if (this.R == null) {
            this.R = new s(androidx.appcompat.app.m.a(context));
        }
        return this.R;
    }

    private void l0() {
        b0();
        if (this.A && this.f444i == null) {
            Object obj = this.f439d;
            if (obj instanceof Activity) {
                this.f444i = new androidx.appcompat.app.n((Activity) this.f439d, this.B);
            } else if (obj instanceof Dialog) {
                this.f444i = new androidx.appcompat.app.n((Dialog) this.f439d);
            }
            androidx.appcompat.app.a aVar = this.f444i;
            if (aVar != null) {
                aVar.s(this.W);
            }
        }
    }

    private boolean m0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f474i;
        if (view != null) {
            panelFeatureState.f473h = view;
            return true;
        } else if (panelFeatureState.f475j == null) {
            return false;
        } else {
            if (this.f453n == null) {
                this.f453n = new v();
            }
            View view2 = (View) panelFeatureState.a(this.f453n);
            panelFeatureState.f473h = view2;
            return view2 != null;
        }
    }

    private boolean n0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(f0());
        panelFeatureState.f472g = new u(panelFeatureState.f477l);
        panelFeatureState.f468c = 81;
        return true;
    }

    private boolean o0(PanelFeatureState panelFeatureState) {
        Context context = this.f440e;
        int i10 = panelFeatureState.f466a;
        if ((i10 == 0 || i10 == 108) && this.f449l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(d.a.f24718f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(d.a.f24719g, typedValue, true);
            } else {
                theme.resolveAttribute(d.a.f24719g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                i.d dVar = new i.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.V(this);
        panelFeatureState.c(eVar);
        return true;
    }

    private void p0(int i10) {
        this.U = (1 << i10) | this.U;
        if (!this.T) {
            d0.l0(this.f441f.getDecorView(), this.V);
            this.T = true;
        }
    }

    private boolean q0() {
        if (!this.Q && (this.f439d instanceof Activity)) {
            PackageManager packageManager = this.f440e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f440e, this.f439d.getClass()), i10 >= 29 ? 269221888 : i10 >= 24 ? 786432 : 0);
                this.P = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.P = false;
            }
        }
        this.Q = true;
        return this.P;
    }

    private boolean v0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState i02 = i0(i10, true);
        if (!i02.f480o) {
            return F0(i02, keyEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean y0(int i10, KeyEvent keyEvent) {
        boolean z10;
        e0 e0Var;
        if (this.f454o != null) {
            return false;
        }
        boolean z11 = true;
        PanelFeatureState i02 = i0(i10, true);
        if (i10 != 0 || (e0Var = this.f449l) == null || !e0Var.d() || ViewConfiguration.get(this.f440e).hasPermanentMenuKey()) {
            boolean z12 = i02.f480o;
            if (z12 || i02.f479n) {
                T(i02, true);
                z11 = z12;
            } else {
                if (i02.f478m) {
                    if (i02.f483r) {
                        i02.f478m = false;
                        z10 = F0(i02, keyEvent);
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        C0(i02, keyEvent);
                    }
                }
                z11 = false;
            }
            if (z11) {
                AudioManager audioManager = (AudioManager) this.f440e.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                }
            }
            return z11;
        }
        if (!this.f449l.b()) {
            if (!this.L && F0(i02, keyEvent)) {
                z11 = this.f449l.g();
            }
            z11 = false;
        } else {
            z11 = this.f449l.f();
        }
        if (z11) {
        }
        return z11;
    }

    void A0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a p10 = p();
            if (p10 != null) {
                p10.i(false);
            }
        } else if (i10 == 0) {
            PanelFeatureState i02 = i0(i10, true);
            if (i02.f480o) {
                T(i02, false);
            }
        }
    }

    void B0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public boolean C(int i10) {
        int H0 = H0(i10);
        if (this.E && H0 == 108) {
            return false;
        }
        if (this.A && H0 == 1) {
            this.A = false;
        }
        if (H0 == 1) {
            L0();
            this.E = true;
            return true;
        } else if (H0 == 2) {
            L0();
            this.f464y = true;
            return true;
        } else if (H0 == 5) {
            L0();
            this.f465z = true;
            return true;
        } else if (H0 == 10) {
            L0();
            this.C = true;
            return true;
        } else if (H0 == 108) {
            L0();
            this.A = true;
            return true;
        } else if (H0 != 109) {
            return this.f441f.requestFeature(H0);
        } else {
            L0();
            this.B = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.f
    public void D(int i10) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.f461v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f440e).inflate(i10, viewGroup);
        this.f442g.a().onContentChanged();
    }

    final androidx.appcompat.app.a D0() {
        return this.f444i;
    }

    @Override // androidx.appcompat.app.f
    public void E(View view) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.f461v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f442g.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void F(View view, ViewGroup.LayoutParams layoutParams) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.f461v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f442g.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void H(Toolbar toolbar) {
        if (this.f439d instanceof Activity) {
            androidx.appcompat.app.a p10 = p();
            if (!(p10 instanceof androidx.appcompat.app.n)) {
                this.f445j = null;
                if (p10 != null) {
                    p10.o();
                }
                this.f444i = null;
                if (toolbar != null) {
                    androidx.appcompat.app.k kVar = new androidx.appcompat.app.k(toolbar, j0(), this.f442g);
                    this.f444i = kVar;
                    this.f442g.b(kVar.f547c);
                } else {
                    this.f442g.b(null);
                }
                r();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // androidx.appcompat.app.f
    public void I(int i10) {
        this.O = i10;
    }

    final boolean I0() {
        ViewGroup viewGroup;
        return this.f460u && (viewGroup = this.f461v) != null && d0.X(viewGroup);
    }

    @Override // androidx.appcompat.app.f
    public final void J(CharSequence charSequence) {
        this.f447k = charSequence;
        e0 e0Var = this.f449l;
        if (e0Var != null) {
            e0Var.setWindowTitle(charSequence);
        } else if (D0() != null) {
            D0().A(charSequence);
        } else {
            TextView textView = this.f462w;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public i.b K(b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar != null) {
            i.b bVar = this.f454o;
            if (bVar != null) {
                bVar.c();
            }
            k kVar = new k(aVar);
            androidx.appcompat.app.a p10 = p();
            if (p10 != null) {
                i.b B = p10.B(kVar);
                this.f454o = B;
                if (!(B == null || (eVar = this.f443h) == null)) {
                    eVar.onSupportActionModeStarted(B);
                }
            }
            if (this.f454o == null) {
                this.f454o = K0(kVar);
            }
            return this.f454o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    i.b K0(b.a aVar) {
        i.b bVar;
        i.b bVar2;
        androidx.appcompat.app.e eVar;
        Context context;
        a0();
        i.b bVar3 = this.f454o;
        if (bVar3 != null) {
            bVar3.c();
        }
        if (!(aVar instanceof k)) {
            aVar = new k(aVar);
        }
        androidx.appcompat.app.e eVar2 = this.f443h;
        if (eVar2 != null && !this.L) {
            try {
                bVar = eVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.f454o = bVar;
            } else {
                boolean z10 = true;
                if (this.f455p == null) {
                    if (this.D) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.f440e.getTheme();
                        theme.resolveAttribute(d.a.f24718f, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.f440e.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new i.d(this.f440e, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.f440e;
                        }
                        this.f455p = new ActionBarContextView(context);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, d.a.f24721i);
                        this.f456q = popupWindow;
                        androidx.core.widget.i.b(popupWindow, 2);
                        this.f456q.setContentView(this.f455p);
                        this.f456q.setWidth(-1);
                        context.getTheme().resolveAttribute(d.a.f24714b, typedValue, true);
                        this.f455p.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.f456q.setHeight(-2);
                        this.f457r = new f();
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.f461v.findViewById(d.f.f24796h);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(f0()));
                            this.f455p = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.f455p != null) {
                    a0();
                    this.f455p.k();
                    Context context2 = this.f455p.getContext();
                    ActionBarContextView actionBarContextView = this.f455p;
                    if (this.f456q != null) {
                        z10 = false;
                    }
                    i.e eVar3 = new i.e(context2, actionBarContextView, aVar, z10);
                    if (aVar.d(eVar3, eVar3.e())) {
                        eVar3.k();
                        this.f455p.h(eVar3);
                        this.f454o = eVar3;
                        if (I0()) {
                            this.f455p.setAlpha(0.0f);
                            androidx.core.view.i0 a10 = d0.e(this.f455p).a(1.0f);
                            this.f458s = a10;
                            a10.f(new g());
                        } else {
                            this.f455p.setAlpha(1.0f);
                            this.f455p.setVisibility(0);
                            if (this.f455p.getParent() instanceof View) {
                                d0.q0((View) this.f455p.getParent());
                            }
                        }
                        if (this.f456q != null) {
                            this.f441f.getDecorView().post(this.f457r);
                        }
                    } else {
                        this.f454o = null;
                    }
                }
            }
            bVar2 = this.f454o;
            if (!(bVar2 == null || (eVar = this.f443h) == null)) {
                eVar.onSupportActionModeStarted(bVar2);
            }
            return this.f454o;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar2 = this.f454o;
        if (bVar2 == null) {
            eVar.onSupportActionModeStarted(bVar2);
        }
        return this.f454o;
    }

    void P(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.G;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f475j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f480o) && !this.L) {
            this.f442g.a().onPanelClosed(i10, menu);
        }
    }

    final int P0(n0 n0Var, Rect rect) {
        int i10;
        boolean z10;
        int i11;
        int i12;
        boolean z11;
        int i13 = 0;
        if (n0Var != null) {
            i10 = n0Var.m();
        } else {
            i10 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f455p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f455p.getLayoutParams();
            boolean z12 = true;
            if (this.f455p.isShown()) {
                if (this.f446j0 == null) {
                    this.f446j0 = new Rect();
                    this.f448k0 = new Rect();
                }
                Rect rect2 = this.f446j0;
                Rect rect3 = this.f448k0;
                if (n0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(n0Var.k(), n0Var.m(), n0Var.l(), n0Var.j());
                }
                e1.a(this.f461v, rect2, rect3);
                int i14 = rect2.top;
                int i15 = rect2.left;
                int i16 = rect2.right;
                n0 L = d0.L(this.f461v);
                if (L == null) {
                    i11 = 0;
                } else {
                    i11 = L.k();
                }
                if (L == null) {
                    i12 = 0;
                } else {
                    i12 = L.l();
                }
                if (marginLayoutParams.topMargin == i14 && marginLayoutParams.leftMargin == i15 && marginLayoutParams.rightMargin == i16) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i14;
                    marginLayoutParams.leftMargin = i15;
                    marginLayoutParams.rightMargin = i16;
                    z11 = true;
                }
                if (i14 <= 0 || this.f463x != null) {
                    View view = this.f463x;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i17 = marginLayoutParams2.height;
                        int i18 = marginLayoutParams.topMargin;
                        if (!(i17 == i18 && marginLayoutParams2.leftMargin == i11 && marginLayoutParams2.rightMargin == i12)) {
                            marginLayoutParams2.height = i18;
                            marginLayoutParams2.leftMargin = i11;
                            marginLayoutParams2.rightMargin = i12;
                            this.f463x.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f440e);
                    this.f463x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i11;
                    layoutParams.rightMargin = i12;
                    this.f461v.addView(this.f463x, -1, layoutParams);
                }
                View view3 = this.f463x;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    Q0(this.f463x);
                }
                if (!this.C && z12) {
                    i10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.f455p.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f463x;
        if (view4 != null) {
            if (!z10) {
                i13 = 8;
            }
            view4.setVisibility(i13);
        }
        return i10;
    }

    void Q(androidx.appcompat.view.menu.e eVar) {
        if (!this.F) {
            this.F = true;
            this.f449l.i();
            Window.Callback k02 = k0();
            if (k02 != null && !this.L) {
                k02.onPanelClosed(108, eVar);
            }
            this.F = false;
        }
    }

    void S(int i10) {
        T(i0(i10, true), true);
    }

    void T(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        e0 e0Var;
        if (!z10 || panelFeatureState.f466a != 0 || (e0Var = this.f449l) == null || !e0Var.b()) {
            WindowManager windowManager = (WindowManager) this.f440e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f480o || (viewGroup = panelFeatureState.f472g) == null)) {
                windowManager.removeView(viewGroup);
                if (z10) {
                    P(panelFeatureState.f466a, panelFeatureState, null);
                }
            }
            panelFeatureState.f478m = false;
            panelFeatureState.f479n = false;
            panelFeatureState.f480o = false;
            panelFeatureState.f473h = null;
            panelFeatureState.f482q = true;
            if (this.H == panelFeatureState) {
                this.H = null;
                return;
            }
            return;
        }
        Q(panelFeatureState.f475j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View W(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        boolean z11 = false;
        if (this.f450l0 == null) {
            String string = this.f440e.obtainStyledAttributes(d.j.f24960v0).getString(d.j.f24980z0);
            if (string == null) {
                this.f450l0 = new androidx.appcompat.app.h();
            } else {
                try {
                    this.f450l0 = (androidx.appcompat.app.h) this.f440e.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th2);
                    this.f450l0 = new androidx.appcompat.app.h();
                }
            }
        }
        boolean z12 = f434o0;
        boolean z13 = true;
        if (z12) {
            if (this.f452m0 == null) {
                this.f452m0 = new androidx.appcompat.app.i();
            }
            if (this.f452m0.a(attributeSet)) {
                z10 = true;
                return this.f450l0.r(view, str, context, attributeSet, z10, z12, true, d1.c());
            }
            if (!(attributeSet instanceof XmlPullParser)) {
                z13 = J0((ViewParent) view);
            }
            z11 = z13;
        }
        z10 = z11;
        return this.f450l0.r(view, str, context, attributeSet, z10, z12, true, d1.c());
    }

    void X() {
        androidx.appcompat.view.menu.e eVar;
        e0 e0Var = this.f449l;
        if (e0Var != null) {
            e0Var.i();
        }
        if (this.f456q != null) {
            this.f441f.getDecorView().removeCallbacks(this.f457r);
            if (this.f456q.isShowing()) {
                try {
                    this.f456q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f456q = null;
        }
        a0();
        PanelFeatureState i02 = i0(0, false);
        if (i02 != null && (eVar = i02.f475j) != null) {
            eVar.close();
        }
    }

    boolean Y(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f439d;
        boolean z10 = true;
        if (((obj instanceof g.a) || (obj instanceof androidx.appcompat.app.g)) && (decorView = this.f441f.getDecorView()) != null && androidx.core.view.g.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f442g.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z10 = false;
        }
        return z10 ? u0(keyCode, keyEvent) : x0(keyCode, keyEvent);
    }

    void Z(int i10) {
        PanelFeatureState i02;
        PanelFeatureState i03 = i0(i10, true);
        if (i03.f475j != null) {
            Bundle bundle = new Bundle();
            i03.f475j.T(bundle);
            if (bundle.size() > 0) {
                i03.f484s = bundle;
            }
            i03.f475j.h0();
            i03.f475j.clear();
        }
        i03.f483r = true;
        i03.f482q = true;
        if ((i10 == 108 || i10 == 0) && this.f449l != null && (i02 = i0(0, false)) != null) {
            i02.f478m = false;
            F0(i02, null);
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        PanelFeatureState d02;
        Window.Callback k02 = k0();
        if (k02 == null || this.L || (d02 = d0(eVar.F())) == null) {
            return false;
        }
        return k02.onMenuItemSelected(d02.f466a, menuItem);
    }

    void a0() {
        androidx.core.view.i0 i0Var = this.f458s;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        G0(true);
    }

    @Override // androidx.appcompat.app.f
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        b0();
        ((ViewGroup) this.f461v.findViewById(16908290)).addView(view, layoutParams);
        this.f442g.a().onContentChanged();
    }

    PanelFeatureState d0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f475j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public boolean e() {
        return L(true);
    }

    final Context f0() {
        androidx.appcompat.app.a p10 = p();
        Context k10 = p10 != null ? p10.k() : null;
        return k10 == null ? this.f440e : k10;
    }

    @Override // androidx.appcompat.app.f
    public Context h(Context context) {
        boolean z10 = true;
        this.J = true;
        int s02 = s0(context, O());
        Configuration configuration = null;
        if (f437r0 && (context instanceof ContextThemeWrapper)) {
            try {
                t.a((ContextThemeWrapper) context, U(context, s02, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof i.d) {
            try {
                ((i.d) context).a(U(context, s02, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f436q0) {
            return super.h(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = l.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = e0(configuration3, configuration4);
            }
        }
        Configuration U = U(context, s02, configuration);
        i.d dVar = new i.d(context, d.i.f24852d);
        dVar.a(U);
        boolean z11 = false;
        try {
            if (context.getTheme() == null) {
                z10 = false;
            }
            z11 = z10;
        } catch (NullPointerException unused3) {
        }
        if (z11) {
            h.e.a(dVar.getTheme());
        }
        return super.h(dVar);
    }

    protected PanelFeatureState i0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.G = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    final CharSequence j0() {
        Object obj = this.f439d;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f447k;
    }

    @Override // androidx.appcompat.app.f
    public <T extends View> T k(int i10) {
        b0();
        return (T) this.f441f.findViewById(i10);
    }

    final Window.Callback k0() {
        return this.f441f.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b m() {
        return new h();
    }

    @Override // androidx.appcompat.app.f
    public int n() {
        return this.N;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater o() {
        if (this.f445j == null) {
            l0();
            androidx.appcompat.app.a aVar = this.f444i;
            this.f445j = new i.g(aVar != null ? aVar.k() : this.f440e);
        }
        return this.f445j;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return W(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a p() {
        l0();
        return this.f444i;
    }

    @Override // androidx.appcompat.app.f
    public void q() {
        LayoutInflater from = LayoutInflater.from(this.f440e);
        if (from.getFactory() == null) {
            androidx.core.view.h.b(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.f
    public void r() {
        androidx.appcompat.app.a p10 = p();
        if (p10 == null || !p10.m()) {
            p0(0);
        }
    }

    public boolean r0() {
        return this.f459t;
    }

    @Override // androidx.appcompat.app.f
    public void s(Configuration configuration) {
        androidx.appcompat.app.a p10;
        if (this.A && this.f460u && (p10 = p()) != null) {
            p10.n(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f440e);
        this.M = new Configuration(this.f440e.getResources().getConfiguration());
        L(false);
    }

    int s0(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (!(i10 == 1 || i10 == 2)) {
                    if (i10 == 3) {
                        return g0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                return h0(context).c();
            } else {
                return -1;
            }
        }
        return i10;
    }

    @Override // androidx.appcompat.app.f
    public void t(Bundle bundle) {
        this.J = true;
        L(false);
        c0();
        Object obj = this.f439d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.h.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a D0 = D0();
                if (D0 == null) {
                    this.W = true;
                } else {
                    D0.s(true);
                }
            }
            androidx.appcompat.app.f.c(this);
        }
        this.M = new Configuration(this.f440e.getResources().getConfiguration());
        this.K = true;
    }

    boolean t0() {
        i.b bVar = this.f454o;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a p10 = p();
        return p10 != null && p10.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // androidx.appcompat.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u() {
        androidx.appcompat.app.a aVar;
        if (this.f439d instanceof Activity) {
            androidx.appcompat.app.f.A(this);
        }
        if (this.T) {
            this.f441f.getDecorView().removeCallbacks(this.V);
        }
        this.L = true;
        if (this.N != -100) {
            Object obj = this.f439d;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f433n0.put(this.f439d.getClass().getName(), Integer.valueOf(this.N));
                aVar = this.f444i;
                if (aVar != null) {
                    aVar.o();
                }
                R();
            }
        }
        f433n0.remove(this.f439d.getClass().getName());
        aVar = this.f444i;
        if (aVar != null) {
        }
        R();
    }

    boolean u0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.I = z10;
        } else if (i10 == 82) {
            v0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void v(Bundle bundle) {
        b0();
    }

    @Override // androidx.appcompat.app.f
    public void w() {
        androidx.appcompat.app.a p10 = p();
        if (p10 != null) {
            p10.y(true);
        }
    }

    boolean w0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a p10 = p();
        if (p10 != null && p10.p(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.H;
        if (panelFeatureState == null || !E0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.H == null) {
                PanelFeatureState i02 = i0(0, true);
                F0(i02, keyEvent);
                boolean E0 = E0(i02, keyEvent.getKeyCode(), keyEvent, 1);
                i02.f478m = false;
                if (E0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.H;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f479n = true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.f
    public void x(Bundle bundle) {
    }

    boolean x0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.I;
            this.I = false;
            PanelFeatureState i02 = i0(0, false);
            if (i02 != null && i02.f480o) {
                if (!z10) {
                    T(i02, true);
                }
                return true;
            } else if (t0()) {
                return true;
            }
        } else if (i10 == 82) {
            y0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void y() {
        e();
    }

    @Override // androidx.appcompat.app.f
    public void z() {
        androidx.appcompat.app.a p10 = p();
        if (p10 != null) {
            p10.y(false);
        }
    }

    void z0(int i10) {
        androidx.appcompat.app.a p10;
        if (i10 == 108 && (p10 = p()) != null) {
            p10.i(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        androidx.collection.f<String, Integer> fVar;
        Integer num;
        androidx.appcompat.app.d M0;
        this.f458s = null;
        this.f459t = true;
        this.N = -100;
        this.V = new b();
        this.f440e = context;
        this.f443h = eVar;
        this.f439d = obj;
        if (this.N == -100 && (obj instanceof Dialog) && (M0 = M0()) != null) {
            this.N = M0.getDelegate().n();
        }
        if (this.N == -100 && (num = (fVar = f433n0).get(obj.getClass().getName())) != null) {
            this.N = num.intValue();
            fVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            N(window);
        }
        androidx.appcompat.widget.j.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends i.i {

        /* renamed from: b  reason: collision with root package name */
        private i f501b;

        p(Window.Callback callback) {
            super(callback);
        }

        void b(i iVar) {
            this.f501b = iVar;
        }

        final ActionMode c(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f440e, callback);
            i.b K = AppCompatDelegateImpl.this.K(aVar);
            if (K != null) {
                return aVar.e(K);
            }
            return null;
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.Y(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.w0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // i.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            i iVar = this.f501b;
            return (iVar == null || (onCreatePanelView = iVar.onCreatePanelView(i10)) == null) ? super.onCreatePanelView(i10) : onCreatePanelView;
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.z0(i10);
            return true;
        }

        @Override // i.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImpl.this.A0(i10);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            boolean z10 = true;
            if (eVar != null) {
                eVar.e0(true);
            }
            i iVar = this.f501b;
            if (iVar == null || !iVar.a(i10)) {
                z10 = false;
            }
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (eVar != null) {
                eVar.e0(false);
            }
            return z10;
        }

        @Override // i.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState i02 = AppCompatDelegateImpl.this.i0(0, true);
            if (i02 == null || (eVar = i02.f475j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        @Override // i.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.r0()) {
                return c(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // i.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (!AppCompatDelegateImpl.this.r0() || i10 != 0) {
                return super.onWindowStartingActionMode(callback, i10);
            }
            return c(callback);
        }
    }
}
