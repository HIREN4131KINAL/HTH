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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Person_details extends AppCompatActivity {
    private EditText et_fullname, et_email, et_contact_no, et_salary, et_emirates_id, et_passport_no, et_nationality, et_gender, et_date_of_birth, et_date_of_hire;
    private TextInputLayout til_fullname, til_contact_no, til_salary, til_emirates_id, til_passport_no, til_nationality, til_email, til_gender, til_date_of_birth, til_date_of_hire;
    private RadioGroup rg_gender;
    private Spinner spin_work_dept, spin_designation;
    private Button bt_save, bt_image_upload;
    private RadioButton radio0, radio1;
    Boolean chk_work_dept = false;
    Boolean chk_designation = false;
    String r_gender;
    String[] work_dept = {
            "PHP",
            "ANDROID",
            "IOS",
            "WEB-DESIGN",
            "PHOTOSHOP"
    };
    String[] designation = {
            "Jr PHP developer",
            "Sr PHP developer",
            "Jr ANDROID developer",
            "Sr ANDROID developer",
            "Jr IOS developer",
            "Sr IOS developer",
            "Jr WEB-DESIGN developer",
            "Sr WEB-DESIGN developer",
            "Jr PHOTOSHOP developer",
            "Sr PHOTOSHOP developer"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        et_gender.addTextChangedListener(new MyTextWatcher(et_gender));
        et_date_of_birth.addTextChangedListener(new MyTextWatcher(et_date_of_birth));
        et_date_of_hire.addTextChangedListener(new MyTextWatcher(et_date_of_hire));


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        spinnerAdapter adapter = new spinnerAdapter(Person_details.this, android.R.layout.simple_list_item_1);
        adapter.addAll(work_dept);
        adapter.add("Please select Work Department");
        spin_work_dept.setAdapter(adapter);
        spin_work_dept.setSelection(adapter.getCount());
        spin_work_dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                if (spin_work_dept.getSelectedItem() == "Please select Work Department") {
                    chk_work_dept = true;
                    //Do nothing.
                } else {
                    chk_work_dept = false;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (radio0.isChecked()) {

                    et_gender.setText("MALE");

                } else if (radio1.isChecked()) {

                    et_gender.setText("FEMALE");
                }
            }
        });


        spinnerAdapter adapter_des = new spinnerAdapter(Person_details.this, android.R.layout.simple_list_item_1);
        adapter_des.addAll(designation);
        adapter_des.add("Please select Designation");
        spin_designation.setAdapter(adapter_des);
        spin_designation.setSelection(adapter_des.getCount());
        spin_designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                if (spin_designation.getSelectedItem() == "Please select Designation") {
                    chk_designation = true;
                    //Do nothing.
                } else {

                    chk_designation = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {


        if (!validateFullName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }
        if (!validateWorkDept()) {

            return;
        }
        if (!validateDesignation()) {

            return;
        }
        if (!validateContactNo()) {
            return;
        }
        if (!validateGender()) {
            return;
        }
        if (!validateBirthDate()) {
            return;
        }
        if (!validateDateOfHire()) {
            return;
        }
        if (!validateEmiratsId()) {
            return;
        }

        if (!validateNationality()) {
            return;
        }

        if (!validatePassportNo()) {
            return;
        }
        if (!validateSalary()) {
            return;
        }

    }

    private boolean validateBirthDate() {

        if (et_date_of_birth.getText().toString().trim().isEmpty()) {
            til_date_of_birth.setError(getString(R.string.err_msg_dob));
            requestFocus(et_date_of_birth);
            return false;
        } else {
            til_date_of_birth.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateDateOfHire() {
        if (et_date_of_hire.getText().toString().trim().isEmpty()) {
            til_date_of_hire.setError(getString(R.string.err_msg_hire_date));
            requestFocus(et_date_of_birth);
            return false;
        } else {
            til_date_of_hire.setErrorEnabled(false);
        }
        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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

    private boolean validateGender() {
        if (et_gender.getText().toString().trim().isEmpty()) {
            til_gender.setError(getString(R.string.err_msg_gender));
            requestFocus(et_gender);
            return false;
        } else {
            til_gender.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateWorkDept() {
        if (chk_work_dept) {
            Toast.makeText(Person_details.this, "Please select Work Department", Toast.LENGTH_LONG).show();
            spin_work_dept.setFocusable(true);
            spin_work_dept.setFocusableInTouchMode(true);
            spin_work_dept.requestFocus();
            spin_work_dept.performClick();
            return false;
        }
        return true;
    }

    private boolean validateDesignation() {
        if (chk_designation) {

            Toast.makeText(Person_details.this, "Please select Designation", Toast.LENGTH_LONG).show();
            spin_designation.setFocusable(true);
            spin_designation.setFocusableInTouchMode(true);
            spin_designation.requestFocus();
            spin_designation.performClick();
            return false;
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
        et_gender = (EditText) findViewById(R.id.et_gender);
        et_date_of_birth = (EditText) findViewById(R.id.et_date_of_birth);
        et_date_of_hire = (EditText) findViewById(R.id.et_date_of_hire);
        //spinners
        spin_work_dept = (Spinner) findViewById(R.id.spin_work_dept);
        spin_designation = (Spinner) findViewById(R.id.spin_designation);

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
        til_gender = (TextInputLayout) findViewById(R.id.til_gender);
        til_date_of_birth = (TextInputLayout) findViewById(R.id.til_date_of_birth);
        til_date_of_hire = (TextInputLayout) findViewById(R.id.til_date_of_hire);

        //radio group
        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        radio0 = (RadioButton) findViewById(R.id.radio0);
        radio1 = (RadioButton) findViewById(R.id.radio1);


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

