# MyProgressBar
自定义圆形带动画ProgressBar，进度条

示例图片，图片如果不展示请出国即可
图片做了帧率压缩，所以有卡顿，实际效果顺滑

![](https://github.com/842869709/TestMyProgressBar/blob/master/test.gif)


## 1.用法
使用前，对于Android Studio的用户，可以选择添加:

方法一：Gradle： 在dependencies中添加引用：
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
	dependencies {
	        implementation 'com.github.842869709:TestMyProgressBar:Tag'
	}
```
方法二：Maven仓库
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
```
<dependency>
	    <groupId>com.github.842869709</groupId>
	    <artifactId>TestMyProgressBar</artifactId>
	    <version>Tag</version>
	</dependency>
```

## 2.功能参数与含义
配置参数|参数含义|参数类型|默认值
-|-|-|-
STROKWITH|	圆环的线条宽度|	dp|	10dp
BACKGROUND_COLOR|	背景色|	string|	#999999
FOREGROUND_COLOR|	前景色|	string|	#666666
INTERVAL|	绘制时间间隔|	string| 	10(毫秒)
TEXT_SIZE|	字体大小|	sp| 	10sp
TEXT_COLOR|	字体颜色|	string| 	#666666
IS_SHOW_TEXT|	标记是否显示文字|	boolean| 	true
Stroke_Cap|	显示圆角还是直角|	enum| 	ROUND圆角(默认)，BUTT直角，SQUARE
setProgress()|	设置最终进度|	int| 	0



## 3.代码参考
布局文件
直接放在任意布局内

```
<com.yxd.myprogressbar.MyProgressBar
            android:id="@+id/mpb"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:background="@android:color/white"
            app:STROKWITH="10dp"
            app:BACKGROUND_COLOR="#B589C4"
            app:FOREGROUND_COLOR="#3BA550"
            app:TEXT_COLOR="#3BA550"
            app:INTERVAL="10"
            app:TEXT_SIZE="60sp"
            app:IS_SHOW_TEXT="true"/>
```
示例
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#E1E26E">

    <FrameLayout
        android:layout_width="200dp"
        android:layout_height="200dp">
        <com.yxd.myprogressbar.MyProgressBar
            android:id="@+id/mpb"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:background="@android:color/white"
            app:STROKWITH="10dp"
            app:BACKGROUND_COLOR="#B589C4"
            app:FOREGROUND_COLOR="#3BA550"
            app:TEXT_COLOR="#3BA550"
            app:INTERVAL="10"
            app:TEXT_SIZE="60sp"
            app:IS_SHOW_TEXT="true"
            />
        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="@color/colorPrimary"
            android:layout_marginTop="99dp"
            android:visibility="invisible"/>
        <View
            android:layout_width="1dp"
            android:layout_height="match_parent"
            android:background="@color/colorPrimary"
            android:layout_marginLeft="99dp"
            android:visibility="invisible"/>

    </FrameLayout>

    <com.yxd.myprogressbar.MyProgressBar
        android:id="@+id/mpb2"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:background="@android:color/white"
        app:STROKWITH="6dp"
        app:BACKGROUND_COLOR="#999999"
        app:FOREGROUND_COLOR="#BD1161"
        app:TEXT_COLOR="#BD1161"
        app:INTERVAL="10"
        app:TEXT_SIZE="34sp"
        app:IS_SHOW_TEXT="true"
        android:layout_marginTop="10dp"
        />

    <com.yxd.myprogressbar.MyProgressBar
        android:id="@+id/mpb3"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:background="@android:color/white"
        app:STROKWITH="4dp"
        app:BACKGROUND_COLOR="#999999"
        app:FOREGROUND_COLOR="#FF000A"
        app:TEXT_COLOR="#FF000A"
        app:INTERVAL="10"
        app:TEXT_SIZE="14sp"
        app:IS_SHOW_TEXT="true"
        android:layout_marginTop="10dp"
        />

    <com.yxd.myprogressbar.MyProgressBar
        android:id="@+id/mpb4"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:background="@android:color/white"
        app:STROKWITH="20dp"
        app:BACKGROUND_COLOR="#999999"
        app:FOREGROUND_COLOR="#FF000A"
        app:TEXT_COLOR="#FF000A"
        app:INTERVAL="10"
        app:TEXT_SIZE="40sp"
        app:IS_SHOW_TEXT="true"
        app:Stroke_Cap="BUTT"
        android:layout_marginTop="10dp"
        />

</LinearLayout>
```

配置及初始化
```
package com.yxd.testmyprogressbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.yxd.myprogressbar.MyProgressBar;

public class MainActivity extends AppCompatActivity {

    private MyProgressBar myProgressBar;
    private MyProgressBar myProgressBar2;
    private MyProgressBar myProgressBar3;
    private MyProgressBar myProgressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProgressBar = findViewById(R.id.mpb);
        myProgressBar.setProgress(95);

        myProgressBar2 = findViewById(R.id.mpb2);
        myProgressBar2.setProgress(80);

        myProgressBar3 = findViewById(R.id.mpb3);
        myProgressBar3.setProgress(50);

        myProgressBar4 = findViewById(R.id.mpb4);
        myProgressBar4.setProgress(75);

    }
}

```
## v1.0.0 初始化提交
