package com.project.CodexistProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.CodexistProject.entity.Constants;
import com.project.CodexistProject.entity.PlaceDbEntity;
import com.project.CodexistProject.entity.Places;
import com.project.CodexistProject.repository.PlacesJpaRepository;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;




@RestController
@RequestMapping("/api/places")
public class PlacesController {

	
	private PlacesJpaRepository placesjpaRepository; 

@Autowired
	public PlacesController(PlacesJpaRepository placesjpaRepository) {
		super();
		this.placesjpaRepository = placesjpaRepository;
	}


	public PlacesController() {
		super();
	}


	@GetMapping("/getAll")
	public Places  getAll(double longitude, double latitude, int radius) {
		
		List <PlaceDbEntity> dbentity =  placesjpaRepository.findByLatAndLongiAndRadius(latitude, longitude, radius);
		Gson gson = new GsonBuilder().create();

		if (dbentity.isEmpty())
		{
			OkHttpClient client = new OkHttpClient();
			  
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = RequestBody.create(mediaType, "");
			Request request = new Request.Builder()
			  .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+longitude +"%2C"+ latitude +"&radius="+radius+"&type=restaurant&keyword=cruise&key="+ Constants.API_KEY)
			  .method("POST", body)
			  .build();
			try {
				System.out.println("Google API'den veri çekiliyor.");
				Response response = client.newCall(request).execute();
				System.out.println("Veri çekme tamamlandı.");

				String jsonResponse = response.body().string();
				Places places = gson.fromJson(jsonResponse, Places.class);
				PlaceDbEntity entity = new PlaceDbEntity();
				entity.setLat(latitude);
				entity.setLongi(longitude);
				entity.setRadius(radius);
				entity.setResult(jsonResponse);
				System.out.println("Veri tabanına kaydedildi.");

				placesjpaRepository.save(entity);
				
				return places;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("Veritabanında veri alınıyor.");

			Places places = gson.fromJson(dbentity.get(0).getResult(), Places.class);
			return places;
			
		}
		
return null;
	}
	
	
	

}
