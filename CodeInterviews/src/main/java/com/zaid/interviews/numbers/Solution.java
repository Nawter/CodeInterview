package com.zaid.interviews.numbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Solution 
{
	public static class Movie {
        private final int movieId;
        private final float rating;
        private List<Movie> similarMovies; // Similarity is bidirectional

        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }

        public int getId() {
            return movieId;
        }

        public float getRating() {
            return rating;
        }

        public void addSimilarMovie(Movie movie) {
            similarMovies.add(movie);
            movie.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }
	 /* 
     * @param movie Current movie.
     * @param numTopRatedSimilarMovies the maximum number of recommended movies to return.
     * @return List of top rated similar movies.
     * 
     * Assumptions I made: TODO
     *
     * Description of my approach: TODO
     *
     * Runtime complexity of my approach: TODO
     *
     * Justification of runtime complexity: TODO
     *
     */
    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) 
    {
    	List<Movie> finalList=new ArrayList<Movie>();
    	Iterator<Movie> itMovies=movie.getSimilarMovies().iterator();
    	while(itMovies.hasNext())
    	{
    		Movie otherMovie=(Movie)itMovies.next();
    		if(movie.getRating() < otherMovie.getRating())
    		{
    			finalList.add(otherMovie);
    		}
    		Iterator<Movie> itSubMovies=otherMovie.getSimilarMovies().iterator();
    		while(itSubMovies.hasNext())
        	{
    			Movie otherSubMovie=(Movie)itSubMovies.next();
        		if(movie.getRating() < otherSubMovie.getRating())
        		{
        			finalList.add(otherSubMovie);
        		}
        	}
    	}
    	finalList=new ArrayList<Movie>(new LinkedHashSet<Movie>(finalList));
    	if(finalList.size()>0){
    		Collections.sort(finalList, new Comparator<Movie>(){

				@Override
				public int compare(final Movie arg0, final Movie arg1) {
					// TODO Auto-generated method stub
					 return Float.compare(arg0.getRating(),arg1.getRating());
				}			
    			
    		});
    	}	
    	
    	if(finalList.size()>numTopRatedSimilarMovies)
    	{    		
    		int diff=Math.abs(finalList.size()-numTopRatedSimilarMovies);
    		for(int i=0;i<diff;i++)
    	    {    			
    	    	finalList.remove(0);
    	    }
    	}    	
        return finalList;
    }
	public static void main(String[] args) throws IOException {       
        final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
        Movie rootMovie = null;
        int numTopRatedSimilarMovies = 0;
        String dir = "src/test/resources/file/";
        
        
        final Scanner in = new Scanner(new File(dir+"input003.txt"));        
        in.useLocale(new Locale("en", "US"));
        
        while (in.hasNextLine()) {
            final String type = in.next();
            
            if (type.equals("movie")) {
                final int id = in.nextInt();
                final float rating = in.nextFloat();
                movieMap.put(id, new Movie(id, rating));
            } else if (type.equals("similar")) {
                final Movie movie1 = movieMap.get(in.nextInt());
                final Movie movie2 = movieMap.get(in.nextInt());
                movie1.addSimilarMovie(movie2);
            } else if (type.equals("params")) {
                rootMovie = movieMap.get(in.nextInt());
                numTopRatedSimilarMovies = in.nextInt();
            } else {
                // ignore comments and whitespace
            }
        }
        
        final List<Movie> result = getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);
        
        
        String output = "result";
        
        if (result == null) {
            output += " <null>";
        } else {
            Collections.sort(result, new Comparator() {
                @Override
                public int compare(Object m1, Object m2) {
                    return ((Movie)m1).getId() - ((Movie)m2).getId();
                }
            });
            
            for (Movie m: result) {
                output += " ";
                output += m.getId();
            }            
        }
       
        File fileName = new File(dir+"output001.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(output);
        bw.newLine();
        bw.close();
    }
}

