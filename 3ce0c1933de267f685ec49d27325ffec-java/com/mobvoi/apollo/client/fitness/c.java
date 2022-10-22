package com.mobvoi.apollo.client.fitness;

import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.DataSession;
import com.mobvoi.apollo.protocol.model.DataSet;
import com.mobvoi.apollo.protocol.model.FitnessRecord;
import io.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.i;
import oa.b;
/* compiled from: FitnessParser.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private int f15484b;

    /* renamed from: c  reason: collision with root package name */
    private int f15485c;

    /* renamed from: d  reason: collision with root package name */
    private int f15486d;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<byte[]> f15488f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f15489g;

    /* renamed from: h  reason: collision with root package name */
    private int f15490h;

    /* renamed from: i  reason: collision with root package name */
    private int f15491i;

    /* renamed from: j  reason: collision with root package name */
    private b f15492j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f15493k;

    /* renamed from: a  reason: collision with root package name */
    private byte f15483a = 1;

    /* renamed from: e  reason: collision with root package name */
    private int f15487e = 1;

    private final void a() {
        if (this.f15490h == this.f15486d || this.f15491i % this.f15487e == 0) {
            ByteBuffer order = ByteBuffer.allocate(5).order(ByteOrder.LITTLE_ENDIAN);
            order.putShort((short) this.f15485c).putShort((short) this.f15490h).put(this.f15483a);
            q.L(q.f15504a, 531, order.array(), null, 4, null);
        }
    }

    private final void b(byte[] bArr) {
        if (this.f15493k) {
            this.f15491i = b.f31485a.b(bArr, 0);
            int length = bArr.length - 2;
            byte[] bArr2 = this.f15489g;
            if (bArr2 != null) {
                System.arraycopy(bArr, 2, bArr2, this.f15490h, length);
                this.f15490h += length;
                a();
                return;
            }
            i.u("sliceData");
            throw null;
        }
    }

    private final void c() {
        int i10;
        int p10;
        int p11;
        int e10 = e();
        if (this.f15484b > 1) {
            ArrayList<byte[]> arrayList = this.f15488f;
            if (arrayList != null) {
                p11 = n.p(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(p11);
                for (byte[] bArr : arrayList) {
                    arrayList2.add(Integer.valueOf(bArr.length));
                }
                Iterator it = arrayList2.iterator();
                if (it.hasNext()) {
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = Integer.valueOf(((Number) next).intValue() + ((Number) it.next()).intValue());
                    }
                    i10 = ((Number) next).intValue() - ((this.f15484b - 1) * e10);
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            } else {
                i.u("sliceList");
                throw null;
            }
        } else {
            ArrayList<byte[]> arrayList3 = this.f15488f;
            if (arrayList3 != null) {
                i10 = arrayList3.get(0).length;
            } else {
                i.u("sliceList");
                throw null;
            }
        }
        ByteBuffer buffer = ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        if (this.f15483a == 1) {
            ArrayList<byte[]> arrayList4 = this.f15488f;
            if (arrayList4 != null) {
                buffer.put(arrayList4.get(0), 0, e10);
            } else {
                i.u("sliceList");
                throw null;
            }
        } else {
            ArrayList<byte[]> arrayList5 = this.f15488f;
            if (arrayList5 != null) {
                p10 = n.p(arrayList5, 10);
                ArrayList arrayList6 = new ArrayList(p10);
                for (byte[] bArr2 : arrayList5) {
                    arrayList6.add(Integer.valueOf(b.f31485a.b(bArr2, 0)));
                }
                Iterator it2 = arrayList6.iterator();
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    while (it2.hasNext()) {
                        next2 = Integer.valueOf(((Number) next2).intValue() + ((Number) it2.next()).intValue());
                    }
                    buffer.putShort((short) ((Number) next2).intValue());
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            } else {
                i.u("sliceList");
                throw null;
            }
        }
        ArrayList<byte[]> arrayList7 = this.f15488f;
        if (arrayList7 != null) {
            for (byte[] bArr3 : arrayList7) {
                buffer.put(bArr3, e10, bArr3.length - e10);
            }
            buffer.flip();
            byte b10 = this.f15483a;
            if (b10 == 1) {
                i.e(buffer, "buffer");
                FitnessRecord c10 = a.c(buffer);
                b bVar = this.f15492j;
                if (bVar != null) {
                    bVar.a(c10);
                }
            } else if (b10 == 2) {
                i.e(buffer, "buffer");
                List<DataSet> b11 = a.b(buffer);
                b bVar2 = this.f15492j;
                if (bVar2 != null) {
                    bVar2.d(b11);
                }
            } else if (b10 == 3) {
                i.e(buffer, "buffer");
                List<DataSession> a10 = a.a(buffer);
                b bVar3 = this.f15492j;
                if (bVar3 != null) {
                    bVar3.c(a10);
                }
            }
        } else {
            i.u("sliceList");
            throw null;
        }
    }

    private final void d(byte[] bArr) {
        b bVar = this.f15492j;
        if (bVar != null && bVar.b()) {
            this.f15493k = true;
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            this.f15483a = order.get();
            this.f15485c = order.getShort();
            this.f15484b = order.getShort();
            this.f15486d = l.a(order.getShort()) & 65535;
            this.f15487e = order.get();
            this.f15489g = new byte[this.f15486d];
            if (this.f15485c == 1) {
                h();
            }
            q.L(q.f15504a, 529, new byte[]{0}, null, 4, null);
            return;
        }
        q.L(q.f15504a, 529, new byte[]{1}, null, 4, null);
    }

    private final int e() {
        if (this.f15483a != 1) {
            return 2;
        }
        ArrayList<byte[]> arrayList = this.f15488f;
        if (arrayList != null) {
            byte[] bArr = arrayList.get(0);
            i.e(bArr, "sliceList[0]");
            return f(bArr);
        }
        i.u("sliceList");
        throw null;
    }

    private final int f(byte[] bArr) {
        byte b10 = bArr[16];
        byte b11 = bArr[b10 + 17];
        return b10 + 99 + b11 + bArr[b10 + 46 + b11];
    }

    private final void h() {
        this.f15490h = 0;
        this.f15488f = new ArrayList<>(this.f15484b);
    }

    public final void g(int i10, byte[] data) {
        i.f(data, "data");
        if (i10 == 528) {
            d(data);
        } else if (i10 == 530) {
            b(data);
        } else if (i10 == 532 && this.f15493k) {
            ByteBuffer order = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
            byte b10 = order.get();
            if (b10 == 2) {
                this.f15490h = order.getShort();
            } else if (b10 == 3) {
                ArrayList<byte[]> arrayList = this.f15488f;
                if (arrayList != null) {
                    byte[] bArr = this.f15489g;
                    if (bArr != null) {
                        arrayList.add(bArr);
                        if (this.f15485c == this.f15484b) {
                            this.f15493k = false;
                            c();
                            return;
                        }
                        return;
                    }
                    i.u("sliceData");
                    throw null;
                }
                i.u("sliceList");
                throw null;
            }
        }
    }

    public final void i(b bVar) {
        this.f15492j = bVar;
    }
}
