package unoesc.edu.br.achadoperdido.achado;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import unoesc.edu.br.achadoperdido.R;
import unoesc.edu.br.achadoperdido.gps.GpsService;

public class AchadoActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener{

    private GpsService gpsService;
    private ImageView ivFoto;
    private Achado achado;
    private AchadoDAO achadoDAO;

    private TextView activity_achado_tvData, activity_achado_tvContato;
    private TextView activity_achado_tvCategoria, activity_achado_tvDescricao,
            activity_achado_tvLatitude, activity_achado_tvLongitude;
    private Bitmap bmimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_achado);

        achadoDAO = new AchadoDAO(this);

        Intent it = getIntent();
        if (it != null) {
            achado = new Achado();
            achado = achadoDAO.buscar(it.getStringExtra(Achado.ID));
        }

        activity_achado_tvData = (TextView) findViewById(R.id.activity_achado_tvData);
        activity_achado_tvCategoria = (TextView) findViewById(R.id.activity_achado_tvCategoria);
        activity_achado_tvDescricao = (TextView) findViewById(R.id.activity_achado_tvDescricao);
        activity_achado_tvContato = (TextView) findViewById(R.id.activity_achado_tvContato);
        activity_achado_tvLatitude = (TextView) findViewById(R.id.activity_achado_tvLatitude);
        activity_achado_tvLongitude = (TextView) findViewById(R.id.activity_achado_tvLongitude);

        activity_achado_tvData.setText(achado.getData());
        activity_achado_tvCategoria.setText(achado.getCategoria());
        activity_achado_tvDescricao.setText(achado.getDescricao());
        activity_achado_tvContato.setText(achado.getContato());
        activity_achado_tvLatitude.setText(achado.getLatitude());
        activity_achado_tvLongitude.setText(achado.getLongitude());

        ivFoto = (ImageView)findViewById(R.id.activity_achado_imFoto);

        byte[] bytearray = Base64.decode(achado.getFoto(), Base64.DEFAULT);
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
    }

    @Override
    public void onMapReady(GoogleMap map) {
        double lat = Double.valueOf(achado.getLatitude());
        double lon = Double.valueOf(achado.getLongitude());
        LatLng latLng = new LatLng(lat,lon);

        //seta minha localizacao
        map.setMyLocationEnabled(true);


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("Teste");
        markerOptions.snippet("Descrição");
        markerOptions.position(latLng);
        map.addMarker(markerOptions);

        //move a camera e zoom para ponto especifico
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
    }
}
