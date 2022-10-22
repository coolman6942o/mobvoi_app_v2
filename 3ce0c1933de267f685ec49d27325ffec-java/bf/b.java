package bf;

import android.content.Context;
import com.mobvoi.wear.info.AccountInfoHelper;
/* compiled from: AuthInterceptorWear.java */
/* loaded from: classes2.dex */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f5134a = context;
    }

    @Override // bf.a
    public String a() {
        return AccountInfoHelper.getInstance(this.f5134a).getAccountId();
    }

    @Override // bf.a
    public String b() {
        return AccountInfoHelper.getInstance(this.f5134a).getSessionId();
    }

    @Override // bf.a
    public String c() {
        return null;
    }
}
