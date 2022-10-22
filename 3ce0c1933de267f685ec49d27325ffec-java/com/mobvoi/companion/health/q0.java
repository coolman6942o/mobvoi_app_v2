package com.mobvoi.companion.health;

import ah.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewGroup;
import cd.g;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.health.thirdparty.wechat.x;
import com.mobvoi.companion.map.i;
import com.mobvoi.health.companion.system.WearDevices;
import com.mobvoi.health.companion.system.b;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ra.h;
import sa.c;
/* compiled from: HealthClientImpl.java */
/* loaded from: classes2.dex */
public class q0 implements com.mobvoi.health.companion.system.a, ah.b, MessageProxyListener, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16926a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16927b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f16928c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f16929d = "";

    /* renamed from: e  reason: collision with root package name */
    private boolean f16930e = false;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<b.c>> f16931f = new HashMap(2);

    /* renamed from: g  reason: collision with root package name */
    private final List<b.a> f16932g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<a4> f16933h = new ArrayList();

    /* compiled from: HealthClientImpl.java */
    /* loaded from: classes2.dex */
    class a implements yp.b<c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f16934a;

        a(q0 q0Var, b.a aVar) {
            this.f16934a = aVar;
        }

        /* renamed from: a */
        public void call(c cVar) {
            b.a aVar = this.f16934a;
            if (aVar != null) {
                aVar.a(Boolean.valueOf(cVar.b()));
            }
        }
    }

    /* compiled from: HealthClientImpl.java */
    /* loaded from: classes2.dex */
    class b implements yp.b<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a f16935a;

        b(q0 q0Var, b.a aVar) {
            this.f16935a = aVar;
        }

        /* renamed from: a */
        public void call(Throwable th2) {
            k.e("health.module", "profile update failed", th2);
            b.a aVar = this.f16935a;
            if (aVar != null) {
                aVar.a(Boolean.FALSE);
            }
        }
    }

    public q0(Context context) {
        this.f16926a = context;
        ta.a.a(this);
    }

    @Override // com.mobvoi.health.companion.system.a, ah.b
    public String a(Context context) {
        if (!sf.a.d()) {
            return ta.a.d();
        }
        k.q("health.module", "You are in debug model to get account ID");
        return sf.a.a();
    }

    @Override // com.mobvoi.health.companion.system.a, ah.b
    public String b(Context context) {
        if (!sf.a.d()) {
            return ta.a.s();
        }
        k.q("health.module", "You are in debug model to get session ID");
        return sf.a.b();
    }

    @Override // com.mobvoi.health.companion.system.a, ah.b
    public String c(Context context) {
        return this.f16929d;
    }

    @Override // com.mobvoi.health.companion.system.a, ah.b
    public void d(Context context, b.a aVar) {
        this.f16932g.add(aVar);
    }

    @Override // com.mobvoi.health.companion.system.a
    public void e(String str, byte[] bArr) {
        u(str, bArr);
    }

    @Override // ah.b
    public void f(Context context, ah.a aVar, b.a<Boolean> aVar2) {
        ta.a.F(aVar.f208a);
        ta.a.N(aVar.f209b);
        ta.a.c0(aVar.f210c);
        ta.a.Z((AccountInfoHelper.AccountInfo.VAL_SEX_FEMALE.equals(aVar.f211d) ? AccountConstant.Sex.FEMALE : AccountConstant.Sex.MALE).ordinal());
        ra.b b10 = h.b();
        ua.a a10 = h.a();
        b10.e(ta.a.e()).Z(a10.b()).H(a10.a()).Y(new a(this, aVar2), new b(this, aVar2));
    }

    @Override // com.mobvoi.health.companion.system.a
    public hh.a g(Context context) {
        hh.a aVar = new hh.a();
        aVar.f27854a = ta.a.u();
        Math.round(166.1f);
        Math.round(57.7f);
        if (!TextUtils.isEmpty(ta.a.k())) {
            Math.round(Float.valueOf(ta.a.k()).floatValue());
        }
        if (!TextUtils.isEmpty(ta.a.w())) {
            Math.round(Float.valueOf(ta.a.w()).floatValue());
        }
        return aVar;
    }

    @Override // com.mobvoi.health.companion.system.b
    public void h(String str, b.c cVar) {
        List<b.c> list = this.f16931f.get(str);
        if (list != null) {
            list.remove(cVar);
        }
    }

    @Override // com.mobvoi.health.companion.system.a
    public void i(Context context, int i10) {
        x.h(context, i10);
    }

    @Override // com.mobvoi.health.companion.system.b
    public void j(String str, String str2, boolean z10) {
        if (z10) {
            this.f16928c = str;
            this.f16929d = str2;
        }
        this.f16930e = z10;
        for (b.a aVar : this.f16932g) {
            aVar.a(this.f16930e);
        }
    }

    @Override // com.mobvoi.health.companion.system.b
    public hh.b k(Context context) {
        z3 z3Var = new z3();
        for (a4 a4Var : this.f16933h) {
            a4Var.a(z3Var);
        }
        return z3Var.c();
    }

    @Override // com.mobvoi.health.companion.system.a
    public String l(Context context) {
        if (!sf.a.d()) {
            return ta.a.x();
        }
        k.q("health.module", "You are in debug model to get WWID");
        return sf.a.c();
    }

    @Override // com.mobvoi.health.companion.system.b
    public WearDevices m(Context context) {
        z3 z3Var = new z3();
        for (a4 a4Var : this.f16933h) {
            a4Var.a(z3Var);
        }
        return z3Var.d();
    }

    @Override // com.mobvoi.health.companion.system.a
    public void n(Context context) {
    }

    @Override // ah.b
    public ah.a o(Context context) {
        ah.a aVar = new ah.a();
        aVar.f208a = ta.a.f();
        aVar.f209b = ta.a.k();
        aVar.f210c = ta.a.w();
        aVar.f211d = ta.a.t() == AccountConstant.Sex.MALE.ordinal() ? AccountInfoHelper.AccountInfo.VAL_SEX_MALE : AccountInfoHelper.AccountInfo.VAL_SEX_FEMALE;
        return aVar;
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> list) {
        this.f16927b = false;
        for (NodeInfo nodeInfo : list) {
            if (nodeInfo.isNearby()) {
                this.f16927b = true;
            }
        }
        k.i("health.module", "Connection changed to connect? %s", Boolean.valueOf(this.f16927b));
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo messageInfo) {
        List<b.c> list;
        String path = messageInfo.getPath();
        byte[] payload = messageInfo.getPayload();
        for (String str : this.f16931f.keySet()) {
            if (!TextUtils.isEmpty(path) && path.startsWith(str) && (list = this.f16931f.get(str)) != null && list.size() > 0) {
                for (b.c cVar : list) {
                    cVar.a(new b.C0221b(this.f16926a, path, payload));
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        for (b.a aVar : this.f16932g) {
            aVar.a(false);
        }
    }

    @Override // com.mobvoi.health.companion.system.a
    public boolean p() {
        return this.f16930e;
    }

    @Override // com.mobvoi.health.companion.system.b
    public void q(String str, b.c cVar) {
        List<b.c> list = this.f16931f.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f16931f.put(str, list);
        }
        list.add(cVar);
    }

    @Override // ah.b
    public i r(ViewGroup viewGroup) {
        return g.b().a().a(viewGroup);
    }

    @Override // com.mobvoi.health.companion.system.a
    public String s(Context context) {
        return this.f16928c;
    }

    public void t(a4 a4Var) {
        this.f16933h.add(a4Var);
    }

    public void u(String str, byte[] bArr) {
        MessageProxyClient.getInstance().sendMessage(str, bArr);
    }
}
