package retrofit2.adapter.rxjava2;

import fo.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.k;
import io.reactivex.r;
import retrofit2.Response;
import xn.b;
/* loaded from: classes3.dex */
final class BodyObservable<T> extends k<T> {
    private final k<Response<T>> upstream;

    /* loaded from: classes3.dex */
    private static class BodyObserver<R> implements r<Response<R>> {
        private final r<? super R> observer;
        private boolean terminated;

        BodyObserver(r<? super R> rVar) {
            this.observer = rVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.terminated) {
                this.observer.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            a.s(assertionError);
        }

        @Override // io.reactivex.r
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                a.s(new CompositeException(httpException, th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyObservable(k<Response<T>> kVar) {
        this.upstream = kVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.upstream.subscribe(new BodyObserver(rVar));
    }
}
