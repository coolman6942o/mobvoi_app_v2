package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f32512a;

    public a() {
        this.f32512a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                this.f32512a.add(Array.get(obj, i10));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f32512a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c10;
        Object obj;
        ArrayList arrayList;
        char c11 = cVar.c();
        if (c11 == '[') {
            c10 = ']';
        } else if (c11 == '(') {
            c10 = ')';
        } else {
            throw cVar.a("A JSONArray text must start with '['");
        }
        if (cVar.c() != ']') {
            do {
                cVar.a();
                char c12 = cVar.c();
                cVar.a();
                if (c12 == ',') {
                    arrayList = this.f32512a;
                    obj = null;
                } else {
                    arrayList = this.f32512a;
                    obj = cVar.d();
                }
                arrayList.add(obj);
                char c13 = cVar.c();
                if (c13 != ')') {
                    if (c13 != ',' && c13 != ';') {
                        if (c13 != ']') {
                            throw cVar.a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c10 != c13) {
                    throw cVar.a("Expected a '" + new Character(c10) + "'");
                }
                return;
            } while (cVar.c() != ']');
        }
    }

    private String a(String str) {
        int size = this.f32512a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f32512a.get(i10)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f32512a.size();
    }

    public final Object a(int i10) {
        Object obj = (i10 < 0 || i10 >= this.f32512a.size()) ? null : this.f32512a.get(i10);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i10 + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
