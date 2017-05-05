package org.yh.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_notice).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showNotificaiton();
            }
        });
    }

    private void showNotificaiton()
    {
        Intent intent = new Intent(this, NotifiacitonActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        android.support.v4.app.NotificationCompat.InboxStyle style = new android.support.v4.app.NotificationCompat.InboxStyle();
        style.setBigContentTitle("BigContentTitle")
                .addLine("第一行，第一行，第一行，第一行，第一行，第一行，第一行")
                .addLine("第二行")
                .addLine("第三行")
                .addLine("第四行")
                .addLine("第五行")
                .setSummaryText("SummaryText");
        NotificationManager manager = (NotificationManager) getSystemService(Context
                .NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                //通知的标题
                .setContentTitle("This is content title")
                //通知的内容
                //.setContentText("This is content text")
                //通知的时间
                .setWhen(System.currentTimeMillis())
                //通知的小图标 使用纯alpha图层的图片
                .setSmallIcon(R.mipmap.ic_launcher)
                //通知的大图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                //通知跳转
                .setContentIntent(pi)
                //是否自动消失
                .setAutoCancel(true)
                //通知生成时候发送一个声音
                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                //震动
                .setVibrate(new long[]{0, 1000, 1000, 1000})
                //LED灯
                .setLights(Color.GREEN, 1000, 1000)
                //设置默认的通知声音和震动
                .setDefaults(Notification.DEFAULT_ALL)
                //设置长文本 图片
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build " +
                        "notifications, send and sync data, and use voice actions. Get the " +
                        "official Android IDE and developer tools to build apps for Android."))

//                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory
//                        .decodeResource(getResources(), R.drawable.big_image)))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();
        manager.notify(1, notification);

    }
}
