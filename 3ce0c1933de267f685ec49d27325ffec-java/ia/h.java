package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: ResponseBean.kt */
/* loaded from: classes2.dex */
public final class h implements JsonBean {
    private final e releaseNotes;
    private final g version;

    public final g a() {
        return this.version;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return i.b(this.releaseNotes, hVar.releaseNotes) && i.b(this.version, hVar.version);
    }

    public int hashCode() {
        return (this.releaseNotes.hashCode() * 31) + this.version.hashCode();
    }

    public String toString() {
        return "VersionInfo(releaseNotes=" + this.releaseNotes + ", version=" + this.version + ')';
    }
}
