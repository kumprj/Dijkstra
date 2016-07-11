Robbie Kump
Dijkstra's and Prim's Algorithms ReadMe
=======

Setup
-------
Utilize the Java compiler of your choice. We utilized Eclipse IDE and confirmed a working program with Java 7 or Java 8.

Making and Preparing the Program
-------
Create your Java project and compile the program. We will read in files using .txt files, in the format as follows:
numnodes as an int
int int double representing node1 node2 weight
int int double
int int double 
etc.

This reads as "The weight from node1 to node2 is weight."
A sample .txt Graph has been supplied for testing purposes. The above information on the style of the input
is present if interested in testing your own Graph.

Running the Program
-------
Run the compiled program. The program reads in a .txt file representing a weighted graph, where nodes are ints and weights are doubles.
It can be supplied as the first (and only) argument, or if args do not exist, it will require user input.
The first line of the .txt file must be the number of nodes, represented by a single integer. 
You must either supply the program 1 argument (a txt file) or no arguments, in which case you will be prompted for the file name.