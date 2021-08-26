package com.example.mystore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.CheckedInputStream;


public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }


    private TextView Existinguser, forgetTextLink;
    private EditText mFullname, mPassword, mEmail, mConfirmpassword;
    private Button mSignBtn;
    private FrameLayout parentframeLayout;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        mPassword = view.findViewById(R.id.createpassword);
        mConfirmpassword = view.findViewById(R.id.confirmpassword);
        mEmail = view.findViewById(R.id.SignupEmail);
        mSignBtn = view.findViewById(R.id.SignUp);
        mFullname = view.findViewById(R.id.fullname);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressBar = view.findViewById(R.id.upprogressBar);


        Existinguser = view.findViewById(R.id.AlreadyUser);
        parentframeLayout = getActivity().findViewById(R.id.frame);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Existinguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());

            }
        });


        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                CheckedInput();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mConfirmpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                CheckedInput();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                CheckedInput();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mFullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                CheckedInput();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkmailandpassword();
            }
        });
    }

    private void checkmailandpassword() {
        if (mPassword.getText().toString().equals(mConfirmpassword.getText().toString())) {
            progressBar.setVisibility(View.VISIBLE);
            mSignBtn.setEnabled(false);
            mSignBtn.setTextColor(Color.argb(50, 255, 255, 255));

            firebaseAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Map<Object, String> userdata = new HashMap<>();
                                userdata.put("fullname", mFullname.getText().toString());

                                firebaseFirestore.collection("USERS").add(userdata)
                                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentReference> task) {

                                                if (task.isSuccessful()) {

                                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(intent);
                                                    getActivity().finish();

                                                } else {
                                                    progressBar.setVisibility(View.INVISIBLE);
                                                    mSignBtn.setEnabled(true);
                                                    mSignBtn.setTextColor(R.color.colorPrimary);
                                                    Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                }

                                            }
                                        });


                            } else {
                                progressBar.setVisibility(View.INVISIBLE);
                                mSignBtn.setEnabled(true);
                                mSignBtn.setTextColor(R.color.colorPrimary);
                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

        } else {

            mConfirmpassword.setError("Password does not match");

        }


    }

    @SuppressLint("ResourceAsColor")
    private void CheckedInput() {

        if (!TextUtils.isEmpty(mEmail.getText())) {
            if (!TextUtils.isEmpty(mFullname.getText())) {
                if (!TextUtils.isEmpty(mPassword.getText()) && mPassword.length() >= 8) {
                    if (!TextUtils.isEmpty(mConfirmpassword.getText())) {
                        mSignBtn.setEnabled(true);
                        mSignBtn.setTextColor(R.color.colorPrimary);
                    } else {
                        mSignBtn.setEnabled(false);
                        mSignBtn.setTextColor(Color.argb(50, 255, 255, 255));

                    }
                } else {
                    mSignBtn.setEnabled(false);
                    mSignBtn.setTextColor(Color.argb(50, 255, 255, 255));

                }
            } else {
                mSignBtn.setEnabled(false);
                mSignBtn.setTextColor(Color.argb(50, 255, 255, 255));

            }
        } else {
            mSignBtn.setEnabled(false);
            mSignBtn.setTextColor(Color.argb(50, 255, 255, 255));
        }

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_form_right);
        fragmentTransaction.replace(parentframeLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}