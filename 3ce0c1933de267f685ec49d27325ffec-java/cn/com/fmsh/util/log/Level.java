package cn.com.fmsh.util.log;
/* loaded from: classes.dex */
public enum Level {
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3);
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6243a;

    /* synthetic */ Level(int i10) {
        this.f6243a = i10;
    }

    public static Level instance(int i10) {
        Level[] values;
        for (Level level : values()) {
            if (level.getId() == i10) {
                return level;
            }
        }
        return null;
    }

    public int getId() {
        return this.f6243a;
    }
}
