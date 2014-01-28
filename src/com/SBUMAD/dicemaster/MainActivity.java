package com.SBUMAD.dicemaster;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void diceRoll(View Button)
    {
    	EditText numberOfDice = (EditText) findViewById(R.id.ETNumberOfDice);
    	String input = numberOfDice.getText().toString();
    	int iNumberOfDice = Integer.parseInt(input);
    	Spinner numberOfSides = (Spinner) findViewById(R.id.SpinnerFeedbackType);
    	String sNumberOfSides = numberOfSides.getSelectedItem().toString();
    	int iNumberOfSides = Integer.parseInt(sNumberOfSides);
    	int sum = 0;
    	for(int i=0;i<iNumberOfDice;i++)
    	{
    		sum += rollDice(iNumberOfSides);
    	}
    	TextView result = (TextView) findViewById(R.id.Result);
    	result.setText(""+sum);
    	Log.i("DiceRoll", ""+sum);
    }
    
    public int rollDice(int numSides){
    	return (int)(Math.random()*numSides) + 1;
    }
}
