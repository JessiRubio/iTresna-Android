package com.example.itresna_android.cops;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.itresna_android.Login;
import com.example.itresna_android.R;

import java.util.ArrayList;
import java.util.Locale;


public class PCops extends AppCompatActivity {

    Spinner comboBox;
    String[] arrayCombobox;
    ArrayAdapter<String> adapter;
    RecyclerView reyclerViewCops;
    AdaptadorRecyclerPCops adaptadorRecycler;
    ArrayList<Cops> listaCops = new ArrayList<>();
    RadioButton rb_cast;
    RadioButton rb_eus;
    RadioButton rb_eng;

    private Context mContext;

    private LinearLayout mRelativeLayout;

    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pcops);

        reyclerViewCops = findViewById(R.id.recyclerViewPCops);
        comboBox = findViewById(R.id.spinnerPCops);

        //Hacemos lo relacionado con el comboBox(Spinner)
        arrayCombobox = new String[] {
                "David", "El", "Cajas", "También", "Conocido", "Como", "David"
        };
        adapter = new ArrayAdapter<>(this,
                R.layout.spinner_texto, arrayCombobox);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBox.setAdapter(adapter);

        comboBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(comboBox.getSelectedItem() == "Cajas"){
                    Toast.makeText(getApplicationContext(), "David el Cajas", Toast.LENGTH_SHORT).show();
                    Cops prueba1 = new Cops("app_logo", "Iberdrola", "1. señal");
                    Cops prueba2 = new Cops("logo", "Accenture", "1. señal");
                    Cops prueba3 = new Cops("logo", "Ibermatica", "1. señal");
                    Cops prueba4 = new Cops("logo", "Ibernautica", "1. señal");
                    listaCops.clear();
                    listaCops.add(prueba1);
                    listaCops.add(prueba2);
                    listaCops.add(prueba3);
                    listaCops.add(prueba4);
                    generarDatosRecyler(listaCops);
                }
                else if (comboBox.getSelectedItem() == "David"){
                    Toast.makeText(getApplicationContext(), "David el David", Toast.LENGTH_SHORT).show();
                    Cops prueba1 = new Cops("logo", "Iberdrola", "1. señal");
                    Cops prueba2 = new Cops("logo", "Accenture", "1. señal");
                    Cops prueba3 = new Cops("logo", "Ibermatica", "1. señal");
                    Cops prueba4 = new Cops("logo", "Ibernautica", "1. señal");
                    listaCops.clear();
                    listaCops.add(prueba1);
                    listaCops.add(prueba2);
                    listaCops.add(prueba3);
                    listaCops.add(prueba4);
                    generarDatosRecyler(listaCops);
                }
                else if (comboBox.getSelectedItem() == "El"){
                    Toast.makeText(getApplicationContext(), "David el El", Toast.LENGTH_SHORT).show();
                    Cops prueba1 = new Cops("app_logo", "Iberdrola", "1. señal");
                    Cops prueba2 = new Cops("app_logo", "Accenture", "1. señal");
                    Cops prueba3 = new Cops("app_logo", "Ibermatica", "1. señal");
                    Cops prueba4 = new Cops("app_logo", "Ibernautica", "1. señal");
                    listaCops.clear();
                    listaCops.add(prueba1);
                    listaCops.add(prueba2);
                    listaCops.add(prueba3);
                    listaCops.add(prueba4);
                    generarDatosRecyler(listaCops);
                } else{
                    Toast.makeText(getApplicationContext(), "David el Deseleccionado", Toast.LENGTH_SHORT).show();
                    Cops prueba1 = new Cops("logo", "Iberdrola", "1. señal");
                    Cops prueba2 = new Cops("logo", "Accenture", "1. señal");
                    Cops prueba3 = new Cops("logo", "Ibermatica", "1. señal");
                    Cops prueba4 = new Cops("logo", "Ibernautica", "1. señal");
                    listaCops.clear();
                    listaCops.add(prueba1);
                    listaCops.add(prueba2);
                    listaCops.add(prueba3);
                    listaCops.add(prueba4);
                    generarDatosRecyler(listaCops);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Get the application context
        mContext = getApplicationContext();

        // Get the widgets reference from XML layout
        mRelativeLayout =  findViewById(R.id.li);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.findItem(R.id.menu_nombre_usuario).setTitle("xDDDD");

        // Creamos un nuevo ActionBar que va a ser un personalizado
        // para poder alinear el logo a la izquierda
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        //Aquí añadimos el custom ActionBar
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbar_personalizado, null);
        actionBar.setCustomView(mActionBarView);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuitem_admin) {
            //Aquí el código de cuando se clique en admin
        } else if (item.getItemId() == R.id.menuitem_idioma){
            // Iniciamos la instancia del inflater
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflamos la vista personlizada
            final View customView = inflater.inflate(R.layout.popup_idiomas,null);

            rb_cast = new RadioButton(customView.getContext());
            rb_cast = customView.findViewById(R.id.radio_castellano);

            rb_eus = new RadioButton(customView.getContext());
            rb_eus = customView.findViewById(R.id.radio_euskera);

            rb_eng = new RadioButton(customView.getContext());
            rb_eng = customView.findViewById(R.id.radio_ingles);

            // Iniciamos una nueva instancia del pop up
            mPopupWindow = new PopupWindow(
                    customView,
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            // Elevar el pop up
            mPopupWindow.setElevation(5.0f);

            // Coger el id del botón del pop up
            ImageButton closeButton = customView.findViewById(R.id.ib_close);

            // Click listener del botón cerrar del pop up
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Configuration config = new Configuration(Resources.getSystem().getConfiguration());

                    // Dismiss the popup window
                    if (rb_cast.isChecked()){
                        setIdioma("es");
                    } else if (rb_eus.isChecked()){
                        setIdioma("eu");
                    } else if (rb_eng.isChecked()){
                        setIdioma("en");
                    }
                    mPopupWindow.dismiss();
                }
            });
            // Centrar el pop up en mitad de la pantalla
            mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);

        } else if (item.getItemId() == R.id.menuitem_cerrar_sesion){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    public void generarDatosRecyler(ArrayList <Cops> listaCops){
        // Este ajuste mejora la performance, solo si el
        // contenido del recycler no altera su tamaño
        reyclerViewCops.setHasFixedSize(true);

        // Colocamos 3 columnas en el recyclerView
        reyclerViewCops.setLayoutManager (new GridLayoutManager(this, 2));

        // Especificamos el adaptador para el recycler
        adaptadorRecycler = new AdaptadorRecyclerPCops(listaCops);
        reyclerViewCops.setAdapter(adaptadorRecycler);
    }

    public void setIdioma(String lang) {
        Locale idioma = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = idioma;
        res.updateConfiguration(conf, dm);
        this.recreate();
    }
}
