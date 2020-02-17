package com.try64.navigationtutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipientFragment extends Fragment implements View.OnClickListener {

    NavController navController;
    Button nextButton, cancelButton;
    TextInputEditText input_recipient;

    public ChooseRecipientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //navController = new NavController(getActivity().getApplicationContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        input_recipient = view.findViewById(R.id.input_recipient);

        nextButton = view.findViewById(R.id.next_btn);
        cancelButton = view.findViewById(R.id.cancel_btn);

        nextButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_btn:
                if (!input_recipient.getText().toString().trim().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient", input_recipient.getText().toString().trim());

                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle);
                }

                break;
            case R.id.cancel_btn:
                navController.popBackStack();
                break;
        }
    }
}
