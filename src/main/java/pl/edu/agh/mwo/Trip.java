package pl.edu.agh.mwo;

import java.util.ArrayList;

public class Trip {
	private String name;
	private String description;
	
	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public ArrayList<Photo> getPhotoList() {
		return photoList;
	}

	private ArrayList<Photo> photoList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addPhoto(Photo photo) {
		photoList.add(photo);
		
	}
}
