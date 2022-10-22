package b6;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Account f5041a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f5042b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f5043c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f5044d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5045e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5046f;

    /* renamed from: g  reason: collision with root package name */
    private final a7.a f5047g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5048h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f5049i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f5050a;

        /* renamed from: b  reason: collision with root package name */
        private androidx.collection.b<Scope> f5051b;

        /* renamed from: c  reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f5052c;

        /* renamed from: e  reason: collision with root package name */
        private View f5054e;

        /* renamed from: f  reason: collision with root package name */
        private String f5055f;

        /* renamed from: g  reason: collision with root package name */
        private String f5056g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5058i;

        /* renamed from: d  reason: collision with root package name */
        private int f5053d = 0;

        /* renamed from: h  reason: collision with root package name */
        private a7.a f5057h = a7.a.f110i;

        public final a a(Collection<Scope> collection) {
            if (this.f5051b == null) {
                this.f5051b = new androidx.collection.b<>();
            }
            this.f5051b.addAll(collection);
            return this;
        }

        public final c b() {
            return new c(this.f5050a, this.f5051b, this.f5052c, this.f5053d, this.f5054e, this.f5055f, this.f5056g, this.f5057h, this.f5058i);
        }

        public final a c(Account account) {
            this.f5050a = account;
            return this;
        }

        public final a d(String str) {
            this.f5056g = str;
            return this;
        }

        public final a e(String str) {
            this.f5055f = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f5059a;
    }

    public c(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i10, View view, String str, String str2, a7.a aVar, boolean z10) {
        this.f5041a = account;
        Set<Scope> unmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f5042b = unmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f5044d = map;
        this.f5045e = str;
        this.f5046f = str2;
        this.f5047g = aVar;
        this.f5048h = z10;
        HashSet hashSet = new HashSet(unmodifiableSet);
        for (b bVar : map.values()) {
            hashSet.addAll(bVar.f5059a);
        }
        this.f5043c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.f5041a;
    }

    @Deprecated
    public final String b() {
        Account account = this.f5041a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public final Account c() {
        Account account = this.f5041a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> d() {
        return this.f5043c;
    }

    public final Set<Scope> e(com.google.android.gms.common.api.a<?> aVar) {
        b bVar = this.f5044d.get(aVar);
        if (bVar == null || bVar.f5059a.isEmpty()) {
            return this.f5042b;
        }
        HashSet hashSet = new HashSet(this.f5042b);
        hashSet.addAll(bVar.f5059a);
        return hashSet;
    }

    public final Integer f() {
        return this.f5049i;
    }

    public final Map<com.google.android.gms.common.api.a<?>, b> g() {
        return this.f5044d;
    }

    public final String h() {
        return this.f5046f;
    }

    public final String i() {
        return this.f5045e;
    }

    public final Set<Scope> j() {
        return this.f5042b;
    }

    public final a7.a k() {
        return this.f5047g;
    }

    public final boolean l() {
        return this.f5048h;
    }

    public final void m(Integer num) {
        this.f5049i = num;
    }
}
