# Uppsetning
- búa til möppu fyrir verkefni
- opna terminal, fara í möppuna 
- git clone https://github.com/adalheidur00/HVD-4D.git
- opna repo í intellij
- 


### Ef það koma fullt af villum við keyrslu sem virðast ekki tengjast neinu ákvðenu
### t.d :
Exception in Application start method
java.lang.reflect.InvocationTargetException
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:118)
at java.base/java.lang.reflect.Method.invoke(Method.java:580)
at javafx.graphics@21/com.sun.javafx.application.LauncherImpl.launchApplicationWithArgs(LauncherImpl.java:464)
at javafx.graphics@21/com.sun.javafx.application.LauncherImpl.launchApplication(LauncherImpl.java:364)
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
at java.base/java.lang.reflect.Method.invoke(Method.java:580)
at java.base/sun.launcher.LauncherHelper$FXHelper.main(LauncherHelper.java:1135)
Caused by: java.lang.RuntimeException: Exception in Application start method
at javafx.graphics@21/com.sun.javafx.application.LauncherImpl.launchApplication1(LauncherImpl.java:893)
at javafx.graphics@21/com.sun.javafx.application.LauncherImpl.lambda$launchApplication$2(LauncherImpl.java:196)
at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.lang.IllegalStateException: Location is not set.
at javafx.fxml@21/javafx.fxml.FXMLLoader.loadImpl(FXMLLoader.java:2556)
at javafx.fxml@21/javafx.fxml.FXMLLoader.load(FXMLLoader.java:2531)
at com.example.hbv4d@1.0-SNAPSHOT/com.example.hbv4d.Application.start(Application.java:12)
at javafx.graphics@21/com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$9(LauncherImpl.java:839)
at javafx.graphics@21/com.sun.javafx.application.PlatformImpl.lambda$runAndWait$12(PlatformImpl.java:483)
at javafx.graphics@21/com.sun.javafx.application.PlatformImpl.lambda$runLater$10(PlatformImpl.java:456)
at java.base/java.security.AccessController.doPrivileged(AccessController.java:400)
at javafx.graphics@21/com.sun.javafx.application.PlatformImpl.lambda$runLater$11(PlatformImpl.java:455)
at javafx.graphics@21/com.sun.glass.ui.InvokeLaterDispatcher$Future.run(InvokeLaterDispatcher.java:95)
Exception running application com.example.hbv4d.Application

- keyra mvn clean package í terminal 
- keyra aftur
