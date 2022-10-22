package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: z  reason: collision with root package name */
    private final a f3575z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!CheckBoxPreference.this.a(Boolean.valueOf(z10))) {
                compoundButton.setChecked(!z10);
            } else {
                CheckBoxPreference.this.L(z10);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    private void Q(View view) {
        boolean z10 = view instanceof CompoundButton;
        if (z10) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3630u);
        }
        if (z10) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f3575z);
        }
    }

    private void R(View view) {
        if (((AccessibilityManager) c().getSystemService("accessibility")).isEnabled()) {
            Q(view.findViewById(16908289));
            P(view.findViewById(16908304));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void D(View view) {
        super.D(view);
        R(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3575z = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3648a, i10, i11);
        O(i.o(obtainStyledAttributes, g.f3661g, g.f3651b));
        N(i.o(obtainStyledAttributes, g.f3659f, g.f3653c));
        M(i.b(obtainStyledAttributes, g.f3657e, g.f3655d, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3636a, 16842895));
    }
}
