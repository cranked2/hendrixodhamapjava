package lightsequence;

public class LightSequence
{
    private String seq;

    public LightSequence (String seq)
    {
        this.seq = seq;
    }

    public String insertSegment(String segment, int ind)
    {
        String first = seq.substring(0,ind);
        String second = seq.substring(ind);

        return first + segment + second;
    }

    public void changeSequence(String seq)
    {
        this.seq = seq;


    }

    public void display()
    {

        System.out.println(seq);

    }
}
