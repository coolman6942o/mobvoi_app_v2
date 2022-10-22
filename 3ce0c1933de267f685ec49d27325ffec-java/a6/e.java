package a6;

import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    private boolean f108b = false;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Integer> f109c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void e() {
        synchronized (this) {
            if (!this.f108b) {
                int count = this.f102a.getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f109c = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String c10 = c();
                    String K0 = this.f102a.K0(c10, 0, this.f102a.L0(0));
                    for (int i10 = 1; i10 < count; i10++) {
                        int L0 = this.f102a.L0(i10);
                        String K02 = this.f102a.K0(c10, i10, L0);
                        if (K02 != null) {
                            if (!K02.equals(K0)) {
                                this.f109c.add(Integer.valueOf(i10));
                                K0 = K02;
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 78);
                            sb2.append("Missing value for markerColumn: ");
                            sb2.append(c10);
                            sb2.append(", at row: ");
                            sb2.append(i10);
                            sb2.append(", for window: ");
                            sb2.append(L0);
                            throw new NullPointerException(sb2.toString());
                        }
                    }
                }
                this.f108b = true;
            }
        }
    }

    private final int f(int i10) {
        if (i10 >= 0 && i10 < this.f109c.size()) {
            return this.f109c.get(i10).intValue();
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("Position ");
        sb2.append(i10);
        sb2.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb2.toString());
    }

    protected String a() {
        return null;
    }

    protected abstract T b(int i10, int i11);

    protected abstract String c();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (r6.f102a.K0(r4, r7, r3) == null) goto L17;
     */
    @Override // a6.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T get(int i10) {
        int i11;
        int i12;
        e();
        int f10 = f(i10);
        int i13 = 0;
        if (i10 >= 0 && i10 != this.f109c.size()) {
            if (i10 == this.f109c.size() - 1) {
                i12 = this.f102a.getCount();
                i11 = this.f109c.get(i10).intValue();
            } else {
                i12 = this.f109c.get(i10 + 1).intValue();
                i11 = this.f109c.get(i10).intValue();
            }
            int i14 = i12 - i11;
            if (i14 == 1) {
                int f11 = f(i10);
                int L0 = this.f102a.L0(f11);
                String a10 = a();
                if (a10 != null) {
                }
            }
            i13 = i14;
        }
        return b(f10, i13);
    }

    @Override // a6.b
    public int getCount() {
        e();
        return this.f109c.size();
    }
}
