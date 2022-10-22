package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.d0;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import d7.h;
import java.util.Locale;
/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    private f A;
    private g B;
    private e C;

    /* renamed from: u  reason: collision with root package name */
    private final Chip f11601u;

    /* renamed from: v  reason: collision with root package name */
    private final Chip f11602v;

    /* renamed from: w  reason: collision with root package name */
    private final ClockHandView f11603w;

    /* renamed from: x  reason: collision with root package name */
    private final ClockFaceView f11604x;

    /* renamed from: y  reason: collision with root package name */
    private final MaterialButtonToggleGroup f11605y;

    /* renamed from: z  reason: collision with root package name */
    private final View.OnClickListener f11606z;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.B != null) {
                TimePickerView.this.B.f(((Integer) view.getTag(d7.f.f25245b0)).intValue());
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
            int i11 = i10 == d7.f.f25266m ? 1 : 0;
            if (TimePickerView.this.A != null && z10) {
                TimePickerView.this.A.e(i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            e eVar = TimePickerView.this.C;
            if (eVar == null) {
                return false;
            }
            eVar.B();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f11610a;

        d(TimePickerView timePickerView, GestureDetector gestureDetector) {
            this.f11610a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f11610a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    interface e {
        void B();
    }

    /* loaded from: classes.dex */
    interface f {
        void e(int i10);
    }

    /* loaded from: classes.dex */
    interface g {
        void f(int i10);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void R() {
        Chip chip = this.f11601u;
        int i10 = d7.f.f25245b0;
        chip.setTag(i10, 12);
        this.f11602v.setTag(i10, 10);
        this.f11601u.setOnClickListener(this.f11606z);
        this.f11602v.setOnClickListener(this.f11606z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void T() {
        d dVar = new d(this, new GestureDetector(getContext(), new c()));
        this.f11601u.setOnTouchListener(dVar);
        this.f11602v.setOnTouchListener(dVar);
    }

    private void W() {
        if (this.f11605y.getVisibility() == 0) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.g(this);
            int i10 = 1;
            if (d0.E(this) == 0) {
                i10 = 2;
            }
            cVar.e(d7.f.f25258i, i10);
            cVar.c(this);
        }
    }

    public void H(ClockHandView.d dVar) {
        this.f11603w.b(dVar);
    }

    public void I(int i10) {
        boolean z10 = true;
        this.f11601u.setChecked(i10 == 12);
        Chip chip = this.f11602v;
        if (i10 != 10) {
            z10 = false;
        }
        chip.setChecked(z10);
    }

    public void J(boolean z10) {
        this.f11603w.j(z10);
    }

    public void K(float f10, boolean z10) {
        this.f11603w.m(f10, z10);
    }

    public void L(androidx.core.view.a aVar) {
        d0.t0(this.f11601u, aVar);
    }

    public void M(androidx.core.view.a aVar) {
        d0.t0(this.f11602v, aVar);
    }

    public void N(ClockHandView.c cVar) {
        this.f11603w.o(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(e eVar) {
        this.C = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(f fVar) {
        this.A = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(g gVar) {
        this.B = gVar;
    }

    public void S(String[] strArr, int i10) {
        this.f11604x.Q(strArr, i10);
    }

    public void U() {
        this.f11605y.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void V(int i10, int i11, int i12) {
        this.f11605y.j(i10 == 1 ? d7.f.f25266m : d7.f.f25264l);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(i12));
        String format2 = String.format(locale, "%02d", Integer.valueOf(i11));
        this.f11601u.setText(format);
        this.f11602v.setText(format2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        W();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            W();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11606z = new a();
        LayoutInflater.from(context).inflate(h.f25297o, this);
        this.f11604x = (ClockFaceView) findViewById(d7.f.f25260j);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(d7.f.f25267n);
        this.f11605y = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        Chip chip = (Chip) findViewById(d7.f.f25272s);
        this.f11601u = chip;
        Chip chip2 = (Chip) findViewById(d7.f.f25269p);
        this.f11602v = chip2;
        this.f11603w = (ClockHandView) findViewById(d7.f.f25262k);
        d0.v0(chip, 2);
        d0.v0(chip2, 2);
        T();
        R();
    }
}
