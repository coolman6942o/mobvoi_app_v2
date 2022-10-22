package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
/* loaded from: classes.dex */
public class a extends AGConnectInstance {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13506a;

    /* renamed from: b  reason: collision with root package name */
    private final c f13507b;

    public a(Context context) {
        this.f13506a = context;
        this.f13507b = new c(new b(context).a());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f13506a;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        return (T) this.f13507b.a(this, cls);
    }
}
