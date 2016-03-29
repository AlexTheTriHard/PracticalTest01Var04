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


public class PracticalTest01Var02PlayActivity extends ActionBarActivity implements View.OnClickListener{
    private EditText scoreField = null;
    private EditText guessField = null;
    private Button backButton = null;
    private Button generateButton = null;
    private Button checkButton = null;
    private int enteredNumber,crtScore =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);
        scoreField = (EditText)findViewById(R.id.scoreField);
        guessField = (EditText)findViewById(R.id.guessField);

        backButton = (Button)findViewById(R.id.backButton);
        generateButton = (Button)findViewById(R.id.generateNumberButton);
        checkButton = (Button)findViewById(R.id.checkNumberButton);
        backButton.setOnClickListener(this);
        generateButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("enteredNumber")) {
            enteredNumber = intent.getIntExtra("enteredNumber", -1);
        }
        scoreField.setText(crtScore + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var02_play, menu);
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
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("scoreField", scoreField.getText().toString());
        savedInstanceState.putString("guessField", guessField.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("scoreField")) {
            scoreField.setText(savedInstanceState.getString("scoreField"));
        } else {
            scoreField.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("guessField")) {
            guessField.setText(savedInstanceState.getString("guessField"));
        } else {
            guessField.setText(String.valueOf(0));
        }
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
                            guessField.setText("");
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
                guessField.setText(String.valueOf(randomNum));

               // if (changeValue.isAlive())
               //     changeValue.stop();
               // changeValue.start();
                break;
            case R.id.checkNumberButton:
                if(enteredNumber == Integer.parseInt(guessField.getText().toString())){
                    crtScore++;
                    scoreField.setText(crtScore +"");
                }
                break;
        }
    }
}
