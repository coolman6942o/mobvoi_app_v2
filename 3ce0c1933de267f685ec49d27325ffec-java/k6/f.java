package k6;

import java.util.Iterator;
import java.util.LinkedList;
import k6.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a f29788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f29788a = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // k6.e
    public final void a(c cVar) {
        LinkedList linkedList;
        LinkedList linkedList2;
        c cVar2;
        this.f29788a.f29783a = cVar;
        linkedList = this.f29788a.f29785c;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cVar2 = this.f29788a.f29783a;
            ((a.AbstractC0363a) it.next()).a(cVar2);
        }
        linkedList2 = this.f29788a.f29785c;
        linkedList2.clear();
        this.f29788a.f29784b = null;
    }
}
