# quicktvui-apk-builder

## 1、开发环境配置
项目编译需要VUE和Android的开发环境，环境配置请 [参考这里](https://developer.extscreen.com/guide/#%E5%AE%89%E8%A3%85%E5%92%8C%E7%8E%AF%E5%A2%83%E9%85%8D%E7%BD%AE)
## 2、项目配置
修改app/local.properties文件:
``` properties
# AndroidSDK路径修改为自己电脑的SDK路径
sdk.dir=AndroidSDK路径
```
## 3、APK配置
### 3.1 根据需求修改apk项目根目录的app.json:
``` json
{
  "_app_package": "com.quicktv.sample",     // 生成APK的包名
  "_app_name": "QuickTV-Sample",            // 生成APK的名字
  "_version_code": 1,                       // 版本Code，最小是1
  "_version_name": "1.0.0",                 // 版本显示名称
  "_repository": "http://hub.quicktvui.com/repository/rpk", // 默认app加载源地
  "_load_app": "quicktv/hello_world"        // 加载应用名称
}
```
### 3.2 更新引入的SDK版本
```
// 引入runtime SDK
dependencies {
    implementation 'com.extscreen.runtime:official:2.8.0'
}
```

**SDK最新版本:**
![](
    https://img.shields.io/badge/dynamic/xml?url=https://nexus.extscreen.com/repository/maven-releases/com/extscreen/runtime/official/maven-metadata.xml&query=metadata/versioning/latest&label=latest
)

## 4、编译

``` bash
# 生成debug包
./gradlew app:assembleDebug
# 生成release包
./gradlew app:assembleRelease
```