package com.example.hirenamaliyar.attendenceemployee;

import android.os.Bundle;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Person_details extends AppCompatActivity {
    private EditText et_fullname, et_email, et_contact_no, et_salary, et_emirates_id, et_passport_no, et_nationality;
    private TextInputLayout til_fullname, til_contact_no, til_salary, til_emirates_id, til_passport_no, til_nationality, til_email;
    private RadioGroup rg_gender;
    private Spinner spin_work_dept, spin_designation;
    private Button bt_save, bt_image_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        LoaduiElements();
        LoadUILisners();

    }

    private void LoadUILisners() {
        et_fullname.addTextChangedListener(new MyTextWatcher(et_fullname));
        et_email.addTextChangedListener(new MyTextWatcher(et_email));
        et_contact_no.addTextChangedListener(new MyTextWatcher(et_contact_no));
        et_emirates_id.addTextChangedListener(new MyTextWatcher(et_emirates_id));
        et_nationality.addTextChangedListener(new MyTextWatcher(et_nationality));
        et_passport_no.addTextChangedListener(new MyTextWatcher(et_passport_no));
        et_salary.addTextChangedListener(new MyTextWatcher(et_salary));

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateFullName()) {
            return;
        }else{

        }

        if (!validateEmail()) {

            return;
        }else{

        }

        if (!validateContactNo()) {
            return;
        }else {

        }
        if (!validateEmiratsId()) {
            return;
        }else{

        }

        if (!validateNationality()) {
            return;
        }else{

        }

        if (!validatePassportNo()) {
            return;
        }else{

        }
        if (!validateSalary()) {
            return;
        }else{

        }

    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateSalary() {
        if (et_salary.getText().toString().trim().isEmpty()) {
            til_salary.setError(getString(R.string.err_msg_salary));
            requestFocus(et_salary);
            return false;
        } else {
            til_salary.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePassportNo() {
        if (et_passport_no.getText().toString().trim().isEmpty()) {
            til_passport_no.setError(getString(R.string.err_msg_passport_no));
            requestFocus(et_passport_no);
            return false;
        } else {
            til_passport_no.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateNationality() {
        if (et_nationality.getText().toString().trim().isEmpty()) {
            til_nationality.setError(getString(R.string.err_msg_nationality));
            requestFocus(et_nationality);
            return false;
        } else {
            til_nationality.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateEmiratsId() {
        if (et_emirates_id.getText().toString().trim().isEmpty()) {
            til_emirates_id.setError(getString(R.string.err_msg_emirates_id));
            requestFocus(et_emirates_id);
            return false;
        } else {
            til_emirates_id.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateContactNo() {
        if (et_contact_no.getText().toString().trim().isEmpty()) {
            til_contact_no.setError(getString(R.string.err_msg_contact));
            requestFocus(et_contact_no);
            return false;
        } else {
            til_contact_no.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = et_email.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            til_email.setError("Enter valid email");
            requestFocus(et_email);
            return false;
        } else {
            til_email.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFullName() {

        if (et_fullname.getText().toString().trim().isEmpty()) {
            til_fullname.setError(getString(R.string.err_msg_name));
            requestFocus(et_fullname);
            return false;
        } else {
            til_fullname.setErrorEnabled(false);
        }
        return true;
    }


    private void LoaduiElements() {
        //edit text
        et_fullname = (EditText) findViewById(R.id.et_fullname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_contact_no = (EditText) findViewById(R.id.et_contact_no);
        et_emirates_id = (EditText) findViewById(R.id.et_emirates_id);
        et_nationality = (EditText) findViewById(R.id.et_nationality);
        et_passport_no = (EditText) findViewById(R.id.et_passport_no);
        et_salary = (EditText) findViewById(R.id.et_salary);

        //buttons
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_image_upload = (Button) findViewById(R.id.bt_image_upload);

        //text input layouts
        til_fullname = (TextInputLayout) findViewById(R.id.til_fullname);
        til_email = (TextInputLayout) findViewById(R.id.til_email);
        til_contact_no = (TextInputLayout) findViewById(R.id.til_contact_no);
        til_emirates_id = (TextInputLayout) findViewById(R.id.til_emirates_id);
        til_nationality = (TextInputLayout) findViewById(R.id.til_nationality);
        til_passport_no = (TextInputLayout) findViewById(R.id.til_passport_no);
        til_salary = (TextInputLayout) findViewById(R.id.til_salary);


    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.et_fullname:
                    validateFullName();
                    break;
                case R.id.et_email:
                    validateEmail();
                    break;
                case R.id.et_contact_no:
                    validateContactNo();
                    break;
                case R.id.et_salary:
                    validateSalary();
                    break;
                case R.id.et_emirates_id:
                    validateEmiratsId();
                    break;
                case R.id.et_passport_no:
                    validatePassportNo();
                    break;
                case R.id.et_nationality:
                    validateNationality();
                    break;
            }
        }
    }
}

