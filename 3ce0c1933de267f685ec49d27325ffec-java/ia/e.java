package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: ResponseBean.kt */
/* loaded from: classes2.dex */
public final class e implements JsonBean {
    private final String publishDate;
    private final String version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return i.b(this.publishDate, eVar.publishDate) && i.b(this.version, eVar.version);
    }

    public int hashCode() {
        return (this.publishDate.hashCode() * 31) + this.version.hashCode();
    }

    public String toString() {
        return "ReleaseNote(publishDate=" + this.publishDate + ", version=" + this.version + ')';
    }
}
