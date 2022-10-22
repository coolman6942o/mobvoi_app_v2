package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Violation.kt */
/* loaded from: classes.dex */
public abstract class Violation extends RuntimeException {
    private final Fragment fragment;

    public /* synthetic */ Violation(Fragment fragment, String str, int i10, f fVar) {
        this(fragment, (i10 & 2) != 0 ? null : str);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Violation(Fragment fragment, String str) {
        super(str);
        i.f(fragment, "fragment");
        this.fragment = fragment;
    }
}
