package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f22430b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public File f22431a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f15a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<File, a> f16a = new HashMap<>();

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f22431a = new File(str);
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File b(String str) {
        File a10 = a();
        return a(a10, str + ".xml");
    }

    /* loaded from: classes2.dex */
    public static final class a implements b {

        /* renamed from: c  reason: collision with root package name */
        public static final Object f22432c = new Object();

        /* renamed from: a  reason: collision with root package name */
        public Map f22433a;

        /* renamed from: a  reason: collision with other field name */
        public WeakHashMap<b.AbstractC0250b, Object> f17a;

        /* renamed from: b  reason: collision with root package name */
        public final File f22434b;

        /* renamed from: c  reason: collision with other field name */
        public final int f18c;

        /* renamed from: c  reason: collision with other field name */
        public final File f19c;

        /* renamed from: j  reason: collision with root package name */
        public boolean f22435j = false;

        public a(File file, int i10, Map map) {
            this.f22434b = file;
            this.f19c = d.a(file);
            this.f18c = i10;
            this.f22433a = map == null ? new HashMap() : map;
            this.f17a = new WeakHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            if (this.f22434b.exists()) {
                if (this.f19c.exists()) {
                    this.f22434b.delete();
                } else if (!this.f22434b.renameTo(this.f19c)) {
                    return false;
                }
            }
            try {
                FileOutputStream a10 = a(this.f22434b);
                if (a10 == null) {
                    return false;
                }
                e.a(this.f22433a, a10);
                a10.close();
                this.f19c.delete();
                return true;
            } catch (Exception unused) {
                if (this.f22434b.exists()) {
                    this.f22434b.delete();
                }
                return false;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            return this.f22434b != null && new File(this.f22434b.getAbsolutePath()).exists();
        }

        public boolean d() {
            boolean z10;
            synchronized (this) {
                z10 = this.f22435j;
            }
            return z10;
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f22433a);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j10) {
            synchronized (this) {
                Long l10 = (Long) this.f22433a.get(str);
                if (l10 != null) {
                    j10 = l10.longValue();
                }
            }
            return j10;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f22433a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0251a implements b.a {

            /* renamed from: b  reason: collision with root package name */
            public final Map<String, Object> f22437b = new HashMap();

            /* renamed from: k  reason: collision with root package name */
            public boolean f22438k = false;

            public C0251a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f22437b.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.f22438k = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                boolean z10;
                ArrayList arrayList;
                HashSet<b.AbstractC0250b> hashSet;
                boolean e10;
                synchronized (d.f22430b) {
                    z10 = a.this.f17a.size() > 0;
                    arrayList = null;
                    if (z10) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f17a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f22438k) {
                            a.this.f22433a.clear();
                            this.f22438k = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f22437b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f22433a.remove(key);
                            } else {
                                a.this.f22433a.put(key, value);
                            }
                            if (z10) {
                                arrayList.add(key);
                            }
                        }
                        this.f22437b.clear();
                    }
                    e10 = a.this.e();
                    if (e10) {
                        a.this.a(true);
                    }
                }
                if (z10) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.AbstractC0250b bVar : hashSet) {
                            if (bVar != null) {
                                bVar.a(a.this, str);
                            }
                        }
                    }
                }
                return e10;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i10) {
                synchronized (this) {
                    this.f22437b.put(str, Integer.valueOf(i10));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j10) {
                synchronized (this) {
                    this.f22437b.put(str, Long.valueOf(j10));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f10) {
                synchronized (this) {
                    this.f22437b.put(str, Float.valueOf(f10));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z10) {
                synchronized (this) {
                    this.f22437b.put(str, Boolean.valueOf(z10));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.f22437b.put(str, this);
                }
                return this;
            }
        }

        public void a(boolean z10) {
            synchronized (this) {
                this.f22435j = z10;
            }
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f22433a = map;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            return new C0251a();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }
    }

    private File a() {
        File file;
        synchronized (this.f15a) {
            file = this.f22431a;
        }
        return file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089 A[Catch: all -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0059, blocks: (B:27:0x0056, B:48:0x0089), top: B:82:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, int i10) {
        Throwable th2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th3;
        File b10 = b(str);
        synchronized (f22430b) {
            a aVar = this.f16a.get(b10);
            if (aVar != null && !aVar.d()) {
                return aVar;
            }
            File a10 = a(b10);
            if (a10.exists()) {
                b10.delete();
                a10.renameTo(b10);
            }
            HashMap hashMap = null;
            hashMap = null;
            hashMap = null;
            FileInputStream fileInputStream3 = null;
            FileInputStream fileInputStream4 = null;
            hashMap = null;
            if (b10.exists()) {
                HashMap canRead = b10.canRead();
                try {
                    try {
                        if (canRead != 0) {
                            try {
                                fileInputStream = new FileInputStream(b10);
                                try {
                                    hashMap = e.a(fileInputStream);
                                    fileInputStream.close();
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                } catch (XmlPullParserException unused2) {
                                    canRead = hashMap;
                                    fileInputStream4 = fileInputStream;
                                    try {
                                        fileInputStream2 = new FileInputStream(b10);
                                        try {
                                            fileInputStream2.read(new byte[fileInputStream2.available()]);
                                            try {
                                                fileInputStream2.close();
                                            } catch (Throwable unused3) {
                                            }
                                        } catch (Exception unused4) {
                                            fileInputStream4 = fileInputStream2;
                                            if (fileInputStream4 != null) {
                                                try {
                                                    fileInputStream4.close();
                                                } catch (Throwable unused5) {
                                                }
                                            }
                                            fileInputStream2 = fileInputStream4;
                                            if (fileInputStream2 != null) {
                                            }
                                            hashMap = canRead;
                                            synchronized (f22430b) {
                                            }
                                        } catch (Throwable th4) {
                                            th3 = th4;
                                            fileInputStream4 = fileInputStream2;
                                            if (fileInputStream4 != null) {
                                                try {
                                                    fileInputStream4.close();
                                                } catch (Throwable unused6) {
                                                }
                                            }
                                            throw th3;
                                        }
                                    } catch (Exception unused7) {
                                    } catch (Throwable th5) {
                                        th3 = th5;
                                    }
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                        canRead = canRead;
                                    }
                                    hashMap = canRead;
                                    synchronized (f22430b) {
                                    }
                                } catch (Exception unused8) {
                                    canRead = hashMap;
                                    fileInputStream3 = fileInputStream;
                                    if (fileInputStream3 != null) {
                                        fileInputStream3.close();
                                        canRead = canRead;
                                    }
                                    hashMap = canRead;
                                    synchronized (f22430b) {
                                    }
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (XmlPullParserException unused10) {
                                canRead = null;
                            } catch (Exception unused11) {
                                canRead = 0;
                            }
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        fileInputStream = null;
                    }
                } catch (Throwable unused12) {
                }
            }
            synchronized (f22430b) {
                if (aVar != null) {
                    aVar.a(hashMap);
                } else {
                    aVar = this.f16a.get(b10);
                    if (aVar == null) {
                        aVar = new a(b10, i10, hashMap);
                        this.f16a.put(b10, aVar);
                    }
                }
            }
            return aVar;
        }
    }

    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }
}
