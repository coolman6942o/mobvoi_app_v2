package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.f;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f34045a;

    public c(ThreadFactory threadFactory) {
        this.f34045a = threadFactory;
    }

    @Override // rx.f
    public f.a a() {
        return new d(this.f34045a);
    }
}
