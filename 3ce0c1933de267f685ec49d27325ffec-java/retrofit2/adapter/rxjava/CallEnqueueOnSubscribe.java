package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.c;
import rx.exceptions.a;
import rx.i;
/* loaded from: classes3.dex */
final class CallEnqueueOnSubscribe<T> implements c.a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    public void call(i<? super Response<T>> iVar) {
        Call<T> clone = this.originalCall.clone();
        final CallArbiter callArbiter = new CallArbiter(clone, iVar);
        iVar.add(callArbiter);
        iVar.setProducer(callArbiter);
        clone.enqueue(new Callback<T>() { // from class: retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.1
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th2) {
                a.e(th2);
                callArbiter.emitError(th2);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }
        });
    }
}
