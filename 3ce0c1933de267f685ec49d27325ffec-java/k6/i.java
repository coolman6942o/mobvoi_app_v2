package k6;

import k6.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements a.AbstractC0363a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a f29793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f29793a = aVar;
    }

    @Override // k6.a.AbstractC0363a
    public final void a(c cVar) {
        c cVar2;
        cVar2 = this.f29793a.f29783a;
        cVar2.onResume();
    }

    @Override // k6.a.AbstractC0363a
    public final int getState() {
        return 5;
    }
}
