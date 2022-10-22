package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import n9.a;
/* loaded from: classes2.dex */
public abstract class LargeMessageSnapshot extends MessageSnapshot {

    /* loaded from: classes2.dex */
    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedFlowDirectlySnapshot(int i10, boolean z10, long j10) {
            super(i10, z10, j10);
        }
    }

    /* loaded from: classes2.dex */
    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -2;
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnFlowDirectlySnapshot(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnMessageSnapshot extends PendingMessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    LargeMessageSnapshot(int i10) {
        super(i10);
        this.f15215b = true;
    }

    /* loaded from: classes2.dex */
    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final long f15212c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(int i10, long j10) {
            super(i10);
            this.f15212c = j10;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.f15212c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15212c = parcel.readLong();
        }
    }

    /* loaded from: classes2.dex */
    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: e  reason: collision with root package name */
        private final int f15213e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(int i10, long j10, Throwable th2, int i11) {
            super(i10, j10, th2);
            this.f15213e = i11;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15213e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15213e = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class CompletedSnapshot extends LargeMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15202c;

        /* renamed from: d  reason: collision with root package name */
        private final long f15203d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(int i10, boolean z10, long j10) {
            super(i10);
            this.f15202c = z10;
            this.f15203d = j10;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f15202c ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f15203d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f15202c = parcel.readByte() != 0;
            this.f15203d = parcel.readLong();
        }
    }

    /* loaded from: classes2.dex */
    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final long f15208c;

        /* renamed from: d  reason: collision with root package name */
        private final Throwable f15209d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(int i10, long j10, Throwable th2) {
            super(i10);
            this.f15208c = j10;
            this.f15209d = th2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.f15208c);
            parcel.writeSerializable(this.f15209d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15208c = parcel.readLong();
            this.f15209d = (Throwable) parcel.readSerializable();
        }
    }

    /* loaded from: classes2.dex */
    public static class PendingMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final long f15210c;

        /* renamed from: d  reason: collision with root package name */
        private final long f15211d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(int i10, long j10, long j11) {
            super(i10);
            this.f15210c = j10;
            this.f15211d = j11;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.f15210c);
            parcel.writeLong(this.f15211d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15210c = parcel.readLong();
            this.f15211d = parcel.readLong();
        }
    }

    LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes2.dex */
    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15204c;

        /* renamed from: d  reason: collision with root package name */
        private final long f15205d;

        /* renamed from: e  reason: collision with root package name */
        private final String f15206e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15207f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(int i10, boolean z10, long j10, String str, String str2) {
            super(i10);
            this.f15204c = z10;
            this.f15205d = j10;
            this.f15206e = str;
            this.f15207f = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f15204c ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f15205d);
            parcel.writeString(this.f15206e);
            parcel.writeString(this.f15207f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15204c = parcel.readByte() != 0;
            this.f15205d = parcel.readLong();
            this.f15206e = parcel.readString();
            this.f15207f = parcel.readString();
        }
    }
}
