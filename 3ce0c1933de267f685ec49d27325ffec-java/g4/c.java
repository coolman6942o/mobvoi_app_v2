package g4;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f27256a;

    public c(b bVar) {
        this.f27256a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f27256a.d();
        } catch (Exception e10) {
            d.c(e10);
        }
    }
}
