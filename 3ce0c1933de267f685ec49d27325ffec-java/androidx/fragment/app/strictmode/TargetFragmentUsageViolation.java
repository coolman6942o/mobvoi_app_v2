package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: TargetFragmentUsageViolation.kt */
/* loaded from: classes.dex */
public abstract class TargetFragmentUsageViolation extends Violation {
    public /* synthetic */ TargetFragmentUsageViolation(Fragment fragment, String str, int i10, f fVar) {
        this(fragment, (i10 & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TargetFragmentUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        i.f(fragment, "fragment");
    }
}
