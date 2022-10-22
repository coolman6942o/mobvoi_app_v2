package b4;

import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Stack<e> f5038a = new Stack<>();

    public void a() {
        if (!c()) {
            Iterator<e> it = this.f5038a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f5038a.clear();
        }
    }

    public void b(e eVar) {
        this.f5038a.push(eVar);
    }

    public boolean c() {
        return this.f5038a.isEmpty();
    }

    public e d() {
        return this.f5038a.pop();
    }
}
