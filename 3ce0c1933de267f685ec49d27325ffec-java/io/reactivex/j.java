package io.reactivex;

import bo.b;
import io.reactivex.internal.util.NotificationLite;
/* compiled from: Notification.java */
/* loaded from: classes2.dex */
public final class j<T> {

    /* renamed from: b  reason: collision with root package name */
    static final j<Object> f29262b = new j<>(null);

    /* renamed from: a  reason: collision with root package name */
    final Object f29263a;

    private j(Object obj) {
        this.f29263a = obj;
    }

    public static <T> j<T> a() {
        return (j<T>) f29262b;
    }

    public static <T> j<T> b(Throwable th2) {
        b.e(th2, "error is null");
        return new j<>(NotificationLite.error(th2));
    }

    public static <T> j<T> c(T t10) {
        b.e(t10, "value is null");
        return new j<>(t10);
    }

    public Throwable d() {
        Object obj = this.f29263a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T e() {
        Object obj = this.f29263a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.f29263a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return b.c(this.f29263a, ((j) obj).f29263a);
        }
        return false;
    }

    public boolean f() {
        return this.f29263a == null;
    }

    public boolean g() {
        return NotificationLite.isError(this.f29263a);
    }

    public boolean h() {
        Object obj = this.f29263a;
        return obj != null && !NotificationLite.isError(obj);
    }

    public int hashCode() {
        Object obj = this.f29263a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f29263a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f29263a + "]";
    }
}
