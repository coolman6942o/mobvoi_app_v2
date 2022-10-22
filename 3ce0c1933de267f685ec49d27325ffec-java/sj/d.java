package sj;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.l;
/* compiled from: CopyTextDialog.java */
/* loaded from: classes2.dex */
public class d extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f34984a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f34985b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f34986c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f34987d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f34988e;

    /* renamed from: f  reason: collision with root package name */
    private a f34989f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34990g;

    /* compiled from: CopyTextDialog.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public d(Context context, a aVar) {
        super(context, l.f20684b);
        this.f34989f = aVar;
    }

    public void a(boolean z10) {
        this.f34990g = z10;
        LinearLayout linearLayout = this.f34984a;
        if (linearLayout != null) {
            int i10 = 0;
            linearLayout.setVisibility(z10 ? 0 : 8);
            LinearLayout linearLayout2 = this.f34988e;
            if (!this.f34990g) {
                i10 = 8;
            }
            linearLayout2.setVisibility(i10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.getId() == h.T) {
            dismiss();
        } else if (view.getId() == h.U) {
            a aVar2 = this.f34989f;
            if (aVar2 != null) {
                aVar2.b();
                dismiss();
            }
        } else if (view.getId() == h.V) {
            a aVar3 = this.f34989f;
            if (aVar3 != null) {
                aVar3.a();
                dismiss();
            }
        } else if (view.getId() == h.Y) {
            a aVar4 = this.f34989f;
            if (aVar4 != null) {
                aVar4.c();
                dismiss();
            }
        } else if (view.getId() == h.Z && (aVar = this.f34989f) != null) {
            aVar.d();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.f20639f);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = l.f20683a;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(h.U);
        this.f34984a = linearLayout;
        int i10 = 0;
        linearLayout.setVisibility(this.f34990g ? 0 : 8);
        this.f34985b = (LinearLayout) findViewById(h.V);
        this.f34986c = (LinearLayout) findViewById(h.T);
        this.f34987d = (LinearLayout) findViewById(h.Y);
        this.f34986c.setOnClickListener(this);
        this.f34984a.setOnClickListener(this);
        this.f34985b.setOnClickListener(this);
        this.f34987d.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(h.Z);
        this.f34988e = linearLayout2;
        if (!this.f34990g) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        this.f34988e.setOnClickListener(this);
    }
}
