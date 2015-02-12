package de.kimminich.nabutimecop.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends ActionBarActivity {

    private static final String tag = "TimerActivity";

    private boolean timerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final TextView timer = (TextView) findViewById(R.id.timer);

        timer.setOnClickListener(new TextView.OnClickListener() { // TODO Handle click on entire screen are instead

            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    Log.i(tag, "Pausing timer.");
                    timer.setText(R.string.paused);
                } else {
                    Log.i(tag, "Starting timer.");
                    timer.setText("00:01"); // TODO Show value of countdown timer
                }
                timerRunning = !timerRunning;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timer, menu);
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
            // TODO Go to timer settings activity
            return true;
        } else if (id == R.id.action_reset) {
            final TextView timer = (TextView) findViewById(R.id.timer);
            timerRunning = false;
            timer.setText(R.string.start);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
