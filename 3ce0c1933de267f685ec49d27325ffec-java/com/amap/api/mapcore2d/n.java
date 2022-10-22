package com.amap.api.mapcore2d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k4.d;
import k4.e;
import k4.f;
import k4.i;
/* compiled from: DBOperation.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends e>, e> f7004d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private i f7005a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f7006b;

    /* renamed from: c  reason: collision with root package name */
    private e f7007c;

    public n(Context context, e eVar) {
        try {
            this.f7005a = new i(context.getApplicationContext(), eVar.a(), null, eVar.b(), eVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f7007c = eVar;
    }

    private ContentValues a(Object obj, o oVar) {
        Field[] n10;
        ContentValues contentValues = new ContentValues();
        for (Field field : n(obj.getClass(), oVar.b())) {
            field.setAccessible(true);
            i(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase b(boolean z10) {
        try {
            if (this.f7006b == null) {
                this.f7006b = this.f7005a.getReadableDatabase();
            }
        } catch (Throwable th2) {
            if (!z10) {
                d.b(th2, "DBOperation", "getReadAbleDataBase");
            } else {
                th2.printStackTrace();
            }
        }
        return this.f7006b;
    }

    private <T> T c(Cursor cursor, Class<T> cls, o oVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] n10 = n(cls, oVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : n10) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(f.class);
            if (annotation != null) {
                f fVar = (f) annotation;
                int b10 = fVar.b();
                int columnIndex = cursor.getColumnIndex(fVar.a());
                switch (b10) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private <T> String d(o oVar) {
        if (oVar == null) {
            return null;
        }
        return oVar.a();
    }

    public static String e(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String str : map.keySet()) {
            if (z10) {
                sb2.append(str);
                sb2.append(" = '");
                sb2.append(map.get(str));
                sb2.append("'");
                z10 = false;
            } else {
                sb2.append(" and ");
                sb2.append(str);
                sb2.append(" = '");
                sb2.append(map.get(str));
                sb2.append("'");
            }
        }
        return sb2.toString();
    }

    public static synchronized e g(Class<? extends e> cls) throws IllegalAccessException, InstantiationException {
        e eVar;
        synchronized (n.class) {
            if (f7004d.get(cls) == null) {
                f7004d.put(cls, cls.newInstance());
            }
            eVar = f7004d.get(cls);
        }
        return eVar;
    }

    private <T> void h(SQLiteDatabase sQLiteDatabase, T t10) {
        ContentValues a10;
        o p10 = p(t10.getClass());
        String d10 = d(p10);
        if (!TextUtils.isEmpty(d10) && sQLiteDatabase != null && (a10 = a(t10, p10)) != null) {
            sQLiteDatabase.insert(d10, null, a10);
        }
    }

    private void i(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(f.class);
        if (annotation != null) {
            f fVar = (f) annotation;
            try {
                switch (fVar.b()) {
                    case 1:
                        contentValues.put(fVar.a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(fVar.a(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(fVar.a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(fVar.a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(fVar.a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(fVar.a(), (String) field.get(obj));
                        break;
                    case 7:
                        contentValues.put(fVar.a(), (byte[]) field.get(obj));
                        break;
                    default:
                        return;
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
    }

    private boolean m(Annotation annotation) {
        return annotation != null;
    }

    private Field[] n(Class<?> cls, boolean z10) {
        if (cls == null) {
            return null;
        }
        if (z10) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase o(boolean z10) {
        try {
            SQLiteDatabase sQLiteDatabase = this.f7006b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f7006b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f7006b = this.f7005a.getWritableDatabase();
            }
        } catch (Throwable th2) {
            d.b(th2, "DBOperation", "getWriteDatabase");
        }
        return this.f7006b;
    }

    private <T> o p(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(o.class);
        if (!m(annotation)) {
            return null;
        }
        return (o) annotation;
    }

    public <T> List<T> f(String str, Class<T> cls, boolean z10) {
        Throwable th2;
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.f7007c) {
            ArrayList arrayList = new ArrayList();
            o p10 = p(cls);
            String d10 = d(p10);
            if (this.f7006b == null) {
                this.f7006b = b(z10);
            }
            if (this.f7006b == null || TextUtils.isEmpty(d10) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f7006b.query(d10, null, str, null, null, null, null);
                try {
                } catch (Throwable th3) {
                    th2 = th3;
                    if (!z10) {
                        d.b(th2, "DataBase", "searchListData");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase = this.f7006b;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            this.f7006b = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (!z10) {
                            str2 = "DataBase";
                            str3 = "searchListData";
                            d.b(th, str2, str3);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th5) {
                th2 = th5;
                cursor = null;
            }
            if (cursor == null) {
                this.f7006b.close();
                this.f7006b = null;
                if (cursor != null) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase2 = this.f7006b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                    this.f7006b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(c(cursor, cls, p10));
            }
            cursor.close();
            try {
                SQLiteDatabase sQLiteDatabase3 = this.f7006b;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                    this.f7006b = null;
                }
            } catch (Throwable th6) {
                th = th6;
                if (!z10) {
                    str2 = "DataBase";
                    str3 = "searchListData";
                    d.b(th, str2, str3);
                }
            }
            return arrayList;
        }
    }

    public <T> void j(T t10, boolean z10) {
        synchronized (this.f7007c) {
            SQLiteDatabase o10 = o(z10);
            this.f7006b = o10;
            if (o10 != null) {
                h(o10, t10);
                SQLiteDatabase sQLiteDatabase = this.f7006b;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    this.f7006b = null;
                }
            }
        }
    }

    public <T> void k(String str, Class<T> cls) {
        synchronized (this.f7007c) {
            String d10 = d(p(cls));
            if (!TextUtils.isEmpty(d10)) {
                SQLiteDatabase o10 = o(false);
                this.f7006b = o10;
                if (o10 != null) {
                    o10.delete(d10, str, null);
                    SQLiteDatabase sQLiteDatabase = this.f7006b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.f7006b = null;
                    }
                }
            }
        }
    }

    public <T> void l(String str, Object obj, boolean z10) {
        synchronized (this.f7007c) {
            if (obj != null) {
                o p10 = p(obj.getClass());
                String d10 = d(p10);
                if (!TextUtils.isEmpty(d10)) {
                    ContentValues a10 = a(obj, p10);
                    if (a10 != null) {
                        SQLiteDatabase o10 = o(z10);
                        this.f7006b = o10;
                        if (o10 != null) {
                            o10.update(d10, a10, str, null);
                            SQLiteDatabase sQLiteDatabase = this.f7006b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.f7006b = null;
                            }
                        }
                    }
                }
            }
        }
    }
}
