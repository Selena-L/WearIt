package project.wearit;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import project.wearit.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private SeekBar tempBar;
    private TextView tempValText;
    private SeekBar precipitationBar;
    private TextView precipitationValText;
    private SeekBar windSpeedBar;
    private TextView windSpeedValText;
    private Button nextButton;
    private TextView tempWT;
    private TextView precipWT;
    private TextView windWT;
    private ImageView bodypic;
    private ImageView headpic;
    private ImageView legpic;
    private ImageView feetpic;
    private TextView textView_head;
    private TextView textView_body;
    private TextView textView_leg;
    private TextView textView_feet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // SeekBar: temperature_toggle
        tempBar = (SeekBar) findViewById(R.id.temperature_toggle);
        tempValText = (TextView) findViewById(R.id.temperature_value);
        tempValText.setText(tempBar.getProgress() + "C");
        tempBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int temperatureVal = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                temperatureVal = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tempValText.setText(temperatureVal + "C");
            }
        });

        // SeekBar: precipitation_toggle
        precipitationBar = (SeekBar) findViewById(R.id.precipitation_toggle);
        precipitationValText = (TextView) findViewById(R.id.precipitation_value);
        precipitationValText.setText(precipitationBar.getProgress() + "%");
        precipitationBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int precipitationVal = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                precipitationVal = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                precipitationValText.setText(precipitationVal + "%");
            }
        });

        // SeekBar: windSpeed_toggle
        windSpeedBar = (SeekBar) findViewById(R.id.windSpeed_toggle);
        windSpeedValText = (TextView) findViewById(R.id.windSpeed_value);
        windSpeedValText.setText(windSpeedBar.getProgress() + "%");
        windSpeedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int windSpeedVal = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                windSpeedVal = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                windSpeedValText.setText(windSpeedVal + "%");
            }
        });

        //implementation of the next button on the first page
        //initialize variables
        nextButton = (Button) findViewById(R.id.button_next);
        tempWT = (TextView) findViewById(R.id.changeintemp);
        precipWT = (TextView) findViewById(R.id.changeinprecip);
        windWT = (TextView) findViewById(R.id.changeinwind);
        textView_head = (TextView) findViewById(R.id.textView_hat);
        textView_body = (TextView) findViewById(R.id.textView_top);
        textView_leg = (TextView) findViewById(R.id.textView_bottom);
        textView_feet = (TextView) findViewById(R.id.textView_shoes);
        headpic = (ImageView) findViewById(R.id.imageView_head);
        bodypic = (ImageView) findViewById(R.id.imageView_body);
        legpic = (ImageView) findViewById(R.id.imageView_leg);
        feetpic = (ImageView) findViewById(R.id.imageView_feet);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set the weather to the progress bar in the first page
                tempWT.setText(tempBar.getProgress());
                precipWT.setText(precipitationBar.getProgress());
                windWT.setText(windSpeedBar.getProgress());

                //change clothes
                if(tempBar.getProgress() >= 20) {
                    //changes text
                    textView_head.setText("Hat");
                    textView_body.setText("T-shirt");
                    textView_leg.setText("Shorts");
                    textView_feet.setText("Sandals");
                    //changes images
                    headpic.setImageResource(R.drawable.cap);
                    bodypic.setImageResource(R.drawable.shirt);
                    legpic.setImageResource(R.drawable.shorts);
                    feetpic.setImageResource(R.drawable.sandals);
                    //if it rains
                    if(precipitationBar.getProgress() > 40) {
                        //changes text
                        textView_body.setText("Bring a rain jacket!");
                        bodypic.setImageResource(R.drawable.rainjacket);
                    }
                }
                else if(tempBar.getProgress() >= 10 && tempBar.getProgress() < 20) {
                    //changes text
                    textView_head.setText("Hat");
                    textView_body.setText("Jacket");
                    textView_leg.setText("Jeans");
                    textView_feet.setText("Sneakers");
                    //changes images
                    headpic.setImageResource(R.drawable.cap);
                    bodypic.setImageResource(R.drawable.jacket);
                    legpic.setImageResource(R.drawable.jeans);
                    feetpic.setImageResource(R.drawable.sneakers);
                    //if it rains
                    if(precipitationBar.getProgress() > 40) {
                        //changes text
                        textView_body.setText("Bring a rain jacket!");
                    }
                }
                else if(tempBar.getProgress() < 10) {
                    //changes text
                    textView_head.setText("Toque");
                    textView_body.setText("Winter Jacket");
                    textView_leg.setText("Sweatpants");
                    textView_feet.setText("Boots");
                    //changes images
                    headpic.setImageResource(R.drawable.toque);
                    bodypic.setImageResource(R.drawable.snow_jacket);
                    legpic.setImageResource(R.drawable.sweats);
                    feetpic.setImageResource(R.drawable.snowboots);
                }
            }
        });

        //add warmer and colder settings

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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}