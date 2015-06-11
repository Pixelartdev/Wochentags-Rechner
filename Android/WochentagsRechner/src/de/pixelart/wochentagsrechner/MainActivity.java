package de.pixelart.wochentagsrechner;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView result;
	EditText et;
	Spinner sp_day;
	Spinner sp_month;
	Button btn_rechne;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		result = (TextView) findViewById(R.id.tv_result);
		et = (EditText) findViewById(R.id.et_year);
		sp_day = (Spinner) findViewById(R.id.sp_day);
		sp_month = (Spinner) findViewById(R.id.sp_month);
		btn_rechne = (Button) findViewById(R.id.btn_rechne);
		
		btn_rechne.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int tag = sp_day.getSelectedItemPosition() +1;
				int month = sp_month.getSelectedItemPosition() +1;
				int year = Integer.valueOf(et.getText().toString());
				Rechner r = new Rechner();
				r.Rechner(tag, month, year);
				result.setText("Der gesuchte Tag ist ein "+Html.fromHtml("<b>"+r.ergebnis+"</b>"));
			}
		});
		
	}

	
}
