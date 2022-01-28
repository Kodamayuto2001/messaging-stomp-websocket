package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
    アノテーション型 EanbleWebSocketMessageBroker
    個のアノテーションを@Configurationクラスに追加して、より高レベルのメッセージングサブプロトコルを使用して、WebSocketを介したブローカーによるメッセージングを有効にする。

    WebSocketConfigには@Configurationのアノテーションがつけられ、Spring構成クラスであることを示す。
    また、@EnableWebSocketMessageBrokerでアノテーションがつけられている。
    名前が示すように、@EnableWebSocketMessageBrokerはWebSocketメッセージ処理を有効にし、メッセージブローカーによって支援される。
*/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /*
        configureMessageBroker()メソッドは、WebSocketMessageBrokerConfigurerのデフォルトメソッドを実装して、メッセージブローカーを構成する。
        まず、enableSimpleBroker()を呼び出して、単純なメモリベースのメッセージブローカーが、/topicをプレフィックスとして持つ宛先でクライアントにグリーティングメッセージを戻すことができるようにする。
        また、@MessageMappingアノテーションがつけられたメソッドにバインドされているメッセージの/appプレフィックスも指定する。
        このプレフィックスは、全てのメッセージマッピングを定義するために使用されます。
        例：/app/helloは、GreetingController.greeting()メソッドが処理するためにマップされるエンドポイント
    */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }


    /*
        registerStompEndpoints()メソッドは/gs-guide-websocketエンドポイントを登録し、WebSocketが使用できな場合に代替トランスポートを使用できるようにSockJSフォールバックオプションを有効にする。
        SockJSクライアントは、/gs-guide-websocketへの接続を試み、利用可能な最適なトランスポート（websocket, xhr-streaming, xhr-polingなど）の使用を試みる。
    */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}

/*
    プレフィックス（prefix）
    プレフィックスとは、接頭辞、前につける、などの意味を持つ英単語。
    "prefix"のpre（「前」「先」などの意）のように、単語の先頭に不可して特定の意味を付け加える要素のこと。

    ブローカー
    仲介人

    フォールバック（fallback）
    何らかの問題が発生した際に「止まるよりは、しょぼいほうがマシでしょ？」な考えに基づいて、機能や性能を制限して動かし続けること
*/