package org.kasapbasi.timestable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    ListView lw;
    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.sbTimesTable);
        lw=(ListView) findViewById(R.id.timesListView);
        tw=(TextView) findViewById(R.id.Times);

        sb.setMax(20);
        sb.setMin(1);
        sb.setProgress(10);
        myInfilate(10);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tw.setText(""+progress);
                myInfilate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void myInfilate(int progress) {

        ArrayList<String> ttcontent= new ArrayList<>();
        for(int i=1;i<=12;i++)
        {
            ttcontent.add(""+i+"*"+progress+"="+(i*progress));

        }
        ArrayAdapter<String> adaptor=
                new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                ttcontent);
        lw.setAdapter(adaptor);
    }
}
