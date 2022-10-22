package o6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f31451a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f31451a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f31451a;
    }
}
