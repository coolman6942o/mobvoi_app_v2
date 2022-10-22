package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.c, a.d, ReflectedParcelable {

    /* renamed from: n  reason: collision with root package name */
    public static final Scope f8390n;

    /* renamed from: a  reason: collision with root package name */
    private final int f8394a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Scope> f8395b;

    /* renamed from: c  reason: collision with root package name */
    private Account f8396c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8397d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8398e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8399f;

    /* renamed from: g  reason: collision with root package name */
    private String f8400g;

    /* renamed from: h  reason: collision with root package name */
    private String f8401h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<GoogleSignInOptionsExtensionParcelable> f8402i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> f8403j;

    /* renamed from: k  reason: collision with root package name */
    public static final Scope f8387k = new Scope("profile");

    /* renamed from: l  reason: collision with root package name */
    public static final Scope f8388l = new Scope("email");

    /* renamed from: m  reason: collision with root package name */
    public static final Scope f8389m = new Scope("openid");

    /* renamed from: o  reason: collision with root package name */
    public static final Scope f8391o = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: p  reason: collision with root package name */
    public static final GoogleSignInOptions f8392p = new a().c().e().a();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new d();

    /* renamed from: q  reason: collision with root package name */
    private static Comparator<Scope> f8393q = new c();

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f8390n = scope;
        new a().f(scope, new Scope[0]).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptions(int i10, ArrayList<Scope> arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, N0(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> N0(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.G0()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public static GoogleSignInOptions O0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private final JSONObject S0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f8395b, f8393q);
            ArrayList<Scope> arrayList = this.f8395b;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Scope scope = arrayList.get(i10);
                i10++;
                jSONArray.put(scope.G0());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f8396c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f8397d);
            jSONObject.put("forceCodeForRefreshToken", this.f8399f);
            jSONObject.put("serverAuthRequested", this.f8398e);
            if (!TextUtils.isEmpty(this.f8400g)) {
                jSONObject.put("serverClientId", this.f8400g);
            }
            if (!TextUtils.isEmpty(this.f8401h)) {
                jSONObject.put("hostedDomain", this.f8401h);
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> G0() {
        return this.f8402i;
    }

    public ArrayList<Scope> H0() {
        return new ArrayList<>(this.f8395b);
    }

    public String I0() {
        return this.f8400g;
    }

    public boolean J0() {
        return this.f8399f;
    }

    public boolean K0() {
        return this.f8397d;
    }

    public boolean L0() {
        return this.f8398e;
    }

    public final String U0() {
        return S0().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r1.equals(r4.o()) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r3.f8400g.equals(r4.I0()) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f8402i.size() <= 0 && googleSignInOptions.f8402i.size() <= 0 && this.f8395b.size() == googleSignInOptions.H0().size() && this.f8395b.containsAll(googleSignInOptions.H0())) {
                Account account = this.f8396c;
                if (account == null) {
                    if (googleSignInOptions.o() == null) {
                    }
                }
                if (TextUtils.isEmpty(this.f8400g)) {
                    if (TextUtils.isEmpty(googleSignInOptions.I0())) {
                    }
                }
                if (this.f8399f == googleSignInOptions.J0() && this.f8397d == googleSignInOptions.K0()) {
                    if (this.f8398e == googleSignInOptions.L0()) {
                        return true;
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f8395b;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Scope scope = arrayList2.get(i10);
            i10++;
            arrayList.add(scope.G0());
        }
        Collections.sort(arrayList);
        return new x5.a().a(arrayList).a(this.f8396c).a(this.f8400g).c(this.f8399f).c(this.f8397d).c(this.f8398e).b();
    }

    public Account o() {
        return this.f8396c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.l(parcel, 1, this.f8394a);
        c6.a.x(parcel, 2, H0(), false);
        c6.a.r(parcel, 3, o(), i10, false);
        c6.a.c(parcel, 4, K0());
        c6.a.c(parcel, 5, L0());
        c6.a.c(parcel, 6, J0());
        c6.a.t(parcel, 7, I0(), false);
        c6.a.t(parcel, 8, this.f8401h, false);
        c6.a.x(parcel, 9, G0(), false);
        c6.a.b(parcel, a10);
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set<Scope> f8404a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8405b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8406c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8407d;

        /* renamed from: e  reason: collision with root package name */
        private String f8408e;

        /* renamed from: f  reason: collision with root package name */
        private Account f8409f;

        /* renamed from: g  reason: collision with root package name */
        private String f8410g;

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f8411h;

        public a() {
            this.f8404a = new HashSet();
            this.f8411h = new HashMap();
        }

        private final String g(String str) {
            i.g(str);
            String str2 = this.f8408e;
            i.b(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public final GoogleSignInOptions a() {
            if (this.f8404a.contains(GoogleSignInOptions.f8391o)) {
                Set<Scope> set = this.f8404a;
                Scope scope = GoogleSignInOptions.f8390n;
                if (set.contains(scope)) {
                    this.f8404a.remove(scope);
                }
            }
            if (this.f8407d && (this.f8409f == null || !this.f8404a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f8404a), this.f8409f, this.f8407d, this.f8405b, this.f8406c, this.f8408e, this.f8410g, this.f8411h, null);
        }

        public final a b() {
            this.f8404a.add(GoogleSignInOptions.f8388l);
            return this;
        }

        public final a c() {
            this.f8404a.add(GoogleSignInOptions.f8389m);
            return this;
        }

        public final a d(String str) {
            this.f8407d = true;
            this.f8408e = g(str);
            return this;
        }

        public final a e() {
            this.f8404a.add(GoogleSignInOptions.f8387k);
            return this;
        }

        public final a f(Scope scope, Scope... scopeArr) {
            this.f8404a.add(scope);
            this.f8404a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.f8404a = new HashSet();
            this.f8411h = new HashMap();
            i.k(googleSignInOptions);
            this.f8404a = new HashSet(googleSignInOptions.f8395b);
            this.f8405b = googleSignInOptions.f8398e;
            this.f8406c = googleSignInOptions.f8399f;
            this.f8407d = googleSignInOptions.f8397d;
            this.f8408e = googleSignInOptions.f8400g;
            this.f8409f = googleSignInOptions.f8396c;
            this.f8410g = googleSignInOptions.f8401h;
            this.f8411h = GoogleSignInOptions.N0(googleSignInOptions.f8402i);
        }
    }

    private GoogleSignInOptions(int i10, ArrayList<Scope> arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.f8394a = i10;
        this.f8395b = arrayList;
        this.f8396c = account;
        this.f8397d = z10;
        this.f8398e = z11;
        this.f8399f = z12;
        this.f8400g = str;
        this.f8401h = str2;
        this.f8402i = new ArrayList<>(map.values());
        this.f8403j = map;
    }

    /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, c cVar) {
        this(3, arrayList, account, z10, z11, z12, str, str2, map);
    }
}
