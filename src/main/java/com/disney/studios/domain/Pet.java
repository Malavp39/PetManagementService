package com.disney.studios.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// Pet Persistence Entity
@Entity
public class Pet {
	@Id
    @GeneratedValue
    private Long id;
	
	private String breed;
	
	private String pictureURL;
	private int favoriteCount;
	
	// TODO; Maintain a list of client Ids to enable duplicate vote check
	
    public Long getId() {
        return id;
    }

    public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getPictureURL() {
		return pictureURL;
	}


	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}


	public int getFavoriteCount() {
		return favoriteCount;
	}


	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public Pet(String breed, String pictureURL, int favoriteCount) { // jpa only
		this.breed = breed;
		this.pictureURL = pictureURL;
		this.favoriteCount = favoriteCount;
    }

	Pet() { // jpa only
    }

	@Override
	public String toString() {
		return "Pet [id=" + id + ", breed=" + breed + ", pictureURL="
				+ pictureURL + ", favoriteCount=" + favoriteCount + "]";
	}
	
	
}
