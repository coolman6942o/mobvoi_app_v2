package ia;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: ResponseBean.kt */
/* loaded from: classes2.dex */
public final class i<T> implements JsonBean {
    private final T data;
    private final String msg;
    private final int status;

    public final T a() {
        return this.data;
    }

    public final String b() {
        return this.msg;
    }

    public final int c() {
        return this.status;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.status == iVar.status && kotlin.jvm.internal.i.b(this.msg, iVar.msg) && kotlin.jvm.internal.i.b(this.data, iVar.data);
    }

    public int hashCode() {
        int hashCode = ((this.status * 31) + this.msg.hashCode()) * 31;
        T t10 = this.data;
        return hashCode + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "Wrapper(status=" + this.status + ", msg=" + this.msg + ", data=" + this.data + ')';
    }
}
