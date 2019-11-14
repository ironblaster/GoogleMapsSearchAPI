# GoogleMapsSearchAPI
Search on google maps Places API


for import this dependency on MAVEN
insert this repository in your POM:

```html
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

and this dependency:
```html
<dependency>
    <groupId>com.github.ironblaster</groupId>
    <artifactId>GoogleMapsSearchAPI</artifactId>
    <version>{LAST-RELASE}</version>
</dependency>
```


last version have only one method:

```java
Collection<PlaceResult> results = SearchPlace.byString(googleAPIKey, languageCode, query);
```

this is the results' structure

```javascript
  	String FormattedAddress; 	//ex: 221B Baker St, Marylebone, London NW1 6XE, UK
	String Locality;		     
	String city;			
	String province;		//ex: Greater London
	String provinceAbbreviation;
	String region;			//ex: England
	String country;			//ex: United Kingdom
	String postalCode;		//ex: NW1 6XE
```

