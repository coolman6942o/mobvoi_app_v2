package d6;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
/* loaded from: classes.dex */
public final class j extends c<m> {
    public j(Context context, Looper looper, b6.c cVar, d.b bVar, d.c cVar2) {
        super(context, looper, 39, cVar, bVar, cVar2);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if (queryLocalInterface instanceof m) {
            return (m) queryLocalInterface;
        }
        return new n(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final String v() {
        return "com.google.android.gms.common.service.START";
    }
}
