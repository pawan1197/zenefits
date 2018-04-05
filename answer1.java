/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Tree
{
    int value;
    Tree right;
    Tree left;
    Tree(int value)
    {
        this.value=value;
        this.right=null;
        this.left=null;
    }
    static void print(Tree node)
    {
        if(node==null)
        return;
        print(node.left);
        System.out.print(node.value);
         System.out.print(",");
        print(node.right);
    }
    static boolean isInt(char s)
    {
        if(s=='{' || s=='}' || s==',')
           return false;
           else
             return true;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		String str = in.next();
		Tree root=null,temp=null;
		Queue<Tree> pk = new LinkedList<>();
		pk.enqueue(root);
		int len = str.length();
		int i=0;
		while(i<len)
		{
		    if(str.charAt(i)=='{')
		    {
		        if(i+6<len && isInt(str.charAt(i+1)) &&isInt(str.charAt(i+3)) && isInt(str.charAt(i+5)))
		        {
		            temp=pk.dequeue();
		            temp = new Tree(Integer.parseInt(str.substring(i+1,i+2)));
		            temp.left = new Tree(Integer.parseInt(str.substring(i+3,i+4)));
		            temp.right = new Tree(Integer.parseInt(str.substring(i+5,i+6)));
		            i=i+6;
		        } 
		        else{
		            temp = pk.dequeue();
		            temp = new Tree(Integer.parseInt(str.substring(i+1,i+2)));
		            pk.enqueue(temp.left);
		             pk.enqueue(temp.right);
		             i=i+2;

		        }
	       
		    }

		   if(str.charAt(i)=='}'){
		      continue; i++;}
		      if(str.charAt(i)==','){
		      continue;i++;}
		      i++;
		
		}print(root);
	}
}
