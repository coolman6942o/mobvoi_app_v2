package jb;

import android.os.Bundle;
import androidx.navigation.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import pa.e;
/* compiled from: LoginFragmentDirections.kt */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final b f29492a = new b(null);

    /* compiled from: LoginFragmentDirections.kt */
    /* loaded from: classes2.dex */
    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final String f29493a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29494b;

        /* renamed from: c  reason: collision with root package name */
        private final String f29495c;

        public a(String extraRestType, String str, String str2) {
            i.f(extraRestType, "extraRestType");
            this.f29493a = extraRestType;
            this.f29494b = str;
            this.f29495c = str2;
        }

        @Override // androidx.navigation.l
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("extra_rest_type", this.f29493a);
            bundle.putString("extra_third_party_type", this.f29494b);
            bundle.putString("extra_third_party_uid", this.f29495c);
            return bundle;
        }

        @Override // androidx.navigation.l
        public int b() {
            return e.f32643j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return i.b(this.f29493a, aVar.f29493a) && i.b(this.f29494b, aVar.f29494b) && i.b(this.f29495c, aVar.f29495c);
        }

        public int hashCode() {
            int hashCode = this.f29493a.hashCode() * 31;
            String str = this.f29494b;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f29495c;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "ActionLoginFragmentToRestBindThirdParty(extraRestType=" + this.f29493a + ", extraThirdPartyType=" + ((Object) this.f29494b) + ", extraThirdPartyUid=" + ((Object) this.f29495c) + ')';
        }
    }

    /* compiled from: LoginFragmentDirections.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final l a(String extraRestType, String str, String str2) {
            i.f(extraRestType, "extraRestType");
            return new a(extraRestType, str, str2);
        }
    }
}
