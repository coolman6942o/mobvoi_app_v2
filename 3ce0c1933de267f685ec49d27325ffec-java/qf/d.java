package qf;

import android.text.TextUtils;
import java.util.Locale;
/* compiled from: DataSource.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f33134a;

    /* renamed from: b  reason: collision with root package name */
    public String f33135b;

    /* renamed from: c  reason: collision with root package name */
    public String f33136c;

    /* renamed from: d  reason: collision with root package name */
    public String f33137d;

    /* renamed from: e  reason: collision with root package name */
    public String f33138e;

    /* renamed from: f  reason: collision with root package name */
    public String f33139f;

    public d() {
        this.f33134a = "";
        this.f33135b = "";
        this.f33136c = "";
        this.f33137d = "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return TextUtils.equals(this.f33134a, dVar.f33134a) && TextUtils.equals(this.f33135b, dVar.f33135b) && TextUtils.equals(this.f33136c, dVar.f33136c) && TextUtils.equals(this.f33137d, dVar.f33137d) && TextUtils.equals(this.f33138e, dVar.f33138e) && TextUtils.equals(this.f33139f, dVar.f33139f);
    }

    public String toString() {
        return String.format(Locale.US, "DataSource[name=%s, wwid=%s, did=%s, type=%s, model=%s, version=%s]", this.f33134a, this.f33135b, this.f33136c, this.f33138e, this.f33137d, this.f33139f);
    }

    public d(d dVar) {
        this.f33134a = "";
        this.f33135b = "";
        this.f33136c = "";
        this.f33137d = "";
        this.f33134a = dVar.f33134a;
        this.f33135b = dVar.f33135b;
        this.f33136c = dVar.f33136c;
        this.f33137d = dVar.f33137d;
        this.f33138e = dVar.f33138e;
        this.f33139f = dVar.f33139f;
    }
}
