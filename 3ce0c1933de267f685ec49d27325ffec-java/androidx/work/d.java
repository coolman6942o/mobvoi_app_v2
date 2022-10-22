package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: Data.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4739b = k.f("Data");

    /* renamed from: c  reason: collision with root package name */
    public static final d f4740c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f4741a;

    /* compiled from: Data.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f4742a = new HashMap();

        public d a() {
            d dVar = new d(this.f4742a);
            d.k(dVar);
            return dVar;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.f4742a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f4742a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f4742a.put(str, d.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f4742a.put(str, d.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f4742a.put(str, d.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f4742a.put(str, d.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f4742a.put(str, d.d((float[]) obj));
                } else if (cls == double[].class) {
                    this.f4742a.put(str, d.c((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
            }
            return this;
        }

        public a c(d dVar) {
            d(dVar.f4741a);
            return this;
        }

        public a d(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a e(String str, String str2) {
            this.f4742a.put(str, str2);
            return this;
        }
    }

    d() {
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x005d -> B:29:0x0062). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d g(byte[] bArr) {
        Throwable th2;
        Throwable e10;
        ObjectInputStream objectInputStream;
        Throwable e11;
        if (bArr.length <= 10240) {
            HashMap hashMap = new HashMap();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream2 = null;
            try {
            } catch (IOException e12) {
                Log.e(f4739b, "Error in Data#fromByteArray: ", e12);
            }
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                            hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e13) {
                            Log.e(f4739b, "Error in Data#fromByteArray: ", e13);
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e14) {
                        e10 = e14;
                        Log.e(f4739b, "Error in Data#fromByteArray: ", e10);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e15) {
                                Log.e(f4739b, "Error in Data#fromByteArray: ", e15);
                            }
                        }
                        byteArrayInputStream.close();
                        return new d(hashMap);
                    } catch (ClassNotFoundException e16) {
                        e10 = e16;
                        Log.e(f4739b, "Error in Data#fromByteArray: ", e10);
                        if (objectInputStream != null) {
                        }
                        byteArrayInputStream.close();
                        return new d(hashMap);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e17) {
                            Log.e(f4739b, "Error in Data#fromByteArray: ", e17);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        Log.e(f4739b, "Error in Data#fromByteArray: ", e18);
                    }
                    throw th2;
                }
            } catch (IOException e19) {
                e11 = e19;
                e10 = e11;
                objectInputStream = null;
                Log.e(f4739b, "Error in Data#fromByteArray: ", e10);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new d(hashMap);
            } catch (ClassNotFoundException e20) {
                e11 = e20;
                e10 = e11;
                objectInputStream = null;
                Log.e(f4739b, "Error in Data#fromByteArray: ", e10);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new d(hashMap);
            } catch (Throwable th4) {
                th2 = th4;
                if (0 != 0) {
                }
                byteArrayInputStream.close();
                throw th2;
            }
            return new d(hashMap);
        }
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public static byte[] k(d dVar) {
        Throwable th2;
        IOException e10;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (IOException e11) {
            e10 = e11;
        }
        try {
            objectOutputStream.writeInt(dVar.j());
            for (Map.Entry<String, Object> entry : dVar.f4741a.entrySet()) {
                objectOutputStream.writeUTF(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e12) {
                Log.e(f4739b, "Error in Data#toByteArray: ", e12);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e13) {
                Log.e(f4739b, "Error in Data#toByteArray: ", e13);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e14) {
            e10 = e14;
            objectOutputStream2 = objectOutputStream;
            Log.e(f4739b, "Error in Data#toByteArray: ", e10);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e15) {
                    Log.e(f4739b, "Error in Data#toByteArray: ", e15);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                Log.e(f4739b, "Error in Data#toByteArray: ", e16);
            }
            return byteArray;
        } catch (Throwable th4) {
            th2 = th4;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e17) {
                    Log.e(f4739b, "Error in Data#toByteArray: ", e17);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                Log.e(f4739b, "Error in Data#toByteArray: ", e18);
            }
            throw th2;
        }
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        Set<String> keySet = this.f4741a.keySet();
        if (!keySet.equals(dVar.f4741a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f4741a.get(str);
            Object obj3 = dVar.f4741a.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z10 = obj2.equals(obj3);
                continue;
            } else {
                z10 = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> h() {
        return Collections.unmodifiableMap(this.f4741a);
    }

    public int hashCode() {
        return this.f4741a.hashCode() * 31;
    }

    public String i(String str) {
        Object obj = this.f4741a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f4741a.size();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f4741a.isEmpty()) {
            for (String str : this.f4741a.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = this.f4741a.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public d(d dVar) {
        this.f4741a = new HashMap(dVar.f4741a);
    }

    public d(Map<String, ?> map) {
        this.f4741a = new HashMap(map);
    }
}
