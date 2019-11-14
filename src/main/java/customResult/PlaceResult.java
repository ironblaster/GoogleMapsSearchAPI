package customResult;

import java.io.Serializable;
/**
 * A single result in the search results returned from the Google Places API Web Service.
 * @author ironblaster
 *
 */
public class PlaceResult implements Serializable{
	
	private String FormattedAddress="";
	private String Locality="";
	private String city="";
	private String province="";
	private String provinceAbbreviation="";
	private String region="";
	private String country="";
	private String postalCode="";
	
	
	
	public String getFormattedAddress() {
		return FormattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		FormattedAddress = formattedAddress;
	}
	public String getLocality() {
		return Locality;
	}
	public void setLocality(String locality) {
		Locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvinceAbbreviation() {
		return provinceAbbreviation;
	}
	public void setProvinceAbbreviation(String provinceAbbreviation) {
		this.provinceAbbreviation = provinceAbbreviation;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	

}
