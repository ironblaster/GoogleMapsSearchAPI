package googleMaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.FindPlaceFromTextRequest.InputType;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResult;

import customResult.PlaceResult;
/**
 * 
 * @author ironblaster
 *
 */
public class SearchPlace {
	
	/**
	 * 
	 * @param googleAPIKey The API Key to use.
	 * @param languageCode all language supported: <a href="https://developers.google.com/maps/faq#languagesupport">SUPPORTED LANGUAGE CODE</a>
	 * @param query The input to search on.
	 * @throws ApiException Thrown if the API Returned result is an error.
	 * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted.
	 * @throws IOException Thrown when an I/O exception of some sort has occurred.
	 * @return Collection of resoult.
	 */
	public static Collection<PlaceResult> byString(String googleAPIKey,String languageCode,String query) throws ApiException, InterruptedException, IOException {
		
	
			GeoApiContext context = new GeoApiContext.Builder()
				    .apiKey(googleAPIKey)
				    .build();
			
			
			
			FindPlaceFromText results = PlacesApi.
					findPlaceFromText(context,query, InputType.TEXT_QUERY)
					.language(languageCode)
					.await();
			
			PlacesSearchResult[] resoultList = results.candidates;
			if (resoultList.length==0) {
				return new ArrayList<PlaceResult>();
			}
			
				  
			
			
			
				Collection<PlaceResult> placeresults = new ArrayList<PlaceResult>();
			

			for (PlacesSearchResult singleresoult : resoultList) {
				PlaceResult singleres = new PlaceResult();
				PlaceDetails detresult = PlacesApi.placeDetails(context, singleresoult.placeId).await();
					
				AddressComponent[] comp = detresult.addressComponents;
				
				try{singleres.setFormattedAddress(detresult.formattedAddress);}catch (Exception e) {}
			
				
				for (AddressComponent co : comp) {
					
					for (AddressComponentType tipo : co.types) {
						
						if(tipo.equals(AddressComponentType.LOCALITY))
							try{singleres.setLocality(co.longName);}catch (Exception e) {}
						
						if(tipo.equals(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_3))
							try{singleres.setCity(co.longName);}catch (Exception e) {}
						
						if (tipo.equals(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2)) {
							try{singleres.setProvinceAbbreviation(co.shortName);}catch (Exception e) {}
							try{singleres.setProvince(co.longName);}catch (Exception e) {}
						}
						if (tipo.equals(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1))
							try{singleres.setRegion(co.longName);}catch (Exception e) {}
						
						if (tipo.equals(AddressComponentType.COUNTRY))
							try{singleres.setCountry(co.longName);}catch (Exception e) {}
						
						if (tipo.equals(AddressComponentType.POSTAL_CODE)) 
							try{singleres.setPostalCode(co.longName);}catch (Exception e) {}
					}
				}
					
					placeresults.add(singleres);
					
				}
				return placeresults;
					
		

		
		
		
	}

}
