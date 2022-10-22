package xf;
/* compiled from: ServerType.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class d {
    public static boolean a(e _this) {
        return "".equals(_this.getName());
    }

    /* JADX WARN: Incorrect return type in method signature: <Type:Ljava/lang/Enum<TType;>;:Lxf/e;>(Ljava/lang/Class<TType;>;Ljava/lang/String;)TType; */
    public static Enum b(Class cls, String str) {
        Enum[] enumArr;
        if (str == null || "".equals(str)) {
            return Enum.valueOf(cls, "Unknown");
        }
        for (Enum r42 : (Enum[]) cls.getEnumConstants()) {
            if (((e) r42).getName().equals(str)) {
                return r42;
            }
        }
        return Enum.valueOf(cls, "Unknown");
    }
}
