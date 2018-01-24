import java.util.Stack;
public class Homework1 {
	public static Stack st = new Stack();
	static Node tree = null;
	public static void main(String[] args) {

		// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			for (int i = 0; i < input.length(); i++) {
				String v = input.substring(i, i + 1);
				node root = new node(v, null, null);
				infix(root);
			}
			tree = (node) st.pop();
			String out = inorder(tree);
			System.out.println(out.substring(1, out.length() - 1) + "=" + calculate(tree));
		}
		TreeIconDemo2.main(tree);
		// End of arguments input sample

		// TODO: Implement your project here
	}
	public static int calculate(node root) {
		if (root.node.matches("[0-9]")) {
			return Integer.parseInt(root.node);
		}
		int v = 0;
		int rt = calculate(root.rt);
		int lt = calculate(root.lt);
		if (root.node.equals("+")) {v = lt + rt;}
		else if (root.node.equals("-")) {v = lt - rt;}
		else if (root.node.equals("*")) {v = lt * rt;}
		else if (root.node.equals("/")) {v = lt / rt;}
		return v;
	}
	public static void infix(node root) {
		if (root.node.matches("[0-9]")) {st.add(root);}
		else {
			root.rt = (node) st.pop();
			root.lt= (node) st.pop();
			st.add(root);
		}
	}
	public static String inorder(node root) {
		String x = "";
		if (root.lt != null) {x += "(" + inorder(root.lt);}
		x += root.node;
		if (root.rt != null) {x += inorder(root.rt) + ")";}
		return x;
	}
 
}
