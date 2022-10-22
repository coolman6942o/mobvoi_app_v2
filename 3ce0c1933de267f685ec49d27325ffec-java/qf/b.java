package qf;

import java.lang.Enum;
import xf.c;
/* compiled from: DataRangeSync.java */
/* loaded from: classes2.dex */
public class b<Type extends Enum<Type> & c> {

    /* renamed from: a  reason: collision with root package name */
    public String f33125a;

    /* renamed from: b  reason: collision with root package name */
    public String f33126b;

    /* renamed from: c  reason: collision with root package name */
    public int f33127c;

    /* renamed from: d  reason: collision with root package name */
    public long f33128d;

    /* renamed from: e  reason: collision with root package name */
    public long f33129e;

    /* renamed from: f  reason: collision with root package name */
    public int f33130f;

    /* renamed from: g  reason: collision with root package name */
    public int f33131g;

    /* renamed from: h  reason: collision with root package name */
    private Class<Type> f33132h;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Class<Type> cls) {
        this.f33125a = "";
        this.f33126b = "";
        this.f33127c = -1;
        this.f33130f = 0;
        this.f33131g = 0;
        this.f33132h = cls;
    }

    public boolean a() {
        return this.f33130f == 1;
    }

    public void b() {
        if (this.f33126b == null) {
            this.f33126b = "";
        }
        if (this.f33125a == null) {
            this.f33125a = "";
        }
    }

    /* JADX WARN: Incorrect return type in method signature: ()TType; */
    public Enum c() {
        Class<Type> cls = this.f33132h;
        if (cls == null) {
            return null;
        }
        return xf.b.b(cls, this.f33127c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TType;JJ)V */
    public b(Enum r32, long j10, long j11) {
        this.f33125a = "";
        this.f33126b = "";
        int i10 = -1;
        this.f33127c = -1;
        this.f33130f = 0;
        this.f33131g = 0;
        this.f33127c = r32 != null ? ((c) r32).getTypeCode() : i10;
        this.f33132h = r32 == null ? null : r32.getDeclaringClass();
        this.f33129e = j10;
        this.f33128d = j11;
    }
}
