package com.example.itresna_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itresna_android.senales.PSenales;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class
AdaptadorRecyclerPCops extends RecyclerView.Adapter<com.example.itresna_android.AdaptadorRecyclerPCops.ViewHolder> {
    //Creamos una lista del tipo de nuestra clase

    private ArrayList<Cops> listaCops ;
    String codigo;
    Bitmap bmp;
    ArrayList<Cop>listaCop;



    // Constructor del adaptador
    AdaptadorRecyclerPCops(ArrayList<Cops> listaCops) {
        this.listaCops = listaCops;
    }

    // Colocamos el xml del elemento selector
    @NonNull
    @Override
    public com.example.itresna_android.AdaptadorRecyclerPCops.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_selector_pcops, parent, false);

        return new com.example.itresna_android.AdaptadorRecyclerPCops.ViewHolder(v);
    }

    // Aqui ponemos los elementos que se muestran en pantalla
    @Override
    public void onBindViewHolder(final com.example.itresna_android.AdaptadorRecyclerPCops.ViewHolder holder, final int position) {
        final String nombre = listaCops.get(position).getNombreCop();
        //final String imgRecycler = listaCops.get(position).getNombreImagen();
        String imgR="";
        ArrayList<Cop> copss = new ArrayList<>();

        //
        //intent.putExtra("senal", senal);
        Aplication myApplication ;
        myApplication = (Aplication) holder.itemView.getContext().getApplicationContext();;
        copss = myApplication.cops;
        for(int i=0; copss.size()>i;i++) {
            if (copss.get(i).getDesc_cop().equals(nombre)){
               //imgRecycler = copss.get(i).img_cop;
               imgR= copss.get(i).img_cop;
            }
        }

        final String imgRecycler =imgR;




        //final String senal = listaCops.get(position).getSenal();
        int resID = holder.itemView.getResources().getIdentifier(imgRecycler , "drawable", holder.itemView.getContext().getPackageName());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    InputStream in = null;
                    in = new java.net.URL(imgRecycler).openStream();
                            bmp = BitmapFactory.decodeStream(in);




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //foto.setImageBitmap(bmp);
                holder.imgRecycler.setImageBitmap(bmp);
                System.out.println("IMG RECYCLER "+imgRecycler);
                holder.nombreCop.setText(nombre);

            }
        }, 500);
        holder.imgRecycler.setImageResource(resID);




       // holder.senal.setText(senal);

        // Aquí programamos el click del elemento del recyclerview
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PSenales.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("nombreImagen", imgRecycler);

                Aplication myApplication ;
                ArrayList<Cop> copss = new ArrayList<>();

                //
                //intent.putExtra("senal", senal);
                myApplication = (Aplication) holder.itemView.getContext().getApplicationContext();;
                copss = myApplication.cops;
                for(int i=0; copss.size()>i;i++) {
                    if (copss.get(i).getDesc_cop().equals(nombre)){
                        codigo = copss.get(i).cod_cop;
                    }
                }
                intent.putExtra("codigo",codigo);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaCops.size();
    }

    // Esto es necesario
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Aqui tambien ponemos los elementos del elemento selector
        private TextView nombreCop;
        private ImageView imgRecycler;
        private  TextView senal;
        ViewHolder(View v) {
            super(v);
            imgRecycler = v.findViewById(R.id.imgRecyclerPCops);
            nombreCop = v.findViewById(R.id.txtNomEmpresaRecyclerPCops);
          //  senal = v.findViewById(R.id.txtSenalRecyclerPCops);
        }
    }

}
