package com.mobvoi.mcuwatch.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.w;
import com.mobvoi.mcuwatch.welcome.fragment.n;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
import wi.d;
import zh.l;
/* compiled from: WelcomeActivity.kt */
/* loaded from: classes2.dex */
public final class WelcomeActivity extends d<l> {

    /* renamed from: d  reason: collision with root package name */
    private n f20284d;

    /* renamed from: e  reason: collision with root package name */
    private n f20285e;

    /* renamed from: f  reason: collision with root package name */
    private n f20286f;

    /* renamed from: g  reason: collision with root package name */
    private n f20287g;

    /* compiled from: WelcomeActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements qo.l<LayoutInflater, l> {
        public static final a INSTANCE = new a();

        a() {
            super(1, l.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityWelcomeBinding;", 0);
        }

        /* renamed from: g */
        public final l invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return l.d(p02);
        }
    }

    /* compiled from: WelcomeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        new b(null);
    }

    public WelcomeActivity() {
        super(a.INSTANCE);
    }

    private final void S() {
        w l10 = getSupportFragmentManager().l();
        i.e(l10, "supportFragmentManager.beginTransaction()");
        n nVar = this.f20284d;
        if (nVar != null) {
            l10.q(nVar);
        }
        n nVar2 = this.f20285e;
        if (nVar2 != null) {
            l10.q(nVar2);
        }
        n nVar3 = this.f20286f;
        if (nVar3 != null) {
            l10.q(nVar3);
        }
        n nVar4 = this.f20287g;
        if (nVar4 != null) {
            l10.q(nVar4);
        }
        l10.j();
    }

    private final void U(int i10) {
        int childCount = H().f37557b.getChildCount();
        if (childCount > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                H().f37557b.getChildAt(i11).setSelected(i11 <= i10);
                if (i12 >= childCount) {
                    break;
                }
                i11 = i12;
            }
        }
        S();
        w l10 = getSupportFragmentManager().l();
        i.e(l10, "supportFragmentManager.beginTransaction()");
        if (i10 == 0) {
            if (this.f20284d == null) {
                n a10 = n.f20323l.a(0);
                this.f20284d = a10;
                int i13 = h.f34611a1;
                i.d(a10);
                l10.b(i13, a10);
            }
            n nVar = this.f20284d;
            i.d(nVar);
            l10.z(nVar);
        } else if (i10 == 1) {
            if (this.f20285e == null) {
                n a11 = n.f20323l.a(1);
                this.f20285e = a11;
                int i14 = h.f34611a1;
                i.d(a11);
                l10.b(i14, a11);
            }
            n nVar2 = this.f20285e;
            i.d(nVar2);
            l10.z(nVar2);
        } else if (i10 == 2) {
            if (this.f20286f == null) {
                n a12 = n.f20323l.a(2);
                this.f20286f = a12;
                int i15 = h.f34611a1;
                i.d(a12);
                l10.b(i15, a12);
            }
            n nVar3 = this.f20286f;
            i.d(nVar3);
            l10.z(nVar3);
        } else if (i10 == 3) {
            if (this.f20287g == null) {
                n a13 = n.f20323l.a(3);
                this.f20287g = a13;
                int i16 = h.f34611a1;
                i.d(a13);
                l10.b(i16, a13);
            }
            n nVar4 = this.f20287g;
            i.d(nVar4);
            l10.z(nVar4);
        }
        l10.j();
    }

    @Override // wi.d
    protected boolean J() {
        return true;
    }

    public final void Q(int i10) {
        if (i10 == 4) {
            InitialQuestionsActivity.f20267r.a(this);
            finish();
            return;
        }
        U(i10);
    }

    public final void T() {
    }

    public final void initView() {
        Toolbar toolbar = (Toolbar) findViewById(h.I0);
        toolbar.setNavigationIcon(sh.f.f34586t);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        Q(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.d, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T();
        initView();
    }
}
