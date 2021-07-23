package com.demo.mp3encodertest;

/**
 * Copyright (C), 2015-2021, 乐普（北京）医疗器械股份有限公司
 * Author: liguangyao
 * Date: 2021/7/22 2:58 PM
 * Description:
 */
class Mp3Encoder {
    public native int init(String pcmPath, int audioChannels, int bitRate, int
            sampleRate, String mp3Path);

    public native void encode();

    public native void destroy();
}
