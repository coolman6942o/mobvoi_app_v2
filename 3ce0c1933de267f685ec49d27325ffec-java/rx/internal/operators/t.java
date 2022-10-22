package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.c;
import rx.f;
import rx.i;
/* compiled from: OnSubscribeTimerOnce.java */
/* loaded from: classes3.dex */
public final class t implements c.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f33922a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f33923b;

    /* renamed from: c  reason: collision with root package name */
    final f f33924c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerOnce.java */
    /* loaded from: classes3.dex */
    public class a implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f33925a;

        a(t tVar, i iVar) {
            this.f33925a = iVar;
        }

        @Override // yp.a
        public void call() {
            try {
                this.f33925a.onNext(0L);
                this.f33925a.onCompleted();
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f33925a);
            }
        }
    }

    public t(long j10, TimeUnit timeUnit, f fVar) {
        this.f33922a = j10;
        this.f33923b = timeUnit;
        this.f33924c = fVar;
    }

    /* renamed from: a */
    public void call(i<? super Long> iVar) {
        f.a a10 = this.f33924c.a();
        iVar.add(a10);
        a10.c(new a(this, iVar), this.f33922a, this.f33923b);
    }
}
