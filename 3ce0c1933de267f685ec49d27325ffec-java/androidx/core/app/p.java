package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f2406a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f2407b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f2408c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2409d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2410e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f2411f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f2412g;

    /* compiled from: RemoteInput.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f2413a;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f2416d;

        /* renamed from: e  reason: collision with root package name */
        private CharSequence[] f2417e;

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f2414b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f2415c = new Bundle();

        /* renamed from: f  reason: collision with root package name */
        private boolean f2418f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f2419g = 0;

        public a(String str) {
            if (str != null) {
                this.f2413a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public p a() {
            return new p(this.f2413a, this.f2416d, this.f2417e, this.f2418f, this.f2419g, this.f2415c, this.f2414b);
        }

        public a b(boolean z10) {
            this.f2418f = z10;
            return this;
        }

        public a c(CharSequence[] charSequenceArr) {
            this.f2417e = charSequenceArr;
            return this;
        }

        public a d(CharSequence charSequence) {
            this.f2416d = charSequence;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z10, int i10, Bundle bundle, Set<String> set) {
        this.f2406a = str;
        this.f2407b = charSequence;
        this.f2408c = charSequenceArr;
        this.f2409d = z10;
        this.f2410e = i10;
        this.f2411f = bundle;
        this.f2412g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    static RemoteInput a(p pVar) {
        Set<String> d10;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(pVar.i()).setLabel(pVar.h()).setChoices(pVar.e()).setAllowFreeFormInput(pVar.c()).addExtras(pVar.g());
        if (Build.VERSION.SDK_INT >= 26 && (d10 = pVar.d()) != null) {
            for (String str : d10) {
                addExtras.setAllowDataType(str, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(pVar.f());
        }
        return addExtras.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(p[] pVarArr) {
        if (pVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[pVarArr.length];
        for (int i10 = 0; i10 < pVarArr.length; i10++) {
            remoteInputArr[i10] = a(pVarArr[i10]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f2409d;
    }

    public Set<String> d() {
        return this.f2412g;
    }

    public CharSequence[] e() {
        return this.f2408c;
    }

    public int f() {
        return this.f2410e;
    }

    public Bundle g() {
        return this.f2411f;
    }

    public CharSequence h() {
        return this.f2407b;
    }

    public String i() {
        return this.f2406a;
    }

    public boolean j() {
        return !c() && (e() == null || e().length == 0) && d() != null && !d().isEmpty();
    }
}
