package FOr;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip 
{
    private String name;
    private FolderLinkedList<Folder> folders;
    private File directory;
    private ArrayList<ZipEntry> entries = new ArrayList<>();
    private ZipOutputStream out;

    public Zip() throws FileNotFoundException 
    {
        setName("");
        setFolders(new FolderLinkedList<>());
        setDirectory(new File("C:\\Users\\" + System.getProperty("user.name") + "\\OneDrive\\" + getName() + ".zip"));
        setOutStream(new ZipOutputStream(new FileOutputStream(directory)));
    }
    public Zip(String name, File d) throws FileNotFoundException 
    {
        setName(name);
        setFolders(null);
        setDirectory(d);
        setOutStream(new ZipOutputStream(new FileOutputStream(directory)));
    }
    public Zip(String name, FolderLinkedList<Folder> f) throws FileNotFoundException 
    {
        setName(name);
        setFolders(f);
        setDirectory(new File("C:\\Users\\" + System.getProperty("user.name") + "\\OneDrive\\" + getName() + ".zip"));
        setOutStream(new ZipOutputStream(new FileOutputStream(directory)));
    }
    public Zip(String name, FolderLinkedList<Folder> f, File d) throws FileNotFoundException 
    {
        setName(name);
        setFolders(f);
        setDirectory(d);
        setOutStream(new ZipOutputStream(new FileOutputStream(d)));
    }
    
    public String getName(){return name;}
    public FolderLinkedList<Folder> getFolders(){return folders;}
    
    public void setName(String n){name = n;}
    public void setFolders(FolderLinkedList<Folder> f){folders = f;}
    public void setDirectory(File d){directory = d;}
    public void setOutStream(ZipOutputStream z){out = z;}
    public void addFolder(Folder f){folders.insertAtTail(f);
                                    entries.add(new ZipEntry(f.getName() + "/"));}
    public void removeFolder(Folder f){folders.remove(f);}
    
    public void addToAFolder(Folder newf, String address)
    {
        entries.add(new ZipEntry(address + "/" + newf.getName() + "/"));
    }
    
    public boolean exists()
    {
        return directory.exists();
    }
    
    public void close() throws IOException
    {
        out.closeEntry();
        out.close();
    }
    
    public void createZip() throws IOException
    {
        for (int i = 0; i < entries.size(); i++)
            out.putNextEntry(entries.get(i));
        out.closeEntry();
        out.close();
    }
}
