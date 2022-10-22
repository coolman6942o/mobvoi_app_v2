package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.Fragment;
import b5.a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.q;
import g5.d;
import g5.l;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r4.k;
import u4.b;
import u4.e;
import v4.h;
import x4.a;
import x4.b;
import x4.d;
import x4.e;
import x4.f;
import x4.g;
import x4.k;
import x4.s;
import x4.t;
import x4.u;
import x4.v;
import x4.w;
import x4.x;
import y4.a;
import y4.b;
import y4.c;
import y4.d;
import y4.e;
/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: i  reason: collision with root package name */
    private static volatile c f7802i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f7803j;

    /* renamed from: a  reason: collision with root package name */
    private final e f7804a;

    /* renamed from: b  reason: collision with root package name */
    private final h f7805b;

    /* renamed from: c  reason: collision with root package name */
    private final e f7806c;

    /* renamed from: d  reason: collision with root package name */
    private final Registry f7807d;

    /* renamed from: e  reason: collision with root package name */
    private final b f7808e;

    /* renamed from: f  reason: collision with root package name */
    private final l f7809f;

    /* renamed from: g  reason: collision with root package name */
    private final d f7810g;

    /* renamed from: h  reason: collision with root package name */
    private final List<h> f7811h = new ArrayList();

    /* compiled from: Glide.java */
    /* loaded from: classes.dex */
    public interface a {
        j5.c build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, j jVar, h hVar, e eVar, b bVar, l lVar, d dVar, int i10, a aVar, Map<Class<?>, i<?, ?>> map, List<j5.b<Object>> list, boolean z10, boolean z11, int i11, int i12) {
        com.bumptech.glide.load.b bVar2;
        com.bumptech.glide.load.b bVar3;
        MemoryCategory memoryCategory = MemoryCategory.NORMAL;
        this.f7804a = eVar;
        this.f7808e = bVar;
        this.f7805b = hVar;
        this.f7809f = lVar;
        this.f7810g = dVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f7807d = registry;
        registry.o(new com.bumptech.glide.load.resource.bitmap.e());
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 27) {
            registry.o(new i());
        }
        List<ImageHeaderParser> g10 = registry.g();
        e5.a aVar2 = new e5.a(context, g10, eVar, bVar);
        com.bumptech.glide.load.b<ParcelFileDescriptor, Bitmap> g11 = q.g(eVar);
        if (!z11 || i13 < 28) {
            f fVar = new f(registry.g(), resources.getDisplayMetrics(), eVar, bVar);
            bVar2 = new com.bumptech.glide.load.resource.bitmap.c(fVar);
            bVar3 = new n(fVar, bVar);
        } else {
            bVar3 = new k();
            bVar2 = new com.bumptech.glide.load.resource.bitmap.d();
        }
        c5.d dVar2 = new c5.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar4 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        a5.b bVar5 = new a5.b(bVar);
        f5.a aVar4 = new f5.a();
        f5.d dVar4 = new f5.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry q5 = registry.c(ByteBuffer.class, new x4.c()).c(InputStream.class, new t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, bVar2).e("Bitmap", InputStream.class, Bitmap.class, bVar3).e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, g11).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, q.c(eVar)).b(Bitmap.class, Bitmap.class, v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new p()).d(Bitmap.class, bVar5).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, bVar2)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, bVar3)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, g11)).d(BitmapDrawable.class, new a5.a(eVar, bVar5)).e("Gif", InputStream.class, e5.c.class, new e5.j(g10, aVar2, bVar)).e("Gif", ByteBuffer.class, e5.c.class, aVar2).d(e5.c.class, new e5.d()).b(p4.a.class, p4.a.class, v.a.a()).e("Bitmap", p4.a.class, Bitmap.class, new e5.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new m(dVar2, eVar)).q(new a.C0070a()).b(File.class, ByteBuffer.class, new d.b()).b(File.class, InputStream.class, new f.e()).a(File.class, File.class, new d5.a()).b(File.class, ParcelFileDescriptor.class, new f.b()).b(File.class, File.class, v.a.a()).q(new k.a(bVar));
        Class cls = Integer.TYPE;
        q5.b(cls, InputStream.class, cVar).b(cls, ParcelFileDescriptor.class, bVar4).b(Integer.class, InputStream.class, cVar).b(Integer.class, ParcelFileDescriptor.class, bVar4).b(Integer.class, Uri.class, dVar3).b(cls, AssetFileDescriptor.class, aVar3).b(Integer.class, AssetFileDescriptor.class, aVar3).b(cls, Uri.class, dVar3).b(String.class, InputStream.class, new e.c()).b(Uri.class, InputStream.class, new e.c()).b(String.class, InputStream.class, new u.c()).b(String.class, ParcelFileDescriptor.class, new u.b()).b(String.class, AssetFileDescriptor.class, new u.a()).b(Uri.class, InputStream.class, new b.a()).b(Uri.class, InputStream.class, new a.c(context.getAssets())).b(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).b(Uri.class, InputStream.class, new c.a(context)).b(Uri.class, InputStream.class, new d.a(context)).b(Uri.class, InputStream.class, new w.d(contentResolver)).b(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).b(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).b(Uri.class, InputStream.class, new x.a()).b(URL.class, InputStream.class, new e.a()).b(Uri.class, File.class, new k.a(context)).b(g.class, InputStream.class, new a.C0537a()).b(byte[].class, ByteBuffer.class, new b.a()).b(byte[].class, InputStream.class, new b.d()).b(Uri.class, Uri.class, v.a.a()).b(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new c5.e()).p(Bitmap.class, BitmapDrawable.class, new f5.b(resources)).p(Bitmap.class, byte[].class, aVar4).p(Drawable.class, byte[].class, new f5.c(eVar, aVar4, dVar4)).p(e5.c.class, byte[].class, dVar4);
        this.f7806c = new e(context, bVar, registry, new k5.g(), aVar, map, list, jVar, z10, i10);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f7803j) {
            f7803j = true;
            m(context, generatedAppGlideModule);
            f7803j = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static c c(Context context) {
        if (f7802i == null) {
            GeneratedAppGlideModule d10 = d(context.getApplicationContext());
            synchronized (c.class) {
                if (f7802i == null) {
                    a(context, d10);
                }
            }
        }
        return f7802i;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            q(e10);
            return null;
        } catch (InstantiationException e11) {
            q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            q(e13);
            return null;
        }
    }

    private static l l(Context context) {
        n5.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new d(), generatedAppGlideModule);
    }

    private static void n(Context context, d dVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<h5.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new h5.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d10 = generatedAppGlideModule.d();
            Iterator<h5.b> it = emptyList.iterator();
            while (it.hasNext()) {
                h5.b next = it.next();
                if (d10.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<h5.b> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (h5.b bVar : emptyList) {
            bVar.a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, dVar);
        }
        c a10 = dVar.a(applicationContext);
        for (h5.b bVar2 : emptyList) {
            try {
                bVar2.b(applicationContext, a10, a10.f7807d);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar2.getClass().getName(), e10);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a10, a10.f7807d);
        }
        applicationContext.registerComponentCallbacks(a10);
        f7802i = a10;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static h t(Activity activity) {
        return l(activity).d(activity);
    }

    public static h u(Context context) {
        return l(context).e(context);
    }

    public static h v(Fragment fragment) {
        return l(fragment.getContext()).f(fragment);
    }

    public static h w(androidx.fragment.app.f fVar) {
        return l(fVar).g(fVar);
    }

    public void b() {
        n5.k.a();
        this.f7805b.b();
        this.f7804a.b();
        this.f7808e.b();
    }

    public u4.b e() {
        return this.f7808e;
    }

    public u4.e f() {
        return this.f7804a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g5.d g() {
        return this.f7810g;
    }

    public Context h() {
        return this.f7806c.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e i() {
        return this.f7806c;
    }

    public Registry j() {
        return this.f7807d;
    }

    public l k() {
        return this.f7809f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(h hVar) {
        synchronized (this.f7811h) {
            if (!this.f7811h.contains(hVar)) {
                this.f7811h.add(hVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        r(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(k5.i<?> iVar) {
        synchronized (this.f7811h) {
            for (h hVar : this.f7811h) {
                if (hVar.z(iVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i10) {
        n5.k.a();
        for (h hVar : this.f7811h) {
            hVar.onTrimMemory(i10);
        }
        this.f7805b.a(i10);
        this.f7804a.a(i10);
        this.f7808e.a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(h hVar) {
        synchronized (this.f7811h) {
            if (this.f7811h.contains(hVar)) {
                this.f7811h.remove(hVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
