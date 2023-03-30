// Short program that demonstrates the use of the IntTree class.
public class IntTreeDemo
{
	public static void main(String[] args)
	{
		//construct a tree 
		IntTree t = new IntTree(12);     
		
		//prints the elements in the tree by inorder
		System.out.println("Elements in the tree are: ");     
		t.printSideways(); 
		
		int sumOf = t.depthSum();
		System.out.println("Number of stored values in a tree: "+ (sumOf));   
		t.printPreorder();    
		t.printInorder();     
		t.printPostorder();    }}
