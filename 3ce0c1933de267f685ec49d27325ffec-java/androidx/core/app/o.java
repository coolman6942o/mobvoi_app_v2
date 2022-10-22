package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
/* compiled from: Person.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f2400a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f2401b;

    /* renamed from: c  reason: collision with root package name */
    String f2402c;

    /* renamed from: d  reason: collision with root package name */
    String f2403d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2404e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2405f;

    public IconCompat a() {
        return this.f2401b;
    }

    public String b() {
        return this.f2403d;
    }

    public CharSequence c() {
        return this.f2400a;
    }

    public String d() {
        return this.f2402c;
    }

    public boolean e() {
        return this.f2404e;
    }

    public boolean f() {
        return this.f2405f;
    }

    public String g() {
        String str = this.f2402c;
        if (str != null) {
            return str;
        }
        if (this.f2400a == null) {
            return "";
        }
        return "name:" + ((Object) this.f2400a);
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().t() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
