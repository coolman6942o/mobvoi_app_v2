package com.tendcloud.tenddata;

import java.lang.reflect.Method;
import java.util.Objects;
/* compiled from: td */
/* loaded from: classes2.dex */
final class x {

    /* renamed from: a  reason: collision with root package name */
    private final Object f23029a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f23030b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23031c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23032d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Object obj, Method method) {
        Objects.requireNonNull(obj, "EventHandler target cannot be null.");
        Objects.requireNonNull(method, "EventHandler method cannot be null.");
        this.f23029a = obj;
        this.f23030b = method;
        method.setAccessible(true);
        this.f23031c = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean a() {
        return this.f23032d;
    }

    public void b() {
        this.f23032d = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            if (x.class != obj.getClass()) {
                return false;
            }
            x xVar = (x) obj;
            if (this.f23030b.equals(xVar.f23030b)) {
                if (this.f23029a == xVar.f23029a) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return false;
        }
    }

    public void handleEvent(Object obj) {
        if (!this.f23032d) {
            g.eForInternal(toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.f23030b.invoke(this.f23029a, obj);
        } catch (Throwable unused) {
        }
    }

    public int hashCode() {
        return this.f23031c;
    }

    public String toString() {
        return "[EventHandler " + this.f23030b + "]";
    }
}
