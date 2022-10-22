package retrofit2.adapter.rxjava2;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.k;
import io.reactivex.r;
import retrofit2.Call;
import retrofit2.Response;
import xn.b;
/* loaded from: classes3.dex */
final class CallExecuteObservable<T> extends k<Response<T>> {
    private final Call<T> originalCall;

    /* loaded from: classes3.dex */
    private static final class CallDisposable implements b {
        private final Call<?> call;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        @Override // xn.b
        public void dispose() {
            this.call.cancel();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Response<T>> rVar) {
        boolean z10;
        Throwable th2;
        Call<T> clone = this.originalCall.clone();
        rVar.onSubscribe(new CallDisposable(clone));
        try {
            Response<T> execute = clone.execute();
            if (!clone.isCanceled()) {
                rVar.onNext(execute);
            }
            if (!clone.isCanceled()) {
                try {
                    rVar.onComplete();
                } catch (Throwable th3) {
                    th2 = th3;
                    z10 = true;
                    a.b(th2);
                    if (z10) {
                        fo.a.s(th2);
                    } else if (!clone.isCanceled()) {
                        try {
                            rVar.onError(th2);
                        } catch (Throwable th4) {
                            a.b(th4);
                            fo.a.s(new CompositeException(th2, th4));
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            z10 = false;
        }
    }
}
