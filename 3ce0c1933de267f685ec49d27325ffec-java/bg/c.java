package bg;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import qf.a;
/* compiled from: DataMerger.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<a> f5143b = b.f5142a;

    /* renamed from: a  reason: collision with root package name */
    private final Map<DataType, NavigableSet<a>> f5144a = new HashMap();

    private NavigableSet<a> b(DataType dataType) {
        NavigableSet<a> navigableSet = this.f5144a.get(dataType);
        if (navigableSet != null) {
            return navigableSet;
        }
        TreeSet treeSet = new TreeSet(f5143b);
        this.f5144a.put(dataType, treeSet);
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(a aVar, a aVar2) {
        return Long.compare(aVar.f5139b, aVar2.f5139b);
    }

    private NavigableSet<a> f(NavigableSet<a> navigableSet, a aVar) {
        TreeSet treeSet = new TreeSet((SortedSet) navigableSet.subSet(a.a(aVar.f5139b), true, a.a(aVar.f5140c), false));
        a lower = navigableSet.lower(a.a(aVar.f5139b));
        if (lower != null && lower.e(aVar)) {
            treeSet.add(lower);
        }
        return treeSet;
    }

    private boolean g(NavigableSet<a> navigableSet, a aVar) {
        boolean z10 = false;
        if (aVar.f5141d <= 0.0f) {
            return false;
        }
        Iterator<a> it = f(navigableSet, aVar).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            a d10 = next.d(aVar);
            if (d10 != null) {
                navigableSet.remove(next);
                long j10 = aVar.f5139b;
                long j11 = d10.f5139b;
                if (j10 < j11) {
                    navigableSet.add(aVar.f(j10, j11));
                }
                long j12 = next.f5139b;
                long j13 = d10.f5139b;
                if (j12 < j13) {
                    navigableSet.add(next.f(j12, j13));
                }
                navigableSet.add(d10);
                long j14 = next.f5140c;
                long j15 = d10.f5140c;
                if (j14 > j15) {
                    navigableSet.add(next.f(j15, j14));
                }
                long j16 = aVar.f5140c;
                long j17 = d10.f5140c;
                if (j16 <= j17) {
                    z10 = true;
                    break;
                }
                aVar = aVar.f(j17, j16);
                z10 = true;
            }
        }
        if (aVar.f5141d <= 0.0f) {
            return z10;
        }
        navigableSet.add(a.b(aVar));
        return true;
    }

    public Collection<a> c(DataType dataType) {
        return b(dataType);
    }

    public boolean d(a aVar) {
        a c10 = a.c(aVar);
        DataType dataType = c10.f5138a;
        if (dataType == DataType.DeltaStep || dataType == DataType.DeltaExercise || dataType == DataType.DeltaCalorie || dataType == DataType.Temperature || dataType == DataType.DeltaDistance) {
            return g(b(dataType), c10);
        }
        return false;
    }
}
