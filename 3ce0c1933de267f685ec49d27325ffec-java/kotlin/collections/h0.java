package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetsJVM.kt */
/* loaded from: classes3.dex */
public class h0 {
    public static final <T> Set<T> a(T t10) {
        Set<T> singleton = Collections.singleton(t10);
        i.e(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
