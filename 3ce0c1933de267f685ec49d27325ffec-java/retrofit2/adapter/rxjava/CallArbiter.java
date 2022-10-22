package retrofit2.adapter.rxjava;

import bq.f;
import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.a;
import rx.i;
import rx.j;
/* loaded from: classes3.dex */
final class CallArbiter<T> extends AtomicInteger implements j, e {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final i<? super Response<T>> subscriber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallArbiter(Call<T> call, i<? super Response<T>> iVar) {
        super(0);
        this.call = call;
        this.subscriber = iVar;
    }

    private void deliverResponse(Response<T> response) {
        Throwable e10;
        Throwable e11;
        Throwable e12;
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response);
            }
            try {
                if (!isUnsubscribed()) {
                    this.subscriber.onCompleted();
                }
            } catch (OnCompletedFailedException e13) {
                e12 = e13;
                f.c().b().a(e12);
            } catch (OnErrorFailedException e14) {
                e12 = e14;
                f.c().b().a(e12);
            } catch (OnErrorNotImplementedException e15) {
                e12 = e15;
                f.c().b().a(e12);
            } catch (Throwable th2) {
                a.e(th2);
                f.c().b().a(th2);
            }
        } catch (OnCompletedFailedException e16) {
            e10 = e16;
            f.c().b().a(e10);
        } catch (OnErrorFailedException e17) {
            e10 = e17;
            f.c().b().a(e10);
        } catch (OnErrorNotImplementedException e18) {
            e10 = e18;
            f.c().b().a(e10);
        } catch (Throwable th3) {
            a.e(th3);
            try {
                this.subscriber.onError(th3);
            } catch (OnCompletedFailedException e19) {
                e11 = e19;
                f.c().b().a(e11);
            } catch (OnErrorFailedException e20) {
                e11 = e20;
                f.c().b().a(e11);
            } catch (OnErrorNotImplementedException e21) {
                e11 = e21;
                f.c().b().a(e11);
            } catch (Throwable th4) {
                a.e(th4);
                f.c().b().a(new CompositeException(th3, th4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitError(Throwable th2) {
        Throwable e10;
        set(3);
        if (!isUnsubscribed()) {
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException e11) {
                e10 = e11;
                f.c().b().a(e10);
            } catch (OnErrorFailedException e12) {
                e10 = e12;
                f.c().b().a(e10);
            } catch (OnErrorNotImplementedException e13) {
                e10 = e13;
                f.c().b().a(e10);
            } catch (Throwable th3) {
                a.e(th3);
                f.c().b().a(new CompositeException(th2, th3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitResponse(Response<T> response) {
        while (true) {
            int i10 = get();
            if (i10 == 0) {
                this.response = response;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    throw new AssertionError();
                }
                throw new IllegalStateException("Unknown state: " + i10);
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response);
                return;
            }
        }
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    @Override // rx.e
    public void request(long j10) {
        if (j10 != 0) {
            while (true) {
                int i10 = get();
                if (i10 != 0) {
                    if (i10 == 1) {
                        return;
                    }
                    if (i10 != 2) {
                        if (i10 != 3) {
                            throw new IllegalStateException("Unknown state: " + i10);
                        }
                        return;
                    } else if (compareAndSet(2, 3)) {
                        deliverResponse(this.response);
                        return;
                    }
                } else if (compareAndSet(0, 1)) {
                    return;
                }
            }
        }
    }

    @Override // rx.j
    public void unsubscribe() {
        this.call.cancel();
    }
}
