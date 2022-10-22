package androidx.room;

import i1.c;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* loaded from: classes.dex */
public class k0 implements c.AbstractC0307c {

    /* renamed from: a  reason: collision with root package name */
    private final String f4268a;

    /* renamed from: b  reason: collision with root package name */
    private final File f4269b;

    /* renamed from: c  reason: collision with root package name */
    private final Callable<InputStream> f4270c;

    /* renamed from: d  reason: collision with root package name */
    private final c.AbstractC0307c f4271d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(String str, File file, Callable<InputStream> callable, c.AbstractC0307c cVar) {
        this.f4268a = str;
        this.f4269b = file;
        this.f4270c = callable;
        this.f4271d = cVar;
    }

    @Override // i1.c.AbstractC0307c
    public c a(c.b bVar) {
        return new j0(bVar.f28014a, this.f4268a, this.f4269b, this.f4270c, bVar.f28016c.f28013a, this.f4271d.a(bVar));
    }
}
