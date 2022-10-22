package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.a;
import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class n extends k {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f12654b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a  reason: collision with root package name */
    private Object f12655a;

    public n(Boolean bool) {
        t(bool);
    }

    private static boolean p(n nVar) {
        Object obj = nVar.f12655a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean r(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f12654b) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f12655a == null) {
            return nVar.f12655a == null;
        }
        if (p(this) && p(nVar)) {
            return m().longValue() == nVar.m().longValue();
        }
        Object obj2 = this.f12655a;
        if (!(obj2 instanceof Number) || !(nVar.f12655a instanceof Number)) {
            return obj2.equals(nVar.f12655a);
        }
        double doubleValue = m().doubleValue();
        double doubleValue2 = nVar.m().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public boolean h() {
        if (o()) {
            return i().booleanValue();
        }
        return Boolean.parseBoolean(n());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f12655a == null) {
            return 31;
        }
        if (p(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.f12655a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    Boolean i() {
        return (Boolean) this.f12655a;
    }

    public double j() {
        return q() ? m().doubleValue() : Double.parseDouble(n());
    }

    public int k() {
        return q() ? m().intValue() : Integer.parseInt(n());
    }

    public long l() {
        return q() ? m().longValue() : Long.parseLong(n());
    }

    public Number m() {
        Object obj = this.f12655a;
        return obj instanceof String ? new LazilyParsedNumber((String) obj) : (Number) obj;
    }

    public String n() {
        if (q()) {
            return m().toString();
        }
        if (o()) {
            return i().toString();
        }
        return (String) this.f12655a;
    }

    public boolean o() {
        return this.f12655a instanceof Boolean;
    }

    public boolean q() {
        return this.f12655a instanceof Number;
    }

    public boolean s() {
        return this.f12655a instanceof String;
    }

    void t(Object obj) {
        if (obj instanceof Character) {
            this.f12655a = String.valueOf(((Character) obj).charValue());
            return;
        }
        a.a((obj instanceof Number) || r(obj));
        this.f12655a = obj;
    }

    public n(Number number) {
        t(number);
    }

    public n(String str) {
        t(str);
    }
}
