package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.b;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.unionpay.tsmservice.data.Constant;
import d7.j;
/* compiled from: TimePickerClockPresenter.java */
/* loaded from: classes.dex */
class e implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, f {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f11639f = {"12", "1", "2", Constant.APPLY_MODE_DECIDED_BY_BANK, "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f11640g = {"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f11641h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a  reason: collision with root package name */
    private TimePickerView f11642a;

    /* renamed from: b  reason: collision with root package name */
    private TimeModel f11643b;

    /* renamed from: c  reason: collision with root package name */
    private float f11644c;

    /* renamed from: d  reason: collision with root package name */
    private float f11645d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11646e = false;

    public e(TimePickerView timePickerView, TimeModel timeModel) {
        this.f11642a = timePickerView;
        this.f11643b = timeModel;
        j();
    }

    private int h() {
        return this.f11643b.f11596c == 1 ? 15 : 30;
    }

    private String[] i() {
        return this.f11643b.f11596c == 1 ? f11640g : f11639f;
    }

    private void k(int i10, int i11) {
        TimeModel timeModel = this.f11643b;
        if (timeModel.f11598e != i11 || timeModel.f11597d != i10) {
            this.f11642a.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
        }
    }

    private void m() {
        TimePickerView timePickerView = this.f11642a;
        TimeModel timeModel = this.f11643b;
        timePickerView.V(timeModel.f11600g, timeModel.c(), this.f11643b.f11598e);
    }

    private void n() {
        o(f11639f, "%d");
        o(f11640g, "%d");
        o(f11641h, "%02d");
    }

    private void o(String[] strArr, String str) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr[i10] = TimeModel.b(this.f11642a.getResources(), strArr[i10], str);
        }
    }

    @Override // com.google.android.material.timepicker.f
    public void a() {
        this.f11642a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void b(float f10, boolean z10) {
        if (!this.f11646e) {
            TimeModel timeModel = this.f11643b;
            int i10 = timeModel.f11597d;
            int i11 = timeModel.f11598e;
            int round = Math.round(f10);
            TimeModel timeModel2 = this.f11643b;
            if (timeModel2.f11599f == 12) {
                timeModel2.i((round + 3) / 6);
                this.f11644c = (float) Math.floor(this.f11643b.f11598e * 6);
            } else {
                this.f11643b.g((round + (h() / 2)) / h());
                this.f11645d = this.f11643b.c() * h();
            }
            if (!z10) {
                m();
                k(i10, i11);
            }
        }
    }

    @Override // com.google.android.material.timepicker.f
    public void c() {
        this.f11645d = this.f11643b.c() * h();
        TimeModel timeModel = this.f11643b;
        this.f11644c = timeModel.f11598e * 6;
        l(timeModel.f11599f, false);
        m();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void d(float f10, boolean z10) {
        this.f11646e = true;
        TimeModel timeModel = this.f11643b;
        int i10 = timeModel.f11598e;
        int i11 = timeModel.f11597d;
        if (timeModel.f11599f == 10) {
            this.f11642a.K(this.f11645d, false);
            if (!((AccessibilityManager) b.i(this.f11642a.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                l(12, true);
            }
        } else {
            int round = Math.round(f10);
            if (!z10) {
                this.f11643b.i(((round + 15) / 30) * 5);
                this.f11644c = this.f11643b.f11598e * 6;
            }
            this.f11642a.K(this.f11644c, z10);
        }
        this.f11646e = false;
        m();
        k(i11, i10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void e(int i10) {
        this.f11643b.j(i10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void f(int i10) {
        l(i10, true);
    }

    @Override // com.google.android.material.timepicker.f
    public void g() {
        this.f11642a.setVisibility(8);
    }

    public void j() {
        if (this.f11643b.f11596c == 0) {
            this.f11642a.U();
        }
        this.f11642a.H(this);
        this.f11642a.Q(this);
        this.f11642a.P(this);
        this.f11642a.N(this);
        n();
        c();
    }

    void l(int i10, boolean z10) {
        boolean z11 = i10 == 12;
        this.f11642a.J(z11);
        this.f11643b.f11599f = i10;
        this.f11642a.S(z11 ? f11641h : i(), z11 ? j.f25321l : j.f25319j);
        this.f11642a.K(z11 ? this.f11644c : this.f11645d, z10);
        this.f11642a.I(i10);
        this.f11642a.M(new a(this.f11642a.getContext(), j.f25318i));
        this.f11642a.L(new a(this.f11642a.getContext(), j.f25320k));
    }
}
