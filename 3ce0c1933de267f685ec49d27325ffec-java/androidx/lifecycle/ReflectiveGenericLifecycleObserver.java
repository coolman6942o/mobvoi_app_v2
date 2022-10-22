package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;
/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3267a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f3268b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3267a = obj;
        this.f3268b = c.f3289c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        this.f3268b.a(pVar, event, this.f3267a);
    }
}
