package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.d0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class f<S> extends m<S> {

    /* renamed from: l  reason: collision with root package name */
    static final Object f10785l = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: m  reason: collision with root package name */
    static final Object f10786m = "NAVIGATION_PREV_TAG";

    /* renamed from: n  reason: collision with root package name */
    static final Object f10787n = "NAVIGATION_NEXT_TAG";

    /* renamed from: o  reason: collision with root package name */
    static final Object f10788o = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b  reason: collision with root package name */
    private int f10789b;

    /* renamed from: c  reason: collision with root package name */
    private DateSelector<S> f10790c;

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f10791d;

    /* renamed from: e  reason: collision with root package name */
    private Month f10792e;

    /* renamed from: f  reason: collision with root package name */
    private k f10793f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.material.datepicker.b f10794g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f10795h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f10796i;

    /* renamed from: j  reason: collision with root package name */
    private View f10797j;

    /* renamed from: k  reason: collision with root package name */
    private View f10798k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10799a;

        a(int i10) {
            this.f10799a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f10796i.w1(this.f10799a);
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    class b extends androidx.core.view.a {
        b(f fVar) {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    class c extends n {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.I = i11;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void N1(RecyclerView.y yVar, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = f.this.f10796i.getWidth();
                iArr[1] = f.this.f10796i.getWidth();
                return;
            }
            iArr[0] = f.this.f10796i.getHeight();
            iArr[1] = f.this.f10796i.getHeight();
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.f.l
        public void a(long j10) {
            if (f.this.f10791d.f().i0(j10)) {
                f.this.f10790c.A0(j10);
                Iterator<com.google.android.material.datepicker.l<S>> it = f.this.f10854a.iterator();
                while (it.hasNext()) {
                    it.next().b((S) f.this.f10790c.w0());
                }
                f.this.f10796i.getAdapter().notifyDataSetChanged();
                if (f.this.f10795h != null) {
                    f.this.f10795h.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f10802a = p.q();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f10803b = p.q();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            int i10;
            if ((recyclerView.getAdapter() instanceof q) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                q qVar = (q) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (j0.d<Long, Long> dVar : f.this.f10790c.q()) {
                    Long l10 = dVar.f29364a;
                    if (!(l10 == null || dVar.f29365b == null)) {
                        this.f10802a.setTimeInMillis(l10.longValue());
                        this.f10803b.setTimeInMillis(dVar.f29365b.longValue());
                        int e10 = qVar.e(this.f10802a.get(1));
                        int e11 = qVar.e(this.f10803b.get(1));
                        View D = gridLayoutManager.D(e10);
                        View D2 = gridLayoutManager.D(e11);
                        int W2 = e10 / gridLayoutManager.W2();
                        int W22 = e11 / gridLayoutManager.W2();
                        int i11 = W2;
                        while (i11 <= W22) {
                            View D3 = gridLayoutManager.D(gridLayoutManager.W2() * i11);
                            if (D3 != null) {
                                int top = D3.getTop() + f.this.f10794g.f10766d.c();
                                int bottom = D3.getBottom() - f.this.f10794g.f10766d.b();
                                int left = i11 == W2 ? D.getLeft() + (D.getWidth() / 2) : 0;
                                if (i11 == W22) {
                                    i10 = D2.getLeft() + (D2.getWidth() / 2);
                                } else {
                                    i10 = recyclerView.getWidth();
                                }
                                canvas.drawRect(left, top, i10, bottom, f.this.f10794g.f10770h);
                            }
                            i11++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* renamed from: com.google.android.material.datepicker.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0122f extends androidx.core.view.a {
        C0122f() {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            String str;
            super.g(view, cVar);
            if (f.this.f10798k.getVisibility() == 0) {
                str = f.this.getString(d7.j.Q);
            } else {
                str = f.this.getString(d7.j.O);
            }
            cVar.l0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class g extends RecyclerView.s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f10806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f10807b;

        g(com.google.android.material.datepicker.k kVar, MaterialButton materialButton) {
            this.f10806a = kVar;
            this.f10807b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                CharSequence text = this.f10807b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i10, int i11) {
            int i12;
            if (i10 < 0) {
                i12 = f.this.p0().Z1();
            } else {
                i12 = f.this.p0().c2();
            }
            f.this.f10792e = this.f10806a.d(i12);
            this.f10807b.setText(this.f10806a.e(i12));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f10810a;

        i(com.google.android.material.datepicker.k kVar) {
            this.f10810a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int Z1 = f.this.p0().Z1() + 1;
            if (Z1 < f.this.f10796i.getAdapter().getItemCount()) {
                f.this.s0(this.f10810a.d(Z1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.k f10812a;

        j(com.google.android.material.datepicker.k kVar) {
            this.f10812a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c22 = f.this.p0().c2() - 1;
            if (c22 >= 0) {
                f.this.s0(this.f10812a.d(c22));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes.dex */
    public interface l {
        void a(long j10);
    }

    private void h0(View view, com.google.android.material.datepicker.k kVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(d7.f.A);
        materialButton.setTag(f10788o);
        d0.t0(materialButton, new C0122f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(d7.f.C);
        materialButton2.setTag(f10786m);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(d7.f.B);
        materialButton3.setTag(f10787n);
        this.f10797j = view.findViewById(d7.f.K);
        this.f10798k = view.findViewById(d7.f.F);
        t0(k.DAY);
        materialButton.setText(this.f10792e.h(view.getContext()));
        this.f10796i.l(new g(kVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(kVar));
        materialButton2.setOnClickListener(new j(kVar));
    }

    private RecyclerView.n i0() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n0(Context context) {
        return context.getResources().getDimensionPixelSize(d7.d.Z);
    }

    private static int o0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(d7.d.f25197h0) + resources.getDimensionPixelOffset(d7.d.f25199i0) + resources.getDimensionPixelOffset(d7.d.f25195g0);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(d7.d.f25185b0);
        int i10 = com.google.android.material.datepicker.j.f10839f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(d7.d.Z) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(d7.d.f25193f0)) + resources.getDimensionPixelOffset(d7.d.X);
    }

    public static <T> f<T> q0(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        f<T> fVar = new f<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.i());
        fVar.setArguments(bundle);
        return fVar;
    }

    private void r0(int i10) {
        this.f10796i.post(new a(i10));
    }

    @Override // com.google.android.material.datepicker.m
    public boolean Y(com.google.android.material.datepicker.l<S> lVar) {
        return super.Y(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints j0() {
        return this.f10791d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b k0() {
        return this.f10794g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month l0() {
        return this.f10792e;
    }

    public DateSelector<S> m0() {
        return this.f10790c;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10789b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10790c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f10791d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f10792e = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f10789b);
        this.f10794g = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month j10 = this.f10791d.j();
        if (com.google.android.material.datepicker.g.G0(contextThemeWrapper)) {
            i11 = d7.h.f25303u;
            i10 = 1;
        } else {
            i11 = d7.h.f25301s;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i11, viewGroup, false);
        inflate.setMinimumHeight(o0(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(d7.f.G);
        d0.t0(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.e());
        gridView.setNumColumns(j10.f10737d);
        gridView.setEnabled(false);
        this.f10796i = (RecyclerView) inflate.findViewById(d7.f.J);
        this.f10796i.setLayoutManager(new c(getContext(), i10, false, i10));
        this.f10796i.setTag(f10785l);
        com.google.android.material.datepicker.k kVar = new com.google.android.material.datepicker.k(contextThemeWrapper, this.f10790c, this.f10791d, new d());
        this.f10796i.setAdapter(kVar);
        int integer = contextThemeWrapper.getResources().getInteger(d7.g.f25282c);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(d7.f.K);
        this.f10795h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f10795h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f10795h.setAdapter(new q(this));
            this.f10795h.h(i0());
        }
        if (inflate.findViewById(d7.f.A) != null) {
            h0(inflate, kVar);
        }
        if (!com.google.android.material.datepicker.g.G0(contextThemeWrapper)) {
            new n().b(this.f10796i);
        }
        this.f10796i.o1(kVar.f(this.f10792e));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f10789b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f10790c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10791d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f10792e);
    }

    LinearLayoutManager p0() {
        return (LinearLayoutManager) this.f10796i.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s0(Month month) {
        com.google.android.material.datepicker.k kVar = (com.google.android.material.datepicker.k) this.f10796i.getAdapter();
        int f10 = kVar.f(month);
        int f11 = f10 - kVar.f(this.f10792e);
        boolean z10 = true;
        boolean z11 = Math.abs(f11) > 3;
        if (f11 <= 0) {
            z10 = false;
        }
        this.f10792e = month;
        if (z11 && z10) {
            this.f10796i.o1(f10 - 3);
            r0(f10);
        } else if (z11) {
            this.f10796i.o1(f10 + 3);
            r0(f10);
        } else {
            r0(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0(k kVar) {
        this.f10793f = kVar;
        if (kVar == k.YEAR) {
            this.f10795h.getLayoutManager().y1(((q) this.f10795h.getAdapter()).e(this.f10792e.f10736c));
            this.f10797j.setVisibility(0);
            this.f10798k.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f10797j.setVisibility(8);
            this.f10798k.setVisibility(0);
            s0(this.f10792e);
        }
    }

    void u0() {
        k kVar = this.f10793f;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            t0(k.DAY);
        } else if (kVar == k.DAY) {
            t0(kVar2);
        }
    }
}
