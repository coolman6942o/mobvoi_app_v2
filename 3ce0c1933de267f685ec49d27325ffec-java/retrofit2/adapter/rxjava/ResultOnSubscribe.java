package retrofit2.adapter.rxjava;

import bq.f;
import retrofit2.Response;
import rx.c;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.a;
import rx.i;
/* loaded from: classes3.dex */
final class ResultOnSubscribe<T> implements c.a<Result<T>> {
    private final c.a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ResultSubscriber<R> extends i<Response<R>> {
        private final i<? super Result<R>> subscriber;

        ResultSubscriber(i<? super Result<R>> iVar) {
            super(iVar);
            this.subscriber = iVar;
        }

        @Override // rx.d
        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            Throwable e10;
            try {
                this.subscriber.onNext(Result.error(th2));
                this.subscriber.onCompleted();
            } catch (Throwable th3) {
                try {
                    this.subscriber.onError(th3);
                } catch (OnCompletedFailedException e11) {
                    e10 = e11;
                    f.c().b().a(e10);
                } catch (OnErrorFailedException e12) {
                    e10 = e12;
                    f.c().b().a(e10);
                } catch (OnErrorNotImplementedException e13) {
                    e10 = e13;
                    f.c().b().a(e10);
                } catch (Throwable th4) {
                    a.e(th4);
                    f.c().b().a(new CompositeException(th3, th4));
                }
            }
        }

        @Override // rx.d
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultOnSubscribe(c.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    public void call(i<? super Result<T>> iVar) {
        this.upstream.call(new ResultSubscriber(iVar));
    }
}
