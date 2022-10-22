package ib;

import android.os.Bundle;
import androidx.navigation.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import pa.e;
/* compiled from: CaptchaFragmentDirections.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f28214a = new b(null);

    /* compiled from: CaptchaFragmentDirections.kt */
    /* loaded from: classes2.dex */
    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final String f28215a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28216b;

        public a(String str, String str2) {
            this.f28215a = str;
            this.f28216b = str2;
        }

        @Override // androidx.navigation.l
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("extra_third_party_type", this.f28215a);
            bundle.putString("extra_third_party_uid", this.f28216b);
            return bundle;
        }

        @Override // androidx.navigation.l
        public int b() {
            return e.f32637g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return i.b(this.f28215a, aVar.f28215a) && i.b(this.f28216b, aVar.f28216b);
        }

        public int hashCode() {
            String str = this.f28215a;
            int i10 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f28216b;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "ActionCaptchaFragmentToBindSuccessFragment(extraThirdPartyType=" + ((Object) this.f28215a) + ", extraThirdPartyUid=" + ((Object) this.f28216b) + ')';
        }
    }

    /* compiled from: CaptchaFragmentDirections.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final l a(String str, String str2) {
            return new a(str, str2);
        }
    }
}
