package androidx.preference;

import a0.i;
import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return !super.u();
    }

    @Override // androidx.preference.Preference
    public boolean u() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3640e, 16842892));
    }
}
