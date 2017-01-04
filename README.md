# spring-shiro-demo
spring-shiro-demo

#权限配置
```xml
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">

		<property name="securityManager" ref="securityManager"></property>
		<property name="loginUrl" value="/security/view/login"></property>
		<property name="successUrl" value="/successUrl"></property>
		<!-- 用户访问未对其授权的资源时，所显示的连接 -->
		<property name="unauthorizedUrl" value="/unauthorizedUrl"></property>
		<property name="filters">
			<map>
				<entry key="anyRoles">
					<bean class="cn.edu.hdu.ssd.core.shiro.AnyRolesAuthorizationFilter" />
				</entry>
			</map>
		</property>
		<property name="filterChainDefinitions">
			<value>
				/security/**=anon
				/test/**=roles[role1]
				/users/**=anyRoles[admin,role1]
				/**=authc
			</value>
		</property>
	</bean>
``` 
#测试步骤
######登录：http://localhost:8080/ssd/security/login   ----->角色:admin，用户名:admin,密码：21232f297a57a5a743894a0e4a801fc3
######权限测试：http://localhost:8080/ssd/users ----->访问成功
######权限测试：http://localhost:8080/ssd/test/access ----->访问失败，无访问权限
######换个角色登录，修改UserRealm.java里的角色为roler1，重新登录http://localhost:8080/ssd/security/login
######权限测试：http://localhost:8080/ssd/users ----->访问成功
######权限测试：http://localhost:8080/ssd/test/access ----->访问成功
