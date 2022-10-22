package sj;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
/* compiled from: TextInputDialog.java */
/* loaded from: classes2.dex */
public class j extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private EditText f35009a;

    /* renamed from: b  reason: collision with root package name */
    private String f35010b;

    /* renamed from: c  reason: collision with root package name */
    private String f35011c;

    /* renamed from: d  reason: collision with root package name */
    private String f35012d;

    /* renamed from: e  reason: collision with root package name */
    private String f35013e;

    /* renamed from: f  reason: collision with root package name */
    private c f35014f;

    /* compiled from: TextInputDialog.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f35015a;

        /* renamed from: b  reason: collision with root package name */
        private String f35016b;

        /* renamed from: c  reason: collision with root package name */
        private String f35017c;

        /* renamed from: d  reason: collision with root package name */
        private String f35018d;

        /* renamed from: e  reason: collision with root package name */
        private String f35019e;

        /* renamed from: f  reason: collision with root package name */
        private c f35020f;

        public b(Context context) {
            this.f35015a = context;
        }

        public j a() {
            j jVar = new j(this.f35015a);
            jVar.f35010b = this.f35016b;
            jVar.f35011c = this.f35017c;
            jVar.f35012d = this.f35018d;
            jVar.f35013e = this.f35019e;
            jVar.f35014f = this.f35020f;
            return jVar;
        }

        public b b(int i10) {
            this.f35019e = this.f35015a.getString(i10);
            return this;
        }

        public b c(int i10) {
            this.f35018d = this.f35015a.getString(i10);
            return this;
        }

        public b d(String str) {
            this.f35017c = str;
            return this;
        }

        public b e(c cVar) {
            this.f35020f = cVar;
            return this;
        }

        public b f(int i10) {
            this.f35016b = this.f35015a.getString(i10);
            return this;
        }
    }

    /* compiled from: TextInputDialog.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        c cVar = this.f35014f;
        if (cVar != null) {
            cVar.a(this.f35009a.getText().toString());
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        dismiss();
    }

    public void j(String str) {
        this.f35011c = str;
        if (!TextUtils.isEmpty(str)) {
            this.f35009a.setText(str);
            this.f35009a.setSelection(str.length());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.f20641h);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(h.f20594g1);
        this.f35009a = (EditText) findViewById(h.f20624v);
        TextView textView2 = (TextView) findViewById(h.f20629x0);
        TextView textView3 = (TextView) findViewById(h.f20627w0);
        Space space = (Space) findViewById(h.f20609n0);
        String str = this.f35010b;
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f35011c)) {
            this.f35009a.setText(this.f35011c);
            this.f35009a.setSelection(this.f35011c.length());
        }
        String str2 = this.f35012d;
        if (str2 != null) {
            textView2.setText(str2);
        } else {
            textView2.setVisibility(8);
        }
        String str3 = this.f35013e;
        if (str3 != null) {
            textView3.setText(str3);
        } else {
            textView3.setVisibility(8);
        }
        if (this.f35013e == null || this.f35012d == null) {
            space.setVisibility(8);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: sj.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.this.h(view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: sj.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.this.i(view);
            }
        });
    }

    private j(Context context) {
        super(context);
    }
}
