package sharetrain.gutsapps.com.fragment;

/**
 * Created by Alejandro Gutierrez on 15/11/2016.
 */

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import sharetrain.gutsapps.com.activity.R;
import sharetrain.gutsapps.com.utils.ComponentsUtils;

public class OfferTicketFragment extends Fragment implements
        View.OnClickListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private AutoCompleteTextView autocompleteExitOffer;
    private AutoCompleteTextView autocompleteArrivalOffer;
    private Spinner spiClassOffer;
    private Spinner spiTrainOffer;
    private View offerTicketFragment;
    private ImageView ivExitHourOffer;
    private ImageView ivArrivalHourOffer;
    private ImageView ivExitDateOffer;
    private ImageView ivArrivalDateOffer;

    private String trainSelected;
    private String classSelected;

    private Boolean ivExitHourSelected = false;
    private Boolean ivArrivalHourSelected = false;
    // Listeners para los SPINNERS
    private AdapterView.OnItemSelectedListener spinerSelectedListener = new Spinner.OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                   long id) {

            // Si hemos seleccionado un equipo
            if (parent.getId() == R.id.spiTrainOffer) {
                // Recogemos el valor
                trainSelected = parent.getItemAtPosition(pos).toString();
            } // Si hemos seleccionado una posicion
            else if (parent.getId() == R.id.spiClassOffer) {
                // Recogemos el valor
                classSelected = parent.getItemAtPosition(pos).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        offerTicketFragment = inflater.inflate(R.layout.fragment_offer_ticket, container, false);

        // Get the string array
        String[] countries = getResources().getStringArray(R.array.cities_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, countries);
        // Get a reference to the AutoCompleteTextView in the layout
        autocompleteExitOffer = (AutoCompleteTextView) offerTicketFragment.findViewById(R.id.autocompleteExitOffer);
        autocompleteArrivalOffer = (AutoCompleteTextView) offerTicketFragment.findViewById(R.id.autocompleteArrivalOffer);
        autocompleteExitOffer.setAdapter(adapter);
        autocompleteArrivalOffer.setAdapter(adapter);

        spiClassOffer = (Spinner) offerTicketFragment.findViewById(R.id.spiClassOffer);
        spiTrainOffer = (Spinner) offerTicketFragment.findViewById(R.id.spiTrainOffer);

        // Añadimos los datos al Spinner
        String[] listTrain = getResources().getStringArray(R.array.trainArray);
        ComponentsUtils.addItemsOnSpinner(this.getContext(), spiTrainOffer, listTrain);
        // Añadimos el listener
        spiTrainOffer.setOnItemSelectedListener(spinerSelectedListener);
        // Recogemos el tren por defecto
        trainSelected = spiTrainOffer.getItemAtPosition(0).toString();


        // Añadimos los datos al Spinner
        String[] listClass = getResources().getStringArray(R.array.classArray);
        ComponentsUtils.addItemsOnSpinner(this.getContext(), spiClassOffer, listClass);
        // Añadimos el listener
        spiClassOffer.setOnItemSelectedListener(spinerSelectedListener);
        // Recogemos la clase por defecto
        classSelected = spiClassOffer.getItemAtPosition(0).toString();

        // Date picker
        ivExitDateOffer = (ImageView) offerTicketFragment.findViewById(R.id.ivExitDateOffer);
        ivExitDateOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        OfferTicketFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(true);
                dpd.setTitle(getResources().getString(R.string.choseDay));
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivExitDateOffer.setImageResource(R.drawable.ic_data_picker_red);
                    }
                });

                Calendar today = Calendar.getInstance();
                dpd.setMinDate(today);
                dpd.setAccentColor(Color.parseColor("#ff80cbc4"));
                FragmentManager fm = getActivity().getFragmentManager();
                dpd.show(fm, "ivExitDateOffer");
            }
        });

        // Date picker
        ivArrivalDateOffer = (ImageView) offerTicketFragment.findViewById(R.id.ivArrivalDateOffer);
        ivArrivalDateOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        OfferTicketFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(true);
                dpd.dismissOnPause(true);
                dpd.setTitle(getResources().getString(R.string.choseDay));
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivArrivalDateOffer.setImageResource(R.drawable.ic_data_picker_red);
                    }
                });
                Calendar today = Calendar.getInstance();
                dpd.setMinDate(today);
                dpd.setAccentColor(Color.parseColor("#ff80cbc4"));
                FragmentManager fm = getActivity().getFragmentManager();
                dpd.show(fm, "ivArrivalDateOffer");
            }
        });

        // Time picker
        ivExitHourOffer = (ImageView) offerTicketFragment.findViewById(R.id.ivExitHourOffer);
        ivExitHourOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        OfferTicketFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.setThemeDark(true);
                tpd.dismissOnPause(true);
                tpd.enableSeconds(false);
                tpd.enableMinutes(true);
                tpd.setAccentColor(Color.parseColor("#ff80cbc4"));
                tpd.setTitle(getResources().getString(R.string.choseHour));
                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivExitHourSelected = false;
                        ivExitHourOffer.setImageResource(R.drawable.ic_time_red);
                    }
                });
                FragmentManager fm = getActivity().getFragmentManager();
                tpd.show(fm, "ivExitHourOffer");
                ivExitHourSelected = true;
            }
        });

        // Time picker
        ivArrivalHourOffer = (ImageView) offerTicketFragment.findViewById(R.id.ivArrivalHourOffer);
        ivArrivalHourOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        OfferTicketFragment.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.setThemeDark(true);
                tpd.dismissOnPause(true);
                tpd.enableSeconds(false);
                tpd.enableMinutes(true);
                tpd.setAccentColor(Color.parseColor("#ff80cbc4"));
                tpd.setTitle(getResources().getString(R.string.choseHour));
                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivArrivalHourSelected = false;
                        ivArrivalHourOffer.setImageResource(R.drawable.ic_time_red);
                    }
                });
                FragmentManager fm = getActivity().getFragmentManager();
                tpd.show(fm, "ivArrivalHourOffer");
                ivArrivalHourSelected = true;
            }
        });
        return offerTicketFragment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        if (view.getTag().equals("ivExitDateOffer")) {
            ivExitDateOffer.setImageResource(R.drawable.ic_date_picker_green);
        } else if (view.getTag().equals("ivArrivalDateOffer")) {
            ivArrivalDateOffer.setImageResource(R.drawable.ic_date_picker_green);
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        if (ivExitHourSelected) {
            ivExitHourOffer.setImageResource(R.drawable.ic_time_green);
        } else {
            ivExitHourOffer.setImageResource(R.drawable.ic_time_red);
        }

        if (ivArrivalHourSelected) {
            ivArrivalHourOffer.setImageResource(R.drawable.ic_time_green);
        } else {
            ivArrivalHourOffer.setImageResource(R.drawable.ic_time_red);
        }
    }
}
