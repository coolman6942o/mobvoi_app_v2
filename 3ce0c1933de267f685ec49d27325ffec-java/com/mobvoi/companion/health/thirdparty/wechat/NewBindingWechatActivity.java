package com.mobvoi.companion.health.thirdparty.wechat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import ce.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.setting.CompanionSetting;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import io.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import zd.a;
/* compiled from: NewBindingWechatActivity.kt */
/* loaded from: classes2.dex */
public final class NewBindingWechatActivity extends com.mobvoi.companion.base.m3.d {

    /* renamed from: h  reason: collision with root package name */
    public static final a f17066h = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final io.d f17067a;

    /* renamed from: b  reason: collision with root package name */
    private String f17068b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f17069c;

    /* renamed from: d  reason: collision with root package name */
    private final io.d f17070d;

    /* renamed from: e  reason: collision with root package name */
    private final io.d f17071e;

    /* renamed from: f  reason: collision with root package name */
    private final io.d f17072f;

    /* renamed from: g  reason: collision with root package name */
    private dq.b f17073g;

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Context context, String str, String deviceId, String deviceModel) {
            i.f(context, "context");
            i.f(deviceId, "deviceId");
            i.f(deviceModel, "deviceModel");
            Intent intent = new Intent(context, NewBindingWechatActivity.class);
            intent.putExtra("deviceId", deviceId);
            intent.putExtra("deviceModel", deviceModel);
            intent.putExtra("sdkID", str);
            intent.addFlags(268435456);
            m mVar = m.f28349a;
            context.startActivity(intent);
        }
    }

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<com.mobvoi.companion.health.thirdparty.wechat.b> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final com.mobvoi.companion.health.thirdparty.wechat.b invoke() {
            return (com.mobvoi.companion.health.thirdparty.wechat.b) new com.google.gson.e().j(CompanionSetting.getBindWechatConfig(), com.mobvoi.companion.health.thirdparty.wechat.b.class);
        }
    }

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<de.a> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final de.a invoke() {
            return de.a.d(NewBindingWechatActivity.this.getLayoutInflater());
        }
    }

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<String> {
        d() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            return NewBindingWechatActivity.this.getIntent().getStringExtra("deviceModel");
        }
    }

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<String> {
        e() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            return NewBindingWechatActivity.this.getIntent().getStringExtra("deviceId");
        }
    }

    /* compiled from: NewBindingWechatActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements qo.a<zd.a> {

        /* compiled from: NewBindingWechatActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements a.AbstractC0547a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NewBindingWechatActivity f17074a;

            a(NewBindingWechatActivity newBindingWechatActivity) {
                this.f17074a = newBindingWechatActivity;
            }

            @Override // zd.a.AbstractC0547a
            public void a() {
                this.f17074a.j0();
            }

            @Override // zd.a.AbstractC0547a
            public void onCancel() {
            }
        }

        f() {
            super(0);
        }

        /* renamed from: a */
        public final zd.a invoke() {
            zd.a aVar = new zd.a(NewBindingWechatActivity.this);
            NewBindingWechatActivity newBindingWechatActivity = NewBindingWechatActivity.this;
            aVar.d(newBindingWechatActivity.getString(h.f5853j0));
            aVar.b(newBindingWechatActivity.getString(h.f5844f), newBindingWechatActivity.getString(h.f5847g0));
            aVar.c(new a(newBindingWechatActivity));
            return aVar;
        }
    }

    public NewBindingWechatActivity() {
        io.d a10;
        io.d a11;
        io.d a12;
        io.d a13;
        io.d a14;
        a10 = io.f.a(new c());
        this.f17067a = a10;
        a11 = io.f.a(new e());
        this.f17069c = a11;
        a12 = io.f.a(new d());
        this.f17070d = a12;
        a13 = io.f.a(b.INSTANCE);
        this.f17071e = a13;
        a14 = io.f.a(new f());
        this.f17072f = a14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(View view) {
        dq.b bVar;
        if (T() && (bVar = this.f17073g) != null) {
            bVar.a(x.b(ta.a.x(), X(), W()).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.q
                @Override // yp.b
                public final void call(Object obj) {
                    NewBindingWechatActivity.Q(NewBindingWechatActivity.this, (f) obj);
                }
            }, new yp.b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.r
                @Override // yp.b
                public final void call(Object obj) {
                    NewBindingWechatActivity.S(NewBindingWechatActivity.this, (Throwable) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(NewBindingWechatActivity this$0, com.mobvoi.companion.health.thirdparty.wechat.f fVar) {
        i.f(this$0, "this$0");
        if (fVar.a() == 0) {
            this$0.i0(fVar.c());
        } else {
            this$0.g0(fVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(NewBindingWechatActivity this$0, Throwable th2) {
        i.f(this$0, "this$0");
        h0(this$0, null, 1, null);
    }

    private final boolean T() {
        if (e0()) {
            return true;
        }
        Toast.makeText(this, h.f5845f0, 0).show();
        return false;
    }

    private final com.mobvoi.companion.health.thirdparty.wechat.b U() {
        return (com.mobvoi.companion.health.thirdparty.wechat.b) this.f17071e.getValue();
    }

    private final de.a V() {
        return (de.a) this.f17067a.getValue();
    }

    private final String W() {
        return (String) this.f17070d.getValue();
    }

    private final String X() {
        return (String) this.f17069c.getValue();
    }

    private final void Y() {
        List l10;
        l10 = kotlin.collections.m.l(X());
        dq.b bVar = this.f17073g;
        if (bVar != null) {
            bVar.a(x.c(ta.a.x(), l10).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.p
                @Override // yp.b
                public final void call(Object obj) {
                    NewBindingWechatActivity.Z(NewBindingWechatActivity.this, (d) obj);
                }
            }, s.f17087a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(NewBindingWechatActivity this$0, com.mobvoi.companion.health.thirdparty.wechat.d dVar) {
        boolean z10;
        i.f(this$0, "this$0");
        int a10 = dVar.a();
        List<com.mobvoi.companion.health.thirdparty.wechat.a> b10 = dVar.b();
        if (a10 == 0 && b10 != null && b10.size() > 0) {
            Object obj = null;
            this$0.f17068b = null;
            Iterator<T> it = b10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                com.mobvoi.companion.health.thirdparty.wechat.a aVar = (com.mobvoi.companion.health.thirdparty.wechat.a) next;
                if (!i.b(aVar.b(), this$0.X()) || !aVar.a()) {
                    z10 = false;
                    continue;
                } else {
                    z10 = true;
                    continue;
                }
                if (z10) {
                    obj = next;
                    break;
                }
            }
            com.mobvoi.companion.health.thirdparty.wechat.a aVar2 = (com.mobvoi.companion.health.thirdparty.wechat.a) obj;
            if (aVar2 != null) {
                this$0.f17068b = aVar2.c();
            }
            this$0.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Throwable th2) {
    }

    private final zd.a b0() {
        return (zd.a) this.f17072f.getValue();
    }

    private final void c0() {
        if (!TextUtils.isEmpty(this.f17068b)) {
            V().f25610c.setText(getString(h.f5835a0));
            TextView textView = V().f25610c;
            i.e(textView, "binding.tvState");
            f0(this, textView, ce.d.f5754b);
            V().f25609b.setText(getString(h.f5849h0));
            V().f25609b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.thirdparty.wechat.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewBindingWechatActivity.this.k0(view);
                }
            });
            return;
        }
        V().f25610c.setText(getString(h.f5851i0));
        TextView textView2 = V().f25610c;
        i.e(textView2, "binding.tvState");
        f0(this, textView2, ce.d.f5757e);
        V().f25609b.setText(getString(h.Z));
        V().f25609b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.thirdparty.wechat.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewBindingWechatActivity.this.O(view);
            }
        });
    }

    private final void d0() {
        setTitle("");
    }

    private final boolean e0() {
        PackageManager packageManager = getPackageManager();
        i.e(packageManager, "packageManager");
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        i.e(installedPackages, "packageManager.getInstalledPackages(0)");
        int size = installedPackages.size() - 1;
        if (size >= 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i.b(installedPackages.get(i10).packageName, "com.tencent.mm")) {
                    return true;
                }
                if (i11 > size) {
                    break;
                }
                i10 = i11;
            }
        }
        return false;
    }

    public static /* synthetic */ void h0(NewBindingWechatActivity newBindingWechatActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        newBindingWechatActivity.g0(str);
    }

    private final void i0(String str) {
        String z10;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, AccountConstant.e());
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = U().e();
        z10 = t.z(U().a(), U().c(), str, false, 4, null);
        req.path = z10;
        req.miniprogramType = U().b();
        k.c("NewBindingWechat", "bind wx type %s", U());
        createWXAPI.sendReq(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        String z10;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, AccountConstant.e());
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = U().e();
        z10 = t.z(U().d(), U().c(), "[\"" + ((Object) this.f17068b) + "\"]", false, 4, null);
        req.path = z10;
        req.miniprogramType = U().b();
        createWXAPI.sendReq(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(View view) {
        if (T()) {
            b0().show();
        }
    }

    public final void f0(Context context, TextView attention, int i10) {
        i.f(context, "context");
        i.f(attention, "attention");
        Drawable drawable = context.getResources().getDrawable(i10, null);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        attention.setCompoundDrawables(drawable, null, null, null);
    }

    public final void g0(String str) {
        View inflate = LayoutInflater.from(this).inflate(ce.f.f5826t, (ViewGroup) null);
        i.e(inflate, "from(this).inflate(R.layout.view_toast_custom_bind_error, null)");
        if (str != null) {
            ((TextView) inflate.findViewById(ce.e.F)).setText(str);
        }
        Toast toast = new Toast(this);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(V().a());
        this.f17073g = new dq.b();
        this.f17068b = getIntent().getStringExtra("sdkID");
        d0();
        c0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dq.b bVar = this.f17073g;
        if (bVar != null) {
            bVar.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        Y();
    }
}
