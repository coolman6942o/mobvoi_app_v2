package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.i;
/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class e {
    private static final void a(int i10, int i11) {
        if (i11 > i10) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field field = baseContinuationImpl.getClass().getDeclaredField("label");
            i.e(field, "field");
            field.setAccessible(true);
            Object obj = field.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl getStackTraceElementImpl) {
        String str;
        i.f(getStackTraceElementImpl, "$this$getStackTraceElementImpl");
        d b10 = b(getStackTraceElementImpl);
        if (b10 == null) {
            return null;
        }
        a(1, b10.v());
        int c10 = c(getStackTraceElementImpl);
        int i10 = c10 < 0 ? -1 : b10.l()[c10];
        String b11 = g.f30069c.b(getStackTraceElementImpl);
        if (b11 == null) {
            str = b10.c();
        } else {
            str = b11 + '/' + b10.c();
        }
        return new StackTraceElement(str, b10.m(), b10.f(), i10);
    }
}
