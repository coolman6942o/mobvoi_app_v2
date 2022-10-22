package s3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d {
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r0v3 java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:174)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1632)
    	at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:278)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1632)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.allMatch(ReferencePipeline.java:533)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.resolveIndependentVariables(TypeSearch.java:174)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:63)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:158)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, String str2) {
        Throwable th2;
        Exception e10;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                try {
                    PublicKey b10 = b("RSA", str2);
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(1, b10);
                    byte[] bytes = str.getBytes("UTF-8");
                    int blockSize = cipher.getBlockSize();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int i10 = 0; i10 < bytes.length; i10 += blockSize) {
                        try {
                            byteArrayOutputStream.write(cipher.doFinal(bytes, i10, bytes.length - i10 < blockSize ? bytes.length - i10 : blockSize));
                        } catch (Exception e11) {
                            e10 = e11;
                            a4.d.d(e10);
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return bArr;
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e12) {
                            a4.d.d(e12);
                        }
                    }
                    throw th2;
                }
            } catch (Exception e13) {
                e10 = e13;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th2 = th4;
                if (byteArrayOutputStream2 != null) {
                }
                throw th2;
            }
        } catch (IOException e14) {
            a4.d.d(e14);
        }
        return bArr;
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.d(str2)));
    }
}
