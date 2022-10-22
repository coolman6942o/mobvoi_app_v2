package dq;

import rx.j;
/* compiled from: Subscriptions.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f25697a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Subscriptions.java */
    /* loaded from: classes3.dex */
    public static final class a implements j {
        a() {
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.j
        public void unsubscribe() {
        }
    }

    public static j a(yp.a aVar) {
        return dq.a.b(aVar);
    }

    public static j b() {
        return dq.a.a();
    }

    public static j c() {
        return f25697a;
    }
}
