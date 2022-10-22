package rx;
/* loaded from: classes3.dex */
public final class Notification<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final Notification<Void> f33675d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Kind f33676a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f33677b;

    /* renamed from: c  reason: collision with root package name */
    private final T f33678c;

    /* loaded from: classes3.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind, T t10, Throwable th2) {
        this.f33678c = t10;
        this.f33677b = th2;
        this.f33676a = kind;
    }

    public static <T> Notification<T> a() {
        return (Notification<T>) f33675d;
    }

    public static <T> Notification<T> b(Throwable th2) {
        return new Notification<>(Kind.OnError, null, th2);
    }

    public static <T> Notification<T> c(T t10) {
        return new Notification<>(Kind.OnNext, t10, null);
    }

    public Kind d() {
        return this.f33676a;
    }

    public Throwable e() {
        return this.f33677b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.d() != d()) {
            return false;
        }
        T t10 = this.f33678c;
        T t11 = notification.f33678c;
        if (t10 != t11 && (t10 == null || !t10.equals(t11))) {
            return false;
        }
        Throwable th2 = this.f33677b;
        Throwable th3 = notification.f33677b;
        return th2 == th3 || (th2 != null && th2.equals(th3));
    }

    public T f() {
        return this.f33678c;
    }

    public boolean g() {
        return j() && this.f33677b != null;
    }

    public boolean h() {
        return k() && this.f33678c != null;
    }

    public int hashCode() {
        int hashCode = d().hashCode();
        if (h()) {
            hashCode = (hashCode * 31) + f().hashCode();
        }
        return g() ? (hashCode * 31) + e().hashCode() : hashCode;
    }

    public boolean i() {
        return d() == Kind.OnCompleted;
    }

    public boolean j() {
        return d() == Kind.OnError;
    }

    public boolean k() {
        return d() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append('[');
        sb2.append(super.toString());
        sb2.append(' ');
        sb2.append(d());
        if (h()) {
            sb2.append(' ');
            sb2.append(f());
        }
        if (g()) {
            sb2.append(' ');
            sb2.append(e().getMessage());
        }
        sb2.append(']');
        return sb2.toString();
    }
}
