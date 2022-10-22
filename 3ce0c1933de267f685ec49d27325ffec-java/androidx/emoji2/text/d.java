package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* compiled from: EmojiCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: n  reason: collision with root package name */
    private static final Object f2786n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static volatile d f2787o;

    /* renamed from: b  reason: collision with root package name */
    private final Set<e> f2789b;

    /* renamed from: e  reason: collision with root package name */
    private final b f2792e;

    /* renamed from: f  reason: collision with root package name */
    final g f2793f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f2794g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f2795h;

    /* renamed from: i  reason: collision with root package name */
    final int[] f2796i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f2797j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2798k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2799l;

    /* renamed from: m  reason: collision with root package name */
    private final AbstractC0028d f2800m;

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f2788a = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private volatile int f2790c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f2791d = new Handler(Looper.getMainLooper());

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    private static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private volatile androidx.emoji2.text.g f2801b;

        /* renamed from: c  reason: collision with root package name */
        private volatile l f2802c;

        /* compiled from: EmojiCompat.java */
        /* renamed from: androidx.emoji2.text.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0027a extends h {
            C0027a() {
            }

            @Override // androidx.emoji2.text.d.h
            public void a(Throwable th2) {
                a.this.f2804a.m(th2);
            }

            @Override // androidx.emoji2.text.d.h
            public void b(l lVar) {
                a.this.d(lVar);
            }
        }

        a(d dVar) {
            super(dVar);
        }

        @Override // androidx.emoji2.text.d.b
        void a() {
            try {
                this.f2804a.f2793f.a(new C0027a());
            } catch (Throwable th2) {
                this.f2804a.m(th2);
            }
        }

        @Override // androidx.emoji2.text.d.b
        CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f2801b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.d.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f2802c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f2804a.f2794g);
        }

        void d(l lVar) {
            if (lVar == null) {
                this.f2804a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f2802c = lVar;
            l lVar2 = this.f2802c;
            i iVar = new i();
            AbstractC0028d dVar = this.f2804a.f2800m;
            d dVar2 = this.f2804a;
            this.f2801b = new androidx.emoji2.text.g(lVar2, iVar, dVar, dVar2.f2795h, dVar2.f2796i);
            this.f2804a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final d f2804a;

        b(d dVar) {
            this.f2804a = dVar;
        }

        void a() {
            this.f2804a.n();
        }

        CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return charSequence;
        }

        void c(EditorInfo editorInfo) {
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final g f2805a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2806b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2807c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2808d;

        /* renamed from: e  reason: collision with root package name */
        Set<e> f2809e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2810f;

        /* renamed from: g  reason: collision with root package name */
        int f2811g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        int f2812h = 0;

        /* renamed from: i  reason: collision with root package name */
        AbstractC0028d f2813i = new g.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public c(g gVar) {
            j0.h.h(gVar, "metadataLoader cannot be null.");
            this.f2805a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final g a() {
            return this.f2805a;
        }

        public c b(int i10) {
            this.f2812h = i10;
            return this;
        }
    }

    /* compiled from: EmojiCompat.java */
    /* renamed from: androidx.emoji2.text.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0028d {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        public void a(Throwable th2) {
        }

        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<e> f2814a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f2815b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2816c;

        f(e eVar, int i10) {
            this(Arrays.asList((e) j0.h.h(eVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2814a.size();
            int i10 = 0;
            if (this.f2816c != 1) {
                while (i10 < size) {
                    this.f2814a.get(i10).a(this.f2815b);
                    i10++;
                }
                return;
            }
            while (i10 < size) {
                this.f2814a.get(i10).b();
                i10++;
            }
        }

        f(Collection<e> collection, int i10) {
            this(collection, i10, null);
        }

        f(Collection<e> collection, int i10, Throwable th2) {
            j0.h.h(collection, "initCallbacks cannot be null");
            this.f2814a = new ArrayList(collection);
            this.f2816c = i10;
            this.f2815b = th2;
        }
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(h hVar);
    }

    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a(Throwable th2);

        public abstract void b(l lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmojiCompat.java */
    /* loaded from: classes.dex */
    public static class i {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public androidx.emoji2.text.h a(androidx.emoji2.text.f fVar) {
            return new n(fVar);
        }
    }

    private d(c cVar) {
        this.f2794g = cVar.f2806b;
        this.f2795h = cVar.f2807c;
        this.f2796i = cVar.f2808d;
        this.f2797j = cVar.f2810f;
        this.f2798k = cVar.f2811g;
        this.f2793f = cVar.f2805a;
        this.f2799l = cVar.f2812h;
        this.f2800m = cVar.f2813i;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f2789b = bVar;
        Set<e> set = cVar.f2809e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f2809e);
        }
        this.f2792e = Build.VERSION.SDK_INT < 19 ? new b(this) : new a(this);
        l();
    }

    public static d b() {
        d dVar;
        synchronized (f2786n) {
            dVar = f2787o;
            j0.h.i(dVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return dVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        if (Build.VERSION.SDK_INT >= 19) {
            return androidx.emoji2.text.g.c(inputConnection, editable, i10, i11, z10);
        }
        return false;
    }

    public static boolean f(Editable editable, int i10, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return androidx.emoji2.text.g.d(editable, i10, keyEvent);
        }
        return false;
    }

    public static d g(c cVar) {
        d dVar = f2787o;
        if (dVar == null) {
            synchronized (f2786n) {
                dVar = f2787o;
                if (dVar == null) {
                    dVar = new d(cVar);
                    f2787o = dVar;
                }
            }
        }
        return dVar;
    }

    public static boolean h() {
        return f2787o != null;
    }

    private boolean j() {
        return d() == 1;
    }

    /* JADX WARN: Finally extract failed */
    private void l() {
        this.f2788a.writeLock().lock();
        try {
            if (this.f2799l == 0) {
                this.f2790c = 0;
            }
            this.f2788a.writeLock().unlock();
            if (d() == 0) {
                this.f2792e.a();
            }
        } catch (Throwable th2) {
            this.f2788a.writeLock().unlock();
            throw th2;
        }
    }

    public int c() {
        return this.f2798k;
    }

    public int d() {
        this.f2788a.readLock().lock();
        try {
            return this.f2790c;
        } finally {
            this.f2788a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f2797j;
    }

    public void k() {
        boolean z10 = true;
        if (this.f2799l != 1) {
            z10 = false;
        }
        j0.h.i(z10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!j()) {
            this.f2788a.writeLock().lock();
            try {
                if (this.f2790c != 0) {
                    this.f2790c = 0;
                    this.f2788a.writeLock().unlock();
                    this.f2792e.a();
                }
            } finally {
                this.f2788a.writeLock().unlock();
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    void m(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f2788a.writeLock().lock();
        try {
            this.f2790c = 2;
            arrayList.addAll(this.f2789b);
            this.f2789b.clear();
            this.f2788a.writeLock().unlock();
            this.f2791d.post(new f(arrayList, this.f2790c, th2));
        } catch (Throwable th3) {
            this.f2788a.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX WARN: Finally extract failed */
    void n() {
        ArrayList arrayList = new ArrayList();
        this.f2788a.writeLock().lock();
        try {
            this.f2790c = 1;
            arrayList.addAll(this.f2789b);
            this.f2789b.clear();
            this.f2788a.writeLock().unlock();
            this.f2791d.post(new f(arrayList, this.f2790c));
        } catch (Throwable th2) {
            this.f2788a.writeLock().unlock();
            throw th2;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i10, int i11) {
        return q(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11, int i12) {
        return r(charSequence, i10, i11, i12, 0);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        j0.h.i(j(), "Not initialized yet");
        j0.h.e(i10, "start cannot be negative");
        j0.h.e(i11, "end cannot be negative");
        j0.h.e(i12, "maxEmojiCount cannot be negative");
        boolean z11 = false;
        j0.h.b(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        j0.h.b(i10 <= charSequence.length(), "start should be < than charSequence length");
        j0.h.b(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            if (i13 != 2) {
                z11 = this.f2794g;
            }
            z10 = z11;
        } else {
            z10 = true;
        }
        return this.f2792e.b(charSequence, i10, i11, i12, z10);
    }

    public void s(e eVar) {
        j0.h.h(eVar, "initCallback cannot be null");
        this.f2788a.writeLock().lock();
        try {
            if (!(this.f2790c == 1 || this.f2790c == 2)) {
                this.f2789b.add(eVar);
            }
            this.f2791d.post(new f(eVar, this.f2790c));
        } finally {
            this.f2788a.writeLock().unlock();
        }
    }

    public void t(e eVar) {
        j0.h.h(eVar, "initCallback cannot be null");
        this.f2788a.writeLock().lock();
        try {
            this.f2789b.remove(eVar);
        } finally {
            this.f2788a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f2792e.c(editorInfo);
        }
    }
}
