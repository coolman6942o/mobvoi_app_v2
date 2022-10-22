package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private CharSequence A;
    private CharSequence B;

    /* renamed from: z  reason: collision with root package name */
    private final a f3626z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!SwitchPreference.this.a(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                SwitchPreference.this.L(z10);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3626z = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.F0, i10, i11);
        O(i.o(obtainStyledAttributes, g.N0, g.G0));
        N(i.o(obtainStyledAttributes, g.M0, g.H0));
        R(i.o(obtainStyledAttributes, g.P0, g.J0));
        Q(i.o(obtainStyledAttributes, g.O0, g.K0));
        M(i.b(obtainStyledAttributes, g.L0, g.I0, false));
        obtainStyledAttributes.recycle();
    }

    private void S(View view) {
        boolean z10 = view instanceof Switch;
        if (z10) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3630u);
        }
        if (z10) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.A);
            r42.setTextOff(this.B);
            r42.setOnCheckedChangeListener(this.f3626z);
        }
    }

    private void T(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            S(view.findViewById(16908352));
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

    public SwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3645j, 16843629));
    }
}
