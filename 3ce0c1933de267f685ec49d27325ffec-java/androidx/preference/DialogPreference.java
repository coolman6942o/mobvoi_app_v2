package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f3577u;

    public DialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3663h, i10, i11);
        String o10 = i.o(obtainStyledAttributes, g.f3683r, g.f3665i);
        this.f3577u = o10;
        if (o10 == null) {
            this.f3577u = n();
        }
        i.o(obtainStyledAttributes, g.f3681q, g.f3667j);
        i.c(obtainStyledAttributes, g.f3677o, g.f3669k);
        i.o(obtainStyledAttributes, g.f3687t, g.f3671l);
        i.o(obtainStyledAttributes, g.f3685s, g.f3673m);
        i.n(obtainStyledAttributes, g.f3679p, g.f3675n, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void y() {
        k();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3637b, 16842897));
    }
}
