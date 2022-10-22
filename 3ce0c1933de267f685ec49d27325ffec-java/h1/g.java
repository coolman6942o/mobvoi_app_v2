package h1;

import android.database.Cursor;
import android.os.Build;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f27687a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f27688b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f27689c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f27690d;

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f27691a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27692b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27693c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f27694d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27695e;

        /* renamed from: f  reason: collision with root package name */
        public final String f27696f;

        /* renamed from: g  reason: collision with root package name */
        private final int f27697g;

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.f27691a = str;
            this.f27692b = str2;
            this.f27694d = z10;
            this.f27695e = i10;
            this.f27693c = a(str2);
            this.f27696f = str3;
            this.f27697g = i11;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean b() {
            return this.f27695e > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f27695e != aVar.f27695e) {
                    return false;
                }
            } else if (b() != aVar.b()) {
                return false;
            }
            if (!this.f27691a.equals(aVar.f27691a) || this.f27694d != aVar.f27694d) {
                return false;
            }
            if (this.f27697g == 1 && aVar.f27697g == 2 && (str3 = this.f27696f) != null && !str3.equals(aVar.f27696f)) {
                return false;
            }
            if (this.f27697g == 2 && aVar.f27697g == 1 && (str2 = aVar.f27696f) != null && !str2.equals(this.f27696f)) {
                return false;
            }
            int i10 = this.f27697g;
            return (i10 == 0 || i10 != aVar.f27697g || ((str = this.f27696f) == null ? aVar.f27696f == null : str.equals(aVar.f27696f))) && this.f27693c == aVar.f27693c;
        }

        public int hashCode() {
            return (((((this.f27691a.hashCode() * 31) + this.f27693c) * 31) + (this.f27694d ? 1231 : 1237)) * 31) + this.f27695e;
        }

        public String toString() {
            return "Column{name='" + this.f27691a + "', type='" + this.f27692b + "', affinity='" + this.f27693c + "', notNull=" + this.f27694d + ", primaryKeyPosition=" + this.f27695e + ", defaultValue='" + this.f27696f + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f27698a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27699b;

        /* renamed from: c  reason: collision with root package name */
        public final String f27700c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f27701d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f27702e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f27698a = str;
            this.f27699b = str2;
            this.f27700c = str3;
            this.f27701d = Collections.unmodifiableList(list);
            this.f27702e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f27698a.equals(bVar.f27698a) && this.f27699b.equals(bVar.f27699b) && this.f27700c.equals(bVar.f27700c) && this.f27701d.equals(bVar.f27701d)) {
                return this.f27702e.equals(bVar.f27702e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f27698a.hashCode() * 31) + this.f27699b.hashCode()) * 31) + this.f27700c.hashCode()) * 31) + this.f27701d.hashCode()) * 31) + this.f27702e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f27698a + "', onDelete='" + this.f27699b + "', onUpdate='" + this.f27700c + "', columnNames=" + this.f27701d + ", referenceColumnNames=" + this.f27702e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        final int f27703a;

        /* renamed from: b  reason: collision with root package name */
        final int f27704b;

        /* renamed from: c  reason: collision with root package name */
        final String f27705c;

        /* renamed from: d  reason: collision with root package name */
        final String f27706d;

        c(int i10, int i11, String str, String str2) {
            this.f27703a = i10;
            this.f27704b = i11;
            this.f27705c = str;
            this.f27706d = str2;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            int i10 = this.f27703a - cVar.f27703a;
            return i10 == 0 ? this.f27704b - cVar.f27704b : i10;
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f27707a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f27708b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f27709c;

        public d(String str, boolean z10, List<String> list) {
            this.f27707a = str;
            this.f27708b = z10;
            this.f27709c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f27708b != dVar.f27708b || !this.f27709c.equals(dVar.f27709c)) {
                return false;
            }
            if (this.f27707a.startsWith("index_")) {
                return dVar.f27707a.startsWith("index_");
            }
            return this.f27707a.equals(dVar.f27707a);
        }

        public int hashCode() {
            return ((((this.f27707a.startsWith("index_") ? -1184239155 : this.f27707a.hashCode()) * 31) + (this.f27708b ? 1 : 0)) * 31) + this.f27709c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f27707a + "', unique=" + this.f27708b + ", columns=" + this.f27709c + '}';
        }
    }

    public g(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.f27687a = str;
        this.f27688b = Collections.unmodifiableMap(map);
        this.f27689c = Collections.unmodifiableSet(set);
        this.f27690d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static g a(i1.b bVar, String str) {
        return new g(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    private static Map<String, a> b(i1.b bVar, String str) {
        Cursor U = bVar.U("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (U.getColumnCount() > 0) {
                int columnIndex = U.getColumnIndex(ContactConstant.CallsRecordKeys.NAME);
                int columnIndex2 = U.getColumnIndex("type");
                int columnIndex3 = U.getColumnIndex("notnull");
                int columnIndex4 = U.getColumnIndex("pk");
                int columnIndex5 = U.getColumnIndex("dflt_value");
                while (U.moveToNext()) {
                    String string = U.getString(columnIndex);
                    hashMap.put(string, new a(string, U.getString(columnIndex2), U.getInt(columnIndex3) != 0, U.getInt(columnIndex4), U.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            U.close();
        }
    }

    private static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.WatchfaceMarket.MARKET_ENTER_FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> d(i1.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor U = bVar.U("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex("id");
            int columnIndex2 = U.getColumnIndex("seq");
            int columnIndex3 = U.getColumnIndex("table");
            int columnIndex4 = U.getColumnIndex("on_delete");
            int columnIndex5 = U.getColumnIndex("on_update");
            List<c> c10 = c(U);
            int count = U.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                U.moveToPosition(i10);
                if (U.getInt(columnIndex2) == 0) {
                    int i11 = U.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c10) {
                        if (cVar.f27703a == i11) {
                            arrayList.add(cVar.f27705c);
                            arrayList2.add(cVar.f27706d);
                        }
                    }
                    hashSet.add(new b(U.getString(columnIndex3), U.getString(columnIndex4), U.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            U.close();
        }
    }

    private static d e(i1.b bVar, String str, boolean z10) {
        Cursor U = bVar.U("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex("seqno");
            int columnIndex2 = U.getColumnIndex("cid");
            int columnIndex3 = U.getColumnIndex(ContactConstant.CallsRecordKeys.NAME);
            if (!(columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1)) {
                TreeMap treeMap = new TreeMap();
                while (U.moveToNext()) {
                    if (U.getInt(columnIndex2) >= 0) {
                        int i10 = U.getInt(columnIndex);
                        treeMap.put(Integer.valueOf(i10), U.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z10, arrayList);
            }
            return null;
        } finally {
            U.close();
        }
    }

    private static Set<d> f(i1.b bVar, String str) {
        Cursor U = bVar.U("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = U.getColumnIndex(ContactConstant.CallsRecordKeys.NAME);
            int columnIndex2 = U.getColumnIndex("origin");
            int columnIndex3 = U.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1)) {
                HashSet hashSet = new HashSet();
                while (U.moveToNext()) {
                    if ("c".equals(U.getString(columnIndex2))) {
                        String string = U.getString(columnIndex);
                        boolean z10 = true;
                        if (U.getInt(columnIndex3) != 1) {
                            z10 = false;
                        }
                        d e10 = e(bVar, string, z10);
                        if (e10 == null) {
                            return null;
                        }
                        hashSet.add(e10);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            U.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.f27687a;
        if (str == null ? gVar.f27687a != null : !str.equals(gVar.f27687a)) {
            return false;
        }
        Map<String, a> map = this.f27688b;
        if (map == null ? gVar.f27688b != null : !map.equals(gVar.f27688b)) {
            return false;
        }
        Set<b> set2 = this.f27689c;
        if (set2 == null ? gVar.f27689c != null : !set2.equals(gVar.f27689c)) {
            return false;
        }
        Set<d> set3 = this.f27690d;
        if (set3 == null || (set = gVar.f27690d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f27687a;
        int i10 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f27688b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f27689c;
        if (set != null) {
            i10 = set.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "TableInfo{name='" + this.f27687a + "', columns=" + this.f27688b + ", foreignKeys=" + this.f27689c + ", indices=" + this.f27690d + '}';
    }
}
