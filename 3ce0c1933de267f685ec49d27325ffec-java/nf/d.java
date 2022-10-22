package nf;
/* compiled from: BooleanRegistration.java */
/* loaded from: classes2.dex */
public class d implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f31232a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31233b = false;

    public d(Runnable runnable) {
        this.f31232a = runnable;
    }

    @Override // nf.l
    public void clear() {
        this.f31233b = true;
        Runnable runnable = this.f31232a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // nf.l
    public boolean d() {
        return this.f31233b;
    }
}
