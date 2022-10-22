package rp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.collections.b;
import kotlin.collections.m;
import kotlin.collections.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okio.ByteString;
import okio.c;
/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final class d extends b<ByteString> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final a f33653d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final ByteString[] f33654b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f33655c;

    /* compiled from: Options.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        private final void a(long j10, c cVar, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) {
            int i13;
            int i14;
            int i15;
            int i16;
            c cVar2;
            int i17 = i10;
            if (i11 < i12) {
                for (int i18 = i11; i18 < i12; i18++) {
                    if (!(list.get(i18).size() >= i17)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i11);
                ByteString byteString2 = list.get(i12 - 1);
                int i19 = -1;
                if (i17 == byteString.size()) {
                    i14 = list2.get(i11).intValue();
                    int i20 = i11 + 1;
                    byteString = list.get(i20);
                    i13 = i20;
                } else {
                    i13 = i11;
                    i14 = -1;
                }
                if (byteString.getByte(i17) != byteString2.getByte(i17)) {
                    int i21 = 1;
                    for (int i22 = i13 + 1; i22 < i12; i22++) {
                        if (list.get(i22 - 1).getByte(i17) != list.get(i22).getByte(i17)) {
                            i21++;
                        }
                    }
                    long c10 = j10 + c(cVar) + 2 + (i21 * 2);
                    cVar.t(i21);
                    cVar.t(i14);
                    for (int i23 = i13; i23 < i12; i23++) {
                        byte b10 = list.get(i23).getByte(i17);
                        if (i23 == i13 || b10 != list.get(i23 - 1).getByte(i17)) {
                            cVar.t(b10 & 255);
                        }
                    }
                    c cVar3 = new c();
                    while (i13 < i12) {
                        byte b11 = list.get(i13).getByte(i17);
                        int i24 = i13 + 1;
                        int i25 = i24;
                        while (true) {
                            if (i25 >= i12) {
                                i15 = i12;
                                break;
                            } else if (b11 != list.get(i25).getByte(i17)) {
                                i15 = i25;
                                break;
                            } else {
                                i25++;
                            }
                        }
                        if (i24 == i15 && i17 + 1 == list.get(i13).size()) {
                            cVar.t(list2.get(i13).intValue());
                            i16 = i15;
                            cVar2 = cVar3;
                        } else {
                            cVar.t(((int) (c10 + c(cVar3))) * i19);
                            i16 = i15;
                            cVar2 = cVar3;
                            a(c10, cVar3, i17 + 1, list, i13, i15, list2);
                        }
                        cVar3 = cVar2;
                        i13 = i16;
                        i19 = -1;
                    }
                    cVar.b0(cVar3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i26 = 0;
                for (int i27 = i17; i27 < min && byteString.getByte(i27) == byteString2.getByte(i27); i27++) {
                    i26++;
                }
                long c11 = j10 + c(cVar) + 2 + i26 + 1;
                cVar.t(-i26);
                cVar.t(i14);
                int i28 = i17 + i26;
                while (i17 < i28) {
                    cVar.t(byteString.getByte(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i12) {
                    if (i28 == list.get(i13).size()) {
                        cVar.t(list2.get(i13).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                c cVar4 = new c();
                cVar.t(((int) (c(cVar4) + c11)) * (-1));
                a(c11, cVar4, i28, list, i13, i12, list2);
                cVar.b0(cVar4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(a aVar, long j10, c cVar, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            aVar.a((i13 & 1) != 0 ? 0L : j10, cVar, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        private final long c(c cVar) {
            return cVar.i0() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final d d(ByteString... byteStrings) {
            List E;
            List l10;
            int f10;
            i.f(byteStrings, "byteStrings");
            int i10 = 0;
            if (byteStrings.length == 0) {
                return new d(new ByteString[0], new int[]{0, -1}, null);
            }
            E = kotlin.collections.i.E(byteStrings);
            q.q(E);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Integer[] numArr = (Integer[]) array;
            l10 = m.l((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int i11 = 0;
            for (ByteString byteString2 : byteStrings) {
                i11++;
                f10 = m.f(E, byteString2, 0, 0, 6, null);
                l10.set(f10, Integer.valueOf(i11));
            }
            if (((ByteString) E.get(0)).size() > 0) {
                int i12 = 0;
                while (i12 < E.size()) {
                    ByteString byteString3 = (ByteString) E.get(i12);
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (i14 < E.size()) {
                        ByteString byteString4 = (ByteString) E.get(i14);
                        if (!byteString4.startsWith(byteString3)) {
                            break;
                        }
                        if (!(byteString4.size() != byteString3.size())) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString4).toString());
                        } else if (((Number) l10.get(i14)).intValue() > ((Number) l10.get(i12)).intValue()) {
                            E.remove(i14);
                            l10.remove(i14);
                        } else {
                            i14++;
                        }
                    }
                    i12 = i13;
                }
                c cVar = new c();
                b(this, 0L, cVar, 0, E, 0, 0, l10, 53, null);
                int[] iArr = new int[(int) c(cVar)];
                while (!cVar.B()) {
                    i10++;
                    iArr[i10] = cVar.readInt();
                }
                Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
                i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                return new d((ByteString[]) copyOf, iArr, null);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public /* synthetic */ d(ByteString[] byteStringArr, int[] iArr, f fVar) {
        this(byteStringArr, iArr);
    }

    public static final d i(ByteString... byteStringArr) {
        return f33653d.d(byteStringArr);
    }

    @Override // kotlin.collections.a
    public int a() {
        return this.f33654b.length;
    }

    public /* bridge */ boolean b(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return b((ByteString) obj);
        }
        return false;
    }

    /* renamed from: d */
    public ByteString get(int i10) {
        return this.f33654b[i10];
    }

    public final ByteString[] e() {
        return this.f33654b;
    }

    public final int[] f() {
        return this.f33655c;
    }

    public /* bridge */ int g(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int h(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return g((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return h((ByteString) obj);
        }
        return -1;
    }

    private d(ByteString[] byteStringArr, int[] iArr) {
        this.f33654b = byteStringArr;
        this.f33655c = iArr;
    }
}
