package com.mobvoi.mcuwatch.ui.settings.ota;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.x;
import ci.a;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.settings.ota.f;
import ij.i;
import k7.b;
import sh.h;
import sh.k;
import wi.e;
/* loaded from: classes2.dex */
public class OtaActivity extends e<i> implements f.a {

    /* renamed from: b  reason: collision with root package name */
    Button f20108b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20109c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20110d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20111e;

    /* renamed from: f  reason: collision with root package name */
    TextView f20112f;

    /* renamed from: g  reason: collision with root package name */
    ProgressBar f20113g;

    /* renamed from: h  reason: collision with root package name */
    boolean f20114h = false;

    /* renamed from: i  reason: collision with root package name */
    private f f20115i;

    private void Q() {
        this.f20109c.setText(getString(k.f34797e4, new Object[]{this.f20115i.a()}));
        this.f20115i.i().i(this, new x() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.k
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                OtaActivity.this.T((String) obj);
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    private boolean S() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(k.f34812h4);
        }
        this.f20110d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    private boolean W() {
        if (n.f19178a.e() < this.f20115i.c()) {
            new b(this).q(k.Z).D(getString(k.Y, new Object[]{Integer.valueOf(this.f20115i.c())})).m(k.f34879v0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    OtaActivity.this.U(dialogInterface, i10);
                }
            }).t();
            return false;
        } else if (S()) {
            return true;
        } else {
            Toast.makeText(this, k.G1, 0).show();
            return false;
        }
    }

    private void X() {
        this.f20114h = false;
        this.f20108b.setEnabled(true);
        this.f20108b.setText(k.M4);
    }

    private void Y() {
        new b(this).q(k.K4).h(k.f34784c3).m(k.f34879v0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                OtaActivity.this.V(dialogInterface, i10);
            }
        }).t();
    }

    private void Z() {
        if (W()) {
            this.f20114h = true;
            this.f20115i.j();
            this.f20108b.setEnabled(false);
            this.f20108b.setText(k.f34832l4);
        }
    }

    private void initView() {
        setTitle(k.K4);
        this.f20108b = (Button) findViewById(h.m0_res_0x7f0b0143);
        this.f20109c = (TextView) findViewById(h.N3);
        this.f20110d = (TextView) findViewById(h.Q3);
        this.f20111e = (TextView) findViewById(h.f34667m4);
        this.f20112f = (TextView) findViewById(h.P3);
        this.f20113g = (ProgressBar) findViewById(h.f34705v2);
        this.f20108b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.ota.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtaActivity.this.onClick(view);
            }
        });
        if (this.f20115i.d()) {
            this.f20112f.setVisibility(0);
        }
        this.f20113g.setMax(100);
        this.f20113g.setProgress(0);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, OtaActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.e
    protected boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O */
    public i H() {
        return new i();
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f.a
    public void b(int i10) {
        if (this.f20111e.getVisibility() == 8) {
            this.f20111e.setVisibility(0);
            this.f20108b.setText(k.T3);
        }
        this.f20111e.setText(getString(k.f34775b0, new Object[]{Integer.valueOf(i10)}));
        this.f20113g.setProgress(i10);
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f.a
    public void d(int i10) {
        switch (i10) {
            case 1:
                this.f20108b.setText(k.H3);
                return;
            case 2:
                String string = getString(k.N4, new Object[]{0});
                this.f20108b.setText(string.substring(0, string.length() - 2));
                return;
            case 3:
                this.f20108b.setText(k.f34832l4);
                return;
            case 4:
                Toast.makeText(this, k.O4, 0).show();
                finish();
                return;
            case 5:
                Toast.makeText(this, k.L4, 0).show();
                X();
                return;
            case 6:
                Toast.makeText(this, k.H4, 0).show();
                X();
                return;
            default:
                return;
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34764y;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f20114h) {
            Toast.makeText(this, k.f34827k4, 0).show();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        if (view.getId() != h.m0_res_0x7f0b0143) {
            return;
        }
        if (!a.b().e()) {
            Toast.makeText(this, k.F3, 0).show();
        } else if (!this.f20115i.d()) {
            Y();
        } else {
            Z();
        }
    }

    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g gVar = new g();
        this.f20115i = gVar;
        gVar.g(this);
        initView();
        Q();
    }

    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f20115i.release();
    }
}
