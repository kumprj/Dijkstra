Robbie Kump - Alex Stahl 
Graph Algorithms ReadMe
=======

Setup
-------
Utilize the Java compiler of your choice. We recommend using the Eclipse IDE for compilation and testing. It is located here:
http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars2 . Java 7 or Java 8 is the recommended
version.

Making and Preparing the Program
-------
(Eclipse)
Once you have Eclipse set up, unzip the folder. Navigate over to Eclipse, and create a new Project. Title this Project
anything you'd like. Then, copy and paste the .java files into the src folder of the new project. The code is now
prepared. We will read in files using .txt files, in the format as follows:
numnodes as an integer
int int double representing node1 node2 weight
int int double
int int double 
etc.

This basically reads "The weight from node1 to node2 is weight."
A sample .txt Graph has been supplied for testing purposes. The above information is present if interested
in testing your own Graph.

(Non Eclipse)
Aggregate the .java files into your project, as well as the given .txt file. Create your own .txt Graph
or test with ours. Be sure to utilize the format outlined as follows: 
numnodes as an integer
int int double as node1 node2 weight
int int double
int int double 

The program reads in a .txt file representing a weighted graph, where nodes are ints and weights are doubles.
It can supplied as the first (and only) argument, or if args do not exist, it will require user input.
The first line of the .txt file must be the number of nodes, represented by a single integer.
After that, each line should contain int int double, representing node node weight. A sample
have been provided in the .zip. 

Running the Program
-------
Run the Tester class. You will be prompted to enter your file name. After the file name is entered,
you will be prompted with several options. Follow the instructions on the screen to learn about the Graph,
such as whether paths exist, or the weight and route of a path from one node to another. Enter 4 to exit.