package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.k;
import io.reactivex.r;
import retrofit2.Response;
import xn.b;
/* loaded from: classes3.dex */
final class ResultObservable<T> extends k<Result<T>> {
    private final k<Response<T>> upstream;

    /* loaded from: classes3.dex */
    private static class ResultObserver<R> implements r<Response<R>> {
        private final r<? super Result<R>> observer;

        ResultObserver(r<? super Result<R>> rVar) {
            this.observer = rVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            try {
                this.observer.onNext(Result.error(th2));
                this.observer.onComplete();
            } catch (Throwable th3) {
                try {
                    this.observer.onError(th3);
                } catch (Throwable th4) {
                    a.b(th4);
                    fo.a.s(new CompositeException(th3, th4));
                }
            }
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
            this.observer.onNext(Result.response(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultObservable(k<Response<T>> kVar) {
        this.upstream = kVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Result<T>> rVar) {
        this.upstream.subscribe(new ResultObserver(rVar));
    }
}
