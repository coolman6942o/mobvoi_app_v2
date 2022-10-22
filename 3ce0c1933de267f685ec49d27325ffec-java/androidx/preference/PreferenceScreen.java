package androidx.preference;

import a0.i;
import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, i.a(context, c.f3641f, 16842891));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void y() {
        if (f() == null && e() == null && L() != 0) {
            k();
            throw null;
        }
    }
}
