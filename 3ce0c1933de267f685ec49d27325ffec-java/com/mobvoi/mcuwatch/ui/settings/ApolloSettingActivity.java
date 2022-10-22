package com.mobvoi.mcuwatch.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.c;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.r;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.health.thirdparty.wechat.NewBindingWechatActivity;
import com.mobvoi.mcuwatch.ui.pair.qrscan.ScanQrActivity;
import com.mobvoi.mcuwatch.ui.settings.ApolloSettingActivity;
import com.mobvoi.mcuwatch.ui.settings.apollo.ApolloOtaActivity;
import com.mobvoi.mcuwatch.ui.settings.apollo.NotificationSettingActivity;
import com.mobvoi.wear.common.base.TicwatchModels;
import ei.h;
import k7.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.k;
/* compiled from: ApolloSettingActivity.kt */
/* loaded from: classes2.dex */
public final class ApolloSettingActivity extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20001b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private c f20002a;

    /* compiled from: ApolloSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, ApolloSettingActivity.class));
        }
    }

    private final void K(final Context context) {
        this.f20002a = new b(context).q(k.f34883v4).h(k.f34888w4).d(false).j(k.f34848p0, ij.b.f28282a).m(k.f34879v0, new DialogInterface.OnClickListener() { // from class: ij.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ApolloSettingActivity.M(context, this, dialogInterface, i10);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Context context, final ApolloSettingActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(context, "$context");
        i.f(this$0, "this$0");
        h.a().f(context);
        dialogInterface.dismiss();
        l.a().postDelayed(new Runnable() { // from class: ij.c
            @Override // java.lang.Runnable
            public final void run() {
                ApolloSettingActivity.N(ApolloSettingActivity.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ApolloSettingActivity this$0) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    private final void O() {
        if (this.f20002a == null) {
            K(this);
        }
        c cVar = this.f20002a;
        i.d(cVar);
        if (!cVar.isShowing()) {
            c cVar2 = this.f20002a;
            i.d(cVar2);
            cVar2.show();
        }
    }

    public static final void start(Context context) {
        f20001b.a(context);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.e_res_0x7f0e0023;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = sh.h.K1;
        if (valueOf != null && valueOf.intValue() == i10) {
            ScanQrActivity.b0(this, "mcu_setting");
            return;
        }
        int i11 = sh.h.R1;
        if (valueOf != null && valueOf.intValue() == i11) {
            startActivity(new Intent(this, ApolloOtaActivity.class));
            return;
        }
        int i12 = sh.h.f34674o2;
        if (valueOf != null && valueOf.intValue() == i12) {
            startActivity(new Intent(this, NotificationSettingActivity.class));
            return;
        }
        int i13 = sh.h.S_res_0x7f0b0102;
        if (valueOf != null && valueOf.intValue() == i13) {
            NewBindingWechatActivity.f17066h.a(this, null, r.f15521b.a(), TicwatchModels.TICWATCH_GTW_eSIM);
            return;
        }
        int i14 = sh.h.S1;
        if (valueOf != null && valueOf.intValue() == i14) {
            lc.a.a(this, "chumenwenwen");
            Toast.makeText(this, getString(k.U4, new Object[]{"chumenwenwen"}), 0).show();
            return;
        }
        int i15 = sh.h.T1;
        if (valueOf != null && valueOf.intValue() == i15) {
            Intent intent = new Intent("com.mobvoi.action.OPEN_BROWSER_SHARE");
            intent.putExtra("url", "http://weibo.com/chumenwenwen");
            intent.setFlags(268435456);
            startActivity(intent);
            return;
        }
        int i16 = sh.h.I1;
        if (valueOf != null && valueOf.intValue() == i16) {
            Intent intent2 = new Intent("android.intent.action.FEED_BACK");
            intent2.putExtra("wwid", ta.a.x());
            startActivity(intent2);
            return;
        }
        int i17 = sh.h.Q1;
        if (valueOf != null && valueOf.intValue() == i17) {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(k.f34890x0);
        findViewById(sh.h.K1).setOnClickListener(this);
        findViewById(sh.h.R1).setOnClickListener(this);
        findViewById(sh.h.f34674o2).setOnClickListener(this);
        findViewById(sh.h.S_res_0x7f0b0102).setOnClickListener(this);
        findViewById(sh.h.S1).setOnClickListener(this);
        findViewById(sh.h.T1).setOnClickListener(this);
        findViewById(sh.h.I1).setOnClickListener(this);
        findViewById(sh.h.Q1).setOnClickListener(this);
    }
}
