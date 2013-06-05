package com.example.testpopup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.testpopup.QuickActionWidget.OnQuickActionClickListener;

public class MainActivity extends Activity implements OnClickListener {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    QuickActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) this.findViewById(R.id.button);
        button2 = (Button) this.findViewById(R.id.button2);
        button3 = (Button) this.findViewById(R.id.button3);
        button4 = (Button) this.findViewById(R.id.button4);
        button5 = (Button) this.findViewById(R.id.button5);
        button6 = (Button) this.findViewById(R.id.button6);
        button7 = (Button) this.findViewById(R.id.button7);
        button8 = (Button) this.findViewById(R.id.button8);
        button9 = (Button) this.findViewById(R.id.button9);
        bar = new QuickActionBar(this);

        bar.addQuickAction(new MyQuickAction(this, R.drawable.ic_launcher, R.string.hello_world));
        bar.addQuickAction(new MyQuickAction(this, R.drawable.ic_launcher, R.string.hello_world));
        bar.addQuickAction(new MyQuickAction(this, R.drawable.ic_launcher, R.string.hello_world));
        bar.addQuickAction(new MyQuickAction(this, R.drawable.ic_launcher, R.string.hello_world));
        bar.setOnQuickActionClickListener(mActionListener);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    static class MyQuickAction extends QuickAction {
        private static final ColorFilter BLACK_CF = new LightingColorFilter(Color.BLACK,
                Color.BLACK);

        public MyQuickAction(Context ctx, int drawableId, int titleId) {
            super(ctx, buildDrawable(ctx, drawableId), titleId);
        }

        public static Drawable buildDrawable(Context ctx, int drawableId) {
            Drawable d = ctx.getResources().getDrawable(drawableId);
            d.setColorFilter(BLACK_CF);
            return d;
        }
    }

    private OnQuickActionClickListener mActionListener = new OnQuickActionClickListener() {
        public void onQuickActionClicked(QuickActionWidget widget, int position) {
            switch (position) {
            case 0:
                Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        bar.show(v);
    }
}
