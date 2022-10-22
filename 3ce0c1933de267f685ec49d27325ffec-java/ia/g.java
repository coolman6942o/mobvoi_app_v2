package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: ResponseBean.kt */
/* loaded from: classes2.dex */
public final class g implements JsonBean {
    private final String bakUrl;
    private final String deltaID;
    private final String deltaUrl;
    private final long fileSize;
    private final String md5sum;
    private final String versionName;

    public final String a() {
        return this.deltaID;
    }

    public final String b() {
        return this.deltaUrl;
    }

    public final long c() {
        return this.fileSize;
    }

    public final String d() {
        return this.md5sum;
    }

    public final String e() {
        return this.versionName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return i.b(this.versionName, gVar.versionName) && this.fileSize == gVar.fileSize && i.b(this.deltaID, gVar.deltaID) && i.b(this.md5sum, gVar.md5sum) && i.b(this.deltaUrl, gVar.deltaUrl) && i.b(this.bakUrl, gVar.bakUrl);
    }

    public int hashCode() {
        return (((((((((this.versionName.hashCode() * 31) + a.a(this.fileSize)) * 31) + this.deltaID.hashCode()) * 31) + this.md5sum.hashCode()) * 31) + this.deltaUrl.hashCode()) * 31) + this.bakUrl.hashCode();
    }

    public String toString() {
        return "VersionData(versionName=" + this.versionName + ", fileSize=" + this.fileSize + ", deltaID=" + this.deltaID + ", md5sum=" + this.md5sum + ", deltaUrl=" + this.deltaUrl + ", bakUrl=" + this.bakUrl + ')';
    }
}
