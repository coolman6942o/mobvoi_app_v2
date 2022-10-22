package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private CharSequence A;
    private CharSequence B;

    /* renamed from: z  reason: collision with root package name */
    private final a f3628z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!SwitchPreferenceCompat.this.a(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                SwitchPreferenceCompat.this.L(z10);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3628z = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.Q0, i10, i11);
        O(i.o(obtainStyledAttributes, g.Y0, g.R0));
        N(i.o(obtainStyledAttributes, g.X0, g.S0));
        R(i.o(obtainStyledAttributes, g.f3650a1, g.U0));
        Q(i.o(obtainStyledAttributes, g.Z0, g.V0));
        M(i.b(obtainStyledAttributes, g.W0, g.T0, false));
        obtainStyledAttributes.recycle();
    }

    private void S(View view) {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3630u);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.A);
            switchCompat.setTextOff(this.B);
            switchCompat.setOnCheckedChangeListener(this.f3628z);
        }
    }

    private void T(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            S(view.findViewById(d.f3646a));
            P(view.findViewById(16908304));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void D(View view) {
        super.D(view);
        T(view);
    }

    public void Q(CharSequence charSequence) {
        this.B = charSequence;
        w();
    }

    public void R(CharSequence charSequence) {
        this.A = charSequence;
        w();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f3644i);
    }
}
