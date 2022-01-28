package com.example.messagingstompwebsocket;

public class Greeting {
    private String content;

    public Greeting() {

    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

/*
    マーシャリング（marshalling）
    マーシャリングとは、異なる技術基盤で実装されたコンピュータプログラム間で、データの交換や機能の呼び出しができるようデータ形式の変換などを行うこと。
*/