package kotlinx.coroutines.internal;

import io.h;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4 extends Lambda implements l<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    public final Throwable invoke(Throwable th2) {
        Object obj;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = this.$constructor$inlined.newInstance(new Object[0]);
        } catch (Throwable th3) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th3));
        }
        if (newInstance != null) {
            Throwable th4 = (Throwable) newInstance;
            th4.initCause(th2);
            obj = Result.m28constructorimpl(th4);
            if (Result.m33isFailureimpl(obj)) {
                obj = null;
            }
            return (Throwable) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
    }
}
