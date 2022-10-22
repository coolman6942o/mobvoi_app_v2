package androidx.work;
/* compiled from: InputMergerFactory.java */
/* loaded from: classes.dex */
public abstract class i {

    /* compiled from: InputMergerFactory.java */
    /* loaded from: classes.dex */
    class a extends i {
        a() {
        }

        @Override // androidx.work.i
        public h a(String str) {
            return null;
        }
    }

    public static i c() {
        return new a();
    }

    public abstract h a(String str);

    public final h b(String str) {
        h a10 = a(str);
        return a10 == null ? h.a(str) : a10;
    }
}
