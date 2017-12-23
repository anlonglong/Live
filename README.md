
![斗鱼TV](https://staticlive.douyucdn.cn/upload/signs/201610291926483131.png)
# 模仿斗鱼Tv项目
## 版权说明：该项目纯属练手项目，不作为商用项目！有涉及到侵权请告知删除，涉及商用侵权与本人无关


## 目录结构
- [开发环境](#1.0.0)
- [应用截图](#2.0.0)
- [下载地址](#3.0.0)
- [接口文档说明](#4.0.0)
- [项目中使用到的三方库说明](#5.0.0)
- [项目反馈](#6.0.0)
- [参考资料](#7.0.0)
- [Issuse Me](#8.0.0)

<h2 id="1.0.0"> 一.开发环境</h2>

| 开发工具  | 开发语言      |SDK版本 |JDK版本|
|:------ |:---------:| :-----:     | :-----:     |
| AndroidStudio3.1   | JAVA | 26 |  1.7 |
 
<h2 id="3.0.0">三.应用截图</h2>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/678D6ACFDFAA01AC6333EC682F1A1D57.png" width="50%" height="50%" />
   <p>
  <h5>2.1.1图</h5>
  </p>
</center>
<div></div>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/DACCBB63F4390F462D498615DCAA4BC7.png" width="50%" height="50%" />
   <p>
  <h5>2.1.2图</h5>
  </p>
</center>
<div></div>

  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/97901F29A1B07C41B574829D8EAD29A1.png" width="50%" height="50%" />
   <p>
  <h5>2.1.3图</h5>
  </p>
</center>
<div></div>

  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/DFC42CEC41072AF3F06FB110CAC385CC.png" width="50%" height="50%" />
   <p>
  <h5>2.1.4图</h5>
  </p>
</center>
<div></div>

  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/04A99D0900B1418A37943CCE169E2C3D.png" width="50%" height="50%" />
   <p>
  <h5>2.1.5图</h5>
  </p>
</center>
<div></div>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/7540E9A56688E00078BBD79554B000E1.png" width="50%" height="50%" />
   <p>
  <h5>2.1.6图</h5>
  </p>
</center>
<div></div>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/3C42F496B3D447D3009DC543D1477186.png" width="50%" height="50%" />
   <p>
  <h5>2.1.7图</h5>
  </p>
</center>
<div></div>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/35692D640637F2A6D2FCF09F9E8B4C48.jpg" width="50%" height="50%" />
   <p>
  <h5>2.1.8图</h5>
  </p>
</center>
<div></div>
  <center>
<img src="https://github.com/mykj/DouYu/blob/master/upload_image/5FC86F4A3DAE79B29DF275C69B7B75A7.jpg" width="50%" height="50%" />
   <p>
  <h5>2.1.9图</h5>
  </p>
</center>
<div></div>
    
<h2 id="4.0.0">四.下载地址</h2>

   下载方式
   ---

       
       
  * 1.下载地址:[点击这里](https://fir.im/DouYu)
     
   ---
  
<h2 id="5.0.0">五.斗鱼接口文档</h2>
 
  * [首页API文档说明](https://github.com/TeamCodeForGit/DouYu/blob/master/document/HomeApi.md)
  *  [直播API文档说明](https://github.com/TeamCodeForGit/DouYu/blob/master/document/LiveApi.md)
  *  [视频API文档说明](https://github.com/TeamCodeForGit/DouYu/blob/master/document/VideoApi.md)
  *  [关注API文档说明](https://github.com/TeamCodeForGit/DouYu/blob/master/document/HomeApi.md)
  *  [个人API文档说明](https://github.com/TeamCodeForGit/DouYu/blob/master/document/HomeApi.md)
  
  ---
  
<h2 id="6.0.0">六.Live/gradle 配置</h2>
   
   
apply plugin: 'com.android.application'
apply plugin: 'org.greenrobot.greendao'

apply plugin: 'com.neenbedankt.android-apt'
apply plugin: 'me.tatarka.retrolambda'

android {
    compileSdkVersion java.lang.Integer.parseInt(ANDROID_COMPILE_SDK_VERSION)
    buildToolsVersion project.ANDROID_BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId "cyou.bike.com.live"
        minSdkVersion Integer.parseInt(ANDROID_MIN_SDK_VERSION)
        targetSdkVersion Integer.parseInt(ANDROID_BUILD_TARGET_SDK_VERSION)
        versionCode Integer.parseInt(APP_VERSION_CODE)
        versionName project.APP_VERSION_NAME
        multiDexEnabled true
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

        //设置支持的.so架构
        ndk {
            abiFilters 'armeabi', 'arm64-v8a'//, 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
        }

    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }

        debug {
            versionNameSuffix "_" + System.getProperty("user.name", "ALLON") + "_Debug"
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }

    //指定生成DaoMaster 、DaoSession、Dao位置
    greendao {
        schemaVersion 1000
    }

    packagingOptions{
        exclude 'META-INF/NOTICE' // will not include NOTICE file
        exclude 'META-INF/LICENSE' // will not include LICENSE file
        exclude  'META-INF/DEPENDENCIES'
        exclude 'lib/armeabi-v7a/libndkbitmap.so'
    }


}

ext {
    supportLibraryVersion = project.ANDROID_SUPPORT_LIBRARY_VERSION
}




dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    //noinspection GradleCompatible
    compile "com.android.support:appcompat-v7:${supportLibraryVersion}"
    compile "com.android.support:design:${supportLibraryVersion}"
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    //greendao
    compile 'org.greenrobot:greendao:3.2.2'
    //ButterKnife
    compile 'com.jakewharton:butterknife:8.1.0'
    //BottomNavigation
    compile 'com.ashokvarma.android:bottom-navigation-bar:2.0.3'

    //SmartTabLayout
    compile 'com.ogaclejapan.smarttablayout:library:1.6.1@aar'
    compile 'com.ogaclejapan.smarttablayout:utils-v4:1.6.1@aar'
    compile 'com.ogaclejapan.smarttablayout:utils-v13:1.6.0@aar'
    //InfiniteCycleViewPager
    compile 'com.github.devlight:infinitecycleviewpager:1.0.2'
    //eventbus
    compile 'org.greenrobot:eventbus:3.1.0-RC'
    compile 'com.android.support:support-v4:25.3.1'
    testCompile 'junit:junit:4.12'
    apt 'com.jakewharton:butterknife-compiler:8.1.0'
    //刷新
    compile 'com.scwang.smartrefresh:SmartRefreshLayout:1.0.3'

    //okhttp
    compile 'com.squareup.okhttp3:okhttp:3.8.1'
    compile 'com.squareup.okhttp3:logging-interceptor:3.3.1'

    //gson
    compile 'com.google.code.gson:gson:2.8.2'

    //fastJson
    compile 'com.alibaba:fastjson:1.1.62.android'

    //dagger2
    compile 'com.google.dagger:dagger:2.4'
    apt 'com.google.dagger:dagger-compiler:2.4'
    //java注解
    compile 'org.glassfish:javax.annotation:10.0-b28'

    //BGAQRCode
    compile 'com.google.zxing:core:3.3.0'
    compile 'cn.bingoogolapple:bga-qrcodecore:1.1.7@aar'
    compile 'cn.bingoogolapple:bga-zxing:1.1.7@aar'

    //Fresco
    compile 'com.facebook.fresco:fresco:1.5.0'
    compile 'com.facebook.fresco:animated-gif:1.5.0'
    compile 'com.facebook.fresco:animated-webp:1.5.0'
    compile 'com.facebook.fresco:webpsupport:1.5.0'

    //BGABanner
    compile 'cn.bingoogolapple:bga-banner:2.1.8@aar'

    //adapter
    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.28'

    //superTextView
    compile 'com.github.lygttpod:SuperTextView:2.1.5'

    //adapter
    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.28'

    //Stetho
    compile 'com.facebook.stetho:stetho:1.3.1'

    //视频
    compile project(path: ':InitActivity')

    compile project(path: ':fragmentandactivitycommuncicationstruct')

    //loading
    compile 'com.wang.avi:library:2.1.3'
    compile 'com.nineoldandroids:library:2.4.0'

    //QRCode
    compile 'com.github.vondear:RxTools:v1.7.6'

    //直播
    compile 'tv.danmaku.ijk.media:ijkplayer-java:0.8.4'

    //弹幕
    compile 'com.github.ctiao:DanmakuFlameMaster:0.4.6'
    compile 'com.github.ctiao:ndkbitmap-armv7a:0.9.16'

    compile 'com.github.hackware1993:MagicIndicator:1.5.0'

    compile 'me.imid.swipebacklayout.lib:library:1.0.0'
    
    
    //底部导航栏
    compile 'com.flipboard:bottomsheet-core:1.5.3'
    compile 'com.flipboard:bottomsheet-commons:1.5.3' // optional


}

  ---
  
<h2 id="7.0.0">七.项目反馈</h2>
   
| 联系人  | QQ        |邮箱 |
|:------ |:---------:| :-----:     |
| 安龙龙  | 940752944 |anlonglong0721@gmail |


---
<h2 id="9.0.0">九.Issuse</h2>


  <div>&nbsp;&nbsp;&nbsp;&nbsp; 本项目所有的API用的这个项目中提供的(https://github.com/mykj/DouYu/issues),再次表示感谢，项目只适合分享，学习，交流！不得用于商业用途,项目还有很多的地方不完美,后期有时间会再此优化,欢迎statr&issues</div>)
   
&nbsp;<h6><center> Copyright 2017 anlonglong</center></h6>

---
 
