package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SeribalizeDeaesiablize {
    public static void main(String[] args) {

    }


        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("X,");
                return;
            }


            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }


        public TreeNode deserialize(String data) {
            String[] tokens = data.split(",");
            Queue<String> nodesQueue = new LinkedList<>(Arrays.asList(tokens));
            return deserializeHelper(nodesQueue);
        }

        private TreeNode deserializeHelper(Queue<String> nodesQueue) {
            String currentVal = nodesQueue.poll();

            if (currentVal.equals("X")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(currentVal));

            root.left = deserializeHelper(nodesQueue);
            root.right = deserializeHelper(nodesQueue);

            return root;
        }
    }
