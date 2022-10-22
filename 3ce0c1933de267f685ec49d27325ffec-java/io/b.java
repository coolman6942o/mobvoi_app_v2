package io;

import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public class b {
    public static void a(Throwable addSuppressed, Throwable exception) {
        i.f(addSuppressed, "$this$addSuppressed");
        i.f(exception, "exception");
        if (addSuppressed != exception) {
            lo.b.f30564a.a(addSuppressed, exception);
        }
    }
}
