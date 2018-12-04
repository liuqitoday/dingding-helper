### 前提

办公室有下班不关机的电脑和一部安卓手机。

### 工作原理

利用安卓USB调试，执行adb命令模拟屏幕操作，常用的命令方式如下：

```
adb shell input tap <x> <y>
adb shell input keyevent <key code number or name>
adb shell input swipe <x1> <y1> <x2> <y2>
adb shell input text <string>
```

### 准备工作

- 下载ADB

  [https://www.xda-developers.com/install-adb-windows-macos-linux/](https://www.xda-developers.com/install-adb-windows-macos-linux/)

- 配置环境变量

- 修改各个步骤中涉及到的操作坐标。

  可以利用手机截屏然后在电脑上利用画图软件来查看所需要点击位置的坐标。

- 修改代码中发送邮件提醒的邮箱账号密码、登陆的钉钉密码等标记TODO的地方。

### 运行

- ide中main方法运行

- 打包，执行jar包

  ```
  mvn clean package
  java -jar dingding-helper-1.0-SNAPSHOT-jar-with-dependencies.jar
  ```