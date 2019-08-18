package com.yang.designpattern.actionpattern.interpreter;

/**
 * @author: Yang
 * @date: 2019/8/18 11:44
 * @description: 解释器模式【了解即可】，通常用于自定义一种新语言时使用。
 * 用以描述如何构建一个简单的语言解释器，在使用面向对象语言开发其他语言的编译器或解释器上。
 * 在实践中尽量不要使用此模式来构建自己的解释器，如有需要在java中实现动态语言特性，
 * 可以使用Jruby、Groovy、jvm内置的js引擎，以弥补java的不足。
 * 比如计算字符串算式"1 + 3 * 8"，此时不必自己用java去解析算是，因为用js引擎就可以轻松搞定。
 * 使用案例：EL表达式、SQL解析器、正则表达式、数学表达式的解析器。
 * 【数学表达式工具包：Math Expression String Parser、Expression4J】
 */
public class InterpreterModel {
}
