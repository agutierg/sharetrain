package sharetrain.gutsapps.com.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Alejandro Gutierrez on 16/11/2016.
 */

public class ComponentsUtils {

    // Método que añade los datos a un Spinner
    public static void addItemsOnSpinner(Context context, Spinner spiner, String[] listaItems) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, listaItems);
        spiner.setAdapter(adapter);
    }
}
