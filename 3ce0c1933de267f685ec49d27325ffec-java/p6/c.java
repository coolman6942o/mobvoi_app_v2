package p6;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import t5.a;
/* loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.c<e> {
    private final a.C0501a E;

    public c(Context context, Looper looper, b6.c cVar, a.C0501a aVar, d.b bVar, d.c cVar2) {
        super(context, looper, 68, cVar, bVar, cVar2);
        this.E = aVar;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle D() {
        a.C0501a aVar = this.E;
        return aVar == null ? new Bundle() : aVar.a();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof e) {
            return (e) queryLocalInterface;
        }
        return new f(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int p() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String v() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
