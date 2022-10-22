package bn;

import java.io.File;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f5294a = "";

    public void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public boolean b(String str) {
        return new File(this.f5294a + str).exists();
    }
}
