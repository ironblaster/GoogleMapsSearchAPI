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

```linguist
Collection<PlaceResult> results = SearchPlace.byString(googleAPIKey, languageCode, query);
```

this is the results' structure

```javascript
  	String FormattedAddress;
	String Locality;
	String city;
	String province;
	String provinceAbbreviation;
	String region;
	String country;
	String postalCode;
```

