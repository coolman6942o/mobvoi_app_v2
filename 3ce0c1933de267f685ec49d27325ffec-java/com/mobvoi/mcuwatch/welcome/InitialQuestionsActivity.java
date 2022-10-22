package com.mobvoi.mcuwatch.welcome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.w;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.mcuwatch.welcome.fragment.g;
import com.mobvoi.mcuwatch.welcome.fragment.i;
import com.mobvoi.mcuwatch.welcome.fragment.l;
import com.unionpay.tsmservice.mi.data.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.text.t;
import rx.j;
import sa.c;
import wi.d;
import zh.h;
/* compiled from: InitialQuestionsActivity.kt */
/* loaded from: classes2.dex */
public final class InitialQuestionsActivity extends d<h> {

    /* renamed from: r  reason: collision with root package name */
    public static final b f20267r = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private final io.d f20268d;

    /* renamed from: e  reason: collision with root package name */
    private i f20269e;

    /* renamed from: f  reason: collision with root package name */
    private com.mobvoi.mcuwatch.welcome.fragment.d f20270f;

    /* renamed from: g  reason: collision with root package name */
    private com.mobvoi.mcuwatch.welcome.fragment.b f20271g;

    /* renamed from: h  reason: collision with root package name */
    private g f20272h;

    /* renamed from: i  reason: collision with root package name */
    private l f20273i;

    /* renamed from: j  reason: collision with root package name */
    private String f20274j = "";

    /* renamed from: k  reason: collision with root package name */
    private int f20275k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f20276l = -1;

    /* renamed from: m  reason: collision with root package name */
    private String f20277m = "";

    /* renamed from: n  reason: collision with root package name */
    private long f20278n;

    /* renamed from: o  reason: collision with root package name */
    private int f20279o;

    /* renamed from: p  reason: collision with root package name */
    private int f20280p;

    /* renamed from: q  reason: collision with root package name */
    private j f20281q;

    /* compiled from: InitialQuestionsActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements qo.l<LayoutInflater, h> {
        public static final a INSTANCE = new a();

        a() {
            super(1, h.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityInitialQuestionsBinding;", 0);
        }

        /* renamed from: g */
        public final h invoke(LayoutInflater p02) {
            kotlin.jvm.internal.i.f(p02, "p0");
            return h.d(p02);
        }
    }

    /* compiled from: InitialQuestionsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            context.startActivity(new Intent(context, InitialQuestionsActivity.class));
        }
    }

    /* compiled from: InitialQuestionsActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<InitialQuestionsActivity> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final InitialQuestionsActivity invoke() {
            return InitialQuestionsActivity.this;
        }
    }

    public InitialQuestionsActivity() {
        super(a.INSTANCE);
        io.d a10;
        a10 = io.f.a(new c());
        this.f20268d = a10;
    }

    private final void a0(boolean z10) {
        if (z10) {
            ta.a.T(this.f20274j);
            s0(1);
            return;
        }
        SetUpCompleteActivity.f20282e.a(this);
        finish();
    }

    private final void b0() {
        w l10 = getSupportFragmentManager().l();
        kotlin.jvm.internal.i.e(l10, "supportFragmentManager.beginTransaction()");
        i iVar = this.f20269e;
        if (iVar != null) {
            l10.q(iVar);
        }
        com.mobvoi.mcuwatch.welcome.fragment.d dVar = this.f20270f;
        if (dVar != null) {
            l10.q(dVar);
        }
        com.mobvoi.mcuwatch.welcome.fragment.b bVar = this.f20271g;
        if (bVar != null) {
            l10.q(bVar);
        }
        g gVar = this.f20272h;
        if (gVar != null) {
            l10.q(gVar);
        }
        l lVar = this.f20273i;
        if (lVar != null) {
            l10.q(lVar);
        }
        l10.j();
    }

    private final void e0() {
        h0(true);
    }

    private final void f0() {
        ta.a.Z(this.f20276l);
        ta.a.F(this.f20277m);
        ta.a.N(String.valueOf(this.f20279o));
        ta.a.c0(String.valueOf(this.f20280p));
    }

    private final void g0() {
        ig.b.J().n(DataType.InfoGender, this.f20275k);
        ig.b.J().n(DataType.InfoBirthday, (float) this.f20278n);
        ig.b.J().n(DataType.InfoHeight, this.f20279o);
        ig.b.J().n(DataType.InfoWeight, this.f20280p);
        ig.b.J().A();
    }

    private final void h0(final boolean z10) {
        sa.a e10 = ta.a.e();
        e10.nickName = this.f20274j;
        this.f20281q = ra.h.b().e(e10).Z(ra.h.a().b()).H(ra.h.a().a()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.welcome.b
            @Override // yp.b
            public final void call(Object obj) {
                InitialQuestionsActivity.i0(InitialQuestionsActivity.this, z10, (c) obj);
            }
        }, new yp.b() { // from class: com.mobvoi.mcuwatch.welcome.a
            @Override // yp.b
            public final void call(Object obj) {
                InitialQuestionsActivity.j0(InitialQuestionsActivity.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(InitialQuestionsActivity this$0, boolean z10, sa.c commonResponse) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(commonResponse, "commonResponse");
        if (commonResponse.b()) {
            k.a("InitialQuestionsActivity", "sendToServer success");
            this$0.a0(z10);
        } else if (commonResponse.errorCode == 100006) {
            this$0.N(sh.k.L1);
        } else {
            this$0.N(sh.k.f34798f0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(InitialQuestionsActivity this$0, Throwable th2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        k.e("InitialQuestionsActivity", "sendToServer error", th2);
        this$0.N(sh.k.f34798f0);
    }

    private final void k0() {
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_GOAL");
        intent.putExtra("gender", this.f20275k);
        intent.putExtra(Constant.KEY_HEIGHT, this.f20279o);
        intent.putExtra("weight", this.f20280p);
        intent.putExtra("age", U(this.f20277m));
        sendBroadcast(intent);
    }

    private final void s0(int i10) {
        int childCount = H().f37539b.getChildCount();
        if (childCount > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                H().f37539b.getChildAt(i11).setSelected(i11 <= i10);
                if (i12 >= childCount) {
                    break;
                }
                i11 = i12;
            }
        }
        b0();
        w l10 = getSupportFragmentManager().l();
        kotlin.jvm.internal.i.e(l10, "supportFragmentManager.beginTransaction()");
        if (i10 == 0) {
            if (this.f20269e == null) {
                i a10 = i.f20311d.a();
                this.f20269e = a10;
                int i13 = sh.h.f34611a1;
                kotlin.jvm.internal.i.d(a10);
                l10.b(i13, a10);
            }
            i iVar = this.f20269e;
            kotlin.jvm.internal.i.d(iVar);
            l10.z(iVar);
        } else if (i10 == 1) {
            if (this.f20270f == null) {
                com.mobvoi.mcuwatch.welcome.fragment.d a11 = com.mobvoi.mcuwatch.welcome.fragment.d.f20300d.a();
                this.f20270f = a11;
                int i14 = sh.h.f34611a1;
                kotlin.jvm.internal.i.d(a11);
                l10.b(i14, a11);
            }
            com.mobvoi.mcuwatch.welcome.fragment.d dVar = this.f20270f;
            kotlin.jvm.internal.i.d(dVar);
            l10.z(dVar);
        } else if (i10 == 2) {
            if (this.f20271g == null) {
                com.mobvoi.mcuwatch.welcome.fragment.b a12 = com.mobvoi.mcuwatch.welcome.fragment.b.f20293g.a();
                this.f20271g = a12;
                int i15 = sh.h.f34611a1;
                kotlin.jvm.internal.i.d(a12);
                l10.b(i15, a12);
            }
            com.mobvoi.mcuwatch.welcome.fragment.b bVar = this.f20271g;
            kotlin.jvm.internal.i.d(bVar);
            l10.z(bVar);
        } else if (i10 == 3) {
            if (this.f20272h == null) {
                g a13 = g.f20305f.a();
                this.f20272h = a13;
                int i16 = sh.h.f34611a1;
                kotlin.jvm.internal.i.d(a13);
                l10.b(i16, a13);
            }
            g gVar = this.f20272h;
            kotlin.jvm.internal.i.d(gVar);
            l10.z(gVar);
        } else if (i10 == 4) {
            if (this.f20273i == null) {
                l a14 = l.f20316f.a();
                this.f20273i = a14;
                int i17 = sh.h.f34611a1;
                kotlin.jvm.internal.i.d(a14);
                l10.b(i17, a14);
            }
            l lVar = this.f20273i;
            kotlin.jvm.internal.i.d(lVar);
            l10.z(lVar);
        }
        l10.j();
    }

    @Override // wi.d
    protected boolean J() {
        return true;
    }

    public final void T(int i10) {
        if (i10 == 1) {
            e0();
        } else {
            s0(i10);
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public final int U(String birthday) {
        String z10;
        String z11;
        String z12;
        String z13;
        String z14;
        String z15;
        kotlin.jvm.internal.i.f(birthday, "birthday");
        try {
            int length = birthday.length() - 1;
            int i10 = 0;
            boolean z16 = false;
            while (i10 <= length) {
                boolean z17 = kotlin.jvm.internal.i.h(birthday.charAt(!z16 ? i10 : length), 32) <= 0;
                if (!z16) {
                    if (!z17) {
                        z16 = true;
                    } else {
                        i10++;
                    }
                } else if (!z17) {
                    break;
                } else {
                    length--;
                }
            }
            z10 = t.z(birthday.subSequence(i10, length + 1).toString(), "-", "", false, 4, null);
            z11 = t.z(z10, " ", "", false, 4, null);
            z12 = t.z(z11, "_", "", false, 4, null);
            z13 = t.z(z12, "/", "", false, 4, null);
            z14 = t.z(z13, ".", "", false, 4, null);
            z15 = t.z(z14, "\\", "", false, 4, null);
            if (z15 != null) {
                String substring = z15.substring(0, 8);
                kotlin.jvm.internal.i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                long time = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).parse(substring).getTime();
                long time2 = new Date().getTime();
                if (time2 <= time) {
                    return 0;
                }
                long j10 = (time2 - time) / 1000;
                long j11 = 60;
                return (int) ((((j10 / j11) / j11) / 24) / 365);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (ParseException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public final String V() {
        return this.f20277m;
    }

    public final int W() {
        return this.f20275k;
    }

    public final int X() {
        return this.f20279o;
    }

    public final String Y() {
        return this.f20274j;
    }

    public final int Z() {
        return this.f20280p;
    }

    public final void c0() {
        int b10;
        int b11;
        String nickName = ta.a.n();
        int t10 = ta.a.t();
        String birthday = ta.a.f();
        String height = ta.a.k();
        String weight = ta.a.w();
        if (!TextUtils.isEmpty(nickName)) {
            kotlin.jvm.internal.i.e(nickName, "nickName");
            this.f20274j = nickName;
        }
        this.f20275k = t10 == AccountConstant.Sex.FEMALE.ordinal() ? 0 : 1;
        this.f20276l = t10;
        if (!TextUtils.isEmpty(birthday)) {
            kotlin.jvm.internal.i.e(birthday, "birthday");
            this.f20277m = birthday;
        }
        if (!TextUtils.isEmpty(height)) {
            kotlin.jvm.internal.i.e(height, "height");
            b11 = so.c.b(Float.parseFloat(height));
            this.f20279o = b11;
        }
        if (!TextUtils.isEmpty(weight)) {
            kotlin.jvm.internal.i.e(weight, "weight");
            b10 = so.c.b(Float.parseFloat(weight));
            this.f20280p = b10;
        }
        k.a("InitialQuestionsActivity", "name:" + this.f20274j + " sex:" + t10 + " birthday:" + this.f20277m + " height:" + this.f20279o + " weight:" + this.f20280p);
    }

    public final void d0() {
        f0();
        g0();
        k0();
        h0(false);
    }

    public final void initView() {
        Toolbar toolbar = (Toolbar) findViewById(sh.h.I0);
        toolbar.setNavigationIcon(sh.f.f34586t);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        T(0);
        H().f37539b.getChildAt(0).setSelected(true);
    }

    public final void l0(long j10) {
        this.f20278n = j10;
    }

    public final void m0(String str) {
        kotlin.jvm.internal.i.f(str, "<set-?>");
        this.f20277m = str;
    }

    public final void n0(int i10) {
        this.f20275k = i10;
    }

    public final void o0(int i10) {
        this.f20279o = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.d, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c0();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        j jVar = this.f20281q;
        if (jVar != null) {
            jVar.unsubscribe();
        }
        super.onDestroy();
    }

    public final void p0(String str) {
        kotlin.jvm.internal.i.f(str, "<set-?>");
        this.f20274j = str;
    }

    public final void q0(int i10) {
        this.f20276l = i10;
    }

    public final void r0(int i10) {
        this.f20280p = i10;
    }
}
