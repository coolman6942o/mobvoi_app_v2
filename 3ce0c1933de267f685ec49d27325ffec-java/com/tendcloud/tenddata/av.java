package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static int f22660a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static int f22661b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static int f22662c = 6;

    /* renamed from: d  reason: collision with root package name */
    private static int f22663d = -40;

    /* renamed from: e  reason: collision with root package name */
    private static int f22664e = 4;

    /* renamed from: f  reason: collision with root package name */
    private as f22665f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class a {
        public au fp1;
        public au fp2;
        public double score;

        public a(au auVar, au auVar2, double d10) {
            this.fp1 = auVar;
            this.fp2 = auVar2;
            this.score = d10;
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    class b {
        public Object key;
        public Object value;

        public b(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    public av() {
        this(new as());
    }

    public double a(au auVar, au auVar2) {
        Map<String, ar> a10 = auVar.a(false);
        Map<String, ar> a11 = auVar2.a(false);
        HashSet<ar> hashSet = new HashSet();
        int i10 = 0;
        int i11 = 0;
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (Map.Entry<String, ar> entry : a10.entrySet()) {
            ar value = entry.getValue();
            ar arVar = a11.get(entry.getKey());
            i11 += value.c();
            if (arVar == null) {
                hashSet.add(value);
            } else {
                i10++;
                double b10 = b(value.c(), arVar.c());
                d10 += b10;
                d11 += b10 * a(value.c(), arVar.c());
            }
        }
        if (i10 == 0) {
            return 0.0d;
        }
        double d12 = 0.0d;
        for (Map.Entry<String, ar> entry2 : a11.entrySet()) {
            i11 += entry2.getValue().c();
            if (!a10.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int max = Math.max(this.f22665f.d(), (int) ((i11 / ((auVar.c().size() + auVar2.c().size()) - 0)) + 1.2d));
        for (ar arVar2 : hashSet) {
            if (arVar2.c() > max) {
                d12 += 1.0d;
            }
        }
        return (d11 / d10) * (1.0d - Math.pow(d12 / ((i10 * 2) + d12), f22664e));
    }

    public au b(au auVar, au auVar2) {
        Map<String, ar> a10 = auVar.a(false);
        Map<String, ar> a11 = auVar2.a(false);
        TreeMap treeMap = new TreeMap();
        au auVar3 = new au();
        auVar3.setPoiId(auVar2.b());
        auVar3.setTimestamp(auVar2.a());
        LinkedList linkedList = new LinkedList();
        auVar3.setBsslist(linkedList);
        for (Map.Entry<String, ar> entry : a10.entrySet()) {
            ar value = entry.getValue();
            ar arVar = a11.get(entry.getKey());
            if (arVar == null) {
                double d10 = -value.c();
                while (treeMap.containsKey(Double.valueOf(d10))) {
                    d10 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d10), value);
            } else {
                linkedList.add(new ar(arVar.a(), arVar.b(), (byte) ((arVar.c() + value.c()) / 2), arVar.d(), arVar.e()));
            }
        }
        for (Map.Entry<String, ar> entry2 : a11.entrySet()) {
            if (!a10.containsKey(entry2.getKey())) {
                double d11 = -entry2.getValue().c();
                while (treeMap.containsKey(Double.valueOf(d11))) {
                    d11 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d11), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b10 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f22665f.c() || b10 < this.f22665f.d()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return auVar3;
    }

    public av(as asVar) {
        this.f22665f = asVar;
    }

    public double a(au auVar, List<au> list) {
        double d10 = 0.0d;
        for (au auVar2 : list) {
            d10 = Math.max(a(auVar2, auVar), d10);
        }
        return d10;
    }

    public double a(List<au> list, List<au> list2) {
        double d10 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i10 = 0;
        for (a aVar : linkedList) {
            if (!(aVar.fp1 == null || aVar.fp2 == null)) {
                d10 += aVar.score;
                i10++;
            }
        }
        return d10 / i10;
    }

    public double a(List<au> list, List<au> list2, List<au> list3) {
        au auVar;
        double d10 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            list3.addAll(list);
            list3.addAll(list2);
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i10 = 0;
        for (a aVar : linkedList) {
            au auVar2 = aVar.fp1;
            if (auVar2 != null && (auVar = aVar.fp2) != null) {
                d10 += aVar.score;
                i10++;
                list3.add(b(auVar2, auVar));
            } else if (list3.size() < this.f22665f.b()) {
                au auVar3 = aVar.fp1;
                list3.add(auVar3 == null ? aVar.fp2.d() : auVar3.d());
            }
        }
        return d10 / i10;
    }

    public void b(List<au> list, List<au> list2, List<a> list3) {
        ArrayList arrayList = new ArrayList();
        HashSet<au> hashSet = new HashSet();
        HashSet<au> hashSet2 = new HashSet();
        for (au auVar : list) {
            for (au auVar2 : list2) {
                hashSet2.add(auVar2);
                arrayList.add(new a(auVar, auVar2, a(auVar, auVar2)));
            }
            hashSet.add(auVar);
        }
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.tendcloud.tenddata.av.1
            public int compare(a aVar, a aVar2) {
                double d10 = aVar.score;
                double d11 = aVar2.score;
                if (d10 == d11) {
                    return 0;
                }
                return d10 < d11 ? 1 : -1;
            }
        });
        list3.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (hashSet.contains(aVar.fp1) && hashSet2.contains(aVar.fp2)) {
                hashSet.remove(aVar.fp1);
                hashSet2.remove(aVar.fp2);
                list3.add(aVar);
            }
        }
        for (au auVar3 : hashSet) {
            list3.add(new a(auVar3, null, 0.0d));
        }
        for (au auVar4 : hashSet2) {
            list3.add(new a(null, auVar4, 0.0d));
        }
    }

    public double a(int i10, int i11) {
        double d10 = 0.0d;
        if (i10 >= 0 || i11 >= 0) {
            return 0.0d;
        }
        double d11 = (i11 + i10) / 2;
        double abs = Math.abs(i10 - d11);
        int i12 = f22660a;
        if (abs > i12) {
            d10 = abs - i12;
        }
        return Math.pow((d10 + d11) / d11, f22661b);
    }

    public double b(int i10, int i11) {
        int i12;
        if (i10 >= 0 || i11 >= 0) {
            return 0.0d;
        }
        double max = Math.max(i10, i11);
        if (max >= f22663d) {
            return 1.0d;
        }
        return Math.pow((max + 128.0d) / (i12 + 128), f22662c);
    }
}
