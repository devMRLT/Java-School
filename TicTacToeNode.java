public class TicTacToeNode{
	public static void main(String[] args) {
		String board = "x ox xo o";
		TicTacToeTreeNode root = createNode(board, "x");
		printTree(root);
	}
	//construct the children array
	private TicTacToeNode childNodesOfTree[];
	//declare var to store the data
	private String TicData;
	//constructor
	public TicTacToeNode(String TicData){
		this.TicData = TicData;
	}
	//This method was given to use and returns the updated
	public static String makeMove(String old, int pos, String player){
			String before = old.substring(0, pos);
			String after = old.substring(pos+1);
			return before + player + after;
	}
	//finds the empty spaces in the string
	public static int findPositionOfEmpty(){
		int positionarrayCounter;
		for (int looparrayCounterer = 0; looparrayCounterer < board.length(); looparrayCounterer++) {
			if(baord.charAt(looparrayCounterer) == ""){
				positionarrayCounter++;
			}
		}
		return positionarrayCounter;
	}
	//prints the data in the tree
	public static void printTree(String emptySpaces, TicTacToeTreeNode node){
		if(node != null){
			System.out.print(emptySpaces + node.TicData);
			for (int i=0; node.childNodesOfTree.length; i++) printTree(emptySpaces + "\t", node.childNodesOfTree[i]);
		}
	}
	//change the current player
	public static String changePlayer(String player){
		if(player == "x"){
			player = "o";
			return player;
		}else{
			player = "x";
			return player;
		}
	}
	//checks to see what player is active
	public static String checkPlayer(){
			if(player == "x"){
				return "x";
			}else{
				return "o";
			}
	}
	//Creates the nodes to be held in the tree
	public static TicTacToeTreeNode createNode(String board, String player){
		TicTacToeTreeNode root = new TicTacToeTreeNode(board);
		int arrayCounter = findPositionOfEmpty(board);
		boardIndex = 0;
		root.childNodesOfTree = new TicTacToeTreeNode[arrayCounter];
		//check to see what player is currently active
		String currentPlayer = player.checkPlayer()
		for(int j = 0; j != arrayCounter; j++){
			boardIndex = board.indexOf("", boardIndex+1);
			board = makeMove(board, boardIndex, " ");
			root.childNodesOfTree[j] = createNode(board, currentPlayer);
			board = makeMove(board, boardIndex, " ");
		}
		return root;
	}
}