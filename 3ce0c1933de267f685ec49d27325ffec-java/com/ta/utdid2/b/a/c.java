package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f11a;

    /* renamed from: a  reason: collision with other field name */
    public b f13a;

    /* renamed from: a  reason: collision with other field name */
    public d f14a;

    /* renamed from: b  reason: collision with root package name */
    public String f22424b;

    /* renamed from: c  reason: collision with root package name */
    public String f22425c;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22426f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22427g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22428h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22429i;
    public Context mContext;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f22423a = null;

    /* renamed from: a  reason: collision with other field name */
    public b.a f12a = null;

    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0158 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0174 A[Catch: Exception -> 0x017e, TRY_LEAVE, TryCatch #1 {Exception -> 0x017e, blocks: (B:74:0x0170, B:76:0x0174), top: B:83:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(Context context, String str, String str2, boolean z10, boolean z11) {
        long j10;
        long j11;
        boolean z12;
        SharedPreferences sharedPreferences;
        b bVar;
        this.f22424b = "";
        this.f22425c = "";
        this.f22426f = false;
        this.f22427g = false;
        this.f22428h = false;
        String str3 = null;
        this.f11a = null;
        this.f13a = null;
        this.mContext = null;
        this.f14a = null;
        this.f22429i = false;
        this.f22426f = z10;
        this.f22429i = z11;
        this.f22424b = str2;
        this.f22425c = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f11a = sharedPreferences2;
            j10 = sharedPreferences2.getLong("t", 0L);
        } else {
            j10 = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (g.m22a(str3)) {
            this.f22428h = false;
            this.f22427g = false;
        } else if (str3.equals("mounted")) {
            this.f22428h = true;
            this.f22427g = true;
        } else if (str3.equals("mounted_ro")) {
            this.f22427g = true;
            this.f22428h = false;
        } else {
            this.f22428h = false;
            this.f22427g = false;
        }
        try {
            if ((this.f22427g || this.f22428h) && context != null && !g.m22a(str)) {
                d a10 = a(str);
                this.f14a = a10;
                if (a10 != null) {
                    try {
                        b a11 = a10.a(str2, 0);
                        this.f13a = a11;
                        j11 = a11.getLong("t", 0L);
                    } catch (Exception unused) {
                    }
                    if (!z11) {
                        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
                        if (i10 > 0) {
                            a(this.f11a, this.f13a);
                            this.f13a = this.f14a.a(str2, 0);
                        } else if (i10 < 0) {
                            a(this.f13a, this.f11a);
                            this.f11a = context.getSharedPreferences(str2, 0);
                        } else {
                            if (i10 == 0) {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            }
                            if (j10 == j11 || (j10 == 0 && j11 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z12 = this.f22429i;
                                if (z12 || (z12 && j10 == 0 && j11 == 0)) {
                                    sharedPreferences = this.f11a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    bVar = this.f13a;
                                    if (bVar != null) {
                                        b.a a12 = bVar.a();
                                        a12.a("t2", currentTimeMillis);
                                        a12.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        j10 = this.f11a.getLong("t2", 0L);
                        j11 = this.f13a.getLong("t2", 0L);
                        int i11 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
                        if (i11 < 0 && j10 > 0) {
                            a(this.f11a, this.f13a);
                            this.f13a = this.f14a.a(str2, 0);
                        } else if (i11 <= 0 || j11 <= 0) {
                            int i12 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                            if (i12 == 0 && j11 > 0) {
                                a(this.f13a, this.f11a);
                                this.f11a = context.getSharedPreferences(str2, 0);
                            } else if (j11 == 0 && i12 > 0) {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            } else if (i11 == 0) {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            }
                        } else {
                            a(this.f13a, this.f11a);
                            this.f11a = context.getSharedPreferences(str2, 0);
                        }
                    }
                    if (j10 == j11) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    z12 = this.f22429i;
                    if (z12) {
                    }
                    sharedPreferences = this.f11a;
                    if (sharedPreferences != null) {
                    }
                    bVar = this.f13a;
                    if (bVar != null) {
                    }
                }
            }
            bVar = this.f13a;
            if (bVar != null) {
            }
        } catch (Exception unused2) {
            return;
        }
        j11 = 0;
        if (j10 == j11) {
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        z12 = this.f22429i;
        if (z12) {
        }
        sharedPreferences = this.f11a;
        if (sharedPreferences != null) {
        }
    }

    private d a(String str) {
        File a10 = m23a(str);
        if (a10 == null) {
            return null;
        }
        d dVar = new d(a10.getAbsolutePath());
        this.f14a = dVar;
        return dVar;
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f22423a == null && (sharedPreferences = this.f11a) != null) {
            this.f22423a = sharedPreferences.edit();
        }
        if (this.f22428h && this.f12a == null && (bVar = this.f13a) != null) {
            this.f12a = bVar.a();
        }
        c();
    }

    private boolean c() {
        b bVar = this.f13a;
        if (bVar == null) {
            return false;
        }
        boolean b10 = bVar.b();
        if (!b10) {
            commit();
        }
        return b10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:2|(4:4|(1:8)|9|(9:11|13|(1:17)|18|56|19|22|(4:24|(2:26|(2:28|(3:30|(1:32)(1:33)|34))(3:52|35|(1:37)))|40|(3:54|46|(1:48)))|49))|12|13|(2:15|17)|18|56|19|22|(0)|49|(1:(7:39|40|(2:42|44)|54|46|(0)|49))) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r4.commit() == false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096 A[Catch: Exception -> 0x009e, TRY_LEAVE, TryCatch #1 {Exception -> 0x009e, blocks: (B:46:0x0092, B:48:0x0096), top: B:54:0x0092 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean commit() {
        boolean z10;
        String str;
        d dVar;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.f22423a;
        if (editor != null) {
            if (!this.f22429i && this.f11a != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.f22423a.commit()) {
                z10 = false;
                if (!(this.f11a == null || (context = this.mContext) == null)) {
                    this.f11a = context.getSharedPreferences(this.f22424b, 0);
                }
                str = null;
                str = Environment.getExternalStorageState();
                if (!g.m22a(str)) {
                    if (str.equals("mounted")) {
                        if (this.f13a == null) {
                            d a10 = a(this.f22425c);
                            if (a10 != null) {
                                b a11 = a10.a(this.f22424b, 0);
                                this.f13a = a11;
                                if (!this.f22429i) {
                                    a(this.f11a, a11);
                                } else {
                                    a(a11, this.f11a);
                                }
                                this.f12a = this.f13a.a();
                            }
                        } else {
                            try {
                                b.a aVar = this.f12a;
                                if (aVar != null) {
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (!str.equals("mounted") || (str.equals("mounted_ro") && this.f13a != null)) {
                        try {
                            dVar = this.f14a;
                            if (dVar != null) {
                                this.f13a = dVar.a(this.f22424b, 0);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                return z10;
            }
        }
        z10 = true;
        if (this.f11a == null) {
            this.f11a = context.getSharedPreferences(this.f22424b, 0);
        }
        str = null;
        str = Environment.getExternalStorageState();
        if (!g.m22a(str)) {
        }
        return z10;
        z10 = false;
        if (!str.equals("mounted")) {
        }
        dVar = this.f14a;
        if (dVar != null) {
        }
        return z10;
    }

    public String getString(String str) {
        c();
        SharedPreferences sharedPreferences = this.f11a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!g.m22a(string)) {
                return string;
            }
        }
        b bVar = this.f13a;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void putString(String str, String str2) {
        if (!g.m22a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.f22423a;
            if (editor != null) {
                editor.putString(str, str2);
            }
            b.a aVar = this.f12a;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }
    }

    public void remove(String str) {
        if (!g.m22a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.f22423a;
            if (editor != null) {
                editor.remove(str);
            }
            b.a aVar = this.f12a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m23a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a10;
        if (sharedPreferences != null && bVar != null && (a10 = bVar.a()) != null) {
            a10.b();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    a10.a(key, (String) value);
                } else if (value instanceof Integer) {
                    a10.a(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    a10.a(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    a10.a(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    a10.a(key, ((Boolean) value).booleanValue());
                }
            }
            try {
                a10.commit();
            } catch (Exception unused) {
            }
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (!(bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null)) {
            edit.clear();
            for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
        }
    }
}
