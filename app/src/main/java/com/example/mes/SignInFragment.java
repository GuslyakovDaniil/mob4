package com.example.mes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mes.databinding.FragmentSignInBinding;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;
    private String predefinedEmail = "admin@example.com";
    private String predefinedPassword = "admin123";
    private String registeredEmail;
    private String registeredPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments() != null){
            registeredEmail = SignInFragmentArgs.fromBundle(getArguments()).getEmail();
            registeredPassword = SignInFragmentArgs.fromBundle(getArguments()).getPassword();
        }

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();


            if ((email.equals(predefinedEmail) && password.equals(predefinedPassword)) ||
                    (email.equals(registeredEmail) && password.equals(registeredPassword))) {
                Toast.makeText(requireContext(), "Успешный вход", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "Неверный email или пароль", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegister.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_signUpFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
