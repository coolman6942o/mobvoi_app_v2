package sk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.TelecomManager;
import com.mobvoi.android.common.utils.k;
/* compiled from: PTelephonyInterface.java */
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    private Context f35021b;

    public b(Context context) {
        super(context);
        this.f35021b = context;
    }

    @Override // sk.c, sk.d
    @SuppressLint({"NewApi"})
    public boolean endCall() {
        TelecomManager telecomManager = (TelecomManager) this.f35021b.getSystemService("telecom");
        if (telecomManager == null || androidx.core.content.b.a(this.f35021b, "android.permission.ANSWER_PHONE_CALLS") != 0) {
            return false;
        }
        k.a("PTelephonyInterface", "endCall");
        telecomManager.endCall();
        return true;
    }
}
