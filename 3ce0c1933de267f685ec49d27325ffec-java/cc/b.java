package cc;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.util.Arrays;
import kotlin.jvm.internal.i;
/* compiled from: Image.kt */
/* loaded from: classes2.dex */
public final class b implements JsonBean {
    @c("class_name")
    private String className;
    @c("image")
    private byte[] image;
    @c("image_url")
    private String imageUrl;
    @c("pkg_name")
    private String pkgName;

    public final String a() {
        return this.className;
    }

    public final byte[] b() {
        return this.image;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Image(className=");
        sb2.append((Object) this.className);
        sb2.append(", image=");
        byte[] bArr = this.image;
        if (bArr == null) {
            str = null;
        } else {
            str = Arrays.toString(bArr);
            i.e(str, "java.util.Arrays.toString(this)");
        }
        sb2.append((Object) str);
        sb2.append(", imageUrl=");
        sb2.append((Object) this.imageUrl);
        sb2.append(", pkgName=");
        sb2.append((Object) this.pkgName);
        sb2.append(')');
        return sb2.toString();
    }
}
