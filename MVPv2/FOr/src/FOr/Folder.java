package FOr;


public class Folder 
{
    private String name, address;


    public Folder() 
    {
        setName("");
    }
    public Folder(String name) 
    {
        setName(name);
    }
    public Folder(String name, FolderLinkedList<Folder> f) 
    {
        setName(name);
    }
    public Folder(String name, String address)
    {
        setName(name);
        setAddress(address);
    }
    
    public String getName(){return name;}
    public String getAddress(){return address;}
    
    public void setName(String n){name = n;}
    public void setAddress(String a){address = a;}
    
    @Override
    public String toString()
    {
        return getName();
    }
}
