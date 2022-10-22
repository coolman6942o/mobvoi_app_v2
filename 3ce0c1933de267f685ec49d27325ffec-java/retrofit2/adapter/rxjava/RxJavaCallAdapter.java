package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.c;
import rx.f;
/* loaded from: classes3.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final f scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJavaCallAdapter(Type type, f fVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.responseType = type;
        this.scheduler = fVar;
        this.isAsync = z10;
        this.isResult = z11;
        this.isBody = z12;
        this.isSingle = z13;
        this.isCompletable = z14;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object adapt(Call<R> call) {
        c.a aVar;
        f fVar;
        c.a bodyOnSubscribe;
        if (this.isAsync) {
            aVar = new CallEnqueueOnSubscribe(call);
        } else {
            aVar = new CallExecuteOnSubscribe(call);
        }
        if (this.isResult) {
            bodyOnSubscribe = new ResultOnSubscribe(aVar);
        } else {
            if (this.isBody) {
                bodyOnSubscribe = new BodyOnSubscribe(aVar);
            }
            c g10 = c.g(aVar);
            fVar = this.scheduler;
            if (fVar != null) {
                g10 = g10.Z(fVar);
            }
            if (!this.isSingle) {
                return g10.h0();
            }
            return this.isCompletable ? g10.g0() : g10;
        }
        aVar = bodyOnSubscribe;
        c g102 = c.g(aVar);
        fVar = this.scheduler;
        if (fVar != null) {
        }
        if (!this.isSingle) {
        }
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
