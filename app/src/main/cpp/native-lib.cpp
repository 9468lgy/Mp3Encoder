#include <jni.h>
#include <string>
#include "mp3_encoder/Mp3Encoder.h"

Mp3Encoder *encoder = NULL;

extern "C" JNIEXPORT jint JNICALL
Java_com_demo_mp3encodertest_Mp3Encoder_init(JNIEnv *env, jobject thiz, jstring pcm_path,
                                             jint audio_channels, jint bit_rate, jint sample_rate,
                                             jstring mp3_path) {
    const char *pcmPath = env->GetStringUTFChars(pcm_path, NULL);
    const char *mp3Path = env->GetStringUTFChars(mp3_path, NULL);
    encoder = new Mp3Encoder();
    int res = encoder->Init(pcmPath, mp3Path, sample_rate, audio_channels, bit_rate);
    env->ReleaseStringUTFChars(mp3_path, mp3Path);
    env->ReleaseStringUTFChars(pcm_path, pcmPath);
    return res;
}
extern "C" JNIEXPORT void JNICALL
Java_com_demo_mp3encodertest_Mp3Encoder_destroy(JNIEnv *env, jobject thiz) {
    encoder->Destory();
}
extern "C" JNIEXPORT void JNICALL
Java_com_demo_mp3encodertest_Mp3Encoder_encode(JNIEnv *env, jobject thiz) {
    encoder->Encode();
}
