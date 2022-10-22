package com.mobvoi.wear.ble;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageParser {
    private static final int DATA_SIZE_WARNING_VALUE = 10240;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    static final int HEADER_SIZE = 8;
    static final byte[] MAGIC_HEADER = {-105, -111, -115, -119};
    private static final String TAG = "MessageParser";
    private MessageParserCallback mCallback;
    private long mDiscardedBytes;
    private int mIncomingDataLength;
    private int mMtu;
    private int mParserState = 0;
    private ByteBuffer mReadBuffer = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);

    /* loaded from: classes2.dex */
    public interface MessageParserCallback {
        void onIncomingData(byte[] bArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    @interface ParserState {
        public static final int CONTENT = 2;
        public static final int HEADER = 0;
        public static final int LENGTH = 1;
    }

    public MessageParser(MessageParserCallback messageParserCallback) {
        o.e(messageParserCallback);
        this.mCallback = messageParserCallback;
    }

    long getDiscardedBytes() {
        return this.mDiscardedBytes;
    }

    int getParserState() {
        return this.mParserState;
    }

    public List<byte[]> packetWriteData(byte[] bArr) {
        byte[] bArr2;
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.mMtu, bArr.length + 8);
        ByteBuffer order = ByteBuffer.allocate(min).order(ByteOrder.LITTLE_ENDIAN);
        order.put(MAGIC_HEADER);
        order.putInt(bArr.length);
        int i10 = min - 8;
        order.put(bArr, 0, i10);
        order.flip();
        arrayList.add(order.array());
        order.clear();
        while (i10 < bArr.length) {
            int i11 = this.mMtu;
            if (i10 + i11 < bArr.length) {
                bArr2 = Arrays.copyOfRange(bArr, i10, i11 + i10);
                i10 += this.mMtu;
            } else {
                bArr2 = Arrays.copyOfRange(bArr, i10, bArr.length);
                i10 = bArr.length;
            }
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    public void parseIncomingData(byte[] bArr) {
        boolean z10;
        if (this.mReadBuffer.remaining() >= bArr.length) {
            this.mReadBuffer.put(bArr);
        } else {
            this.mReadBuffer.flip();
            int capacity = this.mReadBuffer.capacity() * 2;
            while (capacity < bArr.length + this.mReadBuffer.remaining()) {
                capacity *= 2;
            }
            k.c(TAG, "enlarge buffer capability to [%d]", Integer.valueOf(capacity));
            ByteBuffer order = ByteBuffer.allocate(capacity).order(ByteOrder.LITTLE_ENDIAN);
            order.put(this.mReadBuffer);
            order.put(bArr);
            this.mReadBuffer = order;
        }
        this.mReadBuffer.flip();
        while (true) {
            if (this.mReadBuffer.remaining() > 0) {
                int i10 = this.mParserState;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            k.f(TAG, "wrong state [%d] found", Integer.valueOf(i10));
                            break;
                        }
                        int remaining = this.mReadBuffer.remaining();
                        int i11 = this.mIncomingDataLength;
                        if (remaining < i11) {
                            break;
                        }
                        byte[] bArr2 = new byte[i11];
                        this.mReadBuffer.get(bArr2);
                        k.c(TAG, "incoming data found: %d", Integer.valueOf(i11));
                        this.mCallback.onIncomingData(bArr2);
                        this.mParserState = 0;
                    } else if (this.mReadBuffer.remaining() < 4) {
                        break;
                    } else {
                        int i12 = this.mReadBuffer.getInt();
                        this.mIncomingDataLength = i12;
                        if (i12 <= 0) {
                            k.f(TAG, "Invalid length=%d", Integer.valueOf(i12));
                            this.mParserState = 0;
                            break;
                        }
                        if (i12 > DATA_SIZE_WARNING_VALUE) {
                            k.s(TAG, "big data found, length=%d, please check", Integer.valueOf(i12));
                        }
                        this.mParserState = 2;
                    }
                } else if (this.mReadBuffer.remaining() < 4) {
                    break;
                } else {
                    int position = this.mReadBuffer.position();
                    while (true) {
                        if (this.mReadBuffer.remaining() < 4) {
                            z10 = false;
                            break;
                        }
                        byte b10 = this.mReadBuffer.get();
                        byte[] bArr3 = MAGIC_HEADER;
                        if (b10 == bArr3[0] && this.mReadBuffer.get() == bArr3[1] && this.mReadBuffer.get() == bArr3[2] && this.mReadBuffer.get() == bArr3[3]) {
                            z10 = true;
                            break;
                        }
                    }
                    int position2 = this.mReadBuffer.position() - position;
                    if (z10) {
                        position2 -= 4;
                    }
                    if (position2 > 0) {
                        k.f(TAG, "%d bytes discarded. header found? %s", Integer.valueOf(position2), Boolean.valueOf(z10));
                        this.mDiscardedBytes += position2;
                    }
                    if (!z10) {
                        k.d(TAG, "No magic header found.");
                        break;
                    }
                    this.mParserState = 1;
                }
            } else {
                break;
            }
        }
        this.mReadBuffer.compact();
    }

    public void reset() {
        this.mParserState = 0;
        this.mReadBuffer.clear();
    }

    public void setMtu(int i10) {
        k.c(TAG, "setMtu: %d", Integer.valueOf(i10));
        this.mMtu = i10;
    }
}
