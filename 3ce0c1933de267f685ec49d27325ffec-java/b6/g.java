package b6;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.c;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f5061a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private c f5062b;

    public g(c cVar) {
        i.k(cVar);
        this.f5062b = cVar;
    }

    public void a() {
        this.f5061a.clear();
    }

    public int b(Context context, a.f fVar) {
        i.k(context);
        i.k(fVar);
        int i10 = 0;
        if (!fVar.o()) {
            return 0;
        }
        int p10 = fVar.p();
        int i11 = this.f5061a.get(p10, -1);
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= this.f5061a.size()) {
                i10 = i11;
                break;
            }
            int keyAt = this.f5061a.keyAt(i12);
            if (keyAt > p10 && this.f5061a.get(keyAt) == 0) {
                break;
            }
            i12++;
        }
        if (i10 == -1) {
            i10 = this.f5062b.j(context, p10);
        }
        this.f5061a.put(p10, i10);
        return i10;
    }
}
