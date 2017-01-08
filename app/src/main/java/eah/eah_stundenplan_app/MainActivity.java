package eah.eah_stundenplan_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String html = "<html>\n" +
                "<head>\n" +
                "\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"private,must-revalidate,no-cache,no-store\" />\n" +
                "<title>Kallender EAH auslesen</title>\n" +
                "<script src=\"http://stundenplanung.eah-jena.de/studentset/setfunctions.js\" type=\"text/javascript\"></script>\n" +
                "<script src=\"http://stundenplanung.eah-jena.de/inc/semester.js\" type=\"text/javascript\"></script>\n" +
                "<script src=\"http://stundenplanung.eah-jena.de/inc/StudentSetList.js\" type=\"text/javascript\"></script>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "  <form class=\"content\" action=\"http://stundenplanung.eah-jena.de/studentset/\" id=\"fSelect\" method=\"get\" target=\"ausgabe\">\n" +
                "\t<label for=\"StgSelect\">\n" +
                "\t\tStudiengang: \n" +
                "\t\t<select id=\"StgSelect\" name=\"Studiengang\" onchange='UpdateSemester(this)'>\n" +
                "\t\t\t<option value='AO(BA)'>Bachelor: &nbsp; Augenoptik</option>\n" +
                "\t\t\t<option value='BW(BA)'>Bachelor: &nbsp; Betriebswirtschaft</option>\n" +
                "\t\t\t<option value='BT(BA)'>Bachelor: &nbsp; Biotechnologie</option>\n" +
                "\t\t\t<!-- option value='DSA(BA)'>Bachelor: &nbsp; Dayton Sommerakademie</option -->\n" +
                "\t\t\t<option value='DJU(BA)'>Bachelor: &nbsp; Deutsch-Jordanische-Universität</option>\n" +
                "\t\t\t<option value='WIEC(BA)'>Bachelor: &nbsp; E-Commerce</option>\n" +
                "\t\t\t<option value='ET(BA)'>Bachelor: &nbsp; Elektrotechnik</option>\n" +
                "\t\t\t<option value='FT(BA)'>Bachelor: &nbsp; Feinwerktechnik</option>\n" +
                "\t\t\t<!-- option value='AAMW(BA)'>Bachelor: &nbsp; Herbstakademie Wenzhou</option -->\n" +
                "\t\t\t<option value='LOT(BA)'>Bachelor: &nbsp; Laser- und Optotechnologien</option>\n" +
                "\t\t\t<option value='MB(BA)'>Bachelor: &nbsp; Maschinenbau</option>\n" +
                "\t\t\t<option value='ME(BA)'>Bachelor: &nbsp; Mechatronik</option>\n" +
                "\t\t\t<option value='MT(BA)'>Bachelor: &nbsp; Medizintechnik</option>\n" +
                "\t\t\t<option value='PVHT(BA)'>Bachelor: &nbsp; Photovoltaik und Halbleitertechnologie</option>\n" +
                "\t\t\t<option value='PT(BA)'>Bachelor: &nbsp; Physikalische Technik</option>\n" +
                "\t\t\t<option value='SGU(BA)'>Bachelor: &nbsp; Swiss German University Indonesien </option>\n" +
                "\t\t\t<option value='UT(BA)'>Bachelor: &nbsp; Umwelttechnik (und Entwicklung)</option>\n" +
                "\t\t\t<!--option value='PiUS(BA)'>Bachelor: &nbsp; Prozessintegrierter Umweltschutz</option-->\n" +
                "\t\t\t<option value='CDHAW(BA)'>Bachelor: &nbsp; Sonderstudienplan f&uuml;r CDHAW</option>\n" +
                "\t\t\t<option value='WT(BA)'>Bachelor: &nbsp; Werkstofftechnik</option>\n" +
                "\t\t\t<option value='WI(BA)'>Bachelor: &nbsp; Wirtschaftsingenieurwesen</option>\n" +
                "\t\t\t<option value='AO(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Augenoptik</option>\n" +
                "\t\t\t<option value='BW(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Betriebswirtschaft</option>\n" +
                "\t\t\t<option value='LOT(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Laser- und Optotechnologien</option>\n" +
                "\t\t\t<option value='MB(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Maschinenbau</option>\n" +
                "\t\t\t<option value='ME(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Mechatronik</option>\n" +
                "\t\t\t<option value='MT(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Medizintechnik</option>\n" +
                "\t\t\t<option value='MiBi(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Miniaturisierte Biotechnologie</option>\n" +
                "\t\t\t<option value='PBT(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Pharma-Biotechnologie</option>\n" +
                "\t\t\t<option value='RE(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Raumfahrtelektronik</option>\n" +
                "\t\t\t<option value='SI(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Scientific Instrumentation</option>\n" +
                "\t\t\t<option value='SD(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; System Design</option>\n" +
                "\t\t\t<option value='WT(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Werkstofftechnik</option>\n" +
                "\t\t\t<option value='WI(MA)'>Master: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Wirtschaftsingenieurwesen</option>\n" +
                "\t\t\t<option value='DJU(BA)'>Deutsch-Jordanische-Universität</option>\n" +
                "\t\t</select>\t\n" +
                "\t</label>\n" +
                "\n" +
                "\t<label for=\"SemesterSelect\">\n" +
                "\t\tSemester:\n" +
                "\t\t<select id=\"SemesterSelect\" name=\"Semester\" onchange=\"UpdateGroup(this)\">\n" +
                "\t\t\t<option>&nbsp;</option>\n" +
                "\t\t</select>\n" +
                "\t</label>\n" +
                "\n" +
                "\t<label for=\"GroupSelect\">\n" +
                "\t\tGruppe:\n" +
                "\t\t<select id=\"GroupSelect\" name=\"Group\">\n" +
                "\t\t\t<option>&nbsp;</option>\n" +
                "\t\t</select>\n" +
                "\t</label>\n" +
                "\n" +
                "\t<br> <br>\n" +
                "\n" +
                "\t<label>\n" +
                "               <input type=\"radio\" name=\"type\" value=\"table\" checked=\"checked\" /> \n" +
                "              Wochenkalender für\n" +
                "               <select name=\"week\">\n" +
                "                      <option value=\"1\">  \t\t\t\t 1. SW (42. KW) 17.10.2016 - 22.10.2016</option>\n" +
                "                      <option value=\"2\">  \t\t\t\t 2. SW (43. KW) 24.10.2016 - 29.10.2016</option>\n" +
                "                      <option value=\"3\">  \t\t\t\t 3. SW (44. KW) 31.10.2016 - 05.11.2016</option>\n" +
                "                      <option value=\"4\">  \t\t\t\t 4. SW (45. KW) 07.11.2016 - 12.11.2016</option>\n" +
                "                      <option value=\"5\">  \t\t\t\t 5. SW (46. KW) 14.11.2016 - 19.11.2016</option>\n" +
                "                      <option value=\"6\">  \t\t\t\t 6. SW (47. KW) 21.11.2016 - 26.11.2016</option>\n" +
                "                      <option value=\"7\">  \t\t\t\t 7. SW (48. KW) 28.11.2016 - 03.12.2016</option>\n" +
                "                      <option value=\"8\">  \t\t\t\t 8. SW (49. KW) 05.12.2016 - 10.12.2016</option>\n" +
                "                      <option value=\"9\">  \t\t\t\t 9. SW (50. KW) 12.12.2016 - 17.12.2016</option>\n" +
                "                      <option value=\"10\">\t\t\t\t10. SW (51. KW) 19.12.2016 - 24.12.2016</option>\n" +
                "                      <option value=\"11\">\t\t\t\t11. SW (52. KW) 26.12.2016 - 31.12.2016</option>\n" +
                "                      <option value=\"12\">\t\t\t\t12. SW ( 1. KW) 02.01.2017 - 07.01.2017</option>\n" +
                "                      <option value=\"13\">\t\t\t\t13. SW ( 2. KW) 09.01.2017 - 14.01.2017</option>\n" +
                "                      <option value=\"14\">\t\t\t\t14. SW ( 3. KW) 16.01.2017 - 21.01.2017</option>\n" +
                "                      <option value=\"15\">\t\t\t\t15. SW ( 4. KW) 23.01.2017 - 28.01.2017</option>\n" +
                "                      <option value=\"16\">\t\t\t\t16. SW ( 5. KW) 30.01.2017 - 04.02.2017</option>\n" +
                "                      <option value=\"17\">\t\t\t\t17. SW ( 6. KW) 06.02.2017 - 11.02.2017</option>\n" +
                "                      <option value=\"1-17\"   selected=\"selected\" >\tWS 2016/17  17.10.2016 - 12.02.2017    </option>\n" +
                "               </select>\n" +
                "\t</label>\n" +
                "\n" +
                "\t<br> <br>\n" +
                "\t\n" +
                "\t<li>\n" +
                "\t\t<input type=\"submit\" value=\"Anzeigen\" />\n" +
                "\t</li>\n" +
                "   </form>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "\n" +
                "</html> ";
        String mime = "text/html";
        String encoding = "utf-8";
        WebView myWebView = (WebView) findViewById(R.id.activity_main_webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadDataWithBaseURL(null, html, mime, encoding, null);      //lädt die selbst erstellte HTML Datei, die das get sendet
    };

 /*   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

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
}
