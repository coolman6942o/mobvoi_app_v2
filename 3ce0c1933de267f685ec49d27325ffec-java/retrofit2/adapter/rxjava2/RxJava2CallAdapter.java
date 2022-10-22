package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.k;
import io.reactivex.s;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
/* loaded from: classes3.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final s scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJava2CallAdapter(Type type, s sVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.responseType = type;
        this.scheduler = sVar;
        this.isAsync = z10;
        this.isResult = z11;
        this.isBody = z12;
        this.isFlowable = z13;
        this.isSingle = z14;
        this.isMaybe = z15;
        this.isCompletable = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object adapt(Call<R> call) {
        k kVar;
        s sVar;
        k bodyObservable;
        if (this.isAsync) {
            kVar = new CallEnqueueObservable(call);
        } else {
            kVar = new CallExecuteObservable(call);
        }
        if (this.isResult) {
            bodyObservable = new ResultObservable(kVar);
        } else {
            if (this.isBody) {
                bodyObservable = new BodyObservable(kVar);
            }
            sVar = this.scheduler;
            if (sVar != null) {
                kVar = kVar.subscribeOn(sVar);
            }
            if (!this.isFlowable) {
                return kVar.toFlowable(BackpressureStrategy.LATEST);
            }
            if (this.isSingle) {
                return kVar.singleOrError();
            }
            if (this.isMaybe) {
                return kVar.singleElement();
            }
            return this.isCompletable ? kVar.ignoreElements() : kVar;
        }
        kVar = bodyObservable;
        sVar = this.scheduler;
        if (sVar != null) {
        }
        if (!this.isFlowable) {
        }
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
