package com.example.appmovil1524952;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Queue;

public class clienteAdapter extends RecyclerView.Adapter<clienteAdapter.ViewHolderClientes> {

    List<clientev> ListaCLientes;

    public clienteAdapter(List<clientev> clientes){
        this.ListaCLientes = clientes;
    }

    @NonNull
    @Override
    public clienteAdapter.ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,parent, false);
        ViewHolderClientes holder = new ViewHolderClientes(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull clienteAdapter.ViewHolderClientes holder, int position) {
        clientev clientes = ListaCLientes.get(position);

        holder.Apellido.setText(clientes.getApellidos());
        holder.Nombre.setText(clientes.getNombre());
        holder.Telefono.setText(clientes.getTelefono());
        holder.Correo.setText(clientes.getCorreo());


    }

    @Override
    public int getItemCount() {
        return ListaCLientes.size();
    }
    public class ViewHolderClientes extends RecyclerView.ViewHolder{

        TextView Apellido, Nombre, Telefono, Correo;

        public ViewHolderClientes(@NonNull View itemView) {
            super(itemView);
            Apellido = itemView.findViewById(R.id.txtApellidoLista);
            Nombre = itemView.findViewById(R.id.txtnNombreLista);
            Telefono = itemView.findViewById(R.id.txtTelefonoLista);
            Correo = itemView.findViewById(R.id.txtCorreoLista);
        }
    }
}
