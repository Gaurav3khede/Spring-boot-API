
package com.tinkhede.backendapi.open.street.map.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenStreetMapDataModel {

	@JsonProperty("osm_type")
    private String osmType;
    private Integer osmId;
    private String _class;
    private String type;
    private Integer adminLevel;
    private Integer rankSearch;
    private Integer rankAddress;
    private Integer placeId;
    private Integer parentPlaceId;
    private Integer housenumber;
    private String countryCode;
    private String langaddress;
    private String placename;
    private String ref;
    @JsonProperty("lon")
    private String lon;
    private String lat;
    private Double importance;
    private String addressimportance;
    private String extraPlace;
    private String addresstype;
    private List<String> aBoundingBox = null;
    private String icon;
    private String label;
    private String name;
    private Double foundorder;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public Integer getOsmId() {
        return osmId;
    }

    public void setOsmId(Integer osmId) {
        this.osmId = osmId;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Integer getRankSearch() {
        return rankSearch;
    }

    public void setRankSearch(Integer rankSearch) {
        this.rankSearch = rankSearch;
    }

    public Integer getRankAddress() {
        return rankAddress;
    }

    public void setRankAddress(Integer rankAddress) {
        this.rankAddress = rankAddress;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getParentPlaceId() {
        return parentPlaceId;
    }

    public void setParentPlaceId(Integer parentPlaceId) {
        this.parentPlaceId = parentPlaceId;
    }

    public Integer getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(Integer housenumber) {
        this.housenumber = housenumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLangaddress() {
        return langaddress;
    }

    public void setLangaddress(String langaddress) {
        this.langaddress = langaddress;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Double getImportance() {
        return importance;
    }

    public void setImportance(Double importance) {
        this.importance = importance;
    }

    public String getAddressimportance() {
        return addressimportance;
    }

    public void setAddressimportance(String addressimportance) {
        this.addressimportance = addressimportance;
    }

    public String getExtraPlace() {
        return extraPlace;
    }

    public void setExtraPlace(String extraPlace) {
        this.extraPlace = extraPlace;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public List<String> getABoundingBox() {
        return aBoundingBox;
    }

    public void setABoundingBox(List<String> aBoundingBox) {
        this.aBoundingBox = aBoundingBox;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFoundorder() {
        return foundorder;
    }

    public void setFoundorder(Double foundorder) {
        this.foundorder = foundorder;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
