package unoesc.edu.br.achadoperdido.gps;


import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;

public class GpsService extends Service implements LocationListener {

    Context context;
    Location location;

    public GpsService() {

    }

    public GpsService(Context context) {
        this.context = context;
        getLocation(context);
    }

    public Location getLocation(Context context) {
        try{
            LocationManager lm = (LocationManager)
                    context.getSystemService(Context.LOCATION_SERVICE);
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
            if (lm != null) {
                location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }

            if (location == null) {
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,this);
                if(lm != null) {
                    location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }
            }

        } catch (Exception e) {

        } return location;
    }

    public double getLatitude(){
        return location.getLatitude();
    }

    public double getLongitude(){
        return location.getLongitude();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
