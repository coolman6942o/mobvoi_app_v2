package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import m3.e;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.f6722b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt("resultStatus");
            if (i10 == 1000) {
                return this.f6721a == String.class ? jSONObject.optString("result") : e.b(jSONObject.optString("result"), this.f6721a);
            }
            throw new RpcException(Integer.valueOf(i10), jSONObject.optString("tips"));
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.f6722b));
            sb2.append(":");
            sb2.append(e10);
            throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e10.getMessage());
        }
    }
}
