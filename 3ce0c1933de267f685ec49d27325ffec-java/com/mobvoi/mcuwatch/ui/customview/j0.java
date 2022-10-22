package com.mobvoi.mcuwatch.ui.customview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bn.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.android.common.utils.s;
import com.tendcloud.tenddata.ab;
import com.yc.pedometer.dial.OnlineDialUtil;
import cq.a;
import dn.n;
import en.q;
import gn.z;
import java.io.File;
import sh.h;
import sh.i;
import sh.k;
import sh.l;
import yh.c;
/* compiled from: WatchTransferDialog.java */
/* loaded from: classes2.dex */
public class j0 extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    TextView f19649a;

    /* renamed from: b  reason: collision with root package name */
    RoundedImageView f19650b;

    /* renamed from: c  reason: collision with root package name */
    ProgressBar f19651c;

    /* renamed from: d  reason: collision with root package name */
    Button f19652d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19653e;

    /* renamed from: f  reason: collision with root package name */
    RelativeLayout f19654f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f19655g;

    /* renamed from: h  reason: collision with root package name */
    private Context f19656h;

    /* renamed from: i  reason: collision with root package name */
    protected c f19657i;

    /* renamed from: j  reason: collision with root package name */
    protected Handler f19658j;

    /* renamed from: k  reason: collision with root package name */
    private t f19659k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19660l;

    public j0(Context context, c cVar, boolean z10, s sVar, t tVar) {
        super(context, l.a_res_0x7f150001);
        this.f19656h = context;
        this.f19657i = cVar;
        this.f19660l = z10;
        this.f19658j = sVar;
        this.f19659k = tVar;
    }

    private void g() {
        this.f19649a = (TextView) findViewById(h.f34676o4);
        this.f19650b = (RoundedImageView) findViewById(h.f34673o1);
        this.f19651c = (ProgressBar) findViewById(h.f34701u2);
        this.f19652d = (Button) findViewById(h.f34672n4);
        this.f19653e = (TextView) findViewById(h.f34680p3);
        this.f19654f = (RelativeLayout) findViewById(h.E2);
        this.f19655g = (ImageView) findViewById(h.f34709w1);
        this.f19652d.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.this.h(view);
            }
        });
        this.f19655g.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.this.i(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer j(Integer num) {
        return Integer.valueOf(g.a(this.f19657i.watchFaceDownloadUrl, b.h(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator, this.f19657i.title + ".bin"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Integer num) {
        if (num.intValue() == 0) {
            this.f19653e.setText(this.f19656h.getString(k.F2));
            this.f19651c.setProgress(0);
            p();
            return;
        }
        setCancelable(true);
        o();
        Toast.makeText(this.f19656h, k.M0, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i10) {
        if (i10 > 0 && this.f19658j.hasMessages(12)) {
            this.f19658j.removeMessages(12);
        }
        if (i10 > this.f19651c.getProgress()) {
            this.f19653e.setText(this.f19656h.getString(k.G2, Integer.valueOf(i10)));
            this.f19651c.setProgress(i10);
        }
    }

    private void m() {
        t tVar = this.f19659k;
        if (tVar != null) {
            tVar.n();
        }
    }

    private void p() {
        com.mobvoi.android.common.utils.k.a("WatchTransferDialog", "下载完成，开始同步");
        this.f19658j.sendEmptyMessageDelayed(12, ab.Y);
        this.f19651c.setProgress(0);
        q.B(this.f19656h).L();
        q.B(this.f19656h).w0(new n() { // from class: com.mobvoi.mcuwatch.ui.customview.g0
            @Override // dn.n
            public final void a(int i10) {
                j0.this.l(i10);
            }
        });
    }

    private void q() {
        this.f19649a.setText(this.f19657i.title);
        com.bumptech.glide.c.u(getContext()).r(this.f19657i.watchFaceUrl).u0(this.f19650b);
        this.f19650b.setOval(!this.f19660l);
    }

    public void f() {
        setContentView(LayoutInflater.from(this.f19656h).inflate(i.S, (ViewGroup) null));
        g();
        q();
        if (this.f19652d.getText().toString().equals(this.f19656h.getResources().getString(k.E2))) {
            this.f19652d.setClickable(true);
        } else {
            this.f19652d.setClickable(false);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void n() {
        if (!m.b(this.f19656h)) {
            Toast.makeText(this.f19656h, k.M0, 0).show();
        } else if (!z.v(this.f19656h).j()) {
            Toast.makeText(this.f19656h, k.S0, 0).show();
        } else if (com.mobvoi.mcuwatch.engine.s.f19186a.d()) {
            Toast.makeText(this.f19656h, k.J4, 0).show();
        } else {
            setCancelable(false);
            this.f19652d.setVisibility(8);
            this.f19654f.setVisibility(0);
            OnlineDialUtil.j().l(OnlineDialUtil.DialStatus.RegularDial);
            this.f19653e.setText(this.f19656h.getString(k.W2));
            rx.c.A(0).D(new yp.g() { // from class: com.mobvoi.mcuwatch.ui.customview.i0
                @Override // yp.g
                public final Object call(Object obj) {
                    Integer j10;
                    j10 = j0.this.j((Integer) obj);
                    return j10;
                }
            }).Z(a.c()).H(xp.a.b()).X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.customview.h0
                @Override // yp.b
                public final void call(Object obj) {
                    j0.this.k((Integer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        this.f19652d.setVisibility(0);
        this.f19654f.setVisibility(8);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = bn.c.b(getContext()) - bn.c.a(getContext(), 76);
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }
}
