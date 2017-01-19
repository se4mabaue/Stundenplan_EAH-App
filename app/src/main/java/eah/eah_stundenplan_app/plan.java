package eah.eah_stundenplan_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.id.message;
import static eah.eah_stundenplan_app.R.id.plan_aktuelle_woche;


public class plan extends AppCompatActivity {
    private ImageButton _btnAbos;
    private ImageButton _btnNext;
    private ImageButton _btnPrevios;
    private int _woche = 1;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);

        _btnAbos = (ImageButton) findViewById(R.id.plan_button_abos);
        _btnAbos.setOnClickListener(OnBtnAbosListener);                             //macht den Button Edit beim Event Listener bekannt

        _btnNext = (ImageButton) findViewById(R.id.plan_btn_woche_hoch);
        _btnNext.setOnClickListener(OnBtnNextListener);                             //macht den Button Next beim Event Listener bekannt

        _btnPrevios = (ImageButton) findViewById(R.id.plan_btn_woche_runter);
        _btnPrevios.setOnClickListener(OnBtnPreviosListener);                       //macht den Button Previous beim Event Listener bekannt

        refreshPlan();
    }


    private View.OnClickListener OnBtnAbosListener = new View.OnClickListener()        //Beschreibt was beim Klicken auf den Button Edit passieren soll
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(plan.this, abos.class);
            startActivity(intent);                                                      //lädt die Activity Abos
        }
    };


    private View.OnClickListener OnBtnNextListener = new View.OnClickListener()         //Bewirkt ein Neu-laden des Stundenplans
    {
      @Override
      public void onClick(View view)
      {
          if (_woche < 17) _woche++; else AllertWocheHoch();
          refreshPlan();
      }
    };


    private View.OnClickListener OnBtnPreviosListener = new View.OnClickListener()      //bewirkt ein Neu-laden des Stundenplans
    {
        @Override
        public  void onClick(View view)
        {
            if (_woche > 1)  _woche--; else AllertWocheRunter();
            refreshPlan();
        }
    };

    private void AllertWocheHoch (){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Fehlermeldung");
        msg.setMessage("Sie befinden sich bereits in der letzten Woche!!!");
        msg.setCancelable(true);
        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    };

    private void AllertWocheRunter(){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Fehlermeldung");
        msg.setMessage("Sie befinden sich bereits in der ersten Woche!!!");
        msg.setCancelable(true);
        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    };

    private void refreshPlan(){
        TextView Ausgabe;
        Ausgabe = (TextView) findViewById(R.id.plan_aktuelle_woche);
        Ausgabe.setText("Woche" + _woche);
        //Prozedur zur Erzeugen der Stundenplanansicht für die aktuelle Woche
    };
}

