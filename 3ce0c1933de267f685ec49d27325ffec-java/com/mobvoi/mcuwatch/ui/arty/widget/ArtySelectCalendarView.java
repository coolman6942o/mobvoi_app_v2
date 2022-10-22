package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCalendarView;
import sh.i;
import si.h;
/* loaded from: classes2.dex */
public class ArtySelectCalendarView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f19433a;

    /* renamed from: b  reason: collision with root package name */
    TextView f19434b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f19435c;

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f19436d;

    /* renamed from: e  reason: collision with root package name */
    a f19437e;

    /* renamed from: f  reason: collision with root package name */
    h f19438f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(h.c cVar);
    }

    public ArtySelectCalendarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.f19438f.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.f19438f.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(h.c cVar) {
        this.f19434b.setText(cVar.f34963c);
        a aVar = this.f19437e;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void d(int i10) {
        this.f19438f.a(i10);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(this.f19433a).inflate(i.S0, (ViewGroup) this, true);
        this.f19434b = (TextView) findViewById(sh.h.D3);
        this.f19435c = (RelativeLayout) findViewById(sh.h.G2);
        this.f19436d = (RelativeLayout) findViewById(sh.h.F2);
        this.f19438f = new h();
        this.f19435c.setOnClickListener(new View.OnClickListener() { // from class: ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtySelectCalendarView.this.e(view);
            }
        });
        this.f19436d.setOnClickListener(new View.OnClickListener() { // from class: ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtySelectCalendarView.this.f(view);
            }
        });
        this.f19438f.q(new h.a() { // from class: ui.i
            @Override // si.h.a
            public final void a(h.c cVar) {
                ArtySelectCalendarView.this.g(cVar);
            }
        });
    }

    public void setSelectTimeChangeListener(a aVar) {
        this.f19437e = aVar;
    }

    public ArtySelectCalendarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19433a = context;
    }
}
