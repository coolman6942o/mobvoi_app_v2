package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
/* loaded from: classes2.dex */
public abstract class MessageSnapshot implements com.liulishuo.filedownloader.message.a, Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f15214a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f15215b;

    /* loaded from: classes2.dex */
    public static class NoFieldException extends IllegalStateException {
    }

    /* loaded from: classes2.dex */
    public static class StartedMessageSnapshot extends MessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StartedMessageSnapshot(int i10) {
            super(i10);
        }

        @Override // com.liulishuo.filedownloader.message.a
        public byte getStatus() {
            return (byte) 6;
        }

        StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<MessageSnapshot> {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot messageSnapshot;
            MessageSnapshot warnMessageSnapshot;
            boolean z10 = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            if (readByte != -4) {
                if (readByte != -3) {
                    if (readByte != -1) {
                        if (readByte != 1) {
                            if (readByte != 2) {
                                if (readByte != 3) {
                                    if (readByte != 5) {
                                        if (readByte != 6) {
                                            messageSnapshot = null;
                                            if (messageSnapshot == null) {
                                                messageSnapshot.f15215b = z10;
                                                return messageSnapshot;
                                            }
                                            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
                                        }
                                        warnMessageSnapshot = new StartedMessageSnapshot(parcel);
                                    } else if (z10) {
                                        warnMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(parcel);
                                    } else {
                                        warnMessageSnapshot = new SmallMessageSnapshot.RetryMessageSnapshot(parcel);
                                    }
                                } else if (z10) {
                                    warnMessageSnapshot = new LargeMessageSnapshot.ProgressMessageSnapshot(parcel);
                                } else {
                                    warnMessageSnapshot = new SmallMessageSnapshot.ProgressMessageSnapshot(parcel);
                                }
                            } else if (z10) {
                                warnMessageSnapshot = new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel);
                            } else {
                                warnMessageSnapshot = new SmallMessageSnapshot.ConnectedMessageSnapshot(parcel);
                            }
                        } else if (z10) {
                            warnMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(parcel);
                        } else {
                            warnMessageSnapshot = new SmallMessageSnapshot.PendingMessageSnapshot(parcel);
                        }
                    } else if (z10) {
                        warnMessageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(parcel);
                    } else {
                        warnMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(parcel);
                    }
                } else if (z10) {
                    warnMessageSnapshot = new LargeMessageSnapshot.CompletedSnapshot(parcel);
                } else {
                    warnMessageSnapshot = new SmallMessageSnapshot.CompletedSnapshot(parcel);
                }
            } else if (z10) {
                warnMessageSnapshot = new LargeMessageSnapshot.WarnMessageSnapshot(parcel);
            } else {
                warnMessageSnapshot = new SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            }
            messageSnapshot = warnMessageSnapshot;
            if (messageSnapshot == null) {
            }
        }

        /* renamed from: b */
        public MessageSnapshot[] newArray(int i10) {
            return new MessageSnapshot[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(int i10) {
        this.f15214a = i10;
    }

    public int a() {
        return this.f15214a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.f15215b ? (byte) 1 : (byte) 0);
        parcel.writeByte(getStatus());
        parcel.writeInt(this.f15214a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(Parcel parcel) {
        this.f15214a = parcel.readInt();
    }
}
