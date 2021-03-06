package br.com.smart.formatter.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.smart.formatter.SmartFormatter;
import br.com.smart.formatter.environment.DiskEnvironment;
import br.com.smart.formatter.environment.VolatileEnvironment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DiskEnvironment().saveTagValue(getApplicationContext(), "DiskEnvironment", "(Essa foi setada em preferences!)");
        new DiskEnvironment().saveTagValue(getApplicationContext(), "VolatileEnvironment", "(Essa foi setada em preferences!)");
        new DiskEnvironment().saveTagValue(getApplicationContext(), "InstanceEnvironment", "(Essa foi setada em preferences!)");

        new VolatileEnvironment().saveTagValue(getApplicationContext(), "VolatileEnvironment", "(Essa foi setada em singleton!)");
        new VolatileEnvironment().saveTagValue(getApplicationContext(), "InstanceEnvironment", "(Essa foi setada em singleton!)");

        TextView txt1 = (TextView) findViewById(R.id.txt1);
        txt1.setText(SmartFormatter.getFormatter(this).from(getString(R.string.frase)).with("InstanceEnvironment","(Essa foi setada no uso do SmartFormatter!)").format());

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
}
