package ch.ffhs.esa.earthquakemap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsEarthquakeMapActivity extends Activity {

	// Coordinates used for centering the Map
	private static final double CAMERA_LNG = 87.0;
	private static final double CAMERA_LAT = 17.0;

	// The Map Object
	private GoogleMap mMap;

	// URL for getting the earthquake
	// replace with your own user name
	private final static String UNAME = "cheeyam";
	private final static String URL = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username="
			+ UNAME;

	public static final String TAG = "MapsEarthquakeMapActivity";

	// Set up UI and get earthquake data
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		new HttpGetTask().execute(URL);
	}

	private class HttpGetTask extends
			AsyncTask<String, Void, List<EarthQuakeRec>> implements OnMapReadyCallback{

		private List<EarthQuakeRec> mEarthQuakeList;

		@Override
		protected List<EarthQuakeRec> doInBackground(String... params) {
            String urlString = params[0];
            // TODO: use JSONResponseHandler to return the list of EarthQuakeRec.


			return null;
		}

		@Override
		protected void onPostExecute(List<EarthQuakeRec> result) {
			mEarthQuakeList = result;
            //TODO: Get Map Object using getMapAsync on the MapFragment.
		}

		// Assign marker color
		private float getMarkerColor(double magnitude) {

			if (magnitude < 6.0) {
				magnitude = 6.0;
			} else if (magnitude > 9.0) {
				magnitude = 9.0;
			}

			return (float) (120 * (magnitude - 6));
		}

		@Override
		public void onMapReady(GoogleMap googleMap) {
			mMap = googleMap;
			if (null != mMap) {
				// TODO: Add a marker for every earthquake
							// TODO: Set the Marker's position

							// TODO: Set the title of the Marker's information window

							// TODO: Set the color for the Marker


				// TODO: Center the map - should compute map center from the actual data
			}
		}
	}

	// Helper method to extract String from the connection in a buffered fashion.
    private String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e) {
            Log.i(TAG, "Error reading InputStream");
            result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    Log.i(TAG, "Error closing InputStream");
                }
            }
        }

        return result;
    }
}