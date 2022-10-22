package v3;

import a4.d;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f35579a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35580b;

    public b(String str, String str2) {
        this.f35579a = str;
        this.f35580b = str2;
    }

    public String a() {
        return this.f35580b;
    }

    public String b() {
        return this.f35579a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f35580b)) {
            return null;
        }
        try {
            return new JSONObject(this.f35580b);
        } catch (Exception e10) {
            d.d(e10);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f35579a, this.f35580b);
    }
}
