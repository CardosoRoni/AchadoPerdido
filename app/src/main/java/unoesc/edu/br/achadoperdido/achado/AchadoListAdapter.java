package unoesc.edu.br.achadoperdido.achado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import unoesc.edu.br.achadoperdido.R;

/**
 * Created by Luiz Felipe on 14/12/2016.
 */

public class AchadoListAdapter extends ArrayAdapter<Achado> {

    private TextView fragment_achado_list_item_tvData, fragment_achado_list_item_tvCategoria,
            fragment_achado_list_item_tvDescricao, fragment_achado_list_item_tvContato,
            fragment_achado_list_item_tvLatitude, fragment_achado_list_item_tvLongitude;

    int layout;
    Context context;
    List<Achado> achados;

    public AchadoListAdapter(Context context, int layout, List<Achado> achados) {
        super(context, layout, achados);
        this.context = context;
        this.layout = layout;
        this.achados = achados;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);

        TextView fragment_achado_list_item_tvData = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvData);
        TextView fragment_achado_list_item_tvCategoria = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvCategoria);
        TextView fragment_achado_list_item_tvDescricao = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvDescricao);
        TextView fragment_achado_list_item_tvContato = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvContato);
        TextView fragment_achado_list_item_tvLatitude = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvLatitude);
        TextView fragment_achado_list_item_tvLongitude = (TextView) view.findViewById(R.id.fragment_achado_list_item_tvLongitude);

        final Achado achado = getItem(position);

        fragment_achado_list_item_tvData.setText(achado.getData());
        fragment_achado_list_item_tvCategoria.setText(achado.getCategoria());
        fragment_achado_list_item_tvDescricao.setText(achado.getDescricao());
        fragment_achado_list_item_tvContato.setText(achado.getContato());
        fragment_achado_list_item_tvLatitude.setText(achado.getLatitude());
        fragment_achado_list_item_tvLongitude.setText(achado.getLongitude());

        return view;
    }
}
