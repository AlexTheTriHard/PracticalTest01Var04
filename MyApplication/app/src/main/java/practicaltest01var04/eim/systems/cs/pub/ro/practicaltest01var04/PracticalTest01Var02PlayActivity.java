package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var02PlayActivity extends Activity implements View.OnClickListener {
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 2016;
    private EditText numberField ;
    private Button playButton;


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.playButton:
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03ChooseNumber.class);
                int enteredNumber = Integer.parseInt(numberField.getText().toString());
                intent.putExtra("enteredNumber", enteredNumber);
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        numberField = (EditText)findViewById(R.id.numberField);
        playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

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
}
