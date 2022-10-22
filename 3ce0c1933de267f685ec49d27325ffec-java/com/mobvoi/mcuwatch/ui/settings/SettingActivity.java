package com.mobvoi.mcuwatch.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.pair.qrscan.ScanQrActivity;
import com.mobvoi.mcuwatch.ui.settings.SettingActivity;
import com.mobvoi.mcuwatch.ui.settings.ota.OtaActivity;
import ei.h;
import ij.e;
import ij.f;
import ij.g;
import k7.b;
import lc.a;
import sh.i;
import sh.k;
/* loaded from: classes2.dex */
public class SettingActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    TextView f20003a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f20004b;

    /* renamed from: c  reason: collision with root package name */
    private c f20005c;

    /* renamed from: d  reason: collision with root package name */
    private c f20006d;

    private void M(final Context context) {
        this.f20005c = new b(context).q(k.f34883v4).h(k.f34888w4).d(false).j(k.f34848p0, f.f28287a).m(k.f34879v0, new DialogInterface.OnClickListener() { // from class: ij.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                SettingActivity.this.T(context, dialogInterface, i10);
            }
        }).a();
    }

    private void N(Context context) {
        this.f20006d = new b(context).q(k.f34883v4).h(k.f34894x4).d(false).j(k.f34848p0, g.f28288a).m(k.f34879v0, e.f28286a).a();
    }

    private void O(boolean z10) {
        Drawable drawable = getResources().getDrawable(sh.f.B0);
        if (z10) {
            if (this.f20004b == null) {
                Drawable drawable2 = getResources().getDrawable(sh.f.f34597w1);
                this.f20004b = drawable2;
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f20004b.getIntrinsicHeight());
            }
            this.f20003a.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, this.f20004b, (Drawable) null);
            return;
        }
        this.f20003a.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Context context, DialogInterface dialogInterface, int i10) {
        h.a().f(context);
        dialogInterface.dismiss();
        l.a().postDelayed(new Runnable() { // from class: ij.h
            @Override // java.lang.Runnable
            public final void run() {
                SettingActivity.this.S();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i10) {
        h.a().h();
        dialogInterface.dismiss();
    }

    private void W() {
        if (this.f20005c == null) {
            M(this);
        }
        if (!this.f20005c.isShowing()) {
            this.f20005c.show();
        }
    }

    private void X() {
        if (this.f20006d == null) {
            N(this);
        }
        if (!this.f20006d.isShowing()) {
            this.f20006d.show();
        }
    }

    public static void Y(Context context, String str) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    private void Z() {
        O(n.f19178a.z());
    }

    private void initView() {
        this.f20003a = (TextView) findViewById(sh.h.f34663l4);
        findViewById(sh.h.K1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.M1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.R1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.S1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.T1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.I1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        findViewById(sh.h.Q1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.onClick(view);
            }
        });
        if (yd.b.c(this)) {
            findViewById(sh.h.U1).setVisibility(8);
        }
        setTitle(k.f34890x0);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == sh.h.K1) {
            ScanQrActivity.b0(this, "mcu_setting");
        } else if (id2 == sh.h.M1) {
            X();
        } else if (id2 == sh.h.R1) {
            OtaActivity.start(this);
        } else if (id2 == sh.h.S1) {
            a.a(this, "chumenwenwen");
            Toast.makeText(this, getString(k.U4, new Object[]{"chumenwenwen"}), 0).show();
        } else if (id2 == sh.h.T1) {
            Intent intent = new Intent("com.mobvoi.action.OPEN_BROWSER_SHARE");
            intent.putExtra("url", "http://weibo.com/chumenwenwen");
            intent.setFlags(268435456);
            startActivity(intent);
        } else if (id2 == sh.h.I1) {
            Intent intent2 = new Intent("android.intent.action.FEED_BACK");
            intent2.putExtra("wwid", ta.a.x());
            startActivity(intent2);
        } else if (id2 == sh.h.Q1) {
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        Z();
    }
}
