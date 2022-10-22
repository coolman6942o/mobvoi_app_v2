package z9;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.g;
import y9.f;
import y9.h;
import y9.i;
import y9.j;
import z9.c;
/* compiled from: PermissionRequestDialog.java */
/* loaded from: classes2.dex */
public class c extends g {

    /* renamed from: c  reason: collision with root package name */
    private TextView f37304c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f37305d;

    /* renamed from: e  reason: collision with root package name */
    public Button f37306e;

    /* renamed from: f  reason: collision with root package name */
    public Button f37307f;

    /* compiled from: PermissionRequestDialog.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f37308a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f37309b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f37310c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f37311d;

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f37312e;

        /* renamed from: f  reason: collision with root package name */
        private DialogInterface.OnClickListener f37313f;

        /* renamed from: g  reason: collision with root package name */
        private DialogInterface.OnClickListener f37314g;

        public a(Context context) {
            this.f37308a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(c cVar, View view) {
            this.f37313f.onClick(cVar, -1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(c cVar, View view) {
            this.f37314g.onClick(cVar, -2);
        }

        public c c() {
            final c cVar = new c(this.f37308a);
            cVar.setCancelable(false);
            cVar.setTitle(this.f37309b);
            cVar.f(this.f37310c);
            if (!TextUtils.isEmpty(this.f37311d)) {
                cVar.f37306e.setText(this.f37311d);
            }
            if (this.f37313f != null) {
                cVar.f37306e.setOnClickListener(new View.OnClickListener() { // from class: z9.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.a.this.d(cVar, view);
                    }
                });
            }
            if (!TextUtils.isEmpty(this.f37312e)) {
                cVar.f37307f.setText(this.f37312e);
            }
            if (this.f37314g != null) {
                cVar.f37307f.setOnClickListener(new View.OnClickListener() { // from class: z9.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.a.this.e(cVar, view);
                    }
                });
            }
            return cVar;
        }

        public a f(CharSequence charSequence) {
            this.f37310c = charSequence;
            return this;
        }

        public a g(DialogInterface.OnClickListener onClickListener) {
            this.f37314g = onClickListener;
            return this;
        }

        public a h(DialogInterface.OnClickListener onClickListener) {
            this.f37313f = onClickListener;
            return this;
        }

        public a i(int i10) {
            Context context = this.f37308a;
            this.f37309b = context.getString(i.f36857x, context.getString(i10));
            return this;
        }
    }

    public c(Context context) {
        super(context, j.f36859b);
        e();
    }

    private void e() {
        View inflate = View.inflate(getContext(), h.f36832c, null);
        setContentView(inflate);
        setCancelable(false);
        this.f37304c = (TextView) inflate.findViewById(f.f36824m);
        this.f37305d = (TextView) inflate.findViewById(f.f36815d);
        this.f37307f = (Button) inflate.findViewById(f.f36812a);
        this.f37306e = (Button) inflate.findViewById(f.f36813b);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            attributes.windowAnimations = j.f36858a;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }

    public void f(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f37305d.setText(charSequence);
        } else {
            this.f37305d.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f37304c.setText(charSequence);
        } else {
            this.f37304c.setVisibility(8);
        }
    }
}
