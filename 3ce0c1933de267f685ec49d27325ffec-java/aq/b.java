package aq;

import bq.c;
import bq.f;
import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.exceptions.a;
import rx.i;
/* compiled from: SafeSubscriber.java */
/* loaded from: classes3.dex */
public class b<T> extends i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final i<? super T> f4908a;

    /* renamed from: b  reason: collision with root package name */
    boolean f4909b;

    public b(i<? super T> iVar) {
        super(iVar);
        this.f4908a = iVar;
    }

    protected void b(Throwable th2) {
        f.c().b().a(th2);
        try {
            this.f4908a.onError(th2);
            try {
                unsubscribe();
            } catch (Throwable th3) {
                c.i(th3);
                throw new OnErrorFailedException(th3);
            }
        } catch (OnErrorNotImplementedException e10) {
            try {
                unsubscribe();
                throw e10;
            } catch (Throwable th4) {
                c.i(th4);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th2, th4)));
            }
        } catch (Throwable th5) {
            c.i(th5);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th2, th5)));
            } catch (Throwable th6) {
                c.i(th6);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th2, th5, th6)));
            }
        }
    }

    @Override // rx.d
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (!this.f4909b) {
            this.f4909b = true;
            try {
                this.f4908a.onCompleted();
                try {
                    unsubscribe();
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    a.e(th2);
                    c.i(th2);
                    throw new OnCompletedFailedException(th2.getMessage(), th2);
                } catch (Throwable th3) {
                    try {
                        unsubscribe();
                        throw th3;
                    } finally {
                    }
                }
            }
        }
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        a.e(th2);
        if (!this.f4909b) {
            this.f4909b = true;
            b(th2);
        }
    }

    @Override // rx.d
    public void onNext(T t10) {
        try {
            if (!this.f4909b) {
                this.f4908a.onNext(t10);
            }
        } catch (Throwable th2) {
            a.f(th2, this);
        }
    }
}
