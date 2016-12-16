package unoesc.edu.br.achadoperdido.perdido;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;




import unoesc.edu.br.achadoperdido.R;


public class PerdidoCadActivity extends AppCompatActivity {

    // private GpsService gpsService;
    // private ImageView ivFoto;
    private Perdido perdido;
    private PerdidoDAO perdidoDAO;

    private TextView activity_achado_tvData, activity_achado_tvContato;
    private TextView activity_achado_tvCategoria, activity_achado_tvDescricao;

    //private Bitmap bmimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_perdido_cad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        perdidoDAO = new PerdidoDAO(this);

        Intent it = getIntent();
        if (it != null) {
            perdido = new Perdido();
            //   perdido = perdidoDAO.buscar(it.getStringExtra(Perdido.ID));
        }

        activity_achado_tvData = (TextView) findViewById(R.id.activity_achado_tvData);
        activity_achado_tvCategoria = (TextView) findViewById(R.id.activity_achado_tvCategoria);
        activity_achado_tvDescricao = (TextView) findViewById(R.id.activity_achado_tvDescricao);
        activity_achado_tvContato = (TextView) findViewById(R.id.activity_achado_tvContato);


      /*  activity_achado_tvData.setText(perdido.getData());
        activity_achado_tvCategoria.setText(perdido.getCategoria());
        activity_achado_tvDescricao.setText(perdido.getDescricao());
        activity_achado_tvContato.setText(perdido.getContato());

/*
        ivFoto = (ImageView)findViewById(R.id.activity_perdido_imFoto);

        byte[] bytearray = Base64.decode(perdido.getFoto(), Base64.DEFAULT);
        bmimage = BitmapFactory.decodeByteArray(bytearray,0,bytearray.length);
        ivFoto.setImageBitmap(bmimage);
        ivFoto.setOnClickListener(this);

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        gpsService = new GpsService(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_foto);

        dialog.setTitle("Item Encontrado");
        ImageView iFoto = (ImageView) dialog.findViewById(R.id.dialog_foto_imFoto);
        iFoto.setImageBitmap(bmimage);
        dialog.show();
        */
    }

    /*@Override
    public void onMapReady(GoogleMap map) {
        double lat = Double.valueOf(achado.getLatitude());
        double lon = Double.valueOf(achado.getLongitude());
        LatLng latLng = new LatLng(lat,lon);

        //seta minha localizacao
        map.setMyLocationEnabled(true);

        //marcador para a denuncia
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("Teste");
        markerOptions.snippet("Descrição");
        markerOptions.position(latLng);
        map.addMarker(markerOptions);

        //move a camera e zoom para ponto especifico
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}




