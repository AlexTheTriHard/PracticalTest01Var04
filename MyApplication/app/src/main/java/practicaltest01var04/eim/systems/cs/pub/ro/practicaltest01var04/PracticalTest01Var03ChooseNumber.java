package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


public class PracticalTest01Var03ChooseNumber extends ActionBarActivity implements View.OnClickListener {
    private EditText scoreField = null;
    private EditText guessField = null;
    private Button backButton = null;
    private Button generateButton = null;
    private Button checkButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);

        scoreField = (EditText)findViewById(R.id.scoreField);
        guessField = (EditText)findViewById(R.id.guessField);

        backButton = (Button)findViewById(R.id.backButton);
        generateButton = (Button)findViewById(R.id.generateNumberButton);
        checkButton = (Button)findViewById(R.id.checkNumberButton);
        backButton.setOnClickListener(this);
        generateButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var03_choose_number, menu);
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
    Thread changeValue = new Thread() {

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // update TextView here!
                            scoreField.setText("");
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.generateNumberButton:
                Random rand = new Random();
                int randomNum = rand.nextInt(9 - 0 + 1) + 0;
                scoreField.setText(String.valueOf(randomNum));
                if (changeValue.isAlive())
                    changeValue.stop();
                changeValue.start();
                break;
        }
    }
}
