package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;
import qo.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes3.dex */
public class r extends q {
    public static <T> boolean s(Collection<? super T> addAll, Iterable<? extends T> elements) {
        i.f(addAll, "$this$addAll");
        i.f(elements, "elements");
        if (elements instanceof Collection) {
            return addAll.addAll((Collection) elements);
        }
        boolean z10 = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean t(Collection<? super T> addAll, T[] elements) {
        List b10;
        i.f(addAll, "$this$addAll");
        i.f(elements, "elements");
        b10 = h.b(elements);
        return addAll.addAll(b10);
    }

    private static final <T> boolean u(Iterable<? extends T> iterable, l<? super T, Boolean> lVar, boolean z10) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> boolean v(Iterable<? extends T> retainAll, l<? super T, Boolean> predicate) {
        i.f(retainAll, "$this$retainAll");
        i.f(predicate, "predicate");
        return u(retainAll, predicate, false);
    }
}
