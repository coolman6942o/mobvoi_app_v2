package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.j0;
import androidx.lifecycle.p;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.loader.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0034a<D> {
        void V(c<D> cVar);

        void o(c<D> cVar, D d10);

        c<D> r(int i10, Bundle bundle);
    }

    public static <T extends p & j0> a b(T t10) {
        return new b(t10, t10.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> c<D> c(int i10, Bundle bundle, AbstractC0034a<D> aVar);

    public abstract void d();
}
