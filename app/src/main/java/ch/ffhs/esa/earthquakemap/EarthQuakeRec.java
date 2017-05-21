package ch.ffhs.esa.earthquakemap;

public class EarthQuakeRec {
	private double lat, lng, magnitude;

	protected EarthQuakeRec(double lat, double lng, double magnitude) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.magnitude = magnitude;
	}

	// Sind getters schneller als direkte public Eigenschaften?
	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public double getMagnitude() {
		return magnitude;
	}
}
