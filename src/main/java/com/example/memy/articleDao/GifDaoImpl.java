package com.example.memy.articleDao;

import com.example.memy.model.Gif;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slickender on 02.08.2017.
 */
public class GifDaoImpl implements GifDao {

    private static List<Gif> gifList = new ArrayList<>();
    private static CategoryDaoImpl categoryDao= new CategoryDaoImpl();

    static {
        gifList.add(new Gif("android-explosion", true,"Tom", categoryDao.findAll().get(0)));
        gifList.add(new Gif("ben-and-mike", false,"Edd", categoryDao.findAll().get(0)));
        gifList.add(new Gif("book-dominos", false,"Joe", categoryDao.findAll().get(1)));
        gifList.add(new Gif("compiler-bot", true,"Steve", categoryDao.findAll().get(1)));
        gifList.add(new Gif("cowboy-coder", false,"Emily", categoryDao.findAll().get(2)));
        gifList.add(new Gif("infinite-andrew", false,"Monica", categoryDao.findAll().get(2)));
        gifList.add(new Gif("comp1", false,"Alex", categoryDao.findAll().get(3)));
        gifList.add(new Gif("comp2", false,"Kim", categoryDao.findAll().get(3)));

    }

    public List<Gif> allGifs() {
        return gifList;
    }

    public List<Gif> gifsInCategory(String name){
        List<Gif> result=new ArrayList<>();
        if (categoryDao.findAll().get(0).getName().equals(name))
            result=gifsInCategory(categoryDao.findAll().get(0).getId());
        else if (categoryDao.findAll().get(1).getName().equals(name))
            result=gifsInCategory(categoryDao.findAll().get(1).getId());
        else if (categoryDao.findAll().get(2).getName().equals(name))
            result=gifsInCategory(categoryDao.findAll().get(2).getId());
        else if (categoryDao.findAll().get(3).getName().equals(name))
            result=gifsInCategory(categoryDao.findAll().get(3).getId());
        return result;
    }

    public List<Gif> gifsInCategory(Long id){
        List<Gif> gifListInPainted=new ArrayList<>();
        List<Gif> gifListInRealistic=new ArrayList<>();
        List<Gif> gifListInAmazing=new ArrayList<>();
        List<Gif> gifListInCoding=new ArrayList<>();
        for (Gif gif: gifList) {
            if (gif.getCategory().equals(categoryDao.findAll().get(0)) && !gifListInPainted.contains(gif))
                gifListInPainted.add(gif);
            if (gif.getCategory().equals(categoryDao.findAll().get(1)) && !gifListInRealistic.contains(gif))
                gifListInRealistic.add(gif);
            if (gif.getCategory().equals(categoryDao.findAll().get(2)) && !gifListInAmazing.contains(gif))
                gifListInAmazing.add(gif);
            if (gif.getCategory().equals(categoryDao.findAll().get(3)) && !gifListInAmazing.contains(gif))
                gifListInCoding.add(gif);
        }
        if (id.equals(1L)) {
            return gifListInPainted;
        } else if (id.equals(2L)) {
            return gifListInRealistic;
        } else if (id.equals(3L)) {
            return gifListInAmazing;
        } else if (id.equals(4L)) {
            return gifListInCoding;
        } else
            return gifList;
    }

    @Override
    public List<Gif> findFavourites() {
        List<Gif> favouritesGifs = new ArrayList<>();
        for (int i = 0; i < gifList.size(); i++) {
            if (gifList.get(i).getFavorite() == true) {
                favouritesGifs.add(gifList.get(i));
            }
        }
        return favouritesGifs;
    }

    @Override
    public List<Gif> findByName(String name) {
        List<Gif> result = new ArrayList<>();
        for (Gif gif : gifList) {
            if (gif.getName().equals(name)) {
                result.add(gif);
            }
        }
        return result;
    }





}

