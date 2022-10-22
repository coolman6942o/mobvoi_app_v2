package io.reactivex.internal.util;

import io.reactivex.r;
import java.io.Serializable;
/* loaded from: classes3.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes3.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final xn.b upstream;

        a(xn.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f29250e;

        b(Throwable th2) {
            this.f29250e = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return bo.b.c(this.f29250e, ((b) obj).f29250e);
            }
            return false;
        }

        public int hashCode() {
            return this.f29250e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f29250e + "]";
        }
    }

    /* loaded from: classes3.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final vp.c upstream;

        c(vp.c cVar) {
            this.upstream = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, vp.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f29250e);
            return true;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, vp.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f29250e);
            return true;
        } else if (obj instanceof c) {
            bVar.onSubscribe(((c) obj).upstream);
            return false;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(xn.b bVar) {
        return new a(bVar);
    }

    public static Object error(Throwable th2) {
        return new b(th2);
    }

    public static xn.b getDisposable(Object obj) {
        return ((a) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f29250e;
    }

    public static vp.c getSubscription(Object obj) {
        return ((c) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t10) {
        return t10;
    }

    public static Object subscription(vp.c cVar) {
        return new c(cVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, r<? super T> rVar) {
        if (obj == COMPLETE) {
            rVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            rVar.onError(((b) obj).f29250e);
            return true;
        } else {
            rVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, r<? super T> rVar) {
        if (obj == COMPLETE) {
            rVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            rVar.onError(((b) obj).f29250e);
            return true;
        } else if (obj instanceof a) {
            rVar.onSubscribe(((a) obj).upstream);
            return false;
        } else {
            rVar.onNext(obj);
            return false;
        }
    }
}
