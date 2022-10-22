package mo;

import kotlin.jvm.internal.i;
/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a extends lo.a {
    @Override // lo.a
    public void a(Throwable cause, Throwable exception) {
        i.f(cause, "cause");
        i.f(exception, "exception");
        cause.addSuppressed(exception);
    }
}
