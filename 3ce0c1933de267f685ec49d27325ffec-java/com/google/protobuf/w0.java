package com.google.protobuf;
/* compiled from: TextFormatEscaper.java */
/* loaded from: classes.dex */
final class w0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteString f13382a;

        a(ByteString byteString) {
            this.f13382a = byteString;
        }

        @Override // com.google.protobuf.w0.c
        public byte a(int i10) {
            return this.f13382a.byteAt(i10);
        }

        @Override // com.google.protobuf.w0.c
        public int size() {
            return this.f13382a.size();
        }
    }

    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes.dex */
    static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f13383a;

        b(byte[] bArr) {
            this.f13383a = bArr;
        }

        @Override // com.google.protobuf.w0.c
        public byte a(int i10) {
            return this.f13383a[i10];
        }

        @Override // com.google.protobuf.w0.c
        public int size() {
            return this.f13383a.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes.dex */
    public interface c {
        byte a(int i10);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ByteString byteString) {
        return b(new a(byteString));
    }

    static String b(c cVar) {
        StringBuilder sb2 = new StringBuilder(cVar.size());
        for (int i10 = 0; i10 < cVar.size(); i10++) {
            byte a10 = cVar.a(i10);
            if (a10 == 34) {
                sb2.append("\\\"");
            } else if (a10 == 39) {
                sb2.append("\\'");
            } else if (a10 != 92) {
                switch (a10) {
                    case 7:
                        sb2.append("\\a");
                        continue;
                    case 8:
                        sb2.append("\\b");
                        continue;
                    case 9:
                        sb2.append("\\t");
                        continue;
                    case 10:
                        sb2.append("\\n");
                        continue;
                    case 11:
                        sb2.append("\\v");
                        continue;
                    case 12:
                        sb2.append("\\f");
                        continue;
                    case 13:
                        sb2.append("\\r");
                        continue;
                    default:
                        if (a10 < 32 || a10 > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((a10 >>> 6) & 3) + 48));
                            sb2.append((char) (((a10 >>> 3) & 7) + 48));
                            sb2.append((char) ((a10 & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) a10);
                            continue;
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(byte[] bArr) {
        return b(new b(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
