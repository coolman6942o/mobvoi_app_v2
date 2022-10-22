package wo;

import qo.p;
import wo.j;
/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface m<D, E, V> extends j<V>, p<D, E, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<D, E, V> extends j.a<V>, p<D, E, V> {
    }

    Object getDelegate(D d10, E e10);

    a<D, E, V> getGetter();
}
