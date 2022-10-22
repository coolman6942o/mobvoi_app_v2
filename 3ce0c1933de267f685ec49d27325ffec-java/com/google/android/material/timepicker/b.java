package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.d0;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimePickerView;
import d7.f;
import d7.h;
import d7.j;
import d7.k;
import d7.l;
import java.util.LinkedHashSet;
import java.util.Set;
import w7.g;
/* compiled from: MaterialTimePicker.java */
/* loaded from: classes.dex */
public final class b extends androidx.fragment.app.c implements TimePickerView.e {
    private int A;
    private CharSequence C;
    private CharSequence E;
    private CharSequence G;
    private MaterialButton H;
    private Button I;
    private TimeModel K;

    /* renamed from: u  reason: collision with root package name */
    private TimePickerView f11616u;

    /* renamed from: v  reason: collision with root package name */
    private ViewStub f11617v;

    /* renamed from: w  reason: collision with root package name */
    private e f11618w;

    /* renamed from: x  reason: collision with root package name */
    private h f11619x;

    /* renamed from: y  reason: collision with root package name */
    private f f11620y;

    /* renamed from: z  reason: collision with root package name */
    private int f11621z;

    /* renamed from: q  reason: collision with root package name */
    private final Set<View.OnClickListener> f11612q = new LinkedHashSet();

    /* renamed from: r  reason: collision with root package name */
    private final Set<View.OnClickListener> f11613r = new LinkedHashSet();

    /* renamed from: s  reason: collision with root package name */
    private final Set<DialogInterface.OnCancelListener> f11614s = new LinkedHashSet();

    /* renamed from: t  reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f11615t = new LinkedHashSet();
    private int B = 0;
    private int D = 0;
    private int F = 0;
    private int J = 0;
    private int L = 0;

    /* compiled from: MaterialTimePicker.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : b.this.f11612q) {
                onClickListener.onClick(view);
            }
            b.this.b0();
        }
    }

    /* compiled from: MaterialTimePicker.java */
    /* renamed from: com.google.android.material.timepicker.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0135b implements View.OnClickListener {
        View$OnClickListenerC0135b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View.OnClickListener onClickListener : b.this.f11613r) {
                onClickListener.onClick(view);
            }
            b.this.b0();
        }
    }

    /* compiled from: MaterialTimePicker.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.J = bVar.J == 0 ? 1 : 0;
            b bVar2 = b.this;
            bVar2.G0(bVar2.H);
        }
    }

    /* compiled from: MaterialTimePicker.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        private int f11626b;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f11628d;

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f11630f;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f11632h;

        /* renamed from: a  reason: collision with root package name */
        private TimeModel f11625a = new TimeModel();

        /* renamed from: c  reason: collision with root package name */
        private int f11627c = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f11629e = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f11631g = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f11633i = 0;

        public b j() {
            return b.D0(this);
        }

        public d k(int i10) {
            this.f11625a.h(i10);
            return this;
        }

        public d l(int i10) {
            this.f11625a.i(i10);
            return this;
        }

        public d m(int i10) {
            TimeModel timeModel = this.f11625a;
            int i11 = timeModel.f11597d;
            int i12 = timeModel.f11598e;
            TimeModel timeModel2 = new TimeModel(i10);
            this.f11625a = timeModel2;
            timeModel2.i(i12);
            this.f11625a.h(i11);
            return this;
        }

        public d n(int i10) {
            this.f11627c = i10;
            return this;
        }
    }

    private int B0() {
        int i10 = this.L;
        if (i10 != 0) {
            return i10;
        }
        TypedValue a10 = t7.b.a(requireContext(), d7.b.J);
        if (a10 == null) {
            return 0;
        }
        return a10.data;
    }

    private f C0(int i10, TimePickerView timePickerView, ViewStub viewStub) {
        if (i10 == 0) {
            e eVar = this.f11618w;
            if (eVar == null) {
                eVar = new e(timePickerView, this.K);
            }
            this.f11618w = eVar;
            return eVar;
        }
        if (this.f11619x == null) {
            this.f11619x = new h((LinearLayout) viewStub.inflate(), this.K);
        }
        this.f11619x.e();
        return this.f11619x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b D0(d dVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", dVar.f11625a);
        bundle.putInt("TIME_PICKER_INPUT_MODE", dVar.f11626b);
        bundle.putInt("TIME_PICKER_TITLE_RES", dVar.f11627c);
        if (dVar.f11628d != null) {
            bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", dVar.f11628d);
        }
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", dVar.f11629e);
        if (dVar.f11630f != null) {
            bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", dVar.f11630f);
        }
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", dVar.f11631g);
        if (dVar.f11632h != null) {
            bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", dVar.f11632h);
        }
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", dVar.f11633i);
        bVar.setArguments(bundle);
        return bVar;
    }

    private void E0(Bundle bundle) {
        if (bundle != null) {
            TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
            this.K = timeModel;
            if (timeModel == null) {
                this.K = new TimeModel();
            }
            this.J = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
            this.B = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
            this.C = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
            this.D = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
            this.E = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
            this.F = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
            this.G = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
            this.L = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
        }
    }

    private void F0() {
        Button button = this.I;
        if (button != null) {
            button.setVisibility(g0() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(MaterialButton materialButton) {
        if (materialButton != null && this.f11616u != null && this.f11617v != null) {
            f fVar = this.f11620y;
            if (fVar != null) {
                fVar.g();
            }
            f C0 = C0(this.J, this.f11616u, this.f11617v);
            this.f11620y = C0;
            C0.a();
            this.f11620y.c();
            Pair<Integer, Integer> y02 = y0(this.J);
            materialButton.setIconResource(((Integer) y02.first).intValue());
            materialButton.setContentDescription(getResources().getString(((Integer) y02.second).intValue()));
            materialButton.sendAccessibilityEvent(4);
        }
    }

    private Pair<Integer, Integer> y0(int i10) {
        if (i10 == 0) {
            return new Pair<>(Integer.valueOf(this.f11621z), Integer.valueOf(j.f25325p));
        }
        if (i10 == 1) {
            return new Pair<>(Integer.valueOf(this.A), Integer.valueOf(j.f25322m));
        }
        throw new IllegalArgumentException("no icon for mode: " + i10);
    }

    public int A0() {
        return this.K.f11598e;
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    public void B() {
        this.J = 1;
        G0(this.H);
        this.f11619x.j();
    }

    @Override // androidx.fragment.app.c
    public final Dialog h0(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), B0());
        Context context = dialog.getContext();
        int d10 = t7.b.d(context, d7.b.f25161q, b.class.getCanonicalName());
        int i10 = d7.b.I;
        int i11 = k.C;
        g gVar = new g(context, null, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, l.f25549x3, i10, i11);
        this.A = obtainStyledAttributes.getResourceId(l.f25557y3, 0);
        this.f11621z = obtainStyledAttributes.getResourceId(l.f25565z3, 0);
        obtainStyledAttributes.recycle();
        gVar.O(context);
        gVar.Z(ColorStateList.valueOf(d10));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(gVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        gVar.Y(d0.y(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.f11614s) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        E0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(h.f25298p, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(f.f25277x);
        this.f11616u = timePickerView;
        timePickerView.O(this);
        this.f11617v = (ViewStub) viewGroup2.findViewById(f.f25273t);
        this.H = (MaterialButton) viewGroup2.findViewById(f.f25275v);
        TextView textView = (TextView) viewGroup2.findViewById(f.f25256h);
        int i10 = this.B;
        if (i10 != 0) {
            textView.setText(i10);
        } else if (!TextUtils.isEmpty(this.C)) {
            textView.setText(this.C);
        }
        G0(this.H);
        Button button = (Button) viewGroup2.findViewById(f.f25276w);
        button.setOnClickListener(new a());
        int i11 = this.D;
        if (i11 != 0) {
            button.setText(i11);
        } else if (!TextUtils.isEmpty(this.E)) {
            button.setText(this.E);
        }
        Button button2 = (Button) viewGroup2.findViewById(f.f25274u);
        this.I = button2;
        button2.setOnClickListener(new View$OnClickListenerC0135b());
        int i12 = this.F;
        if (i12 != 0) {
            this.I.setText(i12);
        } else if (!TextUtils.isEmpty(this.G)) {
            this.I.setText(this.G);
        }
        F0();
        this.H.setOnClickListener(new c());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11620y = null;
        this.f11618w = null;
        this.f11619x = null;
        TimePickerView timePickerView = this.f11616u;
        if (timePickerView != null) {
            timePickerView.O(null);
            this.f11616u = null;
        }
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f11615t) {
            onDismissListener.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.K);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.J);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.B);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.C);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.D);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.E);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.F);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.G);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.L);
    }

    public boolean x0(View.OnClickListener onClickListener) {
        return this.f11612q.add(onClickListener);
    }

    public int z0() {
        return this.K.f11597d % 24;
    }
}
