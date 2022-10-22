package rd;

import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.tsmservice.data.Constant;
import h8.c;
/* compiled from: Response.java */
/* loaded from: classes2.dex */
public class b {
    @c("err_code")

    /* renamed from: a  reason: collision with root package name */
    public int f33495a;
    @c("err_msg")

    /* renamed from: b  reason: collision with root package name */
    public String f33496b;
    @c(PermissionConstant.Columns.STATUS)

    /* renamed from: c  reason: collision with root package name */
    public String f33497c;
    @c("result")

    /* renamed from: d  reason: collision with root package name */
    public a f33498d;

    /* compiled from: Response.java */
    /* loaded from: classes2.dex */
    public static class a {
        @c("is_confirmed")

        /* renamed from: a  reason: collision with root package name */
        public int f33499a;
    }

    private int a() {
        a aVar = this.f33498d;
        if (aVar == null) {
            return -1;
        }
        return aVar.f33499a;
    }

    public boolean b() {
        return Constant.CASH_LOAD_SUCCESS.equals(this.f33497c);
    }

    public String toString() {
        return "Response{errCode=" + this.f33495a + ", errMsg='" + this.f33496b + "', status='" + this.f33497c + "', is_confirmed='" + a() + "'}";
    }
}
