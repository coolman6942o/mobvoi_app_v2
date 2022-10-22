package u4;
/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class i implements a<int[]> {
    @Override // u4.a
    public int a() {
        return 4;
    }

    @Override // u4.a
    public String b() {
        return "IntegerArrayPool";
    }

    /* renamed from: d */
    public int c(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: e */
    public int[] newArray(int i10) {
        return new int[i10];
    }
}
