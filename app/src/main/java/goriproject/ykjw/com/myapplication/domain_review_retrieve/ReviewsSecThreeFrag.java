package goriproject.ykjw.com.myapplication.domain_review_retrieve;

import java.io.Serializable;

/**
 * Created by JINWOO on 2017-04-18.
 */

public class ReviewsSecThreeFrag implements Serializable {
    private Results[] results;

    private String previous;

    private String count;

    private String next;

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String getPrevious ()
    {
        return previous;
    }

    public void setPrevious (String previous)
    {
        this.previous = previous;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", previous = "+previous+", count = "+count+", next = "+next+"]";
    }
}
