package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import j5.a;
/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class d implements RequestCoordinator, a {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f8189a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8190b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f8191c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f8192d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f8193e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f8194f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8195g;

    public d(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f8193e = requestState;
        this.f8194f = requestState;
        this.f8190b = obj;
        this.f8189a = requestCoordinator;
    }

    private boolean l() {
        boolean z10;
        synchronized (this.f8190b) {
            RequestCoordinator.RequestState requestState = this.f8193e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (!(requestState == requestState2 || this.f8194f == requestState2)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f8189a;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f8189a;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean o() {
        RequestCoordinator requestCoordinator = this.f8189a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private boolean p() {
        RequestCoordinator requestCoordinator = this.f8189a;
        return requestCoordinator != null && requestCoordinator.c();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(a aVar) {
        synchronized (this.f8190b) {
            if (aVar.equals(this.f8192d)) {
                this.f8194f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f8193e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.f8189a;
            if (requestCoordinator != null) {
                requestCoordinator.a(this);
            }
            if (!this.f8194f.a()) {
                this.f8192d.clear();
            }
        }
    }

    @Override // j5.a
    public void b() {
        synchronized (this.f8190b) {
            if (!this.f8194f.a()) {
                this.f8194f = RequestCoordinator.RequestState.PAUSED;
                this.f8192d.b();
            }
            if (!this.f8193e.a()) {
                this.f8193e = RequestCoordinator.RequestState.PAUSED;
                this.f8191c.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c() {
        boolean z10;
        synchronized (this.f8190b) {
            if (!p() && !l()) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    @Override // j5.a
    public void clear() {
        synchronized (this.f8190b) {
            this.f8195g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f8193e = requestState;
            this.f8194f = requestState;
            this.f8192d.clear();
            this.f8191c.clear();
        }
    }

    @Override // j5.a
    public boolean d() {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = this.f8193e == RequestCoordinator.RequestState.CLEARED;
        }
        return z10;
    }

    @Override // j5.a
    public void e() {
        synchronized (this.f8190b) {
            this.f8195g = true;
            if (this.f8193e != RequestCoordinator.RequestState.SUCCESS) {
                RequestCoordinator.RequestState requestState = this.f8194f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f8194f = requestState2;
                    this.f8192d.e();
                }
            }
            if (this.f8195g) {
                RequestCoordinator.RequestState requestState3 = this.f8193e;
                RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                if (requestState3 != requestState4) {
                    this.f8193e = requestState4;
                    this.f8191c.e();
                }
            }
            this.f8195g = false;
        }
    }

    @Override // j5.a
    public boolean f(a aVar) {
        if (!(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        if (this.f8191c == null) {
            if (dVar.f8191c != null) {
                return false;
            }
        } else if (!this.f8191c.f(dVar.f8191c)) {
            return false;
        }
        if (this.f8192d == null) {
            if (dVar.f8192d != null) {
                return false;
            }
        } else if (!this.f8192d.f(dVar.f8192d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean g(a aVar) {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = n() && aVar.equals(this.f8191c) && !l();
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean h(a aVar) {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = m() && aVar.equals(this.f8191c) && this.f8193e != RequestCoordinator.RequestState.PAUSED;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(a aVar) {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = o() && (aVar.equals(this.f8191c) || this.f8193e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z10;
    }

    @Override // j5.a
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = this.f8193e == RequestCoordinator.RequestState.RUNNING;
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void j(a aVar) {
        synchronized (this.f8190b) {
            if (!aVar.equals(this.f8191c)) {
                this.f8194f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f8193e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f8189a;
            if (requestCoordinator != null) {
                requestCoordinator.j(this);
            }
        }
    }

    @Override // j5.a
    public boolean k() {
        boolean z10;
        synchronized (this.f8190b) {
            z10 = this.f8193e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z10;
    }

    public void q(a aVar, a aVar2) {
        this.f8191c = aVar;
        this.f8192d = aVar2;
    }
}
