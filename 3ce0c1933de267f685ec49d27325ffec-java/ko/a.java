package ko;

import io.m;
import kotlin.jvm.internal.i;
/* compiled from: Thread.kt */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: Thread.kt */
    /* renamed from: ko.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0369a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ qo.a f30047a;

        C0369a(qo.a aVar) {
            this.f30047a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f30047a.invoke();
        }
    }

    public static final Thread a(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, qo.a<m> block) {
        i.f(block, "block");
        C0369a aVar = new C0369a(block);
        if (z11) {
            aVar.setDaemon(true);
        }
        if (i10 > 0) {
            aVar.setPriority(i10);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z10) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread b(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, qo.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        ClassLoader classLoader2 = (i11 & 4) != 0 ? null : classLoader;
        String str2 = (i11 & 8) != 0 ? null : str;
        if ((i11 & 16) != 0) {
            i10 = -1;
        }
        return a(z12, z13, classLoader2, str2, i10, aVar);
    }
}
