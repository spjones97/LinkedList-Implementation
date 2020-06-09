# Overview
You are going to build in Java a general List ADT (LIST) using linked cells to do it. It will also me modifed over the traditional behavior to include an operation that would assist in sorting.

Using linked cells means do not use arrays to contain the elements stored in the List. It also means do not use any of the code from the Java Collections library to get your work done.

The LIST you will implement will be very similar to the ADT shown in your text. It will have an operation to put an element into the list by position, to take an element out by position, and to retrieve an element by position (without altering the data structure). It will have an operation telling how many elements are stored in the list, and a boolean to tell if it is empty or not. It has an operation to make a fresh, empty list. We have left out the operations shown in the text that search for elements by value.

It will also have an operation called "insort" that will insert an element into the list in a way that will support sorting. The specific details of insort behavior is given in the specs below.

The class Node below shows how we do linked cells in Java. A linked cell is an object (class instance) that has one (or more) references to other objects of the same class. So a list cell refers to another list cell (the next one in the linked chain).

Our implementation will be a doubly linked list. As you see in the Node class, there is a next field and a prev field. The next field points to the cell that follows the current cell in the list. The prev field points to the cell that came just before the current one in the list. To go through the list item by item in the "forward" direction you would start with the first cell and use the next field until you get to the end of the list. Since it is doubly linked, you can also traverse the list "backwards" by going to the last cell and following the prev links until you get to the first cell. You will need a pointer as well in your List object that points to "end" just as you have a link that points to "head".

# Notes on Operations and Objects
## size
The size operation simply returns the count of how many elements are in the list. A brand new empty should have its numElts field be 0. Method size will return 0 if the list is empty, and always return a 0 or greater. Note the isEmpty() method is synonymous with size()==0 .
## insert and remove
Note that we wish for you to look out for the edge case of inserting or removing in an index that is not reachable (ie < 0 or > size of list) We ask that you return false in these cases. Also when inserting and removing be careful to connect your nodes to the next (and prev) nodes inside the list. You don't want to get a null pointer when iterating, inserting, and removing. Remember the special case of inserting the very first data node... you will have to alter the headCell field of the list object. You will have a similar special case when removing the last data cell and changing the list from size 1 to size 0.
## insort
The insort operation can be used to sort if is is the only "add" operation used... that is, if you always do insort and never use insert, then the list will always remain in sorted order.

# Testing and Output
For testing, use your own test cases in LinkedListPlayground class. Think in detail about that tests will cover the full range of behavior your list might go through in use, and make sure your code handles those situations correctly. We also encourage using the oracle program for incremental development. Instructions on using the oracle will be in the form of the ppt presented in class (and posted online).

There is no specific output or runnable class required for this assignment. We assume you will use the "print" capability provided that will assist you in seeing how your code is working.

For grading, we will be using a grading program that will instantiate your objects and perform the LIST ADT operations on it. We will then observe if the functionality of the data structure is as we requested. Be sure to test beyond the scope of the Oracle as mentioned in class! The order in which ADT operations are performed and what data is entering your list will be different in the official grading script. There will be behavior that is required (in the interface you are implementing) but that is not tested in the oracle we gave you.
