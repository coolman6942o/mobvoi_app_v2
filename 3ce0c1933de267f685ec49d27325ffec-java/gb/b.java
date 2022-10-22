package gb;

import android.os.Bundle;
import androidx.navigation.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import pa.e;
/* compiled from: AccountFragmentDirections.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0291b f27308a = new C0291b(null);

    /* compiled from: AccountFragmentDirections.kt */
    /* loaded from: classes2.dex */
    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final String f27309a;

        /* renamed from: b  reason: collision with root package name */
        private final String f27310b;

        /* renamed from: c  reason: collision with root package name */
        private final String f27311c;

        /* renamed from: d  reason: collision with root package name */
        private final String f27312d;

        public a(String extraRestType, String str, String str2, String str3) {
            i.f(extraRestType, "extraRestType");
            this.f27309a = extraRestType;
            this.f27310b = str;
            this.f27311c = str2;
            this.f27312d = str3;
        }

        @Override // androidx.navigation.l
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("extra_rest_type", this.f27309a);
            bundle.putString("extra_account", this.f27310b);
            bundle.putString("extra_third_party_type", this.f27311c);
            bundle.putString("extra_third_party_uid", this.f27312d);
            return bundle;
        }

        @Override // androidx.navigation.l
        public int b() {
            return e.f32635f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return i.b(this.f27309a, aVar.f27309a) && i.b(this.f27310b, aVar.f27310b) && i.b(this.f27311c, aVar.f27311c) && i.b(this.f27312d, aVar.f27312d);
        }

        public int hashCode() {
            int hashCode = this.f27309a.hashCode() * 31;
            String str = this.f27310b;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f27311c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f27312d;
            if (str3 != null) {
                i10 = str3.hashCode();
            }
            return hashCode3 + i10;
        }

        public String toString() {
            return "ActionAccountFragmentToCaptchaFragment(extraRestType=" + this.f27309a + ", extraAccount=" + ((Object) this.f27310b) + ", extraThirdPartyType=" + ((Object) this.f27311c) + ", extraThirdPartyUid=" + ((Object) this.f27312d) + ')';
        }
    }

    /* compiled from: AccountFragmentDirections.kt */
    /* renamed from: gb.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0291b {
        private C0291b() {
        }

        public /* synthetic */ C0291b(f fVar) {
            this();
        }

        public final l a(String extraRestType, String str, String str2, String str3) {
            i.f(extraRestType, "extraRestType");
            return new a(extraRestType, str, str2, str3);
        }
    }
}
