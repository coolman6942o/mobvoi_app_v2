package com.mobvoi.apollo.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ApolloDatabase.kt */
/* loaded from: classes2.dex */
public abstract class ApolloDatabase extends RoomDatabase {

    /* renamed from: n  reason: collision with root package name */
    public static final a f15562n = new a(null);

    /* renamed from: o  reason: collision with root package name */
    private static ApolloDatabase f15563o;

    /* compiled from: ApolloDatabase.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ApolloDatabase a(Context context) {
            i.f(context, "context");
            if (ApolloDatabase.f15563o == null) {
                ApolloDatabase.f15563o = (ApolloDatabase) g0.a(context, ApolloDatabase.class, "apollo.db").d();
            }
            ApolloDatabase apolloDatabase = ApolloDatabase.f15563o;
            i.d(apolloDatabase);
            return apolloDatabase;
        }
    }

    public abstract ga.a F();
}
