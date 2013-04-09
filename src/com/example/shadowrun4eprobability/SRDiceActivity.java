package com.example.shadowrun4eprobability;

import com.example.shadowrun4eprobability.R;
import srdice.SRDice;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SRDiceActivity extends Activity {
	
	SRDice dice = new SRDice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText tmp = (EditText) findViewById(R.id.SuccessOutput);
        tmp.setKeyListener(null);
        tmp = (EditText) findViewById(R.id.GlitchOutput);
        tmp.setKeyListener(null);
        tmp = (EditText) findViewById(R.id.CritGlitchOutput);
        tmp.setKeyListener(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.srdice, menu);
        return true;
    }
    
    /**
     * TODO Check the logic of numbers
     * @param view
     */
    public void calculateProbs(View view) {
    	EditText editDice = (EditText) findViewById(R.id.editDice);
    	EditText editThres = (EditText) findViewById(R.id.editThres);
    	
    	String txtDice = editDice.getText().toString();
    	String txtThres = editThres.getText().toString();
    	
    	int numDice = Integer.parseInt(txtDice);
    	int numThres = Integer.parseInt(txtThres);
    	
    	double hit, glitch, critg;
    	hit = dice.ProbSucceed(numThres, numDice) * 100;
    	glitch = dice.ProbGlitch(numDice) * 100;
    	critg = dice.ProbCriticalGlitch(numDice) * 100;
    	
    	EditText outHit = (EditText) findViewById(R.id.SuccessOutput);
    	EditText outGlitch = (EditText) findViewById(R.id.GlitchOutput);
    	EditText outCrit = (EditText) findViewById(R.id.CritGlitchOutput);
    	
    	String hitS, critS, glitchS;
    	
    	hitS = String.valueOf(hit);
    	critS = String.valueOf(critg);
    	glitchS = String.valueOf(glitch);
    	
    	outHit.setText(hitS.substring(0, (6<hitS.length())?6:hitS.length())+"%");
    	outGlitch.setText(critS.substring(0, (6<critS.length())?6:critS.length())+"%");
    	outCrit.setText(glitchS.substring(0, (6<glitchS.length())?6:glitchS.length())+"%");
    }
    
}
