package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.a;
import b6.i;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.LogCleaner;
import com.tendcloud.tenddata.ab;
import h6.b;
import h6.e;
import j6.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class j5 implements y {

    /* renamed from: a  reason: collision with root package name */
    y1 f9390a;

    /* renamed from: b  reason: collision with root package name */
    d1 f9391b;

    /* renamed from: c  reason: collision with root package name */
    private d0 f9392c;

    /* renamed from: d  reason: collision with root package name */
    private i1 f9393d;

    /* renamed from: e  reason: collision with root package name */
    private f5 f9394e;

    /* renamed from: f  reason: collision with root package name */
    private x f9395f;

    /* renamed from: g  reason: collision with root package name */
    private d2 f9396g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9397h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9398i;

    /* renamed from: j  reason: collision with root package name */
    private long f9399j;

    /* renamed from: k  reason: collision with root package name */
    private List<Runnable> f9400k;

    /* renamed from: l  reason: collision with root package name */
    private int f9401l;

    /* renamed from: m  reason: collision with root package name */
    private int f9402m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9403n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9404o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9405p;

    /* renamed from: q  reason: collision with root package name */
    private FileLock f9406q;

    /* renamed from: r  reason: collision with root package name */
    private FileChannel f9407r;

    /* renamed from: s  reason: collision with root package name */
    private List<Long> f9408s;

    /* renamed from: t  reason: collision with root package name */
    private List<Long> f9409t;

    /* renamed from: u  reason: collision with root package name */
    long f9410u;

    /* JADX WARN: Code restructure failed: missing block: B:71:0x021c, code lost:
        if (r4 != null) goto L17;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04e6 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04fc A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05b5 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05cb A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05e7 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0705 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0717 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0736 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0a66 A[Catch: all -> 0x0a7e, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0a7a A[Catch: all -> 0x0a7e, TRY_ENTER, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x05c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0224 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0230 A[Catch: all -> 0x0a7e, TryCatch #7 {all -> 0x0a7e, blocks: (B:3:0x000b, B:17:0x0076, B:72:0x0220, B:74:0x0224, B:80:0x0230, B:81:0x024b, B:83:0x0255, B:86:0x026f, B:88:0x029e, B:94:0x02b2, B:96:0x02ba, B:98:0x02d9, B:100:0x02eb, B:104:0x0301, B:106:0x0305, B:107:0x030a, B:112:0x031d, B:114:0x0329, B:115:0x0331, B:117:0x0339, B:118:0x0341, B:121:0x034e, B:123:0x0386, B:124:0x03bc, B:127:0x03ee, B:129:0x03f3, B:131:0x03fd, B:133:0x0406, B:135:0x040c, B:136:0x0414, B:137:0x0417, B:140:0x041e, B:143:0x0428, B:145:0x0459, B:147:0x0476, B:150:0x0482, B:153:0x048b, B:156:0x0492, B:158:0x04a5, B:159:0x04b0, B:161:0x04c7, B:163:0x04d1, B:165:0x04d5, B:168:0x04d9, B:170:0x04e6, B:171:0x04f8, B:172:0x04fc, B:173:0x0503, B:175:0x0518, B:176:0x051f, B:177:0x0529, B:179:0x0537, B:181:0x0543, B:183:0x0551, B:186:0x0556, B:187:0x0579, B:188:0x0594, B:189:0x05b0, B:191:0x05b5, B:193:0x05bf, B:194:0x05c5, B:197:0x05cb, B:200:0x05e7, B:201:0x05fd, B:203:0x0619, B:205:0x0632, B:208:0x0642, B:210:0x0655, B:211:0x0664, B:213:0x0668, B:215:0x0672, B:216:0x067f, B:218:0x0683, B:220:0x0689, B:221:0x0698, B:224:0x06ae, B:228:0x06bd, B:230:0x06c7, B:232:0x06d5, B:234:0x06dd, B:236:0x06e1, B:238:0x06e9, B:240:0x06ed, B:243:0x06f7, B:247:0x0705, B:250:0x0717, B:252:0x0736, B:254:0x0740, B:256:0x0750, B:257:0x0786, B:261:0x0796, B:263:0x079d, B:265:0x07a7, B:267:0x07ab, B:269:0x07af, B:271:0x07b3, B:272:0x07bf, B:274:0x07c5, B:276:0x07e0, B:277:0x07e9, B:278:0x0800, B:280:0x081b, B:282:0x0845, B:283:0x0850, B:284:0x0861, B:286:0x0868, B:287:0x0872, B:288:0x0881, B:290:0x0888, B:291:0x0890, B:292:0x0898, B:294:0x089e, B:296:0x08b4, B:297:0x08c8, B:299:0x08cd, B:301:0x08df, B:302:0x08e3, B:304:0x08f3, B:305:0x08f7, B:306:0x08fa, B:308:0x0909, B:309:0x091f, B:311:0x0924, B:313:0x092e, B:315:0x0934, B:321:0x0946, B:323:0x094c, B:324:0x097b, B:326:0x0980, B:328:0x098e, B:331:0x0993, B:332:0x0996, B:334:0x09a0, B:335:0x09a7, B:336:0x09bc, B:337:0x09c5, B:338:0x09dc, B:341:0x09e4, B:342:0x09e9, B:343:0x09f9, B:345:0x0a13, B:346:0x0a2c, B:347:0x0a34, B:350:0x0a45, B:351:0x0a56, B:354:0x0a66, B:360:0x0a7a, B:361:0x0a7d), top: B:373:0x000b, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean D(String str, long j10) {
        Throwable th2;
        List<e6> list;
        boolean z10;
        n5 n5Var;
        h6 h6Var;
        long j11;
        SecureRandom secureRandom;
        h6 h6Var2;
        int i10;
        e6[] e6VarArr;
        n5 n5Var2;
        boolean z11;
        int M;
        int i11;
        q5 q5Var;
        int i12;
        j6[] j6VarArr;
        boolean z12;
        int i13;
        String str2;
        long j12;
        f6[] f6VarArr;
        b1 N;
        String str3;
        Object I;
        Long l10;
        f6[] f6VarArr2;
        boolean z13;
        String str4;
        SQLiteException e10;
        SQLiteDatabase B;
        String str5;
        String str6;
        String[] strArr;
        String str7;
        String str8 = "_lte";
        P().z();
        try {
            Cursor cursor = null;
            n5 n5Var3 = new n5(this, null);
            d0 P = P();
            long j13 = this.f9410u;
            i.k(n5Var3);
            P.e();
            P.w();
            try {
                try {
                    B = P.B();
                    str5 = "";
                    try {
                    } catch (SQLiteException e11) {
                        e10 = e11;
                        str4 = null;
                        P.c().K().c("Data loss. Error selecting raw event. appId", z0.I(str4), e10);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            } catch (SQLiteException e12) {
                e10 = e12;
                cursor = null;
            } catch (Throwable th4) {
                th2 = th4;
                cursor = null;
                if (cursor != null) {
                }
                throw th2;
            }
            if (TextUtils.isEmpty(null)) {
                int i14 = (j13 > (-1L) ? 1 : (j13 == (-1L) ? 0 : -1));
                String[] strArr2 = i14 != 0 ? new String[]{String.valueOf(j13), String.valueOf(j10)} : new String[]{String.valueOf(j10)};
                if (i14 != 0) {
                    str5 = "rowid <= ? and ";
                }
                StringBuilder sb2 = new StringBuilder(str5.length() + 148);
                sb2.append("select app_id, metadata_fingerprint from raw_events where ");
                sb2.append(str5);
                sb2.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                cursor = B.rawQuery(sb2.toString(), strArr2);
                if (cursor.moveToFirst()) {
                    str4 = cursor.getString(0);
                    try {
                        str6 = cursor.getString(1);
                        cursor.close();
                    } catch (SQLiteException e13) {
                        e10 = e13;
                        P.c().K().c("Data loss. Error selecting raw event. appId", z0.I(str4), e10);
                    }
                }
                cursor.close();
                list = n5Var3.f9539c;
                if (list != null && !list.isEmpty()) {
                    z10 = false;
                    if (!z10) {
                        h6 h6Var3 = n5Var3.f9537a;
                        h6Var3.f9327d = new e6[n5Var3.f9539c.size()];
                        boolean z14 = M().z(h6Var3.f9340q);
                        int i15 = 0;
                        int i16 = 0;
                        boolean z15 = false;
                        long j14 = 0;
                        while (i15 < n5Var3.f9539c.size()) {
                            e6 e6Var = n5Var3.f9539c.get(i15);
                            if (Q().K(n5Var3.f9537a.f9340q, e6Var.f9258d)) {
                                z15 = z15;
                                c().N().c("Dropping blacklisted raw event. appId", z0.I(n5Var3.f9537a.f9340q), J().M(e6Var.f9258d));
                                if (!Q().I(n5Var3.f9537a.f9340q) && !Q().J(n5Var3.f9537a.f9340q)) {
                                    z13 = false;
                                    if (!z13 && !"_err".equals(e6Var.f9258d)) {
                                        K().N(n5Var3.f9537a.f9340q, 11, "_ev", e6Var.f9258d, 0);
                                    }
                                    str2 = str8;
                                    i13 = i15;
                                }
                                z13 = true;
                                if (!z13) {
                                    K().N(n5Var3.f9537a.f9340q, 11, "_ev", e6Var.f9258d, 0);
                                }
                                str2 = str8;
                                i13 = i15;
                            } else {
                                boolean z16 = z15;
                                boolean L = Q().L(n5Var3.f9537a.f9340q, e6Var.f9258d);
                                if (!L) {
                                    K();
                                    if (!r5.m0(e6Var.f9258d)) {
                                        str2 = str8;
                                        i13 = i15;
                                        j12 = j14;
                                        z15 = z16;
                                        if (z14 && "_e".equals(e6Var.f9258d)) {
                                            f6VarArr = e6Var.f9257c;
                                            if (!(f6VarArr == null || f6VarArr.length == 0)) {
                                                K();
                                                l10 = (Long) r5.Y(e6Var, "_et");
                                                if (l10 != null) {
                                                    N = c().N();
                                                    str3 = "Engagement event does not include duration. appId";
                                                    I = z0.I(n5Var3.f9537a.f9340q);
                                                    N.d(str3, I);
                                                } else {
                                                    j14 = j12 + l10.longValue();
                                                    i16++;
                                                    h6Var3.f9327d[i16] = e6Var;
                                                }
                                            }
                                            N = c().N();
                                            str3 = "Engagement event does not contain any parameters. appId";
                                            I = z0.I(n5Var3.f9537a.f9340q);
                                            N.d(str3, I);
                                        }
                                        j14 = j12;
                                        i16++;
                                        h6Var3.f9327d[i16] = e6Var;
                                    }
                                }
                                if (e6Var.f9257c == null) {
                                    e6Var.f9257c = new f6[0];
                                }
                                f6[] f6VarArr3 = e6Var.f9257c;
                                int length = f6VarArr3.length;
                                str2 = str8;
                                boolean z17 = false;
                                int i17 = 0;
                                boolean z18 = false;
                                while (true) {
                                    i13 = i15;
                                    if (i17 >= length) {
                                        break;
                                    }
                                    length = length;
                                    f6 f6Var = f6VarArr3[i17];
                                    f6VarArr3 = f6VarArr3;
                                    if ("_c".equals(f6Var.f9274c)) {
                                        f6Var.f9276e = 1L;
                                        z17 = true;
                                    } else if ("_r".equals(f6Var.f9274c)) {
                                        f6Var.f9276e = 1L;
                                        z18 = true;
                                    }
                                    i17++;
                                    i15 = i13;
                                }
                                if (!z17 && L) {
                                    c().R().d("Marking event as conversion", J().M(e6Var.f9258d));
                                    f6[] f6VarArr4 = e6Var.f9257c;
                                    f6[] f6VarArr5 = (f6[]) Arrays.copyOf(f6VarArr4, f6VarArr4.length + 1);
                                    f6 f6Var2 = new f6();
                                    f6Var2.f9274c = "_c";
                                    f6Var2.f9276e = 1L;
                                    f6VarArr5[f6VarArr5.length - 1] = f6Var2;
                                    e6Var.f9257c = f6VarArr5;
                                }
                                if (!z18) {
                                    c().R().d("Marking event as real-time", J().M(e6Var.f9258d));
                                    f6[] f6VarArr6 = e6Var.f9257c;
                                    f6[] f6VarArr7 = (f6[]) Arrays.copyOf(f6VarArr6, f6VarArr6.length + 1);
                                    f6 f6Var3 = new f6();
                                    f6Var3.f9274c = "_r";
                                    f6Var3.f9276e = 1L;
                                    f6VarArr7[f6VarArr7.length - 1] = f6Var3;
                                    e6Var.f9257c = f6VarArr7;
                                }
                                j12 = j14;
                                if (P().H(V(), n5Var3.f9537a.f9340q, false, false, false, false, true).f9244e > M().v(n5Var3.f9537a.f9340q)) {
                                    int i18 = 0;
                                    while (true) {
                                        f6[] f6VarArr8 = e6Var.f9257c;
                                        if (i18 >= f6VarArr8.length) {
                                            break;
                                        } else if ("_r".equals(f6VarArr8[i18].f9274c)) {
                                            f6[] f6VarArr9 = e6Var.f9257c;
                                            int length2 = f6VarArr9.length - 1;
                                            f6[] f6VarArr10 = new f6[length2];
                                            if (i18 > 0) {
                                                System.arraycopy(f6VarArr9, 0, f6VarArr10, 0, i18);
                                            }
                                            if (i18 < length2) {
                                                System.arraycopy(e6Var.f9257c, i18 + 1, f6VarArr10, i18, length2 - i18);
                                            }
                                            e6Var.f9257c = f6VarArr10;
                                        } else {
                                            i18++;
                                        }
                                    }
                                    z15 = z16;
                                } else {
                                    z15 = true;
                                }
                                if (r5.d0(e6Var.f9258d) && L && P().H(V(), n5Var3.f9537a.f9340q, false, false, true, false, false).f9242c > M().E(n5Var3.f9537a.f9340q, p0.f9574p)) {
                                    c().N().d("Too many conversions. Not logging as conversion. appId", z0.I(n5Var3.f9537a.f9340q));
                                    f6 f6Var4 = null;
                                    boolean z19 = false;
                                    for (f6 f6Var5 : e6Var.f9257c) {
                                        if ("_c".equals(f6Var5.f9274c)) {
                                            f6Var4 = f6Var5;
                                        } else if ("_err".equals(f6Var5.f9274c)) {
                                            z19 = true;
                                        }
                                    }
                                    if (z19 && f6Var4 != null) {
                                        e6Var.f9257c = (f6[]) b.c(e6Var.f9257c, f6Var4);
                                    } else if (f6Var4 != null) {
                                        f6Var4.f9274c = "_err";
                                        f6Var4.f9276e = 10L;
                                    } else {
                                        c().K().d("Did not find conversion parameter. appId", z0.I(n5Var3.f9537a.f9340q));
                                    }
                                }
                                if (z14) {
                                    f6VarArr = e6Var.f9257c;
                                    if (f6VarArr == null) {
                                        K();
                                        l10 = (Long) r5.Y(e6Var, "_et");
                                        if (l10 != null) {
                                        }
                                    }
                                    N = c().N();
                                    str3 = "Engagement event does not contain any parameters. appId";
                                    I = z0.I(n5Var3.f9537a.f9340q);
                                    N.d(str3, I);
                                }
                                j14 = j12;
                                i16++;
                                h6Var3.f9327d[i16] = e6Var;
                            }
                            i15 = i13 + 1;
                            str8 = str2;
                        }
                        String str9 = str8;
                        boolean z20 = z15;
                        long j15 = j14;
                        if (i16 < n5Var3.f9539c.size()) {
                            h6Var3.f9327d = (e6[]) Arrays.copyOf(h6Var3.f9327d, i16);
                        }
                        if (z14) {
                            q5 o02 = P().o0(h6Var3.f9340q, str9);
                            if (!(o02 == null || o02.f9617e == null)) {
                                q5Var = new q5(h6Var3.f9340q, CameraConfig.CAMERA_FOCUS_AUTO, "_lte", b().b(), Long.valueOf(((Long) o02.f9617e).longValue() + j15));
                                j6 j6Var = new j6();
                                j6Var.f9413d = str9;
                                j6Var.f9412c = Long.valueOf(b().b());
                                j6Var.f9415f = (Long) q5Var.f9617e;
                                i12 = 0;
                                while (true) {
                                    j6VarArr = h6Var3.f9328e;
                                    if (i12 < j6VarArr.length) {
                                        z12 = false;
                                        break;
                                    } else if (str9.equals(j6VarArr[i12].f9413d)) {
                                        h6Var3.f9328e[i12] = j6Var;
                                        z12 = true;
                                        break;
                                    } else {
                                        i12++;
                                    }
                                }
                                if (!z12) {
                                    j6[] j6VarArr2 = h6Var3.f9328e;
                                    j6[] j6VarArr3 = (j6[]) Arrays.copyOf(j6VarArr2, j6VarArr2.length + 1);
                                    h6Var3.f9328e = j6VarArr3;
                                    j6VarArr3[n5Var3.f9537a.f9328e.length - 1] = j6Var;
                                }
                                if (j15 > 0) {
                                    P().T(q5Var);
                                    c().Q().d("Updated lifetime engagement user property with value. Value", q5Var.f9617e);
                                }
                            }
                            q5Var = new q5(h6Var3.f9340q, CameraConfig.CAMERA_FOCUS_AUTO, "_lte", b().b(), Long.valueOf(j15));
                            j6 j6Var2 = new j6();
                            j6Var2.f9413d = str9;
                            j6Var2.f9412c = Long.valueOf(b().b());
                            j6Var2.f9415f = (Long) q5Var.f9617e;
                            i12 = 0;
                            while (true) {
                                j6VarArr = h6Var3.f9328e;
                                if (i12 < j6VarArr.length) {
                                }
                                i12++;
                            }
                            if (!z12) {
                            }
                            if (j15 > 0) {
                            }
                        }
                        h6Var3.C = o(h6Var3.f9340q, h6Var3.f9328e, h6Var3.f9327d);
                        if (M().y(n5Var3.f9537a.f9340q)) {
                            HashMap hashMap = new HashMap();
                            e6[] e6VarArr2 = new e6[h6Var3.f9327d.length];
                            SecureRandom y02 = K().y0();
                            e6[] e6VarArr3 = h6Var3.f9327d;
                            int length3 = e6VarArr3.length;
                            int i19 = 0;
                            int i20 = 0;
                            while (i19 < length3) {
                                e6 e6Var2 = e6VarArr3[i19];
                                if (e6Var2.f9258d.equals("_ep")) {
                                    K();
                                    String str10 = (String) r5.Y(e6Var2, "_en");
                                    l0 l0Var = (l0) hashMap.get(str10);
                                    if (l0Var == null) {
                                        l0Var = P().m0(n5Var3.f9537a.f9340q, str10);
                                        hashMap.put(str10, l0Var);
                                    }
                                    if (l0Var.f9476g == null) {
                                        if (l0Var.f9477h.longValue() > 1) {
                                            K();
                                            e6Var2.f9257c = r5.X(e6Var2.f9257c, "_sr", l0Var.f9477h);
                                        }
                                        Boolean bool = l0Var.f9478i;
                                        if (bool != null && bool.booleanValue()) {
                                            K();
                                            e6Var2.f9257c = r5.X(e6Var2.f9257c, "_efs", 1L);
                                        }
                                        i20++;
                                        e6VarArr2[i20] = e6Var2;
                                        n5Var2 = n5Var3;
                                        h6Var2 = h6Var3;
                                        secureRandom = y02;
                                    } else {
                                        n5Var2 = n5Var3;
                                        h6Var2 = h6Var3;
                                        secureRandom = y02;
                                    }
                                    e6VarArr = e6VarArr3;
                                    i10 = length3;
                                } else {
                                    Long l11 = 1L;
                                    if (!TextUtils.isEmpty("_dbg") && l11 != null) {
                                        f6[] f6VarArr11 = e6Var2.f9257c;
                                        e6VarArr = e6VarArr3;
                                        int length4 = f6VarArr11.length;
                                        i10 = length3;
                                        int i21 = 0;
                                        while (true) {
                                            if (i21 >= length4) {
                                                break;
                                            }
                                            length4 = length4;
                                            f6 f6Var6 = f6VarArr11[i21];
                                            f6VarArr11 = f6VarArr11;
                                            if (!"_dbg".equals(f6Var6.f9274c)) {
                                                i21++;
                                            } else if (l11.equals(f6Var6.f9276e) || (((l11 instanceof String) && l11.equals(f6Var6.f9275d)) || ((l11 instanceof Double) && l11.equals(f6Var6.f9278g)))) {
                                                z11 = true;
                                            }
                                        }
                                        z11 = false;
                                        M = z11 ? Q().M(n5Var3.f9537a.f9340q, e6Var2.f9258d) : 1;
                                        if (M > 0) {
                                            c().N().c("Sample rate must be positive. event, rate", e6Var2.f9258d, Integer.valueOf(M));
                                            i11 = i20 + 1;
                                            e6VarArr2[i20] = e6Var2;
                                        } else {
                                            l0 l0Var2 = (l0) hashMap.get(e6Var2.f9258d);
                                            if (l0Var2 == null && (l0Var2 = P().m0(n5Var3.f9537a.f9340q, e6Var2.f9258d)) == null) {
                                                c().N().c("Event being bundled has no eventAggregate. appId, eventName", n5Var3.f9537a.f9340q, e6Var2.f9258d);
                                                l0Var2 = new l0(n5Var3.f9537a.f9340q, e6Var2.f9258d, 1L, 1L, e6Var2.f9259e.longValue(), 0L, null, null, null);
                                            }
                                            K();
                                            Long l12 = (Long) r5.Y(e6Var2, "_eid");
                                            Boolean valueOf = Boolean.valueOf(l12 != null);
                                            if (M == 1) {
                                                i11 = i20 + 1;
                                                e6VarArr2[i20] = e6Var2;
                                                if (valueOf.booleanValue() && !(l0Var2.f9476g == null && l0Var2.f9477h == null && l0Var2.f9478i == null)) {
                                                    hashMap.put(e6Var2.f9258d, l0Var2.a(null, null, null));
                                                }
                                            } else if (y02.nextInt(M) == 0) {
                                                K();
                                                secureRandom = y02;
                                                long j16 = M;
                                                e6Var2.f9257c = r5.X(e6Var2.f9257c, "_sr", Long.valueOf(j16));
                                                i20++;
                                                e6VarArr2[i20] = e6Var2;
                                                if (valueOf.booleanValue()) {
                                                    l0Var2 = l0Var2.a(null, Long.valueOf(j16), null);
                                                }
                                                hashMap.put(e6Var2.f9258d, l0Var2.c(e6Var2.f9259e.longValue()));
                                                n5Var2 = n5Var3;
                                                h6Var2 = h6Var3;
                                            } else {
                                                h6Var2 = h6Var3;
                                                secureRandom = y02;
                                                n5 n5Var4 = n5Var3;
                                                if (Math.abs(e6Var2.f9259e.longValue() - l0Var2.f9475f) >= LogCleaner.ONE_DAY) {
                                                    K();
                                                    e6Var2.f9257c = r5.X(e6Var2.f9257c, "_efs", 1L);
                                                    K();
                                                    n5Var2 = n5Var4;
                                                    long j17 = M;
                                                    e6Var2.f9257c = r5.X(e6Var2.f9257c, "_sr", Long.valueOf(j17));
                                                    i20++;
                                                    e6VarArr2[i20] = e6Var2;
                                                    if (valueOf.booleanValue()) {
                                                        l0Var2 = l0Var2.a(null, Long.valueOf(j17), Boolean.TRUE);
                                                    }
                                                    hashMap.put(e6Var2.f9258d, l0Var2.c(e6Var2.f9259e.longValue()));
                                                } else {
                                                    n5Var2 = n5Var4;
                                                    if (valueOf.booleanValue()) {
                                                        hashMap.put(e6Var2.f9258d, l0Var2.a(l12, null, null));
                                                    }
                                                }
                                            }
                                        }
                                        n5Var2 = n5Var3;
                                        h6Var2 = h6Var3;
                                        secureRandom = y02;
                                        i20 = i11;
                                    }
                                    e6VarArr = e6VarArr3;
                                    i10 = length3;
                                    z11 = false;
                                    if (z11) {
                                    }
                                    if (M > 0) {
                                    }
                                    n5Var2 = n5Var3;
                                    h6Var2 = h6Var3;
                                    secureRandom = y02;
                                    i20 = i11;
                                }
                                i19++;
                                n5Var3 = n5Var2;
                                e6VarArr3 = e6VarArr;
                                length3 = i10;
                                h6Var3 = h6Var2;
                                y02 = secureRandom;
                            }
                            n5Var = n5Var3;
                            h6Var = h6Var3;
                            if (i20 < h6Var.f9327d.length) {
                                h6Var.f9327d = (e6[]) Arrays.copyOf(e6VarArr2, i20);
                            }
                            for (Map.Entry entry : hashMap.entrySet()) {
                                P().M((l0) entry.getValue());
                            }
                        } else {
                            n5Var = n5Var3;
                            h6Var = h6Var3;
                        }
                        h6Var.f9330g = Long.MAX_VALUE;
                        h6Var.f9331h = Long.MIN_VALUE;
                        int i22 = 0;
                        while (true) {
                            e6[] e6VarArr4 = h6Var.f9327d;
                            if (i22 >= e6VarArr4.length) {
                                break;
                            }
                            e6 e6Var3 = e6VarArr4[i22];
                            if (e6Var3.f9259e.longValue() < h6Var.f9330g.longValue()) {
                                h6Var.f9330g = e6Var3.f9259e;
                            }
                            if (e6Var3.f9259e.longValue() > h6Var.f9331h.longValue()) {
                                h6Var.f9331h = e6Var3.f9259e;
                            }
                            i22++;
                        }
                        n5 n5Var5 = n5Var;
                        String str11 = n5Var5.f9537a.f9340q;
                        v f02 = P().f0(str11);
                        if (f02 == null) {
                            c().K().d("Bundling raw events w/o app info. appId", z0.I(n5Var5.f9537a.f9340q));
                        } else if (h6Var.f9327d.length > 0) {
                            long u10 = f02.u();
                            h6Var.f9333j = u10 != 0 ? Long.valueOf(u10) : null;
                            long t10 = f02.t();
                            if (t10 != 0) {
                                u10 = t10;
                            }
                            h6Var.f9332i = u10 != 0 ? Long.valueOf(u10) : null;
                            f02.C();
                            h6Var.f9348y = Integer.valueOf((int) f02.z());
                            f02.O(h6Var.f9330g.longValue());
                            f02.P(h6Var.f9331h.longValue());
                            h6Var.f9349z = f02.K();
                            P().L(f02);
                        }
                        if (h6Var.f9327d.length > 0) {
                            b6 E = Q().E(n5Var5.f9537a.f9340q);
                            if (E != null) {
                                j11 = E.f9184c;
                                if (j11 == null) {
                                }
                                h6Var.I = j11;
                                P().U(h6Var, z20);
                            }
                            if (TextUtils.isEmpty(n5Var5.f9537a.A)) {
                                j11 = -1L;
                                h6Var.I = j11;
                                P().U(h6Var, z20);
                            } else {
                                c().N().d("Did not find measurement config or missing version info. appId", z0.I(n5Var5.f9537a.f9340q));
                                P().U(h6Var, z20);
                            }
                        }
                        d0 P2 = P();
                        List<Long> list2 = n5Var5.f9538b;
                        i.k(list2);
                        P2.e();
                        P2.w();
                        StringBuilder sb3 = new StringBuilder("rowid in (");
                        for (int i23 = 0; i23 < list2.size(); i23++) {
                            if (i23 != 0) {
                                sb3.append(",");
                            }
                            sb3.append(list2.get(i23).longValue());
                        }
                        sb3.append(")");
                        int delete = P2.B().delete("raw_events", sb3.toString(), null);
                        if (delete != list2.size()) {
                            P2.c().K().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list2.size()));
                        }
                        d0 P3 = P();
                        try {
                            P3.B().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str11, str11});
                        } catch (SQLiteException e14) {
                            P3.c().K().c("Failed to remove unused event metadata. appId", z0.I(str11), e14);
                        }
                        P().C();
                        P().A();
                        return true;
                    }
                    P().C();
                    P().A();
                    return false;
                }
                z10 = true;
                if (!z10) {
                }
            } else {
                int i24 = (j13 > (-1L) ? 1 : (j13 == (-1L) ? 0 : -1));
                String[] strArr3 = i24 != 0 ? new String[]{null, String.valueOf(j13)} : new String[]{null};
                if (i24 != 0) {
                    str5 = " and rowid <= ?";
                }
                StringBuilder sb4 = new StringBuilder(str5.length() + 84);
                sb4.append("select metadata_fingerprint from raw_events where app_id = ?");
                sb4.append(str5);
                sb4.append(" order by rowid limit 1;");
                cursor = B.rawQuery(sb4.toString(), strArr3);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    list = n5Var3.f9539c;
                    if (list != null) {
                        z10 = false;
                        if (!z10) {
                        }
                    }
                    z10 = true;
                    if (!z10) {
                    }
                } else {
                    str6 = cursor.getString(0);
                    cursor.close();
                    str4 = null;
                }
            }
            cursor = B.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str4, str6}, null, null, "rowid", "2");
            if (!cursor.moveToFirst()) {
                P.c().K().d("Raw event metadata record is missing. appId", z0.I(str4));
            } else {
                byte[] blob = cursor.getBlob(0);
                g c10 = g.c(blob, 0, blob.length);
                h6 h6Var4 = new h6();
                try {
                    h6Var4.c(c10);
                    if (cursor.moveToNext()) {
                        P.c().N().d("Get multiple raw event metadata records, expected one. appId", z0.I(str4));
                    }
                    cursor.close();
                    n5Var3.b(h6Var4);
                    if (j13 != -1) {
                        str7 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{str4, str6, String.valueOf(j13)};
                    } else {
                        str7 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{str4, str6};
                    }
                    cursor = B.query("raw_events", new String[]{"rowid", ContactConstant.CallsRecordKeys.NAME, "timestamp", "data"}, str7, strArr, null, null, "rowid", null);
                    if (!cursor.moveToFirst()) {
                        P.c().N().d("Raw event data disappeared while in transaction. appId", z0.I(str4));
                    } else {
                        do {
                            long j18 = cursor.getLong(0);
                            byte[] blob2 = cursor.getBlob(3);
                            g c11 = g.c(blob2, 0, blob2.length);
                            e6 e6Var4 = new e6();
                            try {
                                e6Var4.c(c11);
                                e6Var4.f9258d = cursor.getString(1);
                                e6Var4.f9259e = Long.valueOf(cursor.getLong(2));
                                if (!n5Var3.a(j18, e6Var4)) {
                                    break;
                                }
                            } catch (IOException e15) {
                                P.c().K().c("Data loss. Failed to merge raw event. appId", z0.I(str4), e15);
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (IOException e16) {
                    P.c().K().c("Data loss. Failed to merge raw event metadata. appId", z0.I(str4), e16);
                }
            }
            cursor.close();
            list = n5Var3.f9539c;
            if (list != null) {
            }
            z10 = true;
            if (!z10) {
            }
        } catch (Throwable th5) {
            P().A();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v H(zzdz zzdzVar) {
        boolean z10;
        long j10;
        String str;
        p();
        U();
        i.k(zzdzVar);
        i.g(zzdzVar.f9859a);
        v f02 = P().f0(zzdzVar.f9859a);
        String C = L().C(zzdzVar.f9859a);
        boolean z11 = true;
        if (f02 == null) {
            f02 = new v(this.f9396g, zzdzVar.f9859a);
            f02.i(this.f9396g.p0().D());
            f02.k(C);
        } else if (!C.equals(f02.r())) {
            f02.k(C);
            f02.i(this.f9396g.p0().D());
        } else {
            z10 = false;
            if (!TextUtils.isEmpty(zzdzVar.f9860b) && !zzdzVar.f9860b.equals(f02.b())) {
                f02.j(zzdzVar.f9860b);
                z10 = true;
            }
            if (!TextUtils.isEmpty(zzdzVar.f9869k) && !zzdzVar.f9869k.equals(f02.s())) {
                f02.l(zzdzVar.f9869k);
                z10 = true;
            }
            j10 = zzdzVar.f9863e;
            if (!(j10 == 0 || j10 == f02.x())) {
                f02.R(zzdzVar.f9863e);
                z10 = true;
            }
            if (!TextUtils.isEmpty(zzdzVar.f9861c) && !zzdzVar.f9861c.equals(f02.g())) {
                f02.d(zzdzVar.f9861c);
                z10 = true;
            }
            if (zzdzVar.f9868j != f02.v()) {
                f02.Q(zzdzVar.f9868j);
                z10 = true;
            }
            str = zzdzVar.f9862d;
            if (str != null && !str.equals(f02.w())) {
                f02.m(zzdzVar.f9862d);
                z10 = true;
            }
            if (zzdzVar.f9864f != f02.y()) {
                f02.S(zzdzVar.f9864f);
                z10 = true;
            }
            if (zzdzVar.f9866h != f02.c()) {
                f02.e(zzdzVar.f9866h);
                z10 = true;
            }
            if (!TextUtils.isEmpty(zzdzVar.f9865g) && !zzdzVar.f9865g.equals(f02.J())) {
                f02.n(zzdzVar.f9865g);
                z10 = true;
            }
            if (zzdzVar.f9870l != f02.L()) {
                f02.f(zzdzVar.f9870l);
                z10 = true;
            }
            if (zzdzVar.f9873o != f02.M()) {
                f02.o(zzdzVar.f9873o);
                z10 = true;
            }
            if (zzdzVar.f9874p == f02.N()) {
                f02.p(zzdzVar.f9874p);
            } else {
                z11 = z10;
            }
            if (z11) {
                P().L(f02);
            }
            return f02;
        }
        z10 = true;
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            f02.j(zzdzVar.f9860b);
            z10 = true;
        }
        if (!TextUtils.isEmpty(zzdzVar.f9869k)) {
            f02.l(zzdzVar.f9869k);
            z10 = true;
        }
        j10 = zzdzVar.f9863e;
        if (j10 == 0) {
            f02.R(zzdzVar.f9863e);
            z10 = true;
        }
        if (!TextUtils.isEmpty(zzdzVar.f9861c)) {
            f02.d(zzdzVar.f9861c);
            z10 = true;
        }
        if (zzdzVar.f9868j != f02.v()) {
        }
        str = zzdzVar.f9862d;
        if (str != null) {
            f02.m(zzdzVar.f9862d);
            z10 = true;
        }
        if (zzdzVar.f9864f != f02.y()) {
        }
        if (zzdzVar.f9866h != f02.c()) {
        }
        if (!TextUtils.isEmpty(zzdzVar.f9865g)) {
            f02.n(zzdzVar.f9865g);
            z10 = true;
        }
        if (zzdzVar.f9870l != f02.L()) {
        }
        if (zzdzVar.f9873o != f02.M()) {
        }
        if (zzdzVar.f9874p == f02.N()) {
        }
        if (z11) {
        }
        return f02;
    }

    private final y1 Q() {
        j(this.f9390a);
        return this.f9390a;
    }

    private final i1 S() {
        i1 i1Var = this.f9393d;
        if (i1Var != null) {
            return i1Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final f5 T() {
        j(this.f9394e);
        return this.f9394e;
    }

    private final long V() {
        long b10 = b().b();
        k1 L = L();
        L.u();
        L.e();
        long a10 = L.f9436i.a();
        if (a10 == 0) {
            a10 = 1 + L.p().y0().nextInt(86400000);
            L.f9436i.b(a10);
        }
        return ((((b10 + a10) / 1000) / 60) / 60) / 24;
    }

    private final boolean X() {
        p();
        U();
        return P().u0() || !TextUtils.isEmpty(P().p0());
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Y() {
        q0<Long> q0Var;
        long j10;
        p();
        U();
        if (c0()) {
            if (this.f9399j > 0) {
                long abs = LogCleaner.ONE_HOUR - Math.abs(b().c() - this.f9399j);
                if (abs > 0) {
                    c().R().d("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    S().a();
                    T().z();
                    return;
                }
                this.f9399j = 0L;
            }
            if (!this.f9396g.C0() || !X()) {
                c().R().a("Nothing to upload or uploading impossible");
                S().a();
                T().z();
                return;
            }
            long b10 = b().b();
            long max = Math.max(0L, p0.C.a().longValue());
            boolean z10 = P().v0() || P().q0();
            if (z10) {
                String M = M().M();
                q0Var = (TextUtils.isEmpty(M) || ".none.".equals(M)) ? p0.f9581w : p0.f9582x;
            } else {
                q0Var = p0.f9580v;
            }
            long max2 = Math.max(0L, q0Var.a().longValue());
            long a10 = L().f9432e.a();
            long a11 = L().f9433f.a();
            long max3 = Math.max(P().s0(), P().t0());
            if (max3 != 0) {
                long abs2 = b10 - Math.abs(max3 - b10);
                long abs3 = b10 - Math.abs(a10 - b10);
                long abs4 = b10 - Math.abs(a11 - b10);
                long max4 = Math.max(abs3, abs4);
                j10 = abs2 + max;
                if (z10 && max4 > 0) {
                    j10 = Math.min(abs2, max4) + max2;
                }
                if (!K().O(max4, max2)) {
                    j10 = max4 + max2;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    for (int i10 = 0; i10 < Math.min(20, Math.max(0, p0.E.a().intValue())); i10++) {
                        j10 += Math.max(0L, p0.D.a().longValue()) * (1 << i10);
                        if (j10 > abs4) {
                            break;
                        }
                    }
                }
                if (j10 != 0) {
                    c().R().a("Next upload time is 0");
                    S().a();
                    T().z();
                    return;
                } else if (!R().C()) {
                    c().R().a("No network");
                    S().c();
                    T().z();
                    return;
                } else {
                    long a12 = L().f9434g.a();
                    long max5 = Math.max(0L, p0.f9578t.a().longValue());
                    if (!K().O(a12, max5)) {
                        j10 = Math.max(j10, a12 + max5);
                    }
                    S().a();
                    long b11 = j10 - b().b();
                    if (b11 <= 0) {
                        b11 = Math.max(0L, p0.f9583y.a().longValue());
                        L().f9432e.b(b().b());
                    }
                    c().R().d("Upload scheduled in approximately ms", Long.valueOf(b11));
                    T().C(b11);
                    return;
                }
            }
            j10 = 0;
            if (j10 != 0) {
            }
        }
    }

    private final void Z() {
        p();
        if (this.f9403n || this.f9404o || this.f9405p) {
            c().R().b("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f9403n), Boolean.valueOf(this.f9404o), Boolean.valueOf(this.f9405p));
            return;
        }
        c().R().a("Stopping uploading service(s)");
        List<Runnable> list = this.f9400k;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.f9400k.clear();
        }
    }

    private final boolean a0() {
        String str;
        b1 b1Var;
        Object e10;
        p();
        try {
            FileChannel channel = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f9407r = channel;
            FileLock tryLock = channel.tryLock();
            this.f9406q = tryLock;
            if (tryLock != null) {
                c().R().a("Storage concurrent access okay");
                return true;
            }
            c().K().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e11) {
            e10 = e11;
            b1Var = c().K();
            str = "Failed to acquire storage lock";
            b1Var.d(str, e10);
            return false;
        } catch (IOException e12) {
            e10 = e12;
            b1Var = c().K();
            str = "Failed to access storage lock file";
            b1Var.d(str, e10);
            return false;
        }
    }

    private final boolean c0() {
        p();
        U();
        return this.f9398i;
    }

    private final int e(FileChannel fileChannel) {
        p();
        if (fileChannel == null || !fileChannel.isOpen()) {
            c().K().a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    c().N().d("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e10) {
            c().K().d("Failed to read from channel", e10);
            return 0;
        }
    }

    private final zzdz g(Context context, String str, String str2, boolean z10, boolean z11, boolean z12, long j10) {
        String str3;
        String str4;
        int i10;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            c().K().a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str3 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            c().K().d("Error retrieving installer package name. appId", z0.I(str));
            str3 = "Unknown";
        }
        if (str3 == null) {
            str3 = "manual_install";
        } else if ("com.android.vending".equals(str3)) {
            str3 = "";
        }
        String str5 = str3;
        try {
            PackageInfo d10 = c.a(context).d(str, 0);
            if (d10 != null) {
                CharSequence c10 = c.a(context).c(str);
                if (!TextUtils.isEmpty(c10)) {
                    c10.toString();
                }
                str4 = d10.versionName;
                i10 = d10.versionCode;
            } else {
                i10 = Integer.MIN_VALUE;
                str4 = "Unknown";
            }
            long j11 = 0;
            if (M().F(str)) {
                j11 = j10;
            }
            return new zzdz(str, str2, str4, i10, str5, 12451L, K().n0(context, str), (String) null, z10, false, "", 0L, j11, 0, z11, z12, false);
        } catch (PackageManager.NameNotFoundException unused2) {
            c().K().c("Error retrieving newly installed package info. appId, appName", z0.I(str), "Unknown");
            return null;
        }
    }

    private static void j(i5 i5Var) {
        if (i5Var == null) {
            throw new IllegalStateException("Upload component not created");
        } else if (!i5Var.v()) {
            String valueOf = String.valueOf(i5Var.getClass());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
            sb2.append("Component not initialized: ");
            sb2.append(valueOf);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private final boolean l(int i10, FileChannel fileChannel) {
        p();
        if (fileChannel == null || !fileChannel.isOpen()) {
            c().K().a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i10);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                c().K().d("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e10) {
            c().K().d("Failed to write to channel", e10);
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:19|(1:21)(1:22)|23|(2:25|(3:27|33|(1:35)))|28|37|29|32|33|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ef, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f0, code lost:
        r0.c().K().c("Error pruning currencies. appId", com.google.android.gms.internal.measurement.z0.I(r14), r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m(String str, zzeu zzeuVar) {
        long j10;
        q5 q5Var;
        String I0 = zzeuVar.f9889b.I0("currency");
        if ("ecommerce_purchase".equals(zzeuVar.f9888a)) {
            double doubleValue = zzeuVar.f9889b.K0(HealthDataProviderContracts.NAME_VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = zzeuVar.f9889b.H0(HealthDataProviderContracts.NAME_VALUE).longValue() * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                c().N().c("Data lost. Currency value is too big. appId", z0.I(str), Double.valueOf(doubleValue));
                return false;
            }
            j10 = Math.round(doubleValue);
        } else {
            j10 = zzeuVar.f9889b.H0(HealthDataProviderContracts.NAME_VALUE).longValue();
        }
        if (!TextUtils.isEmpty(I0)) {
            String upperCase = I0.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String concat = upperCase.length() != 0 ? "_ltv_".concat(upperCase) : new String("_ltv_");
                q5 o02 = P().o0(str, concat);
                if (o02 != null) {
                    Object obj = o02.f9617e;
                    if (obj instanceof Long) {
                        q5Var = new q5(str, zzeuVar.f9890c, concat, b().b(), Long.valueOf(((Long) obj).longValue() + j10));
                        if (!P().T(q5Var)) {
                            c().K().b("Too many unique user properties are set. Ignoring user property. appId", z0.I(str), J().O(q5Var.f9615c), q5Var.f9617e);
                            K().N(str, 9, null, null, 0);
                        }
                    }
                }
                d0 P = P();
                int E = M().E(str, p0.G) - 1;
                i.g(str);
                P.e();
                P.w();
                P.B().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(E)});
                q5Var = new q5(str, zzeuVar.f9890c, concat, b().b(), Long.valueOf(j10));
                if (!P().T(q5Var)) {
                }
            }
        }
        return true;
    }

    private final d6[] o(String str, j6[] j6VarArr, e6[] e6VarArr) {
        i.g(str);
        return O().G(str, e6VarArr, j6VarArr);
    }

    private final void q(v vVar) {
        p();
        if (TextUtils.isEmpty(vVar.b())) {
            v(vVar.h(), 204, null, null, null);
            return;
        }
        String b10 = vVar.b();
        String a10 = vVar.a();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(p0.f9565g.a()).encodedAuthority(p0.f9566h.a());
        String valueOf = String.valueOf(b10);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", a10).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            c().R().d("Fetching remote configuration", vVar.h());
            b6 E = Q().E(vVar.h());
            a aVar = null;
            String F = Q().F(vVar.h());
            if (E != null && !TextUtils.isEmpty(F)) {
                a aVar2 = new a();
                aVar2.put("If-Modified-Since", F);
                aVar = aVar2;
            }
            this.f9403n = true;
            d1 R = R();
            String h10 = vVar.h();
            l5 l5Var = new l5(this);
            R.e();
            R.w();
            i.k(url);
            i.k(l5Var);
            R.d().L(new h1(R, h10, url, null, aVar, l5Var));
        } catch (MalformedURLException unused) {
            c().K().c("Failed to parse config URL. Not fetching. appId", z0.I(vVar.h()), uri);
        }
    }

    private final Boolean w(v vVar) {
        try {
            if (vVar.v() != -2147483648L) {
                if (vVar.v() == c.a(getContext()).d(vVar.h(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = c.a(getContext()).d(vVar.h(), 0).versionName;
                if (vVar.g() != null && vVar.g().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0584 A[Catch: all -> 0x05ec, TryCatch #1 {all -> 0x05ec, blocks: (B:32:0x00f6, B:34:0x0103, B:36:0x010d, B:38:0x0113, B:41:0x0122, B:43:0x015f, B:45:0x0164, B:46:0x017b, B:50:0x018c, B:52:0x01a2, B:54:0x01a7, B:55:0x01be, B:60:0x01e1, B:64:0x0205, B:65:0x021c, B:69:0x022c, B:72:0x024b, B:73:0x0263, B:75:0x026f, B:76:0x0284, B:78:0x02ae, B:81:0x02be, B:84:0x02f4, B:85:0x030e, B:86:0x031c, B:89:0x0368, B:90:0x036d, B:93:0x0385, B:94:0x0389, B:96:0x0397, B:98:0x03a1, B:100:0x03a5, B:101:0x03b2, B:103:0x03c0, B:105:0x03c4, B:107:0x03d4, B:108:0x03ea, B:110:0x03f0, B:111:0x0403, B:112:0x0405, B:114:0x044c, B:116:0x0452, B:117:0x0454, B:119:0x0460, B:120:0x04c0, B:121:0x04e0, B:123:0x04e6, B:125:0x0519, B:126:0x0521, B:128:0x0529, B:129:0x052d, B:131:0x0533, B:134:0x0542, B:136:0x056a, B:140:0x057e, B:142:0x0584, B:144:0x0588, B:145:0x059b, B:147:0x05ad), top: B:155:0x00f6, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x05ad A[Catch: all -> 0x05ec, TRY_LEAVE, TryCatch #1 {all -> 0x05ec, blocks: (B:32:0x00f6, B:34:0x0103, B:36:0x010d, B:38:0x0113, B:41:0x0122, B:43:0x015f, B:45:0x0164, B:46:0x017b, B:50:0x018c, B:52:0x01a2, B:54:0x01a7, B:55:0x01be, B:60:0x01e1, B:64:0x0205, B:65:0x021c, B:69:0x022c, B:72:0x024b, B:73:0x0263, B:75:0x026f, B:76:0x0284, B:78:0x02ae, B:81:0x02be, B:84:0x02f4, B:85:0x030e, B:86:0x031c, B:89:0x0368, B:90:0x036d, B:93:0x0385, B:94:0x0389, B:96:0x0397, B:98:0x03a1, B:100:0x03a5, B:101:0x03b2, B:103:0x03c0, B:105:0x03c4, B:107:0x03d4, B:108:0x03ea, B:110:0x03f0, B:111:0x0403, B:112:0x0405, B:114:0x044c, B:116:0x0452, B:117:0x0454, B:119:0x0460, B:120:0x04c0, B:121:0x04e0, B:123:0x04e6, B:125:0x0519, B:126:0x0521, B:128:0x0529, B:129:0x052d, B:131:0x0533, B:134:0x0542, B:136:0x056a, B:140:0x057e, B:142:0x0584, B:144:0x0588, B:145:0x059b, B:147:0x05ad), top: B:155:0x00f6, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y(zzeu zzeuVar, zzdz zzdzVar) {
        String str;
        boolean z10;
        l0 l0Var;
        k0 k0Var;
        long D;
        d0 P;
        zzer zzerVar;
        boolean z11;
        v f02;
        i.k(zzdzVar);
        i.g(zzdzVar.f9859a);
        long nanoTime = System.nanoTime();
        p();
        U();
        String str2 = zzdzVar.f9859a;
        K();
        if (r5.q0(zzeuVar, zzdzVar)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
            } else if (Q().K(str2, zzeuVar.f9888a)) {
                c().N().c("Dropping blacklisted event. appId", z0.I(str2), J().M(zzeuVar.f9888a));
                boolean z12 = Q().I(str2) || Q().J(str2);
                if (!z12 && !"_err".equals(zzeuVar.f9888a)) {
                    K().N(str2, 11, "_ev", zzeuVar.f9888a, 0);
                }
                if (z12 && (f02 = P().f0(str2)) != null) {
                    if (Math.abs(b().b() - Math.max(f02.B(), f02.A())) > p0.B.a().longValue()) {
                        c().Q().a("Fetching config for blacklisted app");
                        q(f02);
                    }
                }
            } else {
                if (c().z(2)) {
                    c().R().d("Logging event", J().L(zzeuVar));
                }
                P().z();
                try {
                    H(zzdzVar);
                    if (("_iap".equals(zzeuVar.f9888a) || "ecommerce_purchase".equals(zzeuVar.f9888a)) && !m(str2, zzeuVar)) {
                        P().C();
                        return;
                    }
                    boolean d02 = r5.d0(zzeuVar.f9888a);
                    boolean equals = "_err".equals(zzeuVar.f9888a);
                    e0 H = P().H(V(), str2, true, d02, false, equals, false);
                    long intValue = H.f9241b - p0.f9571m.a().intValue();
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            c().K().c("Data loss. Too many events logged. appId, count", z0.I(str2), Long.valueOf(H.f9241b));
                        }
                        P().C();
                        return;
                    }
                    if (d02) {
                        str = str2;
                        long intValue2 = H.f9240a - p0.f9573o.a().intValue();
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                c().K().c("Data loss. Too many public events logged. appId, count", z0.I(str), Long.valueOf(H.f9240a));
                            }
                            K().N(str, 16, "_ev", zzeuVar.f9888a, 0);
                            P().C();
                            return;
                        }
                    } else {
                        str = str2;
                    }
                    if (equals) {
                        z10 = false;
                        long max = H.f9243d - Math.max(0, Math.min(1000000, M().E(zzdzVar.f9859a, p0.f9572n)));
                        if (max > 0) {
                            if (max == 1) {
                                c().K().c("Too many error events logged. appId, count", z0.I(str), Long.valueOf(H.f9243d));
                            }
                            P().C();
                            return;
                        }
                    } else {
                        z10 = false;
                    }
                    Bundle L0 = zzeuVar.f9889b.L0();
                    K().K(L0, "_o", zzeuVar.f9890c);
                    String str3 = str;
                    if (K().k0(str3)) {
                        K().K(L0, "_dbg", 1L);
                        K().K(L0, "_r", 1L);
                    }
                    long g02 = P().g0(str3);
                    if (g02 > 0) {
                        c().N().c("Data lost. Too many events stored on disk, deleted. appId", z0.I(str3), Long.valueOf(g02));
                    }
                    int i10 = z10;
                    k0 k0Var2 = new k0(this.f9396g, zzeuVar.f9890c, str3, zzeuVar.f9888a, zzeuVar.f9891d, 0L, L0);
                    l0 m02 = P().m0(str3, k0Var2.f9424b);
                    if (m02 != null) {
                        k0Var = k0Var2.a(this.f9396g, m02.f9474e);
                        l0Var = m02.b(k0Var.f9426d);
                    } else if (P().j0(str3) < 500 || !d02) {
                        l0Var = new l0(str3, k0Var2.f9424b, 0L, 0L, k0Var2.f9426d, 0L, null, null, null);
                        k0Var = k0Var2;
                    } else {
                        c().K().b("Too many event names used, ignoring event. appId, name, supported count", z0.I(str3), J().M(k0Var2.f9424b), Integer.valueOf((int) AGCServerException.UNKNOW_EXCEPTION));
                        K().N(str3, 8, null, null, 0);
                        return;
                    }
                    P().M(l0Var);
                    p();
                    U();
                    i.k(k0Var);
                    i.k(zzdzVar);
                    i.g(k0Var.f9423a);
                    i.a(k0Var.f9423a.equals(zzdzVar.f9859a));
                    h6 h6Var = new h6();
                    h6Var.f9326c = 1;
                    h6Var.f9334k = "android";
                    h6Var.f9340q = zzdzVar.f9859a;
                    h6Var.f9339p = zzdzVar.f9862d;
                    h6Var.f9341r = zzdzVar.f9861c;
                    long j10 = zzdzVar.f9868j;
                    h6Var.E = j10 == -2147483648L ? null : Integer.valueOf((int) j10);
                    h6Var.f9342s = Long.valueOf(zzdzVar.f9863e);
                    h6Var.A = zzdzVar.f9860b;
                    long j11 = zzdzVar.f9864f;
                    h6Var.f9347x = j11 == 0 ? null : Long.valueOf(j11);
                    Pair<String, Boolean> B = L().B(zzdzVar.f9859a);
                    if (B == null || TextUtils.isEmpty((CharSequence) B.first)) {
                        if (!G().z(getContext()) && zzdzVar.f9874p) {
                            String string = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
                            if (string == null) {
                                c().N().d("null secure ID. appId", z0.I(h6Var.f9340q));
                                string = LpaConstants.VALUE_NULL;
                            } else if (string.isEmpty()) {
                                c().N().d("empty secure ID. appId", z0.I(h6Var.f9340q));
                            }
                            h6Var.H = string;
                        }
                    } else if (zzdzVar.f9873o) {
                        h6Var.f9344u = (String) B.first;
                        h6Var.f9345v = (Boolean) B.second;
                    }
                    G().u();
                    h6Var.f9336m = Build.MODEL;
                    G().u();
                    h6Var.f9335l = Build.VERSION.RELEASE;
                    h6Var.f9338o = Integer.valueOf((int) G().A());
                    h6Var.f9337n = G().B();
                    h6Var.f9343t = null;
                    h6Var.f9329f = null;
                    h6Var.f9330g = null;
                    h6Var.f9331h = null;
                    h6Var.J = Long.valueOf(zzdzVar.f9870l);
                    if (this.f9396g.g0() && a0.N()) {
                        h6Var.K = null;
                    }
                    v f03 = P().f0(zzdzVar.f9859a);
                    if (f03 == null) {
                        f03 = new v(this.f9396g, zzdzVar.f9859a);
                        f03.i(this.f9396g.p0().D());
                        f03.l(zzdzVar.f9869k);
                        f03.j(zzdzVar.f9860b);
                        f03.k(L().C(zzdzVar.f9859a));
                        f03.T(0L);
                        f03.O(0L);
                        f03.P(0L);
                        f03.d(zzdzVar.f9861c);
                        f03.Q(zzdzVar.f9868j);
                        f03.m(zzdzVar.f9862d);
                        f03.R(zzdzVar.f9863e);
                        f03.S(zzdzVar.f9864f);
                        f03.e(zzdzVar.f9866h);
                        f03.f(zzdzVar.f9870l);
                        P().L(f03);
                    }
                    h6Var.f9346w = f03.a();
                    h6Var.D = f03.s();
                    List<q5> e02 = P().e0(zzdzVar.f9859a);
                    h6Var.f9328e = new j6[e02.size()];
                    for (int i11 = i10; i11 < e02.size(); i11++) {
                        j6 j6Var = new j6();
                        h6Var.f9328e[i11] = j6Var;
                        j6Var.f9413d = e02.get(i11).f9615c;
                        j6Var.f9412c = Long.valueOf(e02.get(i11).f9616d);
                        K().M(j6Var, e02.get(i11).f9617e);
                    }
                    try {
                        D = P().D(h6Var);
                        P = P();
                        zzerVar = k0Var.f9428f;
                    } catch (IOException e10) {
                        c().K().c("Data loss. Failed to insert raw event metadata. appId", z0.I(h6Var.f9340q), e10);
                    }
                    if (zzerVar != null) {
                        Iterator<String> it = zzerVar.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if ("_r".equals(it.next())) {
                                    break;
                                }
                            } else {
                                boolean L = Q().L(k0Var.f9423a, k0Var.f9424b);
                                e0 H2 = P().H(V(), k0Var.f9423a, false, false, false, false, false);
                                if (L && H2.f9244e < M().v(k0Var.f9423a)) {
                                }
                            }
                        }
                        z11 = true;
                        if (P.R(k0Var, D, z11)) {
                            this.f9399j = 0L;
                        }
                        P().C();
                        if (c().z(2)) {
                            c().R().d("Event recorded", J().z(k0Var));
                        }
                        P().A();
                        Y();
                        c().R().d("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                    }
                    z11 = i10;
                    if (P.R(k0Var, D, z11)) {
                    }
                    P().C();
                    if (c().z(2)) {
                    }
                    P().A();
                    Y();
                    c().R().d("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    P().A();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(zzjx zzjxVar, zzdz zzdzVar) {
        p();
        U();
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            c().Q().d("Removing user property", J().O(zzjxVar.f9893b));
            P().z();
            try {
                H(zzdzVar);
                P().n0(zzdzVar.f9859a, zzjxVar.f9893b);
                P().C();
                c().Q().d("User property removed", J().O(zzjxVar.f9893b));
            } finally {
                P().A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdz B(String str) {
        b1 Q;
        String str2;
        Object obj;
        String str3 = str;
        v f02 = P().f0(str3);
        if (f02 == null || TextUtils.isEmpty(f02.g())) {
            Q = c().Q();
            str2 = "No app data available; dropping";
            obj = str3;
        } else {
            Boolean w10 = w(f02);
            if (w10 == null || w10.booleanValue()) {
                return new zzdz(str, f02.b(), f02.g(), f02.v(), f02.w(), f02.x(), f02.y(), (String) null, f02.c(), false, f02.s(), f02.L(), 0L, 0, f02.M(), f02.N(), false);
            }
            Q = c().K();
            str2 = "App version does not match; dropping. appId";
            obj = z0.I(str);
        }
        Q.d(str2, obj);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(zzdz zzdzVar) {
        if (this.f9408s != null) {
            ArrayList arrayList = new ArrayList();
            this.f9409t = arrayList;
            arrayList.addAll(this.f9408s);
        }
        d0 P = P();
        String str = zzdzVar.f9859a;
        i.g(str);
        P.e();
        P.w();
        try {
            SQLiteDatabase B = P.B();
            String[] strArr = {str};
            int delete = B.delete("apps", "app_id=?", strArr) + 0 + B.delete("events", "app_id=?", strArr) + B.delete("user_attributes", "app_id=?", strArr) + B.delete("conditional_properties", "app_id=?", strArr) + B.delete("raw_events", "app_id=?", strArr) + B.delete("raw_events_metadata", "app_id=?", strArr) + B.delete("queue", "app_id=?", strArr) + B.delete("audience_filter_values", "app_id=?", strArr) + B.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                P.c().R().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            P.c().K().c("Error resetting analytics data. appId, error", z0.I(str), e10);
        }
        zzdz g10 = g(getContext(), zzdzVar.f9859a, zzdzVar.f9860b, zzdzVar.f9866h, zzdzVar.f9873o, zzdzVar.f9874p, zzdzVar.f9871m);
        if (!M().D(zzdzVar.f9859a) || zzdzVar.f9866h) {
            F(g10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void E(zzdz zzdzVar) {
        p();
        U();
        i.g(zzdzVar.f9859a);
        H(zzdzVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0301 A[Catch: all -> 0x03b1, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0385 A[Catch: all -> 0x03b1, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bd A[Catch: all -> 0x03b1, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d8 A[Catch: all -> 0x03b1, TRY_LEAVE, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0281 A[Catch: all -> 0x03b1, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d4 A[Catch: all -> 0x03b1, TryCatch #1 {all -> 0x03b1, blocks: (B:24:0x0095, B:26:0x00a1, B:28:0x00a7, B:30:0x00b3, B:31:0x00d9, B:33:0x0122, B:35:0x0135, B:38:0x0149, B:41:0x0156, B:43:0x0160, B:44:0x017e, B:45:0x0182, B:47:0x0189, B:49:0x0195, B:52:0x01b8, B:54:0x01bd, B:55:0x01c5, B:57:0x01cc, B:60:0x01d8, B:63:0x01eb, B:65:0x0231, B:67:0x0235, B:68:0x0238, B:70:0x0242, B:71:0x0257, B:73:0x0262, B:77:0x026b, B:79:0x0281, B:81:0x0289, B:83:0x028f, B:85:0x0295, B:89:0x029f, B:90:0x02ae, B:92:0x02be, B:94:0x02d4, B:96:0x02da, B:97:0x02dd, B:99:0x02e3, B:100:0x02e6, B:102:0x0301, B:103:0x0304, B:104:0x0315, B:107:0x031d, B:109:0x034d, B:111:0x0351, B:112:0x0354, B:113:0x0366, B:114:0x0381, B:115:0x0385, B:117:0x038b, B:118:0x03a2), top: B:126:0x0095, inners: #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(zzdz zzdzVar) {
        int i10;
        l0 l0Var;
        zzeu zzeuVar;
        zzeu zzeuVar2;
        int i11;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        int i12;
        PackageManager.NameNotFoundException e10;
        long I0;
        d0 P;
        String str;
        String str2;
        zzeu zzeuVar3;
        p();
        U();
        i.k(zzdzVar);
        i.g(zzdzVar.f9859a);
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            v f02 = P().f0(zzdzVar.f9859a);
            if (f02 != null && TextUtils.isEmpty(f02.b()) && !TextUtils.isEmpty(zzdzVar.f9860b)) {
                f02.U(0L);
                P().L(f02);
                Q().H(zzdzVar.f9859a);
            }
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            long j10 = zzdzVar.f9871m;
            if (j10 == 0) {
                j10 = b().b();
            }
            int i13 = zzdzVar.f9872n;
            if (!(i13 == 0 || i13 == 1)) {
                c().N().c("Incorrect app type, assuming installed app. appId, appType", z0.I(zzdzVar.f9859a), Integer.valueOf(i13));
                i13 = 0;
            }
            P().z();
            try {
                v f03 = P().f0(zzdzVar.f9859a);
                if (!(f03 == null || f03.b() == null || f03.b().equals(zzdzVar.f9860b))) {
                    c().N().d("New GMP App Id passed in. Removing cached database data. appId", z0.I(f03.h()));
                    d0 P2 = P();
                    String h10 = f03.h();
                    P2.w();
                    P2.e();
                    i.g(h10);
                    try {
                        SQLiteDatabase B = P2.B();
                        String[] strArr = {h10};
                        int delete = B.delete("events", "app_id=?", strArr) + 0 + B.delete("user_attributes", "app_id=?", strArr) + B.delete("conditional_properties", "app_id=?", strArr) + B.delete("apps", "app_id=?", strArr) + B.delete("raw_events", "app_id=?", strArr) + B.delete("raw_events_metadata", "app_id=?", strArr) + B.delete("event_filters", "app_id=?", strArr) + B.delete("property_filters", "app_id=?", strArr) + B.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            P2.c().R().c("Deleted application data. app, records", h10, Integer.valueOf(delete));
                        }
                    } catch (SQLiteException e11) {
                        P2.c().K().c("Error deleting application data. appId, error", z0.I(h10), e11);
                    }
                    f03 = null;
                }
                if (f03 != null) {
                    if (f03.v() != -2147483648L) {
                        if (f03.v() != zzdzVar.f9868j) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", f03.g());
                            i10 = 1;
                            zzeuVar3 = new zzeu("_au", new zzer(bundle), CameraConfig.CAMERA_FOCUS_AUTO, j10);
                        }
                    } else if (f03.g() == null || f03.g().equals(zzdzVar.f9861c)) {
                        i10 = 1;
                        H(zzdzVar);
                        if (i13 == 0) {
                            P = P();
                            str = zzdzVar.f9859a;
                            str2 = "_f";
                        } else if (i13 == i10) {
                            P = P();
                            str = zzdzVar.f9859a;
                            str2 = "_v";
                        } else {
                            l0Var = null;
                            if (l0Var != null) {
                                long j11 = j10;
                                long j12 = ((j10 / LogCleaner.ONE_HOUR) + 1) * LogCleaner.ONE_HOUR;
                                if (i13 == 0) {
                                    u(new zzjx("_fot", j11, Long.valueOf(j12), CameraConfig.CAMERA_FOCUS_AUTO), zzdzVar);
                                    p();
                                    U();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putLong("_c", 1L);
                                    bundle2.putLong("_r", 1L);
                                    bundle2.putLong("_uwa", 0L);
                                    bundle2.putLong("_pfo", 0L);
                                    bundle2.putLong("_sys", 0L);
                                    bundle2.putLong("_sysu", 0L);
                                    if (M().D(zzdzVar.f9859a) && zzdzVar.f9875q) {
                                        bundle2.putLong("_dac", 1L);
                                    }
                                    if (getContext().getPackageManager() == null) {
                                        c().K().d("PackageManager is null, first open report might be inaccurate. appId", z0.I(zzdzVar.f9859a));
                                    } else {
                                        try {
                                            i11 = 0;
                                        } catch (PackageManager.NameNotFoundException e12) {
                                            e10 = e12;
                                            i11 = 0;
                                        }
                                        try {
                                            packageInfo = c.a(getContext()).d(zzdzVar.f9859a, 0);
                                        } catch (PackageManager.NameNotFoundException e13) {
                                            e10 = e13;
                                            c().K().c("Package info is null, first open report might be inaccurate. appId", z0.I(zzdzVar.f9859a), e10);
                                            packageInfo = null;
                                            if (packageInfo != null) {
                                            }
                                            applicationInfo = c.a(getContext()).b(zzdzVar.f9859a, i11);
                                            if (applicationInfo != null) {
                                            }
                                            d0 P3 = P();
                                            String str3 = zzdzVar.f9859a;
                                            i.g(str3);
                                            P3.e();
                                            P3.w();
                                            I0 = P3.I0(str3, "first_open_count");
                                            if (I0 >= 0) {
                                            }
                                            zzeuVar2 = new zzeu("_f", new zzer(bundle2), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                                            s(zzeuVar2, zzdzVar);
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putLong("_et", 1L);
                                            zzeuVar = new zzeu("_e", new zzer(bundle3), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                                            s(zzeuVar, zzdzVar);
                                            P().C();
                                        }
                                        if (packageInfo != null) {
                                            long j13 = packageInfo.firstInstallTime;
                                            if (j13 != 0) {
                                                if (j13 != packageInfo.lastUpdateTime) {
                                                    bundle2.putLong("_uwa", 1L);
                                                    i12 = i11;
                                                } else {
                                                    i12 = 1;
                                                }
                                                u(new zzjx("_fi", j11, Long.valueOf(i12 != 0 ? 1L : 0L), CameraConfig.CAMERA_FOCUS_AUTO), zzdzVar);
                                            }
                                        }
                                        try {
                                            applicationInfo = c.a(getContext()).b(zzdzVar.f9859a, i11);
                                        } catch (PackageManager.NameNotFoundException e14) {
                                            c().K().c("Application info is null, first open report might be inaccurate. appId", z0.I(zzdzVar.f9859a), e14);
                                            applicationInfo = null;
                                        }
                                        if (applicationInfo != null) {
                                            if ((applicationInfo.flags & 1) != 0) {
                                                bundle2.putLong("_sys", 1L);
                                            }
                                            if ((applicationInfo.flags & 128) != 0) {
                                                bundle2.putLong("_sysu", 1L);
                                            }
                                        }
                                    }
                                    d0 P32 = P();
                                    String str32 = zzdzVar.f9859a;
                                    i.g(str32);
                                    P32.e();
                                    P32.w();
                                    I0 = P32.I0(str32, "first_open_count");
                                    if (I0 >= 0) {
                                        bundle2.putLong("_pfo", I0);
                                    }
                                    zzeuVar2 = new zzeu("_f", new zzer(bundle2), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                                } else {
                                    if (i13 == 1) {
                                        u(new zzjx("_fvt", j11, Long.valueOf(j12), CameraConfig.CAMERA_FOCUS_AUTO), zzdzVar);
                                        p();
                                        U();
                                        Bundle bundle4 = new Bundle();
                                        bundle4.putLong("_c", 1L);
                                        bundle4.putLong("_r", 1L);
                                        if (M().D(zzdzVar.f9859a) && zzdzVar.f9875q) {
                                            bundle4.putLong("_dac", 1L);
                                        }
                                        zzeuVar2 = new zzeu("_v", new zzer(bundle4), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                                    }
                                    Bundle bundle32 = new Bundle();
                                    bundle32.putLong("_et", 1L);
                                    zzeuVar = new zzeu("_e", new zzer(bundle32), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                                }
                                s(zzeuVar2, zzdzVar);
                                Bundle bundle322 = new Bundle();
                                bundle322.putLong("_et", 1L);
                                zzeuVar = new zzeu("_e", new zzer(bundle322), CameraConfig.CAMERA_FOCUS_AUTO, j11);
                            } else {
                                long j14 = j10;
                                if (zzdzVar.f9867i) {
                                    zzeuVar = new zzeu("_cd", new zzer(new Bundle()), CameraConfig.CAMERA_FOCUS_AUTO, j14);
                                }
                                P().C();
                            }
                            s(zzeuVar, zzdzVar);
                            P().C();
                        }
                        l0Var = P.m0(str, str2);
                        if (l0Var != null) {
                        }
                        s(zzeuVar, zzdzVar);
                        P().C();
                    } else {
                        Bundle bundle5 = new Bundle();
                        bundle5.putString("_pv", f03.g());
                        i10 = 1;
                        zzeuVar3 = new zzeu("_au", new zzer(bundle5), CameraConfig.CAMERA_FOCUS_AUTO, j10);
                    }
                    s(zzeuVar3, zzdzVar);
                    H(zzdzVar);
                    if (i13 == 0) {
                    }
                    l0Var = P.m0(str, str2);
                    if (l0Var != null) {
                    }
                    s(zzeuVar, zzdzVar);
                    P().C();
                }
                i10 = 1;
                H(zzdzVar);
                if (i13 == 0) {
                }
                l0Var = P.m0(str, str2);
                if (l0Var != null) {
                }
                s(zzeuVar, zzdzVar);
                P().C();
            } finally {
                P().A();
            }
        }
    }

    public j0 G() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I(Runnable runnable) {
        p();
        if (this.f9400k == null) {
            this.f9400k = new ArrayList();
        }
        this.f9400k.add(runnable);
    }

    public x0 J() {
        throw null;
    }

    public r5 K() {
        throw null;
    }

    public k1 L() {
        throw null;
    }

    public a0 M() {
        throw null;
    }

    public final String N(zzdz zzdzVar) {
        try {
            return (String) d().F(new m5(this, zzdzVar)).get(ab.Y, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            c().K().c("Failed to get app instance id. appId", z0.I(zzdzVar.f9859a), e10);
            return null;
        }
    }

    public final x O() {
        j(this.f9395f);
        return this.f9395f;
    }

    public final d0 P() {
        j(this.f9392c);
        return this.f9392c;
    }

    public final d1 R() {
        j(this.f9391b);
        return this.f9391b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U() {
        if (!this.f9397h) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void W() {
        v f02;
        String str;
        b1 R;
        String str2;
        p();
        U();
        this.f9405p = true;
        try {
            Boolean b02 = this.f9396g.q0().b0();
            if (b02 == null) {
                R = c().N();
                str2 = "Upload data called on the client side before use of service was decided";
            } else if (b02.booleanValue()) {
                R = c().K();
                str2 = "Upload called in the client side when service should be used";
            } else {
                if (this.f9399j <= 0) {
                    p();
                    if (this.f9408s != null) {
                        R = c().R();
                        str2 = "Uploading requested multiple times";
                    } else if (!R().C()) {
                        c().R().a("Network not connected, ignoring upload request");
                    } else {
                        long b10 = b().b();
                        String str3 = null;
                        D(null, b10 - a0.L());
                        long a10 = L().f9432e.a();
                        if (a10 != 0) {
                            c().Q().d("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(b10 - a10)));
                        }
                        String p02 = P().p0();
                        if (!TextUtils.isEmpty(p02)) {
                            if (this.f9410u == -1) {
                                this.f9410u = P().w0();
                            }
                            List<Pair<h6, Long>> a02 = P().a0(p02, M().E(p02, p0.f9567i), Math.max(0, M().E(p02, p0.f9568j)));
                            if (!a02.isEmpty()) {
                                Iterator<Pair<h6, Long>> it = a02.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str = null;
                                        break;
                                    }
                                    h6 h6Var = (h6) it.next().first;
                                    if (!TextUtils.isEmpty(h6Var.f9344u)) {
                                        str = h6Var.f9344u;
                                        break;
                                    }
                                }
                                if (str != null) {
                                    int i10 = 0;
                                    while (true) {
                                        if (i10 >= a02.size()) {
                                            break;
                                        }
                                        h6 h6Var2 = (h6) a02.get(i10).first;
                                        if (!TextUtils.isEmpty(h6Var2.f9344u) && !h6Var2.f9344u.equals(str)) {
                                            a02 = a02.subList(0, i10);
                                            break;
                                        }
                                        i10++;
                                    }
                                }
                                g6 g6Var = new g6();
                                g6Var.f9304c = new h6[a02.size()];
                                ArrayList arrayList = new ArrayList(a02.size());
                                boolean z10 = a0.N() && M().x(p02);
                                int i11 = 0;
                                while (true) {
                                    h6[] h6VarArr = g6Var.f9304c;
                                    if (i11 >= h6VarArr.length) {
                                        break;
                                    }
                                    h6VarArr[i11] = (h6) a02.get(i11).first;
                                    arrayList.add((Long) a02.get(i11).second);
                                    g6Var.f9304c[i11].f9343t = 12451L;
                                    g6Var.f9304c[i11].f9329f = Long.valueOf(b10);
                                    h6[] h6VarArr2 = g6Var.f9304c;
                                    h6VarArr2[i11].B = Boolean.FALSE;
                                    if (!z10) {
                                        h6VarArr2[i11].K = null;
                                    }
                                    i11++;
                                }
                                if (c().z(2)) {
                                    str3 = J().C(g6Var);
                                }
                                byte[] Z = K().Z(g6Var);
                                String a11 = p0.f9577s.a();
                                try {
                                    URL url = new URL(a11);
                                    i.a(!arrayList.isEmpty());
                                    if (this.f9408s != null) {
                                        c().K().a("Set uploading progress before finishing the previous upload");
                                    } else {
                                        this.f9408s = new ArrayList(arrayList);
                                    }
                                    L().f9433f.b(b10);
                                    String str4 = "?";
                                    h6[] h6VarArr3 = g6Var.f9304c;
                                    if (h6VarArr3.length > 0) {
                                        str4 = h6VarArr3[0].f9340q;
                                    }
                                    c().R().b("Uploading data. app, uncompressed size, data", str4, Integer.valueOf(Z.length), str3);
                                    this.f9404o = true;
                                    d1 R2 = R();
                                    k5 k5Var = new k5(this, p02);
                                    R2.e();
                                    R2.w();
                                    i.k(url);
                                    i.k(Z);
                                    i.k(k5Var);
                                    R2.d().L(new h1(R2, p02, url, Z, null, k5Var));
                                } catch (MalformedURLException unused) {
                                    c().K().c("Failed to parse upload URL. Not uploading. appId", z0.I(p02), a11);
                                }
                            }
                        } else {
                            this.f9410u = -1L;
                            String Z2 = P().Z(b10 - a0.L());
                            if (!TextUtils.isEmpty(Z2) && (f02 = P().f0(Z2)) != null) {
                                q(f02);
                            }
                        }
                    }
                }
                Y();
            }
            R.a(str2);
        } finally {
            this.f9405p = false;
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        p();
        P().r0();
        if (L().f9432e.a() == 0) {
            L().f9432e.b(b().b());
        }
        Y();
    }

    @Override // com.google.android.gms.internal.measurement.y
    public e b() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0() {
        b1 K;
        Integer valueOf;
        Integer valueOf2;
        String str;
        p();
        U();
        if (!this.f9398i) {
            c().P().a("This instance being marked as an uploader");
            p();
            U();
            if (c0() && a0()) {
                int e10 = e(this.f9407r);
                int E = this.f9396g.p0().E();
                p();
                if (e10 > E) {
                    K = c().K();
                    valueOf = Integer.valueOf(e10);
                    valueOf2 = Integer.valueOf(E);
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (e10 < E) {
                    if (l(E, this.f9407r)) {
                        K = c().R();
                        valueOf = Integer.valueOf(e10);
                        valueOf2 = Integer.valueOf(E);
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        K = c().K();
                        valueOf = Integer.valueOf(e10);
                        valueOf2 = Integer.valueOf(E);
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                K.c(str, valueOf, valueOf2);
            }
            this.f9398i = true;
            Y();
        }
    }

    @Override // com.google.android.gms.internal.measurement.y
    public z0 c() {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public z1 d() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d0() {
        this.f9402m++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d2 e0() {
        return this.f9396g;
    }

    public final void f0(boolean z10) {
        Y();
    }

    @Override // com.google.android.gms.internal.measurement.y
    public Context getContext() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0142, code lost:
        L().f9434g.b(b().b());
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i10, Throwable th2, byte[] bArr, String str) {
        d0 P;
        long longValue;
        p();
        U();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f9404o = false;
                Z();
            }
        }
        List<Long> list = this.f9408s;
        this.f9408s = null;
        boolean z10 = true;
        if ((i10 == 200 || i10 == 204) && th2 == null) {
            try {
                L().f9432e.b(b().b());
                L().f9433f.b(0L);
                Y();
                c().R().c("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                P().z();
                try {
                    for (Long l10 : list) {
                        try {
                            P = P();
                            longValue = l10.longValue();
                            P.e();
                            P.w();
                            try {
                            } catch (SQLiteException e10) {
                                P.c().K().d("Failed to delete a bundle in a queue table", e10);
                                throw e10;
                                break;
                            }
                        } catch (SQLiteException e11) {
                            List<Long> list2 = this.f9409t;
                            if (list2 == null || !list2.contains(l10)) {
                                throw e11;
                            }
                        }
                        if (P.B().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                            break;
                        }
                    }
                    P().C();
                    P().A();
                    this.f9409t = null;
                    if (!R().C() || !X()) {
                        this.f9410u = -1L;
                        Y();
                    } else {
                        W();
                    }
                    this.f9399j = 0L;
                } catch (Throwable th3) {
                    P().A();
                    throw th3;
                }
            } catch (SQLiteException e12) {
                c().K().d("Database error while trying to delete uploaded bundles", e12);
                this.f9399j = b().c();
                c().R().d("Disable upload, time", Long.valueOf(this.f9399j));
            }
        } else {
            c().R().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th2);
            L().f9433f.b(b().b());
            if (!(i10 == 503 || i10 == 429)) {
                z10 = false;
            }
            if (M().B(str)) {
                P().l0(list);
            }
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(d2 d2Var) {
        this.f9396g = d2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(o5 o5Var) {
        p();
        d0 d0Var = new d0(this.f9396g);
        d0Var.y();
        this.f9392c = d0Var;
        M().u(this.f9390a);
        x xVar = new x(this.f9396g);
        xVar.y();
        this.f9395f = xVar;
        f5 f5Var = new f5(this.f9396g);
        f5Var.y();
        this.f9394e = f5Var;
        this.f9393d = new i1(this.f9396g);
        if (this.f9401l != this.f9402m) {
            c().K().c("Not all upload components initialized", Integer.valueOf(this.f9401l), Integer.valueOf(this.f9402m));
        }
        this.f9397h = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final byte[] n(zzeu zzeuVar, String str) {
        q5 q5Var;
        h6 h6Var;
        byte[] bArr;
        Bundle bundle;
        g6 g6Var;
        v vVar;
        long j10;
        b1 N;
        String str2;
        Object I;
        U();
        p();
        d2.m0();
        i.k(zzeuVar);
        i.g(str);
        g6 g6Var2 = new g6();
        P().z();
        try {
            v f02 = P().f0(str);
            if (f02 == null) {
                c().Q().d("Log and bundle not available. package_name", str);
            } else if (!f02.c()) {
                c().Q().d("Log and bundle disabled. package_name", str);
            } else {
                if (("_iap".equals(zzeuVar.f9888a) || "ecommerce_purchase".equals(zzeuVar.f9888a)) && !m(str, zzeuVar)) {
                    c().N().d("Failed to handle purchase event at single event bundle creation. appId", z0.I(str));
                }
                boolean z10 = M().z(str);
                Long l10 = 0L;
                if (z10 && "_e".equals(zzeuVar.f9888a)) {
                    zzer zzerVar = zzeuVar.f9889b;
                    if (!(zzerVar == null || zzerVar.size() == 0)) {
                        if (zzeuVar.f9889b.H0("_et") == null) {
                            N = c().N();
                            str2 = "The engagement event does not include duration. appId";
                            I = z0.I(str);
                            N.d(str2, I);
                        } else {
                            l10 = zzeuVar.f9889b.H0("_et");
                        }
                    }
                    N = c().N();
                    str2 = "The engagement event does not contain any parameters. appId";
                    I = z0.I(str);
                    N.d(str2, I);
                }
                h6 h6Var2 = new h6();
                g6Var2.f9304c = new h6[]{h6Var2};
                h6Var2.f9326c = 1;
                h6Var2.f9334k = "android";
                h6Var2.f9340q = f02.h();
                h6Var2.f9339p = f02.w();
                h6Var2.f9341r = f02.g();
                long v10 = f02.v();
                h6Var2.E = v10 == -2147483648L ? null : Integer.valueOf((int) v10);
                h6Var2.f9342s = Long.valueOf(f02.x());
                h6Var2.A = f02.b();
                h6Var2.f9347x = Long.valueOf(f02.y());
                if (this.f9396g.g0() && a0.N() && M().x(h6Var2.f9340q)) {
                    h6Var2.K = null;
                }
                Pair<String, Boolean> B = L().B(f02.h());
                if (f02.M() && B != null && !TextUtils.isEmpty((CharSequence) B.first)) {
                    h6Var2.f9344u = (String) B.first;
                    h6Var2.f9345v = (Boolean) B.second;
                }
                G().u();
                h6Var2.f9336m = Build.MODEL;
                G().u();
                h6Var2.f9335l = Build.VERSION.RELEASE;
                h6Var2.f9338o = Integer.valueOf((int) G().A());
                h6Var2.f9337n = G().B();
                h6Var2.f9346w = f02.a();
                h6Var2.D = f02.s();
                List<q5> e02 = P().e0(f02.h());
                h6Var2.f9328e = new j6[e02.size()];
                if (z10) {
                    q5Var = P().o0(h6Var2.f9340q, "_lte");
                    if (!(q5Var == null || q5Var.f9617e == null)) {
                        if (l10.longValue() > 0) {
                            q5Var = new q5(h6Var2.f9340q, CameraConfig.CAMERA_FOCUS_AUTO, "_lte", b().b(), Long.valueOf(((Long) q5Var.f9617e).longValue() + l10.longValue()));
                        }
                    }
                    q5Var = new q5(h6Var2.f9340q, CameraConfig.CAMERA_FOCUS_AUTO, "_lte", b().b(), l10);
                } else {
                    q5Var = null;
                }
                j6 j6Var = null;
                for (int i10 = 0; i10 < e02.size(); i10++) {
                    j6 j6Var2 = new j6();
                    h6Var2.f9328e[i10] = j6Var2;
                    j6Var2.f9413d = e02.get(i10).f9615c;
                    f02 = f02;
                    g6Var2 = g6Var2;
                    j6Var2.f9412c = Long.valueOf(e02.get(i10).f9616d);
                    K().M(j6Var2, e02.get(i10).f9617e);
                    if (z10 && "_lte".equals(j6Var2.f9413d)) {
                        j6Var2.f9415f = (Long) q5Var.f9617e;
                        j6Var2.f9412c = Long.valueOf(b().b());
                        j6Var = j6Var2;
                    }
                }
                v vVar2 = f02;
                g6 g6Var3 = g6Var2;
                if (z10 && j6Var == null) {
                    j6 j6Var3 = new j6();
                    j6Var3.f9413d = "_lte";
                    j6Var3.f9412c = Long.valueOf(b().b());
                    j6Var3.f9415f = (Long) q5Var.f9617e;
                    j6[] j6VarArr = h6Var2.f9328e;
                    j6[] j6VarArr2 = (j6[]) Arrays.copyOf(j6VarArr, j6VarArr.length + 1);
                    h6Var2.f9328e = j6VarArr2;
                    j6VarArr2[j6VarArr2.length - 1] = j6Var3;
                }
                if (l10.longValue() > 0) {
                    P().T(q5Var);
                }
                Bundle L0 = zzeuVar.f9889b.L0();
                if ("_iap".equals(zzeuVar.f9888a)) {
                    L0.putLong("_c", 1L);
                    c().Q().a("Marking in-app purchase as real-time");
                    L0.putLong("_r", 1L);
                }
                L0.putString("_o", zzeuVar.f9890c);
                if (K().k0(h6Var2.f9340q)) {
                    K().K(L0, "_dbg", 1L);
                    K().K(L0, "_r", 1L);
                }
                l0 m02 = P().m0(str, zzeuVar.f9888a);
                if (m02 == null) {
                    bArr = null;
                    h6Var = h6Var2;
                    vVar = vVar2;
                    g6Var = g6Var3;
                    bundle = L0;
                    P().M(new l0(str, zzeuVar.f9888a, 1L, 0L, zzeuVar.f9891d, 0L, null, null, null));
                    j10 = 0;
                } else {
                    h6Var = h6Var2;
                    g6Var = g6Var3;
                    vVar = vVar2;
                    bArr = null;
                    bundle = L0;
                    j10 = m02.f9474e;
                    P().M(m02.b(zzeuVar.f9891d).d());
                }
                k0 k0Var = new k0(this.f9396g, zzeuVar.f9890c, str, zzeuVar.f9888a, zzeuVar.f9891d, j10, bundle);
                e6 e6Var = new e6();
                h6 h6Var3 = h6Var;
                h6Var3.f9327d = new e6[]{e6Var};
                e6Var.f9259e = Long.valueOf(k0Var.f9426d);
                e6Var.f9258d = k0Var.f9424b;
                e6Var.f9260f = Long.valueOf(k0Var.f9427e);
                e6Var.f9257c = new f6[k0Var.f9428f.size()];
                Iterator<String> it = k0Var.f9428f.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    f6 f6Var = new f6();
                    i11++;
                    e6Var.f9257c[i11] = f6Var;
                    f6Var.f9274c = next;
                    K().L(f6Var, k0Var.f9428f.G0(next));
                }
                h6Var3.C = o(vVar.h(), h6Var3.f9328e, h6Var3.f9327d);
                Long l11 = e6Var.f9259e;
                h6Var3.f9330g = l11;
                h6Var3.f9331h = l11;
                long u10 = vVar.u();
                h6Var3.f9333j = u10 != 0 ? Long.valueOf(u10) : bArr;
                long t10 = vVar.t();
                if (t10 != 0) {
                    u10 = t10;
                }
                h6Var3.f9332i = u10 != 0 ? Long.valueOf(u10) : bArr;
                vVar.C();
                h6Var3.f9348y = Integer.valueOf((int) vVar.z());
                h6Var3.f9343t = 12451L;
                h6Var3.f9329f = Long.valueOf(b().b());
                h6Var3.B = Boolean.TRUE;
                v vVar3 = vVar;
                vVar3.O(h6Var3.f9330g.longValue());
                vVar3.P(h6Var3.f9331h.longValue());
                P().L(vVar3);
                P().C();
                try {
                    int f10 = g6Var.f();
                    byte[] bArr2 = new byte[f10];
                    h p10 = h.p(bArr2, 0, f10);
                    g6Var.b(p10);
                    p10.B();
                    return K().V(bArr2);
                } catch (IOException e10) {
                    c().K().c("Data loss. Failed to bundle and serialize. appId", z0.I(str), e10);
                    return bArr;
                }
            }
            return new byte[0];
        } finally {
            P().A();
        }
    }

    public void p() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(zzed zzedVar, zzdz zzdzVar) {
        b1 K;
        String str;
        Object I;
        String O;
        Object G0;
        b1 K2;
        String str2;
        Object I2;
        String O2;
        Object obj;
        boolean z10;
        i.k(zzedVar);
        i.g(zzedVar.f9876a);
        i.k(zzedVar.f9877b);
        i.k(zzedVar.f9878c);
        i.g(zzedVar.f9878c.f9893b);
        p();
        U();
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            zzed zzedVar2 = new zzed(zzedVar);
            boolean z11 = false;
            zzedVar2.f9880e = false;
            P().z();
            try {
                zzed C0 = P().C0(zzedVar2.f9876a, zzedVar2.f9878c.f9893b);
                if (C0 != null && !C0.f9877b.equals(zzedVar2.f9877b)) {
                    c().N().b("Updating a conditional user property with different origin. name, origin, origin (from DB)", J().O(zzedVar2.f9878c.f9893b), zzedVar2.f9877b, C0.f9877b);
                }
                if (C0 != null && (z10 = C0.f9880e)) {
                    zzedVar2.f9877b = C0.f9877b;
                    zzedVar2.f9879d = C0.f9879d;
                    zzedVar2.f9883h = C0.f9883h;
                    zzedVar2.f9881f = C0.f9881f;
                    zzedVar2.f9884i = C0.f9884i;
                    zzedVar2.f9880e = z10;
                    zzjx zzjxVar = zzedVar2.f9878c;
                    zzedVar2.f9878c = new zzjx(zzjxVar.f9893b, C0.f9878c.f9894c, zzjxVar.G0(), C0.f9878c.f9897f);
                } else if (TextUtils.isEmpty(zzedVar2.f9881f)) {
                    zzjx zzjxVar2 = zzedVar2.f9878c;
                    zzedVar2.f9878c = new zzjx(zzjxVar2.f9893b, zzedVar2.f9879d, zzjxVar2.G0(), zzedVar2.f9878c.f9897f);
                    zzedVar2.f9880e = true;
                    z11 = true;
                }
                if (zzedVar2.f9880e) {
                    zzjx zzjxVar3 = zzedVar2.f9878c;
                    q5 q5Var = new q5(zzedVar2.f9876a, zzedVar2.f9877b, zzjxVar3.f9893b, zzjxVar3.f9894c, zzjxVar3.G0());
                    if (P().T(q5Var)) {
                        K2 = c().Q();
                        str2 = "User property updated immediately";
                        I2 = zzedVar2.f9876a;
                        O2 = J().O(q5Var.f9615c);
                        obj = q5Var.f9617e;
                    } else {
                        K2 = c().K();
                        str2 = "(2)Too many active user properties, ignoring";
                        I2 = z0.I(zzedVar2.f9876a);
                        O2 = J().O(q5Var.f9615c);
                        obj = q5Var.f9617e;
                    }
                    K2.b(str2, I2, O2, obj);
                    if (z11 && zzedVar2.f9884i != null) {
                        y(new zzeu(zzedVar2.f9884i, zzedVar2.f9879d), zzdzVar);
                    }
                }
                if (P().Q(zzedVar2)) {
                    K = c().Q();
                    str = "Conditional property added";
                    I = zzedVar2.f9876a;
                    O = J().O(zzedVar2.f9878c.f9893b);
                    G0 = zzedVar2.f9878c.G0();
                } else {
                    K = c().K();
                    str = "Too many conditional properties, ignoring";
                    I = z0.I(zzedVar2.f9876a);
                    O = J().O(zzedVar2.f9878c.f9893b);
                    G0 = zzedVar2.f9878c.G0();
                }
                K.b(str, I, O, G0);
                P().C();
            } finally {
                P().A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(zzeu zzeuVar, zzdz zzdzVar) {
        List<zzed> list;
        List<zzed> list2;
        List<zzed> list3;
        b1 K;
        String str;
        Object I;
        String O;
        Object obj;
        i.k(zzdzVar);
        i.g(zzdzVar.f9859a);
        p();
        U();
        String str2 = zzdzVar.f9859a;
        long j10 = zzeuVar.f9891d;
        K();
        if (r5.q0(zzeuVar, zzdzVar)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            P().z();
            try {
                d0 P = P();
                i.g(str2);
                P.e();
                P.w();
                int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                if (i10 < 0) {
                    P.c().N().c("Invalid time querying timed out conditional properties", z0.I(str2), Long.valueOf(j10));
                    list = Collections.emptyList();
                } else {
                    list = P.c0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzed zzedVar : list) {
                    if (zzedVar != null) {
                        c().Q().b("User property timed out", zzedVar.f9876a, J().O(zzedVar.f9878c.f9893b), zzedVar.f9878c.G0());
                        if (zzedVar.f9882g != null) {
                            y(new zzeu(zzedVar.f9882g, j10), zzdzVar);
                        }
                        P().F0(str2, zzedVar.f9878c.f9893b);
                    }
                }
                d0 P2 = P();
                i.g(str2);
                P2.e();
                P2.w();
                if (i10 < 0) {
                    P2.c().N().c("Invalid time querying expired conditional properties", z0.I(str2), Long.valueOf(j10));
                    list2 = Collections.emptyList();
                } else {
                    list2 = P2.c0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzed zzedVar2 : list2) {
                    if (zzedVar2 != null) {
                        c().Q().b("User property expired", zzedVar2.f9876a, J().O(zzedVar2.f9878c.f9893b), zzedVar2.f9878c.G0());
                        P().n0(str2, zzedVar2.f9878c.f9893b);
                        zzeu zzeuVar2 = zzedVar2.f9886k;
                        if (zzeuVar2 != null) {
                            arrayList.add(zzeuVar2);
                        }
                        P().F0(str2, zzedVar2.f9878c.f9893b);
                    }
                }
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj2 = arrayList.get(i11);
                    i11++;
                    y(new zzeu((zzeu) obj2, j10), zzdzVar);
                }
                d0 P3 = P();
                String str3 = zzeuVar.f9888a;
                i.g(str2);
                i.g(str3);
                P3.e();
                P3.w();
                if (i10 < 0) {
                    P3.c().N().b("Invalid time querying triggered conditional properties", z0.I(str2), P3.o().M(str3), Long.valueOf(j10));
                    list3 = Collections.emptyList();
                } else {
                    list3 = P3.c0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzed zzedVar3 : list3) {
                    if (zzedVar3 != null) {
                        zzjx zzjxVar = zzedVar3.f9878c;
                        q5 q5Var = new q5(zzedVar3.f9876a, zzedVar3.f9877b, zzjxVar.f9893b, j10, zzjxVar.G0());
                        if (P().T(q5Var)) {
                            K = c().Q();
                            str = "User property triggered";
                            I = zzedVar3.f9876a;
                            O = J().O(q5Var.f9615c);
                            obj = q5Var.f9617e;
                        } else {
                            K = c().K();
                            str = "Too many active user properties, ignoring";
                            I = z0.I(zzedVar3.f9876a);
                            O = J().O(q5Var.f9615c);
                            obj = q5Var.f9617e;
                        }
                        K.b(str, I, O, obj);
                        zzeu zzeuVar3 = zzedVar3.f9884i;
                        if (zzeuVar3 != null) {
                            arrayList2.add(zzeuVar3);
                        }
                        zzedVar3.f9878c = new zzjx(q5Var);
                        zzedVar3.f9880e = true;
                        P().Q(zzedVar3);
                    }
                }
                y(zzeuVar, zzdzVar);
                int size2 = arrayList2.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj3 = arrayList2.get(i12);
                    i12++;
                    y(new zzeu((zzeu) obj3, j10), zzdzVar);
                }
                P().C();
            } finally {
                P().A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(i5 i5Var) {
        this.f9401l++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u(zzjx zzjxVar, zzdz zzdzVar) {
        p();
        U();
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            int g02 = K().g0(zzjxVar.f9893b);
            int i10 = 0;
            if (g02 != 0) {
                K();
                String G = r5.G(zzjxVar.f9893b, 24, true);
                String str = zzjxVar.f9893b;
                K().N(zzdzVar.f9859a, g02, "_ev", G, str != null ? str.length() : 0);
                return;
            }
            int v02 = K().v0(zzjxVar.f9893b, zzjxVar.G0());
            if (v02 != 0) {
                K();
                String G2 = r5.G(zzjxVar.f9893b, 24, true);
                Object G0 = zzjxVar.G0();
                if (G0 != null && ((G0 instanceof String) || (G0 instanceof CharSequence))) {
                    i10 = String.valueOf(G0).length();
                }
                K().N(zzdzVar.f9859a, v02, "_ev", G2, i10);
                return;
            }
            Object w02 = K().w0(zzjxVar.f9893b, zzjxVar.G0());
            if (w02 != null) {
                q5 q5Var = new q5(zzdzVar.f9859a, zzjxVar.f9897f, zzjxVar.f9893b, zzjxVar.f9894c, w02);
                c().Q().c("Setting user property", J().O(q5Var.f9615c), w02);
                P().z();
                try {
                    H(zzdzVar);
                    boolean T = P().T(q5Var);
                    P().C();
                    if (T) {
                        c().Q().c("User property set", J().O(q5Var.f9615c), q5Var.f9617e);
                    } else {
                        c().K().c("Too many unique user properties are set. Ignoring user property", J().O(q5Var.f9615c), q5Var.f9617e);
                        K().N(zzdzVar.f9859a, 9, null, null, 0);
                    }
                } finally {
                    P().A();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
        L().f9434g.b(b().b());
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120 A[Catch: all -> 0x0163, TryCatch #1 {all -> 0x016c, blocks: (B:4:0x000c, B:5:0x000e, B:43:0x00e6, B:44:0x00ea, B:51:0x0107, B:62:0x015e, B:6:0x0027, B:15:0x0043, B:20:0x005d, B:27:0x00a4, B:28:0x00b5, B:31:0x00bd, B:34:0x00c9, B:36:0x00cf, B:41:0x00dc, B:47:0x00f3, B:49:0x00fd, B:52:0x010c, B:54:0x0120, B:55:0x012e, B:56:0x0144, B:58:0x014e, B:60:0x0154, B:61:0x0157), top: B:66:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012e A[Catch: all -> 0x0163, TryCatch #1 {all -> 0x016c, blocks: (B:4:0x000c, B:5:0x000e, B:43:0x00e6, B:44:0x00ea, B:51:0x0107, B:62:0x015e, B:6:0x0027, B:15:0x0043, B:20:0x005d, B:27:0x00a4, B:28:0x00b5, B:31:0x00bd, B:34:0x00c9, B:36:0x00cf, B:41:0x00dc, B:47:0x00f3, B:49:0x00fd, B:52:0x010c, B:54:0x0120, B:55:0x012e, B:56:0x0144, B:58:0x014e, B:60:0x0154, B:61:0x0157), top: B:66:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(String str, int i10, Throwable th2, byte[] bArr, Map<String, List<String>> map) {
        d0 P;
        p();
        U();
        i.g(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f9403n = false;
                Z();
            }
        }
        c().R().d("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        P().z();
        v f02 = P().f0(str);
        boolean z10 = true;
        boolean z11 = (i10 == 200 || i10 == 204 || i10 == 304) && th2 == null;
        if (f02 == null) {
            c().N().d("App does not exist in onConfigFetched. appId", z0.I(str));
        } else {
            if (!z11 && i10 != 404) {
                f02.V(b().b());
                P().L(f02);
                c().R().c("Fetching config failed. code, error", Integer.valueOf(i10), th2);
                Q().G(str);
                L().f9433f.b(b().b());
                if (!(i10 == 503 || i10 == 429)) {
                    z10 = false;
                }
                Y();
            }
            List<String> list = map != null ? map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
            if (!(i10 == 404 || i10 == 304)) {
                if (!Q().C(str, bArr, str2)) {
                    P = P();
                    P.A();
                }
                f02.U(b().b());
                P().L(f02);
                if (i10 != 404) {
                    c().O().d("Config not found. Using empty config. appId", str);
                } else {
                    c().R().c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                }
                if (R().C() && X()) {
                    W();
                }
                Y();
            }
            if (Q().E(str) == null && !Q().C(str, null, null)) {
                P = P();
                P.A();
            }
            f02.U(b().b());
            P().L(f02);
            if (i10 != 404) {
            }
            if (R().C()) {
                W();
            }
            Y();
        }
        P().C();
        P = P();
        P.A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(zzed zzedVar, zzdz zzdzVar) {
        i.k(zzedVar);
        i.g(zzedVar.f9876a);
        i.k(zzedVar.f9878c);
        i.g(zzedVar.f9878c.f9893b);
        p();
        U();
        if (!TextUtils.isEmpty(zzdzVar.f9860b)) {
            if (!zzdzVar.f9866h) {
                H(zzdzVar);
                return;
            }
            P().z();
            try {
                H(zzdzVar);
                zzed C0 = P().C0(zzedVar.f9876a, zzedVar.f9878c.f9893b);
                if (C0 != null) {
                    c().Q().c("Removing conditional user property", zzedVar.f9876a, J().O(zzedVar.f9878c.f9893b));
                    P().F0(zzedVar.f9876a, zzedVar.f9878c.f9893b);
                    if (C0.f9880e) {
                        P().n0(zzedVar.f9876a, zzedVar.f9878c.f9893b);
                    }
                    zzeu zzeuVar = zzedVar.f9886k;
                    if (zzeuVar != null) {
                        Bundle bundle = null;
                        zzer zzerVar = zzeuVar.f9889b;
                        if (zzerVar != null) {
                            bundle = zzerVar.L0();
                        }
                        r5 K = K();
                        zzeu zzeuVar2 = zzedVar.f9886k;
                        y(K.D(zzeuVar2.f9888a, bundle, C0.f9877b, zzeuVar2.f9891d, true, false), zzdzVar);
                    }
                } else {
                    c().N().c("Conditional user property doesn't exist", z0.I(zzedVar.f9876a), J().O(zzedVar.f9878c.f9893b));
                }
                P().C();
            } finally {
                P().A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(zzeu zzeuVar, String str) {
        v f02 = P().f0(str);
        if (f02 == null || TextUtils.isEmpty(f02.g())) {
            c().Q().d("No app data available; dropping event", str);
            return;
        }
        Boolean w10 = w(f02);
        if (w10 == null) {
            if (!"_ui".equals(zzeuVar.f9888a)) {
                c().N().d("Could not find package. appId", z0.I(str));
            }
        } else if (!w10.booleanValue()) {
            c().K().d("App version does not match; dropping event. appId", z0.I(str));
            return;
        }
        s(zzeuVar, new zzdz(str, f02.b(), f02.g(), f02.v(), f02.w(), f02.x(), f02.y(), (String) null, f02.c(), false, f02.s(), f02.L(), 0L, 0, f02.M(), f02.N(), false));
    }
}
