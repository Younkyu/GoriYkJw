package goriproject.ykjw.com.myapplication.domain_qna_retrieve;

import java.util.List;

/**
 *  GET 통신으로 사용함
 */

public class QnaDetail {
    private List<Results> results;

    private String previous;

    private String count;

    private String next;

    public List<Results> getResults ()
    {
        return results;
    }

    public void setResults (List<Results> results)
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
