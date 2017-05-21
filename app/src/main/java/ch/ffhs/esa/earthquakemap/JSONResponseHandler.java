package ch.ffhs.esa.earthquakemap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONResponseHandler  {
	public List<EarthQuakeRec> handleResponse(String response)
			throws  IOException {
		List<EarthQuakeRec> result = new ArrayList<EarthQuakeRec>();

		/*
		Response ist eine Array.
		Ein Eintrag der Array sieht so aus:
		{"datetime":"2016-03-02 12:55:00","depth":24,"lng":94.275,"src":"us","eqid":"us10004u1y","magnitude":7.8,"lat":-4.9082}
		 */
		// TODO: mittels JSONTokener, JSONObject, die Liste von EarthQuakeRec erstellen.
		return result;
	}

}
