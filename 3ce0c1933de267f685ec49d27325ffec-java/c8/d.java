package c8;

import android.content.Intent;
/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f5616a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Intent f5617b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c f5618c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Intent intent, Intent intent2) {
        this.f5618c = cVar;
        this.f5616a = intent;
        this.f5617b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5618c.e(this.f5616a);
        this.f5618c.a(this.f5617b);
    }
}
