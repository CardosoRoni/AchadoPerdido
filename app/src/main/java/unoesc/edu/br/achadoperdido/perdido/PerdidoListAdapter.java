package unoesc.edu.br.achadoperdido.perdido;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import unoesc.edu.br.achadoperdido.R;


import static unoesc.edu.br.achadoperdido.R.id.fragment_achado_list_item_tvCategoria;
import static unoesc.edu.br.achadoperdido.R.id.fragment_achado_list_item_tvData;
import static unoesc.edu.br.achadoperdido.R.id.fragment_achado_list_item_tvDescricao;


/**
 * Created by Roni on 16/12/2016.
 */

public class PerdidoListAdapter extends ArrayAdapter<Perdido> {


    private TextView fragment_perdido_list_item_tvData,
            fragment_perdido_list_item_tvDescricao, fragment_perdido_list_item_tvCategoria,
            fragment_perdido_list_item_tvContato;

    int layout;
    Context context;
    List<Perdido> perdidos;

    public PerdidoListAdapter(Context context, int layout, List<Perdido> perdidos) {
        super(context, layout, perdidos);
        this.context = context;
        this.layout = layout;
        this.perdidos = perdidos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);

        TextView fragment_perdido_list_tvData = (TextView) view.findViewById(fragment_achado_list_item_tvData);
        TextView fragment_perdido_list_item_tvCategoria = (TextView) view.findViewById(fragment_achado_list_item_tvCategoria);
        TextView fragment_perdido_list_item_tvDescricao = (TextView) view.findViewById(fragment_achado_list_item_tvDescricao);
        TextView fragment_perdido_list_item_tvContato = (TextView) view.findViewById(R.id.fragment_perdido_list_item_tvContato);

        final Perdido perdido = getItem(position);

        fragment_perdido_list_item_tvData.setText(perdido.getData());
       fragment_perdido_list_item_tvCategoria.setText(perdido.getCategoria());
        fragment_perdido_list_item_tvDescricao.setText(perdido.getDescricao());
        fragment_perdido_list_item_tvContato.setText(perdido.getContato());


        return view;
    }
}