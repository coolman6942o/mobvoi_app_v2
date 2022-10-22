package xf;
/* compiled from: PersistentType.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static boolean a(c _this) {
        return _this.getTypeCode() >= 0;
    }

    /* JADX WARN: Incorrect return type in method signature: <Type:Ljava/lang/Enum<TType;>;:Lxf/c;>(Ljava/lang/Class<TType;>;I)TType; */
    public static Enum b(Class cls, int i10) {
        Enum[] enumArr;
        if (i10 < 0) {
            return Enum.valueOf(cls, "Unknown");
        }
        for (Enum r42 : (Enum[]) cls.getEnumConstants()) {
            if (((c) r42).getTypeCode() == i10) {
                return r42;
            }
        }
        return Enum.valueOf(cls, "Unknown");
    }
}
