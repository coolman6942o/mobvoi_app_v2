package o6;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.c;
/* loaded from: classes.dex */
public final class b extends c<c> {
    private final Bundle E;

    public b(Context context, Looper looper, b6.c cVar, t5.c cVar2, d.b bVar, d.c cVar3) {
        super(context, looper, 16, cVar, bVar, cVar3);
        if (cVar2 == null) {
            this.E = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle D() {
        return this.E;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int p() {
        return e.f8830a;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean t() {
        b6.c l02 = l0();
        return !TextUtils.isEmpty(l02.b()) && !l02.e(t5.b.f35063c).isEmpty();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String v() {
        return "com.google.android.gms.auth.service.START";
    }
}
