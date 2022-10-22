package rx.internal.producers;

import rx.e;
/* compiled from: ProducerArbiter.java */
/* loaded from: classes3.dex */
public final class a implements e {

    /* renamed from: g  reason: collision with root package name */
    static final e f33997g = new C0478a();

    /* renamed from: a  reason: collision with root package name */
    long f33998a;

    /* renamed from: b  reason: collision with root package name */
    e f33999b;

    /* renamed from: c  reason: collision with root package name */
    boolean f34000c;

    /* renamed from: d  reason: collision with root package name */
    long f34001d;

    /* renamed from: e  reason: collision with root package name */
    long f34002e;

    /* renamed from: f  reason: collision with root package name */
    e f34003f;

    /* compiled from: ProducerArbiter.java */
    /* renamed from: rx.internal.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0478a implements e {
        C0478a() {
        }

        @Override // rx.e
        public void request(long j10) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j10 = this.f34001d;
                long j11 = this.f34002e;
                e eVar = this.f34003f;
                int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                if (i10 == 0 && j11 == 0 && eVar == null) {
                    this.f34000c = false;
                    return;
                }
                this.f34001d = 0L;
                this.f34002e = 0L;
                this.f34003f = null;
                long j12 = this.f33998a;
                if (j12 != Long.MAX_VALUE) {
                    long j13 = j12 + j10;
                    if (j13 < 0 || j13 == Long.MAX_VALUE) {
                        this.f33998a = Long.MAX_VALUE;
                        j12 = Long.MAX_VALUE;
                    } else {
                        j12 = j13 - j11;
                        if (j12 >= 0) {
                            this.f33998a = j12;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (eVar == null) {
                    e eVar2 = this.f33999b;
                    if (!(eVar2 == null || i10 == 0)) {
                        eVar2.request(j10);
                    }
                } else if (eVar == f33997g) {
                    this.f33999b = null;
                } else {
                    this.f33999b = eVar;
                    eVar.request(j12);
                }
            }
        }
    }

    public void b(long j10) {
        if (j10 > 0) {
            synchronized (this) {
                if (this.f34000c) {
                    this.f34002e += j10;
                    return;
                }
                this.f34000c = true;
                try {
                    long j11 = this.f33998a;
                    if (j11 != Long.MAX_VALUE) {
                        long j12 = j11 - j10;
                        if (j12 >= 0) {
                            this.f33998a = j12;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f34000c = false;
                        throw th2;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("n > 0 required");
        }
    }

    public void c(e eVar) {
        synchronized (this) {
            if (this.f34000c) {
                if (eVar == null) {
                    eVar = f33997g;
                }
                this.f34003f = eVar;
                return;
            }
            this.f34000c = true;
            try {
                this.f33999b = eVar;
                if (eVar != null) {
                    eVar.request(this.f33998a);
                }
                a();
            } catch (Throwable th2) {
                synchronized (this) {
                    this.f34000c = false;
                    throw th2;
                }
            }
        }
    }

    @Override // rx.e
    public void request(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i10 != 0) {
            synchronized (this) {
                if (this.f34000c) {
                    this.f34001d += j10;
                    return;
                }
                this.f34000c = true;
                try {
                    long j11 = this.f33998a + j10;
                    if (j11 < 0) {
                        j11 = Long.MAX_VALUE;
                    }
                    this.f33998a = j11;
                    e eVar = this.f33999b;
                    if (eVar != null) {
                        eVar.request(j10);
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f34000c = false;
                        throw th2;
                    }
                }
            }
        }
    }
}
