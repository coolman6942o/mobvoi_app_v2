package dagger.hilt.android.internal.managers;

import tn.b;
/* compiled from: ApplicationComponentManager.java */
/* loaded from: classes2.dex */
public final class d implements b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f25592a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f25593b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final e f25594c;

    public d(e eVar) {
        this.f25594c = eVar;
    }

    @Override // tn.b
    public Object h() {
        if (this.f25592a == null) {
            synchronized (this.f25593b) {
                if (this.f25592a == null) {
                    this.f25592a = this.f25594c.get();
                }
            }
        }
        return this.f25592a;
    }
}
