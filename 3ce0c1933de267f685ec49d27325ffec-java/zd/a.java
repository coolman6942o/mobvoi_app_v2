package zd;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ce.e;
import ce.f;
import ce.i;
/* compiled from: ConfirmDialog.java */
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f37392a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f37393b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f37394c;

    /* renamed from: d  reason: collision with root package name */
    private AbstractC0547a f37395d;

    /* compiled from: ConfirmDialog.java */
    /* renamed from: zd.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0547a {
        void a();

        void onCancel();
    }

    public a(Context context) {
        super(context, i.f5883c);
        a();
    }

    private void a() {
        getWindow().requestFeature(1);
        getWindow().getAttributes().windowAnimations = i.f5882b;
        View inflate = getLayoutInflater().inflate(f.f5813g, (ViewGroup) null);
        setCancelable(false);
        setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(e.f5784k0);
        this.f37392a = (TextView) inflate.findViewById(e.K);
        this.f37393b = (TextView) inflate.findViewById(e.f5774f0);
        this.f37394c = (TextView) inflate.findViewById(e.f5778h0);
        this.f37393b.setOnClickListener(this);
        this.f37394c.setOnClickListener(this);
    }

    public void b(String str, String str2) {
        this.f37393b.setText(str);
        this.f37394c.setText(str2);
    }

    public void c(AbstractC0547a aVar) {
        this.f37395d = aVar;
    }

    public void d(String str) {
        this.f37392a.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == e.f5774f0) {
            AbstractC0547a aVar = this.f37395d;
            if (aVar != null) {
                aVar.onCancel();
            }
            dismiss();
        } else if (id2 == e.f5778h0) {
            AbstractC0547a aVar2 = this.f37395d;
            if (aVar2 != null) {
                aVar2.a();
            }
            dismiss();
        }
    }
}
