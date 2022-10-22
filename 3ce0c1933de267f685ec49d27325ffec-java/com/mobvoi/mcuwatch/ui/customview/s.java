package com.mobvoi.mcuwatch.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mobvoi.mcuwatch.ui.customview.s;
import sh.h;
import sh.i;
import sh.l;
/* compiled from: DialSelectPicDialog.java */
/* loaded from: classes2.dex */
public class s extends Dialog implements View.OnClickListener {

    /* compiled from: DialSelectPicDialog.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f19684a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f19685b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f19686c;

        /* renamed from: d  reason: collision with root package name */
        private Button f19687d;

        /* renamed from: e  reason: collision with root package name */
        private DialogInterface.OnClickListener f19688e;

        /* renamed from: f  reason: collision with root package name */
        private DialogInterface.OnClickListener f19689f;

        /* renamed from: g  reason: collision with root package name */
        private DialogInterface.OnClickListener f19690g;

        /* renamed from: h  reason: collision with root package name */
        s f19691h;

        public a(Context context) {
            this.f19684a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            this.f19689f.onClick(this.f19691h, -1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view) {
            this.f19688e.onClick(this.f19691h, -2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(View view) {
            this.f19690g.onClick(this.f19691h, -2);
        }

        public s d() {
            this.f19691h = new s(this.f19684a, l.b_res_0x7f15012b);
            View inflate = ((LayoutInflater) this.f19684a.getSystemService("layout_inflater")).inflate(i.Q, (ViewGroup) null);
            this.f19691h.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f19685b = (TextView) inflate.findViewById(h.f34697t2);
            this.f19686c = (TextView) inflate.findViewById(h.h_res_0x7f0b008e);
            this.f19687d = (Button) inflate.findViewById(h.f34682q0);
            if (this.f19689f != null) {
                this.f19685b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.a.this.e(view);
                    }
                });
            }
            if (this.f19688e != null) {
                this.f19686c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.a.this.f(view);
                    }
                });
            }
            if (this.f19690g != null) {
                this.f19687d.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.a.this.g(view);
                    }
                });
            }
            this.f19691h.setCanceledOnTouchOutside(false);
            this.f19691h.setCancelable(false);
            this.f19691h.setContentView(inflate);
            return this.f19691h;
        }

        public a h(DialogInterface.OnClickListener onClickListener) {
            this.f19688e = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnClickListener onClickListener) {
            this.f19690g = onClickListener;
            return this;
        }

        public a j(DialogInterface.OnClickListener onClickListener) {
            this.f19689f = onClickListener;
            return this;
        }
    }

    public s(Context context, int i10) {
        super(context, i10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
