package com.example.frosty.bulldog;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Vector<String> strings = new Vector<String>(10,10); //will store strings the user submits. hopefully
    private EditText password;
    private Button btnSubmit;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        strings.add("hello");
        strings.add("world");
        strings.add("davis");
        strings.add("hackathon");
        strings.add("hackdavis");
        strings.add("test");

        final Animation in = new AlphaAnimation(0.0f,1.0f);
        in.setDuration(3000);
        final Animation out = new AlphaAnimation(1.0f,0.0f);
        out.setDuration(3000);

        final AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(in);
        animation.addAnimation(out);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FloatingActionButton FAB = (FloatingActionButton) v;
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }
        }); */

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v)
            {
                TextView textView1 = (TextView) findViewById(R.id.text1);
                TextView textView2 = (TextView) findViewById(R.id.text2);
                TextView textView3 = (TextView) findViewById(R.id.text3);
                TextView textView4 = (TextView) findViewById(R.id.text4);

                textView1.setText(changeString());
                textView2.setText(changeString());
                textView3.setText(changeString());
                textView4.setText(changeString());
            }
        });
        addListenerOnButton();
    }   //onCreate. does this stuff on startup

    String changeString() {
        Random rand = new Random();
        return strings.get(rand.nextInt(strings.size()));
    }


    public void addListenerOnButton() {
        password = (EditText) findViewById(R.id.blah);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              strings.add(password.getText().toString());
              Toast toast = new Toast(getApplicationContext());
              toast.setGravity(Gravity.TOP| Gravity.LEFT, 0, 0);
              toast.makeText(MainActivity.this, password.getText(), toast.LENGTH_SHORT).show();
              password.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
