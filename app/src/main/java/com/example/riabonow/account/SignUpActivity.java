package com.example.riabonow.account;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.riabonow.R;
import com.example.riabonow.widgets.MemberShipAdapter;
import com.example.riabonow.widgets.OccupationAdapter;
import com.example.riabonow.widgets.RefferedByAdapter;
import com.example.riabonow.widgets.TradeExperiencesAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private String[] reffereByList,occupation,traderExp,memberShip;
    private Spinner spRefferedBy,spOccupation,spTradingExp,spMembership;
    private RefferedByAdapter refferedByAdapter;
    private TradeExperiencesAdapter tradeExperiencesAdapter;
    private OccupationAdapter occupationAdapter;
    private MemberShipAdapter memberShipAdapter;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat selectedDate;
    private TextView edDob;
    private Button btnSubmit;
    private int mSelectedIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        spRefferedBy = (Spinner)findViewById(R.id.sp_refferedby);
        spOccupation = (Spinner)findViewById(R.id.sp_occupation);
        spTradingExp = (Spinner)findViewById(R.id.sp_trading_experience);
        spMembership = (Spinner)findViewById(R.id.sp_membership);
        edDob = (TextView)findViewById(R.id.et_dob);
        btnSubmit = (Button)findViewById(R.id.btn_submit);

        reffereByList = getResources().getStringArray(R.array.referedby);
        occupation = getResources().getStringArray(R.array.occupation);
        traderExp = getResources().getStringArray(R.array.tradeexperiences);
        memberShip = getResources().getStringArray(R.array.membership);

        refferedByAdapter = new RefferedByAdapter(getApplicationContext(),reffereByList);
        spRefferedBy.setAdapter(refferedByAdapter);
        tradeExperiencesAdapter = new TradeExperiencesAdapter(getApplicationContext(),traderExp);
        spTradingExp.setAdapter(tradeExperiencesAdapter);
        occupationAdapter = new OccupationAdapter(getApplicationContext(),occupation,mSelectedIndex);
        spOccupation.setAdapter(occupationAdapter);
        memberShipAdapter = new MemberShipAdapter(getApplicationContext(),memberShip);
        spMembership.setAdapter(memberShipAdapter);

        selectedDate = new SimpleDateFormat(" dd MM YYYY", Locale.US);

        spOccupation.setOnItemSelectedListener(this);
        spTradingExp.setOnItemSelectedListener(this);
        spRefferedBy.setOnItemSelectedListener(this);
        spMembership.setOnItemSelectedListener(this);
        edDob.setOnClickListener(this);

    }

    private void showDatePicker() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                edDob.setText(selectedDate.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        fromDatePickerDialog.getDatePicker().setMaxDate(newCalendar.getTimeInMillis());
        fromDatePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.sp_occupation){
            if(position==0){
                ((TextView) view).setTextColor(getResources().getColor(R.color.color2));
            }else {

                List<String> ss = new ArrayList<String>(Arrays.asList(occupation));
                Log.e("selectedText:::",""+ ss.get(position));
                ((TextView) view).setTextColor(getResources().getColor(R.color.color1));
            }
        }else if(parent.getId() == R.id.sp_trading_experience){
            if(position==0){
                ((TextView) view).setTextColor(getResources().getColor(R.color.color2));
            }else {
                List<String> ss = new ArrayList<String>(Arrays.asList(traderExp));
                Log.e("selectedText:::",""+ ss.get(position));
                ((TextView) view).setTextColor(getResources().getColor(R.color.color1));
            }
        }else if(parent.getId() == R.id.sp_refferedby){
            if(position==0){
                ((TextView) view).setTextColor(getResources().getColor(R.color.color2));
            }else {
                List<String> ss = new ArrayList<String>(Arrays.asList(reffereByList));
                Log.e("selectedText:::",""+ ss.get(position));
                ((TextView) view).setTextColor(getResources().getColor(R.color.color1));
            }
        }else if(parent.getId() == R.id.sp_membership){
            if(position==0){
                ((TextView) view).setTextColor(getResources().getColor(R.color.color2));
            }else {
                List<String> ss = new ArrayList<String>(Arrays.asList(memberShip));
                Log.e("selectedText:::",""+ ss.get(position));
                ((TextView) view).setTextColor(getResources().getColor(R.color.color1));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.et_dob:
                showDatePicker();
                break;
        }
    }
}
