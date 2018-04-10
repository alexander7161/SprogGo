package com.sproggo.sproggo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.sproggo.sproggo.Game.setUpGame;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    //Default number selected is 5.
    private int numOfWords = 5;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        final Button startGameButton = (Button) view.findViewById(R.id.button);

        // List of items in the spinner.
        final List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("hackathon");
        spinnerArray.add("animal");
        spinnerArray.add("garden");
        spinnerArray.add("Danish Hackathon");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems = (Spinner) view.findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        RadioButton fiveRadio = (RadioButton) view.findViewById(R.id.fiveRadio);
        RadioButton tenRadio = (RadioButton) view.findViewById(R.id.tenRadio);
        RadioButton fithteenRadio = (RadioButton) view.findViewById(R.id.fithteenRadio);

        View.OnClickListener first_radio_listener = new View.OnClickListener(){
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        };

        fiveRadio.setOnClickListener(first_radio_listener);
        tenRadio.setOnClickListener(first_radio_listener);
        fithteenRadio.setOnClickListener(first_radio_listener);

        // Start game.
        startGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = getActivity().getSharedPreferences("sproggo", 0);
                Player currentPlayer = PlayerList.getUser(pref.getString("currentUser", null));
                // Create game with list of categories and number of words selected by user.
                Game.setUpGame(spinnerArray.get(sItems.getSelectedItemPosition()), numOfWords);
                // Start game.
                Intent intent = new Intent(getActivity(), DescribeActivity.class);
                MainFragment.this.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fiveRadio:
                if (checked)
                    numOfWords = 5;
                    break;
            case R.id.tenRadio:
                if (checked)
                    numOfWords = 10;
                    break;
            case R.id.fithteenRadio:
                if (checked)
                    numOfWords = 15;
                    break;
        }
    }
}
