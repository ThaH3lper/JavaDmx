#include "Dmx.h"

JNIEXPORT jint JNICALL Java_Dmx_setupNative
(JNIEnv *, jobject, jint, jint) {
	return 1;
}

JNIEXPORT jboolean JNICALL Java_Dmx_sendNaitive
(JNIEnv *, jobject, jbyteArray) {
	return true;
}

JNIEXPORT void JNICALL Java_Dmx_closeNaitive
(JNIEnv *, jobject) {

}