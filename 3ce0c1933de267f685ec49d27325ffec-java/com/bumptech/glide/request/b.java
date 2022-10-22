package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import j5.a;
/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class b implements RequestCoordinator, a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8157a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f8158b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f8159c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f8160d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f8161e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f8162f;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f8161e = requestState;
        this.f8162f = requestState;
        this.f8157a = obj;
        this.f8158b = requestCoordinator;
    }

    private boolean l(a aVar) {
        return aVar.equals(this.f8159c) || (this.f8161e == RequestCoordinator.RequestState.FAILED && aVar.equals(this.f8160d));
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f8158b;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f8158b;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean o() {
        RequestCoordinator requestCoordinator = this.f8158b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private boolean p() {
        RequestCoordinator requestCoordinator = this.f8158b;
        return requestCoordinator != null && requestCoordinator.c();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(a aVar) {
        synchronized (this.f8157a) {
            if (aVar.equals(this.f8159c)) {
                this.f8161e = RequestCoordinator.RequestState.SUCCESS;
            } else if (aVar.equals(this.f8160d)) {
                this.f8162f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f8158b;
            if (requestCoordinator != null) {
                requestCoordinator.a(this);
            }
        }
    }

    @Override // j5.a
    public void b() {
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = this.f8161e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f8161e = RequestCoordinator.RequestState.PAUSED;
                this.f8159c.b();
            }
            if (this.f8162f == requestState2) {
                this.f8162f = RequestCoordinator.RequestState.PAUSED;
                this.f8160d.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c() {
        boolean z10;
        synchronized (this.f8157a) {
            if (!p() && !k()) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    @Override // j5.a
    public void clear() {
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f8161e = requestState;
            this.f8159c.clear();
            if (this.f8162f != requestState) {
                this.f8162f = requestState;
                this.f8160d.clear();
            }
        }
    }

    @Override // j5.a
    public boolean d() {
        boolean z10;
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = this.f8161e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z10 = requestState == requestState2 && this.f8162f == requestState2;
        }
        return z10;
    }

    @Override // j5.a
    public void e() {
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = this.f8161e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f8161e = requestState2;
                this.f8159c.e();
            }
        }
    }

    @Override // j5.a
    public boolean f(a aVar) {
        if (!(aVar instanceof b)) {
            return false;
        }
        b bVar = (b) aVar;
        return this.f8159c.f(bVar.f8159c) && this.f8160d.f(bVar.f8160d);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean g(a aVar) {
        boolean z10;
        synchronized (this.f8157a) {
            z10 = n() && l(aVar);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean h(a aVar) {
        boolean z10;
        synchronized (this.f8157a) {
            z10 = m() && l(aVar);
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(a aVar) {
        boolean z10;
        synchronized (this.f8157a) {
            z10 = o() && l(aVar);
        }
        return z10;
    }

    @Override // j5.a
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = this.f8161e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (!(requestState == requestState2 || this.f8162f == requestState2)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void j(a aVar) {
        synchronized (this.f8157a) {
            if (!aVar.equals(this.f8160d)) {
                this.f8161e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f8162f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f8162f = requestState2;
                    this.f8160d.e();
                }
                return;
            }
            this.f8162f = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f8158b;
            if (requestCoordinator != null) {
                requestCoordinator.j(this);
            }
        }
    }

    @Override // j5.a
    public boolean k() {
        boolean z10;
        synchronized (this.f8157a) {
            RequestCoordinator.RequestState requestState = this.f8161e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (!(requestState == requestState2 || this.f8162f == requestState2)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    public void q(a aVar, a aVar2) {
        this.f8159c = aVar;
        this.f8160d = aVar2;
    }
}
