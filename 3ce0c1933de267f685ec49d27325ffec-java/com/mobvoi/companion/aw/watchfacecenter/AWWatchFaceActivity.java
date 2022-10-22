package com.mobvoi.companion.aw.watchfacecenter;

import aa.c;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.g0;
import androidx.lifecycle.x;
import com.mobvoi.companion.base.m3.e;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import dc.a;
import io.d;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
/* compiled from: AWWatchFaceActivity.kt */
/* loaded from: classes2.dex */
public final class AWWatchFaceActivity extends e<a> {

    /* renamed from: e  reason: collision with root package name */
    public ec.a f16344e;

    /* renamed from: f  reason: collision with root package name */
    private String f16345f;

    /* renamed from: g  reason: collision with root package name */
    private final d f16346g = new g0(l.b(WatchFaceViewModel.class), new AWWatchFaceActivity$special$$inlined$viewModels$default$2(this), new AWWatchFaceActivity$special$$inlined$viewModels$default$1(this));

    private final WatchFaceViewModel V() {
        return (WatchFaceViewModel) this.f16346g.getValue();
    }

    private final void W() {
        this.f16345f = getIntent().getStringExtra("extra_node_id");
        final WatchFaceViewModel V = V();
        V.z().i(this, c.f16370a);
        V.v().i(this, d.f16374a);
        V.u().i(this, new x() { // from class: com.mobvoi.companion.aw.watchfacecenter.b
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                AWWatchFaceActivity.Z(WatchFaceViewModel.this, (MessageInfo) obj);
            }
        });
        V.x().i(this, new x() { // from class: com.mobvoi.companion.aw.watchfacecenter.a
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                AWWatchFaceActivity.a0(AWWatchFaceActivity.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Boolean bool) {
        if (!bool.booleanValue()) {
            c.a(s.f16466b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(String str) {
        c.a(s.f16474t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(WatchFaceViewModel this_with, MessageInfo messageInfo) {
        i.f(this_with, "$this_with");
        String path = messageInfo.getPath();
        if (i.b(path, WearPath.WatchfaceMarket.SET_CONFIRM)) {
            c.a(s.f16475u);
        } else if (i.b(path, WearPath.WatchfaceMarket.DOWNLOAD_WATCHFACE)) {
            c.a(this_with.F() ? s.f16470f : s.g_res_0x7f1403d5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(AWWatchFaceActivity this$0, String str) {
        i.f(this$0, "this$0");
        this$0.setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T */
    public a H(LayoutInflater inflater, ViewGroup parent) {
        i.f(inflater, "inflater");
        i.f(parent, "parent");
        a d10 = a.d(inflater, parent, false);
        i.e(d10, "inflate(inflater, parent, false)");
        return d10;
    }

    public final ec.a U() {
        ec.a aVar = this.f16344e;
        if (aVar != null) {
            return aVar;
        }
        i.u("fragmentMgr");
        throw null;
    }

    public final void b0(String tag, Bundle bundle, String str) {
        i.f(tag, "tag");
        V().r(i.b(tag, "list_fragment"));
        U().f(tag, bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Fragment f02 = getSupportFragmentManager().f0(p.f16465h);
        if (f02 != null) {
            f02.onActivityResult(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (U().d()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l.f16454a.b(System.currentTimeMillis());
        W();
        if (bundle == null) {
            b0("list_fragment", null, this.f16345f);
            return;
        }
        WatchFaceViewModel V = V();
        boolean z10 = true;
        if (U().b() != 1) {
            z10 = false;
        }
        V.r(z10);
    }
}
