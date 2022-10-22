package sp;

import io.m;
import kotlin.jvm.internal.i;
import okio.ByteString;
import okio.c;
/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f35035a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int c(byte[] bArr, int i10) {
        int i11;
        int length = bArr.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        loop0: while (i12 < length) {
            byte b10 = bArr[i12];
            if (b10 >= 0) {
                int i15 = i14 + 1;
                if (i14 == i10) {
                    return i13;
                }
                if (!(b10 == 10 || b10 == 13)) {
                    if ((b10 >= 0 && 31 >= b10) || (Byte.MAX_VALUE <= b10 && 159 >= b10)) {
                        return -1;
                    }
                }
                if (b10 == 65533) {
                    return -1;
                }
                i13 += b10 < 65536 ? 1 : 2;
                i12++;
                while (true) {
                    i14 = i15;
                    if (i12 < length && bArr[i12] >= 0) {
                        i12++;
                        byte b11 = bArr[i12];
                        i15 = i14 + 1;
                        if (i14 == i10) {
                            return i13;
                        }
                        if (!(b11 == 10 || b11 == 13)) {
                            if ((b11 >= 0 && 31 >= b11) || (Byte.MAX_VALUE <= b11 && 159 >= b11)) {
                                break loop0;
                            }
                        }
                        if (b11 == 65533) {
                            break loop0;
                        }
                        i13 += b11 < 65536 ? 1 : 2;
                    }
                }
            } else {
                if ((b10 >> 5) == -2) {
                    int i16 = i12 + 1;
                    if (length > i16) {
                        byte b12 = bArr[i12];
                        byte b13 = bArr[i16];
                        if ((b13 & 192) == 128) {
                            int i17 = (b13 ^ 3968) ^ (b12 << 6);
                            if (i17 >= 128) {
                                i11 = i14 + 1;
                                if (i14 == i10) {
                                    return i13;
                                }
                                if (!(i17 == 10 || i17 == 13)) {
                                    if ((i17 >= 0 && 31 >= i17) || (127 <= i17 && 159 >= i17)) {
                                        return -1;
                                    }
                                }
                                if (i17 == 65533) {
                                    return -1;
                                }
                                i13 += i17 < 65536 ? 1 : 2;
                                m mVar = m.f28349a;
                                i12 += 2;
                            } else if (i14 == i10) {
                                return i13;
                            } else {
                                return -1;
                            }
                        } else if (i14 == i10) {
                            return i13;
                        } else {
                            return -1;
                        }
                    } else if (i14 == i10) {
                        return i13;
                    } else {
                        return -1;
                    }
                } else if ((b10 >> 4) == -2) {
                    int i18 = i12 + 2;
                    if (length > i18) {
                        byte b14 = bArr[i12];
                        byte b15 = bArr[i12 + 1];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i18];
                            if ((b16 & 192) == 128) {
                                int i19 = ((b16 ^ (-123008)) ^ (b15 << 6)) ^ (b14 << 12);
                                if (i19 < 2048) {
                                    if (i14 == i10) {
                                        return i13;
                                    }
                                    return -1;
                                } else if (55296 > i19 || 57343 < i19) {
                                    i11 = i14 + 1;
                                    if (i14 == i10) {
                                        return i13;
                                    }
                                    if (!(i19 == 10 || i19 == 13)) {
                                        if ((i19 >= 0 && 31 >= i19) || (127 <= i19 && 159 >= i19)) {
                                            return -1;
                                        }
                                    }
                                    if (i19 == 65533) {
                                        return -1;
                                    }
                                    i13 += i19 < 65536 ? 1 : 2;
                                    m mVar2 = m.f28349a;
                                    i12 += 3;
                                } else if (i14 == i10) {
                                    return i13;
                                } else {
                                    return -1;
                                }
                            } else if (i14 == i10) {
                                return i13;
                            } else {
                                return -1;
                            }
                        } else if (i14 == i10) {
                            return i13;
                        } else {
                            return -1;
                        }
                    } else if (i14 == i10) {
                        return i13;
                    } else {
                        return -1;
                    }
                } else if ((b10 >> 3) == -2) {
                    int i20 = i12 + 3;
                    if (length > i20) {
                        byte b17 = bArr[i12];
                        byte b18 = bArr[i12 + 1];
                        if ((b18 & 192) == 128) {
                            byte b19 = bArr[i12 + 2];
                            if ((b19 & 192) == 128) {
                                byte b20 = bArr[i20];
                                if ((b20 & 192) == 128) {
                                    int i21 = (((b20 ^ 3678080) ^ (b19 << 6)) ^ (b18 << 12)) ^ (b17 << 18);
                                    if (i21 > 1114111) {
                                        if (i14 == i10) {
                                            return i13;
                                        }
                                        return -1;
                                    } else if (55296 <= i21 && 57343 >= i21) {
                                        if (i14 == i10) {
                                            return i13;
                                        }
                                        return -1;
                                    } else if (i21 >= 65536) {
                                        i11 = i14 + 1;
                                        if (i14 == i10) {
                                            return i13;
                                        }
                                        if (!(i21 == 10 || i21 == 13)) {
                                            if ((i21 >= 0 && 31 >= i21) || (127 <= i21 && 159 >= i21)) {
                                                return -1;
                                            }
                                        }
                                        if (i21 == 65533) {
                                            return -1;
                                        }
                                        i13 += i21 < 65536 ? 1 : 2;
                                        m mVar3 = m.f28349a;
                                        i12 += 4;
                                    } else if (i14 == i10) {
                                        return i13;
                                    } else {
                                        return -1;
                                    }
                                } else if (i14 == i10) {
                                    return i13;
                                } else {
                                    return -1;
                                }
                            } else if (i14 == i10) {
                                return i13;
                            } else {
                                return -1;
                            }
                        } else if (i14 == i10) {
                            return i13;
                        } else {
                            return -1;
                        }
                    } else if (i14 == i10) {
                        return i13;
                    } else {
                        return -1;
                    }
                } else if (i14 == i10) {
                    return i13;
                } else {
                    return -1;
                }
                i14 = i11;
            }
        }
        return i13;
    }

    public static final void d(ByteString commonWrite, c buffer, int i10, int i11) {
        i.f(commonWrite, "$this$commonWrite");
        i.f(buffer, "buffer");
        buffer.e(commonWrite.getData$okio(), i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c10) {
        if ('0' <= c10 && '9' >= c10) {
            return c10 - '0';
        }
        char c11 = 'a';
        if ('a' > c10 || 'f' < c10) {
            c11 = 'A';
            if ('A' > c10 || 'F' < c10) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    public static final char[] f() {
        return f35035a;
    }
}
