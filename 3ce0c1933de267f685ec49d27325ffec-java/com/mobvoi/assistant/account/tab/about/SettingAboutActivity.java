package com.mobvoi.assistant.account.tab.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobvoi.assistant.account.tab.about.SettingAboutActivity;
import com.mobvoi.companion.base.m3.e;
import kc.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import lb.c;
import za.g;
import za.j;
/* compiled from: SettingAboutActivity.kt */
/* loaded from: classes2.dex */
public final class SettingAboutActivity extends e<nb.a> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f15647c = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private g f15648b;

    /* compiled from: SettingAboutActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, SettingAboutActivity.class));
        }
    }

    private final void S() {
        Intent intent = new Intent("com.mobvoi.companion.ESIM_DEBUG");
        intent.setPackage(getPackageName());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        i.f(view, "view");
        this$0.Y(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        i.f(view, "view");
        this$0.a0(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        i.f(view, "view");
        this$0.c0(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        i.f(view, "view");
        this$0.b0(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        i.f(view, "view");
        this$0.Z(view);
    }

    private final void Y(View view) {
        g gVar = this.f15648b;
        if (gVar != null) {
            gVar.g();
        } else {
            i.u("mSettingAction");
            throw null;
        }
    }

    private final void Z(View view) {
        g gVar = this.f15648b;
        if (gVar != null) {
            gVar.i();
        } else {
            i.u("mSettingAction");
            throw null;
        }
    }

    private final void a0(View view) {
        g gVar = this.f15648b;
        if (gVar != null) {
            gVar.h();
        } else {
            i.u("mSettingAction");
            throw null;
        }
    }

    private final void b0(View view) {
        g gVar = this.f15648b;
        if (gVar != null) {
            gVar.c();
        } else {
            i.u("mSettingAction");
            throw null;
        }
    }

    private final void c0(View view) {
        g gVar = this.f15648b;
        if (gVar != null) {
            gVar.l();
        } else {
            i.u("mSettingAction");
            throw null;
        }
    }

    private final void d0(String str, String str2) {
        new gb.e(this, str, str2).show();
    }

    private final void e0() {
        Intent intent = new Intent("com.mobvoi.companion.action.DEVELOP_MODE");
        intent.setPackage(getPackageName());
        startActivity(intent);
    }

    private final void f0(String str) {
        sb.a.d(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(SettingAboutActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.e0();
    }

    private final void initView() {
        setTitle(mb.g.f30633a);
        if (TextUtils.isEmpty(com.mobvoi.companion.base.settings.a.getVersionName())) {
            ((nb.a) I()).f31087m.setVisibility(8);
        } else {
            ((nb.a) I()).f31087m.setText(getString(mb.g.h_res_0x7f14031f, new Object[]{com.mobvoi.companion.base.settings.a.getVersionName()}));
        }
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            ((nb.a) I()).f31089o.setVisibility(0);
            ((nb.a) I()).f31080f.setVisibility(8);
            ((nb.a) I()).f31079e.setVisibility(8);
            g0();
            if (c.d()) {
                ((nb.a) I()).f31083i.setVisibility(0);
                ((nb.a) I()).f31082h.setVisibility(0);
            } else {
                ((nb.a) I()).f31083i.setVisibility(8);
                ((nb.a) I()).f31082h.setVisibility(8);
            }
            ((nb.a) I()).f31087m.setOnClickListener(new View.OnClickListener() { // from class: za.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.T(SettingAboutActivity.this, view);
                }
            });
            ((nb.a) I()).f31091q.setOnClickListener(new View.OnClickListener() { // from class: za.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.U(SettingAboutActivity.this, view);
                }
            });
            ((nb.a) I()).f31094t.setOnClickListener(new View.OnClickListener() { // from class: za.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.V(SettingAboutActivity.this, view);
                }
            });
            ((nb.a) I()).f31093s.setOnClickListener(new View.OnClickListener() { // from class: za.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.W(SettingAboutActivity.this, view);
                }
            });
            ((nb.a) I()).f31083i.setOnClickListener(new View.OnClickListener() { // from class: za.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.X(SettingAboutActivity.this, view);
                }
            });
            return;
        }
        ((nb.a) I()).f31089o.setVisibility(8);
        ((nb.a) I()).f31080f.setVisibility(0);
        ((nb.a) I()).f31079e.setVisibility(0);
        String d10 = ((db.e) b.b().a(db.e.class)).d();
        if (TextUtils.isEmpty(d10)) {
            ((nb.a) I()).f31077c.setVisibility(8);
            ((nb.a) I()).f31088n.setText("");
        } else {
            ((nb.a) I()).f31077c.setVisibility(0);
            ((nb.a) I()).f31088n.setText(getString(mb.g.b_res_0x7f140023, new Object[]{d10}));
        }
        ((nb.a) I()).f31086l.setOnClickListener(this);
        ((nb.a) I()).f31076b.setOnClickListener(this);
        ((nb.a) I()).f31084j.setOnClickListener(this);
        ((nb.a) I()).f31092r.setOnClickListener(this);
        ((nb.a) I()).f31095u.setOnClickListener(this);
        ((nb.a) I()).f31097w.setOnClickListener(this);
        ((nb.a) I()).f31098x.setOnClickListener(this);
        ((nb.a) I()).f31096v.setOnClickListener(this);
        ((nb.a) I()).f31090p.setOnClickListener(this);
        ((nb.a) I()).f31078d.setOnClickListener(this);
        ((nb.a) I()).f31085k.setOnClickListener(this);
    }

    public static final void start(Context context) {
        f15647c.a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Q */
    public nb.a H(LayoutInflater inflater, ViewGroup parent) {
        i.f(inflater, "inflater");
        i.f(parent, "parent");
        nb.a d10 = nb.a.d(inflater, parent, false);
        i.e(d10, "inflate(inflater, parent, false)");
        return d10;
    }

    public final void g0() {
        if (com.mobvoi.companion.base.settings.a.isDevelopMode(this)) {
            I().f31081g.setVisibility(0);
            I().f31081g.setOnClickListener(new View.OnClickListener() { // from class: za.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingAboutActivity.h0(SettingAboutActivity.this, view);
                }
            });
            return;
        }
        I().f31081g.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == mb.c.D_res_0x7f0b04cf) {
            g gVar = this.f15648b;
            if (gVar != null) {
                gVar.e();
                f0("new_feature_about");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.b_res_0x7f0b001e) {
            g gVar2 = this.f15648b;
            if (gVar2 != null) {
                gVar2.j();
                f0("check_update");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.f30626p) {
            g gVar3 = this.f15648b;
            if (gVar3 != null) {
                gVar3.f();
                f0("feed_back_about");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.V_res_0x7f0b05db) {
            g gVar4 = this.f15648b;
            if (gVar4 != null) {
                gVar4.b();
                f0("make_score");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.s0_res_0x7f0b08b8) {
            g gVar5 = this.f15648b;
            if (gVar5 != null) {
                gVar5.d();
                f0("forward_wechat");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.u0_res_0x7f0b08c4) {
            g gVar6 = this.f15648b;
            if (gVar6 != null) {
                gVar6.k();
                f0("forward_weibo");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.f30629r0) {
            String string = getString(pa.i.f32691a0);
            i.e(string, "getString(com.mobvoi.assistant.account.R.string.user_agreement)");
            d0("https://developer.chumenwenwen.com/agreement/", string);
        } else if (id2 == mb.c.K_res_0x7f0b0556) {
            String string2 = getString(pa.i.M);
            i.e(string2, "getString(com.mobvoi.assistant.account.R.string.privacy_policy)");
            d0("https://www.chumenwenwen.com/privacy-policy.html", string2);
        } else if (id2 == mb.c.g_res_0x7f0b018b) {
            String string3 = getString(pa.i.f32715y);
            i.e(string3, "getString(com.mobvoi.assistant.account.R.string.kid_privacy_policy)");
            d0("https://activities.chumenwenwen.com/vpa/tickids/privacy-policy/index.html", string3);
        } else if (id2 == mb.c.d0_res_0x7f0b0758) {
            g gVar7 = this.f15648b;
            if (gVar7 != null) {
                gVar7.a();
                f0("forward_weibo");
                return;
            }
            i.u("mSettingAction");
            throw null;
        } else if (id2 == mb.c.A) {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15648b = new j(this);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        g0();
    }
}
