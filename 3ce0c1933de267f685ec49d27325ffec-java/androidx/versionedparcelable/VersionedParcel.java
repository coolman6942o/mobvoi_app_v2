package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    protected final a<String, Method> f4537a;

    /* renamed from: b  reason: collision with root package name */
    protected final a<String, Method> f4538b;

    /* renamed from: c  reason: collision with root package name */
    protected final a<String, Class> f4539c;

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        this.f4537a = aVar;
        this.f4538b = aVar2;
        this.f4539c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(o1.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    private Class c(Class<? extends o1.a> cls) throws ClassNotFoundException {
        Class cls2 = this.f4539c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f4539c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4537a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f4537a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f4538b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c10 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c10.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f4538b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i10) {
        w(i10);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i10) {
        w(i10);
        C(charSequence);
    }

    protected abstract void E(int i10);

    public void F(int i10, int i11) {
        w(i11);
        E(i10);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i10) {
        w(i10);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i10) {
        w(i10);
        I(str);
    }

    protected <T extends o1.a> void K(T t10, VersionedParcel versionedParcel) {
        try {
            e(t10.getClass()).invoke(null, t10, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(o1.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        VersionedParcel b10 = b();
        K(aVar, b10);
        b10.a();
    }

    public void M(o1.a aVar, int i10) {
        w(i10);
        L(aVar);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z10, int i10) {
        return !m(i10) ? z10 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i10) {
        return !m(i10) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i10) {
        return !m(i10) ? charSequence : k();
    }

    protected abstract boolean m(int i10);

    protected <T extends o1.a> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (T) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    protected abstract int o();

    public int p(int i10, int i11) {
        return !m(i11) ? i10 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t10, int i10) {
        return !m(i10) ? t10 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i10) {
        return !m(i10) ? str : s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends o1.a> T u() {
        String s10 = s();
        if (s10 == null) {
            return null;
        }
        return (T) n(s10, b());
    }

    public <T extends o1.a> T v(T t10, int i10) {
        return !m(i10) ? t10 : (T) u();
    }

    protected abstract void w(int i10);

    public void x(boolean z10, boolean z11) {
    }

    protected abstract void y(boolean z10);

    public void z(boolean z10, int i10) {
        w(i10);
        y(z10);
    }
}
