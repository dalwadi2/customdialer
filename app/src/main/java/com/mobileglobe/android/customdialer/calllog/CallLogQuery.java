package com.mobileglobe.android.customdialer.calllog;


import com.google.common.collect.Lists;
import android.provider.CallLog.Calls;
import com.mobileglobe.android.customdialer.common.compat.CompatUtils;
import com.mobileglobe.android.customdialer.compat.DialerCompatUtils;
import java.util.List;
/**
 * The query for the call log table.
 */
public final class CallLogQuery {
    private static final String[] _PROJECTION_INTERNAL = new String[] {
            Calls._ID,                          // 0
            Calls.NUMBER,                       // 1
            Calls.DATE,                         // 2
            Calls.DURATION,                     // 3
            Calls.TYPE,                         // 4
            Calls.COUNTRY_ISO,                  // 5
            Calls.VOICEMAIL_URI,                // 6
            Calls.GEOCODED_LOCATION,            // 7
            Calls.CACHED_NAME,                  // 8
            Calls.CACHED_NUMBER_TYPE,           // 9
            Calls.CACHED_NUMBER_LABEL,          // 10
            Calls.CACHED_LOOKUP_URI,            // 11
            Calls.CACHED_MATCHED_NUMBER,        // 12
            Calls.CACHED_NORMALIZED_NUMBER,     // 13
            Calls.CACHED_PHOTO_ID,              // 14
            Calls.CACHED_FORMATTED_NUMBER,      // 15
            Calls.IS_READ,                      // 16
            Calls.NUMBER_PRESENTATION,          // 17
            Calls.PHONE_ACCOUNT_COMPONENT_NAME, // 18
            Calls.PHONE_ACCOUNT_ID,             // 19
            Calls.FEATURES,                     // 20
            Calls.DATA_USAGE,                   // 21
            Calls.TRANSCRIPTION,                // 22
    };
    public static final int ID = 0;
    public static final int NUMBER = 1;
    public static final int DATE = 2;
    public static final int DURATION = 3;
    public static final int CALL_TYPE = 4;
    public static final int COUNTRY_ISO = 5;
    public static final int VOICEMAIL_URI = 6;
    public static final int GEOCODED_LOCATION = 7;
    public static final int CACHED_NAME = 8;
    public static final int CACHED_NUMBER_TYPE = 9;
    public static final int CACHED_NUMBER_LABEL = 10;
    public static final int CACHED_LOOKUP_URI = 11;
    public static final int CACHED_MATCHED_NUMBER = 12;
    public static final int CACHED_NORMALIZED_NUMBER = 13;
    public static final int CACHED_PHOTO_ID = 14;
    public static final int CACHED_FORMATTED_NUMBER = 15;
    public static final int IS_READ = 16;
    public static final int NUMBER_PRESENTATION = 17;
    public static final int ACCOUNT_COMPONENT_NAME = 18;
    public static final int ACCOUNT_ID = 19;
    public static final int FEATURES = 20;
    public static final int DATA_USAGE = 21;
    public static final int TRANSCRIPTION = 22;
    // Indices for columns that may not be available, depending on the Sdk Version
    /**
     * Only available in versions >= M
     * Call {@link DialerCompatUtils#isCallsCachedPhotoUriCompatible()} prior to use
     */
    public static int CACHED_PHOTO_URI = -1;
    /**
     * Only available in versions > M
     * Call {@link CompatUtils#isNCompatible()} prior to use
     */
    public static int POST_DIAL_DIGITS = -1;
    public static int VIA_NUMBER = -1;
    public static final String[] _PROJECTION;
    static {
        List<String> projectionList = Lists.newArrayList(_PROJECTION_INTERNAL);
        if (DialerCompatUtils.isCallsCachedPhotoUriCompatible()) {
            projectionList.add(Calls.CACHED_PHOTO_URI);
            CACHED_PHOTO_URI = projectionList.size() - 1;
        }
        if (CompatUtils.isNCompatible()) {
            projectionList.add(CallsSdkCompat.POST_DIAL_DIGITS);
            POST_DIAL_DIGITS = projectionList.size() - 1;
            projectionList.add(CallsSdkCompat.VIA_NUMBER);
            VIA_NUMBER = projectionList.size() - 1;
        }
        _PROJECTION = projectionList.toArray(new String[projectionList.size()]);
    }
}
