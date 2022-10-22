package b6;

import android.content.Context;
import android.content.res.Resources;
import z5.b;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f5065a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5066b;

    public j(Context context) {
        i.k(context);
        Resources resources = context.getResources();
        this.f5065a = resources;
        this.f5066b = resources.getResourcePackageName(b.f37287a);
    }

    public String a(String str) {
        int identifier = this.f5065a.getIdentifier(str, "string", this.f5066b);
        if (identifier == 0) {
            return null;
        }
        return this.f5065a.getString(identifier);
    }
}
