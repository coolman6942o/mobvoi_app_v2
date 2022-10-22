package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import wo.b;
import wo.d;
import wo.n;
/* loaded from: classes3.dex */
public abstract class CallableReference implements b, Serializable {
    public static final Object NO_RECEIVER = a.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient b reflected;
    private final String signature;

    /* loaded from: classes3.dex */
    private static class a implements Serializable {
        private static final a INSTANCE = new a();

        private a() {
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    protected abstract b b();

    /* JADX INFO: Access modifiers changed from: protected */
    public b c() {
        b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // wo.b
    public Object call(Object... objArr) {
        return c().call(objArr);
    }

    @Override // wo.b
    public Object callBy(Map map) {
        return c().callBy(map);
    }

    public b compute() {
        b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        b b10 = b();
        this.reflected = b10;
        return b10;
    }

    @Override // wo.a
    public List<Annotation> getAnnotations() {
        return c().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? l.c(cls) : l.b(cls);
    }

    @Override // wo.b
    public List<Object> getParameters() {
        return c().getParameters();
    }

    @Override // wo.b
    public n getReturnType() {
        return c().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // wo.b
    public List<Object> getTypeParameters() {
        return c().getTypeParameters();
    }

    @Override // wo.b
    public KVisibility getVisibility() {
        return c().getVisibility();
    }

    @Override // wo.b
    public boolean isAbstract() {
        return c().isAbstract();
    }

    @Override // wo.b
    public boolean isFinal() {
        return c().isFinal();
    }

    @Override // wo.b
    public boolean isOpen() {
        return c().isOpen();
    }

    @Override // wo.b
    public boolean isSuspend() {
        return c().isSuspend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }
}
