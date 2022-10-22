package org.greenrobot.eventbus;
/* compiled from: PendingPostQueue.java */
/* loaded from: classes3.dex */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private h f32489a;

    /* renamed from: b  reason: collision with root package name */
    private h f32490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(h hVar) {
        try {
            if (hVar != null) {
                h hVar2 = this.f32490b;
                if (hVar2 != null) {
                    hVar2.f32488c = hVar;
                    this.f32490b = hVar;
                } else if (this.f32489a == null) {
                    this.f32490b = hVar;
                    this.f32489a = hVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized h b() {
        h hVar;
        hVar = this.f32489a;
        if (hVar != null) {
            h hVar2 = hVar.f32488c;
            this.f32489a = hVar2;
            if (hVar2 == null) {
                this.f32490b = null;
            }
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized h c(int i10) throws InterruptedException {
        if (this.f32489a == null) {
            wait(i10);
        }
        return b();
    }
}
