#include "../../../../../../../Library/Android/sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/darwin-x86_64/sysroot/usr/include/c++/v1/cstdio"

#include "../lame/lame.h"


//
// Created by sherlock on 2021/7/22.
//
class Mp3Encoder {
private:
    FILE *pcmFile;
    FILE *mp3File;
    lame_t lameClient;
public:
    Mp3Encoder();

    ~Mp3Encoder();

    int Init(const char *pcmFilepath, const char *mp3FilePath, int sampleRate, int channels,
             int bitRate);

    void Encode();

    void Destory();
};


