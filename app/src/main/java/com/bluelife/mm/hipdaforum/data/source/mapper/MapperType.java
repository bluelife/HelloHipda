package com.bluelife.mm.hipdaforum.data.source.mapper;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by HiWin10 on 2016/4/23.
 */
@IntDef({MapperType.BOARD,MapperType.POST,MapperType.SMS,MapperType.THREAD})
@Retention(RetentionPolicy.SOURCE)
public @interface MapperType {
    int BOARD=0;
    int THREAD=1;
    int SMS=2;
    int POST=3;
}
