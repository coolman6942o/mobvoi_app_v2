package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataTitleView;
import gg.c;
import java.util.List;
import java.util.Map;
import kh.w;
import nf.j;
import nf.m;
import sh.b;
import sh.e;
import sh.f;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class ArtyDataTitleView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f19369a;

    /* renamed from: b  reason: collision with root package name */
    private View f19370b;

    /* renamed from: c  reason: collision with root package name */
    TextView f19371c;

    /* renamed from: d  reason: collision with root package name */
    TextView f19372d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f19373e;

    /* renamed from: f  reason: collision with root package name */
    private float f19374f;

    /* renamed from: g  reason: collision with root package name */
    a f19375g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19376h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f19377i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f19378j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f19379k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f19380l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f19381m;

    /* renamed from: n  reason: collision with root package name */
    private String[] f19382n;

    /* renamed from: o  reason: collision with root package name */
    private String[] f19383o;

    /* renamed from: p  reason: collision with root package name */
    protected m f19384p;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b(int i10);
    }

    public ArtyDataTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e(int i10) {
        this.f19380l = new int[4];
        TypedArray obtainTypedArray = getResources().obtainTypedArray(i10);
        int i11 = 0;
        while (true) {
            int[] iArr = this.f19380l;
            if (i11 < iArr.length) {
                iArr[i11] = obtainTypedArray.getResourceId(i11, 0);
                i11++;
            } else {
                obtainTypedArray.recycle();
                return;
            }
        }
    }

    private void f() {
        LayoutInflater.from(this.f19369a).inflate(i.N0, (ViewGroup) this, true);
        this.f19377i = (ImageView) findViewById(h.f34683q1);
        this.f19378j = (TextView) findViewById(h.f34702u3);
        this.f19379k = (TextView) findViewById(h.f34698t3);
        this.f19373e = (ImageView) findViewById(h.f34696t1);
        this.f19370b = findViewById(h.f34712w4);
        this.f19371c = (TextView) findViewById(h.f34716x3);
        this.f19372d = (TextView) findViewById(h.f34721y3);
        this.f19373e.setOnClickListener(new View.OnClickListener() { // from class: ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtyDataTitleView.this.g(view);
            }
        });
        this.f19371c.setOnClickListener(new View.OnClickListener() { // from class: ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtyDataTitleView.this.h(view);
            }
        });
        this.f19372d.setOnClickListener(new View.OnClickListener() { // from class: ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtyDataTitleView.this.i(view);
            }
        });
        this.f19374f = getResources().getDimension(e.D0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        a aVar = this.f19375g;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        a aVar = this.f19375g;
        if (aVar != null) {
            aVar.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        a aVar = this.f19375g;
        if (aVar != null) {
            aVar.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i10, Map map) {
        if (i10 == 1) {
            this.f19377i.setImageResource(f.f34567m1);
        } else if (i10 == 4) {
            this.f19377i.setImageResource(f.G0);
        } else {
            long j10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                if (j10 < ((Long) entry.getKey()).longValue()) {
                    j10 = ((Long) entry.getKey()).longValue();
                }
            }
            if (j10 > 0 && map.get(Long.valueOf(j10)) != null) {
                this.f19377i.setImageResource(this.f19380l[com.mobvoi.companion.health.widget.arty.a.f17142a.l(i10, ((c) ((List) map.get(Long.valueOf(j10))).get(i10)).f27461e)]);
            }
        }
    }

    private void setSelectTitleLineLayoutParams(boolean z10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19370b.getLayoutParams();
        layoutParams.width = (int) ((getWidth() / 2) - this.f19374f);
        layoutParams.addRule(9);
        if (z10) {
            layoutParams.leftMargin = (int) this.f19374f;
        } else {
            layoutParams.leftMargin = getWidth() / 2;
        }
        this.f19370b.setLayoutParams(layoutParams);
    }

    public void k() {
        this.f19384p.clear();
    }

    public void l(final int i10, w wVar) {
        this.f19377i.setImageResource(this.f19381m[i10]);
        if (i10 == 0) {
            e(b.r_res_0x7f03001a);
        } else if (i10 == 2) {
            e(b.p_res_0x7f030018);
        } else if (i10 == 3) {
            e(b.q_res_0x7f030019);
        }
        this.f19378j.setText(this.f19382n[i10]);
        this.f19379k.setText(this.f19383o[i10]);
        this.f19384p.clear();
        this.f19384p.a(j.b(wVar.t(), new j.a() { // from class: ui.d
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyDataTitleView.this.j(i10, (Map) obj);
            }
        }));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f19376h) {
            setSelectTitleView(0);
            this.f19376h = true;
        }
    }

    public void setSelectTitleClickListener(a aVar) {
        this.f19375g = aVar;
    }

    public void setSelectTitleView(int i10) {
        if (i10 == 0) {
            this.f19371c.setSelected(true);
            this.f19372d.setSelected(false);
            setSelectTitleLineLayoutParams(true);
        } else if (i10 == 1) {
            this.f19371c.setSelected(false);
            this.f19372d.setSelected(true);
            setSelectTitleLineLayoutParams(false);
        }
    }

    public ArtyDataTitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19384p = new m();
        this.f19369a = context;
        int[] intArray = getResources().getIntArray(b.i_res_0x7f030011);
        this.f19381m = new int[intArray.length];
        TypedArray obtainTypedArray = getResources().obtainTypedArray(b.j_res_0x7f030012);
        for (int i11 = 0; i11 < intArray.length; i11++) {
            this.f19381m[i11] = obtainTypedArray.getResourceId(i11, 0);
        }
        obtainTypedArray.recycle();
        this.f19382n = getResources().getStringArray(b.h_res_0x7f030010);
        this.f19383o = getResources().getStringArray(b.g_res_0x7f03000f);
        f();
    }
}
