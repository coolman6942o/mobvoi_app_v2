package com.google.common.cache;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public abstract class RemovalCause extends Enum<RemovalCause> {
    public static final RemovalCause EXPLICIT = new a("EXPLICIT", 0);
    public static final RemovalCause REPLACED = new RemovalCause("REPLACED", 1) { // from class: com.google.common.cache.RemovalCause.b
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return false;
        }
    };
    public static final RemovalCause COLLECTED = new RemovalCause("COLLECTED", 2) { // from class: com.google.common.cache.RemovalCause.c
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    };
    public static final RemovalCause EXPIRED = new RemovalCause("EXPIRED", 3) { // from class: com.google.common.cache.RemovalCause.d
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    };
    public static final RemovalCause SIZE = new RemovalCause("SIZE", 4) { // from class: com.google.common.cache.RemovalCause.e
        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return true;
        }
    };
    private static final /* synthetic */ RemovalCause[] $VALUES = a();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    final class a extends RemovalCause {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.common.cache.RemovalCause
        boolean b() {
            return false;
        }
    }

    private RemovalCause(String str, int i10) {
    }

    private static /* synthetic */ RemovalCause[] a() {
        return new RemovalCause[]{EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE};
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* synthetic */ RemovalCause(String str, int i10, a aVar) {
        this(str, i10);
    }
}
