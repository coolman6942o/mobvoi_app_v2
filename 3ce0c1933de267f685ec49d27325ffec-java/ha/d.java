package ha;

import com.mobvoi.apollo.ota.AbupException;
import ia.i;
import rx.c;
/* compiled from: AbupService.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final <T> c.AbstractC0468c<i<T>, T> c() {
        return b.f27764a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c d(c cVar) {
        return cVar.D(c.f27765a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object e(i iVar) {
        if (iVar.c() == 1000) {
            return iVar.a();
        }
        throw new AbupException(iVar.c(), iVar.b());
    }
}
