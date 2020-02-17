package com.try64.navigationtutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    Button nextButton, cancelButton;
    TextView recipient;
    TextInputEditText textInputEditText;
    String recipientName;

    public SpecifyAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //navController = new NavController(getActivity().getApplicationContext());
        recipientName = getArguments().getString("recipient");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        recipient = view.findViewById(R.id.recipient);

        nextButton = view.findViewById(R.id.send_btn);
        cancelButton = view.findViewById(R.id.cancel_btn);
        textInputEditText = view.findViewById(R.id.input_amount);

        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        recipient.setText("Recipient's name is " + recipientName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_btn:
                if (!textInputEditText.getText().toString().trim().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", recipientName);
                    bundle.putParcelable("ammount", new Money(new BigDecimal(textInputEditText.getText().toString().trim())));

                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle);
                }

                break;
            case R.id.cancel_btn:
                navController.popBackStack();
                break;
        }
    }
}
