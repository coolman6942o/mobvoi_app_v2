package com.mobvoi.mcuwatch.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g0;
import com.mobvoi.android.common.utils.b;
import oi.a;
/* loaded from: classes2.dex */
public abstract class AppDataBase extends RoomDatabase {

    /* renamed from: n  reason: collision with root package name */
    private static volatile AppDataBase f19140n;

    public static AppDataBase E() {
        return F(b.e());
    }

    public static AppDataBase F(Context context) {
        if (f19140n == null) {
            synchronized (AppDataBase.class) {
                if (f19140n == null) {
                    f19140n = (AppDataBase) g0.a(context.getApplicationContext(), AppDataBase.class, "watch_lite.db").d();
                }
            }
        }
        return f19140n;
    }

    public abstract a D();
}
