package sharetrain.gutsapps.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import sharetrain.gutsapps.com.constants.ParamsConstants;
import sharetrain.gutsapps.com.data.Data;
import sharetrain.gutsapps.com.data.DataBuilder;
import sharetrain.gutsapps.com.recycler.RecyclerViewAdapterTable;

public class ListTableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fabCloseListTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_list_table);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewtable);

        List<Data> data = fill_with_data();

        final RecyclerViewAdapterTable.OnItemClickListenerTable listener = new RecyclerViewAdapterTable.OnItemClickListenerTable() {
            @Override
            public void onItemClick(Data item) {
                Intent detailActivity = new Intent(recyclerView.getContext(),
                        DetailActivity.class);

                //activityList.putExtra(ConstantesParametros.TIPO_VISTA,
                //      ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON);

                startActivityForResult(
                        detailActivity,
                        Integer.valueOf(ParamsConstants.CODE_ACTIVITY_DETAIL_TABLE));
            }
        };

        RecyclerViewAdapterTable adapter = new RecyclerViewAdapterTable(data, getApplication(), listener, ParamsConstants.CODE_ACTIVITY_LIST_TABLE);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabCloseListTable = (FloatingActionButton) findViewById(R.id.fabCloseListTable);
        fabCloseListTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new DataBuilder().setExit("Coruña").setArrival("Javalambre").setTrain("AVE").setPrice("20€").setSeller("Mario").createData());
        data.add(new DataBuilder().setExit("Madrid").setArrival("Suiza").setTrain("AVE").setPrice("20€").setSeller("Pepe").createData());
        data.add(new DataBuilder().setExit("Valencia").setArrival("Barcelona").setTrain("Euromed").setPrice("20€").setSeller("Javi").createData());
        data.add(new DataBuilder().setExit("El Provencio").setArrival("Bilbao").setTrain("Cerca").setPrice("20€").setSeller("Mamen").createData());
        data.add(new DataBuilder().setExit("Sevilla").setArrival("Cuenca").setTrain("AVE").setPrice("20€").setSeller("Lola").createData());
        data.add(new DataBuilder().setExit("Tombuctu").setArrival("Lago Ness").setTrain("Talgo").setPrice("20€").setSeller("Gabi").createData());

        return data;
    }
}
