package com.mobvoi.health.common.data.db;

import java.lang.Enum;
import java.util.List;
import qf.b;
import xf.c;
/* loaded from: classes2.dex */
public interface DbSyncAccessor<Type extends Enum<Type> & c, Data extends b<Type>> {

    /* loaded from: classes2.dex */
    public static class DbException extends RuntimeException {
        public DbException() {
        }

        public DbException(String str) {
            super(str);
        }

        public DbException(String str, Throwable th2) {
            super(str, th2);
        }

        public DbException(Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes2.dex */
    public static class InvalidParamsException extends DbException {
        public InvalidParamsException() {
        }

        public InvalidParamsException(String str) {
            super(str);
        }

        public InvalidParamsException(String str, Throwable th2) {
            super(str, th2);
        }

        public InvalidParamsException(Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes2.dex */
    public static class NotFoundException extends DbException {
        public NotFoundException() {
        }

        public NotFoundException(String str) {
            super(str);
        }

        public NotFoundException(String str, Throwable th2) {
            super(str, th2);
        }

        public NotFoundException(Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes2.dex */
    public static class TimeOverlapException extends DbException {
        public TimeOverlapException() {
        }

        public TimeOverlapException(String str) {
            super(str);
        }

        public TimeOverlapException(String str, Throwable th2) {
            super(str, th2);
        }

        public TimeOverlapException(Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes2.dex */
    public static class UnsupportedOperationException extends DbException {
        public UnsupportedOperationException() {
        }

        public UnsupportedOperationException(String str) {
            super(str);
        }

        public UnsupportedOperationException(String str, Throwable th2) {
            super(str, th2);
        }

        public UnsupportedOperationException(Throwable th2) {
            super(th2);
        }
    }

    void a();

    boolean b(Data data);

    Data d(Data data) throws NullPointerException, InvalidParamsException, TimeOverlapException;

    /* JADX WARN: Incorrect types in method signature: (TType;JJ)V */
    void e(Enum r12, long j10, long j11);

    /* JADX WARN: Incorrect types in method signature: (TType;J)Ljava/util/List<TData;>; */
    List f(Enum r12, long j10);

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/String;TType;JJ)Ljava/util/List<TData;>; */
    List g(String str, String str2, Enum r32, long j10, long j11);

    /* JADX WARN: Incorrect types in method signature: (TType;JJ)Ljava/util/List<TData;>; */
    List h(Enum r12, long j10, long j11);

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TType;JJ)Ljava/util/List<TData;>; */
    List i(String str, Enum r22, long j10, long j11);

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TType;JJ)TData; */
    b j(String str, Enum r22, long j10, long j11);

    void k(List<Data> list);

    String o();
}
