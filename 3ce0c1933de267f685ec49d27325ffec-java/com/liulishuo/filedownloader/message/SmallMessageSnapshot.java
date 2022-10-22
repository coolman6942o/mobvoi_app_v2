package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import n9.a;
/* loaded from: classes2.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    /* loaded from: classes2.dex */
    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedFlowDirectlySnapshot(int i10, boolean z10, int i11) {
            super(i10, z10, i11);
        }
    }

    /* loaded from: classes2.dex */
    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -2;
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnFlowDirectlySnapshot(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }
    }

    /* loaded from: classes2.dex */
    public static class WarnMessageSnapshot extends PendingMessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) -4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    SmallMessageSnapshot(int i10) {
        super(i10);
        this.f15215b = false;
    }

    /* loaded from: classes2.dex */
    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final int f15226c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(int i10, int i11) {
            super(i10);
            this.f15226c = i11;
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
            parcel.writeInt(this.f15226c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15226c = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: e  reason: collision with root package name */
        private final int f15227e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(int i10, int i11, Throwable th2, int i12) {
            super(i10, i11, th2);
            this.f15227e = i12;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15227e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15227e = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15216c;

        /* renamed from: d  reason: collision with root package name */
        private final int f15217d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(int i10, boolean z10, int i11) {
            super(i10);
            this.f15216c = z10;
            this.f15217d = i11;
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
            parcel.writeByte(this.f15216c ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f15217d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f15216c = parcel.readByte() != 0;
            this.f15217d = parcel.readInt();
        }
    }

    /* loaded from: classes2.dex */
    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final int f15222c;

        /* renamed from: d  reason: collision with root package name */
        private final Throwable f15223d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(int i10, int i11, Throwable th2) {
            super(i10);
            this.f15222c = i11;
            this.f15223d = th2;
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
            parcel.writeInt(this.f15222c);
            parcel.writeSerializable(this.f15223d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15222c = parcel.readInt();
            this.f15223d = (Throwable) parcel.readSerializable();
        }
    }

    /* loaded from: classes2.dex */
    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final int f15224c;

        /* renamed from: d  reason: collision with root package name */
        private final int f15225d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(int i10, int i11, int i12) {
            super(i10);
            this.f15224c = i11;
            this.f15225d = i12;
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15224c);
            parcel.writeInt(this.f15225d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15224c = parcel.readInt();
            this.f15225d = parcel.readInt();
        }
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes2.dex */
    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f15218c;

        /* renamed from: d  reason: collision with root package name */
        private final int f15219d;

        /* renamed from: e  reason: collision with root package name */
        private final String f15220e;

        /* renamed from: f  reason: collision with root package name */
        private final String f15221f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(int i10, boolean z10, int i11, String str, String str2) {
            super(i10);
            this.f15218c = z10;
            this.f15219d = i11;
            this.f15220e = str;
            this.f15221f = str2;
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
            parcel.writeByte(this.f15218c ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f15219d);
            parcel.writeString(this.f15220e);
            parcel.writeString(this.f15221f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f15218c = parcel.readByte() != 0;
            this.f15219d = parcel.readInt();
            this.f15220e = parcel.readString();
            this.f15221f = parcel.readString();
        }
    }
}
