package com.example.tutorialproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create 2 buttons, 1 for the idChange view and the other for the secondButton view
        //Use the buttons to open the 2 new activities.

        Button button1 = findViewById(R.id.idChange);
        Button button2 = findViewById(R.id.secondButton);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity2();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity3();
            }
        });


    }
    //For startActivity2(), you want to start the activity2.class using the intent class's startActivity() method
    public void startActivity2(){
        Intent intent1 = new Intent(this, Activity2.class);
        startActivity(intent1);
    }
    //For startActivity3(), basically do the same as above
    public void startActivity3(){
        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }
}


// Another project added on top of this exercise in using intents to open new activities is to use intents
// to create shortcuts for the app's icon. If you long press an icon, it will bring up shortcuts for the app.
// These shortcuts can be either static or dynamic at runtime. Static means for any actions that are common such as
// opening up a certain page in the app. The dynamic shortcuts are for when the user needs to enter new information
// each time the intent has to be sent. Such as user location, new searches, new numbers, etc.

// So for the shortcuts, we will be using intents again to create them. Each shortcut uses 1 intent and each app can have
// 5 shortcuts. Only the main activity can have the shortcut codes.

// There is also pin shortcuts. Pin shortcuts are basically custom made shortcuts by the user such as pinning a specific website
// to a browser app.

/* To create a static shortcut:
1. Go into your app's AndroidManifest.xml and see which activity has the MAIN and LAUNCHER in the filter bracket
2. Add a meta-data element after the filter element and inside the activity element. To do this enter the following:
<meta-data android:name="android.app.shortcuts"
                 android:resource="@xml/shortcuts" />
3. Create a new resource file at res/xml/shortcuts.xml
4. In the new shortcuts.xml file, add the following code in xml:
<shortcuts xmlns:android="http://schemas.android.com/apk/res/android">
  <shortcut
    android:shortcutId="compose"
    android:enabled="true"
    android:icon="@drawable/compose_icon"
    android:shortcutShortLabel="@string/compose_shortcut_short_label1"
    android:shortcutLongLabel="@string/compose_shortcut_long_label1"
    android:shortcutDisabledMessage="@string/compose_disabled_message1">
    <intent
      android:action="android.intent.action.VIEW"
      android:targetPackage="com.example.myapplication"
      android:targetClass="com.example.myapplication.ComposeActivity" />
    <!-- If your shortcut is associated with multiple intents, include them
         here. The last intent in the list determines what the user sees when
         they launch this shortcut. -->
    <categories android:name="android.shortcut.conversation" />
  </shortcut>
  <!-- Specify more shortcuts here. -->
</shortcuts>

You will need to specify the values for shortcutId and shortcutShortLabel. The rest are optional to have.
shortcutId cannot be linked to a resource string, it has to be a hard coded string.
shortcutShortLabel is a resource string that should be a concise description of what the shortcut does. It should be less than
10 words. This value cannot be hard coded.
The intent element must be included in all static shortcuts

https://developer.android.com/guide/topics/ui/shortcuts/creating-shortcuts    go to this link to look up what the other attributes
are for. I will have read them and hopefully i sort of remember when I review this again.

Quick note on my review: The shortcutID in the shortcuts.xml, you can assign this your own value. It does not have to match
another name found in a different class. You define the name when initializing the shortcutId.
*/
