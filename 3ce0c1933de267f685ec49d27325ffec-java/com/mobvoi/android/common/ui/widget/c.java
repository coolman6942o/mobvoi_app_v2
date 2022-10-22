package com.mobvoi.android.common.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import y9.f;
import y9.h;
/* compiled from: MessageDialog.java */
/* loaded from: classes2.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private String f15402a;

    /* renamed from: b  reason: collision with root package name */
    private String f15403b;

    /* renamed from: c  reason: collision with root package name */
    private String f15404c;

    /* renamed from: d  reason: collision with root package name */
    private String f15405d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f15406e;

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f15407f;

    /* compiled from: MessageDialog.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15408a;

        /* renamed from: b  reason: collision with root package name */
        private String f15409b;

        /* renamed from: c  reason: collision with root package name */
        private String f15410c;

        /* renamed from: d  reason: collision with root package name */
        private String f15411d;

        /* renamed from: e  reason: collision with root package name */
        private String f15412e;

        /* renamed from: f  reason: collision with root package name */
        private View.OnClickListener f15413f;

        /* renamed from: g  reason: collision with root package name */
        private View.OnClickListener f15414g;

        public b(Context context) {
            this.f15408a = context;
        }

        public b a(int i10) {
            this.f15412e = this.f15408a.getString(i10);
            return this;
        }

        public b b(int i10) {
            this.f15411d = this.f15408a.getString(i10);
            return this;
        }

        public b c(int i10) {
            this.f15410c = this.f15408a.getString(i10);
            return this;
        }

        public b d(View.OnClickListener onClickListener) {
            this.f15414g = onClickListener;
            return this;
        }

        public b e(View.OnClickListener onClickListener) {
            this.f15413f = onClickListener;
            return this;
        }

        public b f(int i10) {
            this.f15409b = this.f15408a.getString(i10);
            return this;
        }

        public void g() {
            c cVar = new c(this.f15408a);
            cVar.f15402a = this.f15409b;
            cVar.f15403b = this.f15410c;
            cVar.f15404c = this.f15411d;
            cVar.f15405d = this.f15412e;
            cVar.f15407f = this.f15414g;
            cVar.f15406e = this.f15413f;
            cVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        View.OnClickListener onClickListener = this.f15406e;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        View.OnClickListener onClickListener = this.f15407f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.f36831b);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(f.f36828q);
        TextView textView2 = (TextView) findViewById(f.f36827p);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView textView3 = (TextView) findViewById(f.f36826o);
        TextView textView4 = (TextView) findViewById(f.f36825n);
        View findViewById = findViewById(f.f36822k);
        String str = this.f15402a;
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
        String str2 = this.f15403b;
        if (str2 != null) {
            textView2.setText(str2);
        } else {
            textView2.setVisibility(8);
        }
        String str3 = this.f15404c;
        if (str3 != null) {
            textView3.setText(str3);
        } else {
            textView3.setVisibility(8);
        }
        String str4 = this.f15405d;
        if (str4 != null) {
            textView4.setText(str4);
        } else {
            textView4.setVisibility(8);
        }
        if (this.f15405d == null || this.f15404c == null) {
            findViewById.setVisibility(8);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.android.common.ui.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.i(view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.android.common.ui.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.j(view);
            }
        });
    }

    private c(Context context) {
        super(context);
    }
}
