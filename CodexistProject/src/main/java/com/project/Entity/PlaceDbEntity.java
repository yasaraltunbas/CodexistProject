package com.project.CodexistProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class PlaceDbEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private double lat;
private double longi;
private int radius;

private String result;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getLat() {
	return lat;
}
public void setLat(double lat) {
	this.lat = lat;
}
public double getLongi() {
	return longi;
}
public void setLongi(double longi) {
	this.longi = longi;
}
public int getRadius() {
	return radius;
}
public void setRadius(int radius) {
	this.radius = radius;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public PlaceDbEntity(int id, double lat, double longi, int radius, String result) {
	super();
	this.id = id;
	this.lat = lat;
	this.longi = longi;
	this.radius = radius;
	this.result = result;
}
public PlaceDbEntity() {
	super();
}


}
