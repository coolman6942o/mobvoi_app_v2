package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import java.util.Objects;
import m3.f;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public int f6725c;

    /* renamed from: d  reason: collision with root package name */
    public Object f6726d;

    public e(int i10, String str, Object obj) {
        super(str, obj);
        this.f6725c = i10;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f6726d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f6726d != null) {
                arrayList.add(new BasicNameValuePair("extParam", f.a(this.f6726d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f6723a));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6725c);
            arrayList.add(new BasicNameValuePair("id", sb2.toString()));
            Objects.toString(this.f6724b);
            Object obj = this.f6724b;
            arrayList.add(new BasicNameValuePair("requestData", obj == null ? "[]" : f.a(obj)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder("request  =");
            sb3.append(this.f6724b);
            sb3.append(":");
            sb3.append(e10);
            throw new RpcException(9, sb3.toString() == null ? "" : e10.getMessage(), e10);
        }
    }
}
