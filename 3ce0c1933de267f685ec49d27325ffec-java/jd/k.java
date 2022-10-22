package jd;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import ce.e;
import ce.f;
import ce.i;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import ig.b;
/* compiled from: IHealthChanger.java */
/* loaded from: classes2.dex */
public abstract class k<E> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f29539a;

    /* renamed from: b  reason: collision with root package name */
    protected h f29540b;

    /* renamed from: c  reason: collision with root package name */
    protected E f29541c;

    /* renamed from: d  reason: collision with root package name */
    protected com.google.android.material.bottomsheet.a f29542d;

    /* renamed from: e  reason: collision with root package name */
    protected a f29543e;

    /* compiled from: IHealthChanger.java */
    /* loaded from: classes2.dex */
    public interface a {
        void k(int i10, Object obj);
    }

    public k(h hVar) {
        this.f29540b = hVar;
    }

    private void f() {
        View inflate = LayoutInflater.from(this.f29539a).cloneInContext(new ContextThemeWrapper(this.f29539a, i.f5884d)).inflate(d(), (ViewGroup) null);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this.f29539a);
        this.f29542d = aVar;
        WindowManager.LayoutParams attributes = aVar.getWindow().getAttributes();
        attributes.width = -1;
        this.f29542d.getWindow().setAttributes(attributes);
        this.f29542d.setContentView(inflate);
        g(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        this.f29542d.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        j(view);
        this.f29542d.dismiss();
    }

    protected int d() {
        return f.f5828v;
    }

    protected abstract int e();

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(View view) {
        ((TextView) view.findViewById(e.f5780i0)).setText(this.f29539a.getResources().getString(e()));
        ((TextView) view.findViewById(e.f5776g0)).setOnClickListener(new View.OnClickListener() { // from class: jd.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.this.h(view2);
            }
        });
        ((TextView) view.findViewById(e.f5778h0)).setOnClickListener(new View.OnClickListener() { // from class: jd.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                k.this.i(view2);
            }
        });
    }

    protected abstract void j(View view);

    public void k(a aVar) {
        this.f29543e = aVar;
    }

    public void l(Context context) {
        this.f29539a = context;
        f();
        this.f29542d.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(DataType dataType, float f10) {
        b.J().n(dataType, f10);
        b.J().A();
    }

    public k(h hVar, E e10) {
        this.f29540b = hVar;
        this.f29541c = e10;
    }
}
