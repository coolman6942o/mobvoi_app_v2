package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.mcuwatch.ui.arty.adapter.ArtyTrendsDataListAdapter;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCalendarView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCommonView;
import com.mobvoi.mcuwatch.ui.arty.widget.d;
import gg.c;
import gg.e;
import gg.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nf.j;
import sh.i;
import si.h;
import ti.b;
import ui.l;
import ui.o;
/* compiled from: ArtyTrendsView.java */
/* loaded from: classes2.dex */
public class d extends o<e> {
    ArtySelectCommonView H;
    ArtySelectCommonView I;
    ArtyDataChartView J;
    ArtySelectCalendarView K;
    RecyclerView L;
    private long M;
    private long N;
    ArtyTrendsDataListAdapter O;
    private List<b> P;
    private int Q;
    private long R;
    private long S;
    private SparseArray<Pair<Long, Long>> T;

    public d(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i10) {
        this.J.c(i10);
        this.K.d(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(int i10) {
        this.J.d(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(h.c cVar) {
        this.J.b(cVar);
        this.M = cVar.f34961a;
        this.N = cVar.f34962b;
        Pair<Long, Long> pair = this.T.get(cVar.f34964d);
        if (pair == null || this.M < ((Long) pair.first).longValue() || this.N > ((Long) pair.second).longValue()) {
            if (pair == null) {
                ((e) this.F).L(this.M, this.N, 1);
            }
            Calendar calendar = Calendar.getInstance();
            int i10 = cVar.f34964d;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            this.R = this.M;
                            this.S = this.N;
                        }
                    } else if (cVar.f34966f) {
                        calendar.setTimeInMillis(this.N);
                        calendar.add(2, 6);
                        this.S = calendar.getTimeInMillis();
                        this.R = this.M;
                    } else {
                        calendar.setTimeInMillis(this.M);
                        calendar.add(2, -6);
                        this.R = calendar.getTimeInMillis();
                        this.S = this.N;
                    }
                } else if (cVar.f34966f) {
                    calendar.setTimeInMillis(this.N);
                    calendar.add(2, 3);
                    this.S = calendar.getTimeInMillis();
                    this.R = this.M;
                } else {
                    calendar.setTimeInMillis(this.M);
                    calendar.add(2, -3);
                    this.R = calendar.getTimeInMillis();
                    this.S = this.N;
                }
            } else if (cVar.f34966f) {
                calendar.setTimeInMillis(this.N);
                calendar.add(6, 28);
                this.S = calendar.getTimeInMillis();
                this.R = this.M;
            } else {
                calendar.setTimeInMillis(this.M);
                calendar.add(6, -28);
                this.R = calendar.getTimeInMillis();
                this.S = this.N;
            }
            if (pair == null) {
                this.T.put(cVar.f34964d, Pair.create(Long.valueOf(this.R), Long.valueOf(this.S)));
            } else {
                long longValue = ((Long) pair.first).longValue();
                long longValue2 = ((Long) pair.second).longValue();
                long j10 = this.R;
                if (j10 < longValue) {
                    longValue = j10;
                }
                long j11 = this.S;
                if (j11 > longValue2) {
                    longValue2 = j11;
                }
                this.T.put(cVar.f34964d, Pair.create(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
            VM vm2 = this.F;
            if (vm2 != 0) {
                ((e) vm2).p(this.R, this.S);
                return;
            }
            return;
        }
        ((e) this.F).L(this.M, this.N, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f0(f fVar, f fVar2) {
        return (int) (fVar2.f27464a - fVar.f27464a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Map map) {
        this.J.setArtyDetailData(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry.getValue() == null || ((List) entry.getValue()).get(this.Q) == null)) {
                arrayList.addAll(((c) ((List) entry.getValue()).get(this.Q)).f27463g);
            }
        }
        this.P.clear();
        this.P.add(new b(0));
        if (arrayList.size() > 0) {
            arrayList.sort(l.f35460a);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.P.add(new b(1, (f) it.next(), this.Q));
            }
        }
        this.O.setNewData(this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Object obj) {
        i0();
    }

    private void i0() {
        VM vm2 = this.F;
        if (vm2 != 0) {
            long j10 = this.M;
            if (j10 != 0) {
                long j11 = this.N;
                if (j11 != 0) {
                    ((e) vm2).L(j10, j11, 1);
                }
            }
        }
    }

    @Override // ui.o
    public void U() {
        LayoutInflater.from(this.C).inflate(i.Y0, (ViewGroup) this, true);
        this.H = (ArtySelectCommonView) findViewById(sh.h.f34658k3);
        this.I = (ArtySelectCommonView) findViewById(sh.h.f34686q4);
        this.J = (ArtyDataChartView) findViewById(sh.h.w_res_0x7f0b00ac);
        this.K = (ArtySelectCalendarView) findViewById(sh.h.E_res_0x7f0b00bc);
        this.L = (RecyclerView) findViewById(sh.h.x_res_0x7f0b00ad);
        this.P = new ArrayList();
        ArtyTrendsDataListAdapter artyTrendsDataListAdapter = new ArtyTrendsDataListAdapter(this.C, this.P);
        this.O = artyTrendsDataListAdapter;
        artyTrendsDataListAdapter.bindToRecyclerView(this.L);
        this.L.setLayoutManager(new LinearLayoutManager(this.C));
        this.H.setSelectItem(getResources().getStringArray(sh.b.f_res_0x7f03000e));
        this.I.setSelectItem(getResources().getStringArray(sh.b.l_res_0x7f030014));
        this.H.setItemSelectListener(new ArtySelectCommonView.a() { // from class: com.mobvoi.mcuwatch.ui.arty.widget.c
            @Override // com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCommonView.a
            public final void a(int i10) {
                d.this.c0(i10);
            }
        });
        this.I.setItemSelectListener(new ArtySelectCommonView.a() { // from class: com.mobvoi.mcuwatch.ui.arty.widget.b
            @Override // com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCommonView.a
            public final void a(int i10) {
                d.this.d0(i10);
            }
        });
        this.K.setSelectTimeChangeListener(new ArtySelectCalendarView.a() { // from class: com.mobvoi.mcuwatch.ui.arty.widget.a
            @Override // com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCalendarView.a
            public final void a(h.c cVar) {
                d.this.e0(cVar);
            }
        });
    }

    @Override // ui.o
    public void V() {
        this.G.clear();
        this.G.a(j.b(((e) this.F).q(), new j.a() { // from class: ui.m
            @Override // nf.j.a
            public final void call(Object obj) {
                d.this.g0((Map) obj);
            }
        }));
        this.G.a(j.b(((e) this.F).x(), new j.a() { // from class: ui.n
            @Override // nf.j.a
            public final void call(Object obj) {
                d.this.h0(obj);
            }
        }));
        ((e) this.F).b();
        this.K.d(0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // ui.o
    public void setArtyBundleData(Bundle bundle) {
        int i10 = bundle.getInt("data_type");
        this.Q = i10;
        this.J.setArtyDataType(i10);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.T = new SparseArray<>();
    }
}
