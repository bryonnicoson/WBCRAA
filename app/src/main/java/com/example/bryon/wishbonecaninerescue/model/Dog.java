package com.example.bryon.wishbonecaninerescue.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryon on 8/10/16.
 */
public class Dog implements Serializable {

    public String name;
    public String breed;
    public String age;
    public String sex;
    public String size;
    public boolean hasShots = false;
    public boolean altered = false;
    public boolean housetrained = false;
    public String description;
    public List<String> images;

    public Dog(String name, String breed, String age, String sex, String size, boolean hasShots,
               boolean altered, boolean housetrained, String description, List<String> images) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.size = size;
        this.hasShots = hasShots;
        this.altered = altered;
        this.housetrained = housetrained;
        this.description = description;
        this.images = images;
    }

    public static ArrayList<Dog> dogMaker(JsonResponse jsonResponse) {

        String name = "";
        String breed = "";
        String age = "";
        String size = "";
        String sex = "";
        String description = "";
        boolean hasShots;
        boolean altered;
        boolean housetrained;
        ArrayList<String> images = new ArrayList<>();

        ArrayList<Dog> dogs = new ArrayList<>();

        List<Pet> lP = jsonResponse.petfinder.pets.pet;

        for (int i = 0; i < lP.size(); i++) {

            hasShots = false;
            altered = false;
            housetrained = false;

            if(lP.get(i).name != null)
                name = lP.get(i).name;

            if(lP.get(i).breeds.breed != null) {            // breed array requires formatting
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < lP.get(i).breeds.breed.size(); j++) {
                    sb.append(lP.get(i).breeds.breed.get(j).toString());
                    if (j + 1 < lP.get(i).breeds.breed.size())
                        sb.append(" - ");
                }
                if (lP.get(i).mix.equals("yes"))            // tacking mix on to breed
                    sb.append(" Mix");
                breed = sb.toString();
            }

            if(lP.get(i).age != null)
                age = lP.get(i).age;

            if(lP.get(i).sex != null) {
                if (lP.get(i).sex.equals("M"))
                    sex = "Male";
                else
                    sex = "Female";
            }

            if(lP.get(i).size != null) {
                if (lP.get(i).size.equals("S"))
                    size = "Small";
                if (lP.get(i).size.equals("M"))
                    size = "Medium";
                if (lP.get(i).size.equals("L"))
                    size = "Large";
            }

            // wishbone only wants to display these three options (hasShots, altered, housetrained)
            // if one of those is in option list, set appropriate boolean to true.
            if(lP.get(i).options.option != null) {
                for (int j = 0; j < lP.get(i).options.option.size(); j++) {
                    if (lP.get(i).options.option.get(j).equals("hasShots"))
                        hasShots = true;
                    if (lP.get(i).options.option.get(j).equals("altered"))
                        altered = true;
                    if (lP.get(i).options.option.get(j).equals("housetrained"))
                        housetrained = true;
                }
            }

            if(lP.get(i).description != null)
                description = lP.get(i).description;

            // Photos - Petfinder ships with three pics in five sizes ea. - we want size x
            // get only these urls and plug them in to our own list - wb will post 1-3 pics
            if(lP.get(i).media.photos.photo != null) {
                images = new ArrayList<>();
                for (int j = 0; j < lP.get(i).media.photos.photo.size(); j++) {
                    if (lP.get(i).media.photos.photo.get(j).size.equals("x")) {
                        images.add(lP.get(i).media.photos.photo.get(j).content);
                    }
                }
            }

            Dog dog = new Dog(name, breed, age, sex, size, hasShots, altered, housetrained,
                    description, images);

            dogs.add(dog);
        }
        return dogs;
    }
}
