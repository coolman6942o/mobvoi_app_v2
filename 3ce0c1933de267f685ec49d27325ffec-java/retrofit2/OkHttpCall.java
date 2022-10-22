package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.w;
import okhttp3.z;
import okio.c;
import okio.h;
import okio.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private e rawCall;
    private final ServiceMethod<T, ?> serviceMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ExceptionCatchingRequestBody extends c0 {
        private final c0 delegate;
        IOException thrownException;

        ExceptionCatchingRequestBody(c0 c0Var) {
            this.delegate = c0Var;
        }

        @Override // okhttp3.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.c0
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.c0
        public w contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.c0
        public okio.e source() {
            return n.d(new h(this.delegate.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1
                @Override // okio.h, okio.t
                public long read(c cVar, long j10) throws IOException {
                    try {
                        return super.read(cVar, j10);
                    } catch (IOException e10) {
                        ExceptionCatchingRequestBody.this.thrownException = e10;
                        throw e10;
                    }
                }
            });
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class NoContentResponseBody extends c0 {
        private final long contentLength;
        private final w contentType;

        NoContentResponseBody(w wVar, long j10) {
            this.contentType = wVar;
            this.contentLength = j10;
        }

        @Override // okhttp3.c0
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.c0
        public w contentType() {
            return this.contentType;
        }

        @Override // okhttp3.c0
        public okio.e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpCall(ServiceMethod<T, ?> serviceMethod, Object[] objArr) {
        this.serviceMethod = serviceMethod;
        this.args = objArr;
    }

    private e createRawCall() throws IOException {
        e a10 = this.serviceMethod.callFactory.a(this.serviceMethod.toRequest(this.args));
        Objects.requireNonNull(a10, "Call.Factory returned null.");
        return a10;
    }

    @Override // retrofit2.Call
    public void cancel() {
        e eVar;
        this.canceled = true;
        synchronized (this) {
            eVar = this.rawCall;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        e eVar;
        Throwable th2;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                eVar = this.rawCall;
                th2 = this.creationFailure;
                if (eVar == null && th2 == null) {
                    e createRawCall = createRawCall();
                    this.rawCall = createRawCall;
                    eVar = createRawCall;
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th2 != null) {
            callback.onFailure(this, th2);
            return;
        }
        if (this.canceled) {
            eVar.cancel();
        }
        eVar.h(new f() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }

            private void callSuccess(Response<T> response) {
                try {
                    callback.onResponse(OkHttpCall.this, response);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }

            @Override // okhttp3.f
            public void onFailure(e eVar2, IOException iOException) {
                try {
                    callback.onFailure(OkHttpCall.this, iOException);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }

            @Override // okhttp3.f
            public void onResponse(e eVar2, b0 b0Var) throws IOException {
                try {
                    callSuccess(OkHttpCall.this.parseResponse(b0Var));
                } catch (Throwable th3) {
                    callFailure(th3);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        e eVar;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                Throwable th2 = this.creationFailure;
                if (th2 == null) {
                    eVar = this.rawCall;
                    if (eVar == null) {
                        try {
                            eVar = createRawCall();
                            this.rawCall = eVar;
                        } catch (IOException | RuntimeException e10) {
                            this.creationFailure = e10;
                            throw e10;
                        }
                    }
                } else if (th2 instanceof IOException) {
                    throw ((IOException) th2);
                } else {
                    throw ((RuntimeException) th2);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            eVar.cancel();
        }
        return parseResponse(eVar.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z10 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            e eVar = this.rawCall;
            if (eVar == null || !eVar.isCanceled()) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* JADX WARN: Finally extract failed */
    Response<T> parseResponse(b0 b0Var) throws IOException {
        c0 c10 = b0Var.c();
        b0 c11 = b0Var.Q().b(new NoContentResponseBody(c10.contentType(), c10.contentLength())).c();
        int n10 = c11.n();
        if (n10 < 200 || n10 >= 300) {
            try {
                Response<T> error = Response.error(Utils.buffer(c10), c11);
                c10.close();
                return error;
            } catch (Throwable th2) {
                c10.close();
                throw th2;
            }
        } else if (n10 == 204 || n10 == 205) {
            c10.close();
            return Response.success((Object) null, c11);
        } else {
            ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(c10);
            try {
                return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), c11);
            } catch (RuntimeException e10) {
                exceptionCatchingRequestBody.throwIfCaught();
                throw e10;
            }
        }
    }

    @Override // retrofit2.Call
    public synchronized z request() {
        e eVar = this.rawCall;
        if (eVar != null) {
            return eVar.request();
        }
        Throwable th2 = this.creationFailure;
        if (th2 == null) {
            try {
                e createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall.request();
            } catch (IOException e10) {
                this.creationFailure = e10;
                throw new RuntimeException("Unable to create request.", e10);
            } catch (RuntimeException e11) {
                this.creationFailure = e11;
                throw e11;
            }
        } else if (th2 instanceof IOException) {
            throw new RuntimeException("Unable to create request.", this.creationFailure);
        } else {
            throw ((RuntimeException) th2);
        }
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.serviceMethod, this.args);
    }
}
