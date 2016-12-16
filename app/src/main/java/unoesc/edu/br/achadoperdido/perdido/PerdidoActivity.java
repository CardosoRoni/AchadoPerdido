package unoesc.edu.br.achadoperdido.perdido;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;


import unoesc.edu.br.achadoperdido.R;



public class PerdidoActivity extends AppCompatActivity {
    // private GpsService gpsService;
    private ImageView ivFoto;
    private Perdido perdido;
    private PerdidoDAO perdidoDAO;
    private TextView activity_perdido_tvData, activity_perdido_tvContato;
    private TextView activity_perdido_tvCategoria, activity_perdido_tvDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_perdido);



     // Bitmap bmimage;


       perdidoDAO = new PerdidoDAO(this);

        Intent it = getIntent();
        if (it != null) {
          perdido = new Perdido();
            perdido = perdidoDAO.buscar(it.getStringExtra(Perdido.ID));
        }



        activity_perdido_tvData = (TextView) findViewById(R.id.activity_perdido_tvData);
        activity_perdido_tvCategoria = (TextView) findViewById(R.id.activity_perdido_tvCategoria);
        activity_perdido_tvDescricao = (TextView) findViewById(R.id.activity_perdido_tvDescricao);
        activity_perdido_tvContato = (TextView) findViewById(R.id.activity_perdido_tvContato);


        activity_perdido_tvData.setText(perdido.getData());
        activity_perdido_tvCategoria.setText(perdido.getCategoria());
        activity_perdido_tvDescricao.setText(perdido.getDescricao());
        activity_perdido_tvContato.setText(perdido.getContato());

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


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
*/
    }
}

