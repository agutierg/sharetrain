package sharetrain.gutsapps.com.fragment;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import sharetrain.gutsapps.com.activity.ListTableActivity;
import sharetrain.gutsapps.com.activity.ListTicketActivity;
import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.constants.ParamsConstants;


/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends DialogFragment implements
        View.OnClickListener,
        DatePickerDialog.OnDateSetListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AutoCompleteTextView autocompleteFrom;
    private AutoCompleteTextView autocompleteTo;
    private ImageView ivDate;
    private View searchFragment;
    private Button btSearch;
    private RadioButton rbTicket;
    private RadioButton rbTable;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        searchFragment = inflater.inflate(R.layout.fragment_search, container, false);

        // Get the string array
        String[] countries = getResources().getStringArray(R.array.cities_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, countries);
        // Get a reference to the AutoCompleteTextView in the layout
        autocompleteFrom = (AutoCompleteTextView) searchFragment.findViewById(R.id.autocompleteFrom);
        autocompleteTo = (AutoCompleteTextView) searchFragment.findViewById(R.id.autocompleteTo);
        autocompleteFrom.setAdapter(adapter);
        autocompleteTo.setAdapter(adapter);

        rbTicket = (RadioButton) searchFragment.findViewById(R.id.rbTicket);
        rbTable = (RadioButton) searchFragment.findViewById(R.id.rbTable);

        // Date picker
        ivDate = (ImageView) searchFragment.findViewById(R.id.ivDate);
        ivDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        SearchFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(true);
                dpd.setTitle(getResources().getString(R.string.choseDay));
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivDate.setImageResource(R.drawable.ic_data_picker_red);
                    }
                });

                Calendar today = Calendar.getInstance();
                dpd.setMinDate(today);
                dpd.setAccentColor(Color.parseColor("#ff80cbc4"));
                FragmentManager fm = getActivity().getFragmentManager();
                dpd.show(fm, "ivDate");
            }
        });
        btSearch = (Button) searchFragment.findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (rbTicket.isChecked()) {
                    Intent activityList = new Intent(v.getContext(),
                            ListTicketActivity.class);
                    startActivityForResult(
                            activityList,
                            Integer.valueOf(ParamsConstants.CODE_ACTIVITY_LIST_TICKET));
                } else if (rbTable.isChecked()) {
                    Intent activityList = new Intent(v.getContext(),
                            ListTableActivity.class);
                    startActivityForResult(
                            activityList,
                            Integer.valueOf(ParamsConstants.CODE_ACTIVITY_LIST_TABLE));
                }
            }
        });

        return searchFragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        if (view.getTag().equals("ivDate")) {
            ivDate.setImageResource(R.drawable.ic_date_picker_green);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
