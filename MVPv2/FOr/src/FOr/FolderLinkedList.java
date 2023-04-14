package FOr;

import java.io.*;
import java.util.*;

public class FolderLinkedList<Folder>
{
    private Node<Folder> head;  // pointer to the front (first) element of the list

    public FolderLinkedList()
    {
            head = null; // compiler does this anyway. just for emphasis
    }

    // LOAD LINKED LIST FROM INCOMING FILE
    @SuppressWarnings("unchecked")
    public FolderLinkedList( Folder[] folders)
    {	head = null;
        for (int i = 0; i < folders.length; i++)
        {
            insertAtTail((Folder)folders[i]);  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
        }
    }

    //-------------------------------------------------------------
    
    public Folder get(int index)
    {
        Node<Folder> curr = head;
        for (int i = 0; i < size(); ++i)
        {
            if (i == index)
                return curr.data;
            else
                curr = curr.next;
        }
        return null;
    }
    
    // inserts new elem at front of list - pushing old elements back one place

    public void insertAtFront(Folder data)
    {
            head = new Node<Folder>(data,head);
    }

    // we use toString as our print

    public String toString()
    {
            String toString = "";

            for (Node<Folder> curr = head; curr != null; curr = curr.next )
            {
                    toString += "/" + curr.data;		// WE ASSUME OUR T TYPE HAS toString() DEFINED
            }       

            return toString;
    }

    // ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################



    public int size() // OF COURSE MORE EFFICIENT to KEEP COUNTER BUT YOU  MUST WRITE LOOP
    {
        int count = 0;
        for (Node<Folder> curr = head; curr != null; curr = curr.next)
            count++;
        return count;
    }

    public boolean empty()
    {
        if (size() == 0)
            return true;
        else
            return false;
    }

    public boolean contains( Folder key )
    {
        if (search(key)!=null)
            return true;
        else
            return false;
    }

    public Node<Folder> search( Folder key )
    {
        for (Node<Folder> curr = head; curr != null; curr = curr.next)
            if (curr.data.equals(key))
                return curr;
        return null;
    }

    // TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
    void insertAtTail(Folder data)
    {
        if (head == null)
            insertAtFront((Folder)data);
        else
        {
            for (Node<Folder> curr = head; curr != null; curr = curr.next)
            {
                if (curr.next == null)
                {
                    curr.next = new Node<Folder>((Folder)data, null);
                    break;
                }
            }
        }
    }

    public boolean remove(Folder key)
    {
        if (empty())
            return false;
        else if (head.data.equals(key))
            removeAtFront();
        else if (search(key) != null)
            for (Node<Folder> curr = head; curr != null; curr = curr.next)
                if (curr.next.data.equals(key))
                {
                    curr.next = curr.next.next;
                    return true;
                }
        return false;  
    }

    public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
    {
        if (empty())
            return false;
        else if (size() == 1)
            removeAtFront();
        else
            for (Node<Folder> curr = head; curr != null; curr = curr.next)
                if (curr.next.next == null)
                {
                    curr.next = curr.next.next;
                    return true;
                }
        return false;
    }

    public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
    {
        if (empty())
            return false;
        else
        {
            head = head.next;
            return true;
        }
    }


} //END LINKEDLIST CLASS

class Node<Folder>
{
    Folder data;
    Node<Folder> next;

    Node()
    {
      this( null, null );
    }

    Node(Folder data)
    {
      this( data, null );
    }

    Node(Folder data, Node<Folder> next)
    {
      this.data = data;
      this.next = next;
    }
    public String toString()
    {
            return ""+data;
    } 
	 
} //EOF