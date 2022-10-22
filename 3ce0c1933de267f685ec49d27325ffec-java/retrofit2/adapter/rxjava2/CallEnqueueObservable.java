package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.k;
import io.reactivex.r;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xn.b;
/* loaded from: classes3.dex */
final class CallEnqueueObservable<T> extends k<Response<T>> {
    private final Call<T> originalCall;

    /* loaded from: classes3.dex */
    private static final class CallCallback<T> implements b, Callback<T> {
        private final Call<?> call;
        private final r<? super Response<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call, r<? super Response<T>> rVar) {
            this.call = call;
            this.observer = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.call.cancel();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.call.isCanceled();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th2) {
            if (!call.isCanceled()) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    a.b(th3);
                    fo.a.s(new CompositeException(th2, th3));
                }
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (!call.isCanceled()) {
                try {
                    this.observer.onNext(response);
                    if (!call.isCanceled()) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable th2) {
                    if (this.terminated) {
                        fo.a.s(th2);
                    } else if (!call.isCanceled()) {
                        try {
                            this.observer.onError(th2);
                        } catch (Throwable th3) {
                            a.b(th3);
                            fo.a.s(new CompositeException(th2, th3));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Response<T>> rVar) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, rVar);
        rVar.onSubscribe(callCallback);
        clone.enqueue(callCallback);
    }
}
