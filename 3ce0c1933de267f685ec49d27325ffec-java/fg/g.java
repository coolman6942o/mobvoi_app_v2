package fg;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobvoi.health.companion.system.c;
/* compiled from: HealthDetailTipsDialog.java */
/* loaded from: classes2.dex */
public class g extends AlertDialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f26430a;

    /* renamed from: b  reason: collision with root package name */
    TextView f26431b;

    /* renamed from: c  reason: collision with root package name */
    TextView f26432c;

    /* renamed from: d  reason: collision with root package name */
    TextView f26433d;

    /* renamed from: e  reason: collision with root package name */
    int f26434e;

    /* renamed from: f  reason: collision with root package name */
    Context f26435f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f26436g;

    public g(Context context, int i10) {
        super(context);
        this.f26434e = i10;
        this.f26435f = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == s.T) {
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(null);
        setContentView(t.f26844r);
        findViewById(s.T).setOnClickListener(this);
        this.f26430a = (TextView) findViewById(s.f26687f5);
        this.f26431b = (TextView) findViewById(s.Z);
        this.f26432c = (TextView) findViewById(s.f26783t4);
        this.f26433d = (TextView) findViewById(s.f26790u4);
        this.f26436g = (ImageView) findViewById(s.f26752p0);
        int i10 = this.f26434e;
        if (i10 == 0) {
            this.f26430a.setText(u.f26917k2);
            this.f26432c.setText(u.Y1);
            this.f26433d.setText(u.W1);
            this.f26431b.setText(Html.fromHtml(this.f26435f.getResources().getString(u.X1, Integer.valueOf(c.a().g(this.f26435f).f27854a))));
            this.f26436g.setImageResource(q.Y);
        } else if (i10 == 1) {
            this.f26430a.setText(u.f26923l2);
            this.f26432c.setText(u.f26863b2);
            this.f26433d.setText(u.Z1);
            this.f26431b.setText(Html.fromHtml(this.f26435f.getResources().getString(u.f26856a2)));
            this.f26436g.setImageResource(q.Z);
        } else if (i10 == 2) {
            this.f26430a.setText(u.f26905i2);
            this.f26432c.setText(u.S1);
            this.f26433d.setText(u.Q1);
            this.f26431b.setText(Html.fromHtml(this.f26435f.getResources().getString(u.R1)));
            this.f26436g.setImageResource(q.N);
        } else if (i10 == 3) {
            this.f26430a.setText(u.f26911j2);
            this.f26432c.setText(u.V1);
            this.f26433d.setText(u.T1);
            this.f26431b.setText(Html.fromHtml(this.f26435f.getResources().getString(u.U1)));
            this.f26436g.setImageResource(q.W);
        }
    }
}
