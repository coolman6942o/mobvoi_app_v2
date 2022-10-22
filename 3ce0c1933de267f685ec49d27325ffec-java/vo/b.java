package vo;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* compiled from: ProgressionIterators.kt */
/* loaded from: classes3.dex */
public final class b extends y {

    /* renamed from: a  reason: collision with root package name */
    private final int f35845a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35846b;

    /* renamed from: c  reason: collision with root package name */
    private int f35847c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35848d;

    public b(int i10, int i11, int i12) {
        this.f35848d = i12;
        this.f35845a = i11;
        boolean z10 = true;
        z10 = false;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
        }
        this.f35846b = z10;
        this.f35847c = !z10 ? i11 : i10;
    }

    @Override // kotlin.collections.y
    public int b() {
        int i10 = this.f35847c;
        if (i10 != this.f35845a) {
            this.f35847c = this.f35848d + i10;
        } else if (this.f35846b) {
            this.f35846b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35846b;
    }
}
