package unoesc.edu.br.achadoperdido.achado;

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
import unoesc.edu.br.achadoperdido.R;
import unoesc.edu.br.achadoperdido.perdido.Perdido;

public class AchadoListFragment extends Fragment implements AdapterView.OnItemClickListener {

    List<Achado> achados;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_achado_list,container,false);

        ListView listView = (ListView)view.findViewById(R.id.fragment_achado_list_listview);
        listView.setEmptyView(view.findViewById(android.R.id.empty));
        listView.setOnItemClickListener(this);

        AchadoDAO achadoDAO = new AchadoDAO(getActivity());
        achados = achadoDAO.listar();

        AchadoListAdapter adapter = new AchadoListAdapter(getActivity(), R.layout.fragment_achado_list_item, achados);

        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        Achado achado = achados.get(position);
        Intent it = new Intent(getActivity(), AchadoActivity.class);
        String id1 = String.valueOf(achado.getId());
        it.putExtra(Achado.ID,id1);
        startActivityForResult(it,1);

    }
}
