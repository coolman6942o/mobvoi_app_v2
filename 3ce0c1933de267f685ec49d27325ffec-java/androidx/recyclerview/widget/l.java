package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    final a f4103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i10, int i11, int i12, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.f4103a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f3922a != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        int i12 = bVar.f3925d;
        int i13 = bVar2.f3923b;
        int i14 = i12 < i13 ? -1 : 0;
        int i15 = bVar.f3923b;
        if (i15 < i13) {
            i14++;
        }
        if (i13 <= i15) {
            bVar.f3923b = i15 + bVar2.f3925d;
        }
        int i16 = bVar2.f3923b;
        if (i16 <= i12) {
            bVar.f3925d = i12 + bVar2.f3925d;
        }
        bVar2.f3923b = i16 + i14;
        list.set(i10, bVar2);
        list.set(i11, bVar);
    }

    private void d(List<a.b> list, int i10, int i11) {
        a.b bVar = list.get(i10);
        a.b bVar2 = list.get(i11);
        int i12 = bVar2.f3922a;
        if (i12 == 1) {
            c(list, i10, bVar, i11, bVar2);
        } else if (i12 == 2) {
            e(list, i10, bVar, i11, bVar2);
        } else if (i12 == 4) {
            f(list, i10, bVar, i11, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<a.b> list) {
        while (true) {
            int a10 = a(list);
            if (a10 != -1) {
                d(list, a10, a10 + 1);
            } else {
                return;
            }
        }
    }

    void e(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        boolean z10;
        int i12 = bVar.f3923b;
        int i13 = bVar.f3925d;
        boolean z11 = false;
        if (i12 < i13) {
            if (bVar2.f3923b == i12 && bVar2.f3925d == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f3923b == i13 + 1 && bVar2.f3925d == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = bVar2.f3923b;
        if (i13 < i14) {
            bVar2.f3923b = i14 - 1;
        } else {
            int i15 = bVar2.f3925d;
            if (i13 < i14 + i15) {
                bVar2.f3925d = i15 - 1;
                bVar.f3922a = 2;
                bVar.f3925d = 1;
                if (bVar2.f3925d == 0) {
                    list.remove(i11);
                    this.f4103a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i16 = bVar.f3923b;
        int i17 = bVar2.f3923b;
        a.b bVar3 = null;
        if (i16 <= i17) {
            bVar2.f3923b = i17 + 1;
        } else {
            int i18 = bVar2.f3925d;
            if (i16 < i17 + i18) {
                bVar3 = this.f4103a.b(2, i16 + 1, (i17 + i18) - i16, null);
                bVar2.f3925d = bVar.f3923b - bVar2.f3923b;
            }
        }
        if (z11) {
            list.set(i10, bVar2);
            list.remove(i11);
            this.f4103a.a(bVar);
            return;
        }
        if (z10) {
            if (bVar3 != null) {
                int i19 = bVar.f3923b;
                if (i19 > bVar3.f3923b) {
                    bVar.f3923b = i19 - bVar3.f3925d;
                }
                int i20 = bVar.f3925d;
                if (i20 > bVar3.f3923b) {
                    bVar.f3925d = i20 - bVar3.f3925d;
                }
            }
            int i21 = bVar.f3923b;
            if (i21 > bVar2.f3923b) {
                bVar.f3923b = i21 - bVar2.f3925d;
            }
            int i22 = bVar.f3925d;
            if (i22 > bVar2.f3923b) {
                bVar.f3925d = i22 - bVar2.f3925d;
            }
        } else {
            if (bVar3 != null) {
                int i23 = bVar.f3923b;
                if (i23 >= bVar3.f3923b) {
                    bVar.f3923b = i23 - bVar3.f3925d;
                }
                int i24 = bVar.f3925d;
                if (i24 >= bVar3.f3923b) {
                    bVar.f3925d = i24 - bVar3.f3925d;
                }
            }
            int i25 = bVar.f3923b;
            if (i25 >= bVar2.f3923b) {
                bVar.f3923b = i25 - bVar2.f3925d;
            }
            int i26 = bVar.f3925d;
            if (i26 >= bVar2.f3923b) {
                bVar.f3925d = i26 - bVar2.f3925d;
            }
        }
        list.set(i10, bVar2);
        if (bVar.f3923b != bVar.f3925d) {
            list.set(i11, bVar);
        } else {
            list.remove(i11);
        }
        if (bVar3 != null) {
            list.add(i10, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        a.b bVar3;
        int i12;
        int i13;
        int i14 = bVar.f3925d;
        int i15 = bVar2.f3923b;
        a.b bVar4 = null;
        if (i14 < i15) {
            bVar2.f3923b = i15 - 1;
        } else {
            int i16 = bVar2.f3925d;
            if (i14 < i15 + i16) {
                bVar2.f3925d = i16 - 1;
                bVar3 = this.f4103a.b(4, bVar.f3923b, 1, bVar2.f3924c);
                i12 = bVar.f3923b;
                i13 = bVar2.f3923b;
                if (i12 > i13) {
                    bVar2.f3923b = i13 + 1;
                } else {
                    int i17 = bVar2.f3925d;
                    if (i12 < i13 + i17) {
                        int i18 = (i13 + i17) - i12;
                        bVar4 = this.f4103a.b(4, i12 + 1, i18, bVar2.f3924c);
                        bVar2.f3925d -= i18;
                    }
                }
                list.set(i11, bVar);
                if (bVar2.f3925d <= 0) {
                    list.set(i10, bVar2);
                } else {
                    list.remove(i10);
                    this.f4103a.a(bVar2);
                }
                if (bVar3 != null) {
                    list.add(i10, bVar3);
                }
                if (bVar4 == null) {
                    list.add(i10, bVar4);
                    return;
                }
                return;
            }
        }
        bVar3 = null;
        i12 = bVar.f3923b;
        i13 = bVar2.f3923b;
        if (i12 > i13) {
        }
        list.set(i11, bVar);
        if (bVar2.f3925d <= 0) {
        }
        if (bVar3 != null) {
        }
        if (bVar4 == null) {
        }
    }
}
