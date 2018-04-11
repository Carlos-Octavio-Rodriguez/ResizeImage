package com.tecmm.tequila.resizeimage;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    SeekBar seekBar;
    private int iWidth = 65;
    private int iHeight = 52;

    float density ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;

        imagen = (ImageView) findViewById(R.id.imagen);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float ancho = (progress + iWidth) * density / 160;
                float alto = (progress + iHeight) * density / 160;

                //if(alto == 246.0 && ancho == 247.5)
                  //  Toast.makeText(getApplicationContext(), "Llego al limite", Toast.LENGTH_LONG);

                imagen.getLayoutParams().height = (int)alto;
                imagen.getLayoutParams().width = (int)ancho;
                imagen.requestLayout();
                if (progress == 100){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "LLego al limite", Toast.LENGTH_LONG);
                    toast1.show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
