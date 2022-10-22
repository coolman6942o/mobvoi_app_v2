package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.d0;
import androidx.fragment.app.w;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import d7.f;
import d7.h;
import d7.j;
import d7.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* compiled from: MaterialDatePicker.java */
/* loaded from: classes.dex */
public final class g<S> extends androidx.fragment.app.c {
    static final Object H = "CONFIRM_BUTTON_TAG";
    static final Object I = "CANCEL_BUTTON_TAG";
    static final Object J = "TOGGLE_BUTTON_TAG";
    private CharSequence A;
    private boolean B;
    private int C;
    private TextView D;
    private CheckableImageButton E;
    private w7.g F;
    private Button G;

    /* renamed from: q  reason: collision with root package name */
    private final LinkedHashSet<h<? super S>> f10814q = new LinkedHashSet<>();

    /* renamed from: r  reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f10815r = new LinkedHashSet<>();

    /* renamed from: s  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f10816s = new LinkedHashSet<>();

    /* renamed from: t  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f10817t = new LinkedHashSet<>();

    /* renamed from: u  reason: collision with root package name */
    private int f10818u;

    /* renamed from: v  reason: collision with root package name */
    private DateSelector<S> f10819v;

    /* renamed from: w  reason: collision with root package name */
    private m<S> f10820w;

    /* renamed from: x  reason: collision with root package name */
    private CalendarConstraints f10821x;

    /* renamed from: y  reason: collision with root package name */
    private f<S> f10822y;

    /* renamed from: z  reason: collision with root package name */
    private int f10823z;

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = g.this.f10814q.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(g.this.D0());
            }
            g.this.b0();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = g.this.f10815r.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            g.this.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes.dex */
    public class c extends l<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.l
        public void a() {
            g.this.G.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.l
        public void b(S s10) {
            g.this.M0();
            g.this.G.setEnabled(g.this.A0().m0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.G.setEnabled(g.this.A0().m0());
            g.this.E.toggle();
            g gVar = g.this;
            gVar.N0(gVar.E);
            g.this.K0();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    /* loaded from: classes.dex */
    public static final class e<S> {

        /* renamed from: a  reason: collision with root package name */
        final DateSelector<S> f10828a;

        /* renamed from: c  reason: collision with root package name */
        CalendarConstraints f10830c;

        /* renamed from: b  reason: collision with root package name */
        int f10829b = 0;

        /* renamed from: d  reason: collision with root package name */
        int f10831d = 0;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f10832e = null;

        /* renamed from: f  reason: collision with root package name */
        S f10833f = null;

        /* renamed from: g  reason: collision with root package name */
        int f10834g = 0;

        private e(DateSelector<S> dateSelector) {
            this.f10828a = dateSelector;
        }

        private Month b() {
            if (!this.f10828a.r0().isEmpty()) {
                Month c10 = Month.c(this.f10828a.r0().iterator().next().longValue());
                if (d(c10, this.f10830c)) {
                    return c10;
                }
            }
            Month d10 = Month.d();
            return d(d10, this.f10830c) ? d10 : this.f10830c.j();
        }

        public static e<Long> c() {
            return new e<>(new SingleDateSelector());
        }

        private static boolean d(Month month, CalendarConstraints calendarConstraints) {
            return month.compareTo(calendarConstraints.j()) >= 0 && month.compareTo(calendarConstraints.g()) <= 0;
        }

        public g<S> a() {
            if (this.f10830c == null) {
                this.f10830c = new CalendarConstraints.b().a();
            }
            if (this.f10831d == 0) {
                this.f10831d = this.f10828a.V();
            }
            S s10 = this.f10833f;
            if (s10 != null) {
                this.f10828a.w(s10);
            }
            if (this.f10830c.i() == null) {
                this.f10830c.m(b());
            }
            return g.I0(this);
        }

        public e<S> e(CalendarConstraints calendarConstraints) {
            this.f10830c = calendarConstraints;
            return this;
        }

        public e<S> f(S s10) {
            this.f10833f = s10;
            return this;
        }

        public e<S> g(int i10) {
            this.f10831d = i10;
            this.f10832e = null;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> A0() {
        if (this.f10819v == null) {
            this.f10819v = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f10819v;
    }

    private static int C0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(d7.d.Y);
        int i10 = Month.d().f10737d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(d7.d.f25183a0) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(d7.d.f25191e0));
    }

    private int E0(Context context) {
        int i10 = this.f10818u;
        return i10 != 0 ? i10 : A0().g0(context);
    }

    private void F0(Context context) {
        this.E.setTag(J);
        this.E.setImageDrawable(z0(context));
        this.E.setChecked(this.C != 0);
        d0.t0(this.E, null);
        N0(this.E);
        this.E.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean G0(Context context) {
        return J0(context, 16843277);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean H0(Context context) {
        return J0(context, d7.b.M);
    }

    static <S> g<S> I0(e<S> eVar) {
        g<S> gVar = new g<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", eVar.f10829b);
        bundle.putParcelable("DATE_SELECTOR_KEY", eVar.f10828a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", eVar.f10830c);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", eVar.f10831d);
        bundle.putCharSequence("TITLE_TEXT_KEY", eVar.f10832e);
        bundle.putInt("INPUT_MODE_KEY", eVar.f10834g);
        gVar.setArguments(bundle);
        return gVar;
    }

    static boolean J0(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(t7.b.d(context, d7.b.C, f.class.getCanonicalName()), new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        int E0 = E0(requireContext());
        this.f10822y = f.q0(A0(), E0, this.f10821x);
        this.f10820w = this.E.isChecked() ? i.a0(A0(), E0, this.f10821x) : this.f10822y;
        M0();
        w l10 = getChildFragmentManager().l();
        l10.s(f.H, this.f10820w);
        l10.l();
        this.f10820w.Y(new c());
    }

    public static long L0() {
        return p.o().getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        String B0 = B0();
        this.D.setContentDescription(String.format(getString(j.f25330u), B0));
        this.D.setText(B0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(CheckableImageButton checkableImageButton) {
        String str;
        if (this.E.isChecked()) {
            str = checkableImageButton.getContext().getString(j.N);
        } else {
            str = checkableImageButton.getContext().getString(j.P);
        }
        this.E.setContentDescription(str);
    }

    private static Drawable z0(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, e.a.b(context, d7.e.f25235b));
        stateListDrawable.addState(new int[0], e.a.b(context, d7.e.f25236c));
        return stateListDrawable;
    }

    public String B0() {
        return A0().n(getContext());
    }

    public final S D0() {
        return A0().w0();
    }

    @Override // androidx.fragment.app.c
    public final Dialog h0(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), E0(requireContext()));
        Context context = dialog.getContext();
        this.B = G0(context);
        int d10 = t7.b.d(context, d7.b.f25161q, g.class.getCanonicalName());
        w7.g gVar = new w7.g(context, null, d7.b.C, k.f25360y);
        this.F = gVar;
        gVar.O(context);
        this.F.Z(ColorStateList.valueOf(d10));
        this.F.Y(d0.y(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f10816s.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10818u = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f10819v = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10821x = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f10823z = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.A = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.C = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.B ? h.f25308z : h.f25307y, viewGroup);
        Context context = inflate.getContext();
        if (this.B) {
            inflate.findViewById(f.H).setLayoutParams(new LinearLayout.LayoutParams(C0(context), -2));
        } else {
            inflate.findViewById(f.I).setLayoutParams(new LinearLayout.LayoutParams(C0(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(f.O);
        this.D = textView;
        d0.v0(textView, 1);
        this.E = (CheckableImageButton) inflate.findViewById(f.P);
        TextView textView2 = (TextView) inflate.findViewById(f.T);
        CharSequence charSequence = this.A;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f10823z);
        }
        F0(context);
        this.G = (Button) inflate.findViewById(f.f25246c);
        if (A0().m0()) {
            this.G.setEnabled(true);
        } else {
            this.G.setEnabled(false);
        }
        this.G.setTag(H);
        this.G.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(f.f25242a);
        button.setTag(I);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f10817t.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f10818u);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10819v);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f10821x);
        if (this.f10822y.l0() != null) {
            bVar.c(this.f10822y.l0().f10739f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f10823z);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.A);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = l0().getWindow();
        if (this.B) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.F);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d7.d.f25187c0);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.F, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new k7.a(l0(), rect));
        }
        K0();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStop() {
        this.f10820w.Z();
        super.onStop();
    }

    public boolean y0(h<? super S> hVar) {
        return this.f10814q.add(hVar);
    }
}
