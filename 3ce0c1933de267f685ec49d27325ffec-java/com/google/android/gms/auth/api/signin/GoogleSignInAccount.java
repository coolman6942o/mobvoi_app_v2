package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.i;
import c6.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h6.e;
import h6.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();

    /* renamed from: n  reason: collision with root package name */
    private static e f8373n = h.d();

    /* renamed from: a  reason: collision with root package name */
    private final int f8374a;

    /* renamed from: b  reason: collision with root package name */
    private String f8375b;

    /* renamed from: c  reason: collision with root package name */
    private String f8376c;

    /* renamed from: d  reason: collision with root package name */
    private String f8377d;

    /* renamed from: e  reason: collision with root package name */
    private String f8378e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f8379f;

    /* renamed from: g  reason: collision with root package name */
    private String f8380g;

    /* renamed from: h  reason: collision with root package name */
    private long f8381h;

    /* renamed from: i  reason: collision with root package name */
    private String f8382i;

    /* renamed from: j  reason: collision with root package name */
    private List<Scope> f8383j;

    /* renamed from: k  reason: collision with root package name */
    private String f8384k;

    /* renamed from: l  reason: collision with root package name */
    private String f8385l;

    /* renamed from: m  reason: collision with root package name */
    private Set<Scope> f8386m = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i10, String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, List<Scope> list, String str7, String str8) {
        this.f8374a = i10;
        this.f8375b = str;
        this.f8376c = str2;
        this.f8377d = str3;
        this.f8378e = str4;
        this.f8379f = uri;
        this.f8380g = str5;
        this.f8381h = j10;
        this.f8382i = str6;
        this.f8383j = list;
        this.f8384k = str7;
        this.f8385l = str8;
    }

    public static GoogleSignInAccount O0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        GoogleSignInAccount P0 = P0(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        P0.f8380g = jSONObject.optString("serverAuthCode", null);
        return P0;
    }

    private static GoogleSignInAccount P0(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l10, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l10 == null ? Long.valueOf(f8373n.b() / 1000) : l10).longValue(), i.g(str7), new ArrayList((Collection) i.k(set)), str5, str6);
    }

    private final JSONObject S0() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (J0() != null) {
                jSONObject.put("tokenId", J0());
            }
            if (G0() != null) {
                jSONObject.put("email", G0());
            }
            if (Q() != null) {
                jSONObject.put("displayName", Q());
            }
            if (I0() != null) {
                jSONObject.put("givenName", I0());
            }
            if (H0() != null) {
                jSONObject.put("familyName", H0());
            }
            if (K0() != null) {
                jSONObject.put("photoUrl", K0().toString());
            }
            if (M0() != null) {
                jSONObject.put("serverAuthCode", M0());
            }
            jSONObject.put("expirationTime", this.f8381h);
            jSONObject.put("obfuscatedIdentifier", this.f8382i);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.f8383j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, a.f8415a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.G0());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public String G0() {
        return this.f8377d;
    }

    public String H0() {
        return this.f8385l;
    }

    public String I0() {
        return this.f8384k;
    }

    public String J0() {
        return this.f8376c;
    }

    public Uri K0() {
        return this.f8379f;
    }

    public Set<Scope> L0() {
        HashSet hashSet = new HashSet(this.f8383j);
        hashSet.addAll(this.f8386m);
        return hashSet;
    }

    public String M0() {
        return this.f8380g;
    }

    public String Q() {
        return this.f8378e;
    }

    public final String Q0() {
        return this.f8382i;
    }

    public final String R0() {
        JSONObject S0 = S0();
        S0.remove("serverAuthCode");
        return S0.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f8382i.equals(this.f8382i) && googleSignInAccount.L0().equals(L0());
    }

    public String getId() {
        return this.f8375b;
    }

    public int hashCode() {
        return ((this.f8382i.hashCode() + 527) * 31) + L0().hashCode();
    }

    public Account o() {
        if (this.f8377d == null) {
            return null;
        }
        return new Account(this.f8377d, "com.google");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8374a);
        a.t(parcel, 2, getId(), false);
        a.t(parcel, 3, J0(), false);
        a.t(parcel, 4, G0(), false);
        a.t(parcel, 5, Q(), false);
        a.r(parcel, 6, K0(), i10, false);
        a.t(parcel, 7, M0(), false);
        a.o(parcel, 8, this.f8381h);
        a.t(parcel, 9, this.f8382i, false);
        a.x(parcel, 10, this.f8383j, false);
        a.t(parcel, 11, I0(), false);
        a.t(parcel, 12, H0(), false);
        a.b(parcel, a10);
    }
}
