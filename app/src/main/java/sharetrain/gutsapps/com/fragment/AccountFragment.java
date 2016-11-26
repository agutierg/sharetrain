package sharetrain.gutsapps.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import info.hoang8f.widget.FButton;
import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.utils.ComponentsUtils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View accountFragment;
    private Spinner spiSexAccount;
    private EditText etNameAccount;
    private EditText etAgeAccount;
    private EditText etEmailAccount;
    private EditText etPhoneAccount;
    private FButton btUpdateAccount;
    private String sexSelected;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    // Listeners para los SPINNERS
    private AdapterView.OnItemSelectedListener spinerSelectedListener = new Spinner.OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                   long id) {

            // Si hemos seleccionado un equipo
            if (parent.getId() == R.id.spiSexAccount) {
                // Recogemos el valor
                sexSelected = parent.getItemAtPosition(pos).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    };

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        accountFragment = inflater.inflate(R.layout.fragment_account, container, false);

        spiSexAccount = (Spinner) accountFragment.findViewById(R.id.spiSexAccount);

        // Añadimos los datos al Spinner
        String[] listTrain = getResources().getStringArray(R.array.sexArray);
        ComponentsUtils.addItemsOnSpinner(this.getContext(), spiSexAccount, listTrain);
        // Añadimos el listener
        spiSexAccount.setOnItemSelectedListener(spinerSelectedListener);
        // Recogemos el sexo por defecto
        sexSelected = spiSexAccount.getItemAtPosition(0).toString();

        return accountFragment;
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
