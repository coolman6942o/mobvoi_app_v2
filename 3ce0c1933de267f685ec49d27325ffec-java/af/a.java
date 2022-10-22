package af;

import ef.o;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
/* compiled from: LocationQueue.java */
/* loaded from: classes2.dex */
class a {

    /* renamed from: b  reason: collision with root package name */
    private final float f200b;

    /* renamed from: c  reason: collision with root package name */
    private o f201c;

    /* renamed from: a  reason: collision with root package name */
    private final Queue<o> f199a = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f202d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f10) {
        this.f200b = f10;
    }

    private float g(o oVar, o oVar2) {
        return ((float) (oVar2.f25945b - oVar.f25945b)) / 1000.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f202d = false;
        this.f199a.clear();
        this.f201c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<o> b(o oVar) {
        com.mobvoi.android.common.utils.o.e(oVar);
        this.f201c = oVar;
        this.f199a.offer(oVar);
        while (g(this.f199a.peek(), oVar) > this.f200b) {
            this.f202d = true;
            this.f199a.poll();
        }
        return this.f199a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<o> c() {
        return this.f199a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f199a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f202d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o f() {
        return this.f201c;
    }
}
