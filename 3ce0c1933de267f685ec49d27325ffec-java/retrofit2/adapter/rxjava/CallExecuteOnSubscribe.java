package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.c;
import rx.exceptions.a;
import rx.i;
/* loaded from: classes3.dex */
final class CallExecuteOnSubscribe<T> implements c.a<Response<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    public void call(i<? super Response<T>> iVar) {
        Call<T> clone = this.originalCall.clone();
        CallArbiter callArbiter = new CallArbiter(clone, iVar);
        iVar.add(callArbiter);
        iVar.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(clone.execute());
        } catch (Throwable th2) {
            a.e(th2);
            callArbiter.emitError(th2);
        }
    }
}
