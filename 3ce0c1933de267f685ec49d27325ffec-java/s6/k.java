package s6;

import java.util.Objects;
/* loaded from: classes.dex */
final class k extends h {

    /* renamed from: a  reason: collision with root package name */
    private final i f34331a = new i();

    @Override // s6.h
    public final void a(Throwable th2, Throwable th3) {
        if (th3 != th2) {
            Objects.requireNonNull(th3, "The suppressed exception cannot be null.");
            this.f34331a.a(th2, true).add(th3);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th3);
    }
}
