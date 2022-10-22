package q4;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class c<T> implements g<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Collection<? extends g<T>> f32923b;

    @SafeVarargs
    public c(Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.f32923b = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // q4.g
    public t4.c<T> a(Context context, t4.c<T> cVar, int i10, int i11) {
        t4.c<T> cVar2 = cVar;
        for (g<T> gVar : this.f32923b) {
            t4.c<T> a10 = gVar.a(context, cVar2, i10, i11);
            if (cVar2 != null && !cVar2.equals(cVar) && !cVar2.equals(a10)) {
                cVar2.b();
            }
            cVar2 = a10;
        }
        return cVar2;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        for (g<T> gVar : this.f32923b) {
            gVar.b(messageDigest);
        }
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f32923b.equals(((c) obj).f32923b);
        }
        return false;
    }

    @Override // q4.b
    public int hashCode() {
        return this.f32923b.hashCode();
    }
}
