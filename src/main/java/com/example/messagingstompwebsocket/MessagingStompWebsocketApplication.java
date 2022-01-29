package com.example.messagingstompwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingStompWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingStompWebsocketApplication.class, args);
	}

}
/*
	@SpringBootApplicationは、次のすべてを追加する便利なアノテーション
		- @Configuration:アプリケーションコンテキストのBean定義のソースとしてクラスにタグをつける。
		- @EnableAutoConfiguration:クラスパス設定、他のBean、様々なプロパティ設定に基づいてBeanの追加をかいするようSpring Bootに指示する。
		例：spring-webmvcがクラスパスにある場合、このアノテーションはアプリケーションにWebアプリケーションとしてフラグを立て、DispatcherServletのセットアップなどの主要な動作をアクティブにする。
		- @ComponentScan: Springに、com/exampleパッケージ内の他のコンポーネント、構成、サービスを探して、コントローラーを検出させるように指示する。

	mainメソッドは、Spring BootのSpringApplication.run()メソッドをしようしてアプリケーションを起動する。
	XMLが1行もない。web.xmlファイルもない。
	このWebアプリケーションは100%純粋なJavaであり、接続機能やインフラストラクチャの構成に対処する必要はない。

	Bean
	BeanとはJavaBeansやEnterprise JavaBeansの使用に沿って開発された、部品化された再利用可能なJavaプログラム。

*/