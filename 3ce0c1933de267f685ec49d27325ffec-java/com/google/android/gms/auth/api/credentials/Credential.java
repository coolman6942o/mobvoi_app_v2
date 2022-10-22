package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f8327a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8328b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f8329c;

    /* renamed from: d  reason: collision with root package name */
    private final List<IdToken> f8330d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8331e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8332f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8333g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8334h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Credential(String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        List<IdToken> list2;
        String trim = ((String) i.l(str, "credential identifier cannot be null")).trim();
        i.h(trim, "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z10 = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                        z10 = true;
                    }
                }
                if (!Boolean.valueOf(z10).booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.f8328b = str2;
                this.f8329c = uri;
                if (list == null) {
                    list2 = Collections.emptyList();
                } else {
                    list2 = Collections.unmodifiableList(list);
                }
                this.f8330d = list2;
                this.f8327a = trim;
                this.f8331e = str3;
                this.f8332f = str4;
                this.f8333g = str5;
                this.f8334h = str6;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public String G0() {
        return this.f8332f;
    }

    public String H0() {
        return this.f8334h;
    }

    public String I0() {
        return this.f8333g;
    }

    public List<IdToken> J0() {
        return this.f8330d;
    }

    public String K0() {
        return this.f8331e;
    }

    public Uri L0() {
        return this.f8329c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f8327a, credential.f8327a) && TextUtils.equals(this.f8328b, credential.f8328b) && h.a(this.f8329c, credential.f8329c) && TextUtils.equals(this.f8331e, credential.f8331e) && TextUtils.equals(this.f8332f, credential.f8332f);
    }

    public String getId() {
        return this.f8327a;
    }

    public String getName() {
        return this.f8328b;
    }

    public int hashCode() {
        return h.b(this.f8327a, this.f8328b, this.f8329c, this.f8331e, this.f8332f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 1, getId(), false);
        a.t(parcel, 2, getName(), false);
        a.r(parcel, 3, L0(), i10, false);
        a.x(parcel, 4, J0(), false);
        a.t(parcel, 5, K0(), false);
        a.t(parcel, 6, G0(), false);
        a.t(parcel, 9, I0(), false);
        a.t(parcel, 10, H0(), false);
        a.b(parcel, a10);
    }
}
