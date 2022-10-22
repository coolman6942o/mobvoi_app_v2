package rx.internal.operators;

import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f33740a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f33741b = new b();

    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    static class a implements Serializable {
        private static final long serialVersionUID = 1;

        a() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    static class b implements Serializable {
        private static final long serialVersionUID = 2;

        b() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes3.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f33742e;

        public c(Throwable th2) {
            this.f33742e = th2;
        }

        public String toString() {
            return "Notification=>Error:" + this.f33742e;
        }
    }

    public static <T> boolean a(rx.d<? super T> dVar, Object obj) {
        if (obj == f33740a) {
            dVar.onCompleted();
            return true;
        } else if (obj == f33741b) {
            dVar.onNext(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == c.class) {
            dVar.onError(((c) obj).f33742e);
            return true;
        } else {
            dVar.onNext(obj);
            return false;
        }
    }

    public static Object b() {
        return f33740a;
    }

    public static Object c(Throwable th2) {
        return new c(th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T d(Object obj) {
        if (obj == f33741b) {
            return null;
        }
        return obj;
    }

    public static boolean e(Object obj) {
        return obj == f33740a;
    }

    public static boolean f(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object g(T t10) {
        return t10 == null ? f33741b : t10;
    }
}
