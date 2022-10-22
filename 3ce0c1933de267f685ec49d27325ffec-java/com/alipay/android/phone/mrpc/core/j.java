package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: g  reason: collision with root package name */
    public g f6747g;

    public j(g gVar, Method method, int i10, String str, byte[] bArr, boolean z10) {
        super(method, i10, str, bArr, "application/x-www-form-urlencoded", z10);
        this.f6747g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        o oVar = new o(this.f6747g.a());
        oVar.a(this.f6716b);
        oVar.a(this.f6719e);
        oVar.a(this.f6720f);
        oVar.a("id", String.valueOf(this.f6718d));
        oVar.a("operationType", this.f6717c);
        oVar.a("gzip", String.valueOf(this.f6747g.d()));
        oVar.a((Header) new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b10 = this.f6747g.c().b();
        if (b10 != null && !b10.isEmpty()) {
            for (Header header : b10) {
                oVar.a(header);
            }
        }
        Thread.currentThread().getId();
        oVar.toString();
        try {
            u uVar = this.f6747g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (InterruptedException e10) {
            throw new RpcException(13, "", e10);
        } catch (CancellationException e11) {
            throw new RpcException(13, "", e11);
        } catch (ExecutionException e12) {
            Throwable cause = e12.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(9, "", e12);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        }
    }
}
