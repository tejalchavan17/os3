import java.util.*;
import java.io.*;
class Os3 implements Runnable
{ 
     int l,m,i,j,t,a[];
     public Os3(int l,int m,int a[])
     {
         this.l=l;
         this.m=m;
         this.a=a;
     }    
     public  void run()
     {
          /*Prints unsorted array */
          for(i=l;i<=m;i++)
          {
             System.out.print(a[i]+"\t");
          }  
          /*Selection sort to sort the array*/  
          for(i=l;i<=m;i++)
          {
                for(j=i+1;j<=m;j++)
                {
                     if(a[i]>a[j])
                     {
                         t=a[i];
                         a[i]=a[j];
                         a[j]=t;
                      }
                }
           } 
	   /*Prints the sorted array*/
           System.out.print("\nSorted array:"+"\n");
           for(i=l;i<=m;i++)
           {
              System.out.print(a[i]+"\t");
           }             
      }
}
class thread1
{
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       int a[]=new int[100];
       int l,m,high,t,i,n;
       System.out.println("Enter no. of elements:");
       n=sc.nextInt();
       System.out.println("Enter elements:");
       for(i=0;i<n;i++)
       {
             a[i]=sc.nextInt();
       }
       l=0;
       high=n-1;
       m=(l+high)/2;		//calculating mid
       Os3 o=new Os3(l,m,a);	//passing left array i.e from 0 to mid 
       Thread td=new Thread(o);
       Os3 o1=new Os3(m+1,high,a);	//passing Right array i.e from mid+1 to n-1 
       Thread td1=new Thread(o1);
       Os3 o2=new Os3(l,high,a);	//passing two sorted left array and right array
       Thread td2=new Thread(o2);
       System.out.println("Left half:"+"\n");
       td.start();
       try
       {
            td.join();
       }
       catch(Exception ex)
       {
            System.out.println(ex);
       }
       System.out.print("\nRight half:"+"\n");
       td1.start();
       try
       {
            td1.join();
       }
       catch(Exception ex)
       {
            System.out.println(ex);
       }
       System.out.print("\nMerged array:"+"\n");
       td2.start();
       
    }
}    
               
/*Output:             
tejal@ubuntu:~/Desktop$ java thread1.java
tejal@ubuntu:~/Desktop$ java thread1
Enter no. of elements:
9
Enter elements:
6
3
4
5
1
2
8
9
7
Left half:

6	3	4	5	1	
Sorted array:
1	3	4	5	6	
Right half:
2	8	9	7	
Sorted array:
2	7	8	9	
Merged array:
1	3	4	5	6	2	7	8	9	
Sorted array:
1	2	3	4	5	6	7	8	9 */

