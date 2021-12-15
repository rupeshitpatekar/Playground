package general;

import java.util.*;
import java.util.stream.Collectors;

public class DiskSpaceProblem {
    public static void main(String[] args) {
        int checkSum = 1;
        Stack<Integer> stack = new Stack();
        stack.push(0);


    }

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        int chunkNum = 1;
        Stack stack = new Stack();
        stack.push(0);

        for(int i=1; i < space.size(); i++){
            if(i < x){
                if(space.get(i) < Integer.parseInt(stack.peek().toString())){
                    stack.pop();
                    stack.push(i);
                }
            }else
            {

                int peek = Integer.parseInt(stack.peek().toString());
                if (peek >= chunkNum)
                {
                    if(space.get(i) < space.get(Integer.parseInt(stack.peek().toString()))){
                        stack.push(i);
                    }else{
                        stack.push(peek);
                    }

                }

                else
                {
                    stack.push(i);

                    var j = chunkNum;
                    var count = 0;
                    while (count++ < x)
                    {
                        if (space.get(j) < space.get(Integer.parseInt(stack.peek().toString())))
                        {
                            stack.pop();
                            stack.push(j);
                        }
                        j++;
                    }
                }
                // we are ready to go to next chunk
                chunkNum++;
            }
        }
        Integer max = 0;
        Iterator value = stack.iterator();
        while (value.hasNext()) {
            if(max < space.get(Integer.parseInt(value.next().toString()))){
                max = space.get(Integer.parseInt(value.next().toString()));
            }
        }
        return max;
    }
}


