package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
/* compiled from: NavDeepLinkRequest.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f3505a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3506b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3507c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    public String a() {
        return this.f3506b;
    }

    public String b() {
        return this.f3507c;
    }

    public Uri c() {
        return this.f3505a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NavDeepLinkRequest");
        sb2.append("{");
        if (this.f3505a != null) {
            sb2.append(" uri=");
            sb2.append(this.f3505a.toString());
        }
        if (this.f3506b != null) {
            sb2.append(" action=");
            sb2.append(this.f3506b);
        }
        if (this.f3507c != null) {
            sb2.append(" mimetype=");
            sb2.append(this.f3507c);
        }
        sb2.append(" }");
        return sb2.toString();
    }

    j(Uri uri, String str, String str2) {
        this.f3505a = uri;
        this.f3506b = str;
        this.f3507c = str2;
    }
}
