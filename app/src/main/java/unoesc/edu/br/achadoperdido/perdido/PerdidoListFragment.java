package unoesc.edu.br.achadoperdido.perdido;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;

import java.util.List;

import unoesc.edu.br.achadoperdido.R;


/**
 * Created by Roni on 16/12/2016.
 */

public class PerdidoListFragment extends android.app.Fragment implements AdapterView.OnItemClickListener{
    List<Perdido> perdidos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perdido_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.fragment_perdido_list_listview);
        listView.setEmptyView(view.findViewById(android.R.id.empty));
        listView.setOnItemClickListener(this);
       PerdidoDAO perdidoDAO = new PerdidoDAO(getActivity());
       perdidos = perdidoDAO.listar();

        PerdidoListAdapter adapter = new PerdidoListAdapter(getActivity(), R.layout.fragment_perdido_list_item, perdidos);

        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        Perdido perdido = perdidos.get(position);
        Intent it = new Intent(getActivity(), PerdidoActivity.class);
        String id1 = String.valueOf(perdido.getId());
        it.putExtra(Perdido.ID, id1);
        startActivityForResult(it, 1);
    }

}
