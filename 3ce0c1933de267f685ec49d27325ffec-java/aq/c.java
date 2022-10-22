package aq;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public class c<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<? super T> f4910a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4911b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f4912c;

    /* renamed from: d  reason: collision with root package name */
    private a f4913d;

    /* compiled from: SerializedObserver.java */
    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object[] f4914a;

        /* renamed from: b  reason: collision with root package name */
        int f4915b;

        a() {
        }

        public void a(Object obj) {
            int i10 = this.f4915b;
            Object[] objArr = this.f4914a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f4914a = objArr;
            } else if (i10 == objArr.length) {
                Object[] objArr2 = new Object[(i10 >> 2) + i10];
                System.arraycopy(objArr, 0, objArr2, 0, i10);
                this.f4914a = objArr2;
                objArr = objArr2;
            }
            objArr[i10] = obj;
            this.f4915b = i10 + 1;
        }
    }

    public c(d<? super T> dVar) {
        this.f4910a = dVar;
    }

    @Override // rx.d
    public void onCompleted() {
        if (!this.f4912c) {
            synchronized (this) {
                if (!this.f4912c) {
                    this.f4912c = true;
                    if (this.f4911b) {
                        a aVar = this.f4913d;
                        if (aVar == null) {
                            aVar = new a();
                            this.f4913d = aVar;
                        }
                        aVar.a(rx.internal.operators.d.b());
                        return;
                    }
                    this.f4911b = true;
                    this.f4910a.onCompleted();
                }
            }
        }
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        rx.exceptions.a.e(th2);
        if (!this.f4912c) {
            synchronized (this) {
                if (!this.f4912c) {
                    this.f4912c = true;
                    if (this.f4911b) {
                        a aVar = this.f4913d;
                        if (aVar == null) {
                            aVar = new a();
                            this.f4913d = aVar;
                        }
                        aVar.a(rx.internal.operators.d.c(th2));
                        return;
                    }
                    this.f4911b = true;
                    this.f4910a.onError(th2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x002d, code lost:
        continue;
     */
    @Override // rx.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t10) {
        Object[] objArr;
        if (!this.f4912c) {
            synchronized (this) {
                if (!this.f4912c) {
                    if (this.f4911b) {
                        a aVar = this.f4913d;
                        if (aVar == null) {
                            aVar = new a();
                            this.f4913d = aVar;
                        }
                        aVar.a(rx.internal.operators.d.g(t10));
                        return;
                    }
                    this.f4911b = true;
                    try {
                        this.f4910a.onNext(t10);
                        while (true) {
                            synchronized (this) {
                                a aVar2 = this.f4913d;
                                if (aVar2 == null) {
                                    this.f4911b = false;
                                    return;
                                }
                                this.f4913d = null;
                                for (Object obj : aVar2.f4914a) {
                                    if (obj == null) {
                                        break;
                                    }
                                    try {
                                        if (rx.internal.operators.d.a(this.f4910a, obj)) {
                                            this.f4912c = true;
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        this.f4912c = true;
                                        rx.exceptions.a.e(th2);
                                        this.f4910a.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        this.f4912c = true;
                        rx.exceptions.a.g(th3, this.f4910a, t10);
                    }
                }
            }
        }
    }
}
