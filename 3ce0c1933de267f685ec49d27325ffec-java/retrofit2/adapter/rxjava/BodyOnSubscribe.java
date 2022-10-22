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
final class BodyOnSubscribe<T> implements c.a<T> {
    private final c.a<Response<T>> upstream;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class BodySubscriber<R> extends i<Response<R>> {
        private final i<? super R> subscriber;
        private boolean subscriberTerminated;

        BodySubscriber(i<? super R> iVar) {
            super(iVar);
            this.subscriber = iVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.subscriberTerminated) {
                this.subscriber.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th2);
            f.c().b().a(assertionError);
        }

        @Override // rx.d
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        public void onNext(Response<R> response) {
            Throwable e10;
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
            } catch (OnCompletedFailedException e11) {
                e10 = e11;
                f.c().b().a(e10);
            } catch (OnErrorFailedException e12) {
                e10 = e12;
                f.c().b().a(e10);
            } catch (OnErrorNotImplementedException e13) {
                e10 = e13;
                f.c().b().a(e10);
            } catch (Throwable th2) {
                a.e(th2);
                f.c().b().a(new CompositeException(httpException, th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyOnSubscribe(c.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    public void call(i<? super T> iVar) {
        this.upstream.call(new BodySubscriber(iVar));
    }
}
