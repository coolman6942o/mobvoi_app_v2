package org.greenrobot.eventbus;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPoster.java */
/* loaded from: classes3.dex */
public class a implements Runnable, j {

    /* renamed from: a  reason: collision with root package name */
    private final i f32433a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f32434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f32434b = cVar;
    }

    @Override // org.greenrobot.eventbus.j
    public void a(n nVar, Object obj) {
        this.f32433a.a(h.a(nVar, obj));
        this.f32434b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        h b10 = this.f32433a.b();
        if (b10 != null) {
            this.f32434b.g(b10);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
