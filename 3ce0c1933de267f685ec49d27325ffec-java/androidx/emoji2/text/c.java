package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.emoji2.text.d;
import j0.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: DefaultEmojiCompatConfig.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: DefaultEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f2785a;

        public a(b bVar) {
            this.f2785a = bVar == null ? e() : bVar;
        }

        private d.c a(Context context, h0.d dVar) {
            if (dVar == null) {
                return null;
            }
            return new i(context, dVar);
        }

        private List<List<byte[]>> b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private h0.d d(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new h0.d(str, str2, "emojicompat-emoji-font", b(this.f2785a.b(packageManager, str2)));
        }

        private static b e() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                return new d();
            }
            if (i10 >= 19) {
                return new C0026c();
            }
            return new b();
        }

        private boolean f(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        private ProviderInfo g(PackageManager packageManager) {
            for (ResolveInfo resolveInfo : this.f2785a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0)) {
                ProviderInfo a10 = this.f2785a.a(resolveInfo);
                if (f(a10)) {
                    return a10;
                }
            }
            return null;
        }

        public d.c c(Context context) {
            return a(context, h(context));
        }

        h0.d h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            h.h(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g10 = g(packageManager);
            if (g10 == null) {
                return null;
            }
            try {
                return d(g10, packageManager);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e10);
                return null;
            }
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class b {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i10) {
            return Collections.emptyList();
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    /* renamed from: androidx.emoji2.text.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026c extends b {
        @Override // androidx.emoji2.text.c.b
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        public List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i10) {
            return packageManager.queryIntentContentProviders(intent, i10);
        }
    }

    /* compiled from: DefaultEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class d extends C0026c {
        @Override // androidx.emoji2.text.c.b
        public Signature[] b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static i a(Context context) {
        return (i) new a(null).c(context);
    }
}
