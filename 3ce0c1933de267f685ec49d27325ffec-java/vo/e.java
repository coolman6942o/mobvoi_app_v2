package vo;

import kotlin.jvm.internal.i;
/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
class e {
    public static final void a(boolean z10, Number step) {
        i.f(step, "step");
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
        }
    }
}
