package rx;
/* compiled from: Subscriber.java */
/* loaded from: classes3.dex */
public abstract class i<T> implements d<T>, j {
    private static final long NOT_SET = Long.MIN_VALUE;
    private e producer;
    private long requested;
    private final i<?> subscriber;
    private final rx.internal.util.i subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public i() {
        this(null, false);
    }

    private void addToRequested(long j10) {
        long j11 = this.requested;
        if (j11 == NOT_SET) {
            this.requested = j10;
            return;
        }
        long j12 = j11 + j10;
        if (j12 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j12;
        }
    }

    public final void add(j jVar) {
        this.subscriptions.a(jVar);
    }

    @Override // rx.j
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j10) {
        if (j10 >= 0) {
            synchronized (this) {
                e eVar = this.producer;
                if (eVar != null) {
                    eVar.request(j10);
                } else {
                    addToRequested(j10);
                }
            }
        } else {
            throw new IllegalArgumentException("number requested cannot be negative: " + j10);
        }
    }

    public void setProducer(e eVar) {
        long j10;
        i<?> iVar;
        boolean z10;
        synchronized (this) {
            j10 = this.requested;
            this.producer = eVar;
            iVar = this.subscriber;
            z10 = iVar != null && j10 == NOT_SET;
        }
        if (z10) {
            iVar.setProducer(eVar);
        } else if (j10 == NOT_SET) {
            eVar.request(Long.MAX_VALUE);
        } else {
            eVar.request(j10);
        }
    }

    @Override // rx.j
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(i<?> iVar) {
        this(iVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(i<?> iVar, boolean z10) {
        this.requested = NOT_SET;
        this.subscriber = iVar;
        this.subscriptions = (!z10 || iVar == null) ? new rx.internal.util.i() : iVar.subscriptions;
    }
}
