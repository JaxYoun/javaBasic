## 实现创建者和调用者的分离
### 简单工厂 PK 工厂方法
1. 结构复杂度：前者胜
2. 代码复杂度：前者胜
3. 客户端编程复杂度：前者胜
4. 管理复杂度：前者胜
5. 设计理论符合度：后者胜

实践中，更多的使用前者
-
用例：
1. JDK的Calander的getInstance方法。
2. JDBC的连接工厂。
3. Hibernate的session工厂。
4. spring之IOC容器创建bean，此时可能搭配原型模式使用。
5. 反射过程中Class对象的newInstance方法。