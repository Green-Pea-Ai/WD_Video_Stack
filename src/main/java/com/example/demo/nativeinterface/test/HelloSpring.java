package com.example.demo.nativeinterface.test;

public class HelloSpring {
    // native란 시스템 하위 API들을 활용할 경우 사용한다.
    // native 키워드가 있으면 C, C++ 코드를 사용하겠다는 의미
    // Netty(JNI 베이스 고속 통신 라이브러리)
    // Java 9부터는 native를 수월하게 사용할 수 있다(부족한 점은 있음, JNI나 Netty로 대체)
    // 수업에서는 Netty 쓴다고 함
    public native String print();

    static {
        // System.out.println()
        // 라이브러리:
        //
        //
        System.loadLibrary("hello");
    }
}
