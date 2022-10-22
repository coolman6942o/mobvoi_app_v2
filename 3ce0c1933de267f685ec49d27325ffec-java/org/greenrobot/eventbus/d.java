package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.f;
import org.greenrobot.eventbus.g;
import up.b;
/* compiled from: EventBusBuilder.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: m  reason: collision with root package name */
    private static final ExecutorService f32465m = Executors.newCachedThreadPool();

    /* renamed from: e  reason: collision with root package name */
    boolean f32470e;

    /* renamed from: g  reason: collision with root package name */
    boolean f32472g;

    /* renamed from: h  reason: collision with root package name */
    boolean f32473h;

    /* renamed from: j  reason: collision with root package name */
    List<b> f32475j;

    /* renamed from: k  reason: collision with root package name */
    f f32476k;

    /* renamed from: l  reason: collision with root package name */
    g f32477l;

    /* renamed from: a  reason: collision with root package name */
    boolean f32466a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f32467b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f32468c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f32469d = true;

    /* renamed from: f  reason: collision with root package name */
    boolean f32471f = true;

    /* renamed from: i  reason: collision with root package name */
    ExecutorService f32474i = f32465m;

    Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b() {
        f fVar = this.f32476k;
        return fVar != null ? fVar : (!f.a.c() || a() == null) ? new f.b() : new f.a("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g c() {
        Object a10;
        g gVar = this.f32477l;
        if (gVar != null) {
            return gVar;
        }
        if (!f.a.c() || (a10 = a()) == null) {
            return null;
        }
        return new g.a((Looper) a10);
    }
}
