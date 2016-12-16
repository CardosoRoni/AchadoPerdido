package unoesc.edu.br.achadoperdido.achado;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import unoesc.edu.br.achadoperdido.R;
import unoesc.edu.br.achadoperdido.gps.GpsService;


public class AchadoCadActivity extends AppCompatActivity {

    private TextView achado_cad_tvData;
    private EditText achado_cad_edtCategoria,
            achado_cad_edtDescricao, achado_cad_edtContato;
    private ImageView achado_cad_ivFoto;
    private Button achado_cad_btnSalvar;

    private GoogleApiClient client;
    private GpsService gpsService;
    String strFoto;
    AchadoDAO achadoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achado_cad);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        achado_cad_tvData = (TextView) findViewById(R.id.achado_cad_tvData);
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        achado_cad_tvData.setText(currentDateTimeString);

        achado_cad_edtCategoria = (EditText) findViewById(R.id.achado_cad_edtCategoria);
        achado_cad_edtDescricao = (EditText) findViewById(R.id.achado_cad_edtDescricao);
        achado_cad_edtContato = (EditText) findViewById(R.id.achado_cad_edtContato);
        achado_cad_ivFoto = (ImageView) findViewById(R.id.achado_cad_ivFoto);
        achado_cad_btnSalvar = (Button) findViewById(R.id.achado_cad_btnSalvar);

        achadoDAO = new AchadoDAO(this);



        achado_cad_btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarAchado(v);
                Toast.makeText(AchadoCadActivity.this,"Salvo!", Toast.LENGTH_LONG).show();
            }
        });

        gpsService = new GpsService(this);

    }

    public void capturarFoto(View v){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            achado_cad_ivFoto.setImageBitmap(bitmap);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
            byte[] bytes = baos.toByteArray();
            strFoto = Base64.encodeToString(bytes,Base64.DEFAULT);
        }
    }

    public void salvarAchado(View v) {
        Achado achado = new Achado();
        achado.setData(achado_cad_tvData.getText().toString());
        achado.setCategoria(achado_cad_edtCategoria.getText().toString());
        achado.setDescricao(achado_cad_edtDescricao.getText().toString());
        achado.setContato(achado_cad_edtContato.getText().toString());
        achado.setFoto(strFoto);
        String latitude = String.valueOf(gpsService.getLatitude());
        String longitude = String.valueOf(gpsService.getLongitude());
        achado.setLatitude(latitude);
        achado.setLongitude(longitude);
        achadoDAO.salvar(achado);
    }

    public void finalizar(){
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finalizar();
                break;
        } return true;
    }
}

