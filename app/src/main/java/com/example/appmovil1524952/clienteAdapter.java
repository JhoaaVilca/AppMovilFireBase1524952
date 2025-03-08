package com.example.appmovil1524952;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Queue;

public class clienteAdapter extends RecyclerView.Adapter<clienteAdapter.ViewHolderClientes> {


    @NonNull
    @Override
    public clienteAdapter.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull clienteAdapter.ViewHolderClientes holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        public ViewHolderClientes(@NonNull View itemView) {
            super(itemView);
        }
    }
}
