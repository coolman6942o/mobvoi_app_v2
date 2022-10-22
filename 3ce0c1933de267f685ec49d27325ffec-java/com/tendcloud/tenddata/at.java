package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: td */
/* loaded from: classes2.dex */
public final class at {

    /* renamed from: a  reason: collision with root package name */
    private static int f22650a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static int f22651b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static int f22652c = 6;

    /* renamed from: d  reason: collision with root package name */
    private static int f22653d = -40;

    /* renamed from: e  reason: collision with root package name */
    private static int f22654e = 4;

    /* renamed from: f  reason: collision with root package name */
    private b f22655f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class b {
        static final int DEFAULT_MAX_BSS_ENTRIES = 50;
        static final int DEFAULT_MAX_FINGERPRINTS = 10;
        static final int DEFAULT_MIN_FINGERPRINTS = 3;
        static final int DEFAULT_RSSI_THRESHOLD = -85;
        private int maxFingerprints = 10;
        private int minFingerprints = 3;
        private int maxBssEntries = 50;
        private int rssiThreshold = -85;

        b() {
        }

        int getMaxBssEntries() {
            return this.maxBssEntries;
        }

        int getMaxFingerprints() {
            return this.maxFingerprints;
        }

        int getMinFingerprints() {
            return this.minFingerprints;
        }

        int getRssiThreshold() {
            return this.rssiThreshold;
        }

        void setMaxBssEntries(int i10) {
            this.maxBssEntries = i10;
        }

        void setMaxFingerprints(int i10) {
            this.maxFingerprints = i10;
        }

        void setMinFingerprints(int i10) {
            this.minFingerprints = i10;
        }

        void setRssiThreshold(int i10) {
            this.rssiThreshold = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class c {
        private List<a> bsslist;
        private Map<String, a> bssmap;
        private long poiId;
        private int timestamp;

        c() {
        }

        c cloneFingerprint() {
            c cVar = new c();
            cVar.setTimestamp(this.timestamp);
            cVar.setPoiId(this.poiId);
            LinkedList linkedList = new LinkedList();
            for (a aVar : this.bsslist) {
                linkedList.add(aVar.cloneBssEntry());
            }
            cVar.setBsslist(linkedList);
            return cVar;
        }

        List<a> getBsslist() {
            return this.bsslist;
        }

        Map<String, a> getBssmap(boolean z10) {
            if (this.bssmap == null || z10) {
                this.bssmap = new HashMap();
                for (a aVar : this.bsslist) {
                    this.bssmap.put(aVar.getBssid(), aVar);
                }
            }
            return this.bssmap;
        }

        long getPoiId() {
            return this.poiId;
        }

        int getTimestamp() {
            return this.timestamp;
        }

        void setBsslist(List<a> list) {
            this.bsslist = list;
        }

        void setPoiId(long j10) {
            this.poiId = j10;
        }

        void setTimestamp(int i10) {
            this.timestamp = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class d {
        c fp1;
        c fp2;
        double score;

        d(c cVar, c cVar2, double d10) {
            this.fp1 = cVar;
            this.fp2 = cVar2;
            this.score = d10;
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    class e {
        Object key;
        Object value;

        e(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    at() {
        this(new b());
    }

    double a(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        HashSet<a> hashSet = new HashSet();
        int i10 = 0;
        int i11 = 0;
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            i11 += value.getRssi();
            if (aVar == null) {
                hashSet.add(value);
            } else {
                i10++;
                double b10 = b(value.getRssi(), aVar.getRssi());
                d10 += b10;
                d11 += b10 * a(value.getRssi(), aVar.getRssi());
            }
        }
        if (i10 == 0) {
            return 0.0d;
        }
        double d12 = 0.0d;
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            i11 += entry2.getValue().getRssi();
            if (!bssmap.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int max = Math.max(this.f22655f.getRssiThreshold(), (int) ((i11 / ((cVar.getBsslist().size() + cVar2.getBsslist().size()) - 0)) + 1.2d));
        for (a aVar2 : hashSet) {
            if (aVar2.getRssi() > max) {
                d12 += 1.0d;
            }
        }
        return (d11 / d10) * (1.0d - Math.pow(d12 / ((i10 * 2) + d12), f22654e));
    }

    c b(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        TreeMap treeMap = new TreeMap();
        c cVar3 = new c();
        cVar3.setPoiId(cVar2.getPoiId());
        cVar3.setTimestamp(cVar2.getTimestamp());
        LinkedList linkedList = new LinkedList();
        cVar3.setBsslist(linkedList);
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            if (aVar == null) {
                double d10 = -value.getRssi();
                while (treeMap.containsKey(Double.valueOf(d10))) {
                    d10 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d10), value);
            } else {
                linkedList.add(new a(aVar.getSsid(), aVar.getBssid(), (byte) ((aVar.getRssi() + value.getRssi()) / 2), aVar.getBand(), aVar.getChannel()));
            }
        }
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            if (!bssmap.containsKey(entry2.getKey())) {
                double d11 = -entry2.getValue().getRssi();
                while (treeMap.containsKey(Double.valueOf(d11))) {
                    d11 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d11), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b10 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f22655f.getMaxBssEntries() || b10 < this.f22655f.getRssiThreshold()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return cVar3;
    }

    at(b bVar) {
        this.f22655f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class a {
        private byte band;
        private String bssid;
        private byte channel;
        private byte rssi;
        private String ssid;

        a() {
            this.ssid = "";
            this.bssid = "00:00:00:00:00:00";
            this.rssi = (byte) -127;
            this.band = (byte) 1;
            this.channel = (byte) 1;
        }

        a cloneBssEntry() {
            return new a(this.ssid, this.bssid, this.rssi, this.band, this.channel);
        }

        byte getBand() {
            return this.band;
        }

        String getBssid() {
            return this.bssid;
        }

        byte getChannel() {
            return this.channel;
        }

        byte getRssi() {
            return this.rssi;
        }

        String getSsid() {
            return this.ssid;
        }

        void setBand(byte b10) {
            this.band = b10;
        }

        void setBssid(String str) {
            this.bssid = str;
        }

        void setChannel(byte b10) {
            this.channel = b10;
        }

        void setRssi(byte b10) {
            this.rssi = b10;
        }

        void setSsid(String str) {
            this.ssid = str;
        }

        a(String str, String str2, byte b10, byte b11, byte b12) {
            this.ssid = str;
            this.bssid = str2;
            this.rssi = b10;
            this.band = b11;
            this.channel = b12;
        }
    }

    double a(c cVar, List<c> list) {
        double d10 = 0.0d;
        for (c cVar2 : list) {
            d10 = Math.max(a(cVar2, cVar), d10);
        }
        return d10;
    }

    double a(List<c> list, List<c> list2) {
        double d10 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i10 = 0;
        for (d dVar : linkedList) {
            if (!(dVar.fp1 == null || dVar.fp2 == null)) {
                d10 += dVar.score;
                i10++;
            }
        }
        return d10 / i10;
    }

    double a(List<c> list, List<c> list2, List<c> list3) {
        c cVar;
        double d10 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            list3.addAll(list);
            list3.addAll(list2);
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i10 = 0;
        for (d dVar : linkedList) {
            c cVar2 = dVar.fp1;
            if (cVar2 != null && (cVar = dVar.fp2) != null) {
                d10 += dVar.score;
                i10++;
                list3.add(b(cVar2, cVar));
            } else if (list3.size() < this.f22655f.getMinFingerprints()) {
                c cVar3 = dVar.fp1;
                list3.add(cVar3 == null ? dVar.fp2.cloneFingerprint() : cVar3.cloneFingerprint());
            }
        }
        return d10 / i10;
    }

    void b(List<c> list, List<c> list2, List<d> list3) {
        ArrayList arrayList = new ArrayList();
        HashSet<c> hashSet = new HashSet();
        HashSet<c> hashSet2 = new HashSet();
        for (c cVar : list) {
            for (c cVar2 : list2) {
                hashSet2.add(cVar2);
                arrayList.add(new d(cVar, cVar2, a(cVar, cVar2)));
            }
            hashSet.add(cVar);
        }
        Collections.sort(arrayList, new Comparator<d>() { // from class: com.tendcloud.tenddata.at.1
            public int compare(d dVar, d dVar2) {
                if (Double.doubleToLongBits(dVar.score) == Double.doubleToLongBits(dVar2.score)) {
                    return 0;
                }
                return Double.doubleToLongBits(dVar.score) < Double.doubleToLongBits(dVar2.score) ? 1 : -1;
            }
        });
        list3.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (hashSet.contains(dVar.fp1) && hashSet2.contains(dVar.fp2)) {
                hashSet.remove(dVar.fp1);
                hashSet2.remove(dVar.fp2);
                list3.add(dVar);
            }
        }
        for (c cVar3 : hashSet) {
            list3.add(new d(cVar3, null, 0.0d));
        }
        for (c cVar4 : hashSet2) {
            list3.add(new d(null, cVar4, 0.0d));
        }
    }

    double a(int i10, int i11) {
        double d10 = 0.0d;
        if (i10 >= 0 || i11 >= 0) {
            return 0.0d;
        }
        double d11 = (i11 + i10) / 2;
        double abs = Math.abs(i10 - d11);
        int i12 = f22650a;
        if (abs > i12) {
            d10 = abs - i12;
        }
        return Math.pow((d10 + d11) / d11, f22651b);
    }

    double b(int i10, int i11) {
        int i12;
        if (i10 >= 0 || i11 >= 0) {
            return 0.0d;
        }
        double max = Math.max(i10, i11);
        if (max >= f22653d) {
            return 1.0d;
        }
        return Math.pow((max + 128.0d) / (i12 + 128), f22652c);
    }
}
