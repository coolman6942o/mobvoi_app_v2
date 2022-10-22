package sj;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Space;
import android.widget.TextView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
/* compiled from: ConfirmDialog.java */
/* loaded from: classes2.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private String f34971a;

    /* renamed from: b  reason: collision with root package name */
    private String f34972b;

    /* renamed from: c  reason: collision with root package name */
    private String f34973c;

    /* renamed from: d  reason: collision with root package name */
    private String f34974d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f34975e;

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f34976f;

    /* compiled from: ConfirmDialog.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f34977a;

        /* renamed from: b  reason: collision with root package name */
        private String f34978b;

        /* renamed from: c  reason: collision with root package name */
        private String f34979c;

        /* renamed from: d  reason: collision with root package name */
        private String f34980d;

        /* renamed from: e  reason: collision with root package name */
        private String f34981e;

        /* renamed from: f  reason: collision with root package name */
        private View.OnClickListener f34982f;

        /* renamed from: g  reason: collision with root package name */
        private View.OnClickListener f34983g;

        public b(Context context) {
            this.f34977a = context;
        }

        public c a() {
            c cVar = new c(this.f34977a);
            cVar.f34971a = this.f34978b;
            cVar.f34972b = this.f34979c;
            cVar.f34973c = this.f34980d;
            cVar.f34974d = this.f34981e;
            cVar.f34976f = this.f34983g;
            cVar.f34975e = this.f34982f;
            return cVar;
        }

        public b b(int i10) {
            this.f34981e = this.f34977a.getString(i10);
            return this;
        }

        public b c(int i10) {
            this.f34980d = this.f34977a.getString(i10);
            return this;
        }

        public b d(int i10) {
            this.f34979c = this.f34977a.getString(i10);
            return this;
        }

        public b e(View.OnClickListener onClickListener) {
            this.f34982f = onClickListener;
            return this;
        }

        public b f(int i10) {
            this.f34978b = this.f34977a.getString(i10);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        View.OnClickListener onClickListener = this.f34975e;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        View.OnClickListener onClickListener = this.f34976f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.f20638e);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(h.f20594g1);
        TextView textView2 = (TextView) findViewById(h.J0);
        TextView textView3 = (TextView) findViewById(h.f20629x0);
        TextView textView4 = (TextView) findViewById(h.f20627w0);
        Space space = (Space) findViewById(h.f20609n0);
        String str = this.f34971a;
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
        String str2 = this.f34972b;
        if (str2 != null) {
            textView2.setText(str2);
        } else {
            textView2.setVisibility(8);
        }
        String str3 = this.f34973c;
        if (str3 != null) {
            textView3.setText(str3);
        } else {
            textView3.setVisibility(8);
        }
        String str4 = this.f34974d;
        if (str4 != null) {
            textView4.setText(str4);
        } else {
            textView4.setVisibility(8);
        }
        if (this.f34974d == null || this.f34973c == null) {
            space.setVisibility(8);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: sj.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.i(view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: sj.b
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
