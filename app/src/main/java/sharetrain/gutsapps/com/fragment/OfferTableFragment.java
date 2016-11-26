package sharetrain.gutsapps.com.fragment;

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

/**
 * Created by Alejandro Gutierrez on 15/11/2016.
 */

public class OfferTableFragment extends Fragment implements
        View.OnClickListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private AutoCompleteTextView autocompleteExitOfferTable;
    private AutoCompleteTextView autocompleteArrivalOfferTable;
    private Spinner spiClassOfferTable;
    private Spinner spiTrainOfferTable;
    private View offerTableFragment;
    private ImageView ivExitHourOfferTable;
    private ImageView ivArrivalHourOfferTable;
    private ImageView ivExitDateOfferTable;
    private ImageView ivArrivalDateOfferTable;

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
        offerTableFragment = inflater.inflate(R.layout.fragment_offer_table, container, false);

        // Get the string array
        String[] countries = getResources().getStringArray(R.array.cities_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, countries);
        // Get a reference to the AutoCompleteTextView in the layout
        autocompleteExitOfferTable = (AutoCompleteTextView) offerTableFragment.findViewById(R.id.autocompleteExitOfferTable);
        autocompleteArrivalOfferTable = (AutoCompleteTextView) offerTableFragment.findViewById(R.id.autocompleteArrivalOfferTable);
        autocompleteExitOfferTable.setAdapter(adapter);
        autocompleteArrivalOfferTable.setAdapter(adapter);

        spiClassOfferTable = (Spinner) offerTableFragment.findViewById(R.id.spiClassOfferTable);
        spiTrainOfferTable = (Spinner) offerTableFragment.findViewById(R.id.spiTrainOfferTable);

        // Añadimos los equipos al Spinner de Equipos
        String[] listTrain = getResources().getStringArray(R.array.trainArray);
        ComponentsUtils.addItemsOnSpinner(this.getContext(), spiTrainOfferTable, listTrain);
        // Añadimos el listener
        spiTrainOfferTable.setOnItemSelectedListener(spinerSelectedListener);
        // Recogemos el equipo por defecto
        trainSelected = spiTrainOfferTable.getItemAtPosition(0).toString();


        // Añadimos los equipos al Spinner de Equipos
        String[] listClass = getResources().getStringArray(R.array.classArray);
        ComponentsUtils.addItemsOnSpinner(this.getContext(), spiClassOfferTable, listClass);
        // Añadimos el listener
        spiClassOfferTable.setOnItemSelectedListener(spinerSelectedListener);
        // Recogemos el equipo por defecto
        classSelected = spiClassOfferTable.getItemAtPosition(0).toString();

        // Date picker
        ivExitDateOfferTable = (ImageView) offerTableFragment.findViewById(R.id.ivExitDateOfferTable);
        ivExitDateOfferTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        OfferTableFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(true);
                dpd.setTitle(getResources().getString(R.string.choseDay));
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ivExitDateOfferTable.setImageResource(R.drawable.ic_data_picker_red);
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
        ivArrivalDateOfferTable = (ImageView) offerTableFragment.findViewById(R.id.ivArrivalDateOfferTable);
        ivArrivalDateOfferTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        OfferTableFragment.this,
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
                        ivArrivalDateOfferTable.setImageResource(R.drawable.ic_data_picker_red);
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
        ivExitHourOfferTable = (ImageView) offerTableFragment.findViewById(R.id.ivExitHourOfferTable);
        ivExitHourOfferTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        OfferTableFragment.this,
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
                        ivExitHourOfferTable.setImageResource(R.drawable.ic_time_red);
                    }
                });
                FragmentManager fm = getActivity().getFragmentManager();
                tpd.show(fm, "ivExitHourOfferTable");
                ivExitHourSelected = true;
            }
        });

        // Time picker
        ivArrivalHourOfferTable = (ImageView) offerTableFragment.findViewById(R.id.ivArrivalHourOfferTable);
        ivArrivalHourOfferTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        OfferTableFragment.this,
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
                        ivArrivalHourOfferTable.setImageResource(R.drawable.ic_time_red);
                    }
                });
                FragmentManager fm = getActivity().getFragmentManager();
                tpd.show(fm, "ivArrivalHourOfferTable");
                ivArrivalHourSelected = true;
            }
        });
        return offerTableFragment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        if (view.getTag().equals("ivExitDateOffer")) {
            ivExitDateOfferTable.setImageResource(R.drawable.ic_date_picker_green);
        } else if (view.getTag().equals("ivArrivalDateOffer")) {
            ivArrivalDateOfferTable.setImageResource(R.drawable.ic_date_picker_green);
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        if (ivExitHourSelected) {
            ivExitHourOfferTable.setImageResource(R.drawable.ic_time_green);
        } else {
            ivExitHourOfferTable.setImageResource(R.drawable.ic_time_red);
        }

        if (ivArrivalHourSelected) {
            ivArrivalHourOfferTable.setImageResource(R.drawable.ic_time_green);
        } else {
            ivArrivalHourOfferTable.setImageResource(R.drawable.ic_time_red);
        }
    }
}
