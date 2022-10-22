package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.download.f;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import r9.c;
import r9.e;
/* compiled from: MessageSnapshotTaker.java */
/* loaded from: classes2.dex */
public class b {
    public static MessageSnapshot a(int i10, File file, boolean z10) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z10) {
                return new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i10, true, length);
            }
            return new LargeMessageSnapshot.CompletedSnapshot(i10, true, length);
        } else if (z10) {
            return new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i10, true, (int) length);
        } else {
            return new SmallMessageSnapshot.CompletedSnapshot(i10, true, (int) length);
        }
    }

    public static MessageSnapshot b(int i10, long j10, Throwable th2) {
        if (j10 > 2147483647L) {
            return new LargeMessageSnapshot.ErrorMessageSnapshot(i10, j10, th2);
        }
        return new SmallMessageSnapshot.ErrorMessageSnapshot(i10, (int) j10, th2);
    }

    public static MessageSnapshot c(int i10, long j10, long j11, boolean z10) {
        if (j11 > 2147483647L) {
            if (z10) {
                return new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i10, j10, j11);
            }
            return new LargeMessageSnapshot.WarnMessageSnapshot(i10, j10, j11);
        } else if (z10) {
            return new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i10, (int) j10, (int) j11);
        } else {
            return new SmallMessageSnapshot.WarnMessageSnapshot(i10, (int) j10, (int) j11);
        }
    }

    public static MessageSnapshot d(byte b10, FileDownloadModel fileDownloadModel, f.a aVar) {
        MessageSnapshot messageSnapshot;
        IllegalStateException illegalStateException;
        int e10 = fileDownloadModel.e();
        if (b10 == -4) {
            throw new IllegalStateException(e.n("please use #catchWarn instead %d", Integer.valueOf(e10)));
        } else if (b10 != -3) {
            if (b10 != -1) {
                if (b10 != 1) {
                    if (b10 == 2) {
                        String d10 = fileDownloadModel.r() ? fileDownloadModel.d() : null;
                        if (fileDownloadModel.p()) {
                            return new LargeMessageSnapshot.ConnectedMessageSnapshot(e10, aVar.c(), fileDownloadModel.k(), fileDownloadModel.b(), d10);
                        }
                        return new SmallMessageSnapshot.ConnectedMessageSnapshot(e10, aVar.c(), (int) fileDownloadModel.k(), fileDownloadModel.b(), d10);
                    } else if (b10 != 3) {
                        if (b10 != 5) {
                            if (b10 == 6) {
                                return new MessageSnapshot.StartedMessageSnapshot(e10);
                            }
                            String n10 = e.n("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b10));
                            c.i(b.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b10));
                            if (aVar.a() != null) {
                                illegalStateException = new IllegalStateException(n10, aVar.a());
                            } else {
                                illegalStateException = new IllegalStateException(n10);
                            }
                            if (fileDownloadModel.p()) {
                                return new LargeMessageSnapshot.ErrorMessageSnapshot(e10, fileDownloadModel.g(), illegalStateException);
                            }
                            return new SmallMessageSnapshot.ErrorMessageSnapshot(e10, (int) fileDownloadModel.g(), illegalStateException);
                        } else if (fileDownloadModel.p()) {
                            messageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(e10, fileDownloadModel.g(), aVar.a(), aVar.b());
                        } else {
                            messageSnapshot = new SmallMessageSnapshot.RetryMessageSnapshot(e10, (int) fileDownloadModel.g(), aVar.a(), aVar.b());
                        }
                    } else if (fileDownloadModel.p()) {
                        return new LargeMessageSnapshot.ProgressMessageSnapshot(e10, fileDownloadModel.g());
                    } else {
                        return new SmallMessageSnapshot.ProgressMessageSnapshot(e10, (int) fileDownloadModel.g());
                    }
                } else if (fileDownloadModel.p()) {
                    return new LargeMessageSnapshot.PendingMessageSnapshot(e10, fileDownloadModel.g(), fileDownloadModel.k());
                } else {
                    return new SmallMessageSnapshot.PendingMessageSnapshot(e10, (int) fileDownloadModel.g(), (int) fileDownloadModel.k());
                }
            } else if (fileDownloadModel.p()) {
                messageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(e10, fileDownloadModel.g(), aVar.a());
            } else {
                messageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(e10, (int) fileDownloadModel.g(), aVar.a());
            }
            return messageSnapshot;
        } else if (fileDownloadModel.p()) {
            return new LargeMessageSnapshot.CompletedSnapshot(e10, false, fileDownloadModel.k());
        } else {
            return new SmallMessageSnapshot.CompletedSnapshot(e10, false, (int) fileDownloadModel.k());
        }
    }
}
