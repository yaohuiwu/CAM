CBAM
====

A criteria based authorization model framework.

In order to using in spring environment , you must provide dataSource and userContextProvider bean first.
And add the following config (modify expression attribute of pointcut to fit your application):


CBAM system configuration
=========================

<bean id="userContextProvider" class="org.cbam.core.mock.MockUserContextProvider"/>
<util:properties id="cbamUtil">
    <prop key="pointCutExpression">execution(* org.learning.spring.hello.service.*.*(..))</prop>
</util:properties>